package fr.supelec.tesl.lang.ui.run;

import com.google.inject.Inject
import fr.supelec.tesl.core.RoundDouble
import fr.supelec.tesl.core.TESLEngine
import fr.supelec.tesl.lang.tesl.Clock
import fr.supelec.tesl.lang.tesl.Let
import fr.supelec.tesl.lang.tesl.Pragma
import fr.supelec.tesl.lang.tesl.Relation
import fr.supelec.tesl.lang.tesl.Type
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.io.UnsupportedEncodingException
import java.util.HashSet
import java.util.Map
import org.eclipse.core.resources.IResource
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.debug.core.ILaunch
import org.eclipse.debug.core.ILaunchConfiguration
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.resource.XtextResourceSet
import fr.supelec.tesl.lang.tesl.DoubleCalcPragma

// For static initialization of the output format handler map
class OutputFormatRegistrar {
    new (Map<String, OutputFormatHandler> toRegister) {
        for (pair : toRegister.entrySet()) {
            OutputFormat::register(pair.key, pair.value)
        }
    }
}

class LaunchTESLSimulation implements ILaunchConfigurationDelegate {
    private static var TESLSpec spec = null
    static extension LetExtensions letExt = null
    static extension ClockExtensions clockExt = null
    static extension RelationExtensions relExt = null
    static extension PragmaExtensions pragExt = null
    // Side effect = register output handlers for formats
    static OutputFormatRegistrar registrar = new OutputFormatRegistrar(#{
        "vcd"->new VCDWriter(),
        "tikz"->new LaTeXTikZWriter(),
        "svg"->new SVGWriter()
    })

    val static majorversion = 1
    val static minorversion = 1
    val static releaseversion = 7
    val static version = Integer.toString(majorversion)
            + "." + Integer.toString(minorversion)
            + "." + Integer.toString(releaseversion)

    def static getVersion() {
        return version
    }


    @Inject
    XtextResourceSet resourceSet;

    override void launch(ILaunchConfiguration configuration, String mode,
            ILaunch launch, IProgressMonitor monitor) throws CoreException {
        val fileName = configuration.getAttribute(MainTab.ATTR_FILE, null as String);
        val maxSteps = configuration.getAttribute(MainTab.ATTR_MAXSTEPS, MainTab.DEFAULT_MAXSTEPS);

        System.out.println("resourceSet = " + resourceSet);

        runTESL(resourceSet, fileName, maxSteps);
    }

    def static void runTESL(XtextResourceSet resourceSet, String fileName, int maxSteps) {
        spec = new TESLSpec(resourceSet, fileName, maxSteps)
        letExt = new LetExtensions(spec)
        clockExt = new ClockExtensions(spec)
        relExt = new RelationExtensions(spec)
        pragExt = new PragmaExtensions(spec)

        var hasFloatClock = false

        try {
            // Reset default for Double calculus before processing pragmas
            // @doublecalc pragma may change the number of digits and rounding mode
            RoundDouble.resetDefaults

            // Process @doublecalc pragma early so that float expressions are evaluated correctly
            for(Pragma pragma : spec.getPragmaDecls()) {
                if (pragma instanceof DoubleCalcPragma) {
                    pragma.process()
                }
            }

            for(Let letdef : spec.getLetDecls()) {
                letdef.process();
            }

            for(Clock c : spec.getClockDecls()) {
                c.process()
                if (c.type == Type.TFLOAT) {
                    hasFloatClock = true
                }
            }

            System.out.println("****** Clocks ********");
            System.out.println(spec.clocks);
            System.out.println("*********************");

            for(Relation r : spec.getRelDecls()) {
                r.process()
            }

            for(Pragma pragma : spec.getPragmaDecls()) {
                pragma.process()
            }

            System.out.println("******** ClockSet **********")
            System.out.println(spec.clockSet)

            System.out.println("******************")

            spec.log("## File: " + spec.osfile)
            spec.log("## TESL version: " + TESLEngine.getVersion())
            spec.log("## TESL lang version: " + getVersion())
            spec.log("##-----------------------------------------")

            // print out a summary of the simulation parameters
            spec.console(spec.out, "Stop clock: " + spec.stopClock)
            spec.console(spec.out, "Tagref clock: " + spec.tagRefClock)
            spec.console(spec.out, "Max. steps: " + spec.maxSimSteps)
            if (hasFloatClock) {
                spec.console(spec.out, "Number of digits for double calculus: " + RoundDouble.numDigits)
                spec.console(spec.out, "Rounding mode for double calculus: " + RoundDouble.roundingMode)
            }

            try {
                var boolean goOn
                var step = 1
                do {
                    spec.console(spec.header, "##### Solve [" + step + "] #####");

                    spec.clockSet.solve();

                    val stopClockHasTicked = (spec.stopClock != null)
                                          && (spec.stopClock.getNowTick() != null);

                    // remove all now ticks after memorizing them
                    // also, stop if there is no more ticks on any clock
                    goOn = false;
                    val tickSet = new HashSet<String>();
                    spec.addTicks(tickSet);
                    for (c : spec.clockSet.getClocks()) {
                        val nowTick = c.getNowTick();
                        if (nowTick != null) {
                            tickSet.add(c.getName());
                        }
                    }
                    spec.clockSet.removeNowTicks();
                    goOn = spec.clockSet.hasFuture();

                    if (stopClockHasTicked) {
                        goOn = false;
                    }

                    if(goOn && step >= spec.maxSimSteps) {
                        spec.console(spec.err, "");
                        spec.console(spec.err, "Stopping simulation at step " + step + " as requested.");
                        goOn = false;
                    }

                    // set a tag for the current step
                    // if there is a "tagref" clock then use its tag, otherwise, use step number
                    val tag = try {
                        (spec.tagRefClock.getCurrentTag().getValue() as Number).doubleValue()
                    } catch(Exception e) {
                        step - 1
                    }
                    spec.addTag(tag);

                    step = step + 1
                } while (goOn);
                spec.console(spec.header, "### End of simulation ###");
            } catch (Throwable e) {
                // .solve() may raise runtime exceptions.
                // We catch them here, so as to stop simulation ASAP and display the error message
                // in the console
                spec.console(spec.err, "");
                spec.console(spec.err, "### Simulation aborted:");
                val msg = e.message
                spec.console(spec.err, "###   Check for errors in TESL source file or use \"@trace info\" to debug your specification");
                if (msg != null) {
                    spec.console(spec.err, e.getMessage())
                }
                e.printStackTrace();
            }

            if (spec.dumpResult) {
                spec.console(spec.out, "## Simulation result:")
                for (i : 0..< spec.ticks.size) {
                    spec.console(spec.out, "# Tag = " + spec.tags.get(i))
                    for (clk : spec.ticks.get(i)) {
                        spec.console(spec.out, "  " + clk)
                    }
                }
                spec.console(spec.out, "## End")
            }

            spec.closeLog();

            if (spec.outputFormats.size == 0) {
                spec.consoleOnly(spec.out, "# No output format requested")
            }
            for (fmtName : spec.getOutputFormats()) {
                val fmt = spec.outputFormat(fmtName)
                val handler = OutputFormat::getHandler(fmt.name)
                if (handler == null) {
                    spec.consoleOnly(spec.err, "# Error: no handler found for output format \"" + fmt.name + "\"")
                } else {
                    handler.write(spec, fmt)
                }
            }

            // need to refresh the folder containing the new file
            spec.infile.getParent().refreshLocal(IResource.DEPTH_INFINITE, null);
        } catch(Exception e) {
            System.out.println("Exception!!!!");
            e.printStackTrace(System.out);
            if(spec.err != null) {
                spec.consoleOnly(spec.err, "An exception was encountered. This is a bug, please report it. Details follow:");
                val buffer = new ByteArrayOutputStream();
                e.printStackTrace(new PrintStream(buffer));
                try {
                    spec.consoleOnly(spec.err, buffer.toString("utf-8"));
                } catch (UnsupportedEncodingException e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            // Finally unload the resource so that the file is parsed again next time
            spec.unload()
        }
    }


    // Test only
    private static def void printTree(EObject o, int level) {
        for (i : 0 ..< level) {
            System.out.print("  ")
        }
        System.out.println(o.getClass().getSimpleName());
        for (EObject oo : o.eContents()) {
            printTree(oo, level + 1);
        }
    }

}


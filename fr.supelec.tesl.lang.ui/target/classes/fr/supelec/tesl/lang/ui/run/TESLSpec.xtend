package fr.supelec.tesl.lang.ui.run

import fr.supelec.tesl.core.Clock
import fr.supelec.tesl.core.ClockSet
import fr.supelec.tesl.lang.tesl.Expression
import fr.supelec.tesl.lang.tesl.Specification
import fr.supelec.tesl.logging.Handler
import fr.supelec.tesl.logging.Logger
import java.io.File
import java.io.IOException
import java.io.PrintStream
import java.util.ArrayList
import java.util.HashMap
import java.util.LinkedList
import java.util.Set
import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IMarker
import org.eclipse.core.resources.IResource
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.core.runtime.CoreException
import org.eclipse.core.runtime.Path
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.swt.SWT
import org.eclipse.swt.graphics.Color
import org.eclipse.swt.widgets.Display
import org.eclipse.ui.PartInitException
import org.eclipse.ui.PlatformUI
import org.eclipse.ui.console.ConsolePlugin
import org.eclipse.ui.console.IConsoleConstants
import org.eclipse.ui.console.IConsoleView
import org.eclipse.ui.console.MessageConsole
import org.eclipse.ui.console.MessageConsoleStream
import org.eclipse.xtext.nodemodel.util.NodeModelUtils
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.emf.ecore.resource.Resource

class ConsoleLogHandler extends Handler {
    val TESLSpec spec
    new(TESLSpec spec) {
        this.spec = spec
    }
    override outputMessage(String msg) {
        spec.console(spec.out, msg)
    }
}

//* A class for holding all the necessary information for the simulation of a TESL specification
class TESLSpec {
    val XtextResourceSet resourceSet
    val String fileName
    val URI uri
    val String osfile
    val String baseName
    val Resource resource
    val Specification specification
    val letValues = new HashMap<String, Expression>()
    val clockSet = new ClockSet()
    val clocks = new HashMap<String, Clock<? extends Comparable<?>>>()
    val orderedClockNames = new LinkedList<String>()
    val outputFormats = new HashMap<String, OutputFormat>()
    val ticks = new ArrayList<Set<String>>();
    val tags = new ArrayList<Double>();
    var Logger clockLogger = clockSet.logger
    var MessageConsoleStream out
    var MessageConsoleStream err
    var MessageConsoleStream header
    val CONSOLE_NAME = "TESL Console"
    var PrintStream logStream
    
    @Property IFile infile
    @Property File logFile
    @Property int maxSimSteps
    @Property MessageConsole console
    @Property Clock<? extends Comparable<?>> tagRefClock = null
    @Property Clock<? extends Comparable<?>> stopClock = null
    @Property boolean dumpResult = false
        
    new(XtextResourceSet resourceSet, String fileName, int maxSteps) {
        this.resourceSet = resourceSet
        this.fileName = fileName
        this.maxSimSteps = maxSteps
        this.uri = URI.createURI(fileName)
        this.infile = ResourcesPlugin.workspace.root.getFile(new Path(fileName))
        this.resource = resourceSet.getResource(uri, true)
        this.specification = resource?.contents.get(0) as Specification
        osfile = infile.rawLocation.toOSString()
        baseName = if (osfile.endsWith(".tesl")) {
            osfile.substring(0, osfile.length() - 5)
        } else {
            new String(osfile)
        }
// No longer (2014-06-03)       // Always output VCD
//        outputFormats.put("vcd", new OutputFormat("vcd"))
        logFile = new File(baseName + ".tlog")
        infile.deleteMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE)
        setupConsole()
        setupLogger()
    }
    
    def unload() {
        if (this.resource != null) {
            this.resource.unload();
        } else {
            consoleOnly(err, "Could not unload resource, changes may not be taken into account.")
        }
    }
    def getBaseName() {
        baseName
    }
    def outputFormat(String name) {
        if (outputFormats.containsKey(name)) {
            outputFormats.get(name)
        } else {
            val fmt = new OutputFormat(name)
            outputFormats.put(name, fmt)
            return fmt
        }
    }
    def getOutputFormats() {
        outputFormats.keySet()
    }
    def getLetDecls() {
        specification.getLet()
    }
    def getClockDecls() {
        specification.getDecl()
    }
    def getRelDecls() {
        specification.getRel()
    }
    def getPragmaDecls() {
        specification.getPragmas()
    }
    def getOsfile() {
        osfile
    }
    def getLetValueNames() {
        this.letValues.keySet
    }
    def getLetValue(String name) {
        letValues.get(name)
    }
    def setLetValue(String name, Expression e) {
        letValues.put(name, e)
    }
    def addClock(String name, Clock<? extends Comparable<?>> clock) {
        clockSet.addClock(clock);
        clocks.put(name, clock);
        orderedClockNames.add(name);
    }
    def getClocks() {
        this.clocks
    }
    def getOrderedClockNames() {
        this.orderedClockNames
    }
    def getClockSet() {
        this.clockSet
    }
    def getClock(String name) {
        clocks.get(name)
    }
    def addTicks(Set<String> tickSet) {
        this.ticks.add(tickSet)
    }
    def getTicks() {
        this.ticks
    }
    def addTag(double t) {
        this.tags.add(t)
    }
    def getTags() {
        this.tags
    }
    def setupLogger() {
        // disable any previous clock logger
        for(Handler h : clockLogger.getHandlers()) {
            clockLogger.removeHandler(h);
        }
        logStream = new PrintStream(logFile);
        // add a clock logger to this console
        val logHandler = new ConsoleLogHandler(this)
        logger.addHandler(logHandler);
    }
    def log(String msg) {
        logStream.println(msg)
    }
    def closeLog() {
        this.logStream.close()
        this.logStream = null
    }
    def getLogger() {
        return clockLogger
    }
    def setupConsole() {
        console = findConsole()
        console.clearConsole()
        out = console.newMessageStream()
        err = console.newMessageStream()
        header = console.newMessageStream()
        val wb = PlatformUI.getWorkbench();
        val display = wb.getDisplay();

        // Need to set colors in a NON-UI thread
        display.syncExec([|
            err.setColor(new Color(display, 220, 0, 0));
            header.setColor(new Color(display, 40, 0, 200));
            header.setFontStyle(SWT.BOLD);
        ])
    }
    def getOut() {
        this.out
    }
    def getErr() {
        this.err
    }
    def getHeader() {
        this.header
    }
    private  def findConsole() {
        val name = CONSOLE_NAME;
        val plugin = ConsolePlugin.getDefault();
        val conMan = plugin.getConsoleManager();
        for (iconsole : conMan.getConsoles()) {
            if (name == iconsole.name) {
                return iconsole as MessageConsole
            }
        }

        // no console found, so create a new one
        val myConsole = new MessageConsole(name, null);
        conMan.addConsoles(#[ myConsole ]);

        Display::getDefault().syncExec([|
            val win = PlatformUI::getWorkbench().getActiveWorkbenchWindow();
            val page = win.getActivePage();
            if (page != null) {
                val id = IConsoleConstants::ID_CONSOLE_VIEW;
                try {
                    val view = page.showView(id) as IConsoleView;
                    view.display(myConsole);
                } catch (PartInitException e) {
                    e.printStackTrace();
                }
            }
        ])
        return myConsole;
    }

    def consoleOnly(MessageConsoleStream s, String msg) {
        val oldLog = logStream
        logStream = null  // do not write this to the log file
        console(s, msg)
        logStream = oldLog
    }
    
    def void console(MessageConsoleStream s, String msg) {
        s.println(msg);
        try {
            s.flush();
        } catch (IOException e) {
            // Nothing to do
        }
        if (logStream != null) {
            logStream.println(msg);
        }
    }

    def void reportError(int line, String msg) throws CoreException {
        val m = infile.createMarker(IMarker.PROBLEM);
        m.setAttribute(IMarker.LINE_NUMBER, line);
        m.setAttribute(IMarker.MESSAGE, msg);
        m.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_HIGH);
        m.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
    }

    def void reportError(EObject faultyASTNode, String msg) throws CoreException {
        reportError(NodeModelUtils.getNode(faultyASTNode).getStartLine(), msg);
    }

}


package fr.supelec.tesl.lang.ui.run

import fr.supelec.tesl.core.RoundDouble
import fr.supelec.tesl.lang.tesl.Clock
import fr.supelec.tesl.lang.tesl.ClockItem
import fr.supelec.tesl.lang.tesl.DecimalValue
import fr.supelec.tesl.lang.tesl.DoubleCalcPragma
import fr.supelec.tesl.lang.tesl.DumpResultPragma
import fr.supelec.tesl.lang.tesl.FloatValue
import fr.supelec.tesl.lang.tesl.IntegerValue
import fr.supelec.tesl.lang.tesl.MaxstepPragma
import fr.supelec.tesl.lang.tesl.OutputPragma
import fr.supelec.tesl.lang.tesl.Pragma
import fr.supelec.tesl.lang.tesl.RationalValue
import fr.supelec.tesl.lang.tesl.StopPragma
import fr.supelec.tesl.lang.tesl.TagrefPragma
import fr.supelec.tesl.lang.tesl.TracePragma
import java.math.BigDecimal
import java.util.ArrayList
import java.util.Collections

//* Extension methods for tesl.lang.Pragma
class PragmaExtensions extends ExtensionWithExpressions {
    new(TESLSpec spec) {
        super(spec)
    }

    def dispatch process(TagrefPragma trp) {
        spec.tagRefClock = spec.getClock(trp.getClock().getName());
    }
    def dispatch process(MaxstepPragma msp) {
        spec.maxSimSteps = msp.getValue().evaluate().intValue(msp, "@maxsteps value")
    }
    def dispatch process(StopPragma sp) {
        spec.stopClock = spec.getClock(sp.getClock().getName());
    }
    def dispatch process(TracePragma tp) {
        for (String kind : tp.getKinds()) {
            // Special kinds begin '_'
            //  _all_ log all info
            //  _help_ show available info
            //  _lets_ dump let definitions
            if ("_all_".equalsIgnoreCase(kind)) {
                spec.logger.setLoggingAllKinds(true);
            } else if ("_help_".equalsIgnoreCase(kind)) {
                spec.consoleOnly(spec.out, "@trace _help_");
                spec.consoleOnly(spec.out, "  - @trace _help_ : show this help message");
                spec.consoleOnly(spec.out, "  - @trace _lets_ : dump the value of let definitions");
                spec.consoleOnly(spec.out, "  - @trace _all_  : display all trace messages from the TESL solver");
                spec.consoleOnly(spec.out,
                    "  - @trace kind (, kind)*  : display trace messages of these kinds from the TESL solver");
                spec.consoleOnly(spec.out, "    available information kinds:");
                for (String info : spec.logger.getInformationKinds()) {
                    spec.consoleOnly(spec.out, "    * " + info);
                }
            } else if ("_lets_".equalsIgnoreCase(kind)) {
                spec.consoleOnly(spec.out, "@trace _lets_");
                val lets = new ArrayList<String>(spec.letValueNames);
                Collections.sort(lets);
                for (String name : lets) {
                    val value = spec.getLetValue(name);
                    val builder = new StringBuilder("  let ");
                    if (value instanceof IntegerValue) {
                        builder.append("int ");
                        builder.append(name);
                        builder.append(" = ");
                        builder.append(value.getValue());
                    } else if (value instanceof DecimalValue) {
                        builder.append("decimal ");
                        builder.append(name);
                        builder.append(" = ");
                        builder.append(value.getValue());
                    } else if (value instanceof FloatValue) {
                        builder.append("float ");
                        builder.append(name);
                        builder.append(" = ");
                        builder.append(value.getValue());
                    } else if (value instanceof RationalValue) {
                        builder.append("rational ");
                        builder.append(name);
                        builder.append(" = ");
                        builder.append(value.getValue());
                    } else {
                        builder.append("<unknown type ");
                        builder.append(value.getClass().getName());
                        builder.append(" > ");
                        builder.append(name);
                        builder.append(" = <unknown value>");
                    }
                    spec.consoleOnly(spec.out, builder.toString());
                }
            } else {
                try {
                    spec.logger.setLoggingKind(kind, true);
                } catch (Throwable t) {
                    spec.consoleOnly(spec.err, t.getMessage());
                    spec.reportError(tp, t.getMessage());
                }
            }
        }
    }
    def dispatch process(OutputPragma op) {
        val fmt = spec.outputFormat(op.getType())

        // "select"
        if (op.isSelection() && op.getSelectedClocks() != null) {
            for (ClockItem c : op.getSelectedClocks()) {
                fmt.addToSelection(c.clock.name)
                if (c.getNewName() != null) {
                    fmt.renameClock(c.getClock().getName(), c.getNewName())
                }
            }
        }

        // "from" ... "to"
        if (op.isWindow()) {
            val real_from = op.getFrom().evaluate();
            val from = real_from.doubleValue(op, "'from' value in window");
            val real_to = op.getTo().evaluate();
            val to = real_to.doubleValue(op, "'to' value in window");
            fmt.setTickWindow(from, to)
        }

        // "label if"
        if (op.getLabelif() != null && op.getLabelif().size() > 0) {
            for (Clock c : op.getLabelif()) {
                fmt.addLabelIf(c.getName());
            }
        }
        
        // "xscale"
        if (op.xscaled) {
            fmt.xscale = op.xscale.evaluate.doubleValue(op, "for xscale value")
        }
        
        // border="<string>"
        if (op.border != null) {
            fmt.borders = op.border
        }
        
        // css style sheet
        if (op.css != null) {
            fmt.css = op.css
        }
        
        // no default css in svg
        if (op.nodefcss) {
            fmt.nodefcss = true
        }
        
        // javascript file
        if (op.jvs != null) {
            fmt.jvs = op.jvs
        }
        
        // generate standalone document
        if (op.standalone) {
            fmt.standalone = true
            if (op.overwrite) {
                fmt.overwrite = true
            }
        }
    }
    
    def dispatch process(DoubleCalcPragma dcp) {
        val digits = dcp.num_digits.intValue
        val mode = dcp.rounding_mode
        RoundDouble.setNumDigits(digits)
        if (dcp.round) {
            val rounding_mode =
                switch (mode) {
                    case ROUND_CEILING:
                        BigDecimal.ROUND_CEILING
                    case ROUND_DOWN:
                        BigDecimal.ROUND_DOWN
                    case ROUND_FLOOR:
                        BigDecimal.ROUND_FLOOR
                    case ROUND_HALF_DOWN:
                        BigDecimal.ROUND_HALF_DOWN
                    case ROUND_HALF_EVEN:
                        BigDecimal.ROUND_HALF_EVEN
                    case ROUND_HALF_UP:
                        BigDecimal.ROUND_HALF_UP
                    case ROUND_UP:
                        BigDecimal.ROUND_UP
                    default: {
                        spec.reportError(dcp, "Unsupported value for rounding mode: " + mode)
                        BigDecimal.ROUND_HALF_DOWN
                    }
                }
            RoundDouble.setRoundingMode(rounding_mode)
        }
    }
    
    def dispatch process(DumpResultPragma drp) {
        spec.dumpResult = true
    }
    
    // Fall back
    def dispatch process(Pragma pragma) {
        spec.reportError(pragma, "Unsupported pragma: " + pragma)
        spec.consoleOnly(spec.out, "Supported pragmas:")
        spec.consoleOnly(spec.out, "  @dumpres  : dump simulation result when finished")
        spec.consoleOnly(spec.out, "  @stop when <clock name>  : stop simulation when the clock ticks")
        spec.consoleOnly(spec.out, "  @tagref <clock name>  : use clock tags as time line reference")
        spec.consoleOnly(spec.out, "  @trace <kind>+  : (try @trace _help_ for details)")
        spec.consoleOnly(spec.out, "  @maxstep <expression>  : stop simulation after a given number of steps")
        spec.consoleOnly(spec.out, "  @doublecalc digits=<int> [(<rounding_mode>)]?")
        spec.consoleOnly(spec.out, "    set the number of digits use for computing with doubles, and optionally")
        spec.consoleOnly(spec.out, "    set the rounding mode among: round_up, round_down, round_ceil, round_floor,")
        spec.consoleOnly(spec.out, "                                 round_half_up, round_half_down and round_half_even")
        spec.consoleOnly(spec.out, "  @output <format> [select <clock>+]? [from <expr> to <expr>]? [label if <clock>+]? [xscale <expr>]?")
        spec.consoleOnly(spec.out, "    request output in <format> (vcd or tikz), selecting only some clocks")
        spec.consoleOnly(spec.out, "    displaying only tick from some date to another.")
        spec.consoleOnly(spec.out, "    With the tikz format, put a label on a tick if some clocks tick and choose the x scale for tags.")
    }
}

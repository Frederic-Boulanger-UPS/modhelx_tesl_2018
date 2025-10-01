package fr.supelec.tesl.lang.ui.run;

import com.google.common.base.Objects;
import fr.supelec.tesl.core.RoundDouble;
import fr.supelec.tesl.lang.tesl.Clock;
import fr.supelec.tesl.lang.tesl.ClockItem;
import fr.supelec.tesl.lang.tesl.DecimalValue;
import fr.supelec.tesl.lang.tesl.DoubleCalcPragma;
import fr.supelec.tesl.lang.tesl.DumpResultPragma;
import fr.supelec.tesl.lang.tesl.Expression;
import fr.supelec.tesl.lang.tesl.FloatValue;
import fr.supelec.tesl.lang.tesl.IntegerValue;
import fr.supelec.tesl.lang.tesl.MaxstepPragma;
import fr.supelec.tesl.lang.tesl.OutputPragma;
import fr.supelec.tesl.lang.tesl.Pragma;
import fr.supelec.tesl.lang.tesl.ROUNDING_MODE;
import fr.supelec.tesl.lang.tesl.RationalValue;
import fr.supelec.tesl.lang.tesl.StopPragma;
import fr.supelec.tesl.lang.tesl.TagrefPragma;
import fr.supelec.tesl.lang.tesl.TracePragma;
import fr.supelec.tesl.lang.tesl.Value;
import fr.supelec.tesl.lang.ui.run.ExtensionWithExpressions;
import fr.supelec.tesl.lang.ui.run.OutputFormat;
import fr.supelec.tesl.lang.ui.run.TESLSpec;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class PragmaExtensions extends ExtensionWithExpressions {
  public PragmaExtensions(final TESLSpec spec) {
    super(spec);
  }
  
  protected PrintStream _process(final TagrefPragma trp) {
    TESLSpec _spec = this.getSpec();
    _spec.setTagRefClock(this.getSpec().getClock(trp.getClock().getName()));
    return null;
  }
  
  protected PrintStream _process(final MaxstepPragma msp) {
    try {
      TESLSpec _spec = this.getSpec();
      _spec.setMaxSimSteps(this.exprExt.intValue(this.exprExt.evaluate(msp.getValue()), msp, "@maxsteps value"));
      return null;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected PrintStream _process(final StopPragma sp) {
    TESLSpec _spec = this.getSpec();
    _spec.setStopClock(this.getSpec().getClock(sp.getClock().getName()));
    return null;
  }
  
  protected PrintStream _process(final TracePragma tp) {
    try {
      EList<String> _kinds = tp.getKinds();
      for (final String kind : _kinds) {
        boolean _equalsIgnoreCase = "_all_".equalsIgnoreCase(kind);
        if (_equalsIgnoreCase) {
          this.getSpec().getLogger().setLoggingAllKinds(true);
        } else {
          boolean _equalsIgnoreCase_1 = "_help_".equalsIgnoreCase(kind);
          if (_equalsIgnoreCase_1) {
            this.getSpec().consoleOnly(this.getSpec().getOut(), "@trace _help_");
            this.getSpec().consoleOnly(this.getSpec().getOut(), "  - @trace _help_ : show this help message");
            this.getSpec().consoleOnly(this.getSpec().getOut(), "  - @trace _lets_ : dump the value of let definitions");
            this.getSpec().consoleOnly(this.getSpec().getOut(), "  - @trace _all_  : display all trace messages from the TESL solver");
            this.getSpec().consoleOnly(this.getSpec().getOut(), 
              "  - @trace kind (, kind)*  : display trace messages of these kinds from the TESL solver");
            this.getSpec().consoleOnly(this.getSpec().getOut(), "    available information kinds:");
            Collection<String> _informationKinds = this.getSpec().getLogger().getInformationKinds();
            for (final String info : _informationKinds) {
              this.getSpec().consoleOnly(this.getSpec().getOut(), ("    * " + info));
            }
          } else {
            boolean _equalsIgnoreCase_2 = "_lets_".equalsIgnoreCase(kind);
            if (_equalsIgnoreCase_2) {
              this.getSpec().consoleOnly(this.getSpec().getOut(), "@trace _lets_");
              Set<String> _letValueNames = this.getSpec().getLetValueNames();
              final ArrayList<String> lets = new ArrayList<String>(_letValueNames);
              Collections.<String>sort(lets);
              for (final String name : lets) {
                {
                  final Expression value = this.getSpec().getLetValue(name);
                  final StringBuilder builder = new StringBuilder("  let ");
                  if ((value instanceof IntegerValue)) {
                    builder.append("int ");
                    builder.append(name);
                    builder.append(" = ");
                    builder.append(((IntegerValue)value).getValue());
                  } else {
                    if ((value instanceof DecimalValue)) {
                      builder.append("decimal ");
                      builder.append(name);
                      builder.append(" = ");
                      builder.append(((DecimalValue)value).getValue());
                    } else {
                      if ((value instanceof FloatValue)) {
                        builder.append("float ");
                        builder.append(name);
                        builder.append(" = ");
                        builder.append(((FloatValue)value).getValue());
                      } else {
                        if ((value instanceof RationalValue)) {
                          builder.append("rational ");
                          builder.append(name);
                          builder.append(" = ");
                          builder.append(((RationalValue)value).getValue());
                        } else {
                          builder.append("<unknown type ");
                          builder.append(value.getClass().getName());
                          builder.append(" > ");
                          builder.append(name);
                          builder.append(" = <unknown value>");
                        }
                      }
                    }
                  }
                  this.getSpec().consoleOnly(this.getSpec().getOut(), builder.toString());
                }
              }
            } else {
              try {
                this.getSpec().getLogger().setLoggingKind(kind, true);
              } catch (final Throwable _t) {
                if (_t instanceof Throwable) {
                  final Throwable t = (Throwable)_t;
                  this.getSpec().consoleOnly(this.getSpec().getErr(), t.getMessage());
                  this.getSpec().reportError(tp, t.getMessage());
                } else {
                  throw Exceptions.sneakyThrow(_t);
                }
              }
            }
          }
        }
      }
      return null;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected PrintStream _process(final OutputPragma op) {
    try {
      final OutputFormat fmt = this.getSpec().outputFormat(op.getType());
      if ((op.isSelection() && (!Objects.equal(op.getSelectedClocks(), null)))) {
        EList<ClockItem> _selectedClocks = op.getSelectedClocks();
        for (final ClockItem c : _selectedClocks) {
          {
            fmt.addToSelection(c.getClock().getName());
            String _newName = c.getNewName();
            boolean _notEquals = (!Objects.equal(_newName, null));
            if (_notEquals) {
              fmt.renameClock(c.getClock().getName(), c.getNewName());
            }
          }
        }
      }
      boolean _isWindow = op.isWindow();
      if (_isWindow) {
        final Value real_from = this.exprExt.evaluate(op.getFrom());
        final double from = this.exprExt.doubleValue(real_from, op, "\'from\' value in window");
        final Value real_to = this.exprExt.evaluate(op.getTo());
        final double to = this.exprExt.doubleValue(real_to, op, "\'to\' value in window");
        fmt.setTickWindow(from, to);
      }
      if (((!Objects.equal(op.getLabelif(), null)) && (op.getLabelif().size() > 0))) {
        EList<Clock> _labelif = op.getLabelif();
        for (final Clock c_1 : _labelif) {
          fmt.addLabelIf(c_1.getName());
        }
      }
      boolean _isXscaled = op.isXscaled();
      if (_isXscaled) {
        fmt.setXscale(this.exprExt.doubleValue(this.exprExt.evaluate(op.getXscale()), op, "for xscale value"));
      }
      String _border = op.getBorder();
      boolean _notEquals = (!Objects.equal(_border, null));
      if (_notEquals) {
        fmt.setBorders(op.getBorder());
      }
      String _css = op.getCss();
      boolean _notEquals_1 = (!Objects.equal(_css, null));
      if (_notEquals_1) {
        fmt.setCss(op.getCss());
      }
      boolean _isNodefcss = op.isNodefcss();
      if (_isNodefcss) {
        fmt.setNodefcss(true);
      }
      String _jvs = op.getJvs();
      boolean _notEquals_2 = (!Objects.equal(_jvs, null));
      if (_notEquals_2) {
        fmt.setJvs(op.getJvs());
      }
      boolean _isStandalone = op.isStandalone();
      if (_isStandalone) {
        fmt.setStandalone(true);
        boolean _isOverwrite = op.isOverwrite();
        if (_isOverwrite) {
          fmt.setOverwrite(true);
        }
      }
      return null;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected PrintStream _process(final DoubleCalcPragma dcp) {
    try {
      final int digits = dcp.getNum_digits().intValue();
      final ROUNDING_MODE mode = dcp.getRounding_mode();
      RoundDouble.setNumDigits(digits);
      boolean _isRound = dcp.isRound();
      if (_isRound) {
        int _switchResult = (int) 0;
        if (mode != null) {
          switch (mode) {
            case ROUND_CEILING:
              _switchResult = BigDecimal.ROUND_CEILING;
              break;
            case ROUND_DOWN:
              _switchResult = BigDecimal.ROUND_DOWN;
              break;
            case ROUND_FLOOR:
              _switchResult = BigDecimal.ROUND_FLOOR;
              break;
            case ROUND_HALF_DOWN:
              _switchResult = BigDecimal.ROUND_HALF_DOWN;
              break;
            case ROUND_HALF_EVEN:
              _switchResult = BigDecimal.ROUND_HALF_EVEN;
              break;
            case ROUND_HALF_UP:
              _switchResult = BigDecimal.ROUND_HALF_UP;
              break;
            case ROUND_UP:
              _switchResult = BigDecimal.ROUND_UP;
              break;
            default:
              int _xblockexpression = (int) 0;
              {
                this.getSpec().reportError(dcp, ("Unsupported value for rounding mode: " + mode));
                _xblockexpression = BigDecimal.ROUND_HALF_DOWN;
              }
              _switchResult = _xblockexpression;
              break;
          }
        } else {
          int _xblockexpression = (int) 0;
          {
            this.getSpec().reportError(dcp, ("Unsupported value for rounding mode: " + mode));
            _xblockexpression = BigDecimal.ROUND_HALF_DOWN;
          }
          _switchResult = _xblockexpression;
        }
        final int rounding_mode = _switchResult;
        RoundDouble.setRoundingMode(rounding_mode);
      }
      return null;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected PrintStream _process(final DumpResultPragma drp) {
    TESLSpec _spec = this.getSpec();
    _spec.setDumpResult(true);
    return null;
  }
  
  protected PrintStream _process(final Pragma pragma) {
    try {
      PrintStream _xblockexpression = null;
      {
        this.getSpec().reportError(pragma, ("Unsupported pragma: " + pragma));
        this.getSpec().consoleOnly(this.getSpec().getOut(), "Supported pragmas:");
        this.getSpec().consoleOnly(this.getSpec().getOut(), "  @dumpres  : dump simulation result when finished");
        this.getSpec().consoleOnly(this.getSpec().getOut(), "  @stop when <clock name>  : stop simulation when the clock ticks");
        this.getSpec().consoleOnly(this.getSpec().getOut(), "  @tagref <clock name>  : use clock tags as time line reference");
        this.getSpec().consoleOnly(this.getSpec().getOut(), "  @trace <kind>+  : (try @trace _help_ for details)");
        this.getSpec().consoleOnly(this.getSpec().getOut(), "  @maxstep <expression>  : stop simulation after a given number of steps");
        this.getSpec().consoleOnly(this.getSpec().getOut(), "  @doublecalc digits=<int> [(<rounding_mode>)]?");
        this.getSpec().consoleOnly(this.getSpec().getOut(), "    set the number of digits use for computing with doubles, and optionally");
        this.getSpec().consoleOnly(this.getSpec().getOut(), "    set the rounding mode among: round_up, round_down, round_ceil, round_floor,");
        this.getSpec().consoleOnly(this.getSpec().getOut(), "                                 round_half_up, round_half_down and round_half_even");
        this.getSpec().consoleOnly(this.getSpec().getOut(), "  @output <format> [select <clock>+]? [from <expr> to <expr>]? [label if <clock>+]? [xscale <expr>]?");
        this.getSpec().consoleOnly(this.getSpec().getOut(), "    request output in <format> (vcd or tikz), selecting only some clocks");
        this.getSpec().consoleOnly(this.getSpec().getOut(), "    displaying only tick from some date to another.");
        _xblockexpression = this.getSpec().consoleOnly(this.getSpec().getOut(), "    With the tikz format, put a label on a tick if some clocks tick and choose the x scale for tags.");
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public PrintStream process(final Pragma dcp) {
    if (dcp instanceof DoubleCalcPragma) {
      return _process((DoubleCalcPragma)dcp);
    } else if (dcp instanceof DumpResultPragma) {
      return _process((DumpResultPragma)dcp);
    } else if (dcp instanceof MaxstepPragma) {
      return _process((MaxstepPragma)dcp);
    } else if (dcp instanceof OutputPragma) {
      return _process((OutputPragma)dcp);
    } else if (dcp instanceof StopPragma) {
      return _process((StopPragma)dcp);
    } else if (dcp instanceof TagrefPragma) {
      return _process((TagrefPragma)dcp);
    } else if (dcp instanceof TracePragma) {
      return _process((TracePragma)dcp);
    } else if (dcp != null) {
      return _process(dcp);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(dcp).toString());
    }
  }
}

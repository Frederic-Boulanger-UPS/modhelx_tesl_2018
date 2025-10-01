package fr.supelec.tesl.lang.ui.run;

import com.google.common.base.Objects;
import fr.supelec.tesl.core.BigDecimalCalc;
import fr.supelec.tesl.core.BigIntegerCalc;
import fr.supelec.tesl.core.Rational;
import fr.supelec.tesl.core.RationalCalc;
import fr.supelec.tesl.core.RoundDouble;
import fr.supelec.tesl.lang.tesl.BinOp;
import fr.supelec.tesl.lang.tesl.DecimalCast;
import fr.supelec.tesl.lang.tesl.DecimalValue;
import fr.supelec.tesl.lang.tesl.Expression;
import fr.supelec.tesl.lang.tesl.FloatCast;
import fr.supelec.tesl.lang.tesl.FloatValue;
import fr.supelec.tesl.lang.tesl.IntCast;
import fr.supelec.tesl.lang.tesl.IntegerValue;
import fr.supelec.tesl.lang.tesl.LetValue;
import fr.supelec.tesl.lang.tesl.Op;
import fr.supelec.tesl.lang.tesl.RationalCast;
import fr.supelec.tesl.lang.tesl.RationalValue;
import fr.supelec.tesl.lang.tesl.TeslFactory;
import fr.supelec.tesl.lang.tesl.Value;
import fr.supelec.tesl.lang.ui.run.TESLSpec;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class ExpressionExtensions {
  private final TeslFactory factory = TeslFactory.eINSTANCE;
  
  private final BigIntegerCalc intCalculus = new BigIntegerCalc();
  
  private final BigDecimalCalc decimalCalculus = new BigDecimalCalc();
  
  private final RoundDouble floatCalculus = new RoundDouble();
  
  private final RationalCalc ratCalculus = new RationalCalc();
  
  private final TESLSpec spec;
  
  public ExpressionExtensions(final TESLSpec spec) {
    this.spec = spec;
  }
  
  /**
   * Evaluate an expression, returning a Value.
   * @param e the expression to evaluate
   * @param infile the file in which the expression appears (for error reporting)
   * @return the value of the expression
   * @throws CoreException
   */
  protected Value _evaluate(final Expression e) throws CoreException {
    String _name = e.getClass().getName();
    String _plus = ("Unsupported expression type for evaluation: " + _name);
    this.spec.reportError(e, _plus);
    return null;
  }
  
  protected Value _evaluate(final Void e) {
    return null;
  }
  
  protected Value _evaluate(final LetValue e) {
    try {
      final String name = e.getRef().getName();
      final Expression letexpr = this.spec.getLetValue(name);
      boolean _equals = Objects.equal(letexpr, null);
      if (_equals) {
        this.spec.reportError(e, (("Unknown let definition " + name) + " in expression"));
        return null;
      }
      final Value v = this.evaluate(letexpr);
      boolean _notEquals = (!Objects.equal(v, e));
      if (_notEquals) {
        this.spec.setLetValue(name, v);
      }
      return v;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected Value _evaluate(final BinOp e) {
    try {
      Value _xblockexpression = null;
      {
        final Value left = this.evaluate(e.getLeft());
        final Value right = this.evaluate(e.getRight());
        _xblockexpression = this.evaluateOperator(left, right, e);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected Value _evaluate(final IntegerValue ie) {
    final Op sign = ie.getSign();
    boolean _equals = Objects.equal(sign, Op.MINUS);
    if (_equals) {
      final IntegerValue value = this.factory.createIntegerValue();
      value.setValue(ie.getValue().negate());
      value.setSign(Op.PLUS);
      return value;
    } else {
      return ie;
    }
  }
  
  protected Value _evaluate(final FloatValue fe) {
    final Op sign = fe.getSign();
    boolean _equals = Objects.equal(sign, Op.MINUS);
    if (_equals) {
      final FloatValue value = this.factory.createFloatValue();
      double _value = fe.getValue();
      double _minus = (-_value);
      value.setValue(_minus);
      value.setSign(Op.PLUS);
      return value;
    } else {
      return fe;
    }
  }
  
  protected Value _evaluate(final DecimalValue de) {
    final Op sign = de.getSign();
    boolean _equals = Objects.equal(sign, Op.MINUS);
    if (_equals) {
      final DecimalValue value = this.factory.createDecimalValue();
      value.setValue(de.getValue().negate());
      value.setSign(Op.PLUS);
      return value;
    } else {
      return de;
    }
  }
  
  protected Value _evaluate(final RationalValue re) {
    final Op sign = re.getSign();
    boolean _equals = Objects.equal(sign, Op.MINUS);
    if (_equals) {
      final RationalValue value = this.factory.createRationalValue();
      Object _value = re.getValue();
      value.setValue(((Rational) _value).negate());
      value.setSign(Op.PLUS);
      return value;
    } else {
      return re;
    }
  }
  
  protected Value _evaluate(final IntCast ice) {
    try {
      Value value = this.evaluate(ice.getExpr());
      if ((value instanceof FloatValue)) {
        final double v = ((FloatValue)value).getValue();
        value = this.factory.createIntegerValue();
        ((IntegerValue) value).setValue(BigInteger.valueOf(((int) v)));
      } else {
        if ((value instanceof DecimalValue)) {
          final BigDecimal v_1 = ((DecimalValue)value).getValue();
          value = this.factory.createIntegerValue();
          ((IntegerValue) value).setValue(v_1.toBigInteger());
        } else {
          if ((value instanceof RationalValue)) {
            Object _value = ((RationalValue)value).getValue();
            final Rational v_2 = ((Rational) _value);
            value = this.factory.createIntegerValue();
            ((IntegerValue) value).setValue(v_2.bigIntegerValue());
          }
        }
      }
      return value;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected Value _evaluate(final DecimalCast dce) {
    try {
      Value value = this.evaluate(dce.getExpr());
      if ((value instanceof IntegerValue)) {
        final BigInteger v = ((IntegerValue)value).getValue();
        value = this.factory.createDecimalValue();
        BigDecimal _bigDecimal = new BigDecimal(v);
        ((DecimalValue) value).setValue(_bigDecimal);
      } else {
        if ((value instanceof FloatValue)) {
          final double dble = ((FloatValue)value).getValue();
          value = this.factory.createDecimalValue();
          ((DecimalValue) value).setValue(BigDecimal.valueOf(dble));
        } else {
          if ((value instanceof RationalValue)) {
            Object _value = ((RationalValue)value).getValue();
            final Rational rat = ((Rational) _value);
            value = this.factory.createDecimalValue();
            ((DecimalValue) value).setValue(rat.bigDecimalValue());
          }
        }
      }
      return value;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected Value _evaluate(final FloatCast fce) {
    try {
      Value value = this.evaluate(fce.getExpr());
      if ((value instanceof IntegerValue)) {
        final BigInteger v = ((IntegerValue)value).getValue();
        value = this.factory.createFloatValue();
        ((FloatValue) value).setValue(v.doubleValue());
      } else {
        if ((value instanceof DecimalValue)) {
          final BigDecimal dec = ((DecimalValue)value).getValue();
          value = this.factory.createFloatValue();
          ((FloatValue) value).setValue(dec.doubleValue());
        } else {
          if ((value instanceof RationalValue)) {
            Object _value = ((RationalValue)value).getValue();
            final Rational rat = ((Rational) _value);
            value = this.factory.createFloatValue();
            ((FloatValue) value).setValue(rat.doubleValue());
          }
        }
      }
      return value;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected Value _evaluate(final RationalCast rce) {
    try {
      Value value = this.evaluate(rce.getExpr());
      if ((value instanceof IntegerValue)) {
        final BigInteger v = ((IntegerValue)value).getValue();
        value = this.factory.createRationalValue();
        Rational _rational = new Rational(v);
        ((RationalValue) value).setValue(_rational);
      } else {
        if ((value instanceof DecimalValue)) {
          final BigDecimal v_1 = ((DecimalValue)value).getValue();
          value = this.factory.createRationalValue();
          Rational _rational_1 = new Rational(v_1);
          ((RationalValue) value).setValue(_rational_1);
        } else {
          if ((value instanceof FloatValue)) {
            final double v_2 = ((FloatValue)value).getValue();
            value = this.factory.createRationalValue();
            Rational _rational_2 = new Rational(v_2);
            ((RationalValue) value).setValue(_rational_2);
          }
        }
      }
      return value;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected Value _evaluateOperator(final IntegerValue left, final IntegerValue right, final BinOp op) {
    return this.evaluateOperator(left.getValue(), right.getValue(), op);
  }
  
  protected Value _evaluateOperator(final BigInteger left, final BigInteger right, final BinOp op) {
    try {
      final IntegerValue result = this.factory.createIntegerValue();
      try {
        Op _op = op.getOp();
        if (_op != null) {
          switch (_op) {
            case PLUS:
              result.setValue(this.intCalculus.add(left, right));
              break;
            case MINUS:
              result.setValue(this.intCalculus.subtract(left, right));
              break;
            case TIMES:
              result.setValue(this.intCalculus.multiply(left, right));
              break;
            case DIV:
              result.setValue(this.intCalculus.divide(left, right));
              break;
            default:
              Op _op_1 = op.getOp();
              String _plus = ("Unknown arithmetic operator: " + _op_1);
              this.spec.reportError(op, _plus);
              break;
          }
        } else {
          Op _op_1 = op.getOp();
          String _plus = ("Unknown arithmetic operator: " + _op_1);
          this.spec.reportError(op, _plus);
        }
      } catch (final Throwable _t) {
        if (_t instanceof ArithmeticException) {
          final ArithmeticException e = (ArithmeticException)_t;
          String _message = e.getMessage();
          final String msg = ("## Arithmetic exception: " + _message);
          this.spec.reportError(op, msg);
          this.spec.console(this.spec.getErr(), msg);
          result.setValue(BigInteger.ZERO);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      return result;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected Value _evaluateOperator(final RationalValue left, final RationalValue right, final BinOp op) {
    return this.evaluateOperator(left.getValue(), right.getValue(), op);
  }
  
  protected Value _evaluateOperator(final RationalValue left, final FloatValue right, final BinOp op) {
    Object _value = left.getValue();
    double _value_1 = right.getValue();
    Rational _rational = new Rational(_value_1);
    return this.evaluateOperator(_value, _rational, op);
  }
  
  protected Value _evaluateOperator(final RationalValue left, final DecimalValue right, final BinOp op) {
    Object _value = left.getValue();
    BigDecimal _value_1 = right.getValue();
    Rational _rational = new Rational(_value_1);
    return this.evaluateOperator(_value, _rational, op);
  }
  
  protected Value _evaluateOperator(final FloatValue left, final RationalValue right, final BinOp op) {
    double _value = left.getValue();
    Rational _rational = new Rational(_value);
    return this.evaluateOperator(_rational, right.getValue(), op);
  }
  
  protected Value _evaluateOperator(final DecimalValue left, final RationalValue right, final BinOp op) {
    BigDecimal _value = left.getValue();
    Rational _rational = new Rational(_value);
    return this.evaluateOperator(_rational, right.getValue(), op);
  }
  
  protected Value _evaluateOperator(final RationalValue left, final IntegerValue right, final BinOp op) {
    Object _value = left.getValue();
    BigInteger _value_1 = right.getValue();
    Rational _rational = new Rational(_value_1);
    return this.evaluateOperator(_value, _rational, op);
  }
  
  protected Value _evaluateOperator(final IntegerValue left, final RationalValue right, final BinOp op) {
    BigInteger _value = left.getValue();
    Rational _rational = new Rational(_value);
    return this.evaluateOperator(_rational, right.getValue(), op);
  }
  
  protected Value _evaluateOperator(final Rational left, final Rational right, final BinOp op) {
    try {
      final RationalValue result = this.factory.createRationalValue();
      Rational _xtrycatchfinallyexpression = null;
      try {
        Rational _switchResult = null;
        Op _op = op.getOp();
        if (_op != null) {
          switch (_op) {
            case PLUS:
              _switchResult = this.ratCalculus.add(left, right);
              break;
            case MINUS:
              _switchResult = this.ratCalculus.subtract(left, right);
              break;
            case TIMES:
              _switchResult = this.ratCalculus.multiply(left, right);
              break;
            case DIV:
              _switchResult = this.ratCalculus.divide(left, right);
              break;
            default:
              Rational _xblockexpression = null;
              {
                Op _op_1 = op.getOp();
                String _plus = ("Unknown arithmetic operator: " + _op_1);
                this.spec.reportError(op, _plus);
                _xblockexpression = new Rational(0);
              }
              _switchResult = _xblockexpression;
              break;
          }
        } else {
          Rational _xblockexpression = null;
          {
            Op _op_1 = op.getOp();
            String _plus = ("Unknown arithmetic operator: " + _op_1);
            this.spec.reportError(op, _plus);
            _xblockexpression = new Rational(0);
          }
          _switchResult = _xblockexpression;
        }
        _xtrycatchfinallyexpression = _switchResult;
      } catch (final Throwable _t) {
        if (_t instanceof ArithmeticException) {
          final ArithmeticException e = (ArithmeticException)_t;
          Rational _xblockexpression_1 = null;
          {
            String _message = e.getMessage();
            final String msg = ("## Arithmetic exception: " + _message);
            this.spec.reportError(op, msg);
            this.spec.console(this.spec.getErr(), msg);
            _xblockexpression_1 = new Rational(0);
          }
          _xtrycatchfinallyexpression = _xblockexpression_1;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      final Rational res = _xtrycatchfinallyexpression;
      result.setValue(res);
      return result;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected Value _evaluateOperator(final IntegerValue left, final DecimalValue right, final BinOp op) {
    BigInteger _value = left.getValue();
    BigDecimal _bigDecimal = new BigDecimal(_value);
    return this.evaluateOperator(_bigDecimal, right.getValue(), op);
  }
  
  protected Value _evaluateOperator(final DecimalValue left, final IntegerValue right, final BinOp op) {
    BigDecimal _value = left.getValue();
    BigInteger _value_1 = right.getValue();
    BigDecimal _bigDecimal = new BigDecimal(_value_1);
    return this.evaluateOperator(_value, _bigDecimal, op);
  }
  
  protected Value _evaluateOperator(final FloatValue left, final DecimalValue right, final BinOp op) {
    double _value = left.getValue();
    BigDecimal _bigDecimal = new BigDecimal(_value);
    return this.evaluateOperator(_bigDecimal, right.getValue(), op);
  }
  
  protected Value _evaluateOperator(final DecimalValue left, final FloatValue right, final BinOp op) {
    BigDecimal _value = left.getValue();
    double _value_1 = right.getValue();
    BigDecimal _bigDecimal = new BigDecimal(_value_1);
    return this.evaluateOperator(_value, _bigDecimal, op);
  }
  
  protected Value _evaluateOperator(final DecimalValue left, final DecimalValue right, final BinOp op) {
    return this.evaluateOperator(left.getValue(), right.getValue(), op);
  }
  
  protected Value _evaluateOperator(final BigDecimal left, final BigDecimal right, final BinOp op) {
    try {
      final DecimalValue result = this.factory.createDecimalValue();
      try {
        Op _op = op.getOp();
        if (_op != null) {
          switch (_op) {
            case PLUS:
              result.setValue(this.decimalCalculus.add(left, right));
              break;
            case MINUS:
              result.setValue(this.decimalCalculus.subtract(left, right));
              break;
            case TIMES:
              result.setValue(this.decimalCalculus.multiply(left, right));
              break;
            case DIV:
              result.setValue(this.decimalCalculus.divide(left, right));
              break;
            default:
              Op _op_1 = op.getOp();
              String _plus = ("Unknown arithmetic operator: " + _op_1);
              this.spec.reportError(op, _plus);
              break;
          }
        } else {
          Op _op_1 = op.getOp();
          String _plus = ("Unknown arithmetic operator: " + _op_1);
          this.spec.reportError(op, _plus);
        }
      } catch (final Throwable _t) {
        if (_t instanceof ArithmeticException) {
          final ArithmeticException e = (ArithmeticException)_t;
          String _message = e.getMessage();
          final String msg = ("## Arithmetic exception: " + _message);
          this.spec.reportError(op, msg);
          this.spec.console(this.spec.getErr(), msg);
          result.setValue(BigDecimal.ZERO);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      return result;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected Value _evaluateOperator(final IntegerValue left, final FloatValue right, final BinOp op) {
    return this.evaluateOperator(Double.valueOf(left.getValue().doubleValue()), Double.valueOf(right.getValue()), op);
  }
  
  protected Value _evaluateOperator(final FloatValue left, final IntegerValue right, final BinOp op) {
    return this.evaluateOperator(Double.valueOf(left.getValue()), Double.valueOf(right.getValue().doubleValue()), op);
  }
  
  protected Value _evaluateOperator(final FloatValue left, final FloatValue right, final BinOp op) {
    return this.evaluateOperator(Double.valueOf(left.getValue()), Double.valueOf(right.getValue()), op);
  }
  
  protected Value _evaluateOperator(final double left, final double right, final BinOp op) {
    try {
      final FloatValue result = this.factory.createFloatValue();
      try {
        Op _op = op.getOp();
        if (_op != null) {
          switch (_op) {
            case PLUS:
              result.setValue((this.floatCalculus.add(Double.valueOf(left), Double.valueOf(right))).doubleValue());
              break;
            case MINUS:
              result.setValue((this.floatCalculus.subtract(Double.valueOf(left), Double.valueOf(right))).doubleValue());
              break;
            case TIMES:
              result.setValue((this.floatCalculus.multiply(Double.valueOf(left), Double.valueOf(right))).doubleValue());
              break;
            case DIV:
              result.setValue((this.floatCalculus.divide(Double.valueOf(left), Double.valueOf(right))).doubleValue());
              break;
            default:
              Op _op_1 = op.getOp();
              String _plus = ("Unknown arithmetic operator: " + _op_1);
              this.spec.reportError(op, _plus);
              break;
          }
        } else {
          Op _op_1 = op.getOp();
          String _plus = ("Unknown arithmetic operator: " + _op_1);
          this.spec.reportError(op, _plus);
        }
      } catch (final Throwable _t) {
        if (_t instanceof ArithmeticException) {
          final ArithmeticException e = (ArithmeticException)_t;
          String _message = e.getMessage();
          final String msg = ("## Arithmetic exception: " + _message);
          this.spec.reportError(op, msg);
          this.spec.console(this.spec.getErr(), msg);
          result.setValue(0.0D);
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
      return result;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected Value _evaluateOperator(final Value left, final Value right, final BinOp op) {
    try {
      String _name = left.getClass().getName();
      String _plus = ("Unsupported value type: either " + _name);
      String _plus_1 = (_plus + " or ");
      String _name_1 = right.getClass().getName();
      String _plus_2 = (_plus_1 + _name_1);
      this.spec.reportError(op, _plus_2);
      return null;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Value Extensions
   */
  protected BigInteger _bigIntegerValue(final IntegerValue v, final EObject faultyASTNode, final String msg) {
    return v.getValue();
  }
  
  protected BigInteger _bigIntegerValue(final Value v, final EObject faultyASTNode, final String msg) {
    try {
      this.spec.reportError(faultyASTNode, ((("Unsupported value as integer for " + msg) + ": ") + v));
      return null;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public int intValue(final Value v, final EObject faultyASTNode, final String msg) {
    try {
      int _xblockexpression = (int) 0;
      {
        final BigInteger bb = this.bigIntegerValue(v, faultyASTNode, msg);
        int _xifexpression = (int) 0;
        boolean _notEquals = (!Objects.equal(bb, null));
        if (_notEquals) {
          int _xblockexpression_1 = (int) 0;
          {
            final int ib = bb.intValue();
            boolean _equals = bb.equals(BigInteger.valueOf(ib));
            boolean _not = (!_equals);
            if (_not) {
              this.spec.reportError(faultyASTNode, ((msg + " is too big to fit into an int: ") + bb));
            }
            _xblockexpression_1 = ib;
          }
          _xifexpression = _xblockexpression_1;
        } else {
          _xifexpression = 0;
        }
        _xblockexpression = _xifexpression;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected BigDecimal _bigDecimalValue(final IntegerValue v, final EObject faultyASTNode, final String msg) {
    BigInteger _value = v.getValue();
    return new BigDecimal(_value);
  }
  
  protected BigDecimal _bigDecimalValue(final DecimalValue v, final EObject faultyASTNode, final String msg) {
    return v.getValue();
  }
  
  protected BigDecimal _bigDecimalValue(final FloatValue v, final EObject faultyASTNode, final String msg) {
    return BigDecimal.valueOf(v.getValue());
  }
  
  protected BigDecimal _bigDecimalValue(final Value v, final EObject faultyASTNode, final String msg) {
    try {
      this.spec.reportError(v, ((("Unsupported value as float for " + msg) + ": ") + v));
      return null;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected double _doubleValue(final IntegerValue v, final EObject faultyASTNode, final String msg) {
    try {
      double _xblockexpression = (double) 0;
      {
        BigInteger _value = v.getValue();
        final BigDecimal bd = new BigDecimal(_value);
        final double dd = bd.doubleValue();
        int _compareTo = bd.compareTo(BigDecimal.valueOf(dd));
        boolean _notEquals = (_compareTo != 0);
        if (_notEquals) {
          this.spec.reportError(faultyASTNode, ((msg + " is too big to fit into a double: ") + bd));
        }
        _xblockexpression = dd;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected double _doubleValue(final DecimalValue v, final EObject faultyASTNode, final String msg) {
    try {
      double _xblockexpression = (double) 0;
      {
        final double dd = v.getValue().doubleValue();
        int _compareTo = v.getValue().compareTo(BigDecimal.valueOf(dd));
        boolean _notEquals = (_compareTo != 0);
        if (_notEquals) {
          BigDecimal _value = v.getValue();
          String _plus = ((msg + " is too big to fit into a double: ") + _value);
          this.spec.reportError(faultyASTNode, _plus);
        }
        _xblockexpression = dd;
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected double _doubleValue(final FloatValue v, final EObject faultyASTNode, final String msg) {
    return v.getValue();
  }
  
  protected double _doubleValue(final Value v, final EObject faultyASTNode, final String msg) {
    try {
      this.spec.reportError(v, ((("Unsupported value as double for " + msg) + ": ") + v));
      return 0.0;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected Rational _rationalValue(final IntegerValue v, final EObject faultyASTNode, final String msg) {
    BigInteger _value = v.getValue();
    return new Rational(_value);
  }
  
  protected Rational _rationalValue(final DecimalValue v, final EObject faultyASTNode, final String msg) {
    BigDecimal _value = v.getValue();
    return new Rational(_value);
  }
  
  protected Rational _rationalValue(final FloatValue v, final EObject faultyASTNode, final String msg) {
    double _value = v.getValue();
    return new Rational(_value);
  }
  
  protected Rational _rationalValue(final RationalValue v, final EObject faultyASTNode, final String msg) {
    Object _value = v.getValue();
    return ((Rational) _value);
  }
  
  protected Rational _rationalValue(final Value v, final EObject faultyASTNode, final String msg) {
    try {
      this.spec.reportError(v, ((("Unsupported value as rational for " + msg) + ": ") + v));
      return null;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public Value evaluate(final Expression dce) throws CoreException {
    if (dce instanceof DecimalCast) {
      return _evaluate((DecimalCast)dce);
    } else if (dce instanceof DecimalValue) {
      return _evaluate((DecimalValue)dce);
    } else if (dce instanceof FloatCast) {
      return _evaluate((FloatCast)dce);
    } else if (dce instanceof FloatValue) {
      return _evaluate((FloatValue)dce);
    } else if (dce instanceof IntCast) {
      return _evaluate((IntCast)dce);
    } else if (dce instanceof IntegerValue) {
      return _evaluate((IntegerValue)dce);
    } else if (dce instanceof LetValue) {
      return _evaluate((LetValue)dce);
    } else if (dce instanceof RationalCast) {
      return _evaluate((RationalCast)dce);
    } else if (dce instanceof RationalValue) {
      return _evaluate((RationalValue)dce);
    } else if (dce instanceof BinOp) {
      return _evaluate((BinOp)dce);
    } else if (dce != null) {
      return _evaluate(dce);
    } else if (dce == null) {
      return _evaluate((Void)null);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(dce).toString());
    }
  }
  
  public Value evaluateOperator(final Object left, final Object right, final BinOp op) {
    if (left instanceof DecimalValue
         && right instanceof DecimalValue) {
      return _evaluateOperator((DecimalValue)left, (DecimalValue)right, op);
    } else if (left instanceof DecimalValue
         && right instanceof FloatValue) {
      return _evaluateOperator((DecimalValue)left, (FloatValue)right, op);
    } else if (left instanceof DecimalValue
         && right instanceof IntegerValue) {
      return _evaluateOperator((DecimalValue)left, (IntegerValue)right, op);
    } else if (left instanceof DecimalValue
         && right instanceof RationalValue) {
      return _evaluateOperator((DecimalValue)left, (RationalValue)right, op);
    } else if (left instanceof FloatValue
         && right instanceof DecimalValue) {
      return _evaluateOperator((FloatValue)left, (DecimalValue)right, op);
    } else if (left instanceof FloatValue
         && right instanceof FloatValue) {
      return _evaluateOperator((FloatValue)left, (FloatValue)right, op);
    } else if (left instanceof FloatValue
         && right instanceof IntegerValue) {
      return _evaluateOperator((FloatValue)left, (IntegerValue)right, op);
    } else if (left instanceof FloatValue
         && right instanceof RationalValue) {
      return _evaluateOperator((FloatValue)left, (RationalValue)right, op);
    } else if (left instanceof IntegerValue
         && right instanceof DecimalValue) {
      return _evaluateOperator((IntegerValue)left, (DecimalValue)right, op);
    } else if (left instanceof IntegerValue
         && right instanceof FloatValue) {
      return _evaluateOperator((IntegerValue)left, (FloatValue)right, op);
    } else if (left instanceof IntegerValue
         && right instanceof IntegerValue) {
      return _evaluateOperator((IntegerValue)left, (IntegerValue)right, op);
    } else if (left instanceof IntegerValue
         && right instanceof RationalValue) {
      return _evaluateOperator((IntegerValue)left, (RationalValue)right, op);
    } else if (left instanceof RationalValue
         && right instanceof DecimalValue) {
      return _evaluateOperator((RationalValue)left, (DecimalValue)right, op);
    } else if (left instanceof RationalValue
         && right instanceof FloatValue) {
      return _evaluateOperator((RationalValue)left, (FloatValue)right, op);
    } else if (left instanceof RationalValue
         && right instanceof IntegerValue) {
      return _evaluateOperator((RationalValue)left, (IntegerValue)right, op);
    } else if (left instanceof RationalValue
         && right instanceof RationalValue) {
      return _evaluateOperator((RationalValue)left, (RationalValue)right, op);
    } else if (left instanceof Value
         && right instanceof Value) {
      return _evaluateOperator((Value)left, (Value)right, op);
    } else if (left instanceof Double
         && right instanceof Double) {
      return _evaluateOperator((Double)left, (Double)right, op);
    } else if (left instanceof Rational
         && right instanceof Rational) {
      return _evaluateOperator((Rational)left, (Rational)right, op);
    } else if (left instanceof BigDecimal
         && right instanceof BigDecimal) {
      return _evaluateOperator((BigDecimal)left, (BigDecimal)right, op);
    } else if (left instanceof BigInteger
         && right instanceof BigInteger) {
      return _evaluateOperator((BigInteger)left, (BigInteger)right, op);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(left, right, op).toString());
    }
  }
  
  public BigInteger bigIntegerValue(final Value v, final EObject faultyASTNode, final String msg) {
    if (v instanceof IntegerValue) {
      return _bigIntegerValue((IntegerValue)v, faultyASTNode, msg);
    } else if (v != null) {
      return _bigIntegerValue(v, faultyASTNode, msg);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(v, faultyASTNode, msg).toString());
    }
  }
  
  public BigDecimal bigDecimalValue(final Value v, final EObject faultyASTNode, final String msg) {
    if (v instanceof DecimalValue) {
      return _bigDecimalValue((DecimalValue)v, faultyASTNode, msg);
    } else if (v instanceof FloatValue) {
      return _bigDecimalValue((FloatValue)v, faultyASTNode, msg);
    } else if (v instanceof IntegerValue) {
      return _bigDecimalValue((IntegerValue)v, faultyASTNode, msg);
    } else if (v != null) {
      return _bigDecimalValue(v, faultyASTNode, msg);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(v, faultyASTNode, msg).toString());
    }
  }
  
  public double doubleValue(final Value v, final EObject faultyASTNode, final String msg) {
    if (v instanceof DecimalValue) {
      return _doubleValue((DecimalValue)v, faultyASTNode, msg);
    } else if (v instanceof FloatValue) {
      return _doubleValue((FloatValue)v, faultyASTNode, msg);
    } else if (v instanceof IntegerValue) {
      return _doubleValue((IntegerValue)v, faultyASTNode, msg);
    } else if (v != null) {
      return _doubleValue(v, faultyASTNode, msg);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(v, faultyASTNode, msg).toString());
    }
  }
  
  public Rational rationalValue(final Value v, final EObject faultyASTNode, final String msg) {
    if (v instanceof DecimalValue) {
      return _rationalValue((DecimalValue)v, faultyASTNode, msg);
    } else if (v instanceof FloatValue) {
      return _rationalValue((FloatValue)v, faultyASTNode, msg);
    } else if (v instanceof IntegerValue) {
      return _rationalValue((IntegerValue)v, faultyASTNode, msg);
    } else if (v instanceof RationalValue) {
      return _rationalValue((RationalValue)v, faultyASTNode, msg);
    } else if (v != null) {
      return _rationalValue(v, faultyASTNode, msg);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(v, faultyASTNode, msg).toString());
    }
  }
}

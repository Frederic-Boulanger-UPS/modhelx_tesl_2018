package fr.supelec.tesl.lang.ui.run;

import com.google.common.base.Objects;
import fr.supelec.tesl.core.BigDecimalCalc;
import fr.supelec.tesl.core.BigIntegerCalc;
import fr.supelec.tesl.core.Rational;
import fr.supelec.tesl.core.RationalCalc;
import fr.supelec.tesl.core.RoundDouble;
import fr.supelec.tesl.core.Unit;
import fr.supelec.tesl.core.UnitCalc;
import fr.supelec.tesl.lang.tesl.Clock;
import fr.supelec.tesl.lang.tesl.ClockQualifier;
import fr.supelec.tesl.lang.tesl.Expression;
import fr.supelec.tesl.lang.tesl.PeriodicQualifier;
import fr.supelec.tesl.lang.tesl.SporadicQualifier;
import fr.supelec.tesl.lang.tesl.Type;
import fr.supelec.tesl.lang.tesl.Value;
import fr.supelec.tesl.lang.ui.run.ExtensionWithExpressions;
import fr.supelec.tesl.lang.ui.run.TESLSpec;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class ClockExtensions extends ExtensionWithExpressions {
  public ClockExtensions(final TESLSpec spec) {
    super(spec);
  }
  
  public void process(final Clock c) {
    try {
      fr.supelec.tesl.core.Clock<? extends Comparable<?>> clock = ((fr.supelec.tesl.core.Clock<? extends Comparable<?>>) null);
      final Type type = c.getType();
      final String name = c.getName();
      if (type != null) {
        switch (type) {
          case TUNIT:
            UnitCalc _unitCalc = new UnitCalc();
            clock = fr.supelec.tesl.core.Clock.<Unit>createClock(Unit.class, name, _unitCalc);
            break;
          case TINT:
            BigIntegerCalc _bigIntegerCalc = new BigIntegerCalc();
            clock = fr.supelec.tesl.core.Clock.<BigInteger>createClock(BigInteger.class, name, _bigIntegerCalc);
            break;
          case TDEC:
            BigDecimalCalc _bigDecimalCalc = new BigDecimalCalc();
            clock = fr.supelec.tesl.core.Clock.<BigDecimal>createClock(BigDecimal.class, name, _bigDecimalCalc);
            break;
          case TRAT:
            RationalCalc _rationalCalc = new RationalCalc();
            clock = fr.supelec.tesl.core.Clock.<Rational>createClock(Rational.class, name, _rationalCalc);
            break;
          case TFLOAT:
            RoundDouble _roundDouble = new RoundDouble();
            clock = fr.supelec.tesl.core.Clock.<Double>createClock(Double.class, name, _roundDouble);
            break;
          default:
            this.getSpec().reportError(c, ("Unsupported clock type: " + type));
            break;
        }
      } else {
        this.getSpec().reportError(c, ("Unsupported clock type: " + type));
      }
      Assert.isNotNull(clock);
      this.getSpec().addClock(name, clock);
      final ClockQualifier qual = c.getQual();
      boolean _notEquals = (!Objects.equal(qual, null));
      if (_notEquals) {
        if (type != null) {
          switch (type) {
            case TUNIT:
              this.processQualifierForUnitClock(((fr.supelec.tesl.core.Clock<Unit>) clock), qual);
              break;
            case TINT:
              this.processQualifierForIntClock(((fr.supelec.tesl.core.Clock<BigInteger>) clock), qual);
              break;
            case TDEC:
              this.processQualifierForDecClock(((fr.supelec.tesl.core.Clock<BigDecimal>) clock), qual);
              break;
            case TRAT:
              this.processQualifierForRatClock(((fr.supelec.tesl.core.Clock<Rational>) clock), qual);
              break;
            case TFLOAT:
              this.processQualifierForFloatClock(((fr.supelec.tesl.core.Clock<Double>) clock), qual);
              break;
            default:
              break;
          }
        }
      }
      boolean _isNongreedy = c.isNongreedy();
      if (_isNongreedy) {
        clock.setGreedy(false);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void _processQualifierForUnitClock(final fr.supelec.tesl.core.Clock<Unit> clock, final SporadicQualifier sq) {
    try {
      boolean _isEmpty = sq.getInstants().isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        this.getSpec().reportError(sq, "A sporadic unit-clock qualifier may not specify tags");
      }
      clock.newTick();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void _processQualifierForIntClock(final fr.supelec.tesl.core.Clock<BigInteger> clock, final SporadicQualifier sq) {
    try {
      boolean _isEmpty = sq.getInstants().isEmpty();
      if (_isEmpty) {
        this.getSpec().reportError(sq, "A sporadic clock qualifier should specify at least one tag");
      }
      EList<Expression> _instants = sq.getInstants();
      for (final Expression date : _instants) {
        {
          final Value dateValue = this.exprExt.evaluate(date);
          final BigInteger tag = this.exprExt.bigIntegerValue(dateValue, sq, "sporadic qualifier of an int clock");
          clock.newTick(tag);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void _processQualifierForDecClock(final fr.supelec.tesl.core.Clock<BigDecimal> clock, final SporadicQualifier sq) {
    try {
      boolean _isEmpty = sq.getInstants().isEmpty();
      if (_isEmpty) {
        this.getSpec().reportError(sq, "A sporadic clock qualifier should specify at least one tag");
      }
      EList<Expression> _instants = sq.getInstants();
      for (final Expression date : _instants) {
        {
          final Value dateValue = this.exprExt.evaluate(date);
          final BigDecimal tag = this.exprExt.bigDecimalValue(dateValue, sq, "sporadic qualifier of a decimal clock");
          clock.newTick(tag);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void _processQualifierForRatClock(final fr.supelec.tesl.core.Clock<Rational> clock, final SporadicQualifier sq) {
    try {
      boolean _isEmpty = sq.getInstants().isEmpty();
      if (_isEmpty) {
        this.getSpec().reportError(sq, "A sporadic clock qualifier should specify at least one tag");
      }
      EList<Expression> _instants = sq.getInstants();
      for (final Expression date : _instants) {
        {
          final Value dateValue = this.exprExt.evaluate(date);
          final Rational tag = this.exprExt.rationalValue(dateValue, sq, "sporadic qualifier of a rational clock");
          clock.newTick(tag);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void _processQualifierForFloatClock(final fr.supelec.tesl.core.Clock<Double> clock, final SporadicQualifier sq) {
    try {
      boolean _isEmpty = sq.getInstants().isEmpty();
      if (_isEmpty) {
        this.getSpec().reportError(sq, "A sporadic clock qualifier should specify at least one tag");
      }
      EList<Expression> _instants = sq.getInstants();
      for (final Expression date : _instants) {
        {
          final Value dateValue = this.exprExt.evaluate(date);
          final double tag = this.exprExt.doubleValue(dateValue, sq, "sporadic qualifier of a double clock");
          clock.newTick(Double.valueOf(tag));
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void _processQualifierForUnitClock(final fr.supelec.tesl.core.Clock<Unit> clock, final PeriodicQualifier pq) {
    try {
      this.getSpec().reportError(pq, "A unit-clock cannot be periodic");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void _processQualifierForIntClock(final fr.supelec.tesl.core.Clock<BigInteger> clock, final PeriodicQualifier pq) {
    try {
      final Value period = this.exprExt.evaluate(pq.getPeriod());
      final Value offset = this.exprExt.evaluate(pq.getOffset());
      final BigInteger iperiod = this.exprExt.bigIntegerValue(period, pq, "period of an int clock");
      clock.<BigInteger, BigInteger>impliesWithTimeDelay(clock, clock, iperiod, false);
      BigInteger ioffset = BigInteger.ZERO;
      boolean _notEquals = (!Objects.equal(offset, null));
      if (_notEquals) {
        ioffset = this.exprExt.bigIntegerValue(offset, pq, "offset of an int clock");
      }
      clock.newTick(ioffset);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void _processQualifierForDecClock(final fr.supelec.tesl.core.Clock<BigDecimal> clock, final PeriodicQualifier pq) {
    try {
      final Value period = this.exprExt.evaluate(pq.getPeriod());
      final Value offset = this.exprExt.evaluate(pq.getOffset());
      final BigDecimal iperiod = this.exprExt.bigDecimalValue(period, pq, "period of a decimal clock");
      clock.<BigDecimal, BigDecimal>impliesWithTimeDelay(clock, clock, iperiod, false);
      BigDecimal ioffset = BigDecimal.ZERO;
      boolean _notEquals = (!Objects.equal(offset, null));
      if (_notEquals) {
        ioffset = this.exprExt.bigDecimalValue(offset, pq, "offset of a decimalclock");
      }
      clock.newTick(ioffset);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void _processQualifierForRatClock(final fr.supelec.tesl.core.Clock<Rational> clock, final PeriodicQualifier pq) {
    try {
      final Value period = this.exprExt.evaluate(pq.getPeriod());
      final Value offset = this.exprExt.evaluate(pq.getOffset());
      final Rational fperiod = this.exprExt.rationalValue(period, pq, "period of a rational clock");
      clock.<Rational, Rational>impliesWithTimeDelay(clock, clock, fperiod, false);
      Rational foffset = new Rational(0);
      boolean _notEquals = (!Objects.equal(offset, null));
      if (_notEquals) {
        foffset = this.exprExt.rationalValue(offset, pq, "offset of a rational clock");
      }
      clock.newTick(foffset);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void _processQualifierForFloatClock(final fr.supelec.tesl.core.Clock<Double> clock, final PeriodicQualifier pq) {
    try {
      final Value period = this.exprExt.evaluate(pq.getPeriod());
      final Value offset = this.exprExt.evaluate(pq.getOffset());
      final double fperiod = this.exprExt.doubleValue(period, pq, "period of a float clock");
      clock.<Double, Double>impliesWithTimeDelay(clock, clock, Double.valueOf(fperiod), false);
      double foffset = 0.0;
      boolean _notEquals = (!Objects.equal(offset, null));
      if (_notEquals) {
        foffset = this.exprExt.doubleValue(offset, pq, "offset of a float clock");
      }
      clock.newTick(Double.valueOf(foffset));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void _processQualifierForIntClock(final fr.supelec.tesl.core.Clock<BigInteger> clock, final ClockQualifier qual) {
    try {
      TESLSpec _spec = this.getSpec();
      String _name = clock.getName();
      String _plus = ("Unhandled qualifier for int clock " + _name);
      String _plus_1 = (_plus + ": ");
      String _plus_2 = (_plus_1 + qual);
      _spec.reportError(qual, _plus_2);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void _processQualifierForDecClock(final fr.supelec.tesl.core.Clock<BigDecimal> clock, final ClockQualifier qual) {
    try {
      TESLSpec _spec = this.getSpec();
      String _name = clock.getName();
      String _plus = ("Unhandled qualifier for decimal clock " + _name);
      String _plus_1 = (_plus + ": ");
      String _plus_2 = (_plus_1 + qual);
      _spec.reportError(qual, _plus_2);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void _processQualifierForRatClock(final fr.supelec.tesl.core.Clock<Rational> clock, final ClockQualifier qual) {
    try {
      TESLSpec _spec = this.getSpec();
      String _name = clock.getName();
      String _plus = ("Unhandled qualifier for rational clock " + _name);
      String _plus_1 = (_plus + ": ");
      String _plus_2 = (_plus_1 + qual);
      _spec.reportError(qual, _plus_2);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void _processQualifierForFloatClock(final fr.supelec.tesl.core.Clock<Double> clock, final ClockQualifier qual) {
    try {
      TESLSpec _spec = this.getSpec();
      String _name = clock.getName();
      String _plus = ("Unhandled qualifier for float clock " + _name);
      String _plus_1 = (_plus + ": ");
      String _plus_2 = (_plus_1 + qual);
      _spec.reportError(qual, _plus_2);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void processQualifierForUnitClock(final fr.supelec.tesl.core.Clock<Unit> clock, final ClockQualifier pq) {
    if (pq instanceof PeriodicQualifier) {
      _processQualifierForUnitClock(clock, (PeriodicQualifier)pq);
      return;
    } else if (pq instanceof SporadicQualifier) {
      _processQualifierForUnitClock(clock, (SporadicQualifier)pq);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(clock, pq).toString());
    }
  }
  
  public void processQualifierForIntClock(final fr.supelec.tesl.core.Clock<BigInteger> clock, final ClockQualifier pq) {
    if (pq instanceof PeriodicQualifier) {
      _processQualifierForIntClock(clock, (PeriodicQualifier)pq);
      return;
    } else if (pq instanceof SporadicQualifier) {
      _processQualifierForIntClock(clock, (SporadicQualifier)pq);
      return;
    } else if (pq != null) {
      _processQualifierForIntClock(clock, pq);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(clock, pq).toString());
    }
  }
  
  public void processQualifierForDecClock(final fr.supelec.tesl.core.Clock<BigDecimal> clock, final ClockQualifier pq) {
    if (pq instanceof PeriodicQualifier) {
      _processQualifierForDecClock(clock, (PeriodicQualifier)pq);
      return;
    } else if (pq instanceof SporadicQualifier) {
      _processQualifierForDecClock(clock, (SporadicQualifier)pq);
      return;
    } else if (pq != null) {
      _processQualifierForDecClock(clock, pq);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(clock, pq).toString());
    }
  }
  
  public void processQualifierForRatClock(final fr.supelec.tesl.core.Clock<Rational> clock, final ClockQualifier pq) {
    if (pq instanceof PeriodicQualifier) {
      _processQualifierForRatClock(clock, (PeriodicQualifier)pq);
      return;
    } else if (pq instanceof SporadicQualifier) {
      _processQualifierForRatClock(clock, (SporadicQualifier)pq);
      return;
    } else if (pq != null) {
      _processQualifierForRatClock(clock, pq);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(clock, pq).toString());
    }
  }
  
  public void processQualifierForFloatClock(final fr.supelec.tesl.core.Clock<Double> clock, final ClockQualifier pq) {
    if (pq instanceof PeriodicQualifier) {
      _processQualifierForFloatClock(clock, (PeriodicQualifier)pq);
      return;
    } else if (pq instanceof SporadicQualifier) {
      _processQualifierForFloatClock(clock, (SporadicQualifier)pq);
      return;
    } else if (pq != null) {
      _processQualifierForFloatClock(clock, pq);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(clock, pq).toString());
    }
  }
}

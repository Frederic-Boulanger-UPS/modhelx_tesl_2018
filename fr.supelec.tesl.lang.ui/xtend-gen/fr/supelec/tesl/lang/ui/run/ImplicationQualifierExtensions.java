package fr.supelec.tesl.lang.ui.run;

import com.google.common.base.Objects;
import fr.supelec.tesl.core.Clock;
import fr.supelec.tesl.core.Rational;
import fr.supelec.tesl.core.TimeDelayedImplication;
import fr.supelec.tesl.lang.tesl.DelayedQualifier;
import fr.supelec.tesl.lang.tesl.EveryQualifier;
import fr.supelec.tesl.lang.tesl.FilteredQualifier;
import fr.supelec.tesl.lang.tesl.ImplicationQualifier;
import fr.supelec.tesl.lang.tesl.NextQualifier;
import fr.supelec.tesl.lang.tesl.Pattern;
import fr.supelec.tesl.lang.tesl.SustainedQualifier;
import fr.supelec.tesl.lang.tesl.TimeDelayedQualifier;
import fr.supelec.tesl.lang.tesl.Type;
import fr.supelec.tesl.lang.tesl.Value;
import fr.supelec.tesl.lang.tesl.WhenQualifier;
import fr.supelec.tesl.lang.ui.run.ExtensionWithExpressions;
import fr.supelec.tesl.lang.ui.run.TESLSpec;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class ImplicationQualifierExtensions extends ExtensionWithExpressions {
  public ImplicationQualifierExtensions(final TESLSpec spec) {
    super(spec);
  }
  
  protected void _process(final DelayedQualifier dq, final Clock<?> source, final Clock<?> target) {
    try {
      final Clock<?> delayClock = this.getSpec().getClock(dq.getClock().getName());
      final Value countValue = this.exprExt.evaluate(dq.getCount());
      int count = this.exprExt.intValue(countValue, dq, "delay value");
      source.impliesWithDelay_erased(target, delayClock, count, dq.isImmediately(), dq.isReset());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void _process(final SustainedQualifier sq, final Clock<? extends Comparable<?>> source, final Clock<? extends Comparable<?>> target) {
    final Clock<?> startClock = this.getSpec().getClock(sq.getStartClock().getName());
    final Clock<?> stopClock = this.getSpec().getClock(sq.getEndClock().getName());
    final boolean immediately = sq.isImmediately();
    final boolean weakly = sq.isWeakly();
    source.sustains_erased(target, startClock, stopClock, immediately, weakly);
  }
  
  protected void _process(final FilteredQualifier fq, final Clock<? extends Comparable<?>> source, final Clock<? extends Comparable<?>> target) {
    try {
      final Pattern p = fq.getPattern();
      int skip = 0;
      int keep = 0;
      int repSkip = 0;
      int repKeep = 0;
      final Value skipVal = this.exprExt.evaluate(p.getSkip());
      final Value keepVal = this.exprExt.evaluate(p.getKeep());
      final Value repSkipVal = this.exprExt.evaluate(p.getRepskip());
      final Value repKeepVal = this.exprExt.evaluate(p.getRepkeep());
      skip = this.exprExt.intValue(skipVal, fq, "skip value in filtered implication");
      keep = this.exprExt.intValue(keepVal, fq, "keep value in filtered implication");
      boolean _isRep = p.isRep();
      if (_isRep) {
        repSkip = this.exprExt.intValue(repSkipVal, fq, "repeating skip value in filtered implication");
        repKeep = this.exprExt.intValue(repKeepVal, fq, "repeating keep value in filtered implication");
      }
      source.impliesThroughFilter_erased(target, skip, keep, repSkip, repKeep);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void _process(final EveryQualifier evq, final Clock<? extends Comparable<?>> source, final Clock<? extends Comparable<?>> target) {
    try {
      int skip = 0;
      int keep = 1;
      int repSkip = 0;
      int repKeep = 1;
      final Value period = this.exprExt.evaluate(evq.getPeriod());
      int _intValue = this.exprExt.intValue(period, evq, "period");
      int _minus = (_intValue - 1);
      repSkip = _minus;
      if ((repSkip < 0)) {
        this.getSpec().reportError(evq, ("Period must be at least 1. Found: " + period));
      }
      boolean _isOff = evq.isOff();
      if (_isOff) {
        final Value offset = this.exprExt.evaluate(evq.getOffset());
        skip = this.exprExt.intValue(offset, evq, "offset");
      }
      source.impliesThroughFilter_erased(target, skip, keep, repSkip, repKeep);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void _process(final TimeDelayedQualifier tdq, final Clock<?> source, final Clock<?> target) {
    try {
      final Clock<?> measuring = this.getSpec().getClock(tdq.getClock().getName());
      final Value delay = this.exprExt.evaluate(tdq.getDelay());
      final Type clockType = tdq.getClock().getType();
      final boolean immediateReset = tdq.isImmReset();
      final boolean strongReset = tdq.isStrongReset();
      Clock<?> _xifexpression = null;
      boolean _isReset = tdq.isReset();
      if (_isReset) {
        _xifexpression = this.getSpec().getClock(tdq.getResetClock().getName());
      } else {
        _xifexpression = ((Clock<? extends Comparable<?>>) null);
      }
      final Clock<?> resetClock = _xifexpression;
      TimeDelayedImplication<?, ? extends Comparable<?>, ?, ?> tdImplication = null;
      if (clockType != null) {
        switch (clockType) {
          case TUNIT:
            this.getSpec().reportError(tdq, "Cannot measure a delay on a unit clock");
            break;
          case TINT:
            final BigInteger int_delay = this.exprExt.bigIntegerValue(delay, tdq, "measuring a delay on an int clock");
            tdImplication = source.<BigInteger>impliesWithTimeDelay_erased(resetClock, target, ((Clock<BigInteger>) measuring), int_delay, true);
            break;
          case TDEC:
            final BigDecimal dec_delay = this.exprExt.bigDecimalValue(delay, tdq, "measuring a delay on a decimal clock");
            tdImplication = source.<BigDecimal>impliesWithTimeDelay_erased(resetClock, target, ((Clock<BigDecimal>) measuring), dec_delay, true);
            break;
          case TRAT:
            final Rational rat_delay = this.exprExt.rationalValue(delay, tdq, "measuring a delay on a rational clock");
            tdImplication = source.<Rational>impliesWithTimeDelay_erased(resetClock, target, ((Clock<Rational>) measuring), rat_delay, true);
            break;
          case TFLOAT:
            final double double_delay = this.exprExt.doubleValue(delay, tdq, "measuring a delay on a float clock");
            tdImplication = source.<Double>impliesWithTimeDelay_erased(resetClock, target, ((Clock<Double>) measuring), Double.valueOf(double_delay), true);
            break;
          default:
            this.getSpec().reportError(tdq, ("Unsupported clock type: " + clockType));
            break;
        }
      } else {
        this.getSpec().reportError(tdq, ("Unsupported clock type: " + clockType));
      }
      boolean _notEquals = (!Objects.equal(tdImplication, null));
      if (_notEquals) {
        tdImplication.setImmediateReset(immediateReset);
        tdImplication.setStrongReset(strongReset);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected void _process(final WhenQualifier wq, final Clock<? extends Comparable<?>> source, final Clock<? extends Comparable<?>> target) {
    final Clock<?> when = this.getSpec().getClock(wq.getClock().getName());
    boolean _isNot = wq.isNot();
    if (_isNot) {
      source.impliesWhenNot_erased(when, target);
    } else {
      source.impliesWhen_erased(when, target);
    }
  }
  
  protected void _process(final NextQualifier nq, final Clock<? extends Comparable<?>> source, final Clock<? extends Comparable<?>> target) {
    final Clock<?> nxt = this.getSpec().getClock(nq.getClock().getName());
    boolean _isStrict = nq.isStrict();
    boolean _not = (!_isStrict);
    source.sustains_erased(target, nxt, source, _not, false);
  }
  
  protected void _process(final Void iq, final Clock<? extends Comparable<?>> source, final Clock<? extends Comparable<?>> target) {
    source.implies_erased(target);
  }
  
  protected void _process(final ImplicationQualifier qual, final Clock<? extends Comparable<?>> source, final Clock<? extends Comparable<?>> target) {
    try {
      this.getSpec().reportError(qual, ("Unsupported implication relation qualifier: " + qual));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void process(final ImplicationQualifier dq, final Clock<?> source, final Clock<?> target) {
    if (dq instanceof DelayedQualifier
         && source != null
         && target != null) {
      _process((DelayedQualifier)dq, source, target);
      return;
    } else if (dq instanceof EveryQualifier
         && source != null
         && target != null) {
      _process((EveryQualifier)dq, source, target);
      return;
    } else if (dq instanceof FilteredQualifier
         && source != null
         && target != null) {
      _process((FilteredQualifier)dq, source, target);
      return;
    } else if (dq instanceof NextQualifier
         && source != null
         && target != null) {
      _process((NextQualifier)dq, source, target);
      return;
    } else if (dq instanceof SustainedQualifier
         && source != null
         && target != null) {
      _process((SustainedQualifier)dq, source, target);
      return;
    } else if (dq instanceof TimeDelayedQualifier
         && source != null
         && target != null) {
      _process((TimeDelayedQualifier)dq, source, target);
      return;
    } else if (dq instanceof WhenQualifier
         && source != null
         && target != null) {
      _process((WhenQualifier)dq, source, target);
      return;
    } else if (dq != null
         && source != null
         && target != null) {
      _process(dq, source, target);
      return;
    } else if (dq == null
         && source != null
         && target != null) {
      _process((Void)null, source, target);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(dq, source, target).toString());
    }
  }
}

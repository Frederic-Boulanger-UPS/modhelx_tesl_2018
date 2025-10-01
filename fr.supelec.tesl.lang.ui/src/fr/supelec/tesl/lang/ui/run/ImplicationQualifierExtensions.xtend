package fr.supelec.tesl.lang.ui.run

import fr.supelec.tesl.lang.tesl.DelayedQualifier
import fr.supelec.tesl.core.Clock
import fr.supelec.tesl.core.TimeDelayedImplication
import fr.supelec.tesl.lang.tesl.SustainedQualifier
import fr.supelec.tesl.lang.tesl.FilteredQualifier
import fr.supelec.tesl.lang.tesl.EveryQualifier
import fr.supelec.tesl.lang.tesl.TimeDelayedQualifier
import fr.supelec.tesl.lang.tesl.WhenQualifier
import fr.supelec.tesl.lang.tesl.NextQualifier
import fr.supelec.tesl.lang.tesl.ImplicationQualifier
import java.math.BigInteger
import fr.supelec.tesl.core.Rational
import java.math.BigDecimal

//* Extension methods for tesl.lang.ImplicationQualifier
class ImplicationQualifierExtensions extends ExtensionWithExpressions {
    
    new(TESLSpec spec) {
        super(spec)
    }
    
    def dispatch void process(DelayedQualifier dq, Clock<?> source, Clock<?> target) {
        val Clock<?> delayClock = spec.getClock(dq.getClock().getName());
        val countValue = dq.getCount().evaluate();
        var count = countValue.intValue(dq, "delay value")
        source.impliesWithDelay_erased(target, delayClock, count, dq.isImmediately(), dq.isReset())
    }
    
    def dispatch void process(SustainedQualifier sq, Clock<? extends Comparable<?>> source, Clock<? extends Comparable<?>> target) {
        val startClock = spec.getClock(sq.getStartClock().getName());
        val stopClock = spec.getClock(sq.getEndClock().getName());
        val immediately = sq.isImmediately();
        val weakly = sq.isWeakly();
        source.sustains_erased(target, startClock, stopClock, immediately, weakly)
    }
    
    def dispatch void process(FilteredQualifier fq, Clock<? extends Comparable<?>> source, Clock<? extends Comparable<?>> target) {
        val p = fq.getPattern();
        var skip = 0
        var keep = 0;
        var repSkip = 0
        var repKeep = 0;
        val skipVal = p.getSkip().evaluate();
        val keepVal = p.getKeep().evaluate();
        val repSkipVal = p.getRepskip().evaluate();
        val repKeepVal = p.getRepkeep().evaluate();
        skip = skipVal.intValue(fq, "skip value in filtered implication")
        keep = keepVal.intValue(fq, "keep value in filtered implication")
        if (p.isRep()) {
            repSkip = repSkipVal.intValue(fq, "repeating skip value in filtered implication")
            repKeep = repKeepVal.intValue(fq, "repeating keep value in filtered implication")
        }
        source.impliesThroughFilter_erased(target, skip, keep, repSkip, repKeep)
    }
    def dispatch void process(EveryQualifier evq, Clock<? extends Comparable<?>> source, Clock<? extends Comparable<?>> target) {
        var skip = 0
        var keep = 1
        var repSkip = 0
        var repKeep = 1;
        val period = evq.getPeriod().evaluate();
        repSkip = period.intValue(evq, "period") - 1
        if (repSkip < 0) {
            spec.reportError(evq, "Period must be at least 1. Found: " + period);
        }
        if (evq.isOff()) {
            val offset = evq.getOffset().evaluate();
            skip = offset.intValue(evq, "offset")
        }
        source.impliesThroughFilter_erased(target, skip, keep, repSkip, repKeep)
    }
    def dispatch void process(TimeDelayedQualifier tdq, Clock<?> source, Clock<?> target) {
        val measuring = spec.getClock(tdq.getClock().getName());
        val delay = tdq.getDelay().evaluate();
        val clockType = tdq.getClock().getType();
        val boolean immediateReset = tdq.immReset;
        val boolean strongReset = tdq.strongReset;
        val resetClock = if (tdq.reset) {
        	spec.getClock(tdq.resetClock.name)
        } else {
        	null as Clock<? extends Comparable<?>>;
        }
		var TimeDelayedImplication<?,? extends Comparable<?>,?,?> tdImplication = null 
        switch (clockType) {
            case TUNIT:
                spec.reportError(tdq, "Cannot measure a delay on a unit clock")
            case TINT: {
                val int_delay = delay.bigIntegerValue(tdq, "measuring a delay on an int clock")
                tdImplication = source.impliesWithTimeDelay_erased(resetClock, target, (measuring as Clock<BigInteger>), int_delay, true)
            }
            case TDEC: {
                val dec_delay = delay.bigDecimalValue(tdq, "measuring a delay on a decimal clock")
                tdImplication = source.impliesWithTimeDelay_erased(resetClock, target, (measuring as Clock<BigDecimal>), dec_delay, true)
            }
            case TRAT: {
                val rat_delay = delay.rationalValue(tdq, "measuring a delay on a rational clock")
                tdImplication = source.impliesWithTimeDelay_erased(resetClock, target, (measuring as Clock<Rational>), rat_delay, true)
            }
            case TFLOAT: {
                val double_delay = delay.doubleValue(tdq, "measuring a delay on a float clock")
                tdImplication = source.impliesWithTimeDelay_erased(resetClock, target, (measuring as Clock<Double>), double_delay, true)
            }
            default:
                spec.reportError(tdq, "Unsupported clock type: " + clockType)
        }
        if (tdImplication != null) {
        	tdImplication.setImmediateReset(immediateReset)
        	tdImplication.setStrongReset(strongReset)
        }
    }
    
    def dispatch void process(WhenQualifier wq, Clock<? extends Comparable<?>> source, Clock<? extends Comparable<?>> target) {
        val when = spec.getClock(wq.getClock().getName());
        if (wq.isNot()) {
            source.impliesWhenNot_erased(when, target)
        } else {
            source.impliesWhen_erased(when, target)
        }
    }
    
    def dispatch void process(NextQualifier nq, Clock<? extends Comparable<?>> source, Clock<? extends Comparable<?>> target) {
        // a next to b = a sustained immediately from b to a
        // a strictly next to b = a sustained from b to a
        val nxt = spec.getClock(nq.getClock().getName());
        source.sustains_erased(target, nxt, source, ! nq.isStrict(), false)
    }
    
    def dispatch void process(Void iq, Clock<? extends Comparable<?>> source, Clock<? extends Comparable<?>> target) {
        source.implies_erased(target)
    }
    
    def dispatch void process(ImplicationQualifier qual, Clock<? extends Comparable<?>> source, Clock<? extends Comparable<?>> target) {
        spec.reportError(qual, "Unsupported implication relation qualifier: " + qual)
    }
}
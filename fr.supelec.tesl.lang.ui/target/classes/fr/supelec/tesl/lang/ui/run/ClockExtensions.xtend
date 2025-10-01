package fr.supelec.tesl.lang.ui.run

import fr.supelec.tesl.core.BigIntegerCalc
import fr.supelec.tesl.core.Clock
import fr.supelec.tesl.core.Rational
import fr.supelec.tesl.core.RationalCalc
import fr.supelec.tesl.core.Unit
import fr.supelec.tesl.core.UnitCalc
import fr.supelec.tesl.lang.tesl.ClockQualifier
import fr.supelec.tesl.lang.tesl.Expression
import fr.supelec.tesl.lang.tesl.PeriodicQualifier
import fr.supelec.tesl.lang.tesl.SporadicQualifier
import java.math.BigInteger
import org.eclipse.core.runtime.Assert

import static fr.supelec.tesl.lang.tesl.Type.*
import java.math.BigDecimal
import fr.supelec.tesl.core.BigDecimalCalc
import fr.supelec.tesl.core.RoundDouble

//* Extension methods for tesl.lang.Clock 
class ClockExtensions  extends ExtensionWithExpressions {
    new (TESLSpec spec) {
        super(spec)
    }

    //* Process a clock declaration
    def void process(fr.supelec.tesl.lang.tesl.Clock c) {
        var clock = null as Clock<? extends Comparable<?>>;
        val type = c.getType();
        val name = c.getName();

        switch(type) {
            case TUNIT:
                clock = Clock.createClock(Unit, name, new UnitCalc())
            case TINT:
                clock = Clock.createClock(BigInteger, name, new BigIntegerCalc())
            case TDEC:
                clock = Clock.createClock(BigDecimal, name, new BigDecimalCalc())
            case TRAT:
                clock = Clock.createClock(Rational, name, new RationalCalc())
            case TFLOAT:
                clock = Clock.createClock(Double, name, new RoundDouble())
            default:
                spec.reportError(c, "Unsupported clock type: " + type)
        }

        Assert::isNotNull(clock)

        spec.addClock(name, clock)

        // explore the qualifier
        val qual = c.getQual();

        if (qual != null) {
            switch (type) {
                case TUNIT:
                    processQualifierForUnitClock(clock as Clock<Unit>, qual)
//                    spec.reportError(qual, "Unhandled qualifier for unit clock " + name + ": " + qual)
                case TINT:
                    processQualifierForIntClock(clock as Clock<BigInteger>, qual)
                case TDEC:
                    processQualifierForDecClock(clock as Clock<BigDecimal>, qual)
                case TRAT:
                    processQualifierForRatClock(clock as Clock<Rational>, qual)
                case TFLOAT:
                    processQualifierForFloatClock(clock as Clock<Double>, qual)
            }
        }

        if (c.isNongreedy()) {
            clock.setGreedy(false);
        }
    }
    
    // Process sporadic qualifiers
    def dispatch void processQualifierForUnitClock(Clock<Unit> clock, SporadicQualifier sq) {
        if (! sq.instants.empty) {
            spec.reportError(sq, "A sporadic unit-clock qualifier may not specify tags")
        }
        clock.newTick()
    }
    def dispatch void processQualifierForIntClock(Clock<BigInteger> clock, SporadicQualifier sq) {
        if (sq.instants.empty) {
            spec.reportError(sq, "A sporadic clock qualifier should specify at least one tag")
        }
        for(Expression date : sq.getInstants()) {
            val dateValue = date.evaluate();
            val tag = dateValue.bigIntegerValue(sq, "sporadic qualifier of an int clock")
            clock.newTick(tag)
        }
    }
    def dispatch void processQualifierForDecClock(Clock<BigDecimal> clock, SporadicQualifier sq) {
        if (sq.instants.empty) {
            spec.reportError(sq, "A sporadic clock qualifier should specify at least one tag")
        }
        for(Expression date : sq.getInstants()) {
            val dateValue = date.evaluate();
            val tag = dateValue.bigDecimalValue(sq, "sporadic qualifier of a decimal clock")
            clock.newTick(tag)
        }
    }
    def dispatch void processQualifierForRatClock(Clock<Rational> clock, SporadicQualifier sq) {
        if (sq.instants.empty) {
            spec.reportError(sq, "A sporadic clock qualifier should specify at least one tag")
        }
        for(Expression date : sq.getInstants()) {
            val dateValue = date.evaluate();
            val tag = dateValue.rationalValue(sq, "sporadic qualifier of a rational clock")
            clock.newTick(tag)
        }
    }
    def dispatch void processQualifierForFloatClock(Clock<Double> clock, SporadicQualifier sq) {
        if (sq.instants.empty) {
            spec.reportError(sq, "A sporadic clock qualifier should specify at least one tag")
        }
        for(Expression date : sq.getInstants()) {
            val dateValue = date.evaluate();
            val tag = dateValue.doubleValue(sq, "sporadic qualifier of a double clock")
            clock.newTick(tag)
        }
    }

    // Process periodic qualifiers
    def dispatch void processQualifierForUnitClock(Clock<Unit> clock, PeriodicQualifier pq) {
        spec.reportError(pq, "A unit-clock cannot be periodic")
    }
    def dispatch void processQualifierForIntClock(Clock<BigInteger> clock, PeriodicQualifier pq) {
            val period = pq.getPeriod().evaluate();
            val offset = pq.getOffset().evaluate();
            val iperiod = period.bigIntegerValue(pq, "period of an int clock")
            clock.impliesWithTimeDelay(clock, clock, iperiod, false)
            var ioffset = BigInteger.ZERO
            if (offset != null) {
                ioffset = offset.bigIntegerValue(pq, "offset of an int clock")
            }
            clock.newTick(ioffset)
    }
    def dispatch void processQualifierForDecClock(Clock<BigDecimal> clock, PeriodicQualifier pq) {
            val period = pq.getPeriod().evaluate();
            val offset = pq.getOffset().evaluate();
            val iperiod = period.bigDecimalValue(pq, "period of a decimal clock")
            clock.impliesWithTimeDelay(clock, clock, iperiod, false)
            var ioffset = BigDecimal.ZERO
            if (offset != null) {
                ioffset = offset.bigDecimalValue(pq, "offset of a decimalclock")
            }
            clock.newTick(ioffset)
    }
    def dispatch void processQualifierForRatClock(Clock<Rational> clock, PeriodicQualifier pq) {
            val period = pq.getPeriod().evaluate();
            val offset = pq.getOffset().evaluate();
            val fperiod = period.rationalValue(pq, "period of a rational clock")
            clock.impliesWithTimeDelay(clock, clock, fperiod, false)
            var foffset = new Rational(0)
            if (offset != null) {
                foffset = offset.rationalValue(pq, "offset of a rational clock")
            }
            clock.newTick(foffset)
    }
    def dispatch void processQualifierForFloatClock(Clock<Double> clock, PeriodicQualifier pq) {
            val period = pq.getPeriod().evaluate();
            val offset = pq.getOffset().evaluate();
            val fperiod = period.doubleValue(pq, "period of a float clock")
            clock.impliesWithTimeDelay(clock, clock, fperiod, false)
            var foffset = 0.0
            if (offset != null) {
                foffset = offset.doubleValue(pq, "offset of a float clock")
            }
            clock.newTick(foffset)
    }
    
    // Fallback for unsupported qualifiers
    def dispatch void processQualifierForIntClock(Clock<BigInteger> clock, ClockQualifier qual) {
        spec.reportError(qual, "Unhandled qualifier for int clock " + clock.name + ": " + qual)
    }
    def dispatch void processQualifierForDecClock(Clock<BigDecimal> clock, ClockQualifier qual) {
        spec.reportError(qual, "Unhandled qualifier for decimal clock " + clock.name + ": " + qual)
    }
    def dispatch void processQualifierForRatClock(Clock<Rational> clock, ClockQualifier qual) {
        spec.reportError(qual, "Unhandled qualifier for rational clock " + clock.name + ": " + qual)
    }
    def dispatch void processQualifierForFloatClock(Clock<Double> clock, ClockQualifier qual) {
        spec.reportError(qual, "Unhandled qualifier for float clock " + clock.name + ": " + qual)
    }
}


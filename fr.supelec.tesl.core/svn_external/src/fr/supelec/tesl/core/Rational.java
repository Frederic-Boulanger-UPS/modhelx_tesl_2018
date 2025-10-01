package fr.supelec.tesl.core;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * A Rational represents a rational value as the quotient of two BigIntegers.
 * @author frederic.boulanger@supelec.fr
 *
 */
public class Rational extends Number implements Comparable<Rational> {
    private static final long serialVersionUID = -5317233889388914236L;
    private BigInteger numerator_;
    private BigInteger denominator_;
    public static Rational ZERO = new Rational(0);
    public static Rational ONE = new Rational(1);

    //@ Build a rational equal to 0
    public Rational() {
        this(0);
    }

    //@ Build a rational equal to value
    public Rational(long value) {
        this(BigInteger.valueOf(value));
    }

    //@ Build a rational equal to value
    public Rational(BigDecimal value) {
        this(value.unscaledValue(), BigInteger.valueOf(10).pow(value.scale()));
    }

    //@ Build a rational equal to value
    public Rational(double value) {
        this(BigDecimal.valueOf(value));
    }

    //@ Build a rational equal to value
    public Rational(BigInteger value) {
        this(value, BigInteger.valueOf(1));
    }

    //@ Build a rational equal to num/den
    public Rational(long num, long den) {
        this(BigInteger.valueOf(num), BigInteger.valueOf(den));
    }

    //@ Build a rational equal to num/den
    public Rational(BigInteger num, BigInteger den) {
        this.numerator_ = num;
        this.denominator_ = den;
        normalize();
    }

    //@ ensure the numerator and denominator have no common divisor
    private void normalize() {
        // Denominator should be positive
        if (this.denominator_.signum() < 0) {
            this.denominator_ = this.denominator_.negate();
            this.numerator_ = this.numerator_.negate();
        }
        // Denominator and numerator should have no common divisor 
        BigInteger gcd = this.numerator_.gcd(this.denominator_);
        this.numerator_ = this.numerator_.divide(gcd);
        this.denominator_ = this.denominator_.divide(gcd);
    }

    public BigInteger getNumerator() {
        return this.numerator_;
    }

    public BigInteger getDenominator() {
        return this.denominator_;
    }

    public Rational add(Rational r) {
        return new Rational(
                this.numerator_.multiply(r.denominator_).add(this.denominator_.multiply(r.numerator_)),
                this.denominator_.multiply(r.denominator_)
                );
    }

    public Rational subtract(Rational r) {
        return new Rational(
                this.numerator_.multiply(r.denominator_).subtract(this.denominator_.multiply(r.numerator_)),
                this.denominator_.multiply(r.denominator_)
                );
    }

    public Rational multiply(Rational r) {
        return new Rational(
                this.numerator_.multiply(r.numerator_),
                this.denominator_.multiply(r.denominator_)
                );
    }

    public Rational divide(Rational r) {
        return new Rational(
                this.numerator_.multiply(r.denominator_),
                this.denominator_.multiply(r.numerator_)
                );
    }

    public Rational invert() {
        return new Rational(this.denominator_, this.numerator_);
    }

    public Rational negate() {
        return new Rational(this.denominator_.negate(), this.numerator_);
    }

    public BigDecimal bigDecimalValue() {
        return new BigDecimal(this.numerator_).divide(new BigDecimal(this.denominator_));
    }

    @Override
    public double doubleValue() {
        return this.bigDecimalValue().doubleValue();
    }

    @Override
    public float floatValue() {
        return this.bigDecimalValue().floatValue();
    }

    public BigInteger bigIntegerValue() {
        return this.numerator_.divide(this.denominator_);
    }
    
    @Override
    public long longValue() {
        return this.bigIntegerValue().longValue();
    }

    public long longValueExact() {
        return this.bigDecimalValue().longValueExact();
    }

    @Override
    public int intValue() {
        return this.bigIntegerValue().intValue();
    }

    public int intValueExact() {
        return this.bigDecimalValue().intValueExact();
    }

    @Override
    public short shortValue() {
        return this.bigIntegerValue().shortValue();
    }

    public short shortValueExact() {
        return this.bigDecimalValue().shortValueExact();
    }

    @Override
    public byte byteValue() {
        return this.bigIntegerValue().byteValue();
    }

    public byte byteValueExact() {
        return this.bigDecimalValue().byteValueExact();
    }

    /**
     * Return the factor by which the denominator should by multiplied to make the rational 
     * in the form a/10^k, or null if the rational is not decimal.
     */
    public BigInteger getDecimalFactor() {
        BigInteger TWO = BigInteger.valueOf(2);
        BigInteger FIVE = BigInteger.valueOf(5);
        BigInteger TEN = BigInteger.valueOf(10);
        BigInteger quot_rem[] = {};
        BigInteger quot = this.denominator_;
        BigInteger fact = BigInteger.ONE;
        BigInteger test[] = {TEN, FIVE, TWO};
        BigInteger testcomp[] = {BigInteger.ONE, TWO, FIVE};
        for (int i = 0; i < 3; i++) {
            do {
                quot_rem = quot.divideAndRemainder(test[i]);
                if (quot_rem[1].equals(BigInteger.ZERO)) {
                    quot = quot_rem[0];
                    fact = fact.multiply(testcomp[i]);
                } else {
                    break;
                }
            } while (true);
        }
        if (quot_rem[0].equals(BigInteger.ZERO) && quot_rem[1].equals(BigInteger.ONE)) {
            return fact;
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        BigInteger fact = getDecimalFactor();
        BigInteger TEN = BigInteger.valueOf(10);
        if (fact == null) {
            return this.numerator_.toString() + "/" + this.denominator_.toString();
        } else {
            BigInteger mantissa = this.numerator_.multiply(fact);
            int sign = mantissa.signum();
            if (sign < 0) {
                mantissa = mantissa.negate();
            }
            BigInteger ten_pow = this.denominator_.multiply(fact);
            int scale = 0;
            while (!ten_pow.equals(BigInteger.ONE)) {
                ten_pow = ten_pow.divide(TEN);
                scale++;
            }
            String m = mantissa.toString();
            if (scale > 0) {
                if (scale >= m.length()) {
                    StringBuilder builder;
                    if (sign < 0) {
                        builder = new StringBuilder("-0.");
                    } else {
                        builder = new StringBuilder("0.");
                    }
                    while (scale > m.length()) {
                        builder.append("0");
                        scale--;
                    }
                    builder.append(m);
                    return builder.toString();
                } else {
                    if (sign < 0) {
                        return "-" + m.substring(0, m.length() - scale) + "." + m.substring(scale);
                    } else {
                        return m.substring(0, m.length() - scale) + "." + m.substring(scale);
                    }
                }
            } else {
                if (sign < 0) {
                    return "-" + m;
                } else {
                    return m;
                }
            }
        }
        //        BigDecimal quotient = null;
        //        try {
        //            quotient = new BigDecimal(this.numerator_).divide(new BigDecimal(this.numerator_));
        //        } catch (ArithmeticException e) {
        //            return this.numerator_.toString() + "/" + this.denominator_.toString();
        //        }
        //        return quotient.toString();
    }

    public String toStringRaw() {
        return this.numerator_.toString() + "/" + this.denominator_.toString();
    }

    @Override
    public int compareTo(Rational o) {
        return this.numerator_.multiply(o.denominator_).subtract(this.denominator_.multiply(o.numerator_)).signum();
    }
    
    @Override
	public int hashCode() {
		final int prime = 31;
		// numerator_ and denominator_ are never null
		return numerator_.hashCode() + prime * denominator_.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Rational)) {
			return false;
		}
		Rational other = (Rational) obj;
		// Rationals are in normalized form, so we just have to compare their numerator and denominator
		return (other.numerator_.equals(numerator_) && other.denominator_.equals(denominator_));
	}
}

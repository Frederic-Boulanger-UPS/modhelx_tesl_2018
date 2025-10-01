/*
 * This file is part of TESL.
 *
 * TESL is free software: you can redistribute it and/or modify
 * it under the terms of the Eclipse Public License 1.0
 *
 * TESL is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 *
 * You should have received a copy of the Eclipse Public License
 * along with TESL. If not, see <http://opensource.org/licenses/EPL-1.0>.
 * 
 * Copyright Supélec, Department of Computer Science, 2013
 * http://wwwdi.supelec.fr/software
 * 
 */

package fr.supelec.tesl.core;

import java.math.BigInteger;

/**
 * A tag calculus on Rationals
 * 
 * @author frederic.boulanger@supelec.fr
 *
 */
public class RationalCalc implements TagCalculus<Rational> {
	static {
		TagCalculusFactory.registerCalculus(Rational.class, new RationalCalc());
	}

    @Override
    public Rational add(Rational a, Rational b) {
        return do_add(a, b);
    }
    
    public static Rational do_add(Rational a, Rational b) {
        return a.add(b);
    }

    @Override
    public Rational subtract(Rational a, Rational b) {
        return do_subtract(a, b);
    }
    
    public static Rational do_subtract(Rational a, Rational b) {
        return a.subtract(b);
    }

    @Override
    public Rational multiply(Rational a, Rational b) {
        return do_multiply(a, b);
    }
    
    public static Rational do_multiply(Rational a, Rational b) {
        return a.multiply(b);
    }

    @Override
    public Rational divide(Rational a, Rational b) {
        return do_divide(a, b);
    }
    
    public static Rational do_divide(Rational a, Rational b) {
        return a.divide(b);
    }

	@Override
	public boolean isZero(Rational a) {
		return a.equals(Rational.ZERO);
	}

	@Override
	public boolean isOne(Rational a) {
		return a.equals(Rational.ONE);
	}

	@Override
	public Rational power(Rational a, int n) {
		return do_power(a, n);
	}
	
	public static Rational do_power(Rational a, int n) {
		TagCalculus<BigInteger> bigcalc = TagCalculusFactory.getCalculus(BigInteger.class);
		return new Rational(bigcalc.power(a.getNumerator(), n), bigcalc.power(a.getDenominator(), n));
	}

	@Override
	public Rational root(Rational a, int n) {
		return do_root(a, n);
	}

	public static Rational do_root(Rational a, int n) {
		TagCalculus<BigInteger> bigcalc = TagCalculusFactory.getCalculus(BigInteger.class);
		return new Rational(bigcalc.root(a.getNumerator(), n), bigcalc.root(a.getDenominator(), n));
	}
}

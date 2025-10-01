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
 * A tag calculus on BigIntegers
 * 
 * @author frederic.boulanger@supelec.fr
 *
 */
public class BigIntegerCalc implements TagCalculus<BigInteger> {
	static {
		TagCalculusFactory.registerCalculus(BigInteger.class, new BigIntegerCalc());
	}

	@Override
    public BigInteger add(BigInteger a, BigInteger b) {
        return do_add(a, b);
    }
    
    public static BigInteger do_add(BigInteger a, BigInteger b) {
        return a.add(b);
    }

    @Override
    public BigInteger subtract(BigInteger a, BigInteger b) {
        return do_subtract(a, b);
    }
    
    public static BigInteger do_subtract(BigInteger a, BigInteger b) {
        return a.subtract(b);
    }

    @Override
    public BigInteger multiply(BigInteger a, BigInteger b) {
        return do_multiply(a, b);
    }
    
    public static BigInteger do_multiply(BigInteger a, BigInteger b) {
        return a.multiply(b);
    }

    @Override
    public BigInteger divide(BigInteger a, BigInteger b) {
        return do_divide(a, b);
    }
    
    public static BigInteger do_divide(BigInteger a, BigInteger b) {
        return a.divide(b);
    }

	@Override
	public boolean isZero(BigInteger a) {
		return a.equals(BigInteger.ZERO);
	}

	@Override
	public boolean isOne(BigInteger a) {
		return a.equals(BigInteger.ONE);
	}

	@Override
	public BigInteger power(BigInteger a, int n) {
		return do_power(a, n);
	}
	
	public static BigInteger do_power(BigInteger a, int n) {
		return a.pow(n);
	}

	@Override
	public BigInteger root(BigInteger a, int n) {
		return do_root(a, n);
	}
	
	public static BigInteger do_root(BigInteger a, int n) {
		if (n <= 0) {
			throw new IllegalArgumentException("Negative or null root power");
		}
		if (n == 1) {
			return a;
		}
		if (a == BigInteger.ZERO) {
			return a;
		}
		// Newton's method for finding the greatest BigInteger whose nth power is less than a
		BigInteger p = BigInteger.valueOf(n);
		BigInteger p1 = BigInteger.valueOf(n-1);
		BigInteger s = a.add(BigInteger.ONE);
		BigInteger x = a;
		while (x.compareTo(s) < 0) {
			s = x;
			x = x.multiply(p1).add(a.divide(x.pow(n-1))).divide(p);
		}
		
		return s;
	}
}

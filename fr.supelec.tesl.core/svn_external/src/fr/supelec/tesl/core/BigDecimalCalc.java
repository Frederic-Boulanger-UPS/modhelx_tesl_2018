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

import java.math.BigDecimal;

/**
 * A tag calculus on BigDecimals
 * 
 * @author frederic.boulanger@supelec.fr
 *
 */
public class BigDecimalCalc implements TagCalculus<BigDecimal> {
	static {
		TagCalculusFactory.registerCalculus(BigDecimal.class, new BigDecimalCalc());
	}
	
    @Override
    public BigDecimal add(BigDecimal a, BigDecimal b) {
        return do_add(a, b);
    }
    
    public static BigDecimal do_add(BigDecimal a, BigDecimal b) {
        return a.add(b);
    }

    @Override
    public BigDecimal subtract(BigDecimal a, BigDecimal b) {
        return do_subtract(a, b);
    }
    
    public static BigDecimal do_subtract(BigDecimal a, BigDecimal b) {
        return a.subtract(b);
    }

    @Override
    public BigDecimal multiply(BigDecimal a, BigDecimal b) {
        return do_multiply(a, b);
    }
    
    public static BigDecimal do_multiply(BigDecimal a, BigDecimal b) {
        return a.multiply(b);
    }

    @Override
    public BigDecimal divide(BigDecimal a, BigDecimal b) {
        return do_divide(a, b);
    }
    
    public static BigDecimal do_divide(BigDecimal a, BigDecimal b) {
        return a.divide(b);
    }

	@Override
	public boolean isZero(BigDecimal a) {
		return a.equals(BigDecimal.ZERO);
	}

	@Override
	public boolean isOne(BigDecimal a) {
		return a.equals(BigDecimal.ONE);
	}

	@Override
	public BigDecimal power(BigDecimal a, int n) {
		return do_power(a, n);
	}
	
	public static BigDecimal do_power(BigDecimal a, int n) {
		if (n < 0) {
			throw new IllegalArgumentException("Negative power");
		}
		if (n == 0) {
			return BigDecimal.ONE;
		}
		int p = n;
		BigDecimal r = a;
		while (p != 1) {
			r = r.multiply(r);
			if (p % 2 == 0) {
				p /= 2;
			} else {
				p--;
				p /= 2;
				r = r.multiply(a);
			}
		}
		return r;
	}

	@Override
	public BigDecimal root(BigDecimal a, int n) {
		return do_root(a, n);
	}
	
	public static BigDecimal do_root(BigDecimal a, int n) {
		throw new UnsupportedOperationException("nth root of a BigDecimal");
	}
}

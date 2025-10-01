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

/**
 * A tag calculus on integers which uses the regular int operators
 * 
 * @author frederic.boulanger@supelec.fr
 *
 */
public class LongCalc implements TagCalculus<Long> {
	static {
		TagCalculusFactory.registerCalculus(Long.class, new LongCalc());
	}

    @Override
    public Long add(Long a, Long b) {
        return do_add(a, b);
    }
    
    public static Long do_add(Long a, Long b) {
        return a.longValue() + b.longValue();
    }

    @Override
    public Long subtract(Long a, Long b) {
        return do_subtract(a, b);
    }
    
    public static Long do_subtract(Long a, Long b) {
        return a.longValue() - b.longValue();
    }

    @Override
    public Long multiply(Long a, Long b) {
        return do_multiply(a, b);
    }
    
    public static Long do_multiply(Long a, Long b) {
        return a.longValue() * b.longValue();
    }

    @Override
    public Long divide(Long a, Long b) {
        return do_divide(a, b);
    }
    
    public static Long do_divide(Long a, Long b) {
        return a.longValue() / b.longValue();
    }

	@Override
	public boolean isZero(Long a) {
		return a.equals(0L);
	}

	@Override
	public boolean isOne(Long a) {
		return a.equals(1L);
	}

	@Override
	public Long power(Long a, int n) {
		return do_power(a, n);
	}
	public static Long do_power(Long a, int n) {
		return (long) Math.pow(a, n);
	}

	@Override
	public Long root(Long a, int n) {
		return do_root(a, n);
	}
	public static Long do_root(Long a, int n) {
		if (n <= 0) {
			throw new IllegalArgumentException("Negative or null root power");
		}
		if (n == 1) {
			return a;
		}
		// Newton's method for finding the greatest int whose nth power is less than a
		int p = n;
		int p1 = n - 1;
		long s = a + 1;
		long x = a;
		while (x < s) {
			s = x;
			x = (x * p1 + (a / (long)(Math.pow(x, p1)))) / p;
		}
		
		return s;
	}
}

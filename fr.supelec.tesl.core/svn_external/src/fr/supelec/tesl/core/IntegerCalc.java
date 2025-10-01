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
public class IntegerCalc implements TagCalculus<Integer> {
	static {
		TagCalculusFactory.registerCalculus(Integer.class, new IntegerCalc());
	}

    @Override
    public Integer add(Integer a, Integer b) {
        return do_add(a, b);
    }
    
    public static Integer do_add(Integer a, Integer b) {
        return a.intValue() + b.intValue();
    }

    @Override
    public Integer subtract(Integer a, Integer b) {
        return do_subtract(a, b);
    }
    
    public static Integer do_subtract(Integer a, Integer b) {
        return a.intValue() - b.intValue();
    }

    @Override
    public Integer multiply(Integer a, Integer b) {
        return do_multiply(a, b);
    }
    
    public static Integer do_multiply(Integer a, Integer b) {
        return a.intValue() * b.intValue();
    }

    @Override
    public Integer divide(Integer a, Integer b) {
        return do_divide(a, b);
    }
    
    public static Integer do_divide(Integer a, Integer b) {
        return a.intValue() / b.intValue();
    }

	@Override
	public boolean isZero(Integer a) {
		return a.equals(0);
	}

	@Override
	public boolean isOne(Integer a) {
		return a.equals(1);
	}

	@Override
	public Integer power(Integer a, int n) {
		return do_power(a, n);
	}
	
	public static Integer do_power(Integer a, int n) {
		return (int) Math.pow(a, n);
	}

	@Override
	public Integer root(Integer a, int n) {
		return do_root(a, n);
	}
	public static Integer do_root(Integer a, int n) {
		if (n <= 0) {
			throw new IllegalArgumentException("Negative or null root power");
		}
		if (n == 1) {
			return a;
		}
		if (a == 0) {
			return 0;
		}
		// Newton's method for finding the greatest int whose nth power is less than a
		int p = n;
		int p1 = n - 1;
		int s = a + 1;
		int x = a;
		while (x < s) {
			s = x;
			x = (x * p1 + (a / (int)(Math.pow(x, p1)))) / p;
		}
		
		return s;
	}
}

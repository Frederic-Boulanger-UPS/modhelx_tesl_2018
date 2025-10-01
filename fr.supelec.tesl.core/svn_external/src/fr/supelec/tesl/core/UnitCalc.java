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
 * A dummy tag calculus on Unit.
 * 
 * @author frederic.boulanger@supelec.fr
 *
 */
public class UnitCalc implements TagCalculus<Unit> {
	static {
		TagCalculusFactory.registerCalculus(Unit.class, new UnitCalc());
	}

    @Override
    public Unit add(Unit a, Unit b) {
        return do_add(a, b);
    }
    
    public static Unit do_add(Unit a, Unit b) {
        return a;
    }

    @Override
    public Unit subtract(Unit a, Unit b) {
        return do_subtract(a, b);
    }
    
    public static Unit do_subtract(Unit a, Unit b) {
        return a;
    }

    @Override
    public Unit multiply(Unit a, Unit b) {
        return do_multiply(a, b);
    }
    
    public static Unit do_multiply(Unit a, Unit b) {
        return a;
    }

    @Override
    public Unit divide(Unit a, Unit b) {
        return do_divide(a, b);
    }
    
    public static Unit do_divide(Unit a, Unit b) {
        return a;
    }

	@Override
	public boolean isZero(Unit a) {
		return false;
	}

	@Override
	public boolean isOne(Unit a) {
		return false;
	}

	@Override
	public Unit power(Unit a, int n) {
		return do_power(a, n);
	}

	public static Unit do_power(Unit a, int n) {
		return a;
	}
	
	@Override
	public Unit root(Unit a, int n) {
		return do_root(a, n);
	}
	
	public static Unit do_root(Unit a, int n) {
		return a;
	}
}

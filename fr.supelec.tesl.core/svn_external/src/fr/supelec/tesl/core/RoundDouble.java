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
 * A tag calculus on doubles which keeps only the 6 first digits after
 * the decimal point and rounds to the nearest value, or down if there
 * is no nearest value.
 * 
 * @author frederic.boulanger@supelec.fr
 *
 */
public class RoundDouble implements TagCalculus<Double> {
	static {
		TagCalculusFactory.registerCalculus(Double.class, new RoundDouble());
	}

    public static final int default_num_digits = 6;
    private static int num_digits_ = default_num_digits;
    public static final int default_rounding_mode = BigDecimal.ROUND_HALF_DOWN;
    private static int rounding_mode_= default_rounding_mode;

    public static void resetDefaults() {
        RoundDouble.num_digits_ = RoundDouble.default_num_digits;
        RoundDouble.rounding_mode_ = RoundDouble.default_rounding_mode;
    }
    
    public static void setNumDigits(int num_digits) {
        RoundDouble.num_digits_ = num_digits;
    }

    public static int getNumDigits() {
        return RoundDouble.num_digits_;
    }
    
    public static void setRoundingMode(int rounding_mode) {
        RoundDouble.rounding_mode_ = rounding_mode;
    }

    public static int getRoundingMode() {
        return RoundDouble.rounding_mode_;
    }
    
    @Override
    public Double add(Double a, Double b) {
        return do_add(a, b);
    }
    
    public static Double do_add(Double a, Double b) {
        return BigDecimal.valueOf(a + b).setScale(num_digits_, rounding_mode_).doubleValue();
    }

    @Override
    public Double subtract(Double a, Double b) {
        return do_subtract(a, b);
    }
    
    public static Double do_subtract(Double a, Double b) {
        return BigDecimal.valueOf(a - b).setScale(num_digits_, rounding_mode_).doubleValue();
    }

    @Override
    public Double multiply(Double a, Double b) {
        return do_multiply(a, b);
    }
    
    public static Double do_multiply(Double a, Double b) {
        return BigDecimal.valueOf(a * b).setScale(num_digits_, rounding_mode_).doubleValue();
    }

    @Override
    public Double divide(Double a, Double b) {
        return do_divide(a, b);
    }
    
    public static Double do_divide(Double a, Double b) {
        return BigDecimal.valueOf(a / b).setScale(num_digits_, rounding_mode_).doubleValue();
    }

	@Override
	public boolean isZero(Double a) {
		return a.equals(0D);
	}

	@Override
	public boolean isOne(Double a) {
		return a.equals(1D);
	}

	@Override
	public Double power(Double a, int n) {
		return do_power(a, n);
	}

	public static Double do_power(Double a, int n) {
		return BigDecimal.valueOf(Math.pow(a, n)).setScale(num_digits_, rounding_mode_).doubleValue();
	}
	
	@Override
	public Double root(Double a, int n) {
		return do_root(a, n);
	}

	public static Double do_root(Double a, int n) {
		return BigDecimal.valueOf(Math.pow(a, 1.0D/n)).setScale(num_digits_, rounding_mode_).doubleValue();
	}
}

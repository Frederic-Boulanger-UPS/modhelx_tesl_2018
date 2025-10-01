package fr.supelec.tesl.lang.ui.run

import fr.supelec.tesl.core.BigDecimalCalc
import fr.supelec.tesl.core.BigIntegerCalc
import fr.supelec.tesl.lang.tesl.BinOp
import fr.supelec.tesl.lang.tesl.Expression
import fr.supelec.tesl.lang.tesl.FloatCast
import fr.supelec.tesl.lang.tesl.FloatValue
import fr.supelec.tesl.lang.tesl.IntCast
import fr.supelec.tesl.lang.tesl.IntegerValue
import fr.supelec.tesl.lang.tesl.LetValue
import fr.supelec.tesl.lang.tesl.Op
import fr.supelec.tesl.lang.tesl.TeslFactory
import fr.supelec.tesl.lang.tesl.Value
import java.math.BigDecimal
import org.eclipse.core.runtime.CoreException

import static fr.supelec.tesl.lang.tesl.Op.*
import java.math.BigInteger
import org.eclipse.emf.ecore.EObject
import fr.supelec.tesl.core.Rational
import fr.supelec.tesl.lang.tesl.RationalValue
import fr.supelec.tesl.lang.tesl.RationalCast
import fr.supelec.tesl.core.RationalCalc
import fr.supelec.tesl.core.RoundDouble
import fr.supelec.tesl.lang.tesl.DecimalValue
import fr.supelec.tesl.lang.tesl.DecimalCast

//* Extension methods for tesl.lang.Expression and Value
class ExpressionExtensions {
    val factory = TeslFactory.eINSTANCE
    val intCalculus = new BigIntegerCalc()
    val decimalCalculus = new BigDecimalCalc()
    val floatCalculus = new RoundDouble()
    val ratCalculus = new RationalCalc()
    val TESLSpec spec
    
    new (TESLSpec spec) {
        this.spec= spec
    }

     /**
     * Evaluate an expression, returning a Value.
     * @param e the expression to evaluate
     * @param infile the file in which the expression appears (for error reporting)
     * @return the value of the expression
     * @throws CoreException
     */
    def dispatch Value evaluate(Expression e) throws CoreException {
        spec.reportError(e, "Unsupported expression type for evaluation: " + e.getClass().getName());
        return null;
    }
    
    //* Handle null Value
    def dispatch Value evaluate(Void e) {
        return null
    }

    def dispatch Value evaluate(LetValue e) {
        val name = e.getRef().getName();
        val letexpr = spec.getLetValue(name);
        if (letexpr == null) {
            spec.reportError(e , "Unknown let definition " + name + " in expression");
            return null;
        }
        val v = letexpr.evaluate();
        if (v != e) {
            spec.setLetValue(name, v);
        }
        return v;
    }
   
    def dispatch Value evaluate(BinOp e) {
        val op = e as BinOp;
        val left = op.getLeft().evaluate()
        val right = op.getRight().evaluate()
        evaluateOperator(left, right, e)
     }
     
    def dispatch Value evaluate(IntegerValue ie) {
        // handle the sign here: if there is a MINUS sign before the number, 
        // then crate a new IntegerValue with the 'value' set accordingly, 
        // and no more sign
        val sign = ie.getSign();
        if(sign == Op.MINUS) {
            val value = factory.createIntegerValue();
            value.setValue(ie.getValue().negate());
            value.setSign(Op.PLUS)
            return value;
        } else {
            return ie;
        }
    }
    
    def dispatch Value evaluate(FloatValue fe) {
        // same strategy as for integers
        val sign = fe.getSign();
        if(sign == Op.MINUS) {
            val value = factory.createFloatValue();
            value.setValue(-fe.getValue());
            value.setSign(Op.PLUS)
            return value;
        } else {
            return fe
        }
    }
    
    def dispatch Value evaluate(DecimalValue de) {
        // same strategy as for integers
        val sign = de.getSign();
        if(sign == Op.MINUS) {
            val value = factory.createDecimalValue();
            value.setValue(de.getValue().negate());
            value.setSign(Op.PLUS)
            return value;
        } else {
            return de
        }
    }
    
    def dispatch Value evaluate(RationalValue re) {
        // same strategy as for integers
        val sign = re.getSign();
        if(sign == Op.MINUS) {
            val value = factory.createRationalValue();
            value.setValue((re.getValue() as Rational).negate());
            value.setSign(Op.PLUS)
            return value;
        } else {
            return re
        }
    }
    
    def dispatch Value evaluate(IntCast ice) {
        // Cast a value to a BigInteger
        var value = ice.getExpr().evaluate()
        if (value instanceof FloatValue) {
            val v = (value as FloatValue).getValue()
            value = factory.createIntegerValue()
            (value as IntegerValue).setValue(BigInteger::valueOf(v as int))
        } else if (value instanceof DecimalValue) {
            val v = (value as DecimalValue).getValue()
            value = factory.createIntegerValue()
            (value as IntegerValue).setValue(v.toBigInteger())
        } else if (value instanceof RationalValue) {
            val v = (value as RationalValue).getValue() as Rational
            value = factory.createIntegerValue()
            (value as IntegerValue).setValue(v.bigIntegerValue())
        }
        return value
    }
    
    def dispatch Value evaluate(DecimalCast dce) {
        // Cast a value to a BigDecimal
        var value = dce.getExpr().evaluate();
        if (value instanceof IntegerValue) {
            val v = (value as IntegerValue).getValue();
            value = factory.createDecimalValue();
            (value as DecimalValue).setValue(new BigDecimal(v));
        } else if (value instanceof FloatValue) {
            val dble = (value as FloatValue).getValue() as double
            value = factory.createDecimalValue()
            (value as DecimalValue).setValue(BigDecimal.valueOf(dble))
        } else if (value instanceof RationalValue) {
            val rat = (value as RationalValue).getValue() as Rational
            value = factory.createDecimalValue()
            (value as DecimalValue).setValue(rat.bigDecimalValue())
        }
        return value;
    }
    
    def dispatch Value evaluate(FloatCast fce) {
        // Cast a value to a BigDecimal
        var value = fce.getExpr().evaluate();
        if (value instanceof IntegerValue) {
            val v = (value as IntegerValue).getValue();
            value = factory.createFloatValue();
            (value as FloatValue).setValue(v.doubleValue());
        } else if (value instanceof DecimalValue) {
            val dec = (value as DecimalValue).getValue() as BigDecimal
            value = factory.createFloatValue()
            (value as FloatValue).setValue(dec.doubleValue())
        } else if (value instanceof RationalValue) {
            val rat = (value as RationalValue).getValue() as Rational
            value = factory.createFloatValue()
            (value as FloatValue).setValue(rat.doubleValue())
        }
        return value;
    }
    
    def dispatch Value evaluate(RationalCast rce) {
        // Cast a value to a rational
        var value = rce.getExpr().evaluate();
        if (value instanceof IntegerValue) {
            val v = (value as IntegerValue).getValue()
            value = factory.createRationalValue();
            (value as RationalValue).setValue(new Rational(v))
        } else if (value instanceof DecimalValue) {
            val v = (value as DecimalValue).getValue()
            value = factory.createRationalValue();
            (value as RationalValue).setValue(new Rational(v))
        } else if (value instanceof FloatValue) {
            val v = (value as FloatValue).getValue()
            value = factory.createRationalValue();
            (value as RationalValue).setValue(new Rational(v))
        }
        return value;
    }
    
    // Operators
    // Integer calculus when both values are integers
    def dispatch Value evaluateOperator(IntegerValue left, IntegerValue right, BinOp op) {
        evaluateOperator(left.getValue(), right.getValue(), op)
    }
    def dispatch Value evaluateOperator(BigInteger left, BigInteger right, BinOp op) {
        val result = factory.createIntegerValue();
        try {
            switch (op.getOp()) {
                case PLUS:
                    result.setValue(intCalculus.add(left, right))
                case MINUS:
                    result.setValue(intCalculus.subtract(left, right))
                case TIMES:
                    result.setValue(intCalculus.multiply(left, right))
                case DIV:
                    result.setValue(intCalculus.divide(left, right))
                default:
                    spec.reportError(op, "Unknown arithmetic operator: " + op.getOp())
            }
        } catch (ArithmeticException e) {
            val msg = "## Arithmetic exception: " + e.message
            spec.reportError(op, msg)
            spec.console(spec.err, msg)
            result.setValue(BigInteger::ZERO)
        }
        return result
    }
    
    // Rational Calculus when at least one value is a Rational
    def dispatch Value evaluateOperator(RationalValue left, RationalValue right, BinOp op) {
        evaluateOperator(left.value, right.value, op)
    }
    def dispatch Value evaluateOperator(RationalValue left, FloatValue right, BinOp op) {
        evaluateOperator(left.value, new Rational(right.value), op)
    }
    def dispatch Value evaluateOperator(RationalValue left, DecimalValue right, BinOp op) {
        evaluateOperator(left.value, new Rational(right.value), op)
    }
    def dispatch Value evaluateOperator(FloatValue left, RationalValue right, BinOp op) {
        evaluateOperator(new Rational(left.value), right.value, op)
    }
    def dispatch Value evaluateOperator(DecimalValue left, RationalValue right, BinOp op) {
        evaluateOperator(new Rational(left.value), right.value, op)
    }
    def dispatch Value evaluateOperator(RationalValue left, IntegerValue right, BinOp op) {
        evaluateOperator(left.value, new Rational(right.value), op)
    }
    def dispatch Value evaluateOperator(IntegerValue left, RationalValue right, BinOp op) {
        evaluateOperator(new Rational(left.value), right.value, op)
    }
    def dispatch Value evaluateOperator(Rational left, Rational right, BinOp op) {
        val result = factory.createRationalValue()
        val Rational res = try {
            switch (op.getOp()) {
                case PLUS:
                    ratCalculus.add(left, right)
                case MINUS:
                    ratCalculus.subtract(left, right)
                case TIMES:
                    ratCalculus.multiply(left, right)
                case DIV:
                    ratCalculus.divide(left, right)
                default: {
                    spec.reportError(op, "Unknown arithmetic operator: " + op.getOp())
                    new Rational(0)
                }
            }
        } catch (ArithmeticException e) {
            val msg = "## Arithmetic exception: " + e.message
            spec.reportError(op, msg)
            spec.console(spec.err, msg)
            new Rational(0)
        }
        result.setValue(res)
        return result
    }
    
    // Decimal calculus when at least one value is a decimal value
    def dispatch Value evaluateOperator(IntegerValue left, DecimalValue right, BinOp op) {
        evaluateOperator(new BigDecimal(left.getValue()), right.getValue(), op)
    }
    def dispatch Value evaluateOperator(DecimalValue left, IntegerValue right, BinOp op) {
        evaluateOperator(left.getValue(), new BigDecimal(right.getValue()), op)
    }
    def dispatch Value evaluateOperator(FloatValue left, DecimalValue right, BinOp op) {
        evaluateOperator(new BigDecimal(left.getValue()), right.getValue(), op)
    }
    def dispatch Value evaluateOperator(DecimalValue left, FloatValue right, BinOp op) {
        evaluateOperator(left.getValue(), new BigDecimal(right.getValue()), op)
    }
    def dispatch Value evaluateOperator(DecimalValue left, DecimalValue right, BinOp op) {
        evaluateOperator(left.getValue(), right.getValue(), op)
    }
    def dispatch Value evaluateOperator(BigDecimal left, BigDecimal right, BinOp op) {
        val result = factory.createDecimalValue();
        try {
            switch (op.getOp()) {
                case PLUS:
                    result.setValue(decimalCalculus.add(left, right))
                case MINUS:
                    result.setValue(decimalCalculus.subtract(left, right))
                case TIMES:
                    result.setValue(decimalCalculus.multiply(left, right))
                case DIV:
                    result.setValue(decimalCalculus.divide(left, right))
                default:
                    spec.reportError(op, "Unknown arithmetic operator: " + op.getOp())
            }

        } catch (ArithmeticException e) {
            val msg = "## Arithmetic exception: " + e.message
            spec.reportError(op, msg)
            spec.console(spec.err, msg)
            result.setValue(BigDecimal::ZERO)
        }
        return result
    }

    // Float calculus for floats and integers
    def dispatch Value evaluateOperator(IntegerValue left, FloatValue right, BinOp op) {
        evaluateOperator(left.getValue().doubleValue(), right.getValue(), op)
    }
    def dispatch Value evaluateOperator(FloatValue left, IntegerValue right, BinOp op) {
        evaluateOperator(left.getValue(), right.getValue().doubleValue(), op)
    }
    def dispatch Value evaluateOperator(FloatValue left, FloatValue right, BinOp op) {
        evaluateOperator(left.getValue(), right.getValue(), op)
    }
    def dispatch Value evaluateOperator(double left, double right, BinOp op) {
        val result = factory.createFloatValue();
        try {
            switch (op.getOp()) {
                case PLUS:
                    result.setValue(floatCalculus.add(left, right))
                case MINUS:
                    result.setValue(floatCalculus.subtract(left, right))
                case TIMES:
                    result.setValue(floatCalculus.multiply(left, right))
                case DIV:
                    result.setValue(floatCalculus.divide(left, right))
                default:
                    spec.reportError(op, "Unknown arithmetic operator: " + op.getOp())
            }

        } catch (ArithmeticException e) {
            val msg = "## Arithmetic exception: " + e.message
            spec.reportError(op, msg)
            spec.console(spec.err, msg)
            result.setValue(0.0D)
        }
        return result
    }

    // Fall back for unknown value types
    def dispatch Value evaluateOperator(Value left, Value right, BinOp op) {
        spec.reportError(op, "Unsupported value type: either " + left.getClass().getName() + " or " + right.getClass().getName())
        return null
    }
     
    /****** Value Extensions ******/
    // Get numerical values from TESL Values
    // BigIntegers
    def dispatch BigInteger bigIntegerValue(IntegerValue v, EObject faultyASTNode, String msg) {
        v.value
    }
    def dispatch BigInteger bigIntegerValue(Value v, EObject faultyASTNode, String msg) {
        spec.reportError(faultyASTNode, "Unsupported value as integer for " + msg + ": " + v)
        return null
    }
    
    // Integers
    def int intValue(Value v, EObject faultyASTNode, String msg) {
        val BigInteger bb = v.bigIntegerValue(faultyASTNode, msg)
        if (bb != null) {
            val int ib = bb.intValue()
            if (! bb.equals(BigInteger.valueOf(ib))) {
                spec.reportError(faultyASTNode, msg + " is too big to fit into an int: " + bb)
            }
            ib
        } else {
            0
        }
    }
    
    // BigDecimals
    def dispatch BigDecimal bigDecimalValue(IntegerValue v, EObject faultyASTNode, String msg) {
        new BigDecimal(v.value)
    }
    def dispatch BigDecimal bigDecimalValue(DecimalValue v, EObject faultyASTNode, String msg) {
        v.value
    }
    def dispatch BigDecimal bigDecimalValue(FloatValue v, EObject faultyASTNode, String msg) {
        BigDecimal.valueOf(v.value)
    }
    def dispatch BigDecimal bigDecimalValue(Value v, EObject faultyASTNode, String msg) {
        spec.reportError(v, "Unsupported value as float for " + msg + ": " + v)
        return null
    }

    // Double
    def dispatch double doubleValue(IntegerValue v, EObject faultyASTNode, String msg) {
        val BigDecimal bd = new BigDecimal(v.value)
        val double dd = bd.doubleValue()
        if (bd.compareTo(BigDecimal.valueOf(dd)) != 0) {  // Beware, BigDecimal.equals differs from BigDecimal.compareTo == 0 
            spec.reportError(faultyASTNode, msg + " is too big to fit into a double: " + bd)
        }
        dd
    }
    
    def dispatch double doubleValue(DecimalValue v, EObject faultyASTNode, String msg) {
        val double dd = v.value.doubleValue()
        if (v.value.compareTo(BigDecimal.valueOf(dd)) != 0) {  // Beware, BigDecimal.equals differs from BigDecimal.compareTo == 0
            spec.reportError(faultyASTNode, msg + " is too big to fit into a double: " + v.value)
        }
        dd
    }
    
    def dispatch double doubleValue(FloatValue v, EObject faultyASTNode, String msg) {
        v.value
    }
    
    def dispatch double doubleValue(Value v, EObject faultyASTNode, String msg) {
        spec.reportError(v, "Unsupported value as double for " + msg + ": " + v)
        return 0.0
    }
    
    // Rational
    def dispatch Rational rationalValue(IntegerValue v, EObject faultyASTNode, String msg) {
        new Rational(v.value)
    }
    def dispatch Rational rationalValue(DecimalValue v, EObject faultyASTNode, String msg) {
        new Rational(v.value)
    }
    def dispatch Rational rationalValue(FloatValue v, EObject faultyASTNode, String msg) {
        new Rational(v.value)
    }
    def dispatch Rational rationalValue(RationalValue v, EObject faultyASTNode, String msg) {
        v.value as Rational
    }
    def dispatch Rational rationalValue(Value v, EObject faultyASTNode, String msg) {
        spec.reportError(v, "Unsupported value as rational for " + msg + ": " + v)
        return null
    }
    
}


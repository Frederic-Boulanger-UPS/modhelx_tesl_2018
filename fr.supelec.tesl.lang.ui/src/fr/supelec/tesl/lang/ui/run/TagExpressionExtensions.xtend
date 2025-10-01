package fr.supelec.tesl.lang.ui.run

import fr.supelec.tesl.core.Clock
import fr.supelec.tesl.lang.tesl.Type
import java.math.BigInteger
import fr.supelec.tesl.core.Rational
import fr.supelec.tesl.lang.tesl.TagExpr
import java.math.BigDecimal
import fr.supelec.tesl.lang.tesl.TeslFactory
import fr.supelec.tesl.lang.tesl.IntegerValue

//* Extension methods for tesl.lang.TagExpr
class TagExpressionExtensions extends ExtensionWithExpressions {
    
    new(TESLSpec spec) {
        super(spec)
    }
/*
    def dispatch void process(SameTagsExpr sametags, Clock<?> x, Clock<?> y) {
        val typeX = sametags.clockX.type
        val typeY = sametags.clockY.type
        if (typeX == typeY) {
        	try {
	            x.sameTags_erased(y)
            } catch (Exception e) {
            	spec.reportError(sametags, e.message)  // mark the line in the source code
            	throw e                                // Let the exception go up to stop the execution
            }
        } else {
        	var msg = "Incompatible clock types for same tags relation"
            spec.reportError(sametags, msg)
    	    throw new Exception("## Error: " + msg)
        }
    }
*/

    def void createSameTags(TagExpr tags, Clock<?> x, Clock<?> y) {
    	if (tags.clockX.type == tags.clockY.type) {
    		try {
    			x.sameTags_erased(y)
    		} catch (Exception e) {
            	spec.reportError(tags, e.message)  // mark the line in the source code
            	throw e                                // Let the exception go up to stop the execution
            }
        } else {
        	var msg = "Incompatible clock types for same tags relation"
            spec.reportError(tags, msg)
    	    throw new Exception("## Error: " + msg)
    	}
    }
    
    def void process(TagExpr tags, Clock<?> x, Clock<?> y) {
        val typeY = tags.clockY.type
        val typeX = tags.clockX.type
        
        // Handle SameTags
        if (tags.valueA == null && tags.valueB == null && tags.valueN == null) {
        	createSameTags(tags, x, y)
        	return
        }
/*
        val coeff = affinetags.getValueA().evaluate();
        val offset = affinetags.getValueB().evaluate();
*/
		// Handle new syntax for tag relations : a = coeff * b is allowed, as well as a = b + offset
        val coeff = if (tags.valueA == null) {
        	// Default coefficient is 1
        	val intvalue = TeslFactory.eINSTANCE.createIntegerValue
        	intvalue.value = BigInteger.ONE
        	intvalue
        } else {
        	tags.valueA.evaluate()	
        }
        val offset = if (tags.valueB == null) {
        	// Default offset is 0
        	val intvalue = TeslFactory.eINSTANCE.createIntegerValue
        	intvalue.value = BigInteger.ZERO
        	intvalue
        } else {
        	tags.valueB.evaluate()
        }
        val power = if (tags.valueN == null) {
        	// Default power is 1
        	val intvalue = TeslFactory.eINSTANCE.createIntegerValue
        	intvalue.value = BigInteger.ONE
        	intvalue
        } else {
        	tags.valueN.evaluate()
        }
        
        if (!(power instanceof IntegerValue)) {
        	var msg = "Power in tag relation is not an integer"
        	spec.reportError(tags, msg)
        	throw new Exception("# Error: " + msg)
        }

		try {
	        if (typeX == Type.TINT && typeY == Type.TINT) {
	        	val intCoeff = coeff.bigIntegerValue(tags, "coefficient in integer tag relation")
	        	val intOffset = offset.bigIntegerValue(tags, "offset in integer tag relation")
	        	if (tags.valueN == null) {
    	            (x as Clock<BigInteger>).affineTags((y as Clock<BigInteger>), intCoeff, intOffset)
        	    } else {
    	            (x as Clock<BigInteger>).powerTags((y as Clock<BigInteger>), power.intValue(tags, "power in a tag relation"), intCoeff, intOffset)
        	    }
        	} else if (typeX == Type.TDEC && typeY == Type.TDEC) {
	        	val decCoeff = coeff.bigDecimalValue(tags, "coefficient in integer tag relation")
	        	val decOffset = offset.bigDecimalValue(tags, "offset in integer tag relation")
	        	if (tags.valueN == null) {
            	    (x as Clock<BigDecimal>).affineTags((y as Clock<BigDecimal>), decCoeff, decOffset)
            	} else {
            	    (x as Clock<BigDecimal>).powerTags((y as Clock<BigDecimal>), power.intValue(tags, "power in a tag relation"), decCoeff, decOffset)
            	}
        	} else if (typeX == Type.TRAT && typeY == Type.TRAT) {
	        	val ratCoeff = coeff.rationalValue(tags, "coefficient in integer tag relation")
	        	val ratOffset = offset.rationalValue(tags, "offset in integer tag relation")
	        	if (tags.valueN == null) {
            	    (x as Clock<Rational>).affineTags((y as Clock<Rational>), ratCoeff, ratOffset)
            	} else {
            	    (x as Clock<Rational>).powerTags((y as Clock<Rational>), power.intValue(tags, "power in a tag relation"), ratCoeff, ratOffset)
            	}
        	} else if (typeX == Type.TFLOAT && typeY == Type.TFLOAT) {
	        	val fltCoeff = coeff.doubleValue(tags, "coefficient in integer tag relation")
	        	val fltOffset = offset.doubleValue(tags, "offset in integer tag relation")
	        	if (tags.valueN == null) {
            	    (x as Clock<Double>).affineTags((y as Clock<Double>), fltCoeff, fltOffset)
            	} else {
            	    (x as Clock<Double>).powerTags((y as Clock<Double>), power.intValue(tags, "power in a tag relation"), fltCoeff, fltOffset)
            	}
	        } else {
	        	var msg = "Incorrect combination of clock types for tag relation"
    	        spec.reportError(tags, msg)
    	        throw new Exception("## Error: " + msg)
        	}
        } catch (Exception e) {
        	spec.reportError(tags, e.message);
        	throw e
        }
    }
    
/*    
    def dispatch void process(TagExpr expr, Clock<? extends Comparable<?>> x, Clock<? extends Comparable<?>> y) {
    	var msg = "Unsupported tag expression kind in tag relation: " + expr
        spec.reportError(expr, msg)
    	throw new Exception("## Error: " + msg)
    }
*/
}
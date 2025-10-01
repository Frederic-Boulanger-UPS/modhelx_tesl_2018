package fr.supelec.tesl.lang.ui.run

import fr.supelec.tesl.lang.tesl.DecimalValue
import fr.supelec.tesl.lang.tesl.FloatValue
import fr.supelec.tesl.lang.tesl.IntegerValue
import fr.supelec.tesl.lang.tesl.Let
import fr.supelec.tesl.lang.tesl.RationalValue
import fr.supelec.tesl.lang.tesl.TeslFactory
import fr.supelec.tesl.lang.tesl.Value

//* Extension methods for tesl.lang.Let
class LetExtensions extends ExtensionWithExpressions {
    new (TESLSpec spec) {
        super(spec)
    }

    def void process(Let letdef) {
        val value = letdef.getValue().evaluate();
        var Value lval = null
        switch (letdef.getType()) {
            case TINT: {
                val ival = value.bigIntegerValue(letdef, "for an integer let definition")
                lval = TeslFactory.eINSTANCE.createIntegerValue()
                (lval as IntegerValue).setValue(ival)
            }
            case TDEC: {
                val dval = value.bigDecimalValue(letdef, "for a float let definition")
                lval = TeslFactory.eINSTANCE.createDecimalValue()
                (lval as DecimalValue).setValue(dval)
            }
            case TFLOAT: {
                val dval = value.doubleValue(letdef, "for a float let definition")
                lval = TeslFactory.eINSTANCE.createFloatValue()
                (lval as FloatValue).setValue(dval)
            }
            case TRAT: {
                val rval = value.rationalValue(letdef, "for a rational let definition")
                lval = TeslFactory.eINSTANCE.createRationalValue()
                (lval as RationalValue).setValue(rval)
            }
            default:
                spec.reportError(letdef, "Unsupported type for let definition: " + letdef.getType())
        }
        spec.setLetValue(letdef.getName(), lval)
    }
    
    def toString(Let letdef) {
        val builder = new StringBuilder("let ")
        switch (letdef.getType()) {
            case TINT: {
                builder.append("int ")
            }
            case TDEC: {
                builder.append("decimal ")
            }
            case TRAT: {
                builder.append("rational ")
            }
            case TFLOAT: {
                builder.append("float ")
            }
            default: {
                builder.append("<unknown type> ")
            }
        }
        builder.append(letdef.name)
        builder.append(" = ")
        builder.append(spec.getLetValue(letdef.name))
        builder.toString()
    }
}


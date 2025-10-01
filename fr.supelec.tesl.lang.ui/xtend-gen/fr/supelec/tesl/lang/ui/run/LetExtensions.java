package fr.supelec.tesl.lang.ui.run;

import fr.supelec.tesl.core.Rational;
import fr.supelec.tesl.lang.tesl.DecimalValue;
import fr.supelec.tesl.lang.tesl.FloatValue;
import fr.supelec.tesl.lang.tesl.IntegerValue;
import fr.supelec.tesl.lang.tesl.Let;
import fr.supelec.tesl.lang.tesl.RationalValue;
import fr.supelec.tesl.lang.tesl.TeslFactory;
import fr.supelec.tesl.lang.tesl.Value;
import fr.supelec.tesl.lang.tesl.ValueType;
import fr.supelec.tesl.lang.ui.run.ExtensionWithExpressions;
import fr.supelec.tesl.lang.ui.run.TESLSpec;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class LetExtensions extends ExtensionWithExpressions {
  public LetExtensions(final TESLSpec spec) {
    super(spec);
  }
  
  public void process(final Let letdef) {
    try {
      final Value value = this.exprExt.evaluate(letdef.getValue());
      Value lval = null;
      ValueType _type = letdef.getType();
      if (_type != null) {
        switch (_type) {
          case TINT:
            final BigInteger ival = this.exprExt.bigIntegerValue(value, letdef, "for an integer let definition");
            lval = TeslFactory.eINSTANCE.createIntegerValue();
            ((IntegerValue) lval).setValue(ival);
            break;
          case TDEC:
            final BigDecimal dval = this.exprExt.bigDecimalValue(value, letdef, "for a float let definition");
            lval = TeslFactory.eINSTANCE.createDecimalValue();
            ((DecimalValue) lval).setValue(dval);
            break;
          case TFLOAT:
            final double dval_1 = this.exprExt.doubleValue(value, letdef, "for a float let definition");
            lval = TeslFactory.eINSTANCE.createFloatValue();
            ((FloatValue) lval).setValue(dval_1);
            break;
          case TRAT:
            final Rational rval = this.exprExt.rationalValue(value, letdef, "for a rational let definition");
            lval = TeslFactory.eINSTANCE.createRationalValue();
            ((RationalValue) lval).setValue(rval);
            break;
          default:
            TESLSpec _spec = this.getSpec();
            ValueType _type_1 = letdef.getType();
            String _plus = ("Unsupported type for let definition: " + _type_1);
            _spec.reportError(letdef, _plus);
            break;
        }
      } else {
        TESLSpec _spec = this.getSpec();
        ValueType _type_1 = letdef.getType();
        String _plus = ("Unsupported type for let definition: " + _type_1);
        _spec.reportError(letdef, _plus);
      }
      this.getSpec().setLetValue(letdef.getName(), lval);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public String toString(final Let letdef) {
    String _xblockexpression = null;
    {
      final StringBuilder builder = new StringBuilder("let ");
      ValueType _type = letdef.getType();
      if (_type != null) {
        switch (_type) {
          case TINT:
            builder.append("int ");
            break;
          case TDEC:
            builder.append("decimal ");
            break;
          case TRAT:
            builder.append("rational ");
            break;
          case TFLOAT:
            builder.append("float ");
            break;
          default:
            builder.append("<unknown type> ");
            break;
        }
      } else {
        builder.append("<unknown type> ");
      }
      builder.append(letdef.getName());
      builder.append(" = ");
      builder.append(this.getSpec().getLetValue(letdef.getName()));
      _xblockexpression = builder.toString();
    }
    return _xblockexpression;
  }
}

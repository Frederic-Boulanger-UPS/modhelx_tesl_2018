package fr.supelec.tesl.lang.ui.run;

import com.google.common.base.Objects;
import fr.supelec.tesl.core.Clock;
import fr.supelec.tesl.core.Rational;
import fr.supelec.tesl.lang.tesl.Expression;
import fr.supelec.tesl.lang.tesl.IntegerValue;
import fr.supelec.tesl.lang.tesl.TagExpr;
import fr.supelec.tesl.lang.tesl.TeslFactory;
import fr.supelec.tesl.lang.tesl.Type;
import fr.supelec.tesl.lang.tesl.Value;
import fr.supelec.tesl.lang.ui.run.ExtensionWithExpressions;
import fr.supelec.tesl.lang.ui.run.TESLSpec;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class TagExpressionExtensions extends ExtensionWithExpressions {
  public TagExpressionExtensions(final TESLSpec spec) {
    super(spec);
  }
  
  /**
   * def dispatch void process(SameTagsExpr sametags, Clock<?> x, Clock<?> y) {
   * val typeX = sametags.clockX.type
   * val typeY = sametags.clockY.type
   * if (typeX == typeY) {
   * try {
   * x.sameTags_erased(y)
   * } catch (Exception e) {
   * spec.reportError(sametags, e.message)  // mark the line in the source code
   * throw e                                // Let the exception go up to stop the execution
   * }
   * } else {
   * var msg = "Incompatible clock types for same tags relation"
   * spec.reportError(sametags, msg)
   * throw new Exception("## Error: " + msg)
   * }
   * }
   */
  public void createSameTags(final TagExpr tags, final Clock<?> x, final Clock<?> y) {
    try {
      Type _type = tags.getClockX().getType();
      Type _type_1 = tags.getClockY().getType();
      boolean _equals = Objects.equal(_type, _type_1);
      if (_equals) {
        try {
          x.sameTags_erased(y);
        } catch (final Throwable _t) {
          if (_t instanceof Exception) {
            final Exception e = (Exception)_t;
            this.getSpec().reportError(tags, e.getMessage());
            throw e;
          } else {
            throw Exceptions.sneakyThrow(_t);
          }
        }
      } else {
        String msg = "Incompatible clock types for same tags relation";
        this.getSpec().reportError(tags, msg);
        throw new Exception(("## Error: " + msg));
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void process(final TagExpr tags, final Clock<?> x, final Clock<?> y) {
    try {
      final Type typeY = tags.getClockY().getType();
      final Type typeX = tags.getClockX().getType();
      if (((Objects.equal(tags.getValueA(), null) && Objects.equal(tags.getValueB(), null)) && Objects.equal(tags.getValueN(), null))) {
        this.createSameTags(tags, x, y);
        return;
      }
      Value _xifexpression = null;
      Expression _valueA = tags.getValueA();
      boolean _equals = Objects.equal(_valueA, null);
      if (_equals) {
        IntegerValue _xblockexpression = null;
        {
          final IntegerValue intvalue = TeslFactory.eINSTANCE.createIntegerValue();
          intvalue.setValue(BigInteger.ONE);
          _xblockexpression = intvalue;
        }
        _xifexpression = _xblockexpression;
      } else {
        _xifexpression = this.exprExt.evaluate(tags.getValueA());
      }
      final Value coeff = _xifexpression;
      Value _xifexpression_1 = null;
      Expression _valueB = tags.getValueB();
      boolean _equals_1 = Objects.equal(_valueB, null);
      if (_equals_1) {
        IntegerValue _xblockexpression_1 = null;
        {
          final IntegerValue intvalue = TeslFactory.eINSTANCE.createIntegerValue();
          intvalue.setValue(BigInteger.ZERO);
          _xblockexpression_1 = intvalue;
        }
        _xifexpression_1 = _xblockexpression_1;
      } else {
        _xifexpression_1 = this.exprExt.evaluate(tags.getValueB());
      }
      final Value offset = _xifexpression_1;
      Value _xifexpression_2 = null;
      Expression _valueN = tags.getValueN();
      boolean _equals_2 = Objects.equal(_valueN, null);
      if (_equals_2) {
        IntegerValue _xblockexpression_2 = null;
        {
          final IntegerValue intvalue = TeslFactory.eINSTANCE.createIntegerValue();
          intvalue.setValue(BigInteger.ONE);
          _xblockexpression_2 = intvalue;
        }
        _xifexpression_2 = _xblockexpression_2;
      } else {
        _xifexpression_2 = this.exprExt.evaluate(tags.getValueN());
      }
      final Value power = _xifexpression_2;
      if ((!(power instanceof IntegerValue))) {
        String msg = "Power in tag relation is not an integer";
        this.getSpec().reportError(tags, msg);
        throw new Exception(("# Error: " + msg));
      }
      try {
        if ((Objects.equal(typeX, Type.TINT) && Objects.equal(typeY, Type.TINT))) {
          final BigInteger intCoeff = this.exprExt.bigIntegerValue(coeff, tags, "coefficient in integer tag relation");
          final BigInteger intOffset = this.exprExt.bigIntegerValue(offset, tags, "offset in integer tag relation");
          Expression _valueN_1 = tags.getValueN();
          boolean _equals_3 = Objects.equal(_valueN_1, null);
          if (_equals_3) {
            ((Clock<BigInteger>) x).affineTags(((Clock<BigInteger>) y), intCoeff, intOffset);
          } else {
            ((Clock<BigInteger>) x).powerTags(((Clock<BigInteger>) y), this.exprExt.intValue(power, tags, "power in a tag relation"), intCoeff, intOffset);
          }
        } else {
          if ((Objects.equal(typeX, Type.TDEC) && Objects.equal(typeY, Type.TDEC))) {
            final BigDecimal decCoeff = this.exprExt.bigDecimalValue(coeff, tags, "coefficient in integer tag relation");
            final BigDecimal decOffset = this.exprExt.bigDecimalValue(offset, tags, "offset in integer tag relation");
            Expression _valueN_2 = tags.getValueN();
            boolean _equals_4 = Objects.equal(_valueN_2, null);
            if (_equals_4) {
              ((Clock<BigDecimal>) x).affineTags(((Clock<BigDecimal>) y), decCoeff, decOffset);
            } else {
              ((Clock<BigDecimal>) x).powerTags(((Clock<BigDecimal>) y), this.exprExt.intValue(power, tags, "power in a tag relation"), decCoeff, decOffset);
            }
          } else {
            if ((Objects.equal(typeX, Type.TRAT) && Objects.equal(typeY, Type.TRAT))) {
              final Rational ratCoeff = this.exprExt.rationalValue(coeff, tags, "coefficient in integer tag relation");
              final Rational ratOffset = this.exprExt.rationalValue(offset, tags, "offset in integer tag relation");
              Expression _valueN_3 = tags.getValueN();
              boolean _equals_5 = Objects.equal(_valueN_3, null);
              if (_equals_5) {
                ((Clock<Rational>) x).affineTags(((Clock<Rational>) y), ratCoeff, ratOffset);
              } else {
                ((Clock<Rational>) x).powerTags(((Clock<Rational>) y), this.exprExt.intValue(power, tags, "power in a tag relation"), ratCoeff, ratOffset);
              }
            } else {
              if ((Objects.equal(typeX, Type.TFLOAT) && Objects.equal(typeY, Type.TFLOAT))) {
                final double fltCoeff = this.exprExt.doubleValue(coeff, tags, "coefficient in integer tag relation");
                final double fltOffset = this.exprExt.doubleValue(offset, tags, "offset in integer tag relation");
                Expression _valueN_4 = tags.getValueN();
                boolean _equals_6 = Objects.equal(_valueN_4, null);
                if (_equals_6) {
                  ((Clock<Double>) x).affineTags(((Clock<Double>) y), Double.valueOf(fltCoeff), Double.valueOf(fltOffset));
                } else {
                  ((Clock<Double>) x).powerTags(((Clock<Double>) y), this.exprExt.intValue(power, tags, "power in a tag relation"), Double.valueOf(fltCoeff), Double.valueOf(fltOffset));
                }
              } else {
                String msg_1 = "Incorrect combination of clock types for tag relation";
                this.getSpec().reportError(tags, msg_1);
                throw new Exception(("## Error: " + msg_1));
              }
            }
          }
        }
      } catch (final Throwable _t) {
        if (_t instanceof Exception) {
          final Exception e = (Exception)_t;
          this.getSpec().reportError(tags, e.getMessage());
          throw e;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

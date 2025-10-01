package fr.supelec.tesl.lang.ui.run

import fr.supelec.tesl.lang.tesl.SameTagsExpr
import fr.supelec.tesl.lang.tesl.AffineTagsExpr
import fr.supelec.tesl.core.Clock
import fr.supelec.tesl.lang.tesl.Type
import java.math.BigInteger
import fr.supelec.tesl.core.Rational
import fr.supelec.tesl.lang.tesl.TagExpr
import java.math.BigDecimal

//* Extension methods for tesl.lang.TagExpr
class TagExpressionExtensions extends ExtensionWithExpressions {
    
    new(TESLSpec spec) {
        super(spec)
    }
    
    def dispatch void process(SameTagsExpr sametags, Clock<? extends Comparable<?>> x, Clock<? extends Comparable<?>> y) {
        val typeX = sametags.clockX.type
        val typeY = sametags.clockY.type
        if (typeX == typeY) {
            x.sameTags_erasedTypes(y)
        } else {
            spec.reportError(sametags, "Incompatible clock types for same tags relation")
        }
    }
    
    def dispatch void process(AffineTagsExpr affinetags, Clock<? extends Comparable<?>> x, Clock<? extends Comparable<?>> y) {
        val typeY = affinetags.getClockY().getType();
        val typeX = affinetags.getClockX().getType();

        val coeff = affinetags.getValueA().evaluate();
        val offset = affinetags.getValueB().evaluate();

        if (typeX == Type.TINT && typeY == Type.TINT) {
            (x as Clock<BigInteger>).affineTags((y as Clock<BigInteger>), coeff.bigIntegerValue(affinetags, "coefficient in integer affine tag relation"),
                            offset.bigIntegerValue(affinetags, "offset in integer affine tag relation"))
        } else if (typeX == Type.TDEC && typeY == Type.TDEC) {
            (x as Clock<BigDecimal>).affineTags((y as Clock<BigDecimal>), coeff.bigDecimalValue(affinetags, "coefficient in rational affine tag relation"),
                            offset.bigDecimalValue(affinetags, "offset in decimal affine tag relation"))
        } else if (typeX == Type.TRAT && typeY == Type.TRAT) {
            (x as Clock<Rational>).affineTags((y as Clock<Rational>), coeff.rationalValue(affinetags, "coefficient in rational affine tag relation"),
                            offset.rationalValue(affinetags, "offset in rational affine tag relation"))
        } else if (typeX == Type.TFLOAT && typeY == Type.TFLOAT) {
            (x as Clock<Double>).affineTags((y as Clock<Double>), coeff.doubleValue(affinetags, "coefficient in float affine tag relation"),
                            offset.doubleValue(affinetags, "offset in float affine tag relation"))
        } else {
            spec.reportError(affinetags, "Incorrect combination of clock types for affine tag relation")
        }
    }
    
    def dispatch void process(TagExpr expr, Clock<? extends Comparable<?>> x, Clock<? extends Comparable<?>> y) {
        spec.reportError(expr, "Unsupported tag expression kind in tag relation: " + expr)
    }
}
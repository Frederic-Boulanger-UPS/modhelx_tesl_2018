package fr.supelec.tesl.lang;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.eclipse.xtext.common.services.DefaultTerminalConverters;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.AbstractToStringConverter;
import org.eclipse.xtext.nodemodel.INode;

import fr.supelec.tesl.core.Rational;

public class TESLValueConverterService extends DefaultTerminalConverters {
    @SuppressWarnings("static-method")
	@ValueConverter(rule = "BIG_INT")
    public IValueConverter<BigInteger> BIG_INT() {
        return new AbstractToStringConverter<BigInteger>() {
            @Override
            protected BigInteger internalToValue(String string, INode node) throws ValueConverterException {
                return new BigInteger(string);
            }
        };
    }

    @SuppressWarnings("static-method")
	@ValueConverter(rule = "BIG_DECIMAL")
    public IValueConverter<BigDecimal> BIG_FLOAT() {
        return new AbstractToStringConverter<BigDecimal>() {
            @Override
            protected BigDecimal internalToValue(String string, INode node) throws ValueConverterException {
                return new BigDecimal(string);
            }
        };
    }

    @SuppressWarnings("static-method")
	@ValueConverter(rule = "RATIONAL")
    public IValueConverter<Rational> RATIONAL() {
        return new AbstractToStringConverter<Rational> () {
            @Override
            protected Rational internalToValue(String string, INode node) throws ValueConverterException {
                BigInteger [] data = new BigInteger[2];
                int start = 0;
                for (int i = 0; i < 2; i++) {
                    while (start < string.length() && !Character.isDigit(string.charAt(start))) {
                        start++;
                    }
                    int stop = start + 1;
                    while (stop < string.length() && Character.isDigit(string.charAt(stop))) {
                        stop++;
                    }
                    data[i] = new BigInteger(string.substring(start, stop));
                    start = stop + 1;
                }
                return new Rational(data[0], data[1]);
            }
        };
    }
}

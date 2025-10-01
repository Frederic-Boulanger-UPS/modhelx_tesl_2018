package fr.supelec.tesl.logging;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

//@ A Handler which performs output on an OutputStream using a given encoding
public class StreamHandler extends PrintStreamHandler {
    public StreamHandler(String format, OutputStream stream, String encoding) throws UnsupportedEncodingException {
        super(format, new PrintStream(stream, true, encoding));
    }

    public StreamHandler(OutputStream stream, String encoding) throws UnsupportedEncodingException {
        super(new PrintStream(stream, true, encoding));
    }

}

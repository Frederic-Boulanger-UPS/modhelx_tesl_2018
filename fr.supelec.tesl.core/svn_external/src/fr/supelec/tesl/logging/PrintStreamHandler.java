package fr.supelec.tesl.logging;

import java.io.PrintStream;

//@ A Handler which performs output on a PrintStream
public class PrintStreamHandler extends Handler {
    private PrintStream stream_;

    public PrintStreamHandler(String format, PrintStream stream) {
        super(format);
        this.stream_ = stream;
    }

    public PrintStreamHandler(PrintStream stream) {
        this.stream_ = stream;
    }

    @Override
    public void outputMessage(String msg) {
        this.stream_.println(msg);
    }

}

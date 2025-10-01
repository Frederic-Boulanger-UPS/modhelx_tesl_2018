package fr.supelec.tesl.logging;

//@ A Handler which performs output on System.err
public class SysErrHandler extends PrintStreamHandler {
    public SysErrHandler(String format) {
        super(format, System.err);
    }

    public SysErrHandler() {
        super(System.err);
    }

}

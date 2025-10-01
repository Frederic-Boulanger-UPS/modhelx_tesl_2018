package fr.supelec.tesl.logging;

//@ A Handler which performs output on System.out
public class SysOutHandler extends PrintStreamHandler {
    public SysOutHandler(String format) {
        super(format, System.out);
    }

    public SysOutHandler() {
        super(System.out);
    }

}

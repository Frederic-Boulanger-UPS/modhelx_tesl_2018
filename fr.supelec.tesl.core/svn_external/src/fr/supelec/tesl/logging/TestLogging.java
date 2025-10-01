package fr.supelec.tesl.logging;

public class TestLogging {
    public static void main(String[] args) {
        Logger log = Logger.getLogger("Test");
        log.addInformationKinds("light", "deep", "debug");
        log.addHandler(new SysErrHandler());

        int i = 1;
        System.err.println("### No kind enabled for logging");
        log.log("light", "light ", i++);
        log.log("deep", "deep ", i++);
        log.log("debug", "debug ", i++);

        log.setLoggingKind("light", true);
        System.err.println("### light enabled for logging");
        log.log("light", "light ", i++);
        log.log("deep", "deep ", i++);
        log.log("debug", "debug ", i++);

        log.setLoggingAllKinds(false);
        log.setLoggingKind("deep", true);
        System.err.println("### deep enabled for logging");
        log.log("light", "light ", i++);
        log.log("deep", "deep ", i++);
        log.log("debug", "debug ", i++);

        log.setLoggingAllKinds(false);
        log.setLoggingKind("debug", true);
        System.err.println("### debug enabled for logging");
        log.log("light", "light ", i++);
        log.log("deep", "deep ", i++);
        log.log("debug", "debug ", i++);

        log.setLoggingKind("light", true);
        System.err.println("### light and debug enabled for logging");
        log.log("light", "light ", i++);
        log.log("deep", "deep ", i++);
        log.log("debug", "debug ", i++);

        log.setLoggingKind("deep", true);
        System.err.println("### light, deep and debug enabled for logging");
        log.log("light", "light ", i++);
        log.log("deep", "deep ", i++);
        log.log("debug", "debug ", i++);
    }

}

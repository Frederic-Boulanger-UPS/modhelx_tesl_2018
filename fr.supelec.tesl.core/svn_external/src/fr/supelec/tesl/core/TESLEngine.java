package fr.supelec.tesl.core;

public abstract class TESLEngine {
    public static final int majorversion = 1;
    public static final int minorversion = 1;
    public static final int releaseversion = 0;
    public static final String version = Integer.toString(majorversion)
                                 + "." + Integer.toString(minorversion)
                                 + "." + Integer.toString(releaseversion);

    public static String getVersion() {
        return version;
    }
}

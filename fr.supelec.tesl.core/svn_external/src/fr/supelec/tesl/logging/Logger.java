package fr.supelec.tesl.logging;

import java.text.MessageFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*@
 * A logger is used to log messages for different kinds of information.
 * A logger needs Handlers to perform the output. 
 */
public class Logger {
    //@ The name of the logger
    private final String name_;
    //@ The information kinds supported by this logger
    private Set<String> information_kinds_;
    //@ The logging state of this logger for each supported kind
    private Map<String, Boolean> is_loggin_kind_;
    //@ The output handlers for this logger
    private List<Handler> handlers_;

    //@ The collection of all known loggers
    private static Map<String, Logger> loggers_ = new HashMap<String, Logger>();

    public static final String EOL = System.getProperty("line.separator");
    public static final String TAB = "\t";

    //@ Create a new Logger named <code>name</code> 
    private Logger(String name) {
        this.name_ = name;
        this.information_kinds_ = new HashSet<String>();
        this.is_loggin_kind_ = new HashMap<String, Boolean>();
        this.handlers_ = new LinkedList<Handler>();
    }

    //@ Get a Logger named <code>name</code>. It will be created if it does not exist yet.
    public static Logger getLogger(String name) {
        Logger log = loggers_.get(name);
        if (log == null) {
            log = new Logger(name);
            loggers_.put(name, log);
        }
        return log;
    }

    //@ Get the name of this logger
    public String getName() {
        return this.name_;
    }

    //@ Get the information kinds supported by this logger
    public Collection<String> getInformationKinds() {
        return this.information_kinds_;
    }

    //@ Add an information kind to this logger. If it already exists, its logging status is reset to false.
    public void addInformationKind(String name) {
        this.information_kinds_.add(name);
        this.is_loggin_kind_.put(name, false);
    }

    //@ Add several information kinds to this logger at once
    public void addInformationKinds(String ... names) {
        for (String name : names) {
            addInformationKind(name);
        }
    }

    //@ Add an output handler to this logger
    public void addHandler(Handler h) {
        this.handlers_.add(h);
    }

    //@ Remove an output handler from this logger
    public void removeHandler(Handler h) {
        this.handlers_.remove(h);
    }

    //@ Get the handlers for this logger
    public Collection<Handler> getHandlers() {
        return this.handlers_;
    }

    //@ Tell if this logger is logging information kind <code>name</code>
    public boolean isLoggingKind(String name) {
        return this.is_loggin_kind_.get(name);
    }

    //@ Set the logging status of kind <code>name</code> to <code>logging</code> for this logger
    public void setLoggingKind(String name, boolean logging) {
        if (this.information_kinds_.contains(name)) {
            this.is_loggin_kind_.put(name, logging);
        } else {
            throw new Error("# Error: cannot set loggin on kind \"" + name
                    + "\", which does not exist in logger " + this.name_);
        }
    }

    //@ Set the logging status of several kinds to <code>logging</code>
    public void setLoggingKinds(boolean logging, String ... names) {
        for (String name : names) {
            if (this.information_kinds_.contains(name)) {
                this.is_loggin_kind_.put(name, logging);
            } else {
                throw new Error("# Error: cannot set loggin on kind \"" + name
                        + "\", which does not exist in logger " + this.name_);
            }
        }
    }

    //@ Set the logging status of all information kinds to <code>logging</code>
    public void setLoggingAllKinds(boolean logging) {
        for (String kind : this.information_kinds_) {
            this.is_loggin_kind_.put(kind, logging);
        }
    }

    private void logKindError(String kind) {
        for (Handler h : this.handlers_) {
            h.handleMessage(this.name_, "# LOGGER ERROR #", "Attempt to log unkown information kind \"" + kind + "\"");
        }
    }

    //@ Log a message composed of <code>args</code> into information kind <code>kind</code>
    public void log(String kind, Object... args) {
        Boolean doLog = this.is_loggin_kind_.get(kind);
        if (doLog == null) {
            logKindError(kind);
            return;
        }
        if (doLog) {
            StringBuilder builder = new StringBuilder();
            for (Object o : args) {
                if (o == null) {
                    builder.append("<null>");
                } else {
                    builder.append(o.toString());
                }
            }
            String msg = builder.toString();
            for (Handler h : this.handlers_) {
                h.handleMessage(this.name_, kind, msg);
            }
        }
    }

    //@ Log a message built by MessageFormat.format(format, args) into information kind <code>kind</code>
    public void logFormat(String kind, String format, Object... args) {
        Boolean doLog = this.is_loggin_kind_.get(kind);
        if (doLog == null) {
            logKindError(kind);
            return;
        }
        if (doLog) {
            String msg = MessageFormat.format(format, args);
            for (Handler h : this.handlers_) {
                h.handleMessage(this.name_, kind, msg);
            }
        }
    }
}

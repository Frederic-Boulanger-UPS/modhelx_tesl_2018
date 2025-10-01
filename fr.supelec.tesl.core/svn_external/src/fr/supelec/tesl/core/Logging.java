/*
 * This file is part of ModHel'X.
 *
 * ModHel'X is free software: you can redistribute it and/or modify
 * it under the terms of the Eclipse Public License 1.0
 *
 * ModHel'X is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 *
 * You should have received a copy of the Eclipse Public License
 * along with ModHel'X. If not, see <http://opensource.org/licenses/EPL-1.0>.
 * 
 * Copyright Supélec, Department of Computer Science, 2013
 * http://wwwdi.supelec.fr/software
 * 
 */

package fr.supelec.tesl.core;

import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Logging provides functions for setting the logging level of java.util.logging loggers.
 * 
 * @author frederic.boulanger@supelec.fr
 *
 */
@Deprecated
public class Logging {
    /** Set the logging level of logger <code>name</code> to level <code>l</code>. */
    public static void setLoggingLevel(String name, Level l) {
        Logger log = Logger.getLogger(name);
        log.setLevel(l);
        // Make sure the handlers have the same logging level
        Logger logger = log;
        while (logger != null) {
            for (Handler h : logger.getHandlers()) {
                h.setLevel(l);
            }
            logger = logger.getParent();
        }
    }

    /** Get the logging level for <code>name</code>. */
    public static Level getLoggingLevel(String name) {
        // Get log level. This is a mess since a logger which inherits its log level from its parent returns a null log level.
        Level log_level = null;
        Logger logger = Logger.getLogger(name);
        while (log_level == null) {
            log_level = logger.getLevel();
            logger = logger.getParent();
        }
        return log_level;
    }

    /** Tell if logger <code>name</code> is logging when level is <code>l</code>. */
    public static boolean isLogging(String name, Level l) {
        return (getLoggingLevel(name).intValue() <= l.intValue()); 
    }

    /** Get the logger named <code>name</code>. */
    public static Logger getLogger(String name) {
        return Logger.getLogger(name);
    }

}

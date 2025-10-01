package fr.supelec.tesl.logging;

import java.text.MessageFormat;
import java.util.Date;

/*@
 * A Handler is used to handle messages produces by a Logger.
 */
public abstract class Handler {
    /*@ The format used to format messages.
     *  Receives the date as {0}, the name of the logger as {1}, 
     *  the kind of information as {2}, and the message as {3}
     */
    private String format_;

    /*@ Create a new Handler using <code>format</code>to format messages.
     *  The format receives the date as {0}, the name of the logger as {1}, 
     *  the kind of information as {2}, and the message as {3}.
     *  See java.text.MessageFormat for details.
     */
    public Handler(String format) {
        this.format_ = format;
    }

    //@ Create a new Handler with a default format
    public Handler() {
        this("{0, time}: ({1}/{2}) {3}");
    }

    //@ Handle message <code>msg></code> of information kind <code>kind</code> from logger named <code>logger</code>
    public void handleMessage(String logger, String kind, String msg) {
        outputMessage(MessageFormat.format(this.format_, new Date(), logger, kind, msg));
    }

    //@ Perform the actual output of the formated message
    public abstract void outputMessage(String msg);
}

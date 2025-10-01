package fr.supelec.tesl.lang.ui.run;

import fr.supelec.tesl.lang.ui.run.TESLSpec;
import fr.supelec.tesl.logging.Handler;

@SuppressWarnings("all")
public class ConsoleLogHandler extends Handler {
  private final TESLSpec spec;
  
  public ConsoleLogHandler(final TESLSpec spec) {
    this.spec = spec;
  }
  
  public void outputMessage(final String msg) {
    this.spec.console(this.spec.getOut(), msg);
  }
}

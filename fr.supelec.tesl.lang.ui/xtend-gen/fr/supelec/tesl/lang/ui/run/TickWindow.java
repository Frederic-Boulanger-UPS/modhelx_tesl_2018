package fr.supelec.tesl.lang.ui.run;

import org.eclipse.xtend.lib.Property;

public class TickWindow {
  @Property
  private double from;

  @Property
  private double to;

  public TickWindow(final double from, final double to) {
    this.from = from;
    this.to = to;
  }
}

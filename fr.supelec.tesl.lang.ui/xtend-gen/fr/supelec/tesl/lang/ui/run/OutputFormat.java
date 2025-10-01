package fr.supelec.tesl.lang.ui.run;

import org.eclipse.xtend.lib.Property;

public class OutputFormat {
  private static final Object handlers /* Skipped initializer because of errors */;

  private final /* String */Object name;

  private final Object selection /* Skipped initializer because of errors */;

  private final Object renames /* Skipped initializer because of errors */;

  private TickWindow window = null;

  private final Object labelIf /* Skipped initializer because of errors */;

  @Property
  private double xscale = 1.0;

  @Property
  private boolean standalone = false;

  @Property
  private boolean overwrite = false;

  @Property
  private boolean nodefcss = false;

  @Property
  private /* String */Object borders = null;

  @Property
  private /* String */Object css = null;

  @Property
  private /* String */Object jvs = null;

  public OutputFormat(final /* String */Object name) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field this is undefined"
      + "\nThe method or field name is undefined"
      + "\nThe method xscale(double) is undefined"
      + "\nThe method or field this is undefined"
      + "\ntoLowerCase cannot be resolved");
  }

  public static Object register(final /* String */Object fmtName, final OutputFormatHandler handler) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field handlers is undefined"
      + "\nThe method or field fmtName is undefined"
      + "\nThe method or field handler is undefined"
      + "\nput cannot be resolved"
      + "\ntoLowerCase cannot be resolved");
  }

  public static Object getHandler(final /* String */Object fmtName) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field handlers is undefined"
      + "\nThe method or field fmtName is undefined"
      + "\nget cannot be resolved"
      + "\ntoLowerCase cannot be resolved");
  }

  public String getName() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field this is undefined");
  }

  public Object clearSelection() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field selection is undefined"
      + "\nclear cannot be resolved");
  }

  public Object addToSelection(final /* String */Object name) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field selection is undefined"
      + "\nThe method or field name is undefined"
      + "\nadd cannot be resolved");
  }

  public Object getSelection() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field selection is undefined");
  }

  public Object renameClock(final /* String */Object oldName, final /* String */Object newName) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field renames is undefined"
      + "\nThe method or field oldName is undefined"
      + "\nThe method or field newName is undefined"
      + "\nput cannot be resolved");
  }

  public Object isRenamed(final /* String */Object name) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field renames is undefined"
      + "\nThe method or field name is undefined"
      + "\ncontainsKey cannot be resolved");
  }

  public String newName(final /* String */Object name) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field renames is undefined"
      + "\nThe method or field name is undefined"
      + "\nThe method or field name is undefined"
      + "\nThe field OutputFormat.renames refers to the missing type Object"
      + "\nget cannot be resolved"
      + "\n== cannot be resolved");
  }

  public TickWindow setTickWindow(final double from, final double to) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method window(TickWindow) is undefined"
      + "\nThe method or field from is undefined"
      + "\nThe method or field to is undefined");
  }

  public TickWindow getTickWindow() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field this is undefined");
  }

  public void clipToWindow(final TESLSpec spec, final /* List<Set<String>> */Object ticks, final /* List<Double> */Object tags) {
    throw new Error("Unresolved compilation problems:"
      + "\nDouble cannot be resolved to a type."
      + "\nDouble cannot be resolved to a type."
      + "\nThe method or field tickWindow is undefined"
      + "\nThe method or field tickWindow is undefined"
      + "\nThe method or field tickWindow is undefined"
      + "\nThe method or field spec is undefined"
      + "\nThe method or field spec is undefined"
      + "\nThe method or field ticks is undefined"
      + "\nThe method or field spec is undefined"
      + "\nThe method or field tags is undefined"
      + "\nThe method getTicks() from the type TESLSpec refers to the missing type Object"
      + "\nThe method getTags() from the type TESLSpec refers to the missing type Object"
      + "\nThe method getTicks() from the type TESLSpec refers to the missing type Object"
      + "\nNEGATIVE_INFINITY cannot be resolved"
      + "\nPOSITIVE_INFINITY cannot be resolved"
      + "\nsize cannot be resolved"
      + "\nget cannot be resolved"
      + "\n>= cannot be resolved"
      + "\n&& cannot be resolved"
      + "\n<= cannot be resolved"
      + "\nadd cannot be resolved"
      + "\nget cannot be resolved"
      + "\nadd cannot be resolved");
  }

  public Object addLabelIf(final /* String */Object name) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field labelIf is undefined"
      + "\nThe method or field name is undefined"
      + "\nThe field OutputFormat.labelIf refers to the missing type Object"
      + "\nadd cannot be resolved");
  }

  public Object getLabelIf() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field this is undefined"
      + "\nThe field OutputFormat.labelIf refers to the missing type Object");
  }
}

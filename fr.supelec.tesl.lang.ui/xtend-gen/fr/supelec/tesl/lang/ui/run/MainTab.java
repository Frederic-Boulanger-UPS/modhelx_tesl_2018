package fr.supelec.tesl.lang.ui.run;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

public class MainTab extends AbstractLaunchConfigurationTab {
  private Text fFileText;

  private Text fMaxSteps;

  public static java.lang.String ATTR_FILE = "tesl_file";

  public static java.lang.String ATTR_MAXSTEPS = "max_steps";

  public static int DEFAULT_MAXSTEPS = 1000;

  public void createControl(final Composite parent) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method setText(java.lang.String) is undefined for the type Label"
      + "\nThe method setLayoutData(GridData) is undefined for the type Label"
      + "\nThe method setLayoutData(GridData) is undefined for the type Text"
      + "\nThe method createPushButton(Composite, java.lang.String, Object) is undefined"
      + "\nThe method setText(java.lang.String) is undefined for the type Label"
      + "\nThe method setLayoutData(GridData) is undefined for the type Label"
      + "\nThe method setLayoutData(GridData) is undefined for the type Text"
      + "\nNONE cannot be resolved"
      + "\nNONE cannot be resolved"
      + "\nBEGINNING cannot be resolved"
      + "\nSINGLE cannot be resolved"
      + "\nbitwiseOr cannot be resolved"
      + "\nBORDER cannot be resolved"
      + "\nFILL_HORIZONTAL cannot be resolved"
      + "\naddSelectionListener cannot be resolved"
      + "\nEND cannot be resolved"
      + "\nsetLayoutData cannot be resolved"
      + "\nNONE cannot be resolved"
      + "\nBEGINNING cannot be resolved"
      + "\nSINGLE cannot be resolved"
      + "\nbitwiseOr cannot be resolved"
      + "\nBORDER cannot be resolved"
      + "\nFILL_HORIZONTAL cannot be resolved");
  }

  public java.lang.String getName() {
    return "TESL Options";
  }

  public void initializeFrom(final ILaunchConfiguration configuration) {
    throw new Error("Unresolved compilation problems:"
      + "\nString cannot be resolved to a type."
      + "\nThe method getAttribute(java.lang.String, String) is undefined for the type ILaunchConfiguration"
      + "\nThe method setText(Object) is undefined for the type Text"
      + "\nThe method getAttribute(java.lang.String, int) is undefined for the type ILaunchConfiguration"
      + "\nThe method setText(Object) is undefined for the type Text"
      + "\nThe field MainTab.ATTR_FILE refers to the missing type java.lang.String"
      + "\nThe field MainTab.ATTR_MAXSTEPS refers to the missing type java.lang.String"
      + "\n!= cannot be resolved"
      + "\ntoString cannot be resolved");
  }

  public void performApply(final ILaunchConfigurationWorkingCopy configuration) {
    throw new Error("Unresolved compilation problems:"
      + "\nNumberFormatException cannot be resolved to a type."
      + "\nThe method getText() is undefined for the type Text"
      + "\nThe method setAttribute(java.lang.String, Object) is undefined for the type ILaunchConfigurationWorkingCopy"
      + "\nThe method getText() is undefined for the type Text"
      + "\nThe method or field Integer is undefined"
      + "\nThe method setAttribute(java.lang.String, Object) is undefined for the type ILaunchConfigurationWorkingCopy"
      + "\nThe field MainTab.ATTR_FILE refers to the missing type java.lang.String"
      + "\nThe field MainTab.ATTR_MAXSTEPS refers to the missing type java.lang.String"
      + "\nNo exception of type NumberFormatException can be thrown; an exception type must be a subclass of Throwable"
      + "\ntrim cannot be resolved"
      + "\nlength cannot be resolved"
      + "\n> cannot be resolved"
      + "\ntrim cannot be resolved"
      + "\nparseInt cannot be resolved");
  }

  public void setDefaults(final ILaunchConfigurationWorkingCopy configuration) {
  }

  public Object browseTeslFiles() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method setTitle(java.lang.String) is undefined for the type ResourceListSelectionDialog"
      + "\nThe method setMessage(java.lang.String) is undefined for the type ResourceListSelectionDialog"
      + "\nThe method getResult() is undefined for the type ResourceListSelectionDialog"
      + "\nThe method setText(Object) is undefined for the type Text"
      + "\nThe method toString() is undefined for the type IPath"
      + "\ngetWorkspace cannot be resolved"
      + "\ngetRoot cannot be resolved"
      + "\nFILE cannot be resolved"
      + "\nOK cannot be resolved"
      + "\nget cannot be resolved");
  }
}

package fr.supelec.tesl.lang.ui.run;

import java.util.Collections;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

public class TESLTabGroup extends AbstractLaunchConfigurationTabGroup {
  public void createTabs(final ILaunchConfigurationDialog dialog, final /* String */Object mode) {
    MainTab _mainTab = new MainTab();
    CommonTab _commonTab = new CommonTab();
    this.setTabs(Collections.<java.lang.Object>unmodifiableList(CollectionLiterals.<java.lang.Object>newArrayList(_mainTab, _commonTab)));
  }
}

package fr.supelec.tesl.lang.ui.run

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup
import org.eclipse.debug.ui.ILaunchConfigurationDialog
import org.eclipse.debug.ui.CommonTab

class TESLTabGroup extends AbstractLaunchConfigurationTabGroup {
	
	override createTabs(ILaunchConfigurationDialog dialog, String mode) {
		setTabs( #[new MainTab, new CommonTab] )
	}
	
}
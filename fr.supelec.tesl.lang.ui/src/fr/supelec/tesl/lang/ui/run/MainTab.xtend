package fr.supelec.tesl.lang.ui.run

import org.eclipse.core.resources.IFile
import org.eclipse.core.resources.IResource
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.debug.core.ILaunchConfiguration
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab
import org.eclipse.jface.window.Window
import org.eclipse.swt.SWT
import org.eclipse.swt.events.SelectionAdapter
import org.eclipse.swt.events.SelectionEvent
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Label
import org.eclipse.swt.widgets.Text
import org.eclipse.ui.dialogs.ResourceListSelectionDialog

class MainTab extends AbstractLaunchConfigurationTab {
	var Text fFileText;
	var Text fMaxSteps;
	
	public static var ATTR_FILE = "tesl_file"
	public static var ATTR_MAXSTEPS = "max_steps"
	
	public static var DEFAULT_MAXSTEPS = 1000;
	
	override createControl(Composite parent) {
		var font = parent.getFont();
                
        var comp = new Composite(parent, SWT.NONE);
		setControl(comp);
        var topLayout = new GridLayout();
        topLayout.verticalSpacing = 0;
        topLayout.numColumns = 3;
        comp.setLayout(topLayout);
        comp.setFont(font);
                
        createVerticalSpacer(comp, 3);
        
        var Label programLabel = new Label(comp, SWT.NONE);
        programLabel.setText("TESL Specification &file:");
        var GridData gd = new GridData(GridData.BEGINNING);
        programLabel.setLayoutData(gd);
        //programLabel.setFont(font);
        
        fFileText = new Text(comp, (SWT.SINGLE.bitwiseOr(SWT.BORDER)));
        gd = new GridData(GridData.FILL_HORIZONTAL);
        fFileText.setLayoutData(gd);
        fFileText.setFont(font);
        fFileText.addModifyListener([
	        updateLaunchConfigurationDialog();
        ])
        
        var fFileButton = createPushButton(comp, "&Browse...", null)
		fFileButton.addSelectionListener(new MainTabFileBrowserListener(this))
        gd = new GridData(GridData.END);
        fFileButton.setLayoutData(gd);
        
        createVerticalSpacer(comp, 2);
        
        var Label maxLabel = new Label(comp, SWT.NONE);
        maxLabel.setText("&Max. number of steps:");
        maxLabel.setLayoutData(new GridData(GridData.BEGINNING));
        
        fMaxSteps = new Text(comp, (SWT.SINGLE.bitwiseOr(SWT.BORDER)));
        fMaxSteps.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
        fMaxSteps.setFont(font);
        fMaxSteps.addModifyListener([
        	updateLaunchConfigurationDialog();
        ])
	}
	
	override getName() {
		return "TESL Options"
	}
	
	override initializeFrom(ILaunchConfiguration configuration) {
		var file = configuration.getAttribute(ATTR_FILE, null as String);
		if(file != null) {
			fFileText.setText(file)
		}
		
		var maxSteps = configuration.getAttribute(ATTR_MAXSTEPS, DEFAULT_MAXSTEPS);
		fMaxSteps.setText(maxSteps.toString);
	}
	
	override performApply(ILaunchConfigurationWorkingCopy configuration) {
		var file = fFileText.getText().trim();
		if(file.length() > 0) {
			configuration.setAttribute(ATTR_FILE, file)
		}
		
		var max = fMaxSteps.getText().trim()
		try {
			var iMax = Integer.parseInt(max)
			configuration.setAttribute(ATTR_MAXSTEPS, iMax)	
		} catch(NumberFormatException e) {
			// do nothing
		}
	}
	
	override setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		// no default
	}
	
	
	def browseTeslFiles() {
    	var dialog = new ResourceListSelectionDialog(getShell(), ResourcesPlugin.getWorkspace().getRoot(), IResource.FILE);
        dialog.setTitle("TESL File");
        dialog.setMessage("Select the TESL file to simulate");
        if (dialog.open() == Window.OK) {
	        var files = dialog.getResult();
	        var IFile file = files.get(0) as IFile;
	        fFileText.setText(file.getFullPath().toString());
        }
        
	}	
}

class MainTabFileBrowserListener extends SelectionAdapter {
	var MainTab tab
	
	new(MainTab tab) {
		this.tab = tab
	}
	
	override widgetSelected(SelectionEvent e) {
		this.tab.browseTeslFiles();
	}
}
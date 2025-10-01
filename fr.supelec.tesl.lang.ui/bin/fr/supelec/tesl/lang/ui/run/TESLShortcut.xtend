package fr.supelec.tesl.lang.ui.run

import com.google.inject.Inject
// import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.debug.ui.ILaunchShortcut
import org.eclipse.jface.viewers.ISelection
import org.eclipse.ui.IEditorInput
import org.eclipse.ui.IEditorPart
import org.eclipse.ui.IFileEditorInput
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.jface.viewers.TreeSelection
import org.eclipse.jface.viewers.TreePath

class TESLShortcut implements ILaunchShortcut {
	
	@Inject
	var XtextResourceSet resourceSet;
	
	
	override launch(ISelection selection, String mode) {
//		System.out.println("TODO: launch(ISelection, String)")
//		System.out.println("TODO: launch(" + selection + ", " + mode + ")")
		if (selection.empty) {
			return
		}
		// The selection should be a TreeSelection
		if (selection instanceof TreeSelection) {
			// Get the paths in the selection
			var TreePath[] paths = selection.paths
			for (TreePath p : paths) {
				// Go through the segments of the paths
        		for (int i : 0..p.segmentCount - 1) {
        			var Object s = p.getSegment(i)
        			// When a segment is a file, run it as a TESL simulation
        			if (s instanceof org.eclipse.core.internal.resources.File) {
						LaunchTESLSimulation.runTESL(this.resourceSet, (s as org.eclipse.core.internal.resources.File).fullPath.toString, MainTab.DEFAULT_MAXSTEPS);
        			}
        		}
			}
		}

		
	}
	
	override launch(IEditorPart editor, String mode) {
		if (editor != null) {
	        var IEditorInput input = editor.getEditorInput();
	        
	        switch(input) {
	        	IFileEditorInput: 
					LaunchTESLSimulation.runTESL(this.resourceSet, input.file.fullPath.toString, MainTab.DEFAULT_MAXSTEPS)
	        }
        }
	}
	
}
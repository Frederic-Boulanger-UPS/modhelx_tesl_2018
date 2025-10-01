package fr.supelec.tesl.lang.ui.run;

import com.google.inject.Inject;
import org.eclipse.debug.ui.ILaunchShortcut;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.xtext.resource.XtextResourceSet;

public class TESLShortcut implements ILaunchShortcut {
  @Inject
  private XtextResourceSet resourceSet;

  public void launch(final ISelection selection, final /* String */Object mode) {
    throw new Error("Unresolved compilation problems:"
      + "\nObject cannot be resolved to a type."
      + "\nThe method getSegment(int) is undefined for the type TreePath"
      + "\nThe method or field toString is undefined for the type IPath"
      + "\nType mismatch: cannot convert from IntegerRange to int[]"
      + "\nrunTESL cannot be resolved"
      + "\nDEFAULT_MAXSTEPS cannot be resolved");
  }

  public Object launch(final IEditorPart editor, final /* String */Object mode) {
    throw new Error("Unresolved compilation problems:"
      + "\n!= cannot be resolved."
      + "\nThe method or field toString is undefined for the type IPath"
      + "\nrunTESL cannot be resolved"
      + "\nDEFAULT_MAXSTEPS cannot be resolved");
  }
}

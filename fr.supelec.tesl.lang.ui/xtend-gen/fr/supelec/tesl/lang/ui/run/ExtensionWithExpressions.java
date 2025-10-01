package fr.supelec.tesl.lang.ui.run;

import org.eclipse.xtext.xbase.lib.Extension;

/**
 * Base class for extensions which evaluate expressions
 */
public class ExtensionWithExpressions {
  private final TESLSpec spec;

  @Extension
  protected ExpressionExtensions exprExt;

  public ExtensionWithExpressions(final TESLSpec spec) {
    this.spec = spec;
    ExpressionExtensions _expressionExtensions = new ExpressionExtensions(spec);
    this.exprExt = _expressionExtensions;
  }

  public TESLSpec getSpec() {
    return this.spec;
  }
}

package fr.supelec.tesl.lang.ui.run;

import fr.supelec.tesl.core.Clock;
import fr.supelec.tesl.lang.tesl.AwaitImplication;
import fr.supelec.tesl.lang.tesl.ImplicationQualifier;
import fr.supelec.tesl.lang.tesl.ImplicationRelation;
import fr.supelec.tesl.lang.tesl.Relation;
import fr.supelec.tesl.lang.tesl.TagExpr;
import fr.supelec.tesl.lang.tesl.TagRelation;
import fr.supelec.tesl.lang.ui.run.AwaitImplicationExtensions;
import fr.supelec.tesl.lang.ui.run.ExtensionWithExpressions;
import fr.supelec.tesl.lang.ui.run.ImplicationQualifierExtensions;
import fr.supelec.tesl.lang.ui.run.TESLSpec;
import fr.supelec.tesl.lang.ui.run.TagExpressionExtensions;
import java.util.Arrays;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class RelationExtensions extends ExtensionWithExpressions {
  @Extension
  private ImplicationQualifierExtensions impQualExt;
  
  @Extension
  private TagExpressionExtensions tagExprExt;
  
  @Extension
  private AwaitImplicationExtensions awaitExt;
  
  public RelationExtensions(final TESLSpec spec) {
    super(spec);
    ImplicationQualifierExtensions _implicationQualifierExtensions = new ImplicationQualifierExtensions(spec);
    this.impQualExt = _implicationQualifierExtensions;
    TagExpressionExtensions _tagExpressionExtensions = new TagExpressionExtensions(spec);
    this.tagExprExt = _tagExpressionExtensions;
    AwaitImplicationExtensions _awaitImplicationExtensions = new AwaitImplicationExtensions(spec);
    this.awaitExt = _awaitImplicationExtensions;
  }
  
  protected void _process(final ImplicationRelation ir) {
    final Clock<?> source = this.getSpec().getClock(ir.getSource().getName());
    final Clock<?> target = this.getSpec().getClock(ir.getTarget().getName());
    final ImplicationQualifier qual = ir.getQual();
    this.impQualExt.process(qual, source, target);
  }
  
  protected void _process(final AwaitImplication ai) {
    this.awaitExt.process(ai);
  }
  
  protected void _process(final TagRelation tr) {
    final TagExpr expr = tr.getExpr();
    final Clock<?> x = this.getSpec().getClock(expr.getClockX().getName());
    final Clock<?> y = this.getSpec().getClock(expr.getClockY().getName());
    this.tagExprExt.process(expr, x, y);
  }
  
  protected void _process(final Relation r) {
    try {
      this.getSpec().reportError(r, ("Unsupported relation type: " + r));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void process(final Relation ai) {
    if (ai instanceof AwaitImplication) {
      _process((AwaitImplication)ai);
      return;
    } else if (ai instanceof ImplicationRelation) {
      _process((ImplicationRelation)ai);
      return;
    } else if (ai instanceof TagRelation) {
      _process((TagRelation)ai);
      return;
    } else if (ai != null) {
      _process(ai);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(ai).toString());
    }
  }
}

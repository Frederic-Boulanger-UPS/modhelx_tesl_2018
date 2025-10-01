package fr.supelec.tesl.lang.ui.run

import fr.supelec.tesl.lang.tesl.ImplicationRelation
import fr.supelec.tesl.lang.tesl.Relation
import fr.supelec.tesl.lang.tesl.TagRelation
import fr.supelec.tesl.lang.tesl.AwaitImplication

//* Extension methods for tesl.lang.Relation
class RelationExtensions extends ExtensionWithExpressions {
    extension ImplicationQualifierExtensions impQualExt
    extension TagExpressionExtensions tagExprExt
    extension AwaitImplicationExtensions awaitExt

    new(TESLSpec spec) {
        super(spec)
        impQualExt = new ImplicationQualifierExtensions(spec)
        tagExprExt = new TagExpressionExtensions(spec)
        awaitExt = new AwaitImplicationExtensions(spec)
    }

    def dispatch void process(ImplicationRelation ir) {
        val source = spec.getClock(ir.getSource().getName());
        val target = spec.getClock(ir.getTarget().getName());
        val qual = ir.getQual();

        qual.process(source, target)
    }

    def dispatch void process(AwaitImplication ai) {
        ai.process()
    }

    def dispatch void process(TagRelation tr) {
        val expr = tr.expr
        val x = spec.getClock(expr.clockX.name)
        val y = spec.getClock(expr.clockY.name)

		expr.process(x, y)
    }

    // Fallback for unknown relations
    def dispatch void process(Relation r) {
        spec.reportError(r, "Unsupported relation type: " + r)
    }
}

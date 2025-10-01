package fr.supelec.tesl.lang.ui.run

/** Base class for extensions which evaluate expressions */
class ExtensionWithExpressions {
    val TESLSpec spec
    protected extension ExpressionExtensions exprExt
    
    new (TESLSpec spec) {
        this.spec = spec
        exprExt = new ExpressionExtensions(spec)
    }
    def getSpec() {
        return this.spec
    }    
}


package fr.supelec.modhelx.core.abstractsemantics;

public class InputOutputPin extends Pin implements fr.supelec.modhelx.core.ecore.InputOutputPin {
    /** Build a new pin named <code>name</code>. */
    public InputOutputPin(String name, Object ... properties) {
        super(name, properties);
    }
    
    @Override
    public boolean isInputPin() {
    	return true;
    }
    
    @Override
    public boolean isOutputPin() {
    	return true;
    }
}

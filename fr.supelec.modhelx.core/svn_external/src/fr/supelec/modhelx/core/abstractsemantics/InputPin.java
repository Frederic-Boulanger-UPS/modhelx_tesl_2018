package fr.supelec.modhelx.core.abstractsemantics;

public class InputPin extends Pin implements fr.supelec.modhelx.core.ecore.InputPin {
    /** Build a new pin named <code>name</code>. */
    public InputPin(String name, Object ... properties) {
        super(name, properties);
    }
    
    /*
    @Override
    public void addOutgoing(Relation r) {
    	throw new RuntimeException("An input pin cannot have outgoing relations: " + this.getName());
    }
    */
    
    @Override
    public boolean isInputPin() {
    	return true;
    }
}

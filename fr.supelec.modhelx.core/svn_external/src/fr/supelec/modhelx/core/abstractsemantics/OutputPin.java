package fr.supelec.modhelx.core.abstractsemantics;

public class OutputPin extends Pin implements fr.supelec.modhelx.core.ecore.OutputPin {
    /** Build a new pin named <code>name</code>. */
    public OutputPin(String name, Object ... properties) {
        super(name, properties);
    }
    
    /*
    @Override
    public void addIncoming(Relation r) {
    	throw new RuntimeException("An output pin cannot have incoming relations: " + this.getName());
    }
    */
    
    @Override
    public boolean isOutputPin() {
    	return true;
    }
}

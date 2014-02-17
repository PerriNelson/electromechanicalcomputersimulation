package electroMechanicalLogic.Interfaces;

public interface IHalfAdder extends ISimulatedCircuit {

	public abstract boolean getCO();

	public abstract boolean getS();

	public abstract void setA(boolean value);

	public abstract void setB(boolean value);
}
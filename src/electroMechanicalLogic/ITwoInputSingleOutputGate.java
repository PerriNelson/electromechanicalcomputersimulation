package electroMechanicalLogic;

public interface ITwoInputSingleOutputGate {

	public abstract boolean getA();

	public abstract boolean getB();

	public abstract boolean getOutput();

	public abstract boolean getPower();

	public abstract void setA(boolean value);

	public abstract void setB(boolean value);

	public abstract void setPower(boolean value);

	public abstract void step();

}
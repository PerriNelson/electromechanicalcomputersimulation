package electroMechanicalLogic.Interfaces;

public interface IFullAdder {

	public abstract boolean getCO();

	public abstract boolean getS();

	public abstract void setA(boolean value);

	public abstract void setB(boolean value);

	public abstract void setCI(boolean value);

	public abstract void setPower(boolean value);

	public abstract void step();

}
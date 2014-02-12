package electroMechanicalLogic.Interfaces;

public interface IHalfAdder {

	public abstract boolean getCO();

	public abstract boolean getS();

	public abstract void setA(boolean value);

	public abstract void setB(boolean value);

	public abstract void setPower(boolean value);

	public abstract void step();

}
package electroMechanicalLogic;

public interface IRelay {

	public abstract boolean getInput();

	public abstract boolean getOutput();

	public abstract boolean getPower();

	public abstract void setInput(boolean value);

	public abstract void setPower(boolean value);

	public abstract void step();

}
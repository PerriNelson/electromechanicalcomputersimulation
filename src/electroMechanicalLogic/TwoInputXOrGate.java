package electroMechanicalLogic;

public final class TwoInputXOrGate implements ITwoInputSingleOutputGate {

	private ITwoInputSingleOutputGate nAnd = new TwoInputNAndGate();
	private ITwoInputSingleOutputGate or = new TwoInputOrGate();
	private ITwoInputSingleOutputGate and = new TwoInputAndGate();

	public boolean getA() {
		return nAnd.getA();
	}

	public boolean getB() {
		return nAnd.getB();
	}

	public boolean getOutput() {
		return and.getOutput();
	}

	public boolean getPower() {
		return nAnd.getPower();
	}

	public synchronized void setA(boolean value) {
		nAnd.setA(value);
		or.setA(value);
	}

	public synchronized void setB(boolean value) {
		nAnd.setB(value);
		or.setB(value);
	}

	public synchronized void setPower(boolean value) {
		nAnd.setPower(value);
		or.setPower(value);
		and.setPower(value);
	}

	public synchronized void step() {
		nAnd.step();
		or.step();
		and.setA(nAnd.getOutput());
		and.setB(or.getOutput());
		and.step();
	}

}

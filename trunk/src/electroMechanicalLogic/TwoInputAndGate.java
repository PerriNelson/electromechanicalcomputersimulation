package electroMechanicalLogic;

public final class TwoInputAndGate extends TwoRelaySingleOutputGate implements
		ITwoInputSingleOutputGate {

	public TwoInputAndGate() {
		super(new Buffer(), new Buffer());
	}

	public boolean getOutput() {
		return relayB.getOutput();
	}

	public boolean getPower() {
		return relayA.getPower();
	}

	public void setPower(boolean value) {
		relayA.setPower(value);
	}

	public synchronized void step() {
		relayA.step();
		relayB.setPower(relayA.getOutput());
		relayB.step();
	}
}

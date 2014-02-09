package electroMechanicalLogic;

public final class TwoInputOrGate extends TwoRelaySingleOutputGate implements
		ITwoInputSingleOutputGate {

	public TwoInputOrGate() {
		super(new Buffer(), new Buffer());
	}

	public synchronized boolean getOutput() {
		return relayA.getOutput() || relayB.getOutput();
	}

	public boolean getPower() {
		return relayA.getPower();
	}

	public synchronized void setPower(boolean value) {
		relayA.setPower(value);
		relayB.setPower(value);
	}

	public void step() {
		relayA.step();
		relayB.step();
	}
}

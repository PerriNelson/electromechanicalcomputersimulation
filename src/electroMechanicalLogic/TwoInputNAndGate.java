package electroMechanicalLogic;

public final class TwoInputNAndGate extends TwoRelaySingleOutputGate implements
		ITwoInputSingleOutputGate {

	public TwoInputNAndGate() {
		super(new Inverter(), new Inverter());
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

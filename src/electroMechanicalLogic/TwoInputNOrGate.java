package electroMechanicalLogic;

public final class TwoInputNOrGate extends TwoRelaySingleOutputGate implements
		ITwoInputSingleOutputGate {

	public TwoInputNOrGate() {
		super(new Inverter(), new Inverter());
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

package electroMechanicalLogic;

abstract class TwoRelaySingleOutputGate {
	final IRelay relayA;
	final IRelay relayB;

	TwoRelaySingleOutputGate(IRelay relayA, IRelay relayB) {
		super();

		this.relayA = relayA;
		this.relayB = relayB;
	}

	public final boolean getA() {
		return relayA.getInput();
	}

	public final boolean getB() {
		return relayB.getInput();
	}

	public final void setA(boolean value) {
		relayA.setInput(value);
	}

	public final void setB(boolean value) {
		relayB.setInput(value);
	}

}
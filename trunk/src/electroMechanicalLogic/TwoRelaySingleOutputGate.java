/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */
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
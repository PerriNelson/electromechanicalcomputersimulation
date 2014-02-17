/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */
package electroMechanicalLogic;

import electroMechanicalLogic.Interfaces.IRelay;

abstract class TwoRelaySingleOutputGate {
	protected final IRelay relayA;
	protected final IRelay relayB;

	TwoRelaySingleOutputGate(IRelay relayA, IRelay relayB) {
		this.relayA = relayA;
		this.relayB = relayB;
	}

	public void setA(boolean value) {
		relayA.setInput(value);
	}

	public void setB(boolean value) {
		relayB.setInput(value);
	}
}
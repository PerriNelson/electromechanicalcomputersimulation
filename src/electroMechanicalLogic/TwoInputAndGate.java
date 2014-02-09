/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */
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

	public void step() {
		relayA.step();
		relayB.setPower(relayA.getOutput());
		relayB.step();
	}
}
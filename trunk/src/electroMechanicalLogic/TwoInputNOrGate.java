/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */
package electroMechanicalLogic;

public final class TwoInputNOrGate extends TwoRelaySingleOutputGate implements
		ITwoInputSingleOutputGate {

	public TwoInputNOrGate() {
		super(new Inverter(), new Inverter());
	}

	@Override
	public boolean getOutput() {
		return relayB.getOutput();
	}

	@Override
	public boolean getPower() {
		return relayA.getPower();
	}

	@Override
	public void setPower(boolean value) {
		relayA.setPower(value);
	}

	@Override
	public void step() {
		relayA.step();
		relayB.setPower(relayA.getOutput());
		relayB.step();
	}

}

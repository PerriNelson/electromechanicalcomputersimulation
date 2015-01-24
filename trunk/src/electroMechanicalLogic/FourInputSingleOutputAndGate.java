/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic;

import electroMechanicalLogic.Interfaces.IFourInputSingleOutputGate;
import electroMechanicalLogic.Interfaces.IRelay;

public final class FourInputSingleOutputAndGate implements
		IFourInputSingleOutputGate {

	private final IRelay relayA = new Buffer();
	private final IRelay relayB = new Buffer();
	private final IRelay relayC = new Buffer();
	private final IRelay relayD = new Buffer();

	@Override
	public boolean getOutput() {
		return relayD.getOutput();
	}

	@Override
	public void setA(final boolean value) {
		relayA.setInput(value);
	}

	@Override
	public void setB(final boolean value) {
		relayB.setInput(value);
	}

	@Override
	public void setC(final boolean value) {
		relayC.setInput(value);
	}

	@Override
	public void setD(final boolean value) {
		relayD.setInput(value);
	}

	@Override
	public void setPower(final boolean value) {
		relayA.setPower(value);
	}

	@Override
	public void step() {
		relayA.step();

		relayB.setPower(relayA.getOutput());
		relayB.step();

		relayC.setPower(relayB.getOutput());
		relayC.step();

		relayD.setPower(relayC.getOutput());
		relayD.step();
	}

}

/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic;

import electroMechanicalLogic.Interfaces.IRSFlipFlop;
import electroMechanicalLogic.Interfaces.ITwoInputSingleOutputGate;

public final class RSFlipFlop implements IRSFlipFlop {

	public ITwoInputSingleOutputGate norR = new TwoInputNOrGate();
	public ITwoInputSingleOutputGate norS = new TwoInputNOrGate();

	@Override
	public boolean getQ() {
		return norR.getOutput();
	}

	@Override
	public boolean getQBar() {
		return norS.getOutput();
	}

	private void halfStep() {
		norR.setA(norS.getOutput());
		norS.setB(norR.getOutput());

		norR.step();
		norS.step();
	}

	@Override
	public void setPower(boolean value) {
		norR.setPower(value);
		norS.setPower(value);
	}

	@Override
	public void setR(boolean value) {
		norR.setB(value);
	}

	@Override
	public void setS(boolean value) {
		norS.setA(value);
	}

	@Override
	public void step() {
		halfStep();
		halfStep();
	}
}

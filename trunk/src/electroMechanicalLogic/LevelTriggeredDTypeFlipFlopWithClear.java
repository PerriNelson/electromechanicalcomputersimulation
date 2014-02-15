/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic;

import electroMechanicalLogic.Interfaces.IDTypeFlipFlopWithClear;
import electroMechanicalLogic.Interfaces.ITwoInputSingleOutputGate;

public class LevelTriggeredDTypeFlipFlopWithClear extends
		LevelTriggeredDTypeFlipFlop implements IDTypeFlipFlopWithClear {

	private ITwoInputSingleOutputGate clear = new TwoInputOrGate();

	@Override
	public void setClear(boolean value) {
		clear.setB(value);
	}

	@Override
	public void setPower(boolean value) {
		super.setPower(value);
		clear.setPower(value);
	}

	@Override
	public void step() {
		dBar.step();
		rAnd.setB(dBar.getOutput());
		sAnd.step();
		rAnd.step();
		clear.setA(rAnd.getOutput());
		clear.step();
		flipFlop.setS(sAnd.getOutput());
		flipFlop.setR(clear.getOutput());
		flipFlop.step();
	}
}

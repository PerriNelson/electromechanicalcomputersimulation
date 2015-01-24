/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic;

import electroMechanicalLogic.Interfaces.IDTypeFlipFlopWithClear;
import electroMechanicalLogic.Interfaces.ILatchWithClear;

public class LatchWithClear implements ILatchWithClear {
	private final IDTypeFlipFlopWithClear flipFlop = new LevelTriggeredDTypeFlipFlopWithClear();

	@Override
	public boolean getDO() {
		return flipFlop.getQ();
	}

	@Override
	public void setClr(final boolean value) {
		flipFlop.setClear(value);
	}

	@Override
	public void setDI(final boolean value) {
		flipFlop.setD(value);
	}

	@Override
	public void setPower(final boolean value) {
		flipFlop.setPower(value);
	}

	@Override
	public void setW(final boolean value) {
		flipFlop.setClk(value);
	}

	@Override
	public void step() {
		flipFlop.step();
	}

}

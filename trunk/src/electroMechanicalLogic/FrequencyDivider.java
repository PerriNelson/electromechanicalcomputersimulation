/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic;

import electroMechanicalLogic.Interfaces.IDTypeFlipFlop;
import electroMechanicalLogic.Interfaces.IFrequencyDivider;

public class FrequencyDivider implements IFrequencyDivider {
	private IDTypeFlipFlop flipFlop = new EdgeTriggeredDTypeFlipFlop();

	@Override
	public boolean getQ() {
		return flipFlop.getQ();
	}

	@Override
	public boolean getQBar() {
		return flipFlop.getQBar();
	}

	@Override
	public void setClk(boolean value) {
		flipFlop.setClk(value);
	}

	@Override
	public void setPower(boolean value) {
		flipFlop.setPower(value);
	}

	@Override
	public void step() {
		flipFlop.setD(flipFlop.getQBar());
		flipFlop.step();
	}
}

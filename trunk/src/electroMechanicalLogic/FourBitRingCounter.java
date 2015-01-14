/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic;

import electroMechanicalLogic.Interfaces.IDTypeFlipFlopWithPresetAndClear;
import electroMechanicalLogic.Interfaces.IFourBitRingCounter;

public class FourBitRingCounter implements IFourBitRingCounter {

	private IDTypeFlipFlopWithPresetAndClear bit0 = new EdgeTriggeredDTypeFlipFlopWithPresetAndClear();
	private IDTypeFlipFlopWithPresetAndClear bit1 = new EdgeTriggeredDTypeFlipFlopWithPresetAndClear();
	private IDTypeFlipFlopWithPresetAndClear bit2 = new EdgeTriggeredDTypeFlipFlopWithPresetAndClear();
	private IDTypeFlipFlopWithPresetAndClear bit3 = new EdgeTriggeredDTypeFlipFlopWithPresetAndClear();

	@Override
	public boolean getQ0() {
		return bit0.getQ();
	}

	@Override
	public boolean getQ1() {
		return bit1.getQ();
	}

	@Override
	public boolean getQ2() {
		return bit2.getQ();
	}

	@Override
	public boolean getQ3() {
		return bit3.getQ();
	}

	@Override
	public void setClear(boolean value) {
		bit0.setClear(value);
		bit1.setClear(value);
		bit2.setClear(value);
		bit3.setPreset(value);
	}

	@Override
	public void setClk(boolean value) {
		bit0.setClk(value);
		bit1.setClk(value);
		bit2.setClk(value);
		bit3.setClk(value);
	}

	@Override
	public void setPower(boolean value) {
		bit0.setPower(value);
		bit1.setPower(value);
		bit2.setPower(value);
		bit3.setPower(value);
	}

	@Override
	public void step() {
		bit0.setD(bit3.getQ());
		bit1.setD(bit0.getQ());
		bit2.setD(bit1.getQ());
		bit3.setD(bit2.getQ());

		bit0.step();
		bit1.step();
		bit2.step();
		bit3.step();
	}
}

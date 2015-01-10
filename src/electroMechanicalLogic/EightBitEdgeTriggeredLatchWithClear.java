/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic;

import electroMechanicalLogic.Interfaces.IDTypeFlipFlopWithPresetAndClear;
import electroMechanicalLogic.Interfaces.IEightBitLatchWithClear;
import electroMechanicalLogic.Interfaces.ILatchWithClear;

public class EightBitEdgeTriggeredLatchWithClear implements IEightBitLatchWithClear {
	private IDTypeFlipFlopWithPresetAndClear bit0 = new EdgeTriggeredDTypeFlipFlopWithPresetAndClear();
	private IDTypeFlipFlopWithPresetAndClear bit1 = new EdgeTriggeredDTypeFlipFlopWithPresetAndClear();
	private IDTypeFlipFlopWithPresetAndClear bit2 = new EdgeTriggeredDTypeFlipFlopWithPresetAndClear();
	private IDTypeFlipFlopWithPresetAndClear bit3 = new EdgeTriggeredDTypeFlipFlopWithPresetAndClear();
	private IDTypeFlipFlopWithPresetAndClear bit4 = new EdgeTriggeredDTypeFlipFlopWithPresetAndClear();
	private IDTypeFlipFlopWithPresetAndClear bit5 = new EdgeTriggeredDTypeFlipFlopWithPresetAndClear();
	private IDTypeFlipFlopWithPresetAndClear bit6 = new EdgeTriggeredDTypeFlipFlopWithPresetAndClear();
	private IDTypeFlipFlopWithPresetAndClear bit7 = new EdgeTriggeredDTypeFlipFlopWithPresetAndClear();

	@Override
	public boolean getDO0() {
		return bit0.getQ();
	}

	@Override
	public boolean getDO1() {
		return bit1.getQ();
	}

	@Override
	public boolean getDO2() {
		return bit2.getQ();
	}

	@Override
	public boolean getDO3() {
		return bit3.getQ();
	}

	@Override
	public boolean getDO4() {
		return bit4.getQ();
	}

	@Override
	public boolean getDO5() {
		return bit5.getQ();
	}

	@Override
	public boolean getDO6() {
		return bit6.getQ();
	}

	@Override
	public boolean getDO7() {
		return bit7.getQ();
	}

	@Override
	public void setClr(boolean value) {
		bit0.setClear(value);
		bit1.setClear(value);
		bit2.setClear(value);
		bit3.setClear(value);
		bit4.setClear(value);
		bit5.setClear(value);
		bit6.setClear(value);
		bit7.setClear(value);
	}

	@Override
	public void setDI0(boolean value) {
		bit0.setD(value);
	}

	@Override
	public void setDI1(boolean value) {
		bit1.setD(value);
	}

	@Override
	public void setDI2(boolean value) {
		bit2.setD(value);
	}

	@Override
	public void setDI3(boolean value) {
		bit3.setD(value);
	}

	@Override
	public void setDI4(boolean value) {
		bit4.setD(value);
	}

	@Override
	public void setDI5(boolean value) {
		bit5.setD(value);
	}

	@Override
	public void setDI6(boolean value) {
		bit6.setD(value);
	}

	@Override
	public void setDI7(boolean value) {
		bit7.setD(value);
	}

	@Override
	public void setPower(boolean value) {
		bit0.setPower(value);
		bit1.setPower(value);
		bit2.setPower(value);
		bit3.setPower(value);
		bit4.setPower(value);
		bit5.setPower(value);
		bit6.setPower(value);
		bit7.setPower(value);
	}

	@Override
	public void setW(boolean value) {
		bit0.setClk(value);
		bit1.setClk(value);
		bit2.setClk(value);
		bit3.setClk(value);
		bit4.setClk(value);
		bit5.setClk(value);
		bit6.setClk(value);
		bit7.setClk(value);
	}

	@Override
	public void step() {
		bit0.step();
		bit1.step();
		bit2.step();
		bit3.step();
		bit4.step();
		bit5.step();
		bit6.step();
		bit7.step();
	}
}

/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic;

import electroMechanicalLogic.Interfaces.IEightByOneBitRandomAccessMemory;
import electroMechanicalLogic.Interfaces.IOneLineToTwoLineDecoder;
import electroMechanicalLogic.Interfaces.ISixteenByOneBitRandomAccessMemory;
import electroMechanicalLogic.Interfaces.ITwoLineToOneLineSelector;

public class SixteenByOneBitRandomAccessMemory implements
		ISixteenByOneBitRandomAccessMemory {

	private IOneLineToTwoLineDecoder decoder = new OneLineToTwoLineDecoder();
	private ITwoLineToOneLineSelector selector = new TwoLineToOneLineSelector();
	private IEightByOneBitRandomAccessMemory bank0 = new EightByOneBitRandomAccessMemory();
	private IEightByOneBitRandomAccessMemory bank1 = new EightByOneBitRandomAccessMemory();

	@Override
	public boolean getDO() {
		return selector.getQ();
	}

	@Override
	public void setA0(boolean value) {
		bank0.setA0(value);
		bank1.setA0(value);
	}

	@Override
	public void setA1(boolean value) {
		bank0.setA1(value);
		bank1.setA1(value);
	}

	@Override
	public void setA2(boolean value) {
		bank0.setA2(value);
		bank1.setA2(value);
	}

	@Override
	public void setA3(boolean value) {
		decoder.setSelect(value);
		selector.setSelect(value);
	}

	@Override
	public void setDI(boolean value) {
		bank0.setDI(value);
		bank1.setDI(value);
	}

	@Override
	public void setPower(boolean value) {
		decoder.setPower(value);
		bank0.setPower(value);
		bank1.setPower(value);
		selector.setPower(value);
	}

	@Override
	public void setW(boolean value) {
		decoder.setInput(value);
	}

	@Override
	public void step() {
		decoder.step();

		bank0.setW(decoder.getO0());
		bank0.step();

		bank1.setW(decoder.getO1());
		bank1.step();

		selector.setA(bank0.getDO());
		selector.setB(bank1.getDO());
		selector.step();
	}

}

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

	private final IOneLineToTwoLineDecoder decoder = new OneLineToTwoLineDecoder();
	private final ITwoLineToOneLineSelector selector = new TwoLineToOneLineSelector();
	private final IEightByOneBitRandomAccessMemory bank0 = new EightByOneBitRandomAccessMemory();
	private final IEightByOneBitRandomAccessMemory bank1 = new EightByOneBitRandomAccessMemory();

	@Override
	public boolean getDO() {
		return selector.getDO();
	}

	@Override
	public void setA0(final boolean value) {
		bank0.setA0(value);
		bank1.setA0(value);
	}

	@Override
	public void setA1(final boolean value) {
		bank0.setA1(value);
		bank1.setA1(value);
	}

	@Override
	public void setA2(final boolean value) {
		bank0.setA2(value);
		bank1.setA2(value);
	}

	@Override
	public void setA3(final boolean value) {
		decoder.setSelect(value);
		selector.setSelect(value);
	}

	@Override
	public void setDI(final boolean value) {
		bank0.setDI(value);
		bank1.setDI(value);
	}

	@Override
	public void setPower(final boolean value) {
		decoder.setPower(value);
		bank0.setPower(value);
		bank1.setPower(value);
		selector.setPower(value);
	}

	@Override
	public void setW(final boolean value) {
		decoder.setInput(value);
	}

	@Override
	public void step() {
		decoder.step();

		bank0.setW(decoder.getA());
		bank0.step();

		bank1.setW(decoder.getB());
		bank1.step();

		selector.setA(bank0.getDO());
		selector.setB(bank1.getDO());
		selector.step();
	}

}

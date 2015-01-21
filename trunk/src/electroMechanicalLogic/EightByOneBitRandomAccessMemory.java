/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic;

import electroMechanicalLogic.Interfaces.IEightByOneBitRandomAccessMemory;
import electroMechanicalLogic.Interfaces.IEightToOneSelector;
import electroMechanicalLogic.Interfaces.ILatch;
import electroMechanicalLogic.Interfaces.IThreeToEightDecoder;

public final class EightByOneBitRandomAccessMemory implements
		IEightByOneBitRandomAccessMemory {
	private IThreeToEightDecoder decoder = new ThreeToEightDecoder();
	private ILatch bit0 = new Latch();
	private ILatch bit1 = new Latch();
	private ILatch bit2 = new Latch();
	private ILatch bit3 = new Latch();
	private ILatch bit4 = new Latch();
	private ILatch bit5 = new Latch();
	private ILatch bit6 = new Latch();
	private ILatch bit7 = new Latch();
	private IEightToOneSelector selector = new EightToOneSelector();

	@Override
	public boolean getDO() {
		return selector.getOutput();
	}

	@Override
	public void setA0(boolean value) {
		decoder.setS0(value);
		selector.setS0(value);
	}

	@Override
	public void setA1(boolean value) {
		decoder.setS1(value);
		selector.setS1(value);
	}

	@Override
	public void setA2(boolean value) {
		decoder.setS2(value);
		selector.setS2(value);
	}

	@Override
	public void setDI(boolean value) {
		bit0.setDI(value);
		bit1.setDI(value);
		bit2.setDI(value);
		bit3.setDI(value);
		bit4.setDI(value);
		bit5.setDI(value);
		bit6.setDI(value);
		bit7.setDI(value);
	}

	@Override
	public void setPower(boolean value) {
		decoder.setPower(value);
		bit0.setPower(value);
		bit1.setPower(value);
		bit2.setPower(value);
		bit3.setPower(value);
		bit4.setPower(value);
		bit5.setPower(value);
		bit6.setPower(value);
		bit7.setPower(value);
		selector.setPower(value);
	}

	@Override
	public void setW(boolean value) {
		decoder.setData(value);
	}

	@Override
	public void step() {
		decoder.step();

		bit0.setW(decoder.getO0());
		bit1.setW(decoder.getO1());
		bit2.setW(decoder.getO2());
		bit3.setW(decoder.getO3());
		bit4.setW(decoder.getO4());
		bit5.setW(decoder.getO5());
		bit6.setW(decoder.getO6());
		bit7.setW(decoder.getO7());

		bit0.step();
		bit1.step();
		bit2.step();
		bit3.step();
		bit4.step();
		bit5.step();
		bit6.step();
		bit7.step();

		selector.setD0(bit0.getDO());
		selector.setD1(bit1.getDO());
		selector.setD2(bit2.getDO());
		selector.setD3(bit3.getDO());
		selector.setD4(bit4.getDO());
		selector.setD5(bit5.getDO());
		selector.setD6(bit6.getDO());
		selector.setD7(bit7.getDO());

		selector.step();
	}
}
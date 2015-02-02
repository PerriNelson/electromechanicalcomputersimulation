/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.RAM;

import electroMechanicalLogic.EightToOneSelector;
import electroMechanicalLogic.Latch;
import electroMechanicalLogic.ThreeToEightDecoder;
import electroMechanicalLogic.Interfaces.IEightToOneSelector;
import electroMechanicalLogic.Interfaces.ILatch;
import electroMechanicalLogic.Interfaces.IThreeToEightDecoder;
import electroMechanicalLogic.RAM.Interfaces.IEightBitRAM;

public final class EightBitRAM implements IEightBitRAM {
	private final IThreeToEightDecoder decoder = new ThreeToEightDecoder();
	private final ILatch bit0 = new Latch();
	private final ILatch bit1 = new Latch();
	private final ILatch bit2 = new Latch();
	private final ILatch bit3 = new Latch();
	private final ILatch bit4 = new Latch();
	private final ILatch bit5 = new Latch();
	private final ILatch bit6 = new Latch();
	private final ILatch bit7 = new Latch();
	private final IEightToOneSelector selector = new EightToOneSelector();

	@Override
	public boolean getDO() {
		return selector.getOutput();
	}

	@Override
	public void setA0(final boolean value) {
		decoder.setS0(value);
		selector.setS0(value);
	}

	@Override
	public void setA1(final boolean value) {
		decoder.setS1(value);
		selector.setS1(value);
	}

	@Override
	public void setA2(final boolean value) {
		decoder.setS2(value);
		selector.setS2(value);
	}

	@Override
	public void setDI(final boolean value) {
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
	public void setPower(final boolean value) {
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
	public void setW(final boolean value) {
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

		selector.setDI0(bit0.getDO());
		selector.setDI1(bit1.getDO());
		selector.setDI2(bit2.getDO());
		selector.setDI3(bit3.getDO());
		selector.setDI4(bit4.getDO());
		selector.setDI5(bit5.getDO());
		selector.setDI6(bit6.getDO());
		selector.setDI7(bit7.getDO());

		selector.step();
	}
}

/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic;

import electroMechanicalLogic.Interfaces.IEightBitLatchWithClear;
import electroMechanicalLogic.Interfaces.ILatchWithClear;

public class EightBitLatchWithClear implements IEightBitLatchWithClear {
	private final ILatchWithClear bit0 = new LatchWithClear();
	private final ILatchWithClear bit1 = new LatchWithClear();
	private final ILatchWithClear bit2 = new LatchWithClear();
	private final ILatchWithClear bit3 = new LatchWithClear();
	private final ILatchWithClear bit4 = new LatchWithClear();
	private final ILatchWithClear bit5 = new LatchWithClear();
	private final ILatchWithClear bit6 = new LatchWithClear();
	private final ILatchWithClear bit7 = new LatchWithClear();

	@Override
	public boolean getDO0() {
		return bit0.getDO();
	}

	@Override
	public boolean getDO1() {
		return bit1.getDO();
	}

	@Override
	public boolean getDO2() {
		return bit2.getDO();
	}

	@Override
	public boolean getDO3() {
		return bit3.getDO();
	}

	@Override
	public boolean getDO4() {
		return bit4.getDO();
	}

	@Override
	public boolean getDO5() {
		return bit5.getDO();
	}

	@Override
	public boolean getDO6() {
		return bit6.getDO();
	}

	@Override
	public boolean getDO7() {
		return bit7.getDO();
	}

	@Override
	public void setClr(final boolean value) {
		bit0.setClr(value);
		bit1.setClr(value);
		bit2.setClr(value);
		bit3.setClr(value);
		bit4.setClr(value);
		bit5.setClr(value);
		bit6.setClr(value);
		bit7.setClr(value);
	}

	@Override
	public void setDI0(final boolean value) {
		bit0.setDI(value);
	}

	@Override
	public void setDI1(final boolean value) {
		bit1.setDI(value);
	}

	@Override
	public void setDI2(final boolean value) {
		bit2.setDI(value);
	}

	@Override
	public void setDI3(final boolean value) {
		bit3.setDI(value);
	}

	@Override
	public void setDI4(final boolean value) {
		bit4.setDI(value);
	}

	@Override
	public void setDI5(final boolean value) {
		bit5.setDI(value);
	}

	@Override
	public void setDI6(final boolean value) {
		bit6.setDI(value);
	}

	@Override
	public void setDI7(final boolean value) {
		bit7.setDI(value);
	}

	@Override
	public void setPower(final boolean value) {
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
	public void setW(final boolean value) {
		bit0.setW(value);
		bit1.setW(value);
		bit2.setW(value);
		bit3.setW(value);
		bit4.setW(value);
		bit5.setW(value);
		bit6.setW(value);
		bit7.setW(value);
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

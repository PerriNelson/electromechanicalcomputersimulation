/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic;

import electroMechanicalLogic.Interfaces.IEightBitLatch;
import electroMechanicalLogic.Interfaces.ILatch;

public class EightBitLatch implements IEightBitLatch {
	private ILatch bit0 = new Latch();
	private ILatch bit1 = new Latch();
	private ILatch bit2 = new Latch();
	private ILatch bit3 = new Latch();
	private ILatch bit4 = new Latch();
	private ILatch bit5 = new Latch();
	private ILatch bit6 = new Latch();
	private ILatch bit7 = new Latch();

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
	public void setDI0(boolean value) {
		bit0.setDI(value);
	}

	@Override
	public void setDI1(boolean value) {
		bit1.setDI(value);
	}

	@Override
	public void setDI2(boolean value) {
		bit2.setDI(value);
	}

	@Override
	public void setDI3(boolean value) {
		bit3.setDI(value);
	}

	@Override
	public void setDI4(boolean value) {
		bit4.setDI(value);
	}

	@Override
	public void setDI5(boolean value) {
		bit5.setDI(value);
	}

	@Override
	public void setDI6(boolean value) {
		bit6.setDI(value);
	}

	@Override
	public void setDI7(boolean value) {
		bit7.setDI(value);
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

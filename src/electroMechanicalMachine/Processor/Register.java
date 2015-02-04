/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Processor;

import electroMechanicalLogic.EightBitEdgeTriggeredLatchWithClear;
import electroMechanicalLogic.Interfaces.IEightBitLatchWithClear;
import electroMechanicalMachine.Processor.Interfaces.IRegister;

public class Register implements IRegister {
	private final IEightBitLatchWithClear latch = new EightBitEdgeTriggeredLatchWithClear();

	@Override
	public boolean getDO0() {
		return latch.getDO0();
	}

	@Override
	public boolean getDO1() {
		return latch.getDO1();
	}

	@Override
	public boolean getDO2() {
		return latch.getDO2();
	}

	@Override
	public boolean getDO3() {
		return latch.getDO3();
	}

	@Override
	public boolean getDO4() {
		return latch.getDO4();
	}

	@Override
	public boolean getDO5() {
		return latch.getDO5();
	}

	@Override
	public boolean getDO6() {
		return latch.getDO6();
	}

	@Override
	public boolean getDO7() {
		return latch.getDO7();
	}

	@Override
	public void setDI0(final boolean value) {
		latch.setDI0(value);
	}

	@Override
	public void setDI1(final boolean value) {
		latch.setDI1(value);
	}

	@Override
	public void setDI2(final boolean value) {
		latch.setDI2(value);
	}

	@Override
	public void setDI3(final boolean value) {
		latch.setDI3(value);
	}

	@Override
	public void setDI4(final boolean value) {
		latch.setDI4(value);
	}

	@Override
	public void setDI5(final boolean value) {
		latch.setDI5(value);
	}

	@Override
	public void setDI6(final boolean value) {
		latch.setDI6(value);
	}

	@Override
	public void setDI7(final boolean value) {
		latch.setDI7(value);
	}

	@Override
	public void setPower(final boolean value) {
		latch.setPower(value);
	}

	@Override
	public void setReset(final boolean value) {
		latch.setClr(value);
	}

	@Override
	public void setWrite(final boolean value) {
		latch.setW(value);
	}

	@Override
	public void step() {
		latch.step();
	}

}

/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Processor;

import electroMechanicalLogic.Buffer;
import electroMechanicalLogic.EightBitBuffer;
import electroMechanicalLogic.Interfaces.IEightBitBuffer;
import electroMechanicalLogic.Interfaces.IRelay;
import electroMechanicalMachine.Processor.Interfaces.IRotateThroughCarry;

public class RotateLeftThroughCarry implements IRotateThroughCarry {
	private final IEightBitBuffer data = new EightBitBuffer();
	private final IRelay carry = new Buffer();

	@Override
	public boolean getCO() {
		return carry.getOutput();
	}

	@Override
	public boolean getDO0() {
		return data.getDO0();
	}

	@Override
	public boolean getDO1() {
		return data.getDO1();
	}

	@Override
	public boolean getDO2() {
		return data.getDO2();
	}

	@Override
	public boolean getDO3() {
		return data.getDO3();
	}

	@Override
	public boolean getDO4() {
		return data.getDO4();
	}

	@Override
	public boolean getDO5() {
		return data.getDO5();
	}

	@Override
	public boolean getDO6() {
		return data.getDO6();
	}

	@Override
	public boolean getDO7() {
		return data.getDO7();
	}

	@Override
	public void setCI(final boolean value) {
		data.setDI0(value);
	}

	@Override
	public void setDI0(final boolean value) {
		data.setDI1(value);
	}

	@Override
	public void setDI1(final boolean value) {
		data.setDI2(value);
	}

	@Override
	public void setDI2(final boolean value) {
		data.setDI3(value);
	}

	@Override
	public void setDI3(final boolean value) {
		data.setDI4(value);
	}

	@Override
	public void setDI4(final boolean value) {
		data.setDI5(value);
	}

	@Override
	public void setDI5(final boolean value) {
		data.setDI6(value);
	}

	@Override
	public void setDI6(final boolean value) {
		data.setDI7(value);

	}

	@Override
	public void setDI7(final boolean value) {
		carry.setInput(value);
	}

	@Override
	public void setPower(final boolean value) {
		data.setPower(value);
		carry.setPower(value);
	}

	@Override
	public void step() {
		data.step();
		carry.step();
	}

}

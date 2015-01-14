/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */
package electroMechanicalLogic;

import electroMechanicalLogic.Interfaces.IEightInputSingleOutputGate;
import electroMechanicalLogic.Interfaces.IRelay;

public final class EightInputSingleOutputOrGate implements
		IEightInputSingleOutputGate {

	private IRelay bit0 = new Buffer();
	private IRelay bit1 = new Buffer();
	private IRelay bit2 = new Buffer();
	private IRelay bit3 = new Buffer();
	private IRelay bit4 = new Buffer();
	private IRelay bit5 = new Buffer();
	private IRelay bit6 = new Buffer();
	private IRelay bit7 = new Buffer();

	@Override
	public boolean getOutput() {
		return bit0.getOutput() || bit1.getOutput() || bit2.getOutput()
				|| bit3.getOutput() || bit4.getOutput() || bit5.getOutput()
				|| bit6.getOutput() || bit7.getOutput();
	}

	@Override
	public void setI0(boolean value) {
		bit0.setInput(value);
	}

	@Override
	public void setI1(boolean value) {
		bit1.setInput(value);
	}

	@Override
	public void setI2(boolean value) {
		bit2.setInput(value);
	}

	@Override
	public void setI3(boolean value) {
		bit3.setInput(value);
	}

	@Override
	public void setI4(boolean value) {
		bit4.setInput(value);
	}

	@Override
	public void setI5(boolean value) {
		bit5.setInput(value);
	}

	@Override
	public void setI6(boolean value) {
		bit6.setInput(value);

	}

	@Override
	public void setI7(boolean value) {
		bit7.setInput(value);

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

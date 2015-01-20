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

public class EightInputNORGate implements IEightInputSingleOutputGate {
	private final IRelay bit0 = new Inverter();
	private final IRelay bit1 = new Inverter();
	private final IRelay bit2 = new Inverter();
	private final IRelay bit3 = new Inverter();
	private final IRelay bit4 = new Inverter();
	private final IRelay bit5 = new Inverter();
	private final IRelay bit6 = new Inverter();
	private final IRelay bit7 = new Inverter();

	@Override
	public boolean getOutput() {
		return bit7.getOutput();
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
	}

	@Override
	public void step() {
		bit0.step();

		bit1.setPower(bit0.getOutput());
		bit1.step();

		bit2.setPower(bit1.getOutput());
		bit2.step();

		bit3.setPower(bit2.getOutput());
		bit3.step();

		bit4.setPower(bit3.getOutput());
		bit4.step();

		bit5.setPower(bit4.getOutput());
		bit5.step();

		bit6.setPower(bit5.getOutput());
		bit6.step();

		bit7.setPower(bit6.getOutput());
		bit7.step();
	}
}

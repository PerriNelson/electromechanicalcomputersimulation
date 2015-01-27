/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */
package electroMechanicalLogic.Gates;

import electroMechanicalLogic.Buffer;
import electroMechanicalLogic.Gates.Interfaces.IEightInputSingleOutputGate;
import electroMechanicalLogic.Interfaces.IRelay;

/**
 * An eight input logic gate that performs a logical OR on all of its inputs. If
 * the power is on and any of the inputs is on the output is on. If the power is
 * off or none of the inputs are on the output is off.
 */
public final class EightInputOR implements IEightInputSingleOutputGate {

	private final IRelay bit0 = new Buffer();
	private final IRelay bit1 = new Buffer();
	private final IRelay bit2 = new Buffer();
	private final IRelay bit3 = new Buffer();
	private final IRelay bit4 = new Buffer();
	private final IRelay bit5 = new Buffer();
	private final IRelay bit6 = new Buffer();
	private final IRelay bit7 = new Buffer();

	@Override
	public boolean getOutput() {
		return bit0.getOutput() || bit1.getOutput() || bit2.getOutput()
				|| bit3.getOutput() || bit4.getOutput() || bit5.getOutput()
				|| bit6.getOutput() || bit7.getOutput();
	}

	@Override
	public void setDI0(final boolean value) {
		bit0.setInput(value);
	}

	@Override
	public void setDI1(final boolean value) {
		bit1.setInput(value);
	}

	@Override
	public void setDI2(final boolean value) {
		bit2.setInput(value);
	}

	@Override
	public void setDI3(final boolean value) {
		bit3.setInput(value);
	}

	@Override
	public void setDI4(final boolean value) {
		bit4.setInput(value);
	}

	@Override
	public void setDI5(final boolean value) {
		bit5.setInput(value);
	}

	@Override
	public void setDI6(final boolean value) {
		bit6.setInput(value);

	}

	@Override
	public void setDI7(final boolean value) {
		bit7.setInput(value);

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

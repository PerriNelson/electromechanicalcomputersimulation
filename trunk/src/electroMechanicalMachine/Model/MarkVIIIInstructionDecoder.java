/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Model;

import electroMechanicalLogic.Inverter;
import electroMechanicalLogic.Gates.EightInputNOR;
import electroMechanicalLogic.Gates.Interfaces.IEightInputSingleOutputGate;
import electroMechanicalLogic.Interfaces.IRelay;
import electroMechanicalMachine.Model.Interfaces.IMarkVIIIInstructionDecoder;

public class MarkVIIIInstructionDecoder extends MarkVIIInstructionDecoder
		implements IMarkVIIIInstructionDecoder {
	private final IRelay ci1Bar;
	private final IEightInputSingleOutputGate addWithCarry;
	private final IEightInputSingleOutputGate subtractWithBorrow;

	public MarkVIIIInstructionDecoder() {
		super();
		ci1Bar = new Inverter();
		addWithCarry = new EightInputNOR();
		subtractWithBorrow = new EightInputNOR();
	}

	@Override
	public void setDI0(final boolean value) {
		super.setDI0(value);
		addWithCarry.setDI0(value);
	}

	@Override
	public void setDI1(final boolean value) {
		super.setDI1(value);
		ci1Bar.setInput(value);
	}

	@Override
	public void setDI2(final boolean value) {
		super.setDI2(value);
		addWithCarry.setDI2(value);
		subtractWithBorrow.setDI2(value);
	}

	@Override
	public void setDI3(final boolean value) {
		super.setDI3(value);
		addWithCarry.setDI3(value);
		subtractWithBorrow.setDI3(value);
	}

	@Override
	public void setDI4(final boolean value) {
		super.setDI4(value);
		addWithCarry.setDI4(value);
		subtractWithBorrow.setDI4(value);
	}

	@Override
	public void setDI6(final boolean value) {
		super.setDI6(value);
		addWithCarry.setDI6(value);
		subtractWithBorrow.setDI6(value);
	}

	@Override
	public void setDI7(final boolean value) {
		super.setDI7(value);
		addWithCarry.setDI7(value);
		subtractWithBorrow.setDI7(value);
	}

	@Override
	public void setPower(final boolean value) {
		super.setPower(value);
		ci1Bar.setPower(value);
		addWithCarry.setPower(value);
		subtractWithBorrow.setPower(value);
	}

	@Override
	public boolean getAddWithCarry() {
		return addWithCarry.getOutput();
	}

	@Override
	public boolean getSubtractWithBorrow() {
		return subtractWithBorrow.getOutput();
	}

	@Override
	public void step() {
		super.step();
		ci1Bar.step();

		addWithCarry.setDI1(ci1Bar.getOutput());
		addWithCarry.setDI5(ci5Bar.getOutput());
		addWithCarry.step();

		subtractWithBorrow.setDI0(ci0Bar.getOutput());
		subtractWithBorrow.setDI1(ci1Bar.getOutput());
		subtractWithBorrow.setDI5(ci5Bar.getOutput());
		subtractWithBorrow.step();
	}

}

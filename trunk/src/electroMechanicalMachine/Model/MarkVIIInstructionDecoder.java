/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Model;

import electroMechanicalLogic.EightInputNORGate;
import electroMechanicalLogic.Interfaces.IEightInputSingleOutputGate;
import electroMechanicalMachine.Model.Interfaces.IMarkVIIInstructionDecoder;

public class MarkVIIInstructionDecoder extends MarkVIInstructionDecoder
		implements IMarkVIIInstructionDecoder {
	private final IEightInputSingleOutputGate subtract;

	public MarkVIIInstructionDecoder() {
		super();
		subtract = new EightInputNORGate();
	}

	@Override
	public boolean getSubtract() {
		return subtract.getOutput();
	}

	@Override
	public void setDI1(final boolean value) {
		super.setDI1(value);
		subtract.setI1(value);
	}

	@Override
	public void setDI2(final boolean value) {
		super.setDI2(value);
		subtract.setI2(value);
	}

	@Override
	public void setDI3(final boolean value) {
		super.setDI3(value);
		subtract.setI3(value);
	}

	@Override
	public void setDI4(final boolean value) {
		super.setDI4(value);
		subtract.setI4(value);
	}

	@Override
	public void setDI6(final boolean value) {
		super.setDI6(value);
		subtract.setI6(value);
	}

	@Override
	public void setDI7(final boolean value) {
		super.setDI7(value);
		subtract.setI7(value);
	}

	@Override
	public void setPower(final boolean value) {
		super.setPower(value);
		subtract.setPower(value);
	}

	@Override
	public void step() {
		super.step();
		subtract.setI0(ci0Bar.getOutput());
		subtract.setI5(ci5Bar.getOutput());
		subtract.step();
	}
}

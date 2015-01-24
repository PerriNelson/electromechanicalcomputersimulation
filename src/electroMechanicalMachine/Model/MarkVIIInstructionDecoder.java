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
	private IEightInputSingleOutputGate subtract;

	public MarkVIIInstructionDecoder() {
		super();
		subtract = new EightInputNORGate();
	}

	@Override
	public boolean getSubtract() {
		return subtract.getOutput();
	}

	@Override
	public void setCI1(boolean value) {
		super.setCI1(value);
		subtract.setI1(value);
	}

	@Override
	public void setCI2(boolean value) {
		super.setCI2(value);
		subtract.setI2(value);
	}

	@Override
	public void setCI3(boolean value) {
		super.setCI3(value);
		subtract.setI3(value);
	}

	@Override
	public void setCI4(boolean value) {
		super.setCI4(value);
		subtract.setI4(value);
	}

	@Override
	public void setCI6(boolean value) {
		super.setCI6(value);
		subtract.setI6(value);
	}

	@Override
	public void setCI7(boolean value) {
		super.setCI7(value);
		subtract.setI7(value);
	}

	@Override
	public void setPower(boolean value) {
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

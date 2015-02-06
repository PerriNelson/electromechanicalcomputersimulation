/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Processor;

import electroMechanicalLogic.Gates.EightInputNOR;
import electroMechanicalLogic.Gates.Interfaces.IEightInputSingleOutputGate;
import electroMechanicalMachine.Processor.Interfaces.IGetJump;

public class BasicInstructionDecoderWithJump extends BasicInstructionDecoder implements
		IGetJump {
	private final IEightInputSingleOutputGate jump = new EightInputNOR();

	@Override
	public boolean getJump() {
		return jump.getOutput();
	}

	@Override
	public void setC0(final boolean value) {
		super.setC0(value);
		jump.setDI0(value);
	}

	@Override
	public void setC1(final boolean value) {
		super.setC1(value);
		jump.setDI1(value);
	}

	@Override
	public void setC2(final boolean value) {
		super.setC2(value);
		jump.setDI2(value);
	}

	@Override
	public void setC3(final boolean value) {
		super.setC3(value);
		jump.setDI3(value);
	}

	@Override
	public void setC4(final boolean value) {
		super.setC4(value);
	}

	@Override
	public void setC5(final boolean value) {
		super.setC5(value);
	}

	@Override
	public void setC6(final boolean value) {
		super.setC6(value);
		jump.setDI6(value);
	}

	@Override
	public void setC7(final boolean value) {
		super.setC7(value);
		jump.setDI7(value);
	}

	@Override
	public void setPower(final boolean value) {
		super.setPower(value);
		jump.setPower(value);
	}

	@Override
	public void step() {
		super.step();

		jump.setDI4(c4Bar.getOutput());
		jump.setDI5(c5Bar.getOutput());
		jump.step();
	}
}

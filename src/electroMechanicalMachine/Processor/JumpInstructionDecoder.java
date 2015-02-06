/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 111 Castro Street, Suite 900, Mountain View, California, 91011,
  USA.
 */

package electroMechanicalMachine.Processor;

import electroMechanicalLogic.Inverter;
import electroMechanicalLogic.Gates.EightInputNOR;
import electroMechanicalLogic.Gates.Interfaces.IEightInputSingleOutputGate;
import electroMechanicalLogic.Interfaces.IRelay;
import electroMechanicalMachine.Processor.Interfaces.IJumpInstructionDecoder;

public class JumpInstructionDecoder implements IJumpInstructionDecoder {
	private final IEightInputSingleOutputGate jump = new EightInputNOR();
	private final IEightInputSingleOutputGate jumpIfCarry = new EightInputNOR();
	private final IEightInputSingleOutputGate jumpIfNotCarry = new EightInputNOR();
	private final IEightInputSingleOutputGate jumpIfZero = new EightInputNOR();
	private final IEightInputSingleOutputGate jumpIfNotZero = new EightInputNOR();
	private final IRelay c0Bar = new Inverter();
	private final IRelay c1Bar = new Inverter();
	private final IRelay c2Bar = new Inverter();
	private final IRelay c4Bar = new Inverter();
	private final IRelay c5Bar = new Inverter();

	@Override
	public boolean getJump() {
		return jump.getOutput();
	}

	@Override
	public boolean getJumpIfCarry() {
		return jumpIfCarry.getOutput();
	}

	@Override
	public boolean getJumpIfNotCarry() {
		return jumpIfNotCarry.getOutput();
	}

	@Override
	public boolean getJumpIfNotZero() {
		return jumpIfNotZero.getOutput();
	}

	@Override
	public boolean getJumpIfZero() {
		return jumpIfZero.getOutput();
	}

	@Override
	public void setC0(boolean value) {
		c0Bar.setInput(value);
		jump.setDI0(value);
		jumpIfCarry.setDI0(value);
		jumpIfNotCarry.setDI0(value);
	}

	@Override
	public void setC1(boolean value) {
		c1Bar.setInput(value);
		jump.setDI1(value);
		jumpIfNotCarry.setDI1(value);
		jumpIfZero.setDI1(value);
	}

	@Override
	public void setC2(boolean value) {
		c2Bar.setInput(value);
		jump.setDI2(value);
		jumpIfCarry.setDI2(value);
		jumpIfNotZero.setDI2(value);
		jumpIfZero.setDI2(value);
	}

	@Override
	public void setC3(boolean value) {
		jump.setDI3(value);
		jumpIfCarry.setDI3(value);
		jumpIfNotCarry.setDI3(value);
		jumpIfNotZero.setDI3(value);
		jumpIfZero.setDI3(value);
	}

	@Override
	public void setC4(boolean value) {
		c4Bar.setInput(value);
	}

	@Override
	public void setC5(boolean value) {
		c5Bar.setInput(value);
	}

	@Override
	public void setC6(boolean value) {
		jump.setDI6(value);
		jumpIfCarry.setDI6(value);
		jumpIfNotCarry.setDI6(value);
		jumpIfNotZero.setDI6(value);
		jumpIfZero.setDI6(value);
	}

	@Override
	public void setC7(boolean value) {
		jump.setDI7(value);
		jumpIfCarry.setDI7(value);
		jumpIfNotCarry.setDI7(value);
		jumpIfNotZero.setDI7(value);
		jumpIfZero.setDI7(value);
	}

	@Override
	public void setPower(final boolean value) {
		jump.setPower(value);
		jumpIfCarry.setPower(value);
		jumpIfNotCarry.setPower(value);
		jumpIfNotZero.setPower(value);
		jumpIfZero.setPower(value);
		c0Bar.setPower(value);
		c1Bar.setPower(value);
		c2Bar.setPower(value);
		c4Bar.setPower(value);
		c5Bar.setPower(value);
	}

	@Override
	public void step() {
		c0Bar.step();
		jumpIfNotZero.setDI0(c0Bar.getOutput());
		jumpIfZero.setDI0(c0Bar.getOutput());

		c1Bar.step();
		jumpIfCarry.setDI1(c1Bar.getOutput());
		jumpIfNotZero.setDI1(c1Bar.getOutput());

		c2Bar.step();
		jumpIfNotCarry.setDI2(c2Bar.getOutput());

		c4Bar.step();
		jump.setDI4(c4Bar.getOutput());
		jumpIfCarry.setDI4(c4Bar.getOutput());
		jumpIfNotCarry.setDI4(c4Bar.getOutput());
		jumpIfNotZero.setDI4(c4Bar.getOutput());
		jumpIfZero.setDI4(c4Bar.getOutput());

		c5Bar.step();
		jump.setDI5(c5Bar.getOutput());
		jumpIfCarry.setDI5(c5Bar.getOutput());
		jumpIfNotCarry.setDI5(c5Bar.getOutput());
		jumpIfNotZero.setDI5(c5Bar.getOutput());
		jumpIfZero.setDI5(c5Bar.getOutput());

		jump.step();
		jumpIfCarry.step();
		jumpIfNotCarry.step();
		jumpIfNotZero.step();
		jumpIfZero.step();
	}

}

/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Processor;

import electroMechanicalLogic.Inverter;
import electroMechanicalLogic.Gates.FourInputOR;
import electroMechanicalLogic.Gates.TwoInputAND;
import electroMechanicalLogic.Gates.TwoInputOR;
import electroMechanicalLogic.Gates.Interfaces.IFourInputSingleOutputGate;
import electroMechanicalLogic.Gates.Interfaces.ITwoInputSingleOutputGate;
import electroMechanicalLogic.Interfaces.IRelay;
import electroMechanicalMachine.Processor.Interfaces.IJumpControl;

public class JumpControl implements IJumpControl {
	private final ITwoInputSingleOutputGate jump = new TwoInputOR();
	private final IRelay carryBar = new Inverter();
	private final IRelay zeroBar = new Inverter();
	private final ITwoInputSingleOutputGate jumpIfCarry = new TwoInputAND();
	private final ITwoInputSingleOutputGate jumpIfNotCarry = new TwoInputAND();
	private final ITwoInputSingleOutputGate jumpIfZero = new TwoInputAND();
	private final ITwoInputSingleOutputGate jumpIfNotZero = new TwoInputAND();
	private final IFourInputSingleOutputGate conditionalJump = new FourInputOR();
	private final ITwoInputSingleOutputGate jumpAndAddressHasBeenLatched = new TwoInputAND();

	@Override
	public void setPower(boolean value) {
		jump.setPower(value);
		carryBar.setPower(value);
		zeroBar.setPower(value);
		jumpIfCarry.setPower(value);
		jumpIfNotCarry.setPower(value);
		jumpIfZero.setPower(value);
		jumpIfNotZero.setPower(value);
		conditionalJump.setPower(value);
		jumpAndAddressHasBeenLatched.setPower(value);
	}

	@Override
	public void step() {
		carryBar.step();
		zeroBar.step();

		jumpIfCarry.step();

		jumpIfNotCarry.setB(carryBar.getOutput());
		jumpIfNotCarry.step();

		jumpIfZero.step();

		jumpIfNotZero.setB(zeroBar.getOutput());
		jumpIfNotZero.step();

		conditionalJump.setA(jumpIfCarry.getOutput());
		conditionalJump.setB(jumpIfNotCarry.getOutput());
		conditionalJump.setC(jumpIfZero.getOutput());
		conditionalJump.setD(jumpIfNotZero.getOutput());
		conditionalJump.step();

		jump.setB(conditionalJump.getOutput());
		jump.step();

		jumpAndAddressHasBeenLatched.setA(jump.getOutput());
		jumpAndAddressHasBeenLatched.step();
	}

	@Override
	public boolean getJump() {
		return jumpAndAddressHasBeenLatched.getOutput();
	}

	@Override
	public void setAddressHasBeenLatched(boolean value) {
		jumpAndAddressHasBeenLatched.setB(value);
	}

	@Override
	public void setCarryFlag(boolean value) {
		jumpIfCarry.setB(value);
		carryBar.setInput(value);
	}

	@Override
	public void setJump(boolean value) {
		jump.setA(value);
	}

	@Override
	public void setJumpIfCarry(boolean value) {
		jumpIfCarry.setA(value);
	}

	@Override
	public void setJumpIfNotCarry(boolean value) {
		jumpIfNotCarry.setA(value);
	}

	@Override
	public void setJumpIfNotZero(boolean value) {
		jumpIfNotZero.setA(value);
	}

	@Override
	public void setJumpIfZero(boolean value) {
		jumpIfZero.setA(value);
	}

	@Override
	public void setZeroFlag(boolean value) {
		jumpIfZero.setB(value);
		zeroBar.setInput(value);
	}

}

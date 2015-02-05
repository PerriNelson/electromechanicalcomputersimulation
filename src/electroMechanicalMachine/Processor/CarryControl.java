/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Processor;

import electroMechanicalLogic.Gates.TwoInputAND;
import electroMechanicalLogic.Gates.TwoInputOR;
import electroMechanicalLogic.Gates.Interfaces.ITwoInputSingleOutputGate;
import electroMechanicalLogic.Interfaces.ISimulatedCircuit;
import electroMechanicalMachine.Processor.Interfaces.ICarryControl;

/**
 * Processes instruction signals and a carry flag to produce a carry in signal.
 */
public class CarryControl implements ISimulatedCircuit, ICarryControl {
	private final ITwoInputSingleOutputGate carryin = new TwoInputOR();
	private final ITwoInputSingleOutputGate operationUsesCarryFlag = new TwoInputOR();
	private final ITwoInputSingleOutputGate carryFlagAndOperationUsesCarryFlag = new TwoInputAND();

	@Override
	public boolean getCarryIn() {
		return carryin.getOutput();
	}

	@Override
	public void setAddWithCarry(final boolean value) {
		operationUsesCarryFlag.setA(value);
	}

	@Override
	public void setCarryFlag(final boolean value) {
		carryFlagAndOperationUsesCarryFlag.setA(value);
	}

	@Override
	public void setPower(final boolean value) {
		operationUsesCarryFlag.setPower(value);
		carryFlagAndOperationUsesCarryFlag.setPower(value);
		carryin.setPower(value);
	}

	@Override
	public void setSubtract(final boolean value) {
		carryin.setB(value);
	}

	@Override
	public void setSubtractWithBorrow(final boolean value) {
		operationUsesCarryFlag.setB(value);
	}

	@Override
	public void step() {
		operationUsesCarryFlag.step();
		carryFlagAndOperationUsesCarryFlag.setB(operationUsesCarryFlag
				.getOutput());
		carryFlagAndOperationUsesCarryFlag.step();

		carryin.setA(carryFlagAndOperationUsesCarryFlag.getOutput());
		carryin.step();
	}
}

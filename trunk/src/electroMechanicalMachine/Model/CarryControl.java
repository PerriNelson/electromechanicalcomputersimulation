/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Model;

import electroMechanicalLogic.EdgeTriggeredLatchWithClear;
import electroMechanicalLogic.Gates.ThreeInputOR;
import electroMechanicalLogic.Gates.TwoInputAND;
import electroMechanicalLogic.Gates.TwoInputOR;
import electroMechanicalLogic.Gates.Interfaces.IThreeInputSingleOutputGate;
import electroMechanicalLogic.Gates.Interfaces.ITwoInputSingleOutputGate;
import electroMechanicalLogic.Interfaces.ILatchWithClear;
import electroMechanicalLogic.Interfaces.ISimulatedCircuit;
import electroMechanicalMachine.Model.Interfaces.ICarryControl;

/**
 * Processes instruction signals and a carry out signal to produce a carry in
 * signal.
 */
public class CarryControl implements ISimulatedCircuit, ICarryControl {
	private final ITwoInputSingleOutputGate carryin = new TwoInputOR();
	private final ITwoInputSingleOutputGate addWithCarryOrSubtractWithBorrow = new TwoInputOR();
	private final ITwoInputSingleOutputGate carryOutAndAddWithCarryOrSubtractWithBorrow = new TwoInputAND();
	private final IThreeInputSingleOutputGate operationMayResultInCarry = new ThreeInputOR();
	private final ITwoInputSingleOutputGate operationMayResultInCarryAndClockIsHigh = new TwoInputAND();
	private final ILatchWithClear carryLatch = new EdgeTriggeredLatchWithClear();

	@Override
	public boolean getCarryIn() {
		return carryin.getOutput();
	}

	@Override
	public void setAdd(final boolean value) {
		operationMayResultInCarry.setA(value);
	}

	@Override
	public void setAddWithCarry(final boolean value) {
		addWithCarryOrSubtractWithBorrow.setA(value);
	}

	@Override
	public void setCarryOut(final boolean value) {
		carryLatch.setDI(value);
	}

	@Override
	public void setClear(final boolean value) {
		carryLatch.setClr(value);

	}

	@Override
	public void setClock(final boolean value) {
		operationMayResultInCarryAndClockIsHigh.setA(value);
	}

	@Override
	public void setPower(final boolean value) {
		addWithCarryOrSubtractWithBorrow.setPower(value);
		carryOutAndAddWithCarryOrSubtractWithBorrow.setPower(value);
		carryin.setPower(value);
		operationMayResultInCarry.setPower(value);
		operationMayResultInCarryAndClockIsHigh.setPower(value);
		carryLatch.setPower(value);
	}

	@Override
	public void setSubtract(final boolean value) {
		carryin.setB(value);
		operationMayResultInCarry.setB(value);
	}

	@Override
	public void setSubtractWithBorrow(final boolean value) {
		addWithCarryOrSubtractWithBorrow.setB(value);
	}

	@Override
	public void step() {
		addWithCarryOrSubtractWithBorrow.step();

		carryOutAndAddWithCarryOrSubtractWithBorrow
				.setB(addWithCarryOrSubtractWithBorrow.getOutput());
		carryOutAndAddWithCarryOrSubtractWithBorrow.setA(carryLatch.getDO());
		carryOutAndAddWithCarryOrSubtractWithBorrow.step();

		carryin.setA(carryOutAndAddWithCarryOrSubtractWithBorrow.getOutput());
		carryin.step();

		operationMayResultInCarry.setC(addWithCarryOrSubtractWithBorrow
				.getOutput());
		operationMayResultInCarry.step();

		operationMayResultInCarryAndClockIsHigh.setB(operationMayResultInCarry
				.getOutput());
		operationMayResultInCarryAndClockIsHigh.step();

		carryLatch.setW(operationMayResultInCarryAndClockIsHigh.getOutput());
		carryLatch.step();
	}
}

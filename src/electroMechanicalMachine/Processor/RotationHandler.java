/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Processor;

import static electroMechanicalLogic.DataChannel.EightBitDataPath.connectEightBitDataOutputToEightBitAInput;
import static electroMechanicalLogic.DataChannel.EightBitDataPath.connectEightBitDataOutputToEightBitBInput;
import electroMechanicalLogic.EightBitTwoToOneSelector;
import electroMechanicalLogic.TwoLineToOneLineSelector;
import electroMechanicalLogic.Gates.TwoInputOR;
import electroMechanicalLogic.Gates.Interfaces.ITwoInputSingleOutputGate;
import electroMechanicalLogic.Interfaces.IEightBitTwoToOneSelector;
import electroMechanicalLogic.Interfaces.ITwoLineToOneLineSelector;
import electroMechanicalMachine.Processor.Interfaces.IRotate;
import electroMechanicalMachine.Processor.Interfaces.IRotateThroughCarry;
import electroMechanicalMachine.Processor.Interfaces.IRotationHandler;

public class RotationHandler implements IRotationHandler {

	private final IRotate rotateLeft = new RotateLeft();
	private final IRotate rotateRight = new RotateRight();
	private final IRotateThroughCarry rotateLeftThroughCarry = new RotateLeftThroughCarry();
	private final IRotateThroughCarry rotateRightThroughCarry = new RotateRightThroughCarry();
	private final ITwoInputSingleOutputGate rotateThroughCarry = new TwoInputOR();
	private final IEightBitTwoToOneSelector leftSideData = new EightBitTwoToOneSelector();
	private final ITwoLineToOneLineSelector leftSideCarry = new TwoLineToOneLineSelector();
	private final IEightBitTwoToOneSelector rightSideData = new EightBitTwoToOneSelector();
	private final ITwoLineToOneLineSelector rightSideCarry = new TwoLineToOneLineSelector();
	private final IEightBitTwoToOneSelector dataOut = new EightBitTwoToOneSelector();
	private final ITwoLineToOneLineSelector carryOut = new TwoLineToOneLineSelector();
	private final ITwoInputSingleOutputGate right = new TwoInputOR();

	@Override
	public boolean getCarryOut() {
		return carryOut.getDO();
	}

	@Override
	public boolean getDO0() {
		return dataOut.getDO0();
	}

	@Override
	public boolean getDO1() {
		return dataOut.getDO1();
	}

	@Override
	public boolean getDO2() {
		return dataOut.getDO2();
	}

	@Override
	public boolean getDO3() {
		return dataOut.getDO3();
	}

	@Override
	public boolean getDO4() {
		return dataOut.getDO4();
	}

	@Override
	public boolean getDO5() {
		return dataOut.getDO5();
	}

	@Override
	public boolean getDO6() {
		return dataOut.getDO6();
	}

	@Override
	public boolean getDO7() {
		return dataOut.getDO7();
	}

	@Override
	public void setCarryIn(final boolean value) {
		rotateLeftThroughCarry.setCI(value);
		rotateRightThroughCarry.setCI(value);
	}

	@Override
	public void setDI0(final boolean value) {
		rotateLeft.setDI0(value);
		rotateRight.setDI0(value);
		rotateLeftThroughCarry.setDI0(value);
		rotateRightThroughCarry.setDI0(value);
	}

	@Override
	public void setDI1(final boolean value) {
		rotateLeft.setDI1(value);
		rotateRight.setDI1(value);
		rotateLeftThroughCarry.setDI1(value);
		rotateRightThroughCarry.setDI1(value);
	}

	@Override
	public void setDI2(final boolean value) {
		rotateLeft.setDI2(value);
		rotateRight.setDI2(value);
		rotateLeftThroughCarry.setDI2(value);
		rotateRightThroughCarry.setDI2(value);
	}

	@Override
	public void setDI3(final boolean value) {
		rotateLeft.setDI3(value);
		rotateRight.setDI3(value);
		rotateLeftThroughCarry.setDI3(value);
		rotateRightThroughCarry.setDI3(value);
	}

	@Override
	public void setDI4(final boolean value) {
		rotateLeft.setDI4(value);
		rotateRight.setDI4(value);
		rotateLeftThroughCarry.setDI4(value);
		rotateRightThroughCarry.setDI4(value);
	}

	@Override
	public void setDI5(final boolean value) {
		rotateLeft.setDI5(value);
		rotateRight.setDI5(value);
		rotateLeftThroughCarry.setDI5(value);
		rotateRightThroughCarry.setDI5(value);
	}

	@Override
	public void setDI6(final boolean value) {
		rotateLeft.setDI6(value);
		rotateRight.setDI6(value);
		rotateLeftThroughCarry.setDI6(value);
		rotateRightThroughCarry.setDI6(value);
	}

	@Override
	public void setDI7(final boolean value) {
		rotateLeft.setDI7(value);
		rotateRight.setDI7(value);
		rotateLeftThroughCarry.setDI7(value);
		rotateRightThroughCarry.setDI7(value);
	}

	@Override
	public void setPower(final boolean value) {
		rotateLeft.setPower(value);
		rotateRight.setPower(value);
		rotateLeftThroughCarry.setPower(value);
		rotateRightThroughCarry.setPower(value);
		leftSideData.setPower(value);
		rightSideData.setPower(value);
		rotateThroughCarry.setPower(value);
		dataOut.setPower(value);
		right.setPower(value);
		rightSideCarry.setPower(value);
		leftSideCarry.setPower(value);
		carryOut.setPower(value);
	}

	@Override
	public void setRotateLeft(final boolean value) {
		// Nothing to do here. This is the default operation.
	}

	@Override
	public void setRotateLeftThroughCarry(final boolean value) {
		rotateThroughCarry.setA(value);
	}

	@Override
	public void setRotateRight(final boolean value) {
		right.setA(value);
	}

	@Override
	public void setRotateRightThroughCarry(final boolean value) {
		rotateThroughCarry.setB(value);
		right.setB(value);
	}

	@Override
	public void step() {
		rotateThroughCarry.step();
		right.step();

		stepLeft();
		stepRight();

		connectEightBitDataOutputToEightBitAInput(leftSideData, dataOut);
		connectEightBitDataOutputToEightBitBInput(rightSideData, dataOut);
		dataOut.setSelect(right.getOutput());
		dataOut.step();

		carryOut.setA(leftSideCarry.getDO());
		carryOut.setB(rightSideCarry.getDO());
		carryOut.setSelect(right.getOutput());
		carryOut.step();
	}

	private void stepLeft() {
		rotateLeft.step();
		rotateLeftThroughCarry.step();

		connectEightBitDataOutputToEightBitAInput(rotateLeft, leftSideData);
		connectEightBitDataOutputToEightBitBInput(rotateLeftThroughCarry,
				leftSideData);
		leftSideData.setSelect(rotateThroughCarry.getOutput());
		leftSideData.step();

		leftSideCarry.setA(rotateLeft.getCO());
		leftSideCarry.setB(rotateLeftThroughCarry.getCO());
		leftSideCarry.setSelect(rotateThroughCarry.getOutput());
		leftSideCarry.step();
	}

	private void stepRight() {
		rotateRight.step();
		rotateRightThroughCarry.step();

		connectEightBitDataOutputToEightBitAInput(rotateRight, rightSideData);
		connectEightBitDataOutputToEightBitBInput(rotateRightThroughCarry,
				rightSideData);
		rightSideData.setSelect(rotateThroughCarry.getOutput());
		rightSideData.step();

		rightSideCarry.setA(rotateRight.getCO());
		rightSideCarry.setB(rotateRightThroughCarry.getCO());
		rightSideCarry.setSelect(rotateThroughCarry.getOutput());
		rightSideCarry.step();
	}

}

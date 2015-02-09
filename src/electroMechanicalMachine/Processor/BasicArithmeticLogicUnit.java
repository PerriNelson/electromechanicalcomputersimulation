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
import static electroMechanicalLogic.DataChannel.EightBitDataPath.connectEightBitDataOutputToEightBitCInput;
import electroMechanicalLogic.Selectors.EightBitFourToOneSelector;
import electroMechanicalLogic.Selectors.TwoToOneSelector;
import electroMechanicalLogic.Selectors.Interfaces.IEightBitFourToOneSelector;
import electroMechanicalLogic.Selectors.Interfaces.ITwoToOneSelector;
import electroMechanicalMachine.Processor.Interfaces.IBasicArithmeticHandler;
import electroMechanicalMachine.Processor.Interfaces.IBasicArithmeticLogicUnit;
import electroMechanicalMachine.Processor.Interfaces.IBitwiseOperationHandler;
import electroMechanicalMachine.Processor.Interfaces.IRotationHandler;

public class BasicArithmeticLogicUnit implements IBasicArithmeticLogicUnit {
	private final IBasicArithmeticHandler arithmeticHandler = new BasicArithmeticHandler();
	private final IBitwiseOperationHandler bitwiseHandler = new BitwiseOperationHandler();
	private final IRotationHandler rotationHandler = new RotationHandler();
	private final IEightBitFourToOneSelector dataOut = new EightBitFourToOneSelector();
	private final ITwoToOneSelector carryOut = new TwoToOneSelector();

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
	public boolean getIsArithmeticOperation() {
		return arithmeticHandler.getIsArithmeticOperation();
	}

	@Override
	public boolean getIsBitwiseOperation() {
		return bitwiseHandler.getIsBitwiseOperation();
	}

	@Override
	public boolean getIsRotationOperation() {
		return rotationHandler.getIsRotationOperation();
	}

	@Override
	public void setA0(final boolean value) {
		arithmeticHandler.setA0(value);
		bitwiseHandler.setA0(value);
	}

	@Override
	public void setA1(final boolean value) {
		arithmeticHandler.setA1(value);
		bitwiseHandler.setA1(value);
	}

	@Override
	public void setA2(final boolean value) {
		arithmeticHandler.setA2(value);
		bitwiseHandler.setA2(value);
	}

	@Override
	public void setA3(final boolean value) {
		arithmeticHandler.setA3(value);
		bitwiseHandler.setA3(value);
	}

	@Override
	public void setA4(final boolean value) {
		arithmeticHandler.setA4(value);
		bitwiseHandler.setA4(value);
	}

	@Override
	public void setA5(final boolean value) {
		arithmeticHandler.setA5(value);
		bitwiseHandler.setA5(value);
	}

	@Override
	public void setA6(final boolean value) {
		arithmeticHandler.setA6(value);
		bitwiseHandler.setA6(value);
	}

	@Override
	public void setA7(final boolean value) {
		arithmeticHandler.setA7(value);
		bitwiseHandler.setA7(value);
	}

	@Override
	public void setAdd(final boolean value) {
		arithmeticHandler.setAdd(value);
	}

	@Override
	public void setAddWithCarry(final boolean value) {
		arithmeticHandler.setAddWithCarry(value);
	}

	@Override
	public void setAND(final boolean value) {
		bitwiseHandler.setAND(value);
	}

	@Override
	public void setB0(final boolean value) {
		arithmeticHandler.setB0(value);
		bitwiseHandler.setB0(value);
		rotationHandler.setDI0(value);
	}

	@Override
	public void setB1(final boolean value) {
		arithmeticHandler.setB1(value);
		bitwiseHandler.setB1(value);
		rotationHandler.setDI1(value);
	}

	@Override
	public void setB2(final boolean value) {
		arithmeticHandler.setB2(value);
		bitwiseHandler.setB2(value);
		rotationHandler.setDI2(value);
	}

	@Override
	public void setB3(final boolean value) {
		arithmeticHandler.setB3(value);
		bitwiseHandler.setB3(value);
		rotationHandler.setDI3(value);
	}

	@Override
	public void setB4(final boolean value) {
		arithmeticHandler.setB4(value);
		bitwiseHandler.setB4(value);
		rotationHandler.setDI4(value);
	}

	@Override
	public void setB5(final boolean value) {
		arithmeticHandler.setB5(value);
		bitwiseHandler.setB5(value);
		rotationHandler.setDI5(value);
	}

	@Override
	public void setB6(final boolean value) {
		arithmeticHandler.setB6(value);
		bitwiseHandler.setB6(value);
		rotationHandler.setDI6(value);
	}

	@Override
	public void setB7(final boolean value) {
		arithmeticHandler.setB7(value);
		bitwiseHandler.setB7(value);
		rotationHandler.setDI7(value);
	}

	@Override
	public void setCarryIn(final boolean value) {
		arithmeticHandler.setCarryIn(value);
		rotationHandler.setCarryIn(value);
	}

	@Override
	public void setOR(final boolean value) {
		bitwiseHandler.setOR(value);
	}

	@Override
	public void setPower(final boolean value) {
		arithmeticHandler.setPower(value);
		bitwiseHandler.setPower(value);
		rotationHandler.setPower(value);
		dataOut.setPower(value);
		carryOut.setPower(value);
	}

	@Override
	public void setRotateLeft(final boolean value) {
		rotationHandler.setRotateLeft(value);
	}

	@Override
	public void setRotateLeftThroughCarry(final boolean value) {
		rotationHandler.setRotateLeftThroughCarry(value);
	}

	@Override
	public void setRotateRight(final boolean value) {
		rotationHandler.setRotateRight(value);
	}

	@Override
	public void setRotateRightThroughCarry(final boolean value) {
		rotationHandler.setRotateRightThroughCarry(value);
	}

	@Override
	public void setSubtract(final boolean value) {
		arithmeticHandler.setSubtract(value);
	}

	@Override
	public void setSubtractWithBorrow(final boolean value) {
		arithmeticHandler.setSubtractWithBorrow(value);
	}

	@Override
	public void setXOR(final boolean value) {
		bitwiseHandler.setXOR(value);
	}

	@Override
	public void step() {
		arithmeticHandler.step();
		bitwiseHandler.step();
		rotationHandler.step();

		connectEightBitDataOutputToEightBitAInput(arithmeticHandler, dataOut);
		connectEightBitDataOutputToEightBitBInput(bitwiseHandler, dataOut);
		connectEightBitDataOutputToEightBitCInput(rotationHandler, dataOut);
		dataOut.setS0(bitwiseHandler.getIsBitwiseOperation());
		dataOut.setS1(rotationHandler.getIsRotationOperation());
		dataOut.step();

		carryOut.setA(arithmeticHandler.getCarryOut());
		carryOut.setB(rotationHandler.getCarryOut());
		carryOut.setSelect(rotationHandler.getIsRotationOperation());
		carryOut.step();
	}

}

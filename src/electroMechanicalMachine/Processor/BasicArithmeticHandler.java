/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Processor;

import static electroMechanicalLogic.DataChannel.EightBitDataPath.connectEightBitDataOutputToEightBitAInput;
import electroMechanicalLogic.EightBitOnesComplement;
import electroMechanicalLogic.Adders.EightBitAdder;
import electroMechanicalLogic.Adders.Interfaces.IEightBitAdder;
import electroMechanicalLogic.Gates.FourInputOR;
import electroMechanicalLogic.Gates.TwoInputOR;
import electroMechanicalLogic.Gates.Interfaces.IFourInputSingleOutputGate;
import electroMechanicalLogic.Gates.Interfaces.ITwoInputSingleOutputGate;
import electroMechanicalLogic.Interfaces.IEightBitOnesComplement;
import electroMechanicalMachine.Processor.Interfaces.IBasicArithmeticHandler;
import electroMechanicalMachine.Processor.Interfaces.ICarryControl;

public class BasicArithmeticHandler implements IBasicArithmeticHandler {
	private final IFourInputSingleOutputGate isArithmeticOperation = new FourInputOR();
	protected final IEightBitAdder adder = new EightBitAdder();
	private final IEightBitOnesComplement subtract = new EightBitOnesComplement();
	private final ICarryControl carryControl = new CarryControl();
	private final ITwoInputSingleOutputGate subtractOrSubtractWithBorrow = new TwoInputOR();

	@Override
	public boolean getCarryOut() {
		return adder.getCO();
	}

	@Override
	public boolean getDO0() {
		return adder.getS0();
	}

	@Override
	public boolean getDO1() {
		return adder.getS1();
	}

	@Override
	public boolean getDO2() {
		return adder.getS2();
	}

	@Override
	public boolean getDO3() {
		return adder.getS3();
	}

	@Override
	public boolean getDO4() {
		return adder.getS4();
	}

	@Override
	public boolean getDO5() {
		return adder.getS5();
	}

	@Override
	public boolean getDO6() {
		return adder.getS6();
	}

	@Override
	public boolean getDO7() {
		return adder.getS7();
	}

	@Override
	public boolean getIsArithmeticOperation() {
		return isArithmeticOperation.getOutput();
	}

	@Override
	public void setA0(final boolean value) {
		subtract.setDI0(value);

	}

	@Override
	public void setA1(final boolean value) {
		subtract.setDI1(value);
	}

	@Override
	public void setA2(final boolean value) {
		subtract.setDI2(value);
	}

	@Override
	public void setA3(final boolean value) {
		subtract.setDI3(value);
	}

	@Override
	public void setA4(final boolean value) {
		subtract.setDI4(value);
	}

	@Override
	public void setA5(final boolean value) {
		subtract.setDI5(value);
	}

	@Override
	public void setA6(final boolean value) {
		subtract.setDI6(value);
	}

	@Override
	public void setA7(final boolean value) {
		subtract.setDI7(value);
	}

	@Override
	public void setAdd(final boolean value) {
		isArithmeticOperation.setA(value);
	}

	@Override
	public void setAddWithCarry(final boolean value) {
		carryControl.setAddWithCarry(value);
		isArithmeticOperation.setB(value);
	}

	@Override
	public void setB0(final boolean value) {
		adder.setB0(value);
	}

	@Override
	public void setB1(final boolean value) {
		adder.setB1(value);
	}

	@Override
	public void setB2(final boolean value) {
		adder.setB2(value);
	}

	@Override
	public void setB3(final boolean value) {
		adder.setB3(value);
	}

	@Override
	public void setB4(final boolean value) {
		adder.setB4(value);
	}

	@Override
	public void setB5(final boolean value) {
		adder.setB5(value);
	}

	@Override
	public void setB6(final boolean value) {
		adder.setB6(value);
	}

	@Override
	public void setB7(final boolean value) {
		adder.setB7(value);
	}

	@Override
	public void setCarryIn(final boolean value) {
		carryControl.setCarryFlag(value);
	}

	@Override
	public void setPower(final boolean value) {
		isArithmeticOperation.setPower(value);
		adder.setPower(value);
		subtract.setPower(value);
		carryControl.setPower(value);
		subtractOrSubtractWithBorrow.setPower(value);
	}

	@Override
	public void setSubtract(final boolean value) {
		isArithmeticOperation.setC(value);
		subtractOrSubtractWithBorrow.setA(value);
		carryControl.setSubtract(value);
	}

	@Override
	public void setSubtractWithBorrow(final boolean value) {
		isArithmeticOperation.setD(value);
		subtractOrSubtractWithBorrow.setB(value);
		carryControl.setSubtractWithBorrow(value);
	}

	@Override
	public void step() {
		isArithmeticOperation.step();

		subtractOrSubtractWithBorrow.step();

		subtract.setInvert(subtractOrSubtractWithBorrow.getOutput());
		subtract.step();

		carryControl.step();

		adder.setCI(carryControl.getCarryIn());
		connectEightBitDataOutputToEightBitAInput(subtract, adder);
		adder.step();
	}

}

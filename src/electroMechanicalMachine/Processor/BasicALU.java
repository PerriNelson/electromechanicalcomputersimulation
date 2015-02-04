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
import electroMechanicalLogic.Gates.TwoInputOR;
import electroMechanicalLogic.Gates.Interfaces.ITwoInputSingleOutputGate;
import electroMechanicalLogic.Interfaces.IEightBitOnesComplement;
import electroMechanicalMachine.Model.CarryControl;
import electroMechanicalMachine.Model.Interfaces.ICarryControl;
import electroMechanicalMachine.Processor.Interfaces.IArithmeticLogicUnit;

public class BasicALU implements IArithmeticLogicUnit {
	private final IEightBitAdder adder = new EightBitAdder();
	private final IEightBitOnesComplement subtract = new EightBitOnesComplement();
	private final ICarryControl carryControl = new CarryControl();
	private final ITwoInputSingleOutputGate subtractOrSubtractWithBorrow = new TwoInputOR();

	@Override
	public void setPower(boolean value) {
		adder.setPower(value);
		subtract.setPower(value);
		carryControl.setPower(value);
		subtractOrSubtractWithBorrow.setPower(value);
	}

	@Override
	public void step() {
		subtractOrSubtractWithBorrow.step();

		subtract.setInvert(subtractOrSubtractWithBorrow.getOutput());
		subtract.step();

		carryControl.step();
		adder.setCI(carryControl.getCarryIn());
		connectEightBitDataOutputToEightBitAInput(subtract, adder);
		adder.step();

		carryControl.setCarryOut(adder.getCO());
		carryControl.step();
	}

	@Override
	public void setA0(boolean value) {
		subtract.setDI0(value);

	}

	@Override
	public void setA1(boolean value) {
		subtract.setDI1(value);
	}

	@Override
	public void setA2(boolean value) {
		subtract.setDI2(value);
	}

	@Override
	public void setA3(boolean value) {
		subtract.setDI3(value);
	}

	@Override
	public void setA4(boolean value) {
		subtract.setDI4(value);
	}

	@Override
	public void setA5(boolean value) {
		subtract.setDI5(value);
	}

	@Override
	public void setA6(boolean value) {
		subtract.setDI6(value);
	}

	@Override
	public void setA7(boolean value) {
		subtract.setDI7(value);
	}

	@Override
	public void setB0(boolean value) {
		adder.setB0(value);
	}

	@Override
	public void setB1(boolean value) {
		adder.setB1(value);
	}

	@Override
	public void setB2(boolean value) {
		adder.setB2(value);
	}

	@Override
	public void setB3(boolean value) {
		adder.setB3(value);
	}

	@Override
	public void setB4(boolean value) {
		adder.setB4(value);
	}

	@Override
	public void setB5(boolean value) {
		adder.setB5(value);
	}

	@Override
	public void setB6(boolean value) {
		adder.setB6(value);
	}

	@Override
	public void setB7(boolean value) {
		adder.setB7(value);
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
	public void setAdd(boolean value) {
		carryControl.setAdd(value);
	}

	@Override
	public void setAddWithCarry(boolean value) {
		carryControl.setAddWithCarry(value);
	}

	@Override
	public void setSubtract(boolean value) {
		subtractOrSubtractWithBorrow.setA(value);
		carryControl.setSubtract(value);
	}

	@Override
	public void setSubtractWithBorrow(boolean value) {
		subtractOrSubtractWithBorrow.setB(value);
		carryControl.setSubtractWithBorrow(value);
	}

	@Override
	public void setReset(boolean value) {
		carryControl.setClear(value);
	}

	@Override
	public void setClock(boolean value) {
		carryControl.setClock(value);
	}

}

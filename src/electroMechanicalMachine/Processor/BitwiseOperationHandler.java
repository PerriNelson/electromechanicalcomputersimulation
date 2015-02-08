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
import electroMechanicalLogic.EightBitFourToOneSelector;
import electroMechanicalLogic.Gates.ThreeInputOR;
import electroMechanicalLogic.Gates.Interfaces.IThreeInputSingleOutputGate;
import electroMechanicalLogic.Interfaces.IEightBitFourToOneSelector;
import electroMechanicalMachine.Processor.Interfaces.IBitwiseOperationHandler;
import electroMechanicalMachine.Processor.Interfaces.ILogicalOperation;

public class BitwiseOperationHandler implements IBitwiseOperationHandler {

	private final IThreeInputSingleOutputGate isBitwiseOperation = new ThreeInputOR();

	private final ILogicalOperation xor = new ExclusiveOr();
	private final ILogicalOperation or = new Or();
	private final ILogicalOperation and = new And();

	private final IEightBitFourToOneSelector dataOut = new EightBitFourToOneSelector();

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
	public boolean getIsBitwiseOperation() {
		return isBitwiseOperation.getOutput();
	}

	@Override
	public void setA0(final boolean value) {
		xor.setA0(value);
		or.setA0(value);
		and.setA0(value);
	}

	@Override
	public void setA1(final boolean value) {
		xor.setA1(value);
		or.setA1(value);
		and.setA1(value);
	}

	@Override
	public void setA2(final boolean value) {
		xor.setA2(value);
		or.setA2(value);
		and.setA2(value);
	}

	@Override
	public void setA3(final boolean value) {
		xor.setA3(value);
		or.setA3(value);
		and.setA3(value);
	}

	@Override
	public void setA4(final boolean value) {
		xor.setA4(value);
		or.setA4(value);
		and.setA4(value);
	}

	@Override
	public void setA5(final boolean value) {
		xor.setA5(value);
		or.setA5(value);
		and.setA5(value);
	}

	@Override
	public void setA6(final boolean value) {
		xor.setA6(value);
		or.setA6(value);
		and.setA6(value);
	}

	@Override
	public void setA7(final boolean value) {
		xor.setA7(value);
		or.setA7(value);
		and.setA7(value);
	}

	@Override
	public void setAND(final boolean value) {
		isBitwiseOperation.setA(value);
		dataOut.setS1(value);
	}

	@Override
	public void setB0(final boolean value) {
		xor.setB0(value);
		or.setB0(value);
		and.setB0(value);
	}

	@Override
	public void setB1(final boolean value) {
		xor.setB1(value);
		or.setB1(value);
		and.setB1(value);
	}

	@Override
	public void setB2(final boolean value) {
		xor.setB2(value);
		or.setB2(value);
		and.setB2(value);
	}

	@Override
	public void setB3(final boolean value) {
		xor.setB3(value);
		or.setB3(value);
		and.setB3(value);
	}

	@Override
	public void setB4(final boolean value) {
		xor.setB4(value);
		or.setB4(value);
		and.setB4(value);
	}

	@Override
	public void setB5(final boolean value) {
		xor.setB5(value);
		or.setB5(value);
		and.setB5(value);
	}

	@Override
	public void setB6(final boolean value) {
		xor.setB6(value);
		or.setB6(value);
		and.setB6(value);
	}

	@Override
	public void setB7(final boolean value) {
		xor.setB7(value);
		or.setB7(value);
		and.setB7(value);
	}

	@Override
	public void setOR(final boolean value) {
		isBitwiseOperation.setB(value);
		dataOut.setS0(value);
	}

	@Override
	public void setPower(final boolean value) {
		isBitwiseOperation.step();

		xor.setPower(value);
		or.setPower(value);
		and.setPower(value);

		dataOut.setPower(value);
	}

	@Override
	public void setXOR(final boolean value) {
		isBitwiseOperation.setC(value);
	}

	@Override
	public void step() {
		isBitwiseOperation.step();

		xor.step();
		or.step();
		and.step();

		connectEightBitDataOutputToEightBitAInput(xor, dataOut);
		connectEightBitDataOutputToEightBitBInput(or, dataOut);
		connectEightBitDataOutputToEightBitCInput(and, dataOut);
		dataOut.step();

	}

}

/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Model;

import static electroMechanicalLogic.DataChannel.EightBitDataPath.connectEightBitDataOutputToEightBitDataInput;
import electroMechanicalLogic.EightBitEdgeTriggeredLatchWithClear;
import electroMechanicalLogic.Interfaces.IEightBitLatchWithClear;
import electroMechanicalMachine.Model.Interfaces.IMarkIXInstructionDecoder;
import electroMechanicalMachine.Model.Interfaces.IMarkVIIIInstructionDecoder;

public class MarkIXInstructionDecoder implements IMarkIXInstructionDecoder {
	private final IEightBitLatchWithClear code = new EightBitEdgeTriggeredLatchWithClear();
	private final IEightBitLatchWithClear addressLow = new EightBitEdgeTriggeredLatchWithClear();
	private final IEightBitLatchWithClear addressHigh = new EightBitEdgeTriggeredLatchWithClear();
	private final IMarkVIIIInstructionDecoder instructionDecoder = new MarkVIIIInstructionDecoder();

	@Override
	public boolean getA0() {
		return addressLow.getDO0();
	}

	@Override
	public boolean getA1() {
		return addressLow.getDO1();
	}

	@Override
	public boolean getA2() {
		return addressLow.getDO2();
	}

	@Override
	public boolean getA3() {
		return addressLow.getDO3();
	}

	@Override
	public boolean getA4() {
		return addressLow.getDO4();
	}

	@Override
	public boolean getA5() {
		return addressLow.getDO5();
	}

	@Override
	public boolean getA6() {
		return addressLow.getDO6();
	}

	@Override
	public boolean getA7() {
		return addressLow.getDO7();
	}

	@Override
	public boolean getA8() {
		return addressHigh.getDO0();
	}

	@Override
	public boolean getA9() {
		return addressHigh.getDO1();
	}

	@Override
	public boolean getAA() {
		return addressHigh.getDO2();
	}

	@Override
	public boolean getAB() {
		return addressHigh.getDO3();
	}

	@Override
	public boolean getAC() {
		return addressHigh.getDO4();
	}

	@Override
	public boolean getAD() {
		return addressHigh.getDO5();
	}

	@Override
	public boolean getAdd() {
		return instructionDecoder.getAdd();
	}

	@Override
	public boolean getAddWithCarry() {
		return instructionDecoder.getAddWithCarry();
	}

	@Override
	public boolean getAE() {
		return addressHigh.getDO6();
	}

	@Override
	public boolean getAF() {
		return addressHigh.getDO7();
	}

	@Override
	public boolean getHalt() {
		return instructionDecoder.getHalt();
	}

	@Override
	public boolean getLoad() {
		return instructionDecoder.getLoad();
	}

	@Override
	public boolean getStore() {
		return instructionDecoder.getStore();
	}

	@Override
	public boolean getSubtract() {
		return instructionDecoder.getSubtract();
	}

	@Override
	public boolean getSubtractWithBorrow() {
		return instructionDecoder.getSubtractWithBorrow();
	}

	@Override
	public void setClear(final boolean value) {
		code.setClr(value);
		addressLow.setClr(value);
		addressHigh.setClr(value);
	}

	@Override
	public void setDI0(final boolean value) {
		code.setDI0(value);
		addressLow.setDI0(value);
		addressHigh.setDI0(value);
	}

	@Override
	public void setDI1(final boolean value) {
		code.setDI1(value);
		addressLow.setDI1(value);
		addressHigh.setDI1(value);
	}

	@Override
	public void setDI2(final boolean value) {
		code.setDI2(value);
		addressLow.setDI2(value);
		addressHigh.setDI2(value);
	}

	@Override
	public void setDI3(final boolean value) {
		code.setDI3(value);
		addressLow.setDI3(value);
		addressHigh.setDI3(value);
	}

	@Override
	public void setDI4(final boolean value) {
		code.setDI4(value);
		addressLow.setDI4(value);
		addressHigh.setDI4(value);
	}

	@Override
	public void setDI5(final boolean value) {
		code.setDI5(value);
		addressLow.setDI5(value);
		addressHigh.setDI5(value);
	}

	@Override
	public void setDI6(final boolean value) {
		code.setDI6(value);
		addressLow.setDI6(value);
		addressHigh.setDI6(value);
	}

	@Override
	public void setDI7(final boolean value) {
		code.setDI7(value);
		addressLow.setDI7(value);
		addressHigh.setDI7(value);
	}

	@Override
	public void setFetchCode(final boolean value) {
		code.setW(value);
	}

	@Override
	public void setFetchHighAddress(final boolean value) {
		addressHigh.setW(value);
	}

	@Override
	public void setFetchLowAddress(final boolean value) {
		addressLow.setW(value);
	}

	@Override
	public void setPower(final boolean value) {
		code.setPower(value);
		addressLow.setPower(value);
		addressHigh.setPower(value);
		instructionDecoder.setPower(value);
	}

	@Override
	public void step() {
		code.step();
		addressLow.step();
		addressHigh.step();

		connectEightBitDataOutputToEightBitDataInput(code, instructionDecoder);
		instructionDecoder.step();
	}

}

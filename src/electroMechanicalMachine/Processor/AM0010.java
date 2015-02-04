/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Processor;

import static electroMechanicalLogic.DataChannel.EightBitDataPath.connectEightBitCOutputToEightBitCInput;
import static electroMechanicalLogic.DataChannel.EightBitDataPath.connectEightBitDataOutputToEightBitAInput;
import static electroMechanicalLogic.DataChannel.EightBitDataPath.connectEightBitDataOutputToEightBitBInput;
import static electroMechanicalLogic.DataChannel.EightBitDataPath.connectEightBitDataOutputToEightBitDataInput;
import static electroMechanicalLogic.DataChannel.SixteenBitDataPath.connectSixteenBitAOutputToTwoEightBitAInputs;
import static electroMechanicalLogic.DataChannel.SixteenBitDataPath.connectSixteenBitAOutputToTwoEightBitBInputs;
import electroMechanicalLogic.EightBitTwoToOneSelector;
import electroMechanicalLogic.Gates.EightInputOR;
import electroMechanicalLogic.Gates.ThreeInputOR;
import electroMechanicalLogic.Gates.TwoInputAND;
import electroMechanicalLogic.Gates.Interfaces.IEightInputSingleOutputGate;
import electroMechanicalLogic.Gates.Interfaces.IThreeInputSingleOutputGate;
import electroMechanicalLogic.Gates.Interfaces.ITwoInputSingleOutputGate;
import electroMechanicalLogic.Interfaces.IEightBitTwoToOneSelector;
import electroMechanicalMachine.Processor.Interfaces.IArithmeticLogicUnit;
import electroMechanicalMachine.Processor.Interfaces.IInstructionDecoder;
import electroMechanicalMachine.Processor.Interfaces.IInstructionLatch;
import electroMechanicalMachine.Processor.Interfaces.IInstructionTimer;
import electroMechanicalMachine.Processor.Interfaces.IProcessor;
import electroMechanicalMachine.Processor.Interfaces.IProgramCounter;
import electroMechanicalMachine.Processor.Interfaces.IRegister;

/**
 * Processor for the Adding Machine Mark X
 */
public class AM0010 implements IProcessor {
	private final IRegister accumulator = new Register();
	private final IArithmeticLogicUnit alu = new BasicALU();
	private final IEightBitTwoToOneSelector loadSelect = new EightBitTwoToOneSelector();
	private final IProgramCounter programCounter = new BasicProgramCounter();
	private final IInstructionDecoder instructionDecoder = new BasicInstructionDecoder();
	private final IInstructionLatch instructionLatch = new InstructionLatch();
	private final IEightBitTwoToOneSelector addressHigh = new EightBitTwoToOneSelector();
	private final IEightBitTwoToOneSelector addressLow = new EightBitTwoToOneSelector();
	private final IInstructionTimer instructionTimer = new BasicInstructionTimer();
	private final IThreeInputSingleOutputGate instructionFetch = new ThreeInputOR();
	private final ITwoInputSingleOutputGate clockToCounter = new TwoInputAND();
	private final IEightInputSingleOutputGate instructionWritesToAccumulator = new EightInputOR();
	private final ITwoInputSingleOutputGate writeToAccumulator = new TwoInputAND();
	private final ITwoInputSingleOutputGate fetchAddressLowAndClockBar = new TwoInputAND();
	private final ITwoInputSingleOutputGate write = new TwoInputAND();

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
	public boolean getAE() {
		return addressHigh.getDO6();
	}

	@Override
	public boolean getAF() {
		return addressHigh.getDO7();
	}

	@Override
	public boolean getDO0() {
		return accumulator.getDO0();
	}

	@Override
	public boolean getDO1() {
		return accumulator.getDO1();
	}

	@Override
	public boolean getDO2() {
		return accumulator.getDO2();
	}

	@Override
	public boolean getDO3() {
		return accumulator.getDO3();
	}

	@Override
	public boolean getDO4() {
		return accumulator.getDO4();
	}

	@Override
	public boolean getDO5() {
		return accumulator.getDO5();
	}

	@Override
	public boolean getDO6() {
		return accumulator.getDO6();
	}

	@Override
	public boolean getDO7() {
		return accumulator.getDO7();
	}

	@Override
	public boolean getWrite() {
		return write.getOutput();
	}

	@Override
	public void setClock(final boolean value) {
		instructionTimer.setClock(value);
	}

	@Override
	public void setDI0(final boolean value) {
		alu.setA0(value);
		loadSelect.setB0(value);
		instructionLatch.setDI0(value);
	}

	@Override
	public void setDI1(final boolean value) {
		alu.setA1(value);
		loadSelect.setB1(value);
		instructionLatch.setDI1(value);
	}

	@Override
	public void setDI2(final boolean value) {
		alu.setA2(value);
		loadSelect.setB2(value);
		instructionLatch.setDI2(value);
	}

	@Override
	public void setDI3(final boolean value) {
		alu.setA3(value);
		loadSelect.setB3(value);
		instructionLatch.setDI3(value);
	}

	@Override
	public void setDI4(final boolean value) {
		alu.setA4(value);
		loadSelect.setB4(value);
		instructionLatch.setDI4(value);
	}

	@Override
	public void setDI5(final boolean value) {
		alu.setA5(value);
		loadSelect.setB5(value);
		instructionLatch.setDI5(value);
	}

	@Override
	public void setDI6(final boolean value) {
		alu.setA6(value);
		loadSelect.setB6(value);
		instructionLatch.setDI6(value);
	}

	@Override
	public void setDI7(final boolean value) {
		alu.setA7(value);
		loadSelect.setB7(value);
		instructionLatch.setDI7(value);
	}

	@Override
	public void setPower(final boolean value) {
		alu.setPower(value);
		accumulator.setPower(value);
		loadSelect.setPower(value);
		programCounter.setPower(value);
		instructionLatch.setPower(value);
		instructionDecoder.setPower(value);
		addressHigh.setPower(value);
		addressLow.setPower(value);
		instructionTimer.setPower(value);
		clockToCounter.setPower(value);
		write.setPower(value);
		instructionWritesToAccumulator.setPower(value);
		writeToAccumulator.setPower(value);
		fetchAddressLowAndClockBar.setPower(value);
		instructionFetch.setPower(value);
		;
	}

	@Override
	public void setReset(final boolean value) {
		instructionTimer.setReset(value);
		programCounter.setReset(value);
		instructionLatch.setReset(value);
		alu.setReset(value);
		accumulator.setReset(value);
	}

	@Override
	public void step() {
		instructionTimer.step();
		stepInstructionLatch();
		stepInstructionDecoder();
		stepALU();
		stepAccumulator();
		stepProgramCounter();
		expressOutputs();
	}

	private void expressOutputs() {
		connectSixteenBitAOutputToTwoEightBitAInputs(programCounter,
				addressLow, addressHigh);
		connectSixteenBitAOutputToTwoEightBitBInputs(instructionLatch,
				addressLow, addressHigh);

		fetchAddressLowAndClockBar.setA(instructionTimer.getFetchAddressLow());
		fetchAddressLowAndClockBar.setB(instructionTimer.getClockBar());
		fetchAddressLowAndClockBar.step();

		addressLow.setSelect(instructionTimer.getFetchAddressLow());
		addressLow.step();
		addressHigh.setSelect(instructionTimer.getFetchAddressLow());
		addressHigh.step();

		write.setA(fetchAddressLowAndClockBar.getOutput());
		write.setB(instructionDecoder.getStore());
		write.step();
	}

	private void stepAccumulator() {
		connectEightBitDataOutputToEightBitAInput(alu, loadSelect);
		loadSelect.setSelect(instructionDecoder.getLoad());
		loadSelect.step();

		instructionWritesToAccumulator.setDI0(instructionDecoder.getAdd());
		instructionWritesToAccumulator.setDI1(instructionDecoder
				.getAddWithCarry());
		instructionWritesToAccumulator.setDI2(instructionDecoder.getSubtract());
		instructionWritesToAccumulator.setDI3(instructionDecoder
				.getSubtractWithBorrow());
		instructionWritesToAccumulator.setDI4(instructionDecoder.getLoad());
		instructionWritesToAccumulator.step();

		writeToAccumulator.setA(instructionWritesToAccumulator.getOutput());
		writeToAccumulator.setB(instructionTimer.getExecute());
		writeToAccumulator.step();

		connectEightBitDataOutputToEightBitDataInput(loadSelect, accumulator);
		accumulator.setWrite(writeToAccumulator.getOutput());
		accumulator.step();
	}

	private void stepALU() {
		connectEightBitDataOutputToEightBitBInput(accumulator, alu);
		alu.setAdd(instructionDecoder.getAdd());
		alu.setAddWithCarry(instructionDecoder.getAddWithCarry());
		alu.setSubtract(instructionDecoder.getSubtract());
		alu.setSubtractWithBorrow(instructionDecoder.getSubtractWithBorrow());
		alu.setClock(instructionTimer.getExecute());
		alu.step();
	}

	private void stepInstructionDecoder() {
		connectEightBitCOutputToEightBitCInput(instructionLatch,
				instructionDecoder);
		instructionDecoder.step();
	}

	private void stepInstructionLatch() {
		instructionLatch.setCode(instructionTimer.getFetchCode());
		instructionLatch.setAddressHigh(instructionTimer.getFetchAddressHigh());
		instructionLatch.setAddressLow(instructionTimer.getFetchAddressLow());
		instructionLatch.step();
	}

	private void stepProgramCounter() {
		instructionFetch.setA(instructionTimer.getFetchCode());
		instructionFetch.setB(instructionTimer.getFetchAddressHigh());
		instructionFetch.setC(instructionTimer.getFetchAddressLow());
		instructionFetch.step();

		clockToCounter.setA(instructionFetch.getOutput());
		clockToCounter.setB(instructionTimer.getClock());
		clockToCounter.step();

		programCounter.setClock(clockToCounter.getOutput());
		programCounter.step();
	}
}

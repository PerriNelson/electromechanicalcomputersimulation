/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Processor;

import electroMechanicalLogic.FourBitRingCounter;
import electroMechanicalLogic.Inverter;
import electroMechanicalLogic.Gates.ThreeInputAND;
import electroMechanicalLogic.Gates.ThreeInputNOR;
import electroMechanicalLogic.Gates.TwoInputOR;
import electroMechanicalLogic.Gates.Interfaces.IThreeInputSingleOutputGate;
import electroMechanicalLogic.Gates.Interfaces.ITwoInputSingleOutputGate;
import electroMechanicalLogic.Interfaces.IFourBitRingCounter;
import electroMechanicalLogic.Interfaces.IRelay;
import electroMechanicalMachine.Processor.Interfaces.ITimingControl;

public class TimingControl implements ITimingControl {
	private final IFourBitRingCounter instructionCycle = new FourBitRingCounter();
	private final IThreeInputSingleOutputGate clock = new ThreeInputNOR();
	private final IRelay clockBar = new Inverter();
	private final IThreeInputSingleOutputGate singleByteAdvanceToExecute = new ThreeInputAND();
	private final ITwoInputSingleOutputGate resetInstructionCycle = new TwoInputOR();

	@Override
	public boolean getClock() {
		return clock.getOutput();
	}

	@Override
	public boolean getClockBar() {
		return clockBar.getOutput();
	}

	@Override
	public boolean getExecute() {
		return instructionCycle.getQ3();
	}

	@Override
	public boolean getFetchAddressHigh() {
		return instructionCycle.getQ1();
	}

	@Override
	public boolean getFetchAddressLow() {
		return instructionCycle.getQ2();
	}

	@Override
	public boolean getFetchCode() {
		return instructionCycle.getQ0();
	}

	@Override
	public void setClock(final boolean value) {
		clock.setB(value);
	}

	@Override
	public void setHalt(final boolean value) {
		clock.setC(value);
	}

	@Override
	public void setPower(final boolean value) {
		instructionCycle.setPower(value);
		clock.setPower(value);
		clockBar.setPower(value);
		resetInstructionCycle.setPower(value);
		singleByteAdvanceToExecute.setPower(value);
	}

	@Override
	public void setReset(final boolean value) {
		clock.setA(value);
		resetInstructionCycle.setA(value);
	}

	@Override
	public void setSingleByteInstruction(final boolean value) {
		singleByteAdvanceToExecute.setA(value);
	}

	@Override
	public void step() {
		clock.step();

		clockBar.setInput(clock.getOutput());
		clockBar.step();

		resetInstructionCycle.setB(singleByteAdvanceToExecute.getOutput());
		resetInstructionCycle.step();

		instructionCycle.setClear(resetInstructionCycle.getOutput());
		instructionCycle.setClk(clock.getOutput());
		instructionCycle.step();

		singleByteAdvanceToExecute.setB(instructionCycle.getQ0());
		singleByteAdvanceToExecute.setC(clockBar.getOutput());
		singleByteAdvanceToExecute.step();
	}

}

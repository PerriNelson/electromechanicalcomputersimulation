/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Model;

import electroMechanicalLogic.FourBitRingCounter;
import electroMechanicalLogic.Inverter;
import electroMechanicalLogic.SixteenBitCounterWithClear;
import electroMechanicalLogic.Gates.ThreeInputNOR;
import electroMechanicalLogic.Gates.ThreeInputOR;
import electroMechanicalLogic.Gates.TwoInputAND;
import electroMechanicalLogic.Gates.Interfaces.IThreeInputSingleOutputGate;
import electroMechanicalLogic.Gates.Interfaces.ITwoInputSingleOutputGate;
import electroMechanicalLogic.Interfaces.IFourBitRingCounter;
import electroMechanicalLogic.Interfaces.IRelay;
import electroMechanicalLogic.Interfaces.ISixteenBitCounterWithClear;
import electroMechanicalMachine.Model.Interfaces.IMarkIXTimingControl;

public class MarkIXTimingControl implements IMarkIXTimingControl {
	private final IFourBitRingCounter instructionCycle = new FourBitRingCounter();
	private final IThreeInputSingleOutputGate instructionFetch = new ThreeInputOR();
	private final ITwoInputSingleOutputGate clockToCounter = new TwoInputAND();
	private final ISixteenBitCounterWithClear counter = new SixteenBitCounterWithClear();
	private final ITwoInputSingleOutputGate write = new TwoInputAND();
	private final ITwoInputSingleOutputGate justBeforeExecute = new TwoInputAND();
	private final IThreeInputSingleOutputGate clock = new ThreeInputNOR();
	private final IRelay clockBar = new Inverter();

	@Override
	public boolean getA0() {
		return counter.getQ0();
	}

	@Override
	public boolean getA1() {
		return counter.getQ1();
	}

	@Override
	public boolean getA2() {
		return counter.getQ2();
	}

	@Override
	public boolean getA3() {
		return counter.getQ3();
	}

	@Override
	public boolean getA4() {
		return counter.getQ4();
	}

	@Override
	public boolean getA5() {
		return counter.getQ5();
	}

	@Override
	public boolean getA6() {
		return counter.getQ6();
	}

	@Override
	public boolean getA7() {
		return counter.getQ7();
	}

	@Override
	public boolean getA8() {
		return counter.getQ8();
	}

	@Override
	public boolean getA9() {
		return counter.getQ9();
	}

	@Override
	public boolean getAA() {
		return counter.getQA();
	}

	@Override
	public boolean getAB() {
		return counter.getQB();
	}

	@Override
	public boolean getAC() {
		return counter.getQC();
	}

	@Override
	public boolean getAD() {
		return counter.getQD();
	}

	@Override
	public boolean getAE() {
		return counter.getQE();
	}

	@Override
	public boolean getAF() {
		return counter.getQF();
	}

	@Override
	public boolean getExecute() {
		return instructionCycle.getQ3();
	}

	@Override
	public boolean getFetchCode() {
		return instructionCycle.getQ0();
	}

	@Override
	public boolean getFetchHighAddress() {
		return instructionCycle.getQ1();
	}

	@Override
	public boolean getFetchLowAddress() {
		return instructionCycle.getQ2();
	}

	@Override
	public boolean getWrite() {
		return write.getOutput();
	}

	@Override
	public void setClear(final boolean value) {
		instructionCycle.setClear(value);
		counter.setClear(value);
		clock.setC(value);
	}

	@Override
	public void setClock(final boolean value) {
		clock.setB(value);
	}

	@Override
	public void setHalt(final boolean value) {
		clock.setA(value);
	}

	@Override
	public void setPower(final boolean value) {
		instructionCycle.setPower(value);
		instructionFetch.setPower(value);
		clockToCounter.setPower(value);
		counter.setPower(value);
		write.setPower(value);
		clock.setPower(value);
		clockBar.setPower(value);
		justBeforeExecute.setPower(value);
	}

	@Override
	public void setStore(final boolean value) {
		write.setA(value);
	}

	@Override
	public void step() {
		clock.step();

		instructionCycle.setClk(clock.getOutput());
		instructionCycle.step();

		instructionFetch.setA(instructionCycle.getQ0());
		instructionFetch.setB(instructionCycle.getQ1());
		instructionFetch.setC(instructionCycle.getQ2());

		instructionFetch.step();

		clockToCounter.setA(instructionFetch.getOutput());
		clockToCounter.setB(clock.getOutput());
		clockToCounter.step();

		counter.setClk(clockToCounter.getOutput());
		counter.step();

		clockBar.setInput(clock.getOutput());
		clockBar.step();

		justBeforeExecute.setA(clockBar.getOutput());
		justBeforeExecute.setB(instructionCycle.getQ2());
		justBeforeExecute.step();

		write.setB(justBeforeExecute.getOutput());
		write.step();
	}

}

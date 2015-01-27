/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Model;

import electroMechanicalLogic.Inverter;
import electroMechanicalLogic.Oscillator;
import electroMechanicalLogic.SixteenBitCounterWithClear;
import electroMechanicalLogic.TwoInputAND;
import electroMechanicalLogic.Interfaces.IRelay;
import electroMechanicalLogic.Interfaces.ISixteenBitCounterWithClear;
import electroMechanicalLogic.Interfaces.ITwoInputSingleOutputGate;
import electroMechanicalMachine.Model.Interfaces.IMarkVITimingAndMemoryWriteControl;

public class MarkVITimingAndMemoryWriteControl implements
		IMarkVITimingAndMemoryWriteControl {
	private final Oscillator oscillator = new Oscillator();
	private final IRelay clearBar = new Inverter();
	private final IRelay oscillatorBar = new Inverter();
	private final IRelay haltBar = new Inverter();
	private final ITwoInputSingleOutputGate clock = new TwoInputAND();

	private final ITwoInputSingleOutputGate write = new TwoInputAND();
	private final ISixteenBitCounterWithClear address = new SixteenBitCounterWithClear();

	@Override
	public boolean getA0() {
		return address.getQ0();
	}

	@Override
	public boolean getA1() {
		return address.getQ1();
	}

	@Override
	public boolean getA2() {
		return address.getQ2();
	}

	@Override
	public boolean getA3() {
		return address.getQ3();
	}

	@Override
	public boolean getA4() {
		return address.getQ4();
	}

	@Override
	public boolean getA5() {
		return address.getQ5();
	}

	@Override
	public boolean getA6() {
		return address.getQ6();
	}

	@Override
	public boolean getA7() {
		return address.getQ7();
	}

	@Override
	public boolean getA8() {
		return address.getQ8();
	}

	@Override
	public boolean getA9() {
		return address.getQ9();
	}

	@Override
	public boolean getAA() {
		return address.getQA();
	}

	@Override
	public boolean getAB() {
		return address.getQB();
	}

	@Override
	public boolean getAC() {
		return address.getQC();
	}

	@Override
	public boolean getAD() {
		return address.getQD();
	}

	@Override
	public boolean getAE() {
		return address.getQE();
	}

	@Override
	public boolean getAF() {
		return address.getQF();
	}

	@Override
	public boolean getClock() {
		return oscillatorBar.getOutput();
	}

	@Override
	public boolean getWrite() {
		return write.getOutput();
	}

	@Override
	public void setClear(final boolean value) {
		clearBar.setInput(value);
		address.setClear(value);
	}

	@Override
	public void setHalt(final boolean value) {
		haltBar.setInput(value);
	}

	@Override
	public void setPower(final boolean value) {
		oscillator.setPower(value);
		clearBar.setPower(value);
		haltBar.setPower(value);
		oscillatorBar.setPower(value);
		address.setPower(value);
		write.setPower(value);
		clock.setPower(value);
	}

	@Override
	public void setStore(final boolean value) {
		write.setA(value);
	}

	@Override
	public void step() {
		clearBar.step();
		haltBar.step();

		stepClock();
		stepAddress();
		stepWrite();
	}

	private void stepAddress() {
		address.setClk(clock.getOutput());
		address.step();
	}

	private void stepClock() {
		oscillator.setPower(clearBar.getOutput());
		oscillator.step();
		oscillatorBar.setPower(clearBar.getOutput());
		oscillatorBar.setInput(oscillator.getOutput());
		oscillatorBar.step();
		clock.setA(oscillatorBar.getOutput());
		clock.setB(haltBar.getOutput());
		clock.step();
	}

	private void stepWrite() {
		write.setB(oscillator.getOutput());
		write.step();
	}
}

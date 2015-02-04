/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Processor;

import electroMechanicalLogic.SixteenBitCounterWithClear;
import electroMechanicalLogic.Interfaces.ISixteenBitCounterWithClear;
import electroMechanicalMachine.Processor.Interfaces.IProgramCounter;

public class BasicProgramCounter implements IProgramCounter {
	private final ISixteenBitCounterWithClear counter = new SixteenBitCounterWithClear();

	@Override
	public void setPower(boolean value) {
		counter.setPower(value);
	}

	@Override
	public void step() {
		counter.step();
	}

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
	public void setReset(boolean value) {
		counter.setClear(value);
	}

	@Override
	public void setClock(boolean value) {
		counter.setClk(value);
	}

}

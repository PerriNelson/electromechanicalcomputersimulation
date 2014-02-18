/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic;

import electroMechanicalLogic.Interfaces.IDTypeFlipFlop;
import electroMechanicalLogic.Interfaces.ISixteenBitCounter;

public class SixteenBitCounter extends EightBitCounter implements
		ISixteenBitCounter {
	private IDTypeFlipFlop bit8 = new EdgeTriggeredDTypeFlipFlop();
	private IDTypeFlipFlop bit9 = new EdgeTriggeredDTypeFlipFlop();
	private IDTypeFlipFlop bitA = new EdgeTriggeredDTypeFlipFlop();
	private IDTypeFlipFlop bitB = new EdgeTriggeredDTypeFlipFlop();
	private IDTypeFlipFlop bitC = new EdgeTriggeredDTypeFlipFlop();
	private IDTypeFlipFlop bitD = new EdgeTriggeredDTypeFlipFlop();
	private IDTypeFlipFlop bitE = new EdgeTriggeredDTypeFlipFlop();
	private IDTypeFlipFlop bitF = new EdgeTriggeredDTypeFlipFlop();

	@Override
	public boolean getQ8() {
		return bit8.getQ();
	}

	@Override
	public boolean getQ9() {
		return bit9.getQ();
	}

	@Override
	public boolean getQA() {
		return bitA.getQ();
	}

	@Override
	public boolean getQB() {
		return bitB.getQ();
	}

	@Override
	public boolean getQC() {
		return bitC.getQ();
	}

	@Override
	public boolean getQD() {
		return bitD.getQ();
	}

	@Override
	public boolean getQE() {
		return bitE.getQ();
	}

	@Override
	public boolean getQF() {
		return bitF.getQ();
	}

	@Override
	public void setPower(boolean value) {
		super.setPower(value);
		bit8.setPower(value);
		bit9.setPower(value);
		bitA.setPower(value);
		bitB.setPower(value);
		bitC.setPower(value);
		bitD.setPower(value);
		bitE.setPower(value);
		bitF.setPower(value);
	}

	@Override
	public void step() {
		super.step();

		bit8.setClk(bit7.getQBar());
		bit8.setD(bit8.getQBar());
		bit8.step();

		bit9.setClk(bit8.getQBar());
		bit9.setD(bit9.getQBar());
		bit9.step();

		bitA.setClk(bit9.getQBar());
		bitA.setD(bitA.getQBar());
		bitA.step();

		bitB.setClk(bitA.getQBar());
		bitB.setD(bitB.getQBar());
		bitB.step();

		bitC.setClk(bitB.getQBar());
		bitC.setD(bitC.getQBar());
		bitC.step();

		bitD.setClk(bitC.getQBar());
		bitD.setD(bitD.getQBar());
		bitD.step();

		bitE.setClk(bitD.getQBar());
		bitE.setD(bitE.getQBar());
		bitE.step();

		bitF.setClk(bitE.getQBar());
		bitF.setD(bitF.getQBar());
		bitF.step();
	}
}

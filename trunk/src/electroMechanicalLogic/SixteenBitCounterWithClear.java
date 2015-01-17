/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic;

import electroMechanicalLogic.Interfaces.IDTypeFlipFlopWithClear;
import electroMechanicalLogic.Interfaces.ISixteenBitCounterWithClear;

public class SixteenBitCounterWithClear implements ISixteenBitCounterWithClear {
	private IDTypeFlipFlopWithClear bit0 = new EdgeTriggeredDTypeFlipFlopWithPresetAndClear();
	private IDTypeFlipFlopWithClear bit1 = new EdgeTriggeredDTypeFlipFlopWithPresetAndClear();
	private IDTypeFlipFlopWithClear bit2 = new EdgeTriggeredDTypeFlipFlopWithPresetAndClear();
	private IDTypeFlipFlopWithClear bit3 = new EdgeTriggeredDTypeFlipFlopWithPresetAndClear();
	private IDTypeFlipFlopWithClear bit4 = new EdgeTriggeredDTypeFlipFlopWithPresetAndClear();
	private IDTypeFlipFlopWithClear bit5 = new EdgeTriggeredDTypeFlipFlopWithPresetAndClear();
	private IDTypeFlipFlopWithClear bit6 = new EdgeTriggeredDTypeFlipFlopWithPresetAndClear();
	private IDTypeFlipFlopWithClear bit7 = new EdgeTriggeredDTypeFlipFlopWithPresetAndClear();
	private IDTypeFlipFlopWithClear bit8 = new EdgeTriggeredDTypeFlipFlopWithPresetAndClear();
	private IDTypeFlipFlopWithClear bit9 = new EdgeTriggeredDTypeFlipFlopWithPresetAndClear();
	private IDTypeFlipFlopWithClear bitA = new EdgeTriggeredDTypeFlipFlopWithPresetAndClear();
	private IDTypeFlipFlopWithClear bitB = new EdgeTriggeredDTypeFlipFlopWithPresetAndClear();
	private IDTypeFlipFlopWithClear bitC = new EdgeTriggeredDTypeFlipFlopWithPresetAndClear();
	private IDTypeFlipFlopWithClear bitD = new EdgeTriggeredDTypeFlipFlopWithPresetAndClear();
	private IDTypeFlipFlopWithClear bitE = new EdgeTriggeredDTypeFlipFlopWithPresetAndClear();
	private IDTypeFlipFlopWithClear bitF = new EdgeTriggeredDTypeFlipFlopWithPresetAndClear();

	@Override
	public boolean getQ0() {
		return bit0.getQ();
	}

	@Override
	public boolean getQ1() {
		return bit1.getQ();
	}

	@Override
	public boolean getQ2() {
		return bit2.getQ();
	}

	@Override
	public boolean getQ3() {
		return bit3.getQ();
	}

	@Override
	public boolean getQ4() {
		return bit4.getQ();
	}

	@Override
	public boolean getQ5() {
		return bit5.getQ();
	}

	@Override
	public boolean getQ6() {
		return bit6.getQ();
	}

	@Override
	public boolean getQ7() {
		return bit7.getQ();
	}

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
	public void setClear(boolean value) {
		bit0.setClear(value);
		bit1.setClear(value);
		bit2.setClear(value);
		bit3.setClear(value);
		bit4.setClear(value);
		bit5.setClear(value);
		bit6.setClear(value);
		bit7.setClear(value);
		bit8.setClear(value);
		bit9.setClear(value);
		bitA.setClear(value);
		bitB.setClear(value);
		bitC.setClear(value);
		bitD.setClear(value);
		bitE.setClear(value);
		bitF.setClear(value);
	}

	@Override
	public void setClk(boolean value) {
		bit0.setClk(value);
	}

	@Override
	public void setPower(boolean value) {
		bit0.setPower(value);
		bit1.setPower(value);
		bit2.setPower(value);
		bit3.setPower(value);
		bit4.setPower(value);
		bit5.setPower(value);
		bit6.setPower(value);
		bit7.setPower(value);
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
		bit0.setD(bit0.getQBar());
		bit0.step();

		bit1.setClk(bit0.getQBar());
		bit1.setD(bit1.getQBar());
		bit1.step();

		bit2.setClk(bit1.getQBar());
		bit2.setD(bit2.getQBar());
		bit2.step();

		bit3.setClk(bit2.getQBar());
		bit3.setD(bit3.getQBar());
		bit3.step();

		bit4.setClk(bit3.getQBar());
		bit4.setD(bit4.getQBar());
		bit4.step();

		bit5.setClk(bit4.getQBar());
		bit5.setD(bit5.getQBar());
		bit5.step();

		bit6.setClk(bit5.getQBar());
		bit6.setD(bit6.getQBar());
		bit6.step();

		bit7.setClk(bit6.getQBar());
		bit7.setD(bit7.getQBar());
		bit7.step();

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

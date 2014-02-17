/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic;

import electroMechanicalLogic.Interfaces.IDTypeFlipFlop;
import electroMechanicalLogic.Interfaces.IEightBitCounter;

public class EightBitCounter implements IEightBitCounter {
	private IDTypeFlipFlop bit0 = new EdgeTriggeredDTypeFlipFlop();
	private IDTypeFlipFlop bit1 = new EdgeTriggeredDTypeFlipFlop();
	private IDTypeFlipFlop bit2 = new EdgeTriggeredDTypeFlipFlop();
	private IDTypeFlipFlop bit3 = new EdgeTriggeredDTypeFlipFlop();
	private IDTypeFlipFlop bit4 = new EdgeTriggeredDTypeFlipFlop();
	private IDTypeFlipFlop bit5 = new EdgeTriggeredDTypeFlipFlop();
	private IDTypeFlipFlop bit6 = new EdgeTriggeredDTypeFlipFlop();
	private IDTypeFlipFlop bit7 = new EdgeTriggeredDTypeFlipFlop();

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
	}
}

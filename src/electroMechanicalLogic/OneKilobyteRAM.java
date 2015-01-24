/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic;

import electroMechanicalLogic.Interfaces.IFiveHundredTwelveByteRAM;
import electroMechanicalLogic.Interfaces.IOneKilobyteRAM;
import electroMechanicalLogic.Interfaces.IOneLineToTwoLineDecoder;
import electroMechanicalLogic.Interfaces.ITwoLineToOneLineSelector;

public class OneKilobyteRAM implements IOneKilobyteRAM {

	protected IOneLineToTwoLineDecoder w = new OneLineToTwoLineDecoder();
	protected ITwoLineToOneLineSelector dO0 = new TwoLineToOneLineSelector();
	protected ITwoLineToOneLineSelector dO1 = new TwoLineToOneLineSelector();
	protected ITwoLineToOneLineSelector dO2 = new TwoLineToOneLineSelector();
	protected ITwoLineToOneLineSelector dO3 = new TwoLineToOneLineSelector();
	protected ITwoLineToOneLineSelector dO4 = new TwoLineToOneLineSelector();
	protected ITwoLineToOneLineSelector dO5 = new TwoLineToOneLineSelector();
	protected ITwoLineToOneLineSelector dO6 = new TwoLineToOneLineSelector();
	protected ITwoLineToOneLineSelector dO7 = new TwoLineToOneLineSelector();

	protected IFiveHundredTwelveByteRAM bank0;
	protected IFiveHundredTwelveByteRAM bank1;

	public OneKilobyteRAM() {
		initializeBanks();
	}

	@Override
	public boolean getDO0() {
		return dO0.getQ();
	}

	@Override
	public boolean getDO1() {
		return dO1.getQ();
	}

	@Override
	public boolean getDO2() {
		return dO2.getQ();
	}

	@Override
	public boolean getDO3() {
		return dO3.getQ();
	}

	@Override
	public boolean getDO4() {
		return dO4.getQ();
	}

	@Override
	public boolean getDO5() {
		return dO5.getQ();
	}

	@Override
	public boolean getDO6() {
		return dO6.getQ();
	}

	@Override
	public boolean getDO7() {
		return dO7.getQ();
	}

	protected void initializeBanks() {
		bank0 = new FiveHundredTwelveByteRAM();
		bank1 = new FiveHundredTwelveByteRAM();
	}

	@Override
	public void setA0(final boolean value) {
		bank0.setA0(value);
		bank1.setA0(value);
	}

	@Override
	public void setA1(final boolean value) {
		bank0.setA1(value);
		bank1.setA1(value);
	}

	@Override
	public void setA2(final boolean value) {
		bank0.setA2(value);
		bank1.setA2(value);
	}

	@Override
	public void setA3(final boolean value) {
		bank0.setA3(value);
		bank1.setA3(value);
	}

	@Override
	public void setA4(final boolean value) {
		bank0.setA4(value);
		bank1.setA4(value);
	}

	@Override
	public void setA5(final boolean value) {
		bank0.setA5(value);
		bank1.setA5(value);
	}

	@Override
	public void setA6(final boolean value) {
		bank0.setA6(value);
		bank1.setA6(value);
	}

	@Override
	public void setA7(final boolean value) {
		bank0.setA7(value);
		bank1.setA7(value);
	}

	@Override
	public void setA8(final boolean value) {
		bank0.setA8(value);
		bank1.setA8(value);
	}

	@Override
	public void setA9(final boolean value) {
		w.setSelect(value);
		dO0.setSelect(value);
		dO1.setSelect(value);
		dO2.setSelect(value);
		dO3.setSelect(value);
		dO4.setSelect(value);
		dO5.setSelect(value);
		dO6.setSelect(value);
		dO7.setSelect(value);
	}

	@Override
	public void setDI0(final boolean value) {
		bank0.setDI0(value);
		bank1.setDI0(value);
	}

	@Override
	public void setDI1(final boolean value) {
		bank0.setDI1(value);
		bank1.setDI1(value);
	}

	@Override
	public void setDI2(final boolean value) {
		bank0.setDI2(value);
		bank1.setDI2(value);
	}

	@Override
	public void setDI3(final boolean value) {
		bank0.setDI3(value);
		bank1.setDI3(value);
	}

	@Override
	public void setDI4(final boolean value) {
		bank0.setDI4(value);
		bank1.setDI4(value);
	}

	@Override
	public void setDI5(final boolean value) {
		bank0.setDI5(value);
		bank1.setDI5(value);
	}

	@Override
	public void setDI6(final boolean value) {
		bank0.setDI6(value);
		bank1.setDI6(value);
	}

	@Override
	public void setDI7(final boolean value) {
		bank0.setDI7(value);
		bank1.setDI7(value);
	}

	@Override
	public void setPower(final boolean value) {
		w.setPower(value);

		bank0.setPower(value);
		bank1.setPower(value);

		dO0.setPower(value);
		dO1.setPower(value);
		dO2.setPower(value);
		dO3.setPower(value);
		dO4.setPower(value);
		dO5.setPower(value);
		dO6.setPower(value);
		dO7.setPower(value);
	}

	@Override
	public void setW(final boolean value) {
		w.setInput(value);
	}

	@Override
	public void step() {
		w.step();

		bank0.setW(w.getO0());
		bank0.step();

		bank1.setW(w.getO1());
		bank1.step();

		dO0.setA(bank0.getDO0());
		dO0.setB(bank1.getDO0());
		dO0.step();

		dO1.setA(bank0.getDO1());
		dO1.setB(bank1.getDO1());
		dO1.step();

		dO2.setA(bank0.getDO2());
		dO2.setB(bank1.getDO2());
		dO2.step();

		dO3.setA(bank0.getDO3());
		dO3.setB(bank1.getDO3());
		dO3.step();

		dO4.setA(bank0.getDO4());
		dO4.setB(bank1.getDO4());
		dO4.step();

		dO5.setA(bank0.getDO5());
		dO5.setB(bank1.getDO5());
		dO5.step();

		dO6.setA(bank0.getDO6());
		dO6.setB(bank1.getDO6());
		dO6.step();

		dO7.setA(bank0.getDO7());
		dO7.setB(bank1.getDO7());
		dO7.step();
	}
}

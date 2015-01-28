/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic;

import electroMechanicalLogic.Interfaces.IFiveHundredTwelveByteRAM;
import electroMechanicalLogic.RAM.SixtyFourByteRAM;
import electroMechanicalLogic.RAM.Interfaces.ISixtyFourByteRAM;

public class FiveHundredTwelveByteRAM extends
		SixtyFourByteRAM implements
		IFiveHundredTwelveByteRAM {

	@Override
	protected void initializeBanks() {
		bank0 = new SixtyFourByteRAM();
		bank1 = new SixtyFourByteRAM();
		bank2 = new SixtyFourByteRAM();
		bank3 = new SixtyFourByteRAM();
		bank4 = new SixtyFourByteRAM();
		bank5 = new SixtyFourByteRAM();
		bank6 = new SixtyFourByteRAM();
		bank7 = new SixtyFourByteRAM();
	}

	@Override
	public void setA3(final boolean value) {
		((ISixtyFourByteRAM) bank0).setA3(value);
		((ISixtyFourByteRAM) bank1).setA3(value);
		((ISixtyFourByteRAM) bank2).setA3(value);
		((ISixtyFourByteRAM) bank3).setA3(value);
		((ISixtyFourByteRAM) bank4).setA3(value);
		((ISixtyFourByteRAM) bank5).setA3(value);
		((ISixtyFourByteRAM) bank6).setA3(value);
		((ISixtyFourByteRAM) bank7).setA3(value);
	}

	@Override
	public void setA4(final boolean value) {
		((ISixtyFourByteRAM) bank0).setA4(value);
		((ISixtyFourByteRAM) bank1).setA4(value);
		((ISixtyFourByteRAM) bank2).setA4(value);
		((ISixtyFourByteRAM) bank3).setA4(value);
		((ISixtyFourByteRAM) bank4).setA4(value);
		((ISixtyFourByteRAM) bank5).setA4(value);
		((ISixtyFourByteRAM) bank6).setA4(value);
		((ISixtyFourByteRAM) bank7).setA4(value);
	}

	@Override
	public void setA5(final boolean value) {
		((ISixtyFourByteRAM) bank0).setA5(value);
		((ISixtyFourByteRAM) bank1).setA5(value);
		((ISixtyFourByteRAM) bank2).setA5(value);
		((ISixtyFourByteRAM) bank3).setA5(value);
		((ISixtyFourByteRAM) bank4).setA5(value);
		((ISixtyFourByteRAM) bank5).setA5(value);
		((ISixtyFourByteRAM) bank6).setA5(value);
		((ISixtyFourByteRAM) bank7).setA5(value);
	}

	@Override
	public void setA6(final boolean value) {
		w.setS0(value);
		dO0.setS0(value);
		dO1.setS0(value);
		dO2.setS0(value);
		dO3.setS0(value);
		dO4.setS0(value);
		dO5.setS0(value);
		dO6.setS0(value);
		dO7.setS0(value);
	}

	@Override
	public void setA7(final boolean value) {
		w.setS1(value);
		dO0.setS1(value);
		dO1.setS1(value);
		dO2.setS1(value);
		dO3.setS1(value);
		dO4.setS1(value);
		dO5.setS1(value);
		dO6.setS1(value);
		dO7.setS1(value);
	}

	@Override
	public void setA8(final boolean value) {
		w.setS2(value);
		dO0.setS2(value);
		dO1.setS2(value);
		dO2.setS2(value);
		dO3.setS2(value);
		dO4.setS2(value);
		dO5.setS2(value);
		dO6.setS2(value);
		dO7.setS2(value);
	}
}

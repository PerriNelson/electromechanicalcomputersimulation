/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic;

import electroMechanicalLogic.Interfaces.IFiveHundredTwelveByteRAM;
import electroMechanicalLogic.Interfaces.ISixtyFourByOneByteRandomAccessMemory;

public class FiveHundredTwelveByteRAM extends
		SixtyFourByOneByteRandomAccessMemory implements
		IFiveHundredTwelveByteRAM {

	@Override
	protected void initializeBanks() {
		bank0 = new SixtyFourByOneByteRandomAccessMemory();
		bank1 = new SixtyFourByOneByteRandomAccessMemory();
		bank2 = new SixtyFourByOneByteRandomAccessMemory();
		bank3 = new SixtyFourByOneByteRandomAccessMemory();
		bank4 = new SixtyFourByOneByteRandomAccessMemory();
		bank5 = new SixtyFourByOneByteRandomAccessMemory();
		bank6 = new SixtyFourByOneByteRandomAccessMemory();
		bank7 = new SixtyFourByOneByteRandomAccessMemory();
	}

	@Override
	public void setA3(boolean value) {
		((ISixtyFourByOneByteRandomAccessMemory) bank0).setA3(value);
		((ISixtyFourByOneByteRandomAccessMemory) bank1).setA3(value);
		((ISixtyFourByOneByteRandomAccessMemory) bank2).setA3(value);
		((ISixtyFourByOneByteRandomAccessMemory) bank3).setA3(value);
		((ISixtyFourByOneByteRandomAccessMemory) bank4).setA3(value);
		((ISixtyFourByOneByteRandomAccessMemory) bank5).setA3(value);
		((ISixtyFourByOneByteRandomAccessMemory) bank6).setA3(value);
		((ISixtyFourByOneByteRandomAccessMemory) bank7).setA3(value);
	}

	@Override
	public void setA4(boolean value) {
		((ISixtyFourByOneByteRandomAccessMemory) bank0).setA4(value);
		((ISixtyFourByOneByteRandomAccessMemory) bank1).setA4(value);
		((ISixtyFourByOneByteRandomAccessMemory) bank2).setA4(value);
		((ISixtyFourByOneByteRandomAccessMemory) bank3).setA4(value);
		((ISixtyFourByOneByteRandomAccessMemory) bank4).setA4(value);
		((ISixtyFourByOneByteRandomAccessMemory) bank5).setA4(value);
		((ISixtyFourByOneByteRandomAccessMemory) bank6).setA4(value);
		((ISixtyFourByOneByteRandomAccessMemory) bank7).setA4(value);
	}

	@Override
	public void setA5(boolean value) {
		((ISixtyFourByOneByteRandomAccessMemory) bank0).setA5(value);
		((ISixtyFourByOneByteRandomAccessMemory) bank1).setA5(value);
		((ISixtyFourByOneByteRandomAccessMemory) bank2).setA5(value);
		((ISixtyFourByOneByteRandomAccessMemory) bank3).setA5(value);
		((ISixtyFourByOneByteRandomAccessMemory) bank4).setA5(value);
		((ISixtyFourByOneByteRandomAccessMemory) bank5).setA5(value);
		((ISixtyFourByOneByteRandomAccessMemory) bank6).setA5(value);
		((ISixtyFourByOneByteRandomAccessMemory) bank7).setA5(value);
	}

	@Override
	public void setA6(boolean value) {
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
	public void setA7(boolean value) {
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
	public void setA8(boolean value) {
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

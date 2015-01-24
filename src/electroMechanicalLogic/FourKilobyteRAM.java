/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic;

import electroMechanicalLogic.Interfaces.IFiveHundredTwelveByteRAM;
import electroMechanicalLogic.Interfaces.IFourKilobyteRAM;

public class FourKilobyteRAM extends FiveHundredTwelveByteRAM implements
IFourKilobyteRAM {

	@Override
	protected void initializeBanks() {
		bank0 = new FiveHundredTwelveByteRAM();
		bank1 = new FiveHundredTwelveByteRAM();
		bank2 = new FiveHundredTwelveByteRAM();
		bank3 = new FiveHundredTwelveByteRAM();
		bank4 = new FiveHundredTwelveByteRAM();
		bank5 = new FiveHundredTwelveByteRAM();
		bank6 = new FiveHundredTwelveByteRAM();
		bank7 = new FiveHundredTwelveByteRAM();
	}

	@Override
	public void setA6(final boolean value) {
		((IFiveHundredTwelveByteRAM) bank0).setA6(value);
		((IFiveHundredTwelveByteRAM) bank1).setA6(value);
		((IFiveHundredTwelveByteRAM) bank2).setA6(value);
		((IFiveHundredTwelveByteRAM) bank3).setA6(value);
		((IFiveHundredTwelveByteRAM) bank4).setA6(value);
		((IFiveHundredTwelveByteRAM) bank5).setA6(value);
		((IFiveHundredTwelveByteRAM) bank6).setA6(value);
		((IFiveHundredTwelveByteRAM) bank7).setA6(value);
	}

	@Override
	public void setA7(final boolean value) {
		((IFiveHundredTwelveByteRAM) bank0).setA7(value);
		((IFiveHundredTwelveByteRAM) bank1).setA7(value);
		((IFiveHundredTwelveByteRAM) bank2).setA7(value);
		((IFiveHundredTwelveByteRAM) bank3).setA7(value);
		((IFiveHundredTwelveByteRAM) bank4).setA7(value);
		((IFiveHundredTwelveByteRAM) bank5).setA7(value);
		((IFiveHundredTwelveByteRAM) bank6).setA7(value);
		((IFiveHundredTwelveByteRAM) bank7).setA7(value);
	}

	@Override
	public void setA8(final boolean value) {
		((IFiveHundredTwelveByteRAM) bank0).setA8(value);
		((IFiveHundredTwelveByteRAM) bank1).setA8(value);
		((IFiveHundredTwelveByteRAM) bank2).setA8(value);
		((IFiveHundredTwelveByteRAM) bank3).setA8(value);
		((IFiveHundredTwelveByteRAM) bank4).setA8(value);
		((IFiveHundredTwelveByteRAM) bank5).setA8(value);
		((IFiveHundredTwelveByteRAM) bank6).setA8(value);
		((IFiveHundredTwelveByteRAM) bank7).setA8(value);
	}

	@Override
	public void setA9(final boolean value) {
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
	public void setAA(final boolean value) {
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
	public void setAB(final boolean value) {
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

/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic;

import electroMechanicalLogic.Interfaces.IFourKilobyteRAM;
import electroMechanicalLogic.Interfaces.IThirtyTwoKilobyteRAM;

public class ThirtyTwoKilobyteRAM extends FourKilobyteRAM implements
		IThirtyTwoKilobyteRAM {

	public ThirtyTwoKilobyteRAM() {
		super();
		bank0 = new FourKilobyteRAM();
		bank1 = new FourKilobyteRAM();
		bank2 = new FourKilobyteRAM();
		bank3 = new FourKilobyteRAM();
		bank4 = new FourKilobyteRAM();
		bank5 = new FourKilobyteRAM();
		bank6 = new FourKilobyteRAM();
		bank7 = new FourKilobyteRAM();
	}

	@Override
	public void setA9(boolean value) {
		((IFourKilobyteRAM) bank0).setA9(value);
		((IFourKilobyteRAM) bank1).setA9(value);
		((IFourKilobyteRAM) bank2).setA9(value);
		((IFourKilobyteRAM) bank3).setA9(value);
		((IFourKilobyteRAM) bank4).setA9(value);
		((IFourKilobyteRAM) bank5).setA9(value);
		((IFourKilobyteRAM) bank6).setA9(value);
		((IFourKilobyteRAM) bank7).setA9(value);
	}

	@Override
	public void setAA(boolean value) {
		((IFourKilobyteRAM) bank0).setAA(value);
		((IFourKilobyteRAM) bank1).setAA(value);
		((IFourKilobyteRAM) bank2).setAA(value);
		((IFourKilobyteRAM) bank3).setAA(value);
		((IFourKilobyteRAM) bank4).setAA(value);
		((IFourKilobyteRAM) bank5).setAA(value);
		((IFourKilobyteRAM) bank6).setAA(value);
		((IFourKilobyteRAM) bank7).setAA(value);
	}

	@Override
	public void setAB(boolean value) {
		((IFourKilobyteRAM) bank0).setAB(value);
		((IFourKilobyteRAM) bank1).setAB(value);
		((IFourKilobyteRAM) bank2).setAB(value);
		((IFourKilobyteRAM) bank3).setAB(value);
		((IFourKilobyteRAM) bank4).setAB(value);
		((IFourKilobyteRAM) bank5).setAB(value);
		((IFourKilobyteRAM) bank6).setAB(value);
		((IFourKilobyteRAM) bank7).setAB(value);
	}

	@Override
	public void setAC(boolean value) {
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
	public void setAD(boolean value) {
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
	public void setAE(boolean value) {
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

/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic;

import electroMechanicalLogic.Interfaces.ISixtyFourKilobyteRAM;
import electroMechanicalLogic.Interfaces.IThirtyTwoKilobyteRAM;

public class SixtyFourKilobyteRAM extends OneKilobyteRAM implements
ISixtyFourKilobyteRAM {

	@Override
	protected void initializeBanks() {
		bank0 = new ThirtyTwoKilobyteRAM();
		bank1 = new ThirtyTwoKilobyteRAM();
	}

	@Override
	public void setA9(final boolean value) {
		((IThirtyTwoKilobyteRAM) bank0).setA9(value);
		((IThirtyTwoKilobyteRAM) bank1).setA9(value);
	}

	@Override
	public void setAA(final boolean value) {
		((IThirtyTwoKilobyteRAM) bank0).setAA(value);
		((IThirtyTwoKilobyteRAM) bank1).setAA(value);
	}

	@Override
	public void setAB(final boolean value) {
		((IThirtyTwoKilobyteRAM) bank0).setAB(value);
		((IThirtyTwoKilobyteRAM) bank1).setAB(value);
	}

	@Override
	public void setAC(final boolean value) {
		((IThirtyTwoKilobyteRAM) bank0).setAC(value);
		((IThirtyTwoKilobyteRAM) bank1).setAC(value);
	}

	@Override
	public void setAD(final boolean value) {
		((IThirtyTwoKilobyteRAM) bank0).setAD(value);
		((IThirtyTwoKilobyteRAM) bank1).setAD(value);
	}

	@Override
	public void setAE(final boolean value) {
		((IThirtyTwoKilobyteRAM) bank0).setAE(value);
		((IThirtyTwoKilobyteRAM) bank1).setAE(value);
	}

	@Override
	public void setAF(final boolean value) {
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
}

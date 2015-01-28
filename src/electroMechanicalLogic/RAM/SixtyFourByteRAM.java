/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.RAM;

import electroMechanicalLogic.RAM.Interfaces.IEightByteRAM;
import electroMechanicalLogic.RAM.Interfaces.ISixtyFourByteRAM;

/**
 * A sixty four byte random access memory.
 */
public class SixtyFourByteRAM extends EightByteRAM implements ISixtyFourByteRAM {

	@Override
	protected void initializeBanks() {
		bank0 = new EightByteRAM();
		bank1 = new EightByteRAM();
		bank2 = new EightByteRAM();
		bank3 = new EightByteRAM();
		bank4 = new EightByteRAM();
		bank5 = new EightByteRAM();
		bank6 = new EightByteRAM();
		bank7 = new EightByteRAM();
	}

	@Override
	public void setA0(final boolean value) {
		((IEightByteRAM) bank0).setA0(value);
		((IEightByteRAM) bank1).setA0(value);
		((IEightByteRAM) bank2).setA0(value);
		((IEightByteRAM) bank3).setA0(value);
		((IEightByteRAM) bank4).setA0(value);
		((IEightByteRAM) bank5).setA0(value);
		((IEightByteRAM) bank6).setA0(value);
		((IEightByteRAM) bank7).setA0(value);
	}

	@Override
	public void setA1(final boolean value) {
		((IEightByteRAM) bank0).setA1(value);
		((IEightByteRAM) bank1).setA1(value);
		((IEightByteRAM) bank2).setA1(value);
		((IEightByteRAM) bank3).setA1(value);
		((IEightByteRAM) bank4).setA1(value);
		((IEightByteRAM) bank5).setA1(value);
		((IEightByteRAM) bank6).setA1(value);
		((IEightByteRAM) bank7).setA1(value);
	}

	@Override
	public void setA2(final boolean value) {
		((IEightByteRAM) bank0).setA2(value);
		((IEightByteRAM) bank1).setA2(value);
		((IEightByteRAM) bank2).setA2(value);
		((IEightByteRAM) bank3).setA2(value);
		((IEightByteRAM) bank4).setA2(value);
		((IEightByteRAM) bank5).setA2(value);
		((IEightByteRAM) bank6).setA2(value);
		((IEightByteRAM) bank7).setA2(value);
	}

	@Override
	public void setA3(final boolean value) {
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
	public void setA4(final boolean value) {
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
	public void setA5(final boolean value) {
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

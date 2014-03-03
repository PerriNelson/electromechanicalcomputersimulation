/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic;

import electroMechanicalLogic.Interfaces.IEightByOneByteRandomAccessMemory;
import electroMechanicalLogic.Interfaces.ISixtyFourByOneByteRandomAccessMemory;

/**
 * @author perri
 * 
 */
public class SixtyFourByOneByteRandomAccessMemory extends
		EightByOneByteRandomAccessMemory implements
		ISixtyFourByOneByteRandomAccessMemory {

	public SixtyFourByOneByteRandomAccessMemory() {
		super();
		bank0 = new EightByOneByteRandomAccessMemory();
		bank1 = new EightByOneByteRandomAccessMemory();
		bank2 = new EightByOneByteRandomAccessMemory();
		bank3 = new EightByOneByteRandomAccessMemory();
		bank4 = new EightByOneByteRandomAccessMemory();
		bank5 = new EightByOneByteRandomAccessMemory();
		bank6 = new EightByOneByteRandomAccessMemory();
		bank7 = new EightByOneByteRandomAccessMemory();
	}

	@Override
	public void setA0(boolean value) {
		((IEightByOneByteRandomAccessMemory) bank0).setA0(value);
		((IEightByOneByteRandomAccessMemory) bank1).setA0(value);
		((IEightByOneByteRandomAccessMemory) bank2).setA0(value);
		((IEightByOneByteRandomAccessMemory) bank3).setA0(value);
		((IEightByOneByteRandomAccessMemory) bank4).setA0(value);
		((IEightByOneByteRandomAccessMemory) bank5).setA0(value);
		((IEightByOneByteRandomAccessMemory) bank6).setA0(value);
		((IEightByOneByteRandomAccessMemory) bank7).setA0(value);
	}

	@Override
	public void setA1(boolean value) {
		((IEightByOneByteRandomAccessMemory) bank0).setA1(value);
		((IEightByOneByteRandomAccessMemory) bank1).setA1(value);
		((IEightByOneByteRandomAccessMemory) bank2).setA1(value);
		((IEightByOneByteRandomAccessMemory) bank3).setA1(value);
		((IEightByOneByteRandomAccessMemory) bank4).setA1(value);
		((IEightByOneByteRandomAccessMemory) bank5).setA1(value);
		((IEightByOneByteRandomAccessMemory) bank6).setA1(value);
		((IEightByOneByteRandomAccessMemory) bank7).setA1(value);
	}

	@Override
	public void setA2(boolean value) {
		((IEightByOneByteRandomAccessMemory) bank0).setA2(value);
		((IEightByOneByteRandomAccessMemory) bank1).setA2(value);
		((IEightByOneByteRandomAccessMemory) bank2).setA2(value);
		((IEightByOneByteRandomAccessMemory) bank3).setA2(value);
		((IEightByOneByteRandomAccessMemory) bank4).setA2(value);
		((IEightByOneByteRandomAccessMemory) bank5).setA2(value);
		((IEightByOneByteRandomAccessMemory) bank6).setA2(value);
		((IEightByOneByteRandomAccessMemory) bank7).setA2(value);
	}

	@Override
	public void setA3(boolean value) {
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
	public void setA4(boolean value) {
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
	public void setA5(boolean value) {
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

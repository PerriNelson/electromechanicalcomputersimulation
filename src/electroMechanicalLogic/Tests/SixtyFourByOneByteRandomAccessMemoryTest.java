/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.Tests;

import org.junit.Before;

import electroMechanicalLogic.SixtyFourByOneByteRandomAccessMemory;
import electroMechanicalLogic.Interfaces.ISixtyFourByOneByteRandomAccessMemory;

public class SixtyFourByOneByteRandomAccessMemoryTest extends
		EightByOneByteRandomAccessMemoryTest {
 
	@Override
	protected void setA(int value) {
		super.setA(value);
		((ISixtyFourByOneByteRandomAccessMemory) systemUnderTest)
				.setA3((value & bit3) == bit3);
		((ISixtyFourByOneByteRandomAccessMemory) systemUnderTest)
				.setA4((value & bit4) == bit4);
		((ISixtyFourByOneByteRandomAccessMemory) systemUnderTest)
				.setA5((value & bit5) == bit5);
	}

	@Override
	@Before
	public void setUp() throws Exception {
		systemUnderTest = new SixtyFourByOneByteRandomAccessMemory();
		systemUnderTest.setPower(true);
	}

	@Override
	protected int translateAddress(int address) {
		return (super.translateAddress(address) << 3) | address;
	}
}

/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.RAM.Tests;

import static electroMechanicalLogic.Tests.TestConstants.bit3;
import static electroMechanicalLogic.Tests.TestConstants.bit4;
import static electroMechanicalLogic.Tests.TestConstants.bit5;

import org.junit.Before;

import electroMechanicalLogic.RAM.SixtyFourByteRAM;
import electroMechanicalLogic.RAM.Interfaces.ISixtyFourByteRAM;

public class TestSixtyFourByteRAM extends TestEightByteRAM {

	@Override
	@Before
	public void setUp() throws Exception {
		systemUnderTest = new SixtyFourByteRAM();
		systemUnderTest.setPower(true);
	}

	@Override
	protected void setA(final int value) {
		super.setA(value);
		((ISixtyFourByteRAM) systemUnderTest).setA3((value & bit3) == bit3);
		((ISixtyFourByteRAM) systemUnderTest).setA4((value & bit4) == bit4);
		((ISixtyFourByteRAM) systemUnderTest).setA5((value & bit5) == bit5);
	}

	@Override
	protected int translateAddress(final int address) {
		return (super.translateAddress(address) << 3) | address;
	}
}

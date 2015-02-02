/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.RAM.Tests;

import static electroMechanicalLogic.Tests.TestConstants.bit6;
import static electroMechanicalLogic.Tests.TestConstants.bit7;
import static electroMechanicalLogic.Tests.TestConstants.bit8;

import org.junit.Before;

import electroMechanicalLogic.Interfaces.IFiveHundredTwelveByteRAM;
import electroMechanicalLogic.RAM.FiveHundredTwelveByteRAM;

public class FiveHundredTwelveByteRAMTest extends TestSixtyFourByteRAM {

	@Override
	@Before
	public void setUp() throws Exception {
		systemUnderTest = new FiveHundredTwelveByteRAM();
		systemUnderTest.setPower(true);
	}

	@Override
	protected void setA(final int value) {
		super.setA(value);
		((IFiveHundredTwelveByteRAM) systemUnderTest)
				.setA6((value & bit6) == bit6);
		((IFiveHundredTwelveByteRAM) systemUnderTest)
				.setA7((value & bit7) == bit7);
		((IFiveHundredTwelveByteRAM) systemUnderTest)
				.setA8((value & bit8) == bit8);
	}

	@Override
	protected int translateAddress(final int address) {
		return (super.translateAddress(address) << 3) | address;
	}
}

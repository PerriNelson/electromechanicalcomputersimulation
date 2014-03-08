/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.Tests;

import org.junit.Before;

import electroMechanicalLogic.FourKilobyteRAM;
import electroMechanicalLogic.Interfaces.IFourKilobyteRAM;

public class FourKilobyteRAMTest extends FiveHundredTwelveByteRAMTest {
	private static final int bit9 = 0x200;
	private static final int bitA = 0x400;
	private static final int bitB = 0x800;

	@Override
	protected void setA(int value) {
		super.setA(value);
		((IFourKilobyteRAM) systemUnderTest).setA9((value & bit9) == bit9);
		((IFourKilobyteRAM) systemUnderTest).setAA((value & bitA) == bitA);
		((IFourKilobyteRAM) systemUnderTest).setAB((value & bitB) == bitB);
	}

	@Override
	@Before
	public void setUp() throws Exception {
		systemUnderTest = new FourKilobyteRAM();
		systemUnderTest.setPower(true);
	}

	@Override
	protected int translateAddress(int address) {
		return (super.translateAddress(address) << 3) | address;
	}
}

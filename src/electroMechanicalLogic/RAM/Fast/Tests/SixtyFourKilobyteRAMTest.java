/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.RAM.Fast.Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalLogic.RAM.Fast.SixtyFourKilobyteRAM;

public class SixtyFourKilobyteRAMTest extends
		electroMechanicalLogic.Tests.TestSixtyFourKilobyteRAM {

	@Override
	@Before
	public void setUp() throws Exception {
		systemUnderTest = new SixtyFourKilobyteRAM();
		systemUnderTest.setPower(true);
	}

	@Test
	public void test_SetPowerOff_WithStep_ClearsAllAddresses() {
		final int maxAddress = 65535;
		for (int address = 0; address < (maxAddress + 1); address++) {
			setA(address);
			setDI(0xff);
			systemUnderTest.step();
		}

		systemUnderTest.setPower(false);

		for (int address = 0; address < (maxAddress + 1); address++) {
			setA(address);
			systemUnderTest.step();
			assertEquals(getDO(), 0);
		}
	}
}

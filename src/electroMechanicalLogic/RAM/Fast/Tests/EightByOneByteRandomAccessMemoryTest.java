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

import electroMechanicalLogic.RAM.Fast.EightByteRAM;

public class EightByOneByteRandomAccessMemoryTest extends
		electroMechanicalLogic.RAM.Tests.TestEightByteRAM {

	@Before
	@Override
	public void setUp() throws Exception {
		systemUnderTest = new EightByteRAM();
		systemUnderTest.setPower(true);
	}

	@Test
	@Override
	public void test() {
		final int maximumAddress = 7;
		for (int i = 0; i < (maximumAddress + 1); i++) {
			for (int a = 0; a < (maximumAddress + 1); a++) {
				setA(a);
				setDI((a == i) ? 0xff : 0);
				systemUnderTest.setW(true);
				systemUnderTest.step();
				systemUnderTest.setW(false);
				systemUnderTest.step();
			}

			for (int a = 0; a < (maximumAddress + 1); a++) {
				setA(a);
				systemUnderTest.step();
				assertEquals(getDO(), (a == i) ? 0xff : 0);
			}
		}
	}

	@Test
	public void test_SetPowerOff_WithStep_ClearsAllAddresses() {
		final int maxAddress = 7;
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

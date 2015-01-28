/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.RAM.Tests;

import static electroMechanicalLogic.Tests.TestConstants.bit0;
import static electroMechanicalLogic.Tests.TestConstants.bit1;
import static electroMechanicalLogic.Tests.TestConstants.bit2;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalLogic.RAM.EightBitRAM;
import electroMechanicalLogic.RAM.Interfaces.IEightBitRAM;

public class TestEightBitRAM {
	private IEightBitRAM systemUnderTest;

	private void setA(final int value) {
		systemUnderTest.setA0((value & bit0) == bit0);
		systemUnderTest.setA1((value & bit1) == bit1);
		systemUnderTest.setA2((value & bit2) == bit2);
	}

	@Before
	public void setUp() throws Exception {
		systemUnderTest = new EightBitRAM();
		systemUnderTest.setPower(true);
	}

	@Test
	public final void test_GetDO_ForAllAddresses_ReturnsStoredValue() {
		for (int i = 0; i < 8; i++) {
			for (int a = 0; a < 8; a++) {
				setA(a);
				systemUnderTest.setDI(a == i);
				systemUnderTest.setW(true);
				systemUnderTest.step();
				systemUnderTest.setW(false);
				systemUnderTest.step();
			}

			for (int a = 0; a < 8; a++) {
				setA(a);
				systemUnderTest.step();
				assertEquals(systemUnderTest.getDO(), a == i);
			}
		}
	}
}

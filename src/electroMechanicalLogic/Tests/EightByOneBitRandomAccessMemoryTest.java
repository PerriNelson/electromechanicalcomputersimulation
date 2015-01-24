/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalLogic.EightByOneBitRandomAccessMemory;
import electroMechanicalLogic.Interfaces.IEightByOneBitRandomAccessMemory;

public class EightByOneBitRandomAccessMemoryTest {
	private IEightByOneBitRandomAccessMemory systemUnderTest;
	private static final int bit0 = 0x01;
	private static final int bit1 = 0x02;
	private static final int bit2 = 0x04;

	private void setA(final int value) {
		systemUnderTest.setA0((value & bit0) == bit0);
		systemUnderTest.setA1((value & bit1) == bit1);
		systemUnderTest.setA2((value & bit2) == bit2);
	}

	@Before
	public void setUp() throws Exception {
		systemUnderTest = new EightByOneBitRandomAccessMemory();
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

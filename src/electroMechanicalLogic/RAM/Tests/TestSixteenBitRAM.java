/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.RAM.Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalLogic.RAM.SixteenBitRAM;
import electroMechanicalLogic.RAM.Interfaces.ISixteenBitRAM;

public class TestSixteenBitRAM {
	private static ISixteenBitRAM systemUnderTest;
	private static final int bit0 = 0x01;
	private static final int bit1 = 0x02;
	private static final int bit2 = 0x04;
	private static final int bit3 = 0x08;

	@Before
	public void setUp() throws Exception {
		systemUnderTest = new SixteenBitRAM();
		systemUnderTest.setPower(true);
	}

	@Test
	public final void test_GetDO_ForAllAddresses_ReturnsStoredValue() {
		for (int i = 0; i < 16; i++) {
			for (int a = 0; a < 16; a++) {
				setA(a);
				systemUnderTest.setDI(a == i);
				systemUnderTest.setW(true);
				systemUnderTest.step();
				systemUnderTest.setW(false);
				systemUnderTest.step();
			}

			for (int a = 0; a < 16; a++) {
				setA(a);
				systemUnderTest.step();

				assertEquals(systemUnderTest.getDO(), a == i);
			}
		}
	}

	private void setA(final int value) {
		systemUnderTest.setA0((value & bit0) == bit0);
		systemUnderTest.setA1((value & bit1) == bit1);
		systemUnderTest.setA2((value & bit2) == bit2);
		systemUnderTest.setA3((value & bit3) == bit3);
	}

}

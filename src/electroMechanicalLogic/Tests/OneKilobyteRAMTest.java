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

import electroMechanicalLogic.OneKilobyteRAM;
import electroMechanicalLogic.Interfaces.IOneKilobyteRAM;

public class OneKilobyteRAMTest {

	private IOneKilobyteRAM systemUnderTest;
	private static final int bit0 = 0x01;
	private static final int bit1 = 0x02;
	private static final int bit2 = 0x04;
	private static final int bit3 = 0x08;
	private static final int bit4 = 0x10;
	private static final int bit5 = 0x20;
	private static final int bit6 = 0x40;
	private static final int bit7 = 0x80;
	private static final int bit8 = 0x100;
	private static final int bit9 = 0x200;

	private int getDO() {
		int result = 0;

		result |= systemUnderTest.getDO0() ? bit0 : 0;
		result |= systemUnderTest.getDO1() ? bit1 : 0;
		result |= systemUnderTest.getDO2() ? bit2 : 0;
		result |= systemUnderTest.getDO3() ? bit3 : 0;
		result |= systemUnderTest.getDO4() ? bit4 : 0;
		result |= systemUnderTest.getDO5() ? bit5 : 0;
		result |= systemUnderTest.getDO6() ? bit6 : 0;
		result |= systemUnderTest.getDO7() ? bit7 : 0;

		return result;
	}

	private void setA(int value) {
		systemUnderTest.setA0((value & bit0) == bit0);
		systemUnderTest.setA1((value & bit1) == bit1);
		systemUnderTest.setA2((value & bit2) == bit2);
		systemUnderTest.setA3((value & bit3) == bit3);
		systemUnderTest.setA4((value & bit4) == bit4);
		systemUnderTest.setA5((value & bit5) == bit5);
		systemUnderTest.setA6((value & bit6) == bit6);
		systemUnderTest.setA7((value & bit7) == bit7);
		systemUnderTest.setA8((value & bit8) == bit8);
		systemUnderTest.setA9((value & bit9) == bit9);
	}

	private void setDI(int value) {
		systemUnderTest.setDI0((value & bit0) == bit0);
		systemUnderTest.setDI1((value & bit1) == bit1);
		systemUnderTest.setDI2((value & bit2) == bit2);
		systemUnderTest.setDI3((value & bit3) == bit3);
		systemUnderTest.setDI4((value & bit4) == bit4);
		systemUnderTest.setDI5((value & bit5) == bit5);
		systemUnderTest.setDI6((value & bit6) == bit6);
		systemUnderTest.setDI7((value & bit7) == bit7);
	}

	@Before
	public void setUp() throws Exception {
		systemUnderTest = new OneKilobyteRAM();
		systemUnderTest.setPower(true);
	}

	@Test
	public final void test() {
		for (int a = 0; a < 1024; a++) {
			setA(a);
			setDI(a % 256);
			systemUnderTest.setW(true);
			systemUnderTest.step();
			systemUnderTest.setW(false);
			systemUnderTest.step();
		}

		for (int a = 0; a < 1024; a++) {
			setA(a);
			systemUnderTest.step();
			assertEquals(getDO(), a % 256);
		}
	}
}
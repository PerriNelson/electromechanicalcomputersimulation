/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.RAM.Tests;

import static electroMechanicalLogic.Tests.TestConstants.bit0;
import static electroMechanicalLogic.Tests.TestConstants.bit1;
import static electroMechanicalLogic.Tests.TestConstants.bit2;
import static electroMechanicalLogic.Tests.TestConstants.bit3;
import static electroMechanicalLogic.Tests.TestConstants.bit4;
import static electroMechanicalLogic.Tests.TestConstants.bit5;
import static electroMechanicalLogic.Tests.TestConstants.bit6;
import static electroMechanicalLogic.Tests.TestConstants.bit7;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalLogic.RAM.EightByteRAM;
import electroMechanicalLogic.RAM.Interfaces.IEightByteRAM;

public class TestEightByteRAM {
	protected IEightByteRAM systemUnderTest;

	protected final int getDO() {
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

	protected void setA(final int value) {
		systemUnderTest.setA0((value & bit0) == bit0);
		systemUnderTest.setA1((value & bit1) == bit1);
		systemUnderTest.setA2((value & bit2) == bit2);
	}

	protected final void setDI(final int value) {
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
		systemUnderTest = new EightByteRAM();
		systemUnderTest.setPower(true);
	}

	@Test
	public void test() {
		for (int i = 0; i < 8; i++) {
			for (int a = 0; a < 8; a++) {
				setA(translateAddress(a));
				setDI((a == i) ? 0xff : 0);
				systemUnderTest.setW(true);
				systemUnderTest.step();
				systemUnderTest.setW(false);
				systemUnderTest.step();
			}

			for (int a = 0; a < 8; a++) {
				setA(translateAddress(a));
				systemUnderTest.step();
				assertEquals(getDO(), (a == i) ? 0xff : 0);
			}
		}
	}

	protected int translateAddress(final int address) {
		return address;
	}
}

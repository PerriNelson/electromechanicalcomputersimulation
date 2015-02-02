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

import electroMechanicalLogic.EightBitLatch;
import electroMechanicalLogic.Interfaces.IEightBitLatch;

public class EightBitLatchTest {
	private static final int bit0 = 0x01;
	private static final int bit1 = 0x02;
	private static final int bit2 = 0x04;
	private static final int bit3 = 0x08;
	private static final int bit4 = 0x10;
	private static final int bit5 = 0x20;
	private static final int bit6 = 0x40;
	private static final int bit7 = 0x80;

	protected IEightBitLatch systemUnderTest;

	@Before
	public void setUp() throws Exception {
		systemUnderTest = new EightBitLatch();
		systemUnderTest.setPower(true);
		systemUnderTest.step();
	}

	@Test
	public void test() {
		for (int testValue = 0; testValue < 0x100; testValue++) {
			setDI(testValue);
			systemUnderTest.setW(true);
			systemUnderTest.step();
			systemUnderTest.setW(false);
			systemUnderTest.step();
			assertEquals(testValue, getDO());
		}
	}

	protected int getDO() {
		int result = 0;

		if (systemUnderTest.getDO0()) {
			result |= bit0;
		}
		if (systemUnderTest.getDO1()) {
			result |= bit1;
		}
		if (systemUnderTest.getDO2()) {
			result |= bit2;
		}
		if (systemUnderTest.getDO3()) {
			result |= bit3;
		}
		if (systemUnderTest.getDO4()) {
			result |= bit4;
		}
		if (systemUnderTest.getDO5()) {
			result |= bit5;
		}
		if (systemUnderTest.getDO6()) {
			result |= bit6;
		}
		if (systemUnderTest.getDO7()) {
			result |= bit7;
		}

		return result;
	}

	protected void setDI(final int value) {
		systemUnderTest.setDI0((value & bit0) == bit0);
		systemUnderTest.setDI1((value & bit1) == bit1);
		systemUnderTest.setDI2((value & bit2) == bit2);
		systemUnderTest.setDI3((value & bit3) == bit3);
		systemUnderTest.setDI4((value & bit4) == bit4);
		systemUnderTest.setDI5((value & bit5) == bit5);
		systemUnderTest.setDI6((value & bit6) == bit6);
		systemUnderTest.setDI7((value & bit7) == bit7);
	}
}

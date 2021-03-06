/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.Gates.Tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalLogic.Gates.EightInputAND;
import electroMechanicalLogic.Gates.Interfaces.IEightInputSingleOutputGate;

public class TestEightInputAND {
	private static final int bit0 = 0x1;
	private static final int bit1 = 0x2;
	private static final int bit2 = 0x4;
	private static final int bit3 = 0x8;
	private static final int bit4 = 0x10;
	private static final int bit5 = 0x20;
	private static final int bit6 = 0x40;
	private static final int bit7 = 0x80;

	private IEightInputSingleOutputGate systemUnderTest;

	@Before
	public void Setup() {
		systemUnderTest = new EightInputAND();
		systemUnderTest.setPower(true);
	}

	@Test
	public void test_WhenAllBitsAreOn_OutputIsOn() {
		setInput(0xff);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getOutput());
	}

	@Test
	public void test_WhenAnyBitisOff_OutputIsOff() {
		for (int i = 0; i < 0xff; i++) {
			setInput(i);
			systemUnderTest.step();

			assertFalse(systemUnderTest.getOutput());
		}
	}

	private void setInput(final int input) {
		systemUnderTest.setDI0((input & bit0) == bit0);
		systemUnderTest.setDI1((input & bit1) == bit1);
		systemUnderTest.setDI2((input & bit2) == bit2);
		systemUnderTest.setDI3((input & bit3) == bit3);
		systemUnderTest.setDI4((input & bit4) == bit4);
		systemUnderTest.setDI5((input & bit5) == bit5);
		systemUnderTest.setDI6((input & bit6) == bit6);
		systemUnderTest.setDI7((input & bit7) == bit7);
	}
}

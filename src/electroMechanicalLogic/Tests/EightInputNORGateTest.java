/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.Tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalLogic.EightInputNORGate;
import electroMechanicalLogic.Interfaces.IEightInputSingleOutputGate;

public class EightInputNORGateTest {
	private static final int bit0 = 0x1;
	private static final int bit1 = 0x2;
	private static final int bit2 = 0x4;
	private static final int bit3 = 0x8;
	private static final int bit4 = 0x10;
	private static final int bit5 = 0x20;
	private static final int bit6 = 0x40;
	private static final int bit7 = 0x80;

	private IEightInputSingleOutputGate systemUnderTest;

	private void setInput(final int input) {
		systemUnderTest.setI0((input & bit0) == bit0);
		systemUnderTest.setI1((input & bit1) == bit1);
		systemUnderTest.setI2((input & bit2) == bit2);
		systemUnderTest.setI3((input & bit3) == bit3);
		systemUnderTest.setI4((input & bit4) == bit4);
		systemUnderTest.setI5((input & bit5) == bit5);
		systemUnderTest.setI6((input & bit6) == bit6);
		systemUnderTest.setI7((input & bit7) == bit7);
	}

	@Before
	public void Setup() {
		systemUnderTest = new EightInputNORGate();
		systemUnderTest.setPower(true);
	}

	@Test
	public void test_WhenAllBitsAreOff_OutputIsOn() {
		setInput(0);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getOutput());
	}

	@Test
	public void test_WhenAnyBitisOn_OutputIsOff() {
		for (int i = 1; i < 256; i++) {
			setInput(i);
			systemUnderTest.step();

			assertFalse(String.format("i == %d", i),
					systemUnderTest.getOutput());
		}
	}
}

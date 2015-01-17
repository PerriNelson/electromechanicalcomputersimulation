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

import electroMechanicalLogic.EightBitCounter;
import electroMechanicalLogic.Interfaces.IEightBitCounter;

public class EightBitCounterTest {
 
	private static final int bit0 = 0x01;
	private static final int bit1 = 0x02;
	private static final int bit2 = 0x04;
	private static final int bit3 = 0x08;
	private static final int bit4 = 0x10;
	private static final int bit5 = 0x20;
	private static final int bit6 = 0x40;
	private static final int bit7 = 0x80;

	private IEightBitCounter systemUnderTest;

	private void clockCycle() {
		systemUnderTest.setClk(false);
		systemUnderTest.step();
		systemUnderTest.setClk(true);
		systemUnderTest.step();
	}

	private int getValue() {
		int result = 0;
		if (systemUnderTest.getQ0())
			result |= bit0;
		if (systemUnderTest.getQ1())
			result |= bit1;
		if (systemUnderTest.getQ2())
			result |= bit2;
		if (systemUnderTest.getQ3())
			result |= bit3;
		if (systemUnderTest.getQ4())
			result |= bit4;
		if (systemUnderTest.getQ5())
			result |= bit5;
		if (systemUnderTest.getQ6())
			result |= bit6;
		if (systemUnderTest.getQ7())
			result |= bit7;

		return result;
	}

	@Before
	public void setUp() throws Exception {
		systemUnderTest = new EightBitCounter();
		systemUnderTest.setPower(true);
	}

	@Test
	public final void test_clockCycle_incrementsCounter_throughAllEightBits() {
		for (int i = 0; i < 256; i++) {
			clockCycle();
			assertEquals(getValue(), i);
		}
	}
}

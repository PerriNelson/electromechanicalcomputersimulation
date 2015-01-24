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

import electroMechanicalLogic.SixteenBitCounter;
import electroMechanicalLogic.Interfaces.ISixteenBitCounter;

public class SixteenBitCounterTest {
	private static final int bit0 = 0x0001;
	private static final int bit1 = 0x0002;
	private static final int bit2 = 0x0004;
	private static final int bit3 = 0x0008;
	private static final int bit4 = 0x0010;
	private static final int bit5 = 0x0020;
	private static final int bit6 = 0x0040;
	private static final int bit7 = 0x0080;
	private static final int bit8 = 0x0100;
	private static final int bit9 = 0x0200;
	private static final int bitA = 0x0400;
	private static final int bitB = 0x0800;
	private static final int bitC = 0x1000;
	private static final int bitD = 0x2000;
	private static final int bitE = 0x4000;
	private static final int bitF = 0x8000;

	private ISixteenBitCounter systemUnderTest;

	private void clockCycle() {
		systemUnderTest.setClk(false);
		systemUnderTest.step();
		systemUnderTest.setClk(true);
		systemUnderTest.step();
	}

	private int getEightBitValue() {
		int result = 0;
		if (systemUnderTest.getQ0()) {
			result |= bit0;
		}
		if (systemUnderTest.getQ1()) {
			result |= bit1;
		}
		if (systemUnderTest.getQ2()) {
			result |= bit2;
		}
		if (systemUnderTest.getQ3()) {
			result |= bit3;
		}
		if (systemUnderTest.getQ4()) {
			result |= bit4;
		}
		if (systemUnderTest.getQ5()) {
			result |= bit5;
		}
		if (systemUnderTest.getQ6()) {
			result |= bit6;
		}
		if (systemUnderTest.getQ7()) {
			result |= bit7;
		}

		return result;
	}

	private int getSixteenBitValue() {
		int result = 0;
		if (systemUnderTest.getQ0()) {
			result |= bit0;
		}
		if (systemUnderTest.getQ1()) {
			result |= bit1;
		}
		if (systemUnderTest.getQ2()) {
			result |= bit2;
		}
		if (systemUnderTest.getQ3()) {
			result |= bit3;
		}
		if (systemUnderTest.getQ4()) {
			result |= bit4;
		}
		if (systemUnderTest.getQ5()) {
			result |= bit5;
		}
		if (systemUnderTest.getQ6()) {
			result |= bit6;
		}
		if (systemUnderTest.getQ7()) {
			result |= bit7;
		}
		if (systemUnderTest.getQ8()) {
			result |= bit8;
		}
		if (systemUnderTest.getQ9()) {
			result |= bit9;
		}
		if (systemUnderTest.getQA()) {
			result |= bitA;
		}
		if (systemUnderTest.getQB()) {
			result |= bitB;
		}
		if (systemUnderTest.getQC()) {
			result |= bitC;
		}
		if (systemUnderTest.getQD()) {
			result |= bitD;
		}
		if (systemUnderTest.getQE()) {
			result |= bitE;
		}
		if (systemUnderTest.getQF()) {
			result |= bitF;
		}

		return result;
	}

	@Before
	public void setUp() throws Exception {
		systemUnderTest = new SixteenBitCounter();
		systemUnderTest.setPower(true);
	}

	@Test
	public final void test_clockCycle_incrementsCounter_throughAllSixteenBits() {
		for (int i = 0; i < 0x10000; i++) {
			clockCycle();
			assertEquals(getSixteenBitValue(), i);
		}
	}

	@Test
	public final void test_SixteenBitCOunter_BehavesLikeAnEightBitCounter_WhenOnlyEightBitsAreChecked() {
		for (int i = 0; i < 0x10000; i++) {
			clockCycle();
			assertEquals(getEightBitValue(), i & 0xFF);
		}
	}
}

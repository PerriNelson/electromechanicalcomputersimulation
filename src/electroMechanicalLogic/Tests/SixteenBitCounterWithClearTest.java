/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalLogic.SixteenBitCounterWithClear;
import electroMechanicalLogic.Interfaces.ISixteenBitCounterWithClear;

public class SixteenBitCounterWithClearTest {
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
	private static final boolean on = true;
	private static final boolean off = false;

	private ISixteenBitCounterWithClear systemUnderTest;

	@Before
	public void Setup() {
		systemUnderTest = new SixteenBitCounterWithClear();
		systemUnderTest.setPower(on);
	}

	@Test
	public void test_WithClearOff_CountsThrough65535AndRollsOver() {
		systemUnderTest.setClear(on);
		systemUnderTest.step();
		systemUnderTest.setClear(off);
		for (int i = 0; i < 65537; i++) {
			assertEquals("i == %d ", i & 0xffff, getCount());
			performOneClockCycle();
		}
	}

	@Test
	public void test_WithClearOn_CountIsAlwaysZero() {
		systemUnderTest.setClear(on);
		for (int i = 0; i < 65537; i++) {
			performOneClockCycle();
			assertEquals(0, getCount());
		}
	}

	private int getCount() {
		int count = 0;
		count |= systemUnderTest.getQ0() ? bit0 : 0;
		count |= systemUnderTest.getQ1() ? bit1 : 0;
		count |= systemUnderTest.getQ2() ? bit2 : 0;
		count |= systemUnderTest.getQ3() ? bit3 : 0;
		count |= systemUnderTest.getQ4() ? bit4 : 0;
		count |= systemUnderTest.getQ5() ? bit5 : 0;
		count |= systemUnderTest.getQ6() ? bit6 : 0;
		count |= systemUnderTest.getQ7() ? bit7 : 0;
		count |= systemUnderTest.getQ8() ? bit8 : 0;
		count |= systemUnderTest.getQ9() ? bit9 : 0;
		count |= systemUnderTest.getQA() ? bitA : 0;
		count |= systemUnderTest.getQB() ? bitB : 0;
		count |= systemUnderTest.getQC() ? bitC : 0;
		count |= systemUnderTest.getQD() ? bitD : 0;
		count |= systemUnderTest.getQE() ? bitE : 0;
		count |= systemUnderTest.getQF() ? bitF : 0;
		return count;
	}

	private void performOneClockCycle() {
		systemUnderTest.setClk(off);
		systemUnderTest.step();
		systemUnderTest.setClk(on);
		systemUnderTest.step();
	}
}

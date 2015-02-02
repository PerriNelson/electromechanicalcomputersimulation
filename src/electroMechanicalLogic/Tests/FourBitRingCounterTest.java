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

import electroMechanicalLogic.FourBitRingCounter;
import electroMechanicalLogic.Interfaces.IFourBitRingCounter;

public class FourBitRingCounterTest {

	private static final byte bit0 = 0x01;
	private static final byte bit1 = 0x02;
	private static final byte bit2 = 0x04;
	private static final byte bit3 = 0x08;

	private IFourBitRingCounter systemUnderTest;

	@Before
	public void setUp() throws Exception {
		systemUnderTest = new FourBitRingCounter();
	}

	@Test
	public void test_OnlyBit2IsSet_AfterThreeClockCycles() {
		initializeCounter();

		performOneClockCycle();
		performOneClockCycle();
		performOneClockCycle();

		final byte counterValue = getCounterValue();

		assertEquals(counterValue, bit2);
	}

	@Test
	public void test_OnlyBitOneIsSet_AfterTwoClockCycles() {
		initializeCounter();

		performOneClockCycle();
		performOneClockCycle();

		final byte counterValue = getCounterValue();

		assertEquals(counterValue, bit1);
	}

	@Test
	public void test_OnlyBitThreeIsSet_AfterFourClockCycles() {
		initializeCounter();

		performOneClockCycle();
		performOneClockCycle();
		performOneClockCycle();
		performOneClockCycle();

		final byte counterValue = getCounterValue();

		assertEquals(counterValue, bit3);
	}

	@Test
	public void test_OnlyBitThreeIsSet_WhenClearIsHigh() {
		initializeCounter();

		final byte counterValue = getCounterValue();

		assertEquals(counterValue, bit3);
	}

	@Test
	public void test_OnlyBitZeroIsSet_AfterOneClockCycle() {
		initializeCounter();

		performOneClockCycle();

		final byte counterValue = getCounterValue();

		assertEquals(counterValue, bit0);
	}

	private byte getCounterValue() {
		byte value = 0;

		value |= systemUnderTest.getQ0() ? bit0 : 0;
		value |= systemUnderTest.getQ1() ? bit1 : 0;
		value |= systemUnderTest.getQ2() ? bit2 : 0;
		value |= systemUnderTest.getQ3() ? bit3 : 0;

		return value;
	}

	private void initializeCounter() {
		systemUnderTest.setPower(true);
		systemUnderTest.setClear(true);
		systemUnderTest.setClk(false);
		systemUnderTest.step();

		performOneClockCycle();

		systemUnderTest.setClear(false);
		systemUnderTest.step();
	}

	private void performOneClockCycle() {

		systemUnderTest.setClk(true);
		systemUnderTest.step();

		systemUnderTest.setClk(false);
		systemUnderTest.step();
	}
}

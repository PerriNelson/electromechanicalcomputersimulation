/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
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

import electroMechanicalLogic.FourBitRingCounter;
import electroMechanicalLogic.Interfaces.IFourBitRingCounter;

public class FourBitRingCounterTest {

	private IFourBitRingCounter systemUnderTest;

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

	@Before
	public void setUp() throws Exception {
		systemUnderTest = new FourBitRingCounter();
	}

	@Test
	public void test_Q0IsHighAndQ1IsLowAndQ2IsLowAndQ3IsLow_AfterOneClockCycle() {
		initializeCounter();

		performOneClockCycle();

		assertTrue(systemUnderTest.getQ0());
		assertFalse(systemUnderTest.getQ1());
		assertFalse(systemUnderTest.getQ2());
		assertFalse(systemUnderTest.getQ3());
	}

	@Test
	public void test_Q0IsLowAndQ1IsHighAndQ2IsLowAndQ3IsLow_AfterTwoClockCycles() {
		initializeCounter();

		performOneClockCycle();
		performOneClockCycle();

		assertFalse(systemUnderTest.getQ0());
		assertTrue(systemUnderTest.getQ1());
		assertFalse(systemUnderTest.getQ2());
		assertFalse(systemUnderTest.getQ3());
	}

	@Test
	public void test_Q0IsLowAndQ1IsLowAndQ2IsHighAndQ3IsLow_AfterThreeClockCycles() {
		initializeCounter();

		performOneClockCycle();
		performOneClockCycle();
		performOneClockCycle();

		assertFalse(systemUnderTest.getQ0());
		assertFalse(systemUnderTest.getQ1());
		assertTrue(systemUnderTest.getQ2());
		assertFalse(systemUnderTest.getQ3());
	}

	@Test
	public void test_Q0IsLowAndQ1IsLowAndQ2IsLowAndQ3IsHigh_AfterFourClockCycles() {
		initializeCounter();

		performOneClockCycle();
		performOneClockCycle();
		performOneClockCycle();
		performOneClockCycle();

		assertFalse(systemUnderTest.getQ0());
		assertFalse(systemUnderTest.getQ1());
		assertFalse(systemUnderTest.getQ2());
		assertTrue(systemUnderTest.getQ3());
	}

	@Test
	public void test_Q0IsLowAndQ1IsLowAndQ2IsLowAndQ3IsHigh_WhenClearIsHigh() {
		initializeCounter();

		assertFalse(systemUnderTest.getQ0());
		assertFalse(systemUnderTest.getQ1());
		assertFalse(systemUnderTest.getQ2());
		assertTrue(systemUnderTest.getQ3());
	}
}

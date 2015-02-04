/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Processor.Tests;

import static electroMechanicalLogic.Tests.TestConstants.off;
import static electroMechanicalLogic.Tests.TestConstants.on;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalMachine.Processor.BasicInstructionTimer;
import electroMechanicalMachine.Processor.Interfaces.IInstructionTimer;

public class TestBasicInstructionTimer {
	private IInstructionTimer systemUnderTest;

	@Before
	public void setUp() {
		systemUnderTest = new BasicInstructionTimer();
		systemUnderTest.setPower(on);
		systemUnderTest.setReset(on);
		systemUnderTest.step();
		systemUnderTest.setReset(off);
	}

	@Test
	public void testGetClock_shouldReturnFalse_whenHaltIsOffandClockInputIsOn() {
		systemUnderTest.setHalt(off);
		systemUnderTest.setClock(on);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getClock());
	}

	@Test
	public void testGetClock_shouldReturnFalse_whenHaltIsOnandClockInputIsOff() {
		systemUnderTest.setHalt(on);
		systemUnderTest.setClock(off);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getClock());
	}

	@Test
	public void testGetClock_shouldReturnFalse_whenHaltIsOnandClockInputIsOn() {
		systemUnderTest.setHalt(on);
		systemUnderTest.setClock(on);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getClock());
	}

	@Test
	public void testGetClock_shouldReturnFalse_whenResetIsOnandClockInputIsOn() {
		systemUnderTest.setReset(on);
		systemUnderTest.setClock(on);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getClock());
	}

	@Test
	public void testGetClock_shouldReturnFalse_whenResetsOnandClockInputIsOff() {
		systemUnderTest.setReset(on);
		systemUnderTest.setClock(off);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getClock());
	}

	@Test
	public void testGetClock_shouldReturnTrue_whenHaltIsOffandClockInputIsOn() {
		systemUnderTest.setHalt(off);
		systemUnderTest.setClock(off);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getClock());
	}

	@Test
	public void testGetClockBar_shouldReturnFalse_whenHaltIsOffandClockInputIsOff() {
		systemUnderTest.setHalt(off);
		systemUnderTest.setClock(off);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getClockBar());
	}

	@Test
	public void testGetClockBar_shouldReturnTrue_whenHaltIsOffandClockInputIsOn() {
		systemUnderTest.setHalt(off);
		systemUnderTest.setClock(on);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getClockBar());
	}

	@Test
	public void testGetClockBar_shouldReturnTrue_whenHaltIsOnandClockInputIsOff() {
		systemUnderTest.setHalt(on);
		systemUnderTest.setClock(off);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getClockBar());
	}

	@Test
	public void testGetClockBar_shouldReturnTrue_whenHaltIsOnandClockInputIsOn() {
		systemUnderTest.setHalt(on);
		systemUnderTest.setClock(on);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getClockBar());
	}

	@Test
	public void testGetClockBar_shouldReturnTrue_whenResetIsOnandClockInputIsOn() {
		systemUnderTest.setReset(on);
		systemUnderTest.setClock(on);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getClockBar());
	}

	@Test
	public void testGetClockBar_shouldReturnTrue_whenResetsOnandClockInputIsOff() {
		systemUnderTest.setReset(on);
		systemUnderTest.setClock(off);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getClockBar());
	}

	@Test
	public void testGetExecute_shouldReturnTrue_whenResetIsOffAfterFourClockCycles() {
		systemUnderTest.setReset(off);
		performOneClockCycle();
		performOneClockCycle();
		performOneClockCycle();
		performOneClockCycle();
		assertTrue(systemUnderTest.getExecute());
	}

	@Test
	public void testGetExecute_shouldReturnTrue_whenResetsOn() {
		systemUnderTest.setReset(on);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getExecute());
	}

	@Test
	public void testGetFetchAddressHigh_shouldReturnFalse_whenResetsOn() {
		systemUnderTest.setReset(on);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getFetchAddressHigh());
	}

	@Test
	public void testGetFetchAddressHigh_shouldReturnTrue_whenResetIsOffAfterTwoClockCycles() {
		systemUnderTest.setReset(off);
		performOneClockCycle();
		performOneClockCycle();
		assertTrue(systemUnderTest.getFetchAddressHigh());
	}

	@Test
	public void testGetFetchAddressLow_shouldReturnFalse_whenResetsOn() {
		systemUnderTest.setReset(on);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getFetchAddressLow());
	}

	@Test
	public void testGetFetchAddressLow_shouldReturnTrue_whenResetIsOffAfterThreeClockCycles() {
		systemUnderTest.setReset(off);
		performOneClockCycle();
		performOneClockCycle();
		performOneClockCycle();
		assertTrue(systemUnderTest.getFetchAddressLow());
	}

	@Test
	public void testGetFetchCode_shouldReturnFalse_whenResetsOn() {
		systemUnderTest.setReset(on);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getFetchCode());
	}

	@Test
	public void testGetFetchCode_shouldReturnTrue_whenResetIsOffAfterOneClockCycle() {
		systemUnderTest.setReset(off);
		performOneClockCycle();
		assertTrue(systemUnderTest.getFetchCode());
	}

	@Test
	public void testInstructionTimer_shouldNotAdvanceToFetchAddressHigh_AfterOneClockCycleWithHaltOn() {
		systemUnderTest.setReset(off);
		performOneClockCycle();
		systemUnderTest.setHalt(on);
		performOneClockCycle();
		assertFalse(systemUnderTest.getFetchAddressHigh());
	}

	private void performOneClockCycle() {
		systemUnderTest.setClock(on);
		systemUnderTest.step();

		systemUnderTest.setClock(off);
		systemUnderTest.step();
	}
}

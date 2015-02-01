/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Model.Tests;

import static electroMechanicalLogic.Tests.TestConstants.off;
import static electroMechanicalLogic.Tests.TestConstants.on;
import static electroMechanicalLogic.Tests.TestUtilities.getAddress;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalMachine.Model.MarkIXTimingControl;
import electroMechanicalMachine.Model.Interfaces.IMarkIXTimingControl;

public class TestMarkIXTimingControl {
	private IMarkIXTimingControl systemUnderTest;

	@Before
	public void setUp() {
		systemUnderTest = new MarkIXTimingControl();
		systemUnderTest.setPower(on);
		systemUnderTest.setClear(on);
		systemUnderTest.step();
	}

	@Test
	public void testAddress_shouldBeFour_afterFiveClockCycles() {
		systemUnderTest.setClear(off);
		performOneClockCycle();
		performOneClockCycle();
		performOneClockCycle();
		performOneClockCycle();
		performOneClockCycle();
		assertEquals(4, getAddress(systemUnderTest));
	}

	@Test
	public void testAddress_shouldBeOne_afterOneClockCycle() {
		systemUnderTest.setClear(off);
		performOneClockCycle();
		assertEquals(1, getAddress(systemUnderTest));
	}

	@Test
	public void testAddress_shouldBeThree_afterFourClockCycles() {
		systemUnderTest.setClear(off);
		performOneClockCycle();
		performOneClockCycle();
		performOneClockCycle();
		performOneClockCycle();
		assertEquals(3, getAddress(systemUnderTest));
	}

	@Test
	public void testAddress_shouldBeThree_afterThreeClockCycles() {
		systemUnderTest.setClear(off);
		performOneClockCycle();
		performOneClockCycle();
		performOneClockCycle();
		assertEquals(3, getAddress(systemUnderTest));
	}

	@Test
	public void testAddress_shouldBeTwo_afterTwoClockCycles() {
		systemUnderTest.setClear(off);
		performOneClockCycle();
		performOneClockCycle();
		assertEquals(2, getAddress(systemUnderTest));
	}

	@Test
	public void testAddress_shouldBeZero_whenClearIsOn() {
		systemUnderTest.setClear(off);
		performOneClockCycle();
		performOneClockCycle();
		performOneClockCycle();
		systemUnderTest.setClear(on);
		performOneClockCycle();
		assertEquals(0, getAddress(systemUnderTest));
	}

	@Test
	public void testAddress_shouldNotAdvance_whenHaltIsOn() {
		systemUnderTest.setClear(off);
		performOneClockCycle();
		systemUnderTest.setHalt(on);
		performOneClockCycle();
		assertEquals(1, getAddress(systemUnderTest));
	}

	@Test
	public void testGetCodeFetch_shouldReturnFalse_afterFourClockCycles() {
		systemUnderTest.setClear(off);
		performOneClockCycle();
		performOneClockCycle();
		performOneClockCycle();
		performOneClockCycle();
		assertFalse(systemUnderTest.getFetchCode());
	}

	@Test
	public void testGetCodeFetch_shouldReturnFalse_afterThreeClockCycles() {
		systemUnderTest.setClear(off);
		performOneClockCycle();
		performOneClockCycle();
		performOneClockCycle();
		assertFalse(systemUnderTest.getFetchCode());
	}

	@Test
	public void testGetCodeFetch_shouldReturnFalse_afterTwoClockCycles() {
		systemUnderTest.setClear(off);
		performOneClockCycle();
		performOneClockCycle();
		assertFalse(systemUnderTest.getFetchCode());
	}

	@Test
	public void testGetCodeFetch_shouldReturnTrue_afterOneClockCycle() {
		systemUnderTest.setClear(off);
		performOneClockCycle();
		assertTrue(systemUnderTest.getFetchCode());
	}

	@Test
	public void testGetExecute_shouldReturnFalse_afterOneClockCycle() {
		systemUnderTest.setClear(off);
		performOneClockCycle();
		assertFalse(systemUnderTest.getExecute());
	}

	@Test
	public void testGetExecute_shouldReturnFalse_afterThreeClockCycles() {
		systemUnderTest.setClear(off);
		performOneClockCycle();
		performOneClockCycle();
		performOneClockCycle();
		assertFalse(systemUnderTest.getExecute());
	}

	@Test
	public void testGetExecute_shouldReturnFalse_afterTwoClockCycles() {
		systemUnderTest.setClear(off);
		performOneClockCycle();
		performOneClockCycle();
		assertFalse(systemUnderTest.getExecute());
	}

	@Test
	public void testGetExecute_shouldReturnTrue_afterFourClockCycles() {
		systemUnderTest.setClear(off);
		performOneClockCycle();
		performOneClockCycle();
		performOneClockCycle();
		performOneClockCycle();
		assertTrue(systemUnderTest.getExecute());
	}

	@Test
	public void testGetFetchHighAddress_shouldReturnFalse_afterFourlockCycle() {
		systemUnderTest.setClear(off);
		performOneClockCycle();
		performOneClockCycle();
		performOneClockCycle();
		performOneClockCycle();
		assertFalse(systemUnderTest.getFetchHighAddress());
	}

	@Test
	public void testGetFetchHighAddress_shouldReturnFalse_afterOneClockCycle() {
		systemUnderTest.setClear(off);
		performOneClockCycle();
		assertFalse(systemUnderTest.getFetchHighAddress());
	}

	@Test
	public void testGetFetchHighAddress_shouldReturnFalse_afterThreeClockCycle() {
		systemUnderTest.setClear(off);
		performOneClockCycle();
		performOneClockCycle();
		performOneClockCycle();
		assertFalse(systemUnderTest.getFetchHighAddress());
	}

	@Test
	public void testGetFetchHighAddress_shouldReturnTrue_afterTwoClockCycles() {
		systemUnderTest.setClear(off);
		performOneClockCycle();
		performOneClockCycle();
		assertTrue(systemUnderTest.getFetchHighAddress());
	}

	@Test
	public void testGetFetchLowAddress_shouldReturnFalse_afterFourClockCycles() {
		systemUnderTest.setClear(off);
		performOneClockCycle();
		performOneClockCycle();
		performOneClockCycle();
		performOneClockCycle();
		assertFalse(systemUnderTest.getFetchLowAddress());
	}

	@Test
	public void testGetFetchLowAddress_shouldReturnFalse_afterOneClockCycle() {
		systemUnderTest.setClear(off);
		performOneClockCycle();
		assertFalse(systemUnderTest.getFetchLowAddress());
	}

	@Test
	public void testGetFetchLowAddress_shouldReturnFalse_afterTwoClockCycles() {
		systemUnderTest.setClear(off);
		performOneClockCycle();
		performOneClockCycle();
		assertFalse(systemUnderTest.getFetchLowAddress());
	}

	@Test
	public void testGetFetchLowAddress_shouldReturnTrue_afterThreeClockCycles() {
		systemUnderTest.setClear(off);
		performOneClockCycle();
		performOneClockCycle();
		performOneClockCycle();
		assertTrue(systemUnderTest.getFetchLowAddress());
	}

	@Test
	public void testGetWrite_shouldReturnFalse_afterFiveClockCyclesAndStoreIsOn() {
		systemUnderTest.setClear(off);
		systemUnderTest.setStore(on);
		performOneClockCycle();
		performOneClockCycle();
		performOneClockCycle();
		performOneClockCycle();
		performOneClockCycle();
		assertFalse(systemUnderTest.getWrite());
	}

	@Test
	public void testGetWrite_shouldReturnFalse_afterThreeClockCyclesAndStoreIsOn() {
		systemUnderTest.setClear(off);
		systemUnderTest.setStore(on);
		performOneClockCycle();
		performOneClockCycle();
		performOneClockCycle();
		assertFalse(systemUnderTest.getWrite());
	}

	@Test
	public void testGetWrite_shouldReturnTrue_afterFourClockCyclesAndStoreIsOn() {
		systemUnderTest.setClear(off);
		systemUnderTest.setStore(on);
		performOneClockCycle();
		performOneClockCycle();
		performOneClockCycle();
		performOneClockCycle();
		assertTrue(systemUnderTest.getWrite());
	}

	@Test
	public void testInstructionCycle_shouldBeExecute_whenClearIsOn() {
		systemUnderTest.setClear(off);
		performOneClockCycle();
		systemUnderTest.setClear(on);
		performOneClockCycle();
		assertTrue(systemUnderTest.getExecute());
	}

	@Test
	public void testInstructionCycle_shouldNotAdvance_whenHaltIsOn() {
		systemUnderTest.setClear(off);
		performOneClockCycle();
		systemUnderTest.setHalt(on);
		performOneClockCycle();
		assertTrue(systemUnderTest.getFetchCode());
	}

	private void performOneClockCycle() {
		systemUnderTest.setClock(true);
		systemUnderTest.step();
		systemUnderTest.setClock(false);
		systemUnderTest.step();
	}
}

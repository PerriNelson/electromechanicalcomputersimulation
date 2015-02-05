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

import electroMechanicalMachine.Processor.BasicFlagControl;
import electroMechanicalMachine.Processor.Interfaces.IFlagControl;

public class TestBasicFlagControl {
	private IFlagControl systemUnderTest;

	@Before
	public void setUp() {
		systemUnderTest = new BasicFlagControl();
		systemUnderTest.setPower(on);
	}

	@Test
	public void testGetLatchFlags_shouldReturnFalse_whenAddIsOnAndExecuteIsOff() {
		systemUnderTest.setAdd(on);
		systemUnderTest.setExecute(off);
		performOneClockCycle();

		assertFalse(systemUnderTest.getLatchFlags());
	}

	@Test
	public void testGetLatchFlags_shouldReturnTrue_whenAddIsOnAndExecuteIsOn() {
		systemUnderTest.setAdd(on);
		systemUnderTest.setExecute(on);
		performOneClockCycle();

		assertTrue(systemUnderTest.getLatchFlags());
	}

	@Test
	public void testGetLatchFlags_shouldReturnFalse_whenAddWithCarryIsOnAndExecuteIsOff() {
		systemUnderTest.setAddWithCarry(on);
		systemUnderTest.setExecute(off);
		performOneClockCycle();

		assertFalse(systemUnderTest.getLatchFlags());
	}

	@Test
	public void testGetLatchFlags_shouldReturnTrue_whenAddWithCarryIsOnAndExecuteIsOn() {
		systemUnderTest.setAddWithCarry(on);
		systemUnderTest.setExecute(on);
		performOneClockCycle();

		assertTrue(systemUnderTest.getLatchFlags());
	}

	@Test
	public void testGetLatchFlags_shouldReturnFalse_whenSubtractIsOnAndExecuteIsOff() {
		systemUnderTest.setSubtract(on);
		systemUnderTest.setExecute(off);
		performOneClockCycle();

		assertFalse(systemUnderTest.getLatchFlags());
	}

	@Test
	public void testGetLatchFlags_shouldReturnTrue_whenSubtractIsOnAndExecuteIsOn() {
		systemUnderTest.setSubtract(on);
		systemUnderTest.setExecute(on);
		performOneClockCycle();

		assertTrue(systemUnderTest.getLatchFlags());
	}

	@Test
	public void testGetLatchFlags_shouldReturnFalse_whenSubtractWithBorrowIsOnAndExecuteIsOff() {
		systemUnderTest.setSubtractWithBorrow(on);
		systemUnderTest.setExecute(off);
		performOneClockCycle();

		assertFalse(systemUnderTest.getLatchFlags());
	}

	@Test
	public void testGetLatchFlags_shouldReturnTrue_whenSubtractWithBorrowIsOnAndExecuteIsOn() {
		systemUnderTest.setSubtractWithBorrow(on);
		systemUnderTest.setExecute(on);
		performOneClockCycle();

		assertTrue(systemUnderTest.getLatchFlags());
	}

	private void performOneClockCycle() {
		systemUnderTest.setClockBar(off);
		systemUnderTest.step();

		systemUnderTest.setClockBar(on);
		systemUnderTest.step();
	}
}

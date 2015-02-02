/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Model.Tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalMachine.Model.CarryControl;
import electroMechanicalMachine.Model.Interfaces.ICarryControl;

public class TestCarryControl {
	private ICarryControl systemUnderTest;

	@Before
	public void setUp() {
		systemUnderTest = new CarryControl();
		systemUnderTest.setPower(true);
	}

	@Test
	public void testGetCarryIn_shouldReturnFalse_whenAddIsTrueAndCarryOutIsTrue() {
		systemUnderTest.setAdd(true);
		systemUnderTest.setCarryOut(true);

		performOneClockCycle();

		assertFalse(systemUnderTest.getCarryIn());
	}

	@Test
	public void testGetCarryIn_shouldReturnFalse_whenPreviousOperationResultedInACarryAndAddIsTrue() {
		systemUnderTest.setSubtract(true);
		systemUnderTest.setCarryOut(true);

		performOneClockCycle();
		systemUnderTest.setSubtract(false);
		systemUnderTest.setCarryOut(false);
		systemUnderTest.setAdd(true);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getCarryIn());
	}

	@Test
	public void testGetCarryIn_shouldReturnTrue_whenAddWithCarryIsTrueAndCarryOutIsTrue() {
		systemUnderTest.setAddWithCarry(true);
		systemUnderTest.setCarryOut(true);

		performOneClockCycle();

		systemUnderTest.setCarryOut(false);
		performOneClockCycle();

		assertTrue(systemUnderTest.getCarryIn());
	}

	@Test
	public void testGetCarryIn_shouldReturnTrue_whenPreviousOperationResultedInACarryAndAddWithCarryIsTrue() {
		systemUnderTest.setAdd(true);
		systemUnderTest.setCarryOut(true);

		performOneClockCycle();
		systemUnderTest.setAdd(false);
		systemUnderTest.setCarryOut(false);
		systemUnderTest.setAddWithCarry(true);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getCarryIn());
	}

	@Test
	public void testGetCarryIn_shouldReturnTrue_whenPreviousOperationResultedInACarryAndSubtractWithBorrowIsTrue() {
		systemUnderTest.setAdd(true);
		systemUnderTest.setCarryOut(true);

		performOneClockCycle();
		systemUnderTest.setAdd(false);
		systemUnderTest.setCarryOut(false);
		systemUnderTest.setSubtractWithBorrow(true);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getCarryIn());
	}

	@Test
	public void testGetCarryIn_shouldReturnTrue_whenSubractWithBorrowIsTrueAndCarryOutIsTrue() {
		systemUnderTest.setSubtractWithBorrow(true);
		systemUnderTest.setCarryOut(true);

		performOneClockCycle();

		systemUnderTest.setCarryOut(false);
		performOneClockCycle();

		assertTrue(systemUnderTest.getCarryIn());
	}

	@Test
	public void testGetCarryIn_shouldReturnTrue_whenSubtractIsTrue() {
		systemUnderTest.setSubtract(true);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getCarryIn());
	}

	private void performOneClockCycle() {
		systemUnderTest.setClock(false);
		systemUnderTest.step();

		systemUnderTest.setClock(true);
		systemUnderTest.step();
	}
}

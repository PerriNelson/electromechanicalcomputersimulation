/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Processor.Tests;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalMachine.Processor.CarryControl;
import electroMechanicalMachine.Processor.Interfaces.ICarryControl;

public class TestCarryControl {
	private ICarryControl systemUnderTest;

	@Before
	public void setUp() {
		systemUnderTest = new CarryControl();
		systemUnderTest.setPower(true);
	}

	@Test
	public void testGetCarryIn_shouldReturnTrue_whenAddWithCarryIsTrueAndCarryFlagIsTrue() {
		systemUnderTest.setAddWithCarry(true);
		systemUnderTest.setCarryFlag(true);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getCarryIn());
	}

	@Test
	public void testGetCarryIn_shouldReturnTrue_whenPreviousOperationResultedInACarryAndAddWithCarryIsTrue() {
		systemUnderTest.step();
		systemUnderTest.setCarryFlag(true);
		systemUnderTest.setAddWithCarry(true);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getCarryIn());
	}

	@Test
	public void testGetCarryIn_shouldReturnTrue_whenPreviousOperationResultedInACarryAndSubtractWithBorrowIsTrue() {
		systemUnderTest.step();
		systemUnderTest.setCarryFlag(true);
		systemUnderTest.setSubtractWithBorrow(true);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getCarryIn());
	}

	@Test
	public void testGetCarryIn_shouldReturnTrue_whenSubractWithBorrowIsTrueAndCarryFlagIsTrue() {
		systemUnderTest.setSubtractWithBorrow(true);
		systemUnderTest.setCarryFlag(true);

		systemUnderTest.step();

		assertTrue(systemUnderTest.getCarryIn());
	}

	@Test
	public void testGetCarryIn_shouldReturnTrue_whenSubtractIsTrue() {
		systemUnderTest.setSubtract(true);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getCarryIn());
	}
}

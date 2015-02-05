/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Processor.Tests;

import static electroMechanicalLogic.Tests.TestConstants.on;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalMachine.Processor.JumpControl;
import electroMechanicalMachine.Processor.Interfaces.IJumpControl;

public class TestJumpControl {

	private IJumpControl systemUnderTest;

	@Before
	public void setUp() {
		systemUnderTest = new JumpControl();
		systemUnderTest.setPower(on);
	}

	@Test
	public void testGetJump_shouldReturnFalse_forJump_whenAddressHasBeenLatchedIsOff() {
		systemUnderTest.setJump(on);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getJump());
	}

	@Test
	public void testGetJump_shouldReturnFalse_forJumpIfCarry_whenCarryFlagIsOffAndAddressHasBeenLatchedIsOff() {
		systemUnderTest.setJumpIfCarry(on);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getJump());
	}

	@Test
	public void testGetJump_shouldReturnFalse_forJumpIfCarry_WhenCarryFlagIsOffAndAddressHasBeenLatchedIsOn() {
		systemUnderTest.setJumpIfCarry(on);
		systemUnderTest.setAddressHasBeenLatched(on);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getJump());
	}

	@Test
	public void testGetJump_shouldReturnFalse_forJumpIfCarry_whenCarryFlagIsOnAndAddressHasBeenLatchedIsOff() {
		systemUnderTest.setJumpIfCarry(on);
		systemUnderTest.setCarryFlag(on);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getJump());
	}

	@Test
	public void testGetJump_shouldReturnFalse_forJumpIfNotCarry_whenCarryFlagIsOffAndAddressHasBeenLatchedIsOn() {
		systemUnderTest.setJumpIfNotCarry(on);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getJump());
	}

	@Test
	public void testGetJump_shouldReturnFalse_forJumpIfNotCarry_whenCarryFlagIsOnAndAddressHasBeenLatchedIsOff() {
		systemUnderTest.setJumpIfNotCarry(on);
		systemUnderTest.setCarryFlag(on);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getJump());
	}

	@Test
	public void testGetJump_shouldReturnFalse_forJumpIfNotCarry_whenCarryFlagIsOnAndAddressHasBeenLatchedIsOn() {
		systemUnderTest.setJumpIfNotCarry(on);
		systemUnderTest.setCarryFlag(on);
		systemUnderTest.setAddressHasBeenLatched(on);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getJump());
	}

	@Test
	public void testGetJump_shouldReturnFalse_forJumpIfNotZero_whenZeroFlagIsOffAndAddressHasBeenLatchedIsOff() {
		systemUnderTest.setJumpIfNotZero(on);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getJump());
	}

	@Test
	public void testGetJump_shouldReturnFalse_forJumpIfNotZero_whenZeroFlagIsOnAndAddressHasBeenLatchedIsOff() {
		systemUnderTest.setJumpIfNotZero(on);
		systemUnderTest.setZeroFlag(on);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getJump());
	}

	@Test
	public void testGetJump_shouldReturnFalse_forJumpIfNotZero_whenZeroFlagIsOnAndAddressHasBeenLatchedIsOn() {
		systemUnderTest.setJumpIfNotZero(on);
		systemUnderTest.setZeroFlag(on);
		systemUnderTest.setAddressHasBeenLatched(on);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getJump());
	}

	@Test
	public void testGetJump_shouldReturnFalse_forJumpIfZero_whenZeroFlagIsOffAndAddressHasBeenLatchedIsOff() {
		systemUnderTest.setJumpIfZero(on);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getJump());
	}

	@Test
	public void testGetJump_shouldReturnFalse_forJumpIfZero_whenZeroFlagIsOffAndAddressHasBeenLatchedIsOn() {
		systemUnderTest.setJumpIfZero(on);
		systemUnderTest.setAddressHasBeenLatched(on);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getJump());
	}

	@Test
	public void testGetJump_shouldReturnFalse_forJumpIfZero_whenZeroFlagIsOnAndAddressHasBeenLatchedIsOff() {
		systemUnderTest.setJumpIfZero(on);
		systemUnderTest.setZeroFlag(on);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getJump());
	}

	@Test
	public void testGetJump_shouldReturnTrue_forJump_whenAddressHasBeenLatchedIsOn() {
		systemUnderTest.setJump(on);
		systemUnderTest.setAddressHasBeenLatched(on);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getJump());
	}

	@Test
	public void testGetJump_shouldReturnTrue_forJumpIfCarry_whenCarryFlagIsOnAndAddressHasBeenLatchedIsOn() {
		systemUnderTest.setJumpIfCarry(on);
		systemUnderTest.setCarryFlag(on);
		systemUnderTest.setAddressHasBeenLatched(on);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getJump());
	}

	@Test
	public void testGetJump_shouldReturnTrue_forJumpIfNotCarry_whenCarryFlagIsOffAndAddressHasBeenLatchedIsOn() {
		systemUnderTest.setJumpIfNotCarry(on);
		systemUnderTest.setAddressHasBeenLatched(on);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getJump());
	}

	@Test
	public void testGetJump_shouldReturnTrue_forJumpIfNotZero_whenZeroFlagIsOffAndAddressHasBeenLatchedIsOn() {
		systemUnderTest.setJumpIfNotZero(on);
		systemUnderTest.setAddressHasBeenLatched(on);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getJump());
	}

	@Test
	public void testGetJump_shouldReturnTrue_forJumpIfZero_whenZeroFlagIsOnAndddressHasBeenLatchedIsOn() {
		systemUnderTest.setJumpIfZero(on);
		systemUnderTest.setZeroFlag(on);
		systemUnderTest.setAddressHasBeenLatched(on);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getJump());
	}
}

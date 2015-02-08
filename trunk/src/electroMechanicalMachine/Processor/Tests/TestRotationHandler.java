/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Processor.Tests;

import static electroMechanicalLogic.Tests.TestUtilities.getDataOut;
import static electroMechanicalLogic.Tests.TestUtilities.setDataIn;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalMachine.Processor.RotationHandler;
import electroMechanicalMachine.Processor.Interfaces.IRotationHandler;

public class TestRotationHandler {
	private IRotationHandler systemUnderTest;

	@Before
	public void setUp() {
		systemUnderTest = new RotationHandler();
		systemUnderTest.setPower(true);
	}

	@Test
	public void testIsRotationOperation_shouldReturnFalse_whenNoRotationOperationIsOn() {
		systemUnderTest.step();
		assertFalse(systemUnderTest.getIsRotationOperation());
	}

	@Test
	public void testIsRotationOperation_shouldReturnTrue_whenRotateLeftIsOn() {
		systemUnderTest.setRotateLeft(true);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getIsRotationOperation());
	}

	@Test
	public void testIsRotationOperation_shouldReturnTrue_whenRotateLeftThroughCarryIsOn() {
		systemUnderTest.setRotateLeftThroughCarry(true);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getIsRotationOperation());
	}

	@Test
	public void testIsRotationOperation_shouldReturnTrue_whenRotateRightIsOn() {
		systemUnderTest.setRotateRight(true);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getIsRotationOperation());
	}

	@Test
	public void testIsRotationOperation_shouldReturnTrue_whenRotateRIghtThroughCarryIsOn() {
		systemUnderTest.setRotateRightThroughCarry(true);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getIsRotationOperation());
	}

	@Test
	public void testRotateLeft_shouldReturnExpectedCarry_forAllInputs() {
		systemUnderTest.setRotateLeft(true);
		for (int input = 0; input < 256; input++) {
			final boolean expected = (input & 0x80) == 0x80;
			setDataIn(systemUnderTest, input);
			systemUnderTest.step();
			final boolean actual = systemUnderTest.getCarryOut();

			assertEquals(expected, actual);
		}
	}

	@Test
	public void testRotateLeft_shouldReturnRotatedInput_forAllInputs() {
		systemUnderTest.setRotateLeft(true);
		for (int input = 0; input < 256; input++) {
			final int expected = ((input << 1) | ((input & 0x80) == 0x80 ? 1
					: 0)) & 0xff;
			setDataIn(systemUnderTest, input);
			systemUnderTest.step();
			final int actual = getDataOut(systemUnderTest);

			assertEquals(expected, actual);
		}
	}

	@Test
	public void testRotateLeftThroughCarry_shouldReturnExpectedCarry_forAllInputs() {
		systemUnderTest.setRotateLeftThroughCarry(true);
		for (int input = 0; input < 256; input++) {
			final boolean expected = (input & 0x80) == 0x80;
			setDataIn(systemUnderTest, input);
			systemUnderTest.step();
			final boolean actual = systemUnderTest.getCarryOut();

			assertEquals(expected, actual);
		}
	}

	@Test
	public void testRotateLeftThroughCarry_shouldReturnRotatedInput_forAllInputs() {
		systemUnderTest.setRotateLeftThroughCarry(true);
		for (int carryin = 0; carryin < 2; carryin++) {
			for (int input = 0; input < 256; input++) {
				final int expected = ((input << 1) | (carryin == 1 ? 1 : 0)) & 0xff;
				setDataIn(systemUnderTest, input);
				systemUnderTest.setCarryIn(carryin == 1);
				systemUnderTest.step();
				final int actual = getDataOut(systemUnderTest);

				assertEquals(expected, actual);
			}
		}
	}

	@Test
	public void testRotateRight_shouldReturnExpectedCarry_forAllInputs() {
		systemUnderTest.setRotateRight(true);
		for (int input = 0; input < 256; input++) {
			final boolean expected = (input & 0x01) == 0x01;
			setDataIn(systemUnderTest, input);
			systemUnderTest.step();
			final boolean actual = systemUnderTest.getCarryOut();

			assertEquals(expected, actual);
		}
	}

	@Test
	public void testRotateRight_shouldReturnRotatedInput_forAllInputs() {
		systemUnderTest.setRotateRight(true);
		for (int input = 0; input < 256; input++) {
			final int expected = ((input >> 1) | ((input & 0x01) == 0x01 ? 0x80
					: 0)) & 0xff;
			setDataIn(systemUnderTest, input);
			systemUnderTest.step();
			final int actual = getDataOut(systemUnderTest);

			assertEquals(expected, actual);
		}
	}

	@Test
	public void testRotateRightThroughCarry_shouldReturnExpectedCarry_forAllInputs() {
		systemUnderTest.setRotateRightThroughCarry(true);
		for (int input = 0; input < 256; input++) {
			final boolean expected = (input & 0x01) == 0x01;
			setDataIn(systemUnderTest, input);
			systemUnderTest.step();
			final boolean actual = systemUnderTest.getCarryOut();

			assertEquals(expected, actual);
		}
	}

	@Test
	public void testRotateRightThroughCarry_shouldReturnRotatedInput_forAllInputs() {
		systemUnderTest.setRotateRightThroughCarry(true);
		for (int carryin = 0; carryin < 2; carryin++) {
			for (int input = 0; input < 256; input++) {
				final int expected = ((input >> 1) | (carryin == 1 ? 0x80 : 0)) & 0xff;
				setDataIn(systemUnderTest, input);
				systemUnderTest.setCarryIn(carryin == 1);
				systemUnderTest.step();
				final int actual = getDataOut(systemUnderTest);

				assertEquals(expected, actual);
			}
		}
	}

}

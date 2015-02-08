/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Processor.Tests;

import static electroMechanicalLogic.Tests.TestConstants.on;
import static electroMechanicalLogic.Tests.TestUtilities.getDataOut;
import static electroMechanicalLogic.Tests.TestUtilities.setAIn;
import static electroMechanicalLogic.Tests.TestUtilities.setBIn;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalMachine.Processor.BasicArithmeticHandler;
import electroMechanicalMachine.Processor.Interfaces.IBasicArithmeticHandler;

public class TestBasicArithmeticHandler {

	private IBasicArithmeticHandler systemUnderTest;

	@Before
	public void setUp() {
		systemUnderTest = new BasicArithmeticHandler();
		systemUnderTest.setPower(true);
	}

	@Test
	public void testBasicALU_shouldReturnCorrectEightBitResults_whenAddWithCarryForAllABAndCarryInputs() {
		for (int b = 0; b < 256; b++) {
			for (int a = 0; a < 256; a++) {
				for (int cf = 0; cf < 2; cf++) {
					systemUnderTest.setCarryIn(cf == 1);
					systemUnderTest.setAddWithCarry(on);
					setBIn(systemUnderTest, b);
					setAIn(systemUnderTest, a);

					systemUnderTest.step();

					assertEquals(
							String.format("a = %d, b = %d, cf = %d", a, b, cf),
							eightBitAdd(a, b, cf == 1),
							getDataOut(systemUnderTest));
				}
			}
		}
	}

	@Test
	public void testBasicALU_shouldReturnCorrectEightBitResults_whenSubractingForAllAAndBInputs() {
		for (int b = 0; b < 256; b++) {
			for (int a = 0; a < 256; a++) {
				systemUnderTest.setSubtract(on);
				setAIn(systemUnderTest, a);
				setBIn(systemUnderTest, b);

				systemUnderTest.step();

				assertEquals(String.format("a = %d, b = %d", a, b),
						eightBitSubtract(a, b, false),
						getDataOut(systemUnderTest));
			}
		}
	}

	@Test
	public void testBasicALU_shouldReturnCorrectEightBitResults_whenSubtractWithBorrowForAllABAndCarryInputs() {
		for (int b = 0; b < 256; b++) {
			for (int a = 0; a < 256; a++) {
				for (int cf = 0; cf < 2; cf++) {
					final boolean borrow = cf == 0;
					systemUnderTest.setCarryIn(!borrow);
					systemUnderTest.setSubtractWithBorrow(on);
					setBIn(systemUnderTest, b);
					setAIn(systemUnderTest, a);

					systemUnderTest.step();

					assertEquals(
							String.format("a = %d, b = %d, cf = %d", a, b, cf),
							eightBitSubtract(a, b, borrow),
							getDataOut(systemUnderTest));
				}
			}
		}
	}

	@Test
	public void testGetIsArithmeticOperation_shouldReturnFalse_whenNoArithmeticOperationIsSet() {
		systemUnderTest.step();
		assertFalse(systemUnderTest.getIsArithmeticOperation());
	}

	@Test
	public void testGetIsArithmeticOperation_shouldReturnTrue_whenAddIsSet() {
		systemUnderTest.setAdd(true);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getIsArithmeticOperation());
	}

	@Test
	public void testGetIsArithmeticOperation_shouldReturnTrue_whenAddWithCarryIsSet() {
		systemUnderTest.setAddWithCarry(true);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getIsArithmeticOperation());
	}

	@Test
	public void testGetIsArithmeticOperation_shouldReturnTrue_whenSubtractIsSet() {
		systemUnderTest.setSubtract(true);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getIsArithmeticOperation());
	}

	@Test
	public void testGetIsArithmeticOperation_shouldReturnTrue_whenSubtractWithBorrowIsSet() {
		systemUnderTest.setSubtractWithBorrow(true);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getIsArithmeticOperation());
	}

	@Test
	public void testHandler_shouldReturnCorrectEightBitResults_whenAddingForAllAAndBInputs() {
		for (int b = 0; b < 256; b++) {
			for (int a = 0; a < 256; a++) {
				systemUnderTest.setAdd(on);
				setAIn(systemUnderTest, a);
				setBIn(systemUnderTest, b);

				systemUnderTest.step();

				assertEquals(String.format("a = %d, b = %d", a, b),
						eightBitAdd(a, b, false), getDataOut(systemUnderTest));
			}
		}
	}

	private int eightBitAdd(final int a, final int b, final boolean carryIn) {
		return (((a + b) + (carryIn ? 1 : 0)) & 0xff);
	}

	private int eightBitSubtract(final int minuend, final int subtrahend,
			final boolean borrow) {
		final int b = subtrahend;
		final int a = (~minuend) & 0xff;
		final int ci = borrow ? 0 : 1;

		return (((a + b) & 0xff) + ci) & 0xff;
	}

}

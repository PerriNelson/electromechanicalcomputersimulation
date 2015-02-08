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
import static electroMechanicalLogic.Tests.TestUtilities.getDataOut;
import static electroMechanicalLogic.Tests.TestUtilities.setAIn;
import static electroMechanicalLogic.Tests.TestUtilities.setBIn;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalMachine.Processor.MarkXALU;
import electroMechanicalMachine.Processor.Interfaces.IMarkXALU;

public class TestMarkXALU {
	protected IMarkXALU systemUnderTest;

	@Before
	public void setUp() {
		setALU();
		systemUnderTest.setPower(on);
	}

	@Test
	public void testMarkXALU_shouldReturnCorrectEightBitResults_whenAddingForAllAAndBInputs() {
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

	@Test
	public void testMarkXALU_shouldReturnCorrectEightBitResults_whenAddWithCarryForAllABAndCarryInputs() {
		for (int b = 0; b < 256; b++) {
			for (int a = 0; a < 256; a++) {
				for (int cf = 0; cf < 2; cf++) {
					setCarryFlag(cf == 1);
					systemUnderTest.setAddWithCarry(on);
					setBIn(systemUnderTest, b);
					setAIn(systemUnderTest, a);

					performOneExecutionCycle();

					assertEquals(
							String.format("a = %d, b = %d, cf = %d", a, b, cf),
							eightBitAdd(a, b, cf == 1),
							getDataOut(systemUnderTest));
				}
			}
		}
	}

	@Test
	public void testMarkXALU_shouldReturnCorrectEightBitResults_whenSubractingForAllAAndBInputs() {
		for (int b = 0; b < 256; b++) {
			for (int a = 0; a < 256; a++) {
				systemUnderTest.setSubtract(on);
				setAIn(systemUnderTest, a);
				setBIn(systemUnderTest, b);

				performOneExecutionCycle();

				assertEquals(String.format("a = %d, b = %d", a, b),
						eightBitSubtract(a, b, false),
						getDataOut(systemUnderTest));
			}
		}
	}

	@Test
	public void testMarkXALU_shouldReturnCorrectEightBitResults_whenSubtractWithBorrowForAllABAndCarryInputs() {
		for (int b = 0; b < 256; b++) {
			for (int a = 0; a < 256; a++) {
				for (int cf = 0; cf < 2; cf++) {
					final boolean borrow = cf == 0;
					setCarryFlag(!borrow);
					systemUnderTest.setSubtractWithBorrow(on);
					setBIn(systemUnderTest, b);
					setAIn(systemUnderTest, a);

					performOneExecutionCycle();

					assertEquals(
							String.format("a = %d, b = %d, cf = %d", a, b, cf),
							eightBitSubtract(a, b, borrow),
							getDataOut(systemUnderTest));
				}
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

	private void setCarryFlag(final boolean value) {
		setAIn(systemUnderTest, 0xff);
		setBIn(systemUnderTest, value ? 0x01 : 0x00);
		systemUnderTest.setAdd(on);
		systemUnderTest.setSubtract(off);
		systemUnderTest.setAddWithCarry(off);
		systemUnderTest.setSubtractWithBorrow(off);

		performOneExecutionCycle();

		systemUnderTest.setAdd(off);
	}

	protected void performOneExecutionCycle() {
		systemUnderTest.setExecute(off);
		systemUnderTest.step();

		systemUnderTest.setExecute(on);
		systemUnderTest.step();
	}

	protected void setALU() {
		setALU(new MarkXALU());
	}

	protected final void setALU(final IMarkXALU alu) {
		systemUnderTest = alu;
	}
}

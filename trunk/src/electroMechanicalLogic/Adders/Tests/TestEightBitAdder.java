/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */
package electroMechanicalLogic.Adders.Tests;

import static electroMechanicalLogic.Tests.TestConstants.bit8;
import static electroMechanicalLogic.Tests.TestUtilities.getSum;
import static electroMechanicalLogic.Tests.TestUtilities.setAIn;
import static electroMechanicalLogic.Tests.TestUtilities.setBIn;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalLogic.Adders.EightBitAdder;
import electroMechanicalLogic.Adders.Interfaces.IEightBitAdder;

public class TestEightBitAdder {

	private IEightBitAdder systemUnderTest;

	@Before
	public void setUp() throws Exception {
		systemUnderTest = new EightBitAdder();
	}

	@Test
	public void testEightBitAdder_shouldPerformAdditionCorrectly_forAllAAndBInputs_whenCIIsOffAndPowerIsOn() {
		systemUnderTest.setPower(true);
		for (int a = 0; a < 256; a++) {
			for (int b = 0; b < 256; b++) {
				setAIn(systemUnderTest, a);
				setBIn(systemUnderTest, b);
				systemUnderTest.step();

				assertEquals(a + b, getSumWithCarry());
			}
		}
	}

	@Test
	public void testEightBitAdder_shouldPerformAdditionCorrectly_forAllAAndBInputs_whenCIIsOnAndPowerIsOn() {
		systemUnderTest.setPower(true);
		systemUnderTest.setCI(true);
		for (int a = 0; a < 256; a++) {
			for (int b = 0; b < 256; b++) {
				setAIn(systemUnderTest, a);
				setBIn(systemUnderTest, b);
				systemUnderTest.step();

				assertEquals(a + b + 1, getSumWithCarry());
			}
		}
	}

	@Test
	public void testEightBitAdder_shouldReturnZeroSumAndCarry_forAllAAndBInputs_whenCIIsOffAndPowerIsOff() {
		for (int a = 0; a < 256; a++) {
			for (int b = 0; b < 256; b++) {
				setAIn(systemUnderTest, a);
				setBIn(systemUnderTest, b);
				systemUnderTest.step();

				assertEquals(0, getSumWithCarry());
			}
		}
	}

	@Test
	public void testEightBitAdder_shouldReturnZeroSumAndCarry_forAllAAndBInputs_whenCIIsOnAndPowerIsOff() {
		systemUnderTest.setCI(true);
		for (int a = 0; a < 256; a++) {
			for (int b = 0; b < 256; b++) {
				setAIn(systemUnderTest, a);
				setBIn(systemUnderTest, b);
				systemUnderTest.step();

				assertEquals(0, getSumWithCarry());
			}
		}
	}

	private int getSumWithCarry() {
		int sum = getSum(systemUnderTest);
		if (systemUnderTest.getCO()) {
			sum = sum | bit8;
		}
		return sum;
	}
}

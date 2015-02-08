/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Processor.Tests;

import static electroMechanicalLogic.Tests.TestUtilities.getDataOut;
import static electroMechanicalLogic.Tests.TestUtilities.setAIn;
import static electroMechanicalLogic.Tests.TestUtilities.setBIn;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalMachine.Processor.BitwiseOperationHandler;
import electroMechanicalMachine.Processor.Interfaces.IBitwiseOperationHandler;

public class TestBitwiseOperationHandler {

	private IBitwiseOperationHandler systemUnderTest;

	@Before
	public void setUp() {
		systemUnderTest = new BitwiseOperationHandler();
		systemUnderTest.setPower(true);
	}

	@Test
	public void testAND_shouldGiveExpectedResults_forAllInputs() {
		systemUnderTest.setAND(true);
		for (int a = 0; a < 256; a++) {
			for (int b = 0; b < 256; b++) {
				setAIn(systemUnderTest, a);
				setBIn(systemUnderTest, b);

				systemUnderTest.step();

				assertEquals(String.format("a = %d, b = %d", a, b), a & b,
						getDataOut(systemUnderTest));
			}
		}
	}

	@Test
	public void testOR_shouldGiveExpectedResults_forAllInputs() {
		systemUnderTest.setOR(true);
		for (int a = 0; a < 256; a++) {
			for (int b = 0; b < 256; b++) {
				setAIn(systemUnderTest, a);
				setBIn(systemUnderTest, b);

				systemUnderTest.step();

				assertEquals(String.format("a = %d, b = %d", a, b), a | b,
						getDataOut(systemUnderTest));
			}
		}
	}

	@Test
	public void testXOR_shouldGiveExpectedResults_forAllInputs() {
		systemUnderTest.setXOR(true);
		for (int a = 0; a < 256; a++) {
			for (int b = 0; b < 256; b++) {
				setAIn(systemUnderTest, a);
				setBIn(systemUnderTest, b);

				systemUnderTest.step();

				assertEquals(String.format("a = %d, b = %d", a, b), a ^ b,
						getDataOut(systemUnderTest));
			}
		}
	}

}

/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.Gates.Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalLogic.Gates.FourInputOR;
import electroMechanicalLogic.Gates.Interfaces.IFourInputSingleOutputGate;

public class TestFourInputOR {
	private IFourInputSingleOutputGate systemUnderTest;

	@Before
	public void setUp() throws Exception {
		systemUnderTest = new FourInputOR();
		systemUnderTest.setPower(true);
	}

	@Test
	public void testFourInputOr_shouldReturnTrue_forAllInputsExceptZero() {
		for (int input = 0; input < 16; input++) {
			setInputs(input);

			systemUnderTest.step();

			assertEquals(String.format("input is %d", input), input != 0,
					systemUnderTest.getOutput());
		}
	}

	private void setInputs(final int input) {
		systemUnderTest.setA((input & 1) == 1);
		systemUnderTest.setB((input & 2) == 2);
		systemUnderTest.setC((input & 4) == 4);
		systemUnderTest.setD((input & 8) == 8);
	}
}

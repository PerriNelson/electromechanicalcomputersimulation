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
import static electroMechanicalLogic.Tests.TestUtilities.setDataIn;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalMachine.Processor.RotateLeft;
import electroMechanicalMachine.Processor.Interfaces.IRotate;

public class TestRotateLeft {
	private IRotate systemUnderTest;

	@Before
	public void setUp() {
		systemUnderTest = new RotateLeft();
		systemUnderTest.setPower(on);
	}

	@Test
	public void testRotateLeft_shouldReturnExpectedCarry_forAllInputs() {
		for (int input = 0; input < 256; input++) {
			final boolean expected = (input & 0x80) == 0x80;
			setDataIn(systemUnderTest, input);
			systemUnderTest.step();
			final boolean actual = systemUnderTest.getCO();

			assertEquals(expected, actual);
		}
	}

	@Test
	public void testRotateLeft_shouldReturnRotatedInput_forAllInputs() {
		for (int input = 0; input < 256; input++) {
			final int expected = ((input << 1) | ((input & 0x80) == 0x80 ? 1
					: 0)) & 0xff;
			setDataIn(systemUnderTest, input);
			systemUnderTest.step();
			final int actual = getDataOut(systemUnderTest);

			assertEquals(expected, actual);
		}
	}
}

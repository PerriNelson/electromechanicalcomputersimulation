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

import electroMechanicalMachine.Model.MarkVIIInstructionDecoder;
import electroMechanicalMachine.Model.Interfaces.IMarkVIIInstructionDecoder;

public class MarkVIIInstructionDecoderTest extends MarkVIInstructionDecoderTest {

	private static final int subtractCode = 0x21;

	private IMarkVIIInstructionDecoder getSystemUnderTest() {
		return (IMarkVIIInstructionDecoder) systemUnderTest;
	}

	@Before
	@Override
	public void Setup() {
		systemUnderTest = new MarkVIIInstructionDecoder();
		systemUnderTest.setPower(true);
	}

	@Test
	public void test_WhenCodeIsNotSubtract_getSubtract_ReturnsFalse() {
		for (int code = 0; code < 256; code++) {
			if (code == subtractCode)
				continue;

			setCode(code);
			systemUnderTest.step();

			assertFalse(String.format("code == %d", code), getSystemUnderTest()
					.getSubtract());
		}
	}

	@Test
	public void test_WhenCodeIsSubtract_getSubtract_ReturnsTrue() {
		setCode(subtractCode);
		systemUnderTest.step();

		assertTrue(getSystemUnderTest().getSubtract());
	}

}

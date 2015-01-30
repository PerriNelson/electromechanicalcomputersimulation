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

import electroMechanicalMachine.Model.MarkVIIIInstructionDecoder;
import electroMechanicalMachine.Model.Interfaces.IMarkVIIIInstructionDecoder;

public class TestMarkVIIIInstructionDecoder extends
		MarkVIIInstructionDecoderTest {

	private static final int addWithCarryCode = 0x22;
	private static final int subtractWithBorrowCode = 0x23;

	private IMarkVIIIInstructionDecoder getSystemUnderTest() {
		return (IMarkVIIIInstructionDecoder) systemUnderTest;
	}

	@Before
	@Override
	public void Setup() {
		systemUnderTest = new MarkVIIIInstructionDecoder();
		systemUnderTest.setPower(true);
	}

	@Test
	public void test_WhenCodeIsNotSubtractWithBorrow_getSubtractWithBorrow_ReturnsFalse() {
		for (int code = 0; code < 256; code++) {
			if (code == subtractWithBorrowCode) {
				continue;
			}

			setCode(code);
			systemUnderTest.step();

			assertFalse(String.format("code == %d", code), getSystemUnderTest()
					.getSubtractWithBorrow());
		}
	}

	@Test
	public void test_WhenCodeIsSubtractWithBorrow_getSubtractWithBorrow_ReturnsTrue() {
		setCode(subtractWithBorrowCode);
		systemUnderTest.step();

		assertTrue(getSystemUnderTest().getSubtractWithBorrow());
	}

	@Test
	public void test_WhenCodeIsNotAddWithCarry_getAddWithCarry_ReturnsFalse() {
		for (int code = 0; code < 256; code++) {
			if (code == addWithCarryCode) {
				continue;
			}

			setCode(code);
			systemUnderTest.step();

			assertFalse(String.format("code == %d", code), getSystemUnderTest()
					.getAddWithCarry());
		}
	}

	@Test
	public void test_WhenCodeIsAddWithCarry_getAddWithCarry_ReturnsTrue() {
		setCode(addWithCarryCode);
		systemUnderTest.step();

		assertTrue(getSystemUnderTest().getAddWithCarry());
	}

}

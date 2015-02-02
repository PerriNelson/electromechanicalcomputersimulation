/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Model.Tests;

import static electroMechanicalLogic.Tests.TestConstants.bit0;
import static electroMechanicalLogic.Tests.TestConstants.bit1;
import static electroMechanicalLogic.Tests.TestConstants.bit2;
import static electroMechanicalLogic.Tests.TestConstants.bit3;
import static electroMechanicalLogic.Tests.TestConstants.bit4;
import static electroMechanicalLogic.Tests.TestConstants.bit5;
import static electroMechanicalLogic.Tests.TestConstants.bit6;
import static electroMechanicalLogic.Tests.TestConstants.bit7;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalMachine.Model.MarkVIInstructionDecoder;
import electroMechanicalMachine.Model.Interfaces.IMarkVIInstructionDecoder;

public class MarkVIInstructionDecoderTest {

	private static final int loadCode = 0x10;
	private static final int storeCode = 0x11;
	private static final int addCode = 0x20;
	private static final int haltCode = 0xff;

	protected IMarkVIInstructionDecoder systemUnderTest;

	@Before
	public void Setup() {
		systemUnderTest = new MarkVIInstructionDecoder();
		systemUnderTest.setPower(true);
	}

	@Test
	public void test_WhenCodeIsAdd_getAdd_ReturnsTrue() {
		setCode(addCode);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getAdd());
	}

	@Test
	public void test_WhenCodeIsHalt_getHalt_ReturnsTrue() {
		setCode(haltCode);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getHalt());
	}

	@Test
	public void test_WhenCodeIsLoad_getLoad_ReturnsTrue() {
		setCode(loadCode);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getLoad());
	}

	@Test
	public void test_WhenCodeIsNotAdd_getAdd_ReturnsFalse() {
		for (int code = 0; code < 256; code++) {
			if (code == addCode) {
				continue;
			}

			setCode(code);
			systemUnderTest.step();

			assertFalse(String.format("code == %d", code),
					systemUnderTest.getAdd());
		}
	}

	@Test
	public void test_WhenCodeIsNotHalt_getHalt_ReturnsFalse() {
		for (int code = 0; code < 256; code++) {
			if (code == haltCode) {
				continue;
			}

			setCode(code);
			systemUnderTest.step();

			assertFalse(String.format("code == %d", code),
					systemUnderTest.getHalt());
		}
	}

	@Test
	public void test_WhenCodeIsNotLoad_getLoad_ReturnsFalse() {
		for (int code = 0; code < 256; code++) {
			if (code == loadCode) {
				continue;
			}

			setCode(code);
			systemUnderTest.step();

			assertFalse(String.format("code == %d", code),
					systemUnderTest.getLoad());
		}
	}

	@Test
	public void test_WhenCodeIsNotStore_getStore_ReturnsFalse() {
		for (int code = 0; code < 256; code++) {
			if (code == storeCode) {
				continue;
			}

			setCode(code);
			systemUnderTest.step();

			assertFalse(String.format("code == %d", code),
					systemUnderTest.getStore());
		}
	}

	@Test
	public void test_WhenCodeIsStore_getStore_ReturnsTrue() {
		setCode(storeCode);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getStore());
	}

	protected void setCode(final int code) {
		systemUnderTest.setDI0((code & bit0) == bit0);
		systemUnderTest.setDI1((code & bit1) == bit1);
		systemUnderTest.setDI2((code & bit2) == bit2);
		systemUnderTest.setDI3((code & bit3) == bit3);
		systemUnderTest.setDI4((code & bit4) == bit4);
		systemUnderTest.setDI5((code & bit5) == bit5);
		systemUnderTest.setDI6((code & bit6) == bit6);
		systemUnderTest.setDI7((code & bit7) == bit7);
	}
}

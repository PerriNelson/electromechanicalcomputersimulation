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

import electroMechanicalMachine.Model.MarkVIInstructionDecoder;
import electroMechanicalMachine.Model.Interfaces.IMarkVIInstructionDecoder;

public class MarkVIInstructionDecoderTest {
	private static final int bit0 = 0x1;
	private static final int bit1 = 0x2;
	private static final int bit2 = 0x4;
	private static final int bit3 = 0x8;
	private static final int bit4 = 0x10;
	private static final int bit5 = 0x20;
	private static final int bit6 = 0x40;
	private static final int bit7 = 0x80;

	private static final int loadCode = 0x10;
	private static final int storeCode = 0x11;
	private static final int addCode = 0x20;
	private static final int haltCode = 0xff;

	private IMarkVIInstructionDecoder systemUnderTest;

	private void setCode(int code) {
		systemUnderTest.setCI0((code & bit0) == bit0);
		systemUnderTest.setCI1((code & bit1) == bit1);
		systemUnderTest.setCI2((code & bit2) == bit2);
		systemUnderTest.setCI3((code & bit3) == bit3);
		systemUnderTest.setCI4((code & bit4) == bit4);
		systemUnderTest.setCI5((code & bit5) == bit5);
		systemUnderTest.setCI6((code & bit6) == bit6);
		systemUnderTest.setCI7((code & bit7) == bit7);
	}

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
			if (code == addCode)
				continue;

			setCode(code);
			systemUnderTest.step();

			assertFalse(String.format("code == %d", code),
					systemUnderTest.getAdd());
		}
	}

	@Test
	public void test_WhenCodeIsNotHalt_getHalt_ReturnsFalse() {
		for (int code = 0; code < 256; code++) {
			if (code == haltCode)
				continue;

			setCode(code);
			systemUnderTest.step();

			assertFalse(String.format("code == %d", code),
					systemUnderTest.getHalt());
		}
	}

	@Test
	public void test_WhenCodeIsNotLoad_getLoad_ReturnsFalse() {
		for (int code = 0; code < 256; code++) {
			if (code == loadCode)
				continue;

			setCode(code);
			systemUnderTest.step();

			assertFalse(String.format("code == %d", code),
					systemUnderTest.getLoad());
		}
	}

	@Test
	public void test_WhenCodeIsNotStore_getStore_ReturnsFalse() {
		for (int code = 0; code < 256; code++) {
			if (code == storeCode)
				continue;

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
}

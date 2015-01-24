/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.Tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalLogic.ThreeToEightDecoder;
import electroMechanicalLogic.Interfaces.IThreeToEightDecoder;

public class ThreeToEightDecoderTest {

	private IThreeToEightDecoder systemUnderTest;
	private static final int bit0 = 0x01;
	private static final int bit1 = 0x02;
	private static final int bit2 = 0x04;

	private void setS(final int value) {
		systemUnderTest.setS0((value & bit0) == bit0);
		systemUnderTest.setS1((value & bit1) == bit1);
		systemUnderTest.setS2((value & bit2) == bit2);
	}

	@Before
	public void setUp() throws Exception {
		systemUnderTest = new ThreeToEightDecoder();
		systemUnderTest.setPower(true);
	}

	@Test
	public void test_GetO0_OnlyReturnsOn_WhenDataIsOnAndS0IsOffAndS1IsOffAndS2IsOff() {
		systemUnderTest.setData(true);

		setS(0);

		systemUnderTest.step();
		assertTrue(systemUnderTest.getO0());

		for (int s = 1; s < 8; s += 1) {
			setS(s);
			systemUnderTest.step();
			assertFalse(systemUnderTest.getO0());
		}

		systemUnderTest.setData(false);
		for (int s = 0; s < 8; s += 1) {
			setS(s);
			systemUnderTest.step();
			assertFalse(systemUnderTest.getO0());
		}
	}

	@Test
	public void test_GetO1_OnlyReturnsOn_WhenDataIsOnAndS0IsOnAndS1IsOffAndS2IsOff() {
		systemUnderTest.setData(true);

		setS(0);

		systemUnderTest.step();
		assertFalse(systemUnderTest.getO1());

		setS(1);

		systemUnderTest.step();
		assertTrue(systemUnderTest.getO1());

		for (int s = 2; s < 8; s += 1) {
			setS(s);
			systemUnderTest.step();
			assertFalse(systemUnderTest.getO1());
		}

		systemUnderTest.setData(false);
		for (int s = 0; s < 8; s += 1) {
			setS(s);
			systemUnderTest.step();
			assertFalse(systemUnderTest.getO1());
		}
	}

	@Test
	public void test_GetO2_OnlyReturnsOn_WhenDataIsOnAndS0IsOffAndS1IsOnAndS2IsOff() {
		systemUnderTest.setData(true);

		for (int s = 0; s < 2; s += 1) {
			setS(s);
			systemUnderTest.step();
			assertFalse(systemUnderTest.getO2());
		}

		setS(2);

		systemUnderTest.step();
		assertTrue(systemUnderTest.getO2());

		for (int s = 3; s < 8; s += 1) {
			setS(s);
			systemUnderTest.step();
			assertFalse(systemUnderTest.getO2());
		}

		systemUnderTest.setData(false);
		for (int s = 0; s < 8; s += 1) {
			setS(s);
			systemUnderTest.step();
			assertFalse(systemUnderTest.getO2());
		}
	}

	@Test
	public void test_GetO3_OnlyReturnsOn_WhenDataIsOnAndS0IsOnAndS1IsOnAndS2IsOff() {
		systemUnderTest.setData(true);

		for (int s = 0; s < 3; s += 1) {
			setS(s);
			systemUnderTest.step();
			assertFalse(systemUnderTest.getO3());
		}

		setS(3);

		systemUnderTest.step();
		assertTrue(systemUnderTest.getO3());

		for (int s = 4; s < 8; s += 1) {
			setS(s);
			systemUnderTest.step();
			assertFalse(systemUnderTest.getO3());
		}

		systemUnderTest.setData(false);
		for (int s = 0; s < 8; s += 1) {
			setS(s);
			systemUnderTest.step();
			assertFalse(systemUnderTest.getO3());
		}
	}

	@Test
	public void test_GetO4_OnlyReturnsOn_WhenDataIsOnAndS0IsOffAndS1IsOffAndS2IsOn() {
		systemUnderTest.setData(true);

		for (int s = 0; s < 4; s += 1) {
			setS(s);
			systemUnderTest.step();
			assertFalse(systemUnderTest.getO4());
		}

		setS(4);

		systemUnderTest.step();
		assertTrue(systemUnderTest.getO4());

		for (int s = 5; s < 8; s += 1) {
			setS(s);
			systemUnderTest.step();
			assertFalse(systemUnderTest.getO4());
		}

		systemUnderTest.setData(false);
		for (int s = 0; s < 8; s += 1) {
			setS(s);
			systemUnderTest.step();
			assertFalse(systemUnderTest.getO4());
		}
	}

	@Test
	public void test_GetO5_OnlyReturnsOn_WhenDataIsOnAndS0IsOnAndS1IsOffAndS2IsOn() {
		systemUnderTest.setData(true);

		for (int s = 0; s < 5; s += 1) {
			setS(s);
			systemUnderTest.step();
			assertFalse(systemUnderTest.getO5());
		}

		setS(5);

		systemUnderTest.step();
		assertTrue(systemUnderTest.getO5());

		for (int s = 6; s < 8; s += 1) {
			setS(s);
			systemUnderTest.step();
			assertFalse(systemUnderTest.getO5());
		}

		systemUnderTest.setData(false);
		for (int s = 0; s < 8; s += 1) {
			setS(s);
			systemUnderTest.step();
			assertFalse(systemUnderTest.getO5());
		}
	}

	@Test
	public void test_GetO6_OnlyReturnsOn_WhenDataIsOnAndS0IsOffAndS1IsOnAndS2IsOn() {
		systemUnderTest.setData(true);

		for (int s = 0; s < 6; s += 1) {
			setS(s);
			systemUnderTest.step();
			assertFalse(systemUnderTest.getO6());
		}

		setS(6);

		systemUnderTest.step();
		assertTrue(systemUnderTest.getO6());

		for (int s = 7; s < 8; s += 1) {
			setS(s);
			systemUnderTest.step();
			assertFalse(systemUnderTest.getO6());
		}

		systemUnderTest.setData(false);
		for (int s = 0; s < 8; s += 1) {
			setS(s);
			systemUnderTest.step();
			assertFalse(systemUnderTest.getO6());
		}
	}

	@Test
	public void test_GetO6_OnlyReturnsOn_WhenDataIsOnAndS0IsOnAndS1IsOnAndS2IsOn() {
		systemUnderTest.setData(true);

		for (int s = 0; s < 7; s += 1) {
			setS(s);
			systemUnderTest.step();
			assertFalse(systemUnderTest.getO7());
		}

		setS(7);

		systemUnderTest.step();
		assertTrue(systemUnderTest.getO7());

		systemUnderTest.setData(false);
		for (int s = 0; s < 8; s += 1) {
			setS(s);
			systemUnderTest.step();
			assertFalse(systemUnderTest.getO7());
		}
	}

}

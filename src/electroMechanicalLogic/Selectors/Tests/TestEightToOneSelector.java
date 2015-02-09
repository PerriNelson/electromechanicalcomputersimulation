/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.Selectors.Tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalLogic.Selectors.EightToOneSelector;
import electroMechanicalLogic.Selectors.Interfaces.IEightToOneSelector;

public class TestEightToOneSelector {

	private IEightToOneSelector systemUnderTest;
	private static final int bit0 = 0x01;
	private static final int bit1 = 0x02;
	private static final int bit2 = 0x04;
	private static final int bit3 = 0x08;
	private static final int bit4 = 0x10;
	private static final int bit5 = 0x20;
	private static final int bit6 = 0x40;
	private static final int bit7 = 0x80;

	private static final int[] OnValues = new int[] { 0x01, 0x02, 0x04, 0x08,
			0x10, 0x20, 0x40, 0x80 };

	@Before
	public void setUp() throws Exception {
		systemUnderTest = new EightToOneSelector();
		systemUnderTest.setPower(true);
	}

	@Test
	public void test_GetOutput_WhenS0IsOffAndS1IsOffAndS2IsOff_ReturnsD0() {
		systemUnderTest.setS0(false);
		systemUnderTest.setS1(false);
		systemUnderTest.setS2(false);

		setD(OnValues[0]);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getDO());

		setD(~OnValues[0]);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getDO());
	}

	@Test
	public void test_GetOutput_WhenS0IsOffAndS1IsOffAndS2IsOn_ReturnsD4() {
		systemUnderTest.setS0(false);
		systemUnderTest.setS1(false);
		systemUnderTest.setS2(true);

		setD(OnValues[4]);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getDO());

		setD(~OnValues[4]);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getDO());
	}

	@Test
	public void test_GetOutput_WhenS0IsOffAndS1IsOnAndS2IsOff_ReturnsD2() {
		systemUnderTest.setS0(false);
		systemUnderTest.setS1(true);
		systemUnderTest.setS2(false);

		setD(OnValues[2]);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getDO());

		setD(~OnValues[2]);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getDO());
	}

	@Test
	public void test_GetOutput_WhenS0IsOffAndS1IsOnAndS2IsOn_ReturnsD6() {
		systemUnderTest.setS0(false);
		systemUnderTest.setS1(true);
		systemUnderTest.setS2(true);

		setD(OnValues[6]);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getDO());

		setD(~OnValues[6]);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getDO());
	}

	@Test
	public void test_GetOutput_WhenS0IsOnAndS1IsOffAndS2IsOff_ReturnsD1() {
		systemUnderTest.setS0(true);
		systemUnderTest.setS1(false);
		systemUnderTest.setS2(false);

		setD(OnValues[1]);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getDO());

		setD(~OnValues[1]);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getDO());
	}

	@Test
	public void test_GetOutput_WhenS0IsOnAndS1IsOffAndS2IsOn_ReturnsD5() {
		systemUnderTest.setS0(true);
		systemUnderTest.setS1(false);
		systemUnderTest.setS2(true);

		setD(OnValues[5]);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getDO());

		setD(~OnValues[5]);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getDO());
	}

	@Test
	public void test_GetOutput_WhenS0IsOnAndS1IsOnAndS2IsOff_ReturnsD3() {
		systemUnderTest.setS0(true);
		systemUnderTest.setS1(true);
		systemUnderTest.setS2(false);

		setD(OnValues[3]);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getDO());

		setD(~OnValues[3]);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getDO());
	}

	@Test
	public void test_GetOutput_WhenS0IsOnAndS1IsOnAndS2IsOn_ReturnsD7() {
		systemUnderTest.setS0(true);
		systemUnderTest.setS1(true);
		systemUnderTest.setS2(true);

		setD(OnValues[7]);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getDO());

		setD(~OnValues[7]);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getDO());
	}

	private void setD(final int value) {
		systemUnderTest.setA((value & bit0) == bit0);
		systemUnderTest.setB((value & bit1) == bit1);
		systemUnderTest.setC((value & bit2) == bit2);
		systemUnderTest.setD((value & bit3) == bit3);
		systemUnderTest.setE((value & bit4) == bit4);
		systemUnderTest.setF((value & bit5) == bit5);
		systemUnderTest.setG((value & bit6) == bit6);
		systemUnderTest.setH((value & bit7) == bit7);
	}
}

/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalLogic.EightBitTwoToOneSelector;
import electroMechanicalLogic.Interfaces.IEightBitTwoToOneSelector;

public class EightBitTwoToOneSelectorTest {

	private static final byte bit0 = 0x01;
	private static final byte bit1 = 0x02;
	private static final byte bit2 = 0x04;
	private static final byte bit3 = 0x08;
	private static final byte bit4 = 0x10;
	private static final byte bit5 = 0x20;
	private static final byte bit6 = 0x40;
	private static final byte bit7 = (byte) 0x80;

	IEightBitTwoToOneSelector systemUnderTest;

	@Before
	public void setUp() throws Exception {
		systemUnderTest = new EightBitTwoToOneSelector();
		systemUnderTest.setPower(true);
	}

	@Test
	public void test_OnlyO0IsOff_WhenOnlyA0IsOffAndOnlyB0IsnAndSelectIsOff() {
		setA(~bit0);
		setB(bit0);
		systemUnderTest.setSelect(false);

		systemUnderTest.step();

		assertEquals(getOutput(), ~bit0);
	}

	@Test
	public void test_OnlyO0IsOff_WhenOnlyA0IsOnAndOnlyB0IsOffAndSelectIsOn() {
		setA(bit0);
		setB(~bit0);
		systemUnderTest.setSelect(true);

		systemUnderTest.step();

		assertEquals(getOutput(), ~bit0);
	}

	@Test
	public void test_OnlyO0IsOn_WhenOnlyA0IsOffAndOnlyB0IsOnAndSelectIsOn() {
		setA(~bit0);
		setB(bit0);
		systemUnderTest.setSelect(true);

		systemUnderTest.step();

		assertEquals(getOutput(), bit0);
	}

	@Test
	public void test_OnlyO0IsOn_WhenOnlyA0IsOnAndOnlyB0IsOffAndSelectIsOff() {
		setA(bit0);
		setB(~bit0);
		systemUnderTest.setSelect(false);

		systemUnderTest.step();

		assertEquals(getOutput(), bit0);
	}

	@Test
	public void test_OnlyO10IsOff_WhenOnlyA1IsOnAndOnlyB1IsOffAndSelectIsOn() {
		setA(bit1);
		setB(~bit1);
		systemUnderTest.setSelect(true);

		systemUnderTest.step();

		assertEquals(getOutput(), ~bit1);
	}

	@Test
	public void test_OnlyO1IsOff_WhenOnlyA1IsOffAndOnlyB1IsnAndSelectIsOff() {
		setA(~bit1);
		setB(bit1);
		systemUnderTest.setSelect(false);

		systemUnderTest.step();

		assertEquals(getOutput(), ~bit1);
	}

	@Test
	public void test_OnlyO1IsOn_WhenOnlyA1IsOffAndOnlyB1IsOnAndSelectIsOn() {
		setA(~bit1);
		setB(bit1);
		systemUnderTest.setSelect(true);

		systemUnderTest.step();

		assertEquals(getOutput(), bit1);
	}

	@Test
	public void test_OnlyO1IsOn_WhenOnlyA1IsOnAndOnlyB1IsOffAndSelectIsOff() {
		setA(bit1);
		setB(~bit1);
		systemUnderTest.setSelect(false);

		systemUnderTest.step();

		assertEquals(getOutput(), bit1);
	}

	@Test
	public void test_OnlyO20IsOff_WhenOnlyA2IsOnAndOnlyB2IsOffAndSelectIsOn() {
		setA(bit2);
		setB(~bit2);
		systemUnderTest.setSelect(true);

		systemUnderTest.step();

		assertEquals(getOutput(), ~bit2);
	}

	@Test
	public void test_OnlyO2IsOff_WhenOnlyA2IsOffAndOnlyB2IsnAndSelectIsOff() {
		setA(~bit2);
		setB(bit2);
		systemUnderTest.setSelect(false);

		systemUnderTest.step();

		assertEquals(getOutput(), ~bit2);
	}

	@Test
	public void test_OnlyO2IsOn_WhenOnlyA2IsOffAndOnlyB2IsOnAndSelectIsOn() {
		setA(~bit2);
		setB(bit2);
		systemUnderTest.setSelect(true);

		systemUnderTest.step();

		assertEquals(getOutput(), bit2);
	}

	@Test
	public void test_OnlyO2IsOn_WhenOnlyA2IsOnAndOnlyB2IsOffAndSelectIsOff() {
		setA(bit2);
		setB(~bit2);
		systemUnderTest.setSelect(false);

		systemUnderTest.step();

		assertEquals(getOutput(), bit2);
	}

	@Test
	public void test_OnlyO30IsOff_WhenOnlyA3IsOnAndOnlyB3IsOffAndSelectIsOn() {
		setA(bit3);
		setB(~bit3);
		systemUnderTest.setSelect(true);

		systemUnderTest.step();

		assertEquals(getOutput(), ~bit3);
	}

	@Test
	public void test_OnlyO3IsOff_WhenOnlyA3IsOffAndOnlyB3IsnAndSelectIsOff() {
		setA(~bit3);
		setB(bit3);
		systemUnderTest.setSelect(false);

		systemUnderTest.step();

		assertEquals(getOutput(), ~bit3);
	}

	@Test
	public void test_OnlyO3IsOn_WhenOnlyA3IsOffAndOnlyB3IsOnAndSelectIsOn() {
		setA(~bit3);
		setB(bit3);
		systemUnderTest.setSelect(true);

		systemUnderTest.step();

		assertEquals(getOutput(), bit3);
	}

	@Test
	public void test_OnlyO3IsOn_WhenOnlyA3IsOnAndOnlyB3IsOffAndSelectIsOff() {
		setA(bit3);
		setB(~bit3);
		systemUnderTest.setSelect(false);

		systemUnderTest.step();

		assertEquals(getOutput(), bit3);
	}

	@Test
	public void test_OnlyO4IsOff_WhenOnlyA4IsOffAndOnlyB4IsnAndSelectIsOff() {
		setA(~bit4);
		setB(bit4);
		systemUnderTest.setSelect(false);

		systemUnderTest.step();

		assertEquals(getOutput(), ~bit4);
	}

	@Test
	public void test_OnlyO4IsOff_WhenOnlyA4IsOnAndOnlyB4IsOffAndSelectIsOn() {
		setA(bit4);
		setB(~bit4);
		systemUnderTest.setSelect(true);

		systemUnderTest.step();

		assertEquals(getOutput(), ~bit4);
	}

	@Test
	public void test_OnlyO4IsOn_WhenOnlyA4IsOffAndOnlyB4IsOnAndSelectIsOn() {
		setA(~bit4);
		setB(bit4);
		systemUnderTest.setSelect(true);

		systemUnderTest.step();

		assertEquals(getOutput(), bit4);
	}

	@Test
	public void test_OnlyO4IsOn_WhenOnlyA4IsOnAndOnlyB4IsOffAndSelectIsOff() {
		setA(bit4);
		setB(~bit4);
		systemUnderTest.setSelect(false);

		systemUnderTest.step();

		assertEquals(getOutput(), bit4);
	}

	@Test
	public void test_OnlyO54IsOff_WhenOnlyA5IsOnAndOnlyB5IsOffAndSelectIsOn() {
		setA(bit5);
		setB(~bit5);
		systemUnderTest.setSelect(true);

		systemUnderTest.step();

		assertEquals(getOutput(), ~bit5);
	}

	@Test
	public void test_OnlyO5IsOff_WhenOnlyA5IsOffAndOnlyB5IsnAndSelectIsOff() {
		setA(~bit5);
		setB(bit5);
		systemUnderTest.setSelect(false);

		systemUnderTest.step();

		assertEquals(getOutput(), ~bit5);
	}

	@Test
	public void test_OnlyO5IsOn_WhenOnlyA5IsOffAndOnlyB5IsOnAndSelectIsOn() {
		setA(~bit5);
		setB(bit5);
		systemUnderTest.setSelect(true);

		systemUnderTest.step();

		assertEquals(getOutput(), bit5);
	}

	@Test
	public void test_OnlyO5IsOn_WhenOnlyA5IsOnAndOnlyB5IsOffAndSelectIsOff() {
		setA(bit5);
		setB(~bit5);
		systemUnderTest.setSelect(false);

		systemUnderTest.step();

		assertEquals(getOutput(), bit5);
	}

	@Test
	public void test_OnlyO64IsOff_WhenOnlyA6IsOnAndOnlyB6IsOffAndSelectIsOn() {
		setA(bit6);
		setB(~bit6);
		systemUnderTest.setSelect(true);

		systemUnderTest.step();

		assertEquals(getOutput(), ~bit6);
	}

	@Test
	public void test_OnlyO6IsOff_WhenOnlyA6IsOffAndOnlyB6IsnAndSelectIsOff() {
		setA(~bit6);
		setB(bit6);
		systemUnderTest.setSelect(false);

		systemUnderTest.step();

		assertEquals(getOutput(), ~bit6);
	}

	@Test
	public void test_OnlyO6IsOn_WhenOnlyA6IsOffAndOnlyB6IsOnAndSelectIsOn() {
		setA(~bit6);
		setB(bit6);
		systemUnderTest.setSelect(true);

		systemUnderTest.step();

		assertEquals(getOutput(), bit6);
	}

	@Test
	public void test_OnlyO6IsOn_WhenOnlyA6IsOnAndOnlyB6IsOffAndSelectIsOff() {
		setA(bit6);
		setB(~bit6);
		systemUnderTest.setSelect(false);

		systemUnderTest.step();

		assertEquals(getOutput(), bit6);
	}

	@Test
	public void test_OnlyO74IsOff_WhenOnlyA7IsOnAndOnlyB7IsOffAndSelectIsOn() {
		setA(bit7);
		setB(~bit7);
		systemUnderTest.setSelect(true);

		systemUnderTest.step();

		assertEquals(getOutput(), ~bit7);
	}

	@Test
	public void test_OnlyO7IsOff_WhenOnlyA7IsOffAndOnlyB7IsnAndSelectIsOff() {
		setA(~bit7);
		setB(bit7);
		systemUnderTest.setSelect(false);

		systemUnderTest.step();

		assertEquals(getOutput(), ~bit7);
	}

	@Test
	public void test_OnlyO7IsOn_WhenOnlyA7IsOffAndOnlyB7IsOnAndSelectIsOn() {
		setA(~bit7);
		setB(bit7);
		systemUnderTest.setSelect(true);

		systemUnderTest.step();

		assertEquals(getOutput(), bit7);
	}

	@Test
	public void test_OnlyO7IsOn_WhenOnlyA7IsOnAndOnlyB7IsOffAndSelectIsOff() {
		setA(bit7);
		setB(~bit7);
		systemUnderTest.setSelect(false);

		systemUnderTest.step();

		assertEquals(getOutput(), bit7);
	}

	private byte getOutput() {
		byte value = 0;

		value |= systemUnderTest.getDO0() ? bit0 : 0;
		value |= systemUnderTest.getDO1() ? bit1 : 0;
		value |= systemUnderTest.getDO2() ? bit2 : 0;
		value |= systemUnderTest.getDO3() ? bit3 : 0;
		value |= systemUnderTest.getDO4() ? bit4 : 0;
		value |= systemUnderTest.getDO5() ? bit5 : 0;
		value |= systemUnderTest.getDO6() ? bit6 : 0;
		value |= systemUnderTest.getDO7() ? bit7 : 0;

		return value;
	}

	private void setA(final int value) {
		systemUnderTest.setA0((value & bit0) == bit0);
		systemUnderTest.setA1((value & bit1) == bit1);
		systemUnderTest.setA2((value & bit2) == bit2);
		systemUnderTest.setA3((value & bit3) == bit3);
		systemUnderTest.setA4((value & bit4) == bit4);
		systemUnderTest.setA5((value & bit5) == bit5);
		systemUnderTest.setA6((value & bit6) == bit6);
		systemUnderTest.setA7((value & bit7) == bit7);
	}

	private void setB(final int value) {
		systemUnderTest.setB0((value & bit0) == bit0);
		systemUnderTest.setB1((value & bit1) == bit1);
		systemUnderTest.setB2((value & bit2) == bit2);
		systemUnderTest.setB3((value & bit3) == bit3);
		systemUnderTest.setB4((value & bit4) == bit4);
		systemUnderTest.setB5((value & bit5) == bit5);
		systemUnderTest.setB6((value & bit6) == bit6);
		systemUnderTest.setB7((value & bit7) == bit7);
	}
}

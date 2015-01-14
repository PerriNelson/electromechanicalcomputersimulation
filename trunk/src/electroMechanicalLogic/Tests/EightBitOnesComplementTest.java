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

import electroMechanicalLogic.EightBitOnesComplement;
import electroMechanicalLogic.Interfaces.IEightBitOnesComplement;

public class EightBitOnesComplementTest {

	private static final byte bit0 = 0x01;
	private static final byte bit1 = 0x02;
	private static final byte bit2 = 0x04;
	private static final byte bit3 = 0x08;
	private static final byte bit4 = 0x10;
	private static final byte bit5 = 0x20;
	private static final byte bit6 = 0x40;
	private static final byte bit7 = (byte) 0x80;

	private IEightBitOnesComplement systemUnderTest;

	private byte getOutput() {
		byte value = 0;

		value |= systemUnderTest.getO0() ? bit0 : 0;
		value |= systemUnderTest.getO1() ? bit1 : 0;
		value |= systemUnderTest.getO2() ? bit2 : 0;
		value |= systemUnderTest.getO3() ? bit3 : 0;
		value |= systemUnderTest.getO4() ? bit4 : 0;
		value |= systemUnderTest.getO5() ? bit5 : 0;
		value |= systemUnderTest.getO6() ? bit6 : 0;
		value |= systemUnderTest.getO7() ? bit7 : 0;

		return value;
	}

	private void setInput(byte value) {
		systemUnderTest.setI0((value & bit0) == bit0);
		systemUnderTest.setI1((value & bit1) == bit1);
		systemUnderTest.setI2((value & bit2) == bit2);
		systemUnderTest.setI3((value & bit3) == bit3);
		systemUnderTest.setI4((value & bit4) == bit4);
		systemUnderTest.setI5((value & bit5) == bit5);
		systemUnderTest.setI6((value & bit6) == bit6);
		systemUnderTest.setI7((value & bit7) == bit7);
	}

	@Before
	public void setUp() throws Exception {
		systemUnderTest = new EightBitOnesComplement();
		systemUnderTest.setPower(true);
	}

	@Test
	public void test_OnlyOutputFiveIsOff_WhenOnlyInputFiveIsSetAndInvertIsSet() {
		setInput(bit5);

		systemUnderTest.setInvert(true);
		systemUnderTest.step();

		assertEquals(getOutput(), ~bit5);
	}

	@Test
	public void test_OnlyOutputFiveIsOn_WhenOnlyInputFiveIsSetAndInvertIsNotSet() {
		setInput(bit5);

		systemUnderTest.step();

		assertEquals(getOutput(), bit5);
	}

	@Test
	public void test_OnlyOutputFourIsOff_WhenOnlyInputFourIsSetAndInvertIsSet() {
		setInput(bit4);

		systemUnderTest.setInvert(true);
		systemUnderTest.step();

		assertEquals(getOutput(), ~bit4);
	}

	@Test
	public void test_OnlyOutputFourIsOn_WhenOnlyInputFourIsSetAndInvertIsNotSet() {
		setInput(bit4);

		systemUnderTest.step();

		assertEquals(getOutput(), bit4);
	}

	@Test
	public void test_OnlyOutputOneIsOff_WhenOnlyInputOneIsSetAndInvertIsSet() {
		setInput(bit1);

		systemUnderTest.setInvert(true);
		systemUnderTest.step();

		assertEquals(getOutput(), ~bit1);
	}

	@Test
	public void test_OnlyOutputOneIsOn_WhenOnlyInputOneIsSetAndInvertIsNotSet() {
		setInput(bit1);

		systemUnderTest.step();

		assertEquals(getOutput(), bit1);
	}

	@Test
	public void test_OnlyOutputSevenIsOff_WhenOnlyInputSevenIsSetAndInvertIsSet() {
		setInput(bit7);

		systemUnderTest.setInvert(true);
		systemUnderTest.step();

		assertEquals(getOutput(), ~bit7);
	}

	@Test
	public void test_OnlyOutputSevenIsOn_WhenOnlyInputSevenIsSetAndInvertIsNotSet() {
		setInput(bit7);

		systemUnderTest.step();

		assertEquals(getOutput(), bit7);
	}

	@Test
	public void test_OnlyOutputSixIsOff_WhenOnlyInputSixIsSetAndInvertIsSet() {
		setInput(bit6);

		systemUnderTest.setInvert(true);
		systemUnderTest.step();

		assertEquals(getOutput(), ~bit6);
	}

	@Test
	public void test_OnlyOutputSixIsOn_WhenOnlyInputSixIsSetAndInvertIsNotSet() {
		setInput(bit6);

		systemUnderTest.step();

		assertEquals(getOutput(), bit6);
	}

	@Test
	public void test_OnlyOutputThreeIsOff_WhenOnlyInputThreeIsSetAndInvertIsSet() {
		setInput(bit3);

		systemUnderTest.setInvert(true);
		systemUnderTest.step();

		assertEquals(getOutput(), ~bit3);
	}

	@Test
	public void test_OnlyOutputThreeIsOn_WhenOnlyInputThreeIsSetAndInvertIsNotSet() {
		setInput(bit3);

		systemUnderTest.step();

		assertEquals(getOutput(), bit3);
	}

	@Test
	public void test_OnlyOutputTwoIsOff_WhenOnlyInputTwoIsSetAndInvertIsSet() {
		setInput(bit2);

		systemUnderTest.setInvert(true);
		systemUnderTest.step();

		assertEquals(getOutput(), ~bit2);
	}

	@Test
	public void test_OnlyOutputTwoIsOn_WhenOnlyInputTwoIsSetAndInvertIsNotSet() {
		setInput(bit2);

		systemUnderTest.step();

		assertEquals(getOutput(), bit2);
	}

	@Test
	public void test_OnlyOutputZeroIsOff_WhenOnlyInputZeroIsSetAndInvertIsSet() {
		setInput(bit0);

		systemUnderTest.setInvert(true);
		systemUnderTest.step();

		assertEquals(getOutput(), ~bit0);
	}

	@Test
	public void test_OnlyOutputZeroIsOn_WhenOnlyInputZeroIsSetAndInvertIsNotSet() {
		setInput(bit0);

		systemUnderTest.step();

		assertEquals(getOutput(), bit0);
	}
}

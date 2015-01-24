/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.Tests;

import static electroMechanicalLogic.Tests.TestConstants.bit0;
import static electroMechanicalLogic.Tests.TestConstants.bit1;
import static electroMechanicalLogic.Tests.TestConstants.bit2;
import static electroMechanicalLogic.Tests.TestConstants.bit3;
import static electroMechanicalLogic.Tests.TestConstants.bit4;
import static electroMechanicalLogic.Tests.TestConstants.bit5;
import static electroMechanicalLogic.Tests.TestConstants.bit6;
import static electroMechanicalLogic.Tests.TestConstants.bit7;
import static electroMechanicalLogic.Tests.TestUtilities.getDataOut;
import static electroMechanicalLogic.Tests.TestUtilities.setInput;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalLogic.EightBitOnesComplement;
import electroMechanicalLogic.Interfaces.IEightBitOnesComplement;

public class EightBitOnesComplementTest {

	private IEightBitOnesComplement systemUnderTest;

	@Before
	public void setUp() throws Exception {
		systemUnderTest = new EightBitOnesComplement();
		systemUnderTest.setPower(true);
	}

	@Test
	public void test_OnlyOutputFiveIsOff_WhenOnlyInputFiveIsSetAndInvertIsSet() {
		setInput(systemUnderTest, bit5);

		systemUnderTest.setInvert(true);
		systemUnderTest.step();

		assertEquals(getDataOut(systemUnderTest), 0xff & ~bit5);
	}

	@Test
	public void test_OnlyOutputFiveIsOn_WhenOnlyInputFiveIsSetAndInvertIsNotSet() {
		setInput(systemUnderTest, bit5);

		systemUnderTest.step();

		assertEquals(getDataOut(systemUnderTest), bit5);
	}

	@Test
	public void test_OnlyOutputFourIsOff_WhenOnlyInputFourIsSetAndInvertIsSet() {
		setInput(systemUnderTest, bit4);

		systemUnderTest.setInvert(true);
		systemUnderTest.step();

		assertEquals(getDataOut(systemUnderTest), 0xff & ~bit4);
	}

	@Test
	public void test_OnlyOutputFourIsOn_WhenOnlyInputFourIsSetAndInvertIsNotSet() {
		setInput(systemUnderTest, bit4);

		systemUnderTest.step();

		assertEquals(getDataOut(systemUnderTest), bit4);
	}

	@Test
	public void test_OnlyOutputOneIsOff_WhenOnlyInputOneIsSetAndInvertIsSet() {
		setInput(systemUnderTest, bit1);

		systemUnderTest.setInvert(true);
		systemUnderTest.step();

		assertEquals(getDataOut(systemUnderTest), 0xff & ~bit1);
	}

	@Test
	public void test_OnlyOutputOneIsOn_WhenOnlyInputOneIsSetAndInvertIsNotSet() {
		setInput(systemUnderTest, bit1);

		systemUnderTest.step();

		assertEquals(getDataOut(systemUnderTest), bit1);
	}

	@Test
	public void test_OnlyOutputSevenIsOff_WhenOnlyInputSevenIsSetAndInvertIsSet() {
		setInput(systemUnderTest, bit7);

		systemUnderTest.setInvert(true);
		systemUnderTest.step();

		assertEquals(getDataOut(systemUnderTest), 0xff & ~bit7);
	}

	@Test
	public void test_OnlyOutputSevenIsOn_WhenOnlyInputSevenIsSetAndInvertIsNotSet() {
		setInput(systemUnderTest, bit7);

		systemUnderTest.step();

		assertEquals(getDataOut(systemUnderTest), bit7);
	}

	@Test
	public void test_OnlyOutputSixIsOff_WhenOnlyInputSixIsSetAndInvertIsSet() {
		setInput(systemUnderTest, bit6);

		systemUnderTest.setInvert(true);
		systemUnderTest.step();

		assertEquals(getDataOut(systemUnderTest), 0xff & ~bit6);
	}

	@Test
	public void test_OnlyOutputSixIsOn_WhenOnlyInputSixIsSetAndInvertIsNotSet() {
		setInput(systemUnderTest, bit6);

		systemUnderTest.step();

		assertEquals(getDataOut(systemUnderTest), bit6);
	}

	@Test
	public void test_OnlyOutputThreeIsOff_WhenOnlyInputThreeIsSetAndInvertIsSet() {
		setInput(systemUnderTest, bit3);

		systemUnderTest.setInvert(true);
		systemUnderTest.step();

		assertEquals(getDataOut(systemUnderTest), 0xff & ~bit3);
	}

	@Test
	public void test_OnlyOutputThreeIsOn_WhenOnlyInputThreeIsSetAndInvertIsNotSet() {
		setInput(systemUnderTest, bit3);

		systemUnderTest.step();

		assertEquals(getDataOut(systemUnderTest), bit3);
	}

	@Test
	public void test_OnlyOutputTwoIsOff_WhenOnlyInputTwoIsSetAndInvertIsSet() {
		setInput(systemUnderTest, bit2);

		systemUnderTest.setInvert(true);
		systemUnderTest.step();

		assertEquals(getDataOut(systemUnderTest), 0xff & ~bit2);
	}

	@Test
	public void test_OnlyOutputTwoIsOn_WhenOnlyInputTwoIsSetAndInvertIsNotSet() {
		setInput(systemUnderTest, bit2);

		systemUnderTest.step();

		assertEquals(getDataOut(systemUnderTest), bit2);
	}

	@Test
	public void test_OnlyOutputZeroIsOff_WhenOnlyInputZeroIsSetAndInvertIsSet() {
		setInput(systemUnderTest, bit0);

		systemUnderTest.setInvert(true);
		systemUnderTest.step();

		assertEquals(getDataOut(systemUnderTest), 0xff & ~bit0);
	}

	@Test
	public void test_OnlyOutputZeroIsOn_WhenOnlyInputZeroIsSetAndInvertIsNotSet() {
		setInput(systemUnderTest, bit0);

		systemUnderTest.step();

		assertEquals(getDataOut(systemUnderTest), bit0);
	}
}

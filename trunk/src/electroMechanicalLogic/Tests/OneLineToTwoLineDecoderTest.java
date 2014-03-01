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

import electroMechanicalLogic.OneLineToTwoLineDecoder;
import electroMechanicalLogic.Interfaces.IOneLineToTwoLineDecoder;

public class OneLineToTwoLineDecoderTest {
	private IOneLineToTwoLineDecoder systemUnderTest;

	@Before
	public void setUp() throws Exception {
		systemUnderTest = new OneLineToTwoLineDecoder();
		systemUnderTest.setPower(true);
	}

	@Test
	public final void test_WhenInputIsOff_BothOutputsAreOff() {
		systemUnderTest.setInput(false);
		systemUnderTest.step();
		assertFalse(systemUnderTest.getO0());
		assertFalse(systemUnderTest.getO1());
	}

	@Test
	public final void test_WhenInputIsOnAndSelectIsOff_Output0IsOnAndOutput1IsOff() {
		systemUnderTest.setInput(true);
		systemUnderTest.setSelect(false);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getO0());
		assertFalse(systemUnderTest.getO1());
	}

	@Test
	public final void test_WhenInputIsOnAndSelectIsOn_Output0IsOffAndOutput1IsOn() {
		systemUnderTest.setInput(true);
		systemUnderTest.setSelect(true);
		systemUnderTest.step();
		assertFalse(systemUnderTest.getO0());
		assertTrue(systemUnderTest.getO1());
	}

}

/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.Selectors.Tests;

import static electroMechanicalLogic.Tests.TestUtilities.getDataOut;
import static electroMechanicalLogic.Tests.TestUtilities.setAIn;
import static electroMechanicalLogic.Tests.TestUtilities.setBIn;
import static electroMechanicalLogic.Tests.TestUtilities.setCIn;
import static electroMechanicalLogic.Tests.TestUtilities.setDIn;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalLogic.Selectors.EightBitFourToOneSelector;
import electroMechanicalLogic.Selectors.Interfaces.IEightBitFourToOneSelector;

public class TestEIghtBitFourToOneSelector {

	private IEightBitFourToOneSelector systemUnderTest;

	@Before
	public void setUp() {
		systemUnderTest = new EightBitFourToOneSelector();
		systemUnderTest.setPower(true);

		setAIn(systemUnderTest, 0xAA);
		setBIn(systemUnderTest, 0xBB);
		setCIn(systemUnderTest, 0xCC);
		setDIn(systemUnderTest, 0xDD);
	}

	@Test
	public void testSelector_shouldSelectAInput_whenS0IsOffAndS1IsOff() {
		systemUnderTest.setS0(false);
		systemUnderTest.setS1(false);

		systemUnderTest.step();

		assertEquals(0xAA, getDataOut(systemUnderTest));
	}

	@Test
	public void testSelector_shouldSelectBInput_whenS0IsOnAndS1IsOff() {
		systemUnderTest.setS0(true);
		systemUnderTest.setS1(false);

		systemUnderTest.step();

		assertEquals(0xBB, getDataOut(systemUnderTest));
	}

	@Test
	public void testSelector_shouldSelectCInput_whenS0IsOffAndS1IsOn() {
		systemUnderTest.setS0(false);
		systemUnderTest.setS1(true);

		systemUnderTest.step();

		assertEquals(0xCC, getDataOut(systemUnderTest));
	}

	@Test
	public void testSelector_shouldSelectDInput_whenS0IsOnAndS1IsOn() {
		systemUnderTest.setS0(true);
		systemUnderTest.setS1(true);

		systemUnderTest.step();

		assertEquals(0xDD, getDataOut(systemUnderTest));
	}
}

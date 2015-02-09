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

import electroMechanicalLogic.Selectors.TwoToOneSelector;
import electroMechanicalLogic.Selectors.Interfaces.ITwoToOneSelector;

public class TestTwoToOneSelector {

	private ITwoToOneSelector systemUnderTest;

	@Before
	public void setUp() throws Exception {
		systemUnderTest = new TwoToOneSelector();
		systemUnderTest.setPower(true);
	}

	@Test
	public void test_GetQ_WhenAIsOffAndBIsOffAndSelectIsOff_ReturnsOff() {
		systemUnderTest.setA(false);
		systemUnderTest.setB(false);
		systemUnderTest.setSelect(false);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getDO());
	}

	@Test
	public void test_GetQ_WhenAIsOffAndBIsOffAndSelectIsOn_ReturnsOff() {
		systemUnderTest.setA(false);
		systemUnderTest.setB(false);
		systemUnderTest.setSelect(true);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getDO());
	}

	@Test
	public void test_GetQ_WhenAIsOffAndBIsOnAndSelectIsOff_ReturnsOff() {
		systemUnderTest.setA(false);
		systemUnderTest.setB(true);
		systemUnderTest.setSelect(false);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getDO());
	}

	@Test
	public void test_GetQ_WhenAIsOffAndBIsOnAndSelectIsOn_ReturnsOn() {
		systemUnderTest.setA(false);
		systemUnderTest.setB(true);
		systemUnderTest.setSelect(true);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getDO());
	}

	@Test
	public void test_GetQ_WhenAIsOnAndBIsOffAndSelectIsOff_ReturnsOn() {
		systemUnderTest.setA(true);
		systemUnderTest.setB(false);
		systemUnderTest.setSelect(false);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getDO());
	}

	@Test
	public void test_GetQ_WhenAIsOnAndBIsOffAndSelectIsOn_ReturnsOff() {
		systemUnderTest.setA(true);
		systemUnderTest.setB(false);
		systemUnderTest.setSelect(true);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getDO());
	}

	@Test
	public void test_GetQ_WhenAIsOnAndBIsOnAndSelectIsOff_ReturnsOn() {
		systemUnderTest.setA(true);
		systemUnderTest.setB(true);
		systemUnderTest.setSelect(false);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getDO());
	}

	@Test
	public void test_GetQ_WhenAIsOnAndBIsOnAndSelectIsOn_ReturnsOn() {
		systemUnderTest.setA(true);
		systemUnderTest.setB(true);
		systemUnderTest.setSelect(true);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getDO());
	}

}

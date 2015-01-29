/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.Gates.Tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalLogic.Gates.FourInputAND;
import electroMechanicalLogic.Gates.Interfaces.IFourInputSingleOutputGate;

public class TestFourInputAND {
	private IFourInputSingleOutputGate systemUnderTest;

	@Before
	public void setUp() throws Exception {
		systemUnderTest = new FourInputAND();
		systemUnderTest.setPower(true);
	}

	@Test
	public void test_GetOutput_WhenAIsOffAndBIsOffAndCIsOffAndDIsOff_ReturnsOff() {
		systemUnderTest.setA(false);
		systemUnderTest.setB(false);
		systemUnderTest.setC(false);
		systemUnderTest.setD(false);

		systemUnderTest.step();

		assertFalse(systemUnderTest.getOutput());
	}

	@Test
	public void test_GetOutput_WhenAIsOffAndBIsOffAndCIsOffAndDIsOn_ReturnsOff() {
		systemUnderTest.setA(false);
		systemUnderTest.setB(false);
		systemUnderTest.setC(false);
		systemUnderTest.setD(true);

		systemUnderTest.step();

		assertFalse(systemUnderTest.getOutput());
	}

	@Test
	public void test_GetOutput_WhenAIsOffAndBIsOffAndCIsOnAndDIsOff_ReturnsOff() {
		systemUnderTest.setA(false);
		systemUnderTest.setB(false);
		systemUnderTest.setC(true);
		systemUnderTest.setD(false);

		systemUnderTest.step();

		assertFalse(systemUnderTest.getOutput());
	}

	@Test
	public void test_GetOutput_WhenAIsOffAndBIsOffAndCIsOnAndDIsOn_ReturnsOff() {
		systemUnderTest.setA(false);
		systemUnderTest.setB(false);
		systemUnderTest.setC(true);
		systemUnderTest.setD(true);

		systemUnderTest.step();

		assertFalse(systemUnderTest.getOutput());
	}

	@Test
	public void test_GetOutput_WhenAIsOffAndBIsOnAndCIsOffAndDIsOff_ReturnsOff() {
		systemUnderTest.setA(false);
		systemUnderTest.setB(true);
		systemUnderTest.setC(false);
		systemUnderTest.setD(false);

		systemUnderTest.step();

		assertFalse(systemUnderTest.getOutput());
	}

	@Test
	public void test_GetOutput_WhenAIsOffAndBIsOnAndCIsOffAndDIsOn_ReturnsOff() {
		systemUnderTest.setA(false);
		systemUnderTest.setB(true);
		systemUnderTest.setC(false);
		systemUnderTest.setD(true);

		systemUnderTest.step();

		assertFalse(systemUnderTest.getOutput());
	}

	@Test
	public void test_GetOutput_WhenAIsOffAndBIsOnAndCIsOnAndDIsOff_ReturnsOff() {
		systemUnderTest.setA(false);
		systemUnderTest.setB(true);
		systemUnderTest.setC(true);
		systemUnderTest.setD(false);

		systemUnderTest.step();

		assertFalse(systemUnderTest.getOutput());
	}

	@Test
	public void test_GetOutput_WhenAIsOffAndBIsOnAndCIsOnAndDIsOn_ReturnsOff() {
		systemUnderTest.setA(false);
		systemUnderTest.setB(true);
		systemUnderTest.setC(true);
		systemUnderTest.setD(true);

		systemUnderTest.step();

		assertFalse(systemUnderTest.getOutput());
	}

	@Test
	public void test_GetOutput_WhenAIsOnAndBIsOffAndCIsOffAndDIsOff_ReturnsOff() {
		systemUnderTest.setA(true);
		systemUnderTest.setB(false);
		systemUnderTest.setC(false);
		systemUnderTest.setD(false);

		systemUnderTest.step();

		assertFalse(systemUnderTest.getOutput());
	}

	@Test
	public void test_GetOutput_WhenAIsOnAndBIsOffAndCIsOffAndDIsOn_ReturnsOff() {
		systemUnderTest.setA(true);
		systemUnderTest.setB(false);
		systemUnderTest.setC(false);
		systemUnderTest.setD(true);

		systemUnderTest.step();

		assertFalse(systemUnderTest.getOutput());
	}

	@Test
	public void test_GetOutput_WhenAIsOnAndBIsOffAndCIsOnAndDIsOff_ReturnsOff() {
		systemUnderTest.setA(true);
		systemUnderTest.setB(false);
		systemUnderTest.setC(true);
		systemUnderTest.setD(false);

		systemUnderTest.step();

		assertFalse(systemUnderTest.getOutput());
	}

	@Test
	public void test_GetOutput_WhenAIsOnAndBIsOffAndCIsOnAndDIsOn_ReturnsOff() {
		systemUnderTest.setA(true);
		systemUnderTest.setB(false);
		systemUnderTest.setC(true);
		systemUnderTest.setD(true);

		systemUnderTest.step();

		assertFalse(systemUnderTest.getOutput());
	}

	@Test
	public void test_GetOutput_WhenAIsOnAndBIsOnAndCIsOffAndDIsOff_ReturnsOff() {
		systemUnderTest.setA(true);
		systemUnderTest.setB(true);
		systemUnderTest.setC(false);
		systemUnderTest.setD(false);

		systemUnderTest.step();

		assertFalse(systemUnderTest.getOutput());
	}

	@Test
	public void test_GetOutput_WhenAIsOnAndBIsOnAndCIsOffAndDIsOn_ReturnsOff() {
		systemUnderTest.setA(true);
		systemUnderTest.setB(true);
		systemUnderTest.setC(false);
		systemUnderTest.setD(true);

		systemUnderTest.step();

		assertFalse(systemUnderTest.getOutput());
	}

	@Test
	public void test_GetOutput_WhenAIsOnAndBIsOnAndCIsOnAndDIsOff_ReturnsOff() {
		systemUnderTest.setA(true);
		systemUnderTest.setB(true);
		systemUnderTest.setC(true);
		systemUnderTest.setD(false);

		systemUnderTest.step();

		assertFalse(systemUnderTest.getOutput());
	}

	@Test
	public void test_GetOutput_WhenAIsOnAndBIsOnAndCIsOnAndDIsOn_ReturnsOn() {
		systemUnderTest.setA(true);
		systemUnderTest.setB(true);
		systemUnderTest.setC(true);
		systemUnderTest.setD(true);

		systemUnderTest.step();

		assertTrue(systemUnderTest.getOutput());
	}

}

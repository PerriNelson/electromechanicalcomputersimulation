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

import electroMechanicalLogic.EightInputSIngleOutputOrGate;
import electroMechanicalLogic.Interfaces.IEightInputSingleOutputOrGate;

public class EightInputSingleOutputOrGateTest {
	private IEightInputSingleOutputOrGate systemUnderTest;

	@Before
	public void setUp() throws Exception {
		systemUnderTest = new EightInputSIngleOutputOrGate();
		systemUnderTest.setPower(true);
		systemUnderTest.setI0(false);
		systemUnderTest.setI1(false);
		systemUnderTest.setI2(false);
		systemUnderTest.setI3(false);
		systemUnderTest.setI4(false);
		systemUnderTest.setI5(false);
		systemUnderTest.setI6(false);
		systemUnderTest.setI7(false);
	}

	@Test
	public void test_GetOutput_WhenAllInputsAreOff_ReturnsOn() {
		systemUnderTest.step();
		assertFalse(systemUnderTest.getOutput());
	}

	@Test
	public void test_GetOutput_WhenI0IsOn_ReturnsOn() {
		systemUnderTest.setI0(true);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getOutput());
	}

	@Test
	public void test_GetOutput_WhenI1IsOn_ReturnsOn() {
		systemUnderTest.setI1(true);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getOutput());
	}

	@Test
	public void test_GetOutput_WhenI2IsOn_ReturnsOn() {
		systemUnderTest.setI2(true);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getOutput());
	}

	@Test
	public void test_GetOutput_WhenI3IsOn_ReturnsOn() {
		systemUnderTest.setI3(true);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getOutput());
	}

	@Test
	public void test_GetOutput_WhenI4IsOn_ReturnsOn() {
		systemUnderTest.setI4(true);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getOutput());
	}

	@Test
	public void test_GetOutput_WhenI5IsOn_ReturnsOn() {
		systemUnderTest.setI5(true);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getOutput());
	}

	@Test
	public void test_GetOutput_WhenI6IsOn_ReturnsOn() {
		systemUnderTest.setI6(true);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getOutput());
	}

	@Test
	public void test_GetOutput_WhenI7IsOn_ReturnsOn() {
		systemUnderTest.setI7(true);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getOutput());
	}

}

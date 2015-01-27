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

import electroMechanicalLogic.EightInputOR;
import electroMechanicalLogic.Interfaces.IEightInputSingleOutputGate;

public class EightInputSingleOutputOrGateTest {
	private IEightInputSingleOutputGate systemUnderTest;

	@Before
	public void setUp() throws Exception {
		systemUnderTest = new EightInputOR();
		systemUnderTest.setPower(true);
		systemUnderTest.setDI0(false);
		systemUnderTest.setDI1(false);
		systemUnderTest.setDI2(false);
		systemUnderTest.setDI3(false);
		systemUnderTest.setDI4(false);
		systemUnderTest.setDI5(false);
		systemUnderTest.setDI6(false);
		systemUnderTest.setDI7(false);
	}

	@Test
	public void test_GetOutput_WhenAllInputsAreOff_ReturnsOn() {
		systemUnderTest.step();
		assertFalse(systemUnderTest.getOutput());
	}

	@Test
	public void test_GetOutput_WhenI0IsOn_ReturnsOn() {
		systemUnderTest.setDI0(true);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getOutput());
	}

	@Test
	public void test_GetOutput_WhenI1IsOn_ReturnsOn() {
		systemUnderTest.setDI1(true);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getOutput());
	}

	@Test
	public void test_GetOutput_WhenI2IsOn_ReturnsOn() {
		systemUnderTest.setDI2(true);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getOutput());
	}

	@Test
	public void test_GetOutput_WhenI3IsOn_ReturnsOn() {
		systemUnderTest.setDI3(true);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getOutput());
	}

	@Test
	public void test_GetOutput_WhenI4IsOn_ReturnsOn() {
		systemUnderTest.setDI4(true);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getOutput());
	}

	@Test
	public void test_GetOutput_WhenI5IsOn_ReturnsOn() {
		systemUnderTest.setDI5(true);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getOutput());
	}

	@Test
	public void test_GetOutput_WhenI6IsOn_ReturnsOn() {
		systemUnderTest.setDI6(true);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getOutput());
	}

	@Test
	public void test_GetOutput_WhenI7IsOn_ReturnsOn() {
		systemUnderTest.setDI7(true);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getOutput());
	}

}

/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */
package electroMechanicalLogic.Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalLogic.Interfaces.ITwoInputSingleOutputGate;

public class TwoInputNOrGateTest {

	private ITwoInputSingleOutputGate systemUnderTest;
 
	@Before
	public void setUp() throws Exception {
		systemUnderTest = new electroMechanicalLogic.TwoInputNOrGate();
	}

	@Test
	public final void test_GetOutput_WhenPowerIsOffAIsOnAndBIsOn_ReturnsFalse() {
		systemUnderTest.setPower(false);
		systemUnderTest.setA(true);
		systemUnderTest.setB(true);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getOutput());
	}

	@Test
	public final void test_GetOutput_WhenPowerIsOnAIsOffAndBIsOff_ReturnsTrue() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(false);
		systemUnderTest.setB(false);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getOutput());
	}

	@Test
	public final void test_GetOutput_WhenPowerIsOnAIsOffAndBIsOn_ReturnsFalse() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(false);
		systemUnderTest.setB(true);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getOutput());
	}

	@Test
	public final void test_GetOutput_WhenPowerIsOnAIsOnAndBIsOff_ReturnsFalse() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(true);
		systemUnderTest.setB(false);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getOutput());
	}

	@Test
	public final void test_GetOutput_WhenPowerIsOnAIsOnAndBIsOn_ReturnsFalse() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(true);
		systemUnderTest.setB(true);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getOutput());
	}

	@Test
	public final void test_SetA_WithoutStep_DoesNotAffectOutput() {
		boolean originalValue = systemUnderTest.getOutput();
		assertFalse("Startup value should be false.", originalValue);
		systemUnderTest.setA(true);
		assertEquals("Value should be unchanged", originalValue,
				systemUnderTest.getOutput());
	}

	@Test
	public final void test_SetB_WithoutStep_DoesNotAffectOutput() {
		boolean originalValue = systemUnderTest.getOutput();
		assertFalse("Startup value should be false.", originalValue);
		systemUnderTest.setB(true);
		assertEquals("Value should be unchanged", originalValue,
				systemUnderTest.getOutput());
	}
}

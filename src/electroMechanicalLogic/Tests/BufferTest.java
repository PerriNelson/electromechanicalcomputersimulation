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

import electroMechanicalLogic.Buffer;
import electroMechanicalLogic.IRelay;

public class BufferTest {

	private IRelay systemUnderTest;

	@Before
	public void setUp() throws Exception {
		systemUnderTest = new Buffer();
	}

	@Test
	public void test_GetInput_ByItself_ReturnsFalse() {
		assertFalse(systemUnderTest.getInput());
	}

	@Test
	public void test_GetOutput_ByItself_ReturnsFalse() {
		assertFalse(systemUnderTest.getOutput());
	}

	@Test
	public void test_GetOutput_WhenPowerAndInputAreOff_ReturnsFalse() {
		systemUnderTest.setPower(false);
		systemUnderTest.setInput(false);
		systemUnderTest.step();
		assertFalse(systemUnderTest.getOutput());
	}

	@Test
	public void test_GetOutput_WhenPowerAndInputAreOn_ReturnsTrue() {
		systemUnderTest.setPower(true);
		systemUnderTest.setInput(true);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getOutput());
	}

	@Test
	public void test_GetOutput_WhenPowerIsOffAndInputIsOn_ReturnsFalse() {
		systemUnderTest.setPower(false);
		systemUnderTest.setInput(true);
		systemUnderTest.step();
		assertFalse(systemUnderTest.getOutput());
	}

	@Test
	public void test_GetOutput_WhenPowerIsOnAndInputIsOff_ReturnsFalse() {
		systemUnderTest.setPower(true);
		systemUnderTest.setInput(false);
		systemUnderTest.step();
		assertFalse(systemUnderTest.getOutput());
	}

	@Test
	public void test_GetPower_ByItself_ReturnsFalse() {
		assertFalse(systemUnderTest.getPower());
	}

	@Test
	public void test_SetInput_WithoutStep_DoesNotAffectRetrievableState() {
		Boolean originalValue = systemUnderTest.getInput();
		systemUnderTest.setInput(!originalValue);
		assertEquals(originalValue, systemUnderTest.getInput());
	}

	@Test
	public void test_SetInput_WithStep_AffectsRetrievableState() {
		Boolean originalValue = systemUnderTest.getInput();
		systemUnderTest.setInput(!originalValue);
		systemUnderTest.step();
		assertEquals(!originalValue, systemUnderTest.getInput());
	}

	@Test
	public void test_SetPower_WithoutStep_DoesNotAffectRetrievableState() {
		Boolean originalValue = systemUnderTest.getPower();
		systemUnderTest.setPower(!originalValue);
		assertEquals(originalValue, systemUnderTest.getPower());
	}

	@Test
	public void test_SetPower_WithStep_AffectsRetrievableState() {
		Boolean originalValue = systemUnderTest.getPower();
		systemUnderTest.setPower(!originalValue);
		systemUnderTest.step();
		assertEquals(!originalValue, systemUnderTest.getPower());
	}

	@Test
	public void test_Step_WhenInputDoesNotChange_DoesNotAffectInput() {
		Boolean originalValue = systemUnderTest.getInput();
		systemUnderTest.step();
		assertEquals(originalValue, systemUnderTest.getInput());

		systemUnderTest.setInput(!originalValue);
		systemUnderTest.step();

		originalValue = systemUnderTest.getInput();
		systemUnderTest.step();
		assertEquals(originalValue, systemUnderTest.getInput());
	}

	@Test
	public void test_Step_WhenPowerDoesNotChange_DoesNotAffectPower() {
		Boolean originalValue = systemUnderTest.getPower();
		systemUnderTest.step();
		assertEquals(originalValue, systemUnderTest.getPower());

		systemUnderTest.setPower(!originalValue);
		systemUnderTest.step();

		originalValue = systemUnderTest.getPower();
		systemUnderTest.step();
		assertEquals(originalValue, systemUnderTest.getPower());
	}
}

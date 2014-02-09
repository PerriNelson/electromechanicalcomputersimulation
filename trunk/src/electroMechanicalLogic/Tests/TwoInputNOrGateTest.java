package electroMechanicalLogic.Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalLogic.ITwoInputSingleOutputGate;

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
		systemUnderTest.setA(!originalValue);
		assertEquals(originalValue, systemUnderTest.getOutput());
	}

	@Test
	public final void test_SetA_WithoutStep_DoesNotAffectRetrievableState() {
		boolean originalValue = systemUnderTest.getA();
		systemUnderTest.setA(!originalValue);
		assertEquals(originalValue, systemUnderTest.getA());
	}

	@Test
	public final void test_SetB_WithoutStep_DoesNotAffectOutput() {
		boolean originalValue = systemUnderTest.getOutput();
		systemUnderTest.setB(!originalValue);
		assertEquals(originalValue, systemUnderTest.getOutput());
	}

	@Test
	public final void test_SetB_WithoutStep_DoesNotAffectRetrievableState() {
		boolean originalValue = systemUnderTest.getB();
		systemUnderTest.setB(!originalValue);
		assertEquals(originalValue, systemUnderTest.getB());
	}

	@Test
	public final void test_SetPower_WithoutStep_DoesNotAffectRetrievableState() {
		boolean originalValue = systemUnderTest.getPower();
		systemUnderTest.setPower(!originalValue);
		assertEquals(originalValue, systemUnderTest.getPower());
	}

	@Test
	public final void test_SetPower_WithStep_ChangesRetrievableState() {
		boolean originalValue = systemUnderTest.getPower();
		systemUnderTest.setPower(!originalValue);
		systemUnderTest.step();
		assertEquals(!originalValue, systemUnderTest.getPower());
	}

}

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

public class HalfAdderTest {

	private electroMechanicalLogic.Interfaces.IHalfAdder systemUnderTest;

	@Before
	public void setUp() throws Exception {
		systemUnderTest = new electroMechanicalLogic.HalfAdder();
	}

	@Test
	public final void test_GetCO_WhenPowerIsOffAndAIsOffAndBIsOff_ReturnsOff() {
		systemUnderTest.setPower(false);
		systemUnderTest.setA(false);
		systemUnderTest.setB(false);
		systemUnderTest.step();
		assertFalse(systemUnderTest.getCO());
	}

	@Test
	public final void test_GetCO_WhenPowerIsOffAndAIsOffAndBIsOn_ReturnsOff() {
		systemUnderTest.setPower(false);
		systemUnderTest.setA(false);
		systemUnderTest.setB(true);
		systemUnderTest.step();
		assertFalse(systemUnderTest.getCO());
	}

	@Test
	public final void test_GetCO_WhenPowerIsOffAndAIsOnAndBIsOff_ReturnsOff() {
		systemUnderTest.setPower(false);
		systemUnderTest.setA(true);
		systemUnderTest.setB(false);
		systemUnderTest.step();
		assertFalse(systemUnderTest.getCO());
	}

	@Test
	public final void test_GetCO_WhenPowerIsOffAndAIsOnAndBIsOn_ReturnsOff() {
		systemUnderTest.setPower(false);
		systemUnderTest.setA(true);
		systemUnderTest.setB(true);
		systemUnderTest.step();
		assertFalse(systemUnderTest.getCO());
	}

	@Test
	public final void test_GetCO_WhenPowerIsOnAndAIsOffAndBIsOff_ReturnsOff() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(false);
		systemUnderTest.setB(false);
		systemUnderTest.step();
		assertFalse(systemUnderTest.getCO());
	}

	@Test
	public final void test_GetCO_WhenPowerIsOnAndAIsOffAndBIsOn_ReturnsOff() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(false);
		systemUnderTest.setB(true);
		systemUnderTest.step();
		assertFalse(systemUnderTest.getCO());
	}

	@Test
	public final void test_GetCO_WhenPowerIsOnAndAIsOnAndBIsOff_ReturnsOff() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(true);
		systemUnderTest.setB(false);
		systemUnderTest.step();
		assertFalse(systemUnderTest.getCO());
	}

	@Test
	public final void test_GetCO_WhenPowerIsOnAndAIsOnAndBIsOn_ReturnsOn() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(true);
		systemUnderTest.setB(true);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getCO());
	}

	@Test
	public final void test_GetS_WhenPowerIsOffAndAIsOffAndBIsOff_ReturnsOff() {
		systemUnderTest.setPower(false);
		systemUnderTest.setA(false);
		systemUnderTest.setB(false);
		systemUnderTest.step();
		assertFalse(systemUnderTest.getS());
	}

	@Test
	public final void test_GetS_WhenPowerIsOffAndAIsOffAndBIsOn_ReturnsOff() {
		systemUnderTest.setPower(false);
		systemUnderTest.setA(false);
		systemUnderTest.setB(true);
		systemUnderTest.step();
		assertFalse(systemUnderTest.getS());
	}

	@Test
	public final void test_GetS_WhenPowerIsOffAndAIsOnAndBIsOff_ReturnsOff() {
		systemUnderTest.setPower(false);
		systemUnderTest.setA(true);
		systemUnderTest.setB(false);
		systemUnderTest.step();
		assertFalse(systemUnderTest.getS());
	}

	@Test
	public final void test_GetS_WhenPowerIsOffAndAIsOnAndBIsOn_ReturnsOff() {
		systemUnderTest.setPower(false);
		systemUnderTest.setA(true);
		systemUnderTest.setB(true);
		systemUnderTest.step();
		assertFalse(systemUnderTest.getS());
	}

	@Test
	public final void test_GetS_WhenPowerIsOnAndAIsOffAndBIsOff_ReturnsOff() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(false);
		systemUnderTest.setB(false);
		systemUnderTest.step();
		assertFalse(systemUnderTest.getS());
	}

	@Test
	public final void test_GetS_WhenPowerIsOnAndAIsOffAndBIsOn_ReturnsOn() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(false);
		systemUnderTest.setB(true);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getS());
	}

	@Test
	public final void test_GetS_WhenPowerIsOnAndAIsOnAndBIsOff_ReturnsOn() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(true);
		systemUnderTest.setB(false);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getS());
	}

	@Test
	public final void test_GetS_WhenPowerIsOnAndAIsOnAndBIsOn_ReturnsOff() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(true);
		systemUnderTest.setB(true);
		systemUnderTest.step();
		assertFalse(systemUnderTest.getS());
	}

	@Test
	public final void test_SetA_WithoutStep_DoesNotAffectCarryOut() {
		systemUnderTest.setPower(true);
		final boolean originalValue = systemUnderTest.getCO();
		systemUnderTest.setA(true);
		assertEquals(originalValue, systemUnderTest.getCO());
		systemUnderTest.setA(false);
		assertEquals(originalValue, systemUnderTest.getCO());
	}

	@Test
	public final void test_SetA_WithoutStep_DoesNotAffectSum() {
		systemUnderTest.setPower(true);
		final boolean originalValue = systemUnderTest.getS();
		systemUnderTest.setA(true);
		assertEquals(originalValue, systemUnderTest.getS());
		systemUnderTest.setA(false);
		assertEquals(originalValue, systemUnderTest.getS());
	}

	@Test
	public final void test_SetB_WithoutStep_DoesNotAffectCarryOut() {
		systemUnderTest.setPower(true);
		final boolean originalValue = systemUnderTest.getCO();
		systemUnderTest.setB(true);
		assertEquals(originalValue, systemUnderTest.getCO());
		systemUnderTest.setB(false);
		assertEquals(originalValue, systemUnderTest.getCO());
	}

	@Test
	public final void test_SetB_WithoutStep_DoesNotAffectSum() {
		systemUnderTest.setPower(true);
		final boolean originalValue = systemUnderTest.getS();
		systemUnderTest.setB(true);
		assertEquals(originalValue, systemUnderTest.getS());
		systemUnderTest.setB(false);
		assertEquals(originalValue, systemUnderTest.getS());
	}

}

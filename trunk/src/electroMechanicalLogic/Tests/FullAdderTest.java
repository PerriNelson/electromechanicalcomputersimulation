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

import electroMechanicalLogic.Interfaces.IFullAdder;

public class FullAdderTest {

	private IFullAdder systemUnderTest;

	@Before
	public void setUp() throws Exception {
		systemUnderTest = new electroMechanicalLogic.FullAdder();
	}
 
	@Test
	public final void test_GetCO_WhenPowerIsOffAndAIsOffAndBIsOffAndCIIsOff_ReturnsOff() {
		systemUnderTest.setPower(false);
		systemUnderTest.setA(false);
		systemUnderTest.setB(false);
		systemUnderTest.setCI(false);
		systemUnderTest.step();
		assertFalse(systemUnderTest.getCO());
	}

	@Test
	public final void test_GetCO_WhenPowerIsOffAndAIsOffAndBIsOffAndCIIsOn_ReturnsOff() {
		systemUnderTest.setPower(false);
		systemUnderTest.setA(false);
		systemUnderTest.setB(false);
		systemUnderTest.setCI(true);
		systemUnderTest.step();
		assertFalse(systemUnderTest.getCO());
	}

	@Test
	public final void test_GetCO_WhenPowerIsOffAndAIsOffAndBIsOnAndCIIsOff_ReturnsOff() {
		systemUnderTest.setPower(false);
		systemUnderTest.setA(false);
		systemUnderTest.setB(true);
		systemUnderTest.setCI(false);
		systemUnderTest.step();
		assertFalse(systemUnderTest.getCO());
	}

	@Test
	public final void test_GetCO_WhenPowerIsOffAndAIsOffAndBIsOnAndCIIsOn_ReturnsOff() {
		systemUnderTest.setPower(false);
		systemUnderTest.setA(false);
		systemUnderTest.setB(true);
		systemUnderTest.setCI(true);
		systemUnderTest.step();
		assertFalse(systemUnderTest.getCO());
	}

	@Test
	public final void test_GetCO_WhenPowerIsOffAndAIsOnAndBIsOffAndCIIsOff_ReturnsOff() {
		systemUnderTest.setPower(false);
		systemUnderTest.setA(true);
		systemUnderTest.setB(false);
		systemUnderTest.setCI(false);
		systemUnderTest.step();
		assertFalse(systemUnderTest.getCO());
	}

	@Test
	public final void test_GetCO_WhenPowerIsOffAndAIsOnAndBIsOffAndCIIsOn_ReturnsOff() {
		systemUnderTest.setPower(false);
		systemUnderTest.setA(true);
		systemUnderTest.setB(false);
		systemUnderTest.setCI(true);
		systemUnderTest.step();
		assertFalse(systemUnderTest.getCO());
	}

	@Test
	public final void test_GetCO_WhenPowerIsOffAndAIsOnAndBIsOnAndCIIsOff_ReturnsOff() {
		systemUnderTest.setPower(false);
		systemUnderTest.setA(true);
		systemUnderTest.setB(true);
		systemUnderTest.setCI(false);
		systemUnderTest.step();
		assertFalse(systemUnderTest.getCO());
	}

	@Test
	public final void test_GetCO_WhenPowerIsOffAndAIsOnAndBIsOonAndCIIsOn_ReturnsOff() {
		systemUnderTest.setPower(false);
		systemUnderTest.setA(true);
		systemUnderTest.setB(true);
		systemUnderTest.setCI(true);
		systemUnderTest.step();
		assertFalse(systemUnderTest.getCO());
	}

	@Test
	public final void test_GetCO_WhenPowerIsOnAndAIsOffAndBIsOffAndCIIsOff_ReturnsOff() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(false);
		systemUnderTest.setB(false);
		systemUnderTest.setCI(false);
		systemUnderTest.step();
		assertFalse(systemUnderTest.getCO());
	}

	@Test
	public final void test_GetCO_WhenPowerIsOnAndAIsOffAndBIsOffAndCIIsOn_ReturnsOff() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(false);
		systemUnderTest.setB(false);
		systemUnderTest.setCI(true);
		systemUnderTest.step();
		assertFalse(systemUnderTest.getCO());
	}

	@Test
	public final void test_GetCO_WhenPowerIsOnAndAIsOffAndBIsOnAndCIIsOff_ReturnsOff() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(false);
		systemUnderTest.setB(true);
		systemUnderTest.setCI(false);
		systemUnderTest.step();
		assertFalse(systemUnderTest.getCO());
	}

	@Test
	public final void test_GetCO_WhenPowerIsOnAndAIsOffAndBIsOnAndCIIsOn_ReturnsOn() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(false);
		systemUnderTest.setB(true);
		systemUnderTest.setCI(true);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getCO());
	}

	@Test
	public final void test_GetCO_WhenPowerIsOnAndAIsOnAndBIsOffAndCIIsOff_ReturnsOff() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(true);
		systemUnderTest.setB(false);
		systemUnderTest.setCI(false);
		systemUnderTest.step();
		assertFalse(systemUnderTest.getCO());
	}

	@Test
	public final void test_GetCO_WhenPowerIsOnAndAIsOnAndBIsOffAndCIIsOn_ReturnsOn() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(true);
		systemUnderTest.setB(false);
		systemUnderTest.setCI(true);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getCO());
	}

	@Test
	public final void test_GetCO_WhenPowerIsOnAndAIsOnAndBIsOnAndCIIsOff_ReturnsOn() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(true);
		systemUnderTest.setB(true);
		systemUnderTest.setCI(false);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getCO());
	}

	@Test
	public final void test_GetCO_WhenPowerIsOnAndAIsOnAndBIsOonAndCIIsOn_ReturnsOn() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(true);
		systemUnderTest.setB(true);
		systemUnderTest.setCI(true);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getCO());
	}

	@Test
	public final void test_GetS_WhenPowerIsOffAndAIsOffAndBIsOffAndCIIsOff_ReturnsOff() {
		systemUnderTest.setPower(false);
		systemUnderTest.setA(false);
		systemUnderTest.setB(false);
		systemUnderTest.setCI(false);
		systemUnderTest.step();
		assertFalse(systemUnderTest.getS());
	}

	@Test
	public final void test_GetS_WhenPowerIsOffAndAIsOffAndBIsOffAndCIIsOn_ReturnsOff() {
		systemUnderTest.setPower(false);
		systemUnderTest.setA(false);
		systemUnderTest.setB(false);
		systemUnderTest.setCI(true);
		systemUnderTest.step();
		assertFalse(systemUnderTest.getS());
	}

	@Test
	public final void test_GetS_WhenPowerIsOffAndAIsOffAndBIsOnAndCIIsOff_ReturnsOff() {
		systemUnderTest.setPower(false);
		systemUnderTest.setA(false);
		systemUnderTest.setB(true);
		systemUnderTest.setCI(false);
		systemUnderTest.step();
		assertFalse(systemUnderTest.getS());
	}

	@Test
	public final void test_GetS_WhenPowerIsOffAndAIsOffAndBIsOnAndCIIsOn_ReturnsOff() {
		systemUnderTest.setPower(false);
		systemUnderTest.setA(false);
		systemUnderTest.setB(true);
		systemUnderTest.setCI(true);
		systemUnderTest.step();
		assertFalse(systemUnderTest.getS());
	}

	@Test
	public final void test_GetS_WhenPowerIsOffAndAIsOnAndBIsOffAndCIIsOff_ReturnsOff() {
		systemUnderTest.setPower(false);
		systemUnderTest.setA(true);
		systemUnderTest.setB(false);
		systemUnderTest.setCI(false);
		systemUnderTest.step();
		assertFalse(systemUnderTest.getS());
	}

	@Test
	public final void test_GetS_WhenPowerIsOffAndAIsOnAndBIsOffAndCIIsOn_ReturnsOff() {
		systemUnderTest.setPower(false);
		systemUnderTest.setA(true);
		systemUnderTest.setB(false);
		systemUnderTest.setCI(true);
		systemUnderTest.step();
		assertFalse(systemUnderTest.getS());
	}

	@Test
	public final void test_GetS_WhenPowerIsOffAndAIsOnAndBIsOnAndCIIsOff_ReturnsOff() {
		systemUnderTest.setPower(false);
		systemUnderTest.setA(true);
		systemUnderTest.setB(true);
		systemUnderTest.setCI(false);
		systemUnderTest.step();
		assertFalse(systemUnderTest.getS());
	}

	@Test
	public final void test_GetS_WhenPowerIsOffAndAIsOnAndBIsOonAndCIIsOn_ReturnsOff() {
		systemUnderTest.setPower(false);
		systemUnderTest.setA(true);
		systemUnderTest.setB(true);
		systemUnderTest.setCI(true);
		systemUnderTest.step();
		assertFalse(systemUnderTest.getS());
	}

	@Test
	public final void test_GetS_WhenPowerIsOnAndAIsOffAndBIsOffAndCIIsOff_ReturnsOff() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(false);
		systemUnderTest.setB(false);
		systemUnderTest.setCI(false);
		systemUnderTest.step();
		assertFalse(systemUnderTest.getS());
	}

	@Test
	public final void test_GetS_WhenPowerIsOnAndAIsOffAndBIsOffAndCIIsOn_ReturnsOn() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(false);
		systemUnderTest.setB(false);
		systemUnderTest.setCI(true);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getS());
	}

	@Test
	public final void test_GetS_WhenPowerIsOnAndAIsOffAndBIsOnAndCIIsOff_ReturnsOn() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(false);
		systemUnderTest.setB(true);
		systemUnderTest.setCI(false);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getS());
	}

	@Test
	public final void test_GetS_WhenPowerIsOnAndAIsOffAndBIsOnAndCIIsOn_ReturnsOff() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(false);
		systemUnderTest.setB(true);
		systemUnderTest.setCI(true);
		systemUnderTest.step();
		assertFalse(systemUnderTest.getS());
	}

	@Test
	public final void test_GetS_WhenPowerIsOnAndAIsOnAndBIsOffAndCIIsOff_ReturnsOn() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(true);
		systemUnderTest.setB(false);
		systemUnderTest.setCI(false);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getS());
	}

	@Test
	public final void test_GetS_WhenPowerIsOnAndAIsOnAndBIsOffAndCIIsOn_ReturnsOff() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(true);
		systemUnderTest.setB(false);
		systemUnderTest.setCI(true);
		systemUnderTest.step();
		assertFalse(systemUnderTest.getS());
	}

	@Test
	public final void test_GetS_WhenPowerIsOnAndAIsOnAndBIsOnAndCIIsOff_ReturnsOff() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(true);
		systemUnderTest.setB(true);
		systemUnderTest.setCI(false);
		systemUnderTest.step();
		assertFalse(systemUnderTest.getS());
	}

	@Test
	public final void test_GetS_WhenPowerIsOnAndAIsOnAndBIsOonAndCIIsOn_ReturnsOn() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(true);
		systemUnderTest.setB(true);
		systemUnderTest.setCI(true);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getS());
	}

}

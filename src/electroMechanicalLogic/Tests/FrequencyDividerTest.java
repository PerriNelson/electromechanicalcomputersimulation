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

import electroMechanicalLogic.FrequencyDivider;
import electroMechanicalLogic.Interfaces.IFrequencyDivider;

public class FrequencyDividerTest {

	private IFrequencyDivider systemUnderTest;

	@Before
	public void setUp() throws Exception {
		systemUnderTest = new FrequencyDivider();
		systemUnderTest.setPower(true);
		systemUnderTest.step();
	}

	@Test
	public final void test_GetQ_AtStartOfSecondClockCycle_ReturnsOn() {
		systemUnderTest.setClk(true);
		systemUnderTest.step();
		systemUnderTest.setClk(false);
		systemUnderTest.step();
		systemUnderTest.setClk(true);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getQ());
	}

	@Test
	public final void test_GetQ_AtStartOfThirdClockCycle_ReturnsOff() {
		systemUnderTest.setClk(true);
		systemUnderTest.step();
		systemUnderTest.setClk(false);
		systemUnderTest.step();
		systemUnderTest.setClk(true);
		systemUnderTest.step();
		systemUnderTest.setClk(false);
		systemUnderTest.step();
		systemUnderTest.setClk(true);
		systemUnderTest.step();
		assertFalse(systemUnderTest.getQ());
	}

	@Test
	public final void test_GetQ_WhenGivenOneClockCycle_ReturnsOff() {
		systemUnderTest.setClk(true);
		systemUnderTest.step();
		assertFalse(systemUnderTest.getQ());
		systemUnderTest.setClk(false);
		systemUnderTest.step();
		assertFalse(systemUnderTest.getQ());
	}

	@Test
	public final void test_GetQ_WhenGivenTwoClockCycles_ReturnsOn() {
		systemUnderTest.setClk(true);
		systemUnderTest.step();
		systemUnderTest.setClk(false);
		systemUnderTest.step();
		systemUnderTest.setClk(true);
		systemUnderTest.step();
		systemUnderTest.setClk(false);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getQ());
	}

	@Test
	public final void test_GetQ_WhenInitialized_ReturnsOff() {
		assertFalse(systemUnderTest.getQ());
	}

	@Test
	public final void test_QBarIsAlwasOppositeQ_ThroughTwoCycles() {
		systemUnderTest.setClk(true);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getQ() != systemUnderTest.getQBar());
		systemUnderTest.setClk(false);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getQ() != systemUnderTest.getQBar());
		systemUnderTest.setClk(true);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getQ() != systemUnderTest.getQBar());
		systemUnderTest.setClk(false);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getQ() != systemUnderTest.getQBar());
		systemUnderTest.setClk(true);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getQ() != systemUnderTest.getQBar());
	}
}

/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.FlipFlops.Tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalLogic.FlipFlops.EdgeTriggeredDTypeFlipFlop;
import electroMechanicalLogic.FlipFlops.Interfaces.IDTypeFlipFlop;

public class EdgeTriggeredDTypeFlipFlopTest {

	IDTypeFlipFlop systemUnderTest;

	@Before
	public void setUp() throws Exception {
		systemUnderTest = new EdgeTriggeredDTypeFlipFlop();
		systemUnderTest.setPower(true);
		systemUnderTest.step();
	}

	@Test
	public final void test_GetQ_WhenClockAndDataBothTransistionToTrue_ReturnsFalse() {
		systemUnderTest.setD(false);
		systemUnderTest.setClk(false);
		systemUnderTest.step();

		systemUnderTest.setD(true);
		systemUnderTest.setClk(true);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getQ());
	}

	@Test
	public void test_GetQ_WhenClockIsOnAndDataIsOff_ReturnsOff() {
		systemUnderTest.setD(false);
		systemUnderTest.setClk(true);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getQ());
	}

	@Test
	public void test_GetQ_WhenClockIsOnAndDataIsToggled_DoesNotChange() {
		systemUnderTest.setD(true);
		systemUnderTest.step();
		systemUnderTest.setClk(true);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getQ());

		systemUnderTest.setD(false);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getQ());
	}

	@Test
	public void test_GetQ_WhenDataIsOnAndClockTransitionsToOn_ReturnsOn() {
		systemUnderTest.setD(true);
		systemUnderTest.setClk(false);
		systemUnderTest.step();
		systemUnderTest.setClk(true);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getQ());
	}

	@Test
	public void test_GetQBar_WhenClockAndDataBothTransistionToTrue_ReturnsTrue() {
		systemUnderTest.setD(false);
		systemUnderTest.setClk(false);
		systemUnderTest.step();

		systemUnderTest.setD(true);
		systemUnderTest.setClk(true);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getQBar());
	}

	@Test
	public void test_GetQBar_WhenClockIsOnAndDataIsOff_ReturnsOn() {
		systemUnderTest.setD(false);
		systemUnderTest.setClk(true);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getQBar());
	}

	@Test
	public void test_GetQBar_WhenClockIsOnAndDataIsToggled_DoesNotChange() {
		systemUnderTest.setD(true);
		systemUnderTest.step();
		systemUnderTest.setClk(true);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getQBar());

		systemUnderTest.setD(false);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getQBar());
	}

	@Test
	public void test_GetQBar_WhenDataIsOnAndClockTransitionsToOn_ReturnsOff() {
		systemUnderTest.setD(true);
		systemUnderTest.setClk(false);
		systemUnderTest.step();
		systemUnderTest.setClk(true);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getQBar());
	}

}

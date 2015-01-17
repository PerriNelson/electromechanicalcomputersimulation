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

import electroMechanicalLogic.LevelTriggeredDTypeFlipFlopWithClear;
import electroMechanicalLogic.Interfaces.IDTypeFlipFlopWithClear;

public class LevelTriggeredDTypeFlipFlopWithClearTest {
	private IDTypeFlipFlopWithClear systemUnderTest;

	@Before
	public void setUp() throws Exception {
		systemUnderTest = new LevelTriggeredDTypeFlipFlopWithClear();
		systemUnderTest.setPower(true);
	}
 
	@Test
	public final void test_GetQ_WhenClockIsOnAndDataIsOff_ReturnsOff() {
		systemUnderTest.setD(false);
		systemUnderTest.setClk(true);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getQ());
	}

	@Test
	public final void test_GetQ_WhenClockIsOnAndDataIsOn_ReturnsOn() {
		systemUnderTest.setD(true);
		systemUnderTest.setClk(true);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getQ());
	}

	@Test
	public final void test_GetQ_WhenClockIsOnAndDataIsOnAndClearIsOn_ReturnsOff() {
		systemUnderTest.setD(true);
		systemUnderTest.setClk(true);
		systemUnderTest.setClear(true);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getQ());
	}

	@Test
	public final void test_GetQ_WhenClockIsOnAndDataIsToggled_Toggles() {
		systemUnderTest.setD(true);
		systemUnderTest.setClk(true);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getQ());

		systemUnderTest.setD(false);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getQ());
	}

	@Test
	public final void test_GetQ_WhenClockIsToggledAndDataIsOff_ReturnsOff() {
		systemUnderTest.setD(false);
		systemUnderTest.setClk(true);
		systemUnderTest.step();

		systemUnderTest.setClk(false);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getQ());
	}

	@Test
	public final void test_GetQ_WhenUnitialized_Returnsff() {
		systemUnderTest.step();

		assertFalse(systemUnderTest.getQ());
	}

	@Test
	public final void test_GetQBar_WhenClockIsOnAndDataIsOff_ReturnsOn() {
		systemUnderTest.setD(false);
		systemUnderTest.setClk(true);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getQBar());
	}

	@Test
	public final void test_GetQBar_WhenClockIsOnAndDataIsOn_ReturnsOff() {
		systemUnderTest.setD(true);
		systemUnderTest.setClk(true);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getQBar());
	}

	@Test
	public final void test_GetQBar_WhenClockIsOnAndDataIsToggled_Toggles() {
		systemUnderTest.setD(true);
		systemUnderTest.setClk(true);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getQBar());

		systemUnderTest.setD(false);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getQBar());

	}

	@Test
	public final void test_GetQBar_WhenClockIsToggledAndDataIsOff_ReturnsOn() {
		systemUnderTest.setD(false);
		systemUnderTest.setClk(true);
		systemUnderTest.step();

		systemUnderTest.setClk(false);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getQBar());
	}

	@Test
	public final void test_GetQBar_WhenClockIsToggledAndDataIsOn_ReturnsOff() {
		systemUnderTest.setD(true);
		systemUnderTest.setClk(true);
		systemUnderTest.step();
		systemUnderTest.setClk(false);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getQBar());
	}

	@Test
	public final void test_GetQBar_WhenClockIsToggledAndDataIsOn_ReturnsOn() {
		systemUnderTest.setD(true);
		systemUnderTest.setClk(true);
		systemUnderTest.step();
		systemUnderTest.setClk(false);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getQ());
	}

	@Test
	public final void test_GetQBar_WhenUnitialized_ReturnsOff() {
		systemUnderTest.step();

		assertFalse(systemUnderTest.getQBar());
	}

}

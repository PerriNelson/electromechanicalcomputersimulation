/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalLogic.EdgeTriggeredDTypeFlipFlopWithPresetAndClear;
import electroMechanicalLogic.Interfaces.IDTypeFlipFlopWithPresetAndClear;

public class EdgeTriggeredDTypeFlipFlopWithPresetAndClearTest {
	private static final boolean on = true;
	private static final boolean off = false;
	IDTypeFlipFlopWithPresetAndClear systemUnderTest;

	@Before
	public void setUp() throws Exception {
		systemUnderTest = new EdgeTriggeredDTypeFlipFlopWithPresetAndClear();
		systemUnderTest.setPower(on);
		systemUnderTest.setPreset(off);
		systemUnderTest.setClear(off);
		systemUnderTest.setD(off);
		systemUnderTest.setClk(off);
		systemUnderTest.step();
	}

	@Test
	public final void test_GetQ_WhenAllInputsAreOff_ReturnsOff() {
		systemUnderTest.setClk(on);
		systemUnderTest.step();
		systemUnderTest.setClk(off);
		systemUnderTest.step();
		assertEquals(off, systemUnderTest.getQ());
	}

	@Test
	public final void test_GetQ_WhenClearIsOn_ReturnsOff() {
		systemUnderTest.setClear(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getQ());
	}

	@Test
	public final void test_GetQ_WhenClearTransitionsToOff_ReturnsOff() {
		systemUnderTest.setClear(on);
		systemUnderTest.step();
		systemUnderTest.setClear(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getQ());
	}

	@Test
	public final void test_GetQ_WhenClockIsOnAndDTransitionsToOn_ReturnsOff() {
		systemUnderTest.setClk(on);
		systemUnderTest.step();
		systemUnderTest.setD(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getQ());
	}

	@Test
	public final void test_GetQ_WhenDIsOnAndClockTransitionsToOn_ReturnsOn() {
		systemUnderTest.setD(on);
		systemUnderTest.step();
		systemUnderTest.setClk(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getQ());
	}

	@Test
	public final void test_GetQ_WhenDTurnsOffAndClockTurnsOn_ReturnsOff() {
		systemUnderTest.setD(on);
		systemUnderTest.step();
		systemUnderTest.setClk(on);
		systemUnderTest.step();
		systemUnderTest.setD(off);
		systemUnderTest.setClk(off);
		systemUnderTest.step();
		systemUnderTest.setClk(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getQ());
	}

	@Test
	public final void test_GetQ_WhenPresetIsOn_ReturnsOn() {
		systemUnderTest.setPreset(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getQ());
	}

	@Test
	public final void test_GetQ_WhenPresetTransitionsToOff_ReturnsOn() {
		systemUnderTest.setPreset(on);
		systemUnderTest.step();
		systemUnderTest.setPreset(off);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getQ());
	}

	@Test
	public final void test_GetQBar_WhenAllInputsAreOff_ReturnsOn() {
		systemUnderTest.setClk(on);
		systemUnderTest.step();
		systemUnderTest.setClk(off);
		systemUnderTest.step();
		assertEquals(on, systemUnderTest.getQBar());
	}

	@Test
	public final void test_GetQBar_WhenClearIsOn_ReturnsOn() {
		systemUnderTest.setClear(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getQBar());
	}

	@Test
	public final void test_GetQBar_WhenClearTransitionsToOff_ReturnsOn() {
		systemUnderTest.setClear(on);
		systemUnderTest.step();
		systemUnderTest.setClear(off);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getQBar());
	}

	@Test
	public final void test_GetQBar_WhenClockIsOnAndDTransitionsToOn_ReturnsOn() {
		systemUnderTest.setClk(on);
		systemUnderTest.step();
		systemUnderTest.setD(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getQBar());
	}

	@Test
	public final void test_GetQBar_WhenDIsOnAndClockTransitionsToOn_ReturnsOff() {
		systemUnderTest.setD(on);
		systemUnderTest.step();
		systemUnderTest.setClk(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getQBar());
	}

	@Test
	public final void test_GetQBar_WhenDTurnsOffAndClockTurnsOn_ReturnsOn() {
		systemUnderTest.setD(on);
		systemUnderTest.step();
		systemUnderTest.setClk(on);
		systemUnderTest.step();
		systemUnderTest.setD(off);
		systemUnderTest.setClk(off);
		systemUnderTest.step();
		systemUnderTest.setClk(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getQBar());
	}

	@Test
	public final void test_GetQBar_WhenPresetIsOn_ReturnsOff() {
		systemUnderTest.setPreset(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getQBar());
	}

	@Test
	public final void test_GetQBar_WhenPresetTransitionsToOff_ReturnsOff() {
		systemUnderTest.setPreset(on);
		systemUnderTest.step();
		systemUnderTest.setPreset(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getQBar());
	}
}

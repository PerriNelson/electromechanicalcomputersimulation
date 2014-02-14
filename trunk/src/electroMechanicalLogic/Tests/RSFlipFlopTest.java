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

import electroMechanicalLogic.RSFlipFlop;
import electroMechanicalLogic.Interfaces.IRSFlipFlop;

public class RSFlipFlopTest {

	private IRSFlipFlop systemUnderTest;

	@Before
	public void setUp() throws Exception {
		systemUnderTest = new RSFlipFlop();
		systemUnderTest.setPower(true);
	}

	@Test
	public void test_GetQ_WhenReset_ReturnsOff() {
		systemUnderTest.setR(true);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getQ());
	}

	@Test
	public void test_GetQ_WhenResetAndResetTurnedOff_RemainsOff() {
		systemUnderTest.setR(true);
		systemUnderTest.step();
		systemUnderTest.setR(false);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getQ());
	}

	@Test
	public void test_GetQ_WhenSet_ReturnsOn() {
		systemUnderTest.setS(true);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getQ());
	}

	@Test
	public void test_GetQ_WhenSetAndReSetTogether_ReturnsOff() {
		systemUnderTest.setS(true);
		systemUnderTest.setR(true);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getQ());
	}

	@Test
	public void test_GetQ_WhenSetAndSetTurnedOff_RemainsOn() {
		systemUnderTest.setS(true);
		systemUnderTest.step();
		systemUnderTest.setS(false);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getQ());
	}

	@Test
	public void test_GetQ_WhenUninitialized_ReturnsOff() {
		systemUnderTest.step();

		assertFalse(systemUnderTest.getQ());
	}

	@Test
	public void test_GetQBar_WhenReset_ReturnsOn() {
		systemUnderTest.setR(true);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getQBar());
	}

	@Test
	public void test_GetQBar_WhenResetAndResetTurnedOff_RemainsOn() {
		systemUnderTest.setR(true);
		systemUnderTest.step();
		systemUnderTest.setR(false);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getQBar());
	}

	@Test
	public void test_GetQBar_WhenSet_ReturnsOff() {
		systemUnderTest.setS(true);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getQBar());
	}

	@Test
	public void test_GetQBar_WhenSetAndReSetTogether_ReturnsOff() {
		systemUnderTest.setS(true);
		systemUnderTest.setR(true);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getQBar());
	}

	@Test
	public void test_GetQBar_WhenSetAndSetTurnedOff_RemainsOff() {
		systemUnderTest.setS(true);
		systemUnderTest.step();
		systemUnderTest.setS(false);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getQBar());
	}

	@Test
	public void test_GetQBar_WhenUninitialized_ReturnsOff() {
		systemUnderTest.step();

		assertFalse(systemUnderTest.getQBar());
	}

	@Test
	public void test_WhenSetOrReset_QIsNotEqualToQBar() {
		systemUnderTest.setR(false);
		systemUnderTest.setS(true);
		systemUnderTest.step();
		assertFalse(systemUnderTest.getQ() == systemUnderTest.getQBar());
		systemUnderTest.setR(true);
		systemUnderTest.setS(false);
		systemUnderTest.step();
		assertFalse(systemUnderTest.getQ() == systemUnderTest.getQBar());
	}

}

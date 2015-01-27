/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */
package electroMechanicalLogic.Adders.Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalLogic.Adders.HalfAdder;
import electroMechanicalLogic.Adders.Interfaces.IHalfAdder;

public class TestHalfAdder {

	protected IHalfAdder systemUnderTest;

	@Before
	public void setUp() throws Exception {
		systemUnderTest = new HalfAdder();
	}

	@Test
	public final void testCO_shouldBeOff_whenPowerIsOffAndBothInputsAreOff() {
		systemUnderTest.setPower(false);
		systemUnderTest.setA(false);
		systemUnderTest.setB(false);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getCO());
	}

	@Test
	public final void testCO_shouldBeOff_whenPowerIsOffAndBothInputsAreOn() {
		systemUnderTest.setPower(false);
		systemUnderTest.setA(true);
		systemUnderTest.setB(true);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getCO());
	}

	@Test
	public final void testCO_shouldBeOff_whenPowerIsOffAndOnlyAIsOn() {
		systemUnderTest.setPower(false);
		systemUnderTest.setA(true);
		systemUnderTest.setB(false);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getCO());
	}

	@Test
	public final void testCO_shouldBeOff_whenPowerIsOffAndOnlyBIsOn() {
		systemUnderTest.setPower(false);
		systemUnderTest.setA(false);
		systemUnderTest.setB(true);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getCO());
	}

	@Test
	public final void testCO_shouldBeOff_whenPowerIsOnAndBothInputsAreOff() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(false);
		systemUnderTest.setB(false);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getCO());
	}

	@Test
	public final void testCO_shouldBeOff_whenPowerIsOnAndOnlyAIsOn() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(true);
		systemUnderTest.setB(false);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getCO());
	}

	@Test
	public final void testCO_shouldBeOff_whenPowerIsOnAndOnlyBIsOn() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(false);
		systemUnderTest.setB(true);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getCO());
	}

	@Test
	public final void testCO_shouldBeOn_whenPowerIsOnAndBothInputsAreOn() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(true);
		systemUnderTest.setB(true);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getCO());
	}

	@Test
	public final void testCO_shouldNotChange_whenTurningAOffWithoutCallingStep() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(true);
		systemUnderTest.setB(true);
		systemUnderTest.step();
		final boolean originalValue = systemUnderTest.getCO();

		systemUnderTest.setA(false);

		assertEquals(originalValue, systemUnderTest.getCO());
	}

	@Test
	public final void testCO_shouldNotChange_whenTurningAOnWithoutCallingStep() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(false);
		systemUnderTest.setB(true);
		systemUnderTest.step();
		final boolean originalValue = systemUnderTest.getCO();

		systemUnderTest.setA(true);

		assertEquals(originalValue, systemUnderTest.getCO());
	}

	@Test
	public final void testCO_shouldNotChange_whenTurningBOffWithoutCallingStep() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(true);
		systemUnderTest.setB(true);
		systemUnderTest.step();
		final boolean originalValue = systemUnderTest.getCO();

		systemUnderTest.setB(false);

		assertEquals(originalValue, systemUnderTest.getCO());
	}

	@Test
	public final void testCO_shouldNotChange_whenTurningBOnWithoutCallingStep() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(true);
		systemUnderTest.setB(false);
		systemUnderTest.step();
		final boolean originalValue = systemUnderTest.getCO();

		systemUnderTest.setB(true);

		assertEquals(originalValue, systemUnderTest.getCO());
	}

	@Test
	public final void testS_shouldBeOff_whenPowerIsOffAndBothInputsAreOff() {
		systemUnderTest.setPower(false);
		systemUnderTest.setA(false);
		systemUnderTest.setB(false);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getS());
	}

	@Test
	public final void testS_shouldBeOff_whenPowerIsOffAndBothInputsAreOn() {
		systemUnderTest.setPower(false);
		systemUnderTest.setA(true);
		systemUnderTest.setB(true);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getS());
	}

	@Test
	public final void testS_shouldBeOff_whenPowerIsOffAndOnlyAIsOn() {
		systemUnderTest.setPower(false);
		systemUnderTest.setA(true);
		systemUnderTest.setB(false);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getS());
	}

	@Test
	public final void testS_shouldBeOff_whenPowerIsOffAndOnlyBIsOn() {
		systemUnderTest.setPower(false);
		systemUnderTest.setA(false);
		systemUnderTest.setB(true);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getS());
	}

	@Test
	public final void testS_shouldBeOff_WhenPowerIsOnAndBothInputsAreOff() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(false);
		systemUnderTest.setB(false);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getS());
	}

	@Test
	public final void testS_shouldBeOff_WhenPowerIsOnAndBothInputsAreOn() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(true);
		systemUnderTest.setB(true);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getS());
	}

	@Test
	public final void testS_shouldBeOn_whenPowerIsOnAndOnlyAIsOn() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(true);
		systemUnderTest.setB(false);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getS());
	}

	@Test
	public final void testS_shouldBeOn_whenPowerIsOnAndOnlyBIsOn() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(false);
		systemUnderTest.setB(true);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getS());
	}

	@Test
	public final void testS_shouldNotChange_whenTurningAOffWithoutCallingStep() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(true);
		systemUnderTest.step();
		final boolean originalValue = systemUnderTest.getS();

		systemUnderTest.setA(false);

		assertEquals(originalValue, systemUnderTest.getS());
	}

	@Test
	public final void testS_shouldNotChange_whenTurningAOnWithoutCallingStep() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(false);
		systemUnderTest.step();
		final boolean originalValue = systemUnderTest.getS();

		systemUnderTest.setA(true);

		assertEquals(originalValue, systemUnderTest.getS());
	}

	@Test
	public final void testS_shouldNotChange_whenTurningBOffWithoutCallingStep() {
		systemUnderTest.setPower(true);
		systemUnderTest.setB(true);
		systemUnderTest.step();
		final boolean originalValue = systemUnderTest.getS();

		systemUnderTest.setB(false);

		assertEquals(originalValue, systemUnderTest.getS());
	}

	@Test
	public final void testS_shouldNotChange_whenTurningBOnWithoutCallingStep() {
		systemUnderTest.setPower(true);
		systemUnderTest.setB(false);
		systemUnderTest.step();
		final boolean originalValue = systemUnderTest.getS();

		systemUnderTest.setB(true);

		assertEquals(originalValue, systemUnderTest.getS());
	}

}

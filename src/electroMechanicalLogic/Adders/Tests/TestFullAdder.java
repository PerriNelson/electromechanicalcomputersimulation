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

import electroMechanicalLogic.Adders.FullAdder;
import electroMechanicalLogic.Adders.Interfaces.IFullAdder;

public class TestFullAdder extends TestHalfAdder {

	@Override
	@Before
	public void setUp() throws Exception {
		systemUnderTest = new FullAdder();
	}

	@Test
	public final void testCO_shouldBeOff_whenPowerIsOffAndBothInputsAreOffAndCIIsOn() {
		systemUnderTest.setPower(false);
		systemUnderTest.setA(false);
		systemUnderTest.setB(false);
		turnOnCI();
		systemUnderTest.step();

		assertFalse(systemUnderTest.getCO());
	}

	@Test
	public final void testCO_shouldBeOff_whenPowerIsOffAndBothInputsAreOnAndCIIsOn() {
		systemUnderTest.setPower(false);
		systemUnderTest.setA(true);
		systemUnderTest.setB(true);
		turnOnCI();
		systemUnderTest.step();

		assertFalse(systemUnderTest.getCO());
	}

	@Test
	public final void testCO_shouldBeOff_whenPowerIsOffAndOnlyAIsOnAndCIIsOn() {
		systemUnderTest.setPower(false);
		systemUnderTest.setA(true);
		systemUnderTest.setB(false);
		turnOnCI();
		systemUnderTest.step();

		assertFalse(systemUnderTest.getCO());
	}

	@Test
	public final void testCO_shouldBeOff_whenPowerIsOffAndOnlyBIsOnAndCIIsOn() {
		systemUnderTest.setPower(false);
		systemUnderTest.setA(false);
		systemUnderTest.setB(true);
		turnOnCI();
		systemUnderTest.step();

		assertFalse(systemUnderTest.getCO());
	}

	@Test
	public final void testCO_shouldBeOff_whenPowerIsOnAndBothInputsAreOffAndCIIsOn() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(false);
		systemUnderTest.setB(false);
		turnOnCI();
		systemUnderTest.step();

		assertFalse(systemUnderTest.getCO());
	}

	@Test
	public final void testCO_shouldBeOn_whenPowerIsOnAndBothInputsAreOnAndCIIsOn() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(true);
		systemUnderTest.setB(true);
		turnOnCI();
		systemUnderTest.step();

		assertTrue(systemUnderTest.getCO());
	}

	@Test
	public final void testCO_shouldBeOn_whenPowerIsOnAndOnlyAIsOnAndCIIsOn() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(true);
		systemUnderTest.setB(false);
		turnOnCI();
		systemUnderTest.step();

		assertTrue(systemUnderTest.getCO());
	}

	@Test
	public final void testCO_shouldBeOn_whenPowerIsOnAndOnlyBIsOnAndCIIsOn() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(false);
		systemUnderTest.setB(true);
		turnOnCI();
		systemUnderTest.step();

		assertTrue(systemUnderTest.getCO());
	}

	@Test
	public final void testCO_shouldNotChange_whenTurningAOffAndCIIsOnWithoutCallingStep() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(true);
		systemUnderTest.setB(true);
		turnOnCI();
		systemUnderTest.step();
		final boolean originalValue = systemUnderTest.getCO();

		systemUnderTest.setA(false);

		assertEquals(originalValue, systemUnderTest.getCO());
	}

	@Test
	public final void testCO_shouldNotChange_whenTurningAOnAndCIIsOnWithoutCallingStep() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(false);
		systemUnderTest.setB(true);
		turnOnCI();
		systemUnderTest.step();
		final boolean originalValue = systemUnderTest.getCO();

		systemUnderTest.setA(true);

		assertEquals(originalValue, systemUnderTest.getCO());
	}

	@Test
	public final void testCO_shouldNotChange_whenTurningBOffAndCIIsOnWithoutCallingStep() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(true);
		systemUnderTest.setB(true);
		turnOnCI();
		systemUnderTest.step();
		final boolean originalValue = systemUnderTest.getCO();

		systemUnderTest.setB(false);

		assertEquals(originalValue, systemUnderTest.getCO());
	}

	@Test
	public final void testCO_shouldNotChange_whenTurningBOnAndCIIsOnWithoutCallingStep() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(true);
		systemUnderTest.setB(false);
		turnOnCI();
		systemUnderTest.step();
		final boolean originalValue = systemUnderTest.getCO();

		systemUnderTest.setB(true);

		assertEquals(originalValue, systemUnderTest.getCO());
	}

	@Test
	public final void testCO_shouldNotChange_whenTurningCIOffWithoutCallingStep() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(true);
		turnOnCI();
		systemUnderTest.step();
		final boolean originalValue = systemUnderTest.getCO();

		turnOffCI();

		assertEquals(originalValue, systemUnderTest.getCO());
	}

	@Test
	public final void testCO_shouldNotChange_whenTurningCIOnWithoutCallingStep() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(true);
		systemUnderTest.step();
		final boolean originalValue = systemUnderTest.getCO();

		turnOnCI();

		assertEquals(originalValue, systemUnderTest.getCO());
	}

	@Test
	public final void testS_shouldBeOff_whenPowerIsOffAndBothInputsAreOffAndCIIsOn() {
		systemUnderTest.setPower(false);
		systemUnderTest.setA(false);
		systemUnderTest.setB(false);
		turnOnCI();
		systemUnderTest.step();

		assertFalse(systemUnderTest.getS());
	}

	@Test
	public final void testS_shouldBeOff_whenPowerIsOffAndBothInputsAreOnAndCIIsOn() {
		systemUnderTest.setPower(false);
		systemUnderTest.setA(true);
		systemUnderTest.setB(true);
		turnOnCI();
		systemUnderTest.step();

		assertFalse(systemUnderTest.getS());
	}

	@Test
	public final void testS_shouldBeOff_whenPowerIsOffAndOnlyAIsOnAndCIIsOn() {
		systemUnderTest.setPower(false);
		systemUnderTest.setA(true);
		systemUnderTest.setB(false);
		turnOnCI();
		systemUnderTest.step();

		assertFalse(systemUnderTest.getS());
	}

	@Test
	public final void testS_shouldBeOff_whenPowerIsOffAndOnlyBIsOnAndCIIsOn() {
		systemUnderTest.setPower(false);
		systemUnderTest.setA(false);
		systemUnderTest.setB(true);
		turnOnCI();
		systemUnderTest.step();

		assertFalse(systemUnderTest.getS());
	}

	@Test
	public final void testS_shouldBeOff_whenPowerIsOnAndOnlyAIsOnAndCIIsOn() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(true);
		systemUnderTest.setB(false);
		turnOnCI();
		systemUnderTest.step();

		assertFalse(systemUnderTest.getS());
	}

	@Test
	public final void testS_shouldBeOff_whenPowerIsOnAndOnlyBIsOnAndCIIsOn() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(false);
		systemUnderTest.setB(true);
		turnOnCI();
		systemUnderTest.step();

		assertFalse(systemUnderTest.getS());
	}

	@Test
	public final void testS_shouldBeOn_WhenPowerIsOnAndBothInputsAreOffAndCIIsOn() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(false);
		systemUnderTest.setB(false);
		turnOnCI();
		systemUnderTest.step();

		assertTrue(systemUnderTest.getS());
	}

	@Test
	public final void testS_shouldBeOn_WhenPowerIsOnAndBothInputsAreOnAndCIIsOn() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(true);
		systemUnderTest.setB(true);
		turnOnCI();
		systemUnderTest.step();

		assertTrue(systemUnderTest.getS());
	}

	@Test
	public final void testS_shouldNotChange_whenTurningAOffAndCIIsOnWithoutCallingStep() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(true);
		turnOnCI();
		systemUnderTest.step();
		final boolean originalValue = systemUnderTest.getS();

		systemUnderTest.setA(false);

		assertEquals(originalValue, systemUnderTest.getS());
	}

	@Test
	public final void testS_shouldNotChange_whenTurningAOnAndCIIsOnWithoutCallingStep() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(false);
		turnOnCI();
		systemUnderTest.step();
		final boolean originalValue = systemUnderTest.getS();

		systemUnderTest.setA(true);

		assertEquals(originalValue, systemUnderTest.getS());
	}

	@Test
	public final void testS_shouldNotChange_whenTurningBOffAndCIIsOnWithoutCallingStep() {
		systemUnderTest.setPower(true);
		systemUnderTest.setB(true);
		turnOnCI();
		systemUnderTest.step();
		final boolean originalValue = systemUnderTest.getS();

		systemUnderTest.setB(false);

		assertEquals(originalValue, systemUnderTest.getS());
	}

	@Test
	public final void testS_shouldNotChange_whenTurningBOnAndCIIsOnWithoutCallingStep() {
		systemUnderTest.setPower(true);
		systemUnderTest.setB(false);
		turnOnCI();
		systemUnderTest.step();
		final boolean originalValue = systemUnderTest.getS();

		systemUnderTest.setB(true);

		assertEquals(originalValue, systemUnderTest.getS());
	}

	@Test
	public final void testS_shouldNotChange_whenTurningCIOffWithoutCallingStep() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(true);
		turnOnCI();
		systemUnderTest.step();
		final boolean originalValue = systemUnderTest.getS();

		turnOffCI();

		assertEquals(originalValue, systemUnderTest.getS());
	}

	@Test
	public final void testS_shouldNotChange_whenTurningCIOnWithoutCallingStep() {
		systemUnderTest.setPower(true);
		systemUnderTest.setA(true);
		systemUnderTest.step();
		final boolean originalValue = systemUnderTest.getS();

		turnOnCI();

		assertEquals(originalValue, systemUnderTest.getS());
	}

	private void turnOffCI() {
		((IFullAdder) systemUnderTest).setCI(false);
	}

	private void turnOnCI() {
		((IFullAdder) systemUnderTest).setCI(true);
	}

}

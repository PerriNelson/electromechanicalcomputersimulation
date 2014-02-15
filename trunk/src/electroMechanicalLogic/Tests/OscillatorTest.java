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

import electroMechanicalLogic.Oscillator;
import electroMechanicalLogic.Interfaces.IOscillator;

public class OscillatorTest {

	private IOscillator systemUnderTest;

	@Before
	public void setUp() throws Exception {
		systemUnderTest = new Oscillator();
		systemUnderTest.setPower(true);
	}

	@Test
	public final void test_GetOutput_WhenFirstStepped_ReturnsOn() {
		systemUnderTest.step();

		assertTrue(systemUnderTest.getOutput());
	}

	@Test
	public final void test_GetOutput_WhenRepeatedlyStepped_Oscillates() {
		systemUnderTest.step();
		assertTrue(systemUnderTest.getOutput());
		systemUnderTest.step();
		assertFalse(systemUnderTest.getOutput());
		systemUnderTest.step();
		assertTrue(systemUnderTest.getOutput());
		systemUnderTest.step();
		assertFalse(systemUnderTest.getOutput());
	}

}

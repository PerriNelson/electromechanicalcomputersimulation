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

import electroMechanicalLogic.Buffer;
import electroMechanicalLogic.Interfaces.IRelay;

public class BufferTest {

	private IRelay systemUnderTest;
 
	@Before
	public void setUp() throws Exception {
		systemUnderTest = new Buffer();
	}

	@Test
	public void test_GetOutput_ByItself_ReturnsFalse() {
		assertFalse(systemUnderTest.getOutput());
	}

	@Test
	public void test_GetOutput_WhenPowerAndInputAreOff_ReturnsFalse() {
		systemUnderTest.setPower(false);
		systemUnderTest.setInput(false);
		systemUnderTest.step();
		assertFalse(systemUnderTest.getOutput());
	}

	@Test
	public void test_GetOutput_WhenPowerAndInputAreOn_ReturnsTrue() {
		systemUnderTest.setPower(true);
		systemUnderTest.setInput(true);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getOutput());
	}

	@Test
	public void test_GetOutput_WhenPowerIsOffAndInputIsOn_ReturnsFalse() {
		systemUnderTest.setPower(false);
		systemUnderTest.setInput(true);
		systemUnderTest.step();
		assertFalse(systemUnderTest.getOutput());
	}

	@Test
	public void test_GetOutput_WhenPowerIsOnAndInputIsOff_ReturnsFalse() {
		systemUnderTest.setPower(true);
		systemUnderTest.setInput(false);
		systemUnderTest.step();
		assertFalse(systemUnderTest.getOutput());
	}
}

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

import electroMechanicalLogic.ThreeInputNOR;
import electroMechanicalLogic.Interfaces.IThreeInputSingleOutputGate;

public class ThreeInputNOrTest {
	private IThreeInputSingleOutputGate systemUnderTest;

	@Before
	public void setUp() throws Exception {
		systemUnderTest = new ThreeInputNOR();
		systemUnderTest.setPower(true);
	}

	@Test
	public final void test_GetOutput_WhenAIsOffAndBIsOffAndCIsOff_ReturnsOn() {
		systemUnderTest.setA(false);
		systemUnderTest.setB(false);
		systemUnderTest.setC(false);

		systemUnderTest.step();

		assertTrue(systemUnderTest.getOutput());
	}

	@Test
	public final void test_GetOutput_WhenAIsOffAndBIsOffAndCIsOn_ReturnsOff() {
		systemUnderTest.setA(false);
		systemUnderTest.setB(false);
		systemUnderTest.setC(true);

		systemUnderTest.step();

		assertFalse(systemUnderTest.getOutput());
	}

	@Test
	public final void test_GetOutput_WhenAIsOffAndBIsOnAndCIsOff_ReturnsOff() {
		systemUnderTest.setA(false);
		systemUnderTest.setB(true);
		systemUnderTest.setC(false);

		systemUnderTest.step();

		assertFalse(systemUnderTest.getOutput());
	}

	@Test
	public final void test_GetOutput_WhenAIsOffAndBIsOnAndCIsOn_ReturnsOff() {
		systemUnderTest.setA(false);
		systemUnderTest.setB(true);
		systemUnderTest.setC(true);

		systemUnderTest.step();

		assertFalse(systemUnderTest.getOutput());
	}

	@Test
	public final void test_GetOutput_WhenAIsOnAndBIsOffAndCIsOff_ReturnsOff() {
		systemUnderTest.setA(true);
		systemUnderTest.setB(false);
		systemUnderTest.setC(false);

		systemUnderTest.step();

		assertFalse(systemUnderTest.getOutput());
	}

	@Test
	public final void test_GetOutput_WhenAIsOnAndBIsOffAndCIsOn_ReturnsOff() {
		systemUnderTest.setA(true);
		systemUnderTest.setB(false);
		systemUnderTest.setC(true);

		systemUnderTest.step();

		assertFalse(systemUnderTest.getOutput());
	}

	@Test
	public final void test_GetOutput_WhenAIsOnAndBIsOnAndCIsOff_ReturnsOff() {
		systemUnderTest.setA(true);
		systemUnderTest.setB(true);
		systemUnderTest.setC(false);

		systemUnderTest.step();

		assertFalse(systemUnderTest.getOutput());
	}

	@Test
	public final void test_GetOutput_WhenAIsOnAndBIsOnAndCIsOn_ReturnsOff() {
		systemUnderTest.setA(true);
		systemUnderTest.setB(true);
		systemUnderTest.setC(true);

		systemUnderTest.step();

		assertFalse(systemUnderTest.getOutput());
	}

}

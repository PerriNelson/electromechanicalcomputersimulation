/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.Tests;

import static electroMechanicalLogic.Tests.TestConstants.off;
import static electroMechanicalLogic.Tests.TestConstants.on;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalLogic.ThreeInputOR;
import electroMechanicalLogic.Interfaces.IThreeInputSingleOutputGate;

public class ThreeInputOrTest {
	private IThreeInputSingleOutputGate systemUnderTest;

	@Before
	public void setUp() throws Exception {
		systemUnderTest = new ThreeInputOR();
		systemUnderTest.setPower(on);
	}

	@Test
	public final void test_GetOutput_WhenAIsOffAndBIsOffAndCIsOff_ReturnsOff() {
		systemUnderTest.setA(off);
		systemUnderTest.setB(off);
		systemUnderTest.setC(off);

		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getOutput());
	}

	@Test
	public final void test_GetOutput_WhenAIsOffAndBIsOffAndCIsOn_ReturnsOn() {
		systemUnderTest.setA(off);
		systemUnderTest.setB(off);
		systemUnderTest.setC(on);

		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getOutput());
	}

	@Test
	public final void test_GetOutput_WhenAIsOffAndBIsOnAndCIsOff_ReturnsOn() {
		systemUnderTest.setA(off);
		systemUnderTest.setB(on);
		systemUnderTest.setC(off);

		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getOutput());
	}

	@Test
	public final void test_GetOutput_WhenAIsOffAndBIsOnAndCIsOn_ReturnsOn() {
		systemUnderTest.setA(off);
		systemUnderTest.setB(on);
		systemUnderTest.setC(on);

		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getOutput());
	}

	@Test
	public final void test_GetOutput_WhenAIsOnAndBIsOffAndCIsOff_ReturnsOn() {
		systemUnderTest.setA(on);
		systemUnderTest.setB(off);
		systemUnderTest.setC(off);

		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getOutput());
	}

	@Test
	public final void test_GetOutput_WhenAIsOnAndBIsOffAndCIsOn_ReturnsOn() {
		systemUnderTest.setA(on);
		systemUnderTest.setB(off);
		systemUnderTest.setC(on);

		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getOutput());
	}

	@Test
	public final void test_GetOutput_WhenAIsOnAndBIsOnAndCIsOff_ReturnsOn() {
		systemUnderTest.setA(on);
		systemUnderTest.setB(on);
		systemUnderTest.setC(off);

		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getOutput());
	}

	@Test
	public final void test_GetOutput_WhenAIsOnAndBIsOnAndCIsOn_ReturnsOn() {
		systemUnderTest.setA(on);
		systemUnderTest.setB(on);
		systemUnderTest.setC(on);

		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getOutput());
	}

}

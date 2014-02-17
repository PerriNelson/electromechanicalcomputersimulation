/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalLogic.Interfaces.ILatch;
import electroMechanicalLogic.Latch;

public class LatchTest {
	private ILatch systemUnderTest;

	@Before
	public void setUp() throws Exception {
		systemUnderTest = new Latch();
		systemUnderTest.setPower(true);
	}

	@Test
	public final void test_GetDO_WhenDIIsOnAndWIsOn_ReturnsOn() {
		systemUnderTest.setDI(true);
		systemUnderTest.setW(true);
		systemUnderTest.step();
		
		assertTrue(systemUnderTest.getDO());
	}

	@Test
	public final void test_GetDO_WhenDIIsOffAndWIsOn_ReturnsOff() {
		systemUnderTest.setDI(false);
		systemUnderTest.setW(true);
		systemUnderTest.step();
		
		assertFalse(systemUnderTest.getDO());
	}

	@Test
	public final void test_GetDO_WhenDIIsOnAndWIsOnThenWIsOff_ReturnsOn() {
		systemUnderTest.setDI(true);
		systemUnderTest.setW(true);
		systemUnderTest.step();
		systemUnderTest.setW(false);
		systemUnderTest.step();
		
		assertTrue(systemUnderTest.getDO());
	}

	@Test
	public final void test_GetDO_WhenDIIsOffAndWIsOnThenWIsOff_ReturnsOff() {
		systemUnderTest.setDI(false);
		systemUnderTest.setW(true);
		systemUnderTest.step();
		systemUnderTest.setW(false);
		systemUnderTest.step();
		
		assertFalse(systemUnderTest.getDO());
	}

	@Test
	public final void test_SetDI_WhenWIsOff_DoesNotAffectDO() {
		systemUnderTest.setDI(false);
		systemUnderTest.setW(true);
		systemUnderTest.step();
		systemUnderTest.setW(false);
		systemUnderTest.step();
		systemUnderTest.setDI(true);
		systemUnderTest.step();
		
		assertFalse(systemUnderTest.getDO());
		
		systemUnderTest.setDI(true);
		systemUnderTest.setW(true);
		systemUnderTest.step();
		systemUnderTest.setW(false);
		systemUnderTest.step();
		systemUnderTest.setDI(false);
		systemUnderTest.step();
		
		assertTrue(systemUnderTest.getDO());
	}
}

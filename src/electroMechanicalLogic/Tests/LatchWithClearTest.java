/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.Tests;

import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalLogic.LatchWithClear;
import electroMechanicalLogic.Interfaces.ILatchWithClear;

public class LatchWithClearTest extends LatchTest {

	@Before
	@Override
	public void setUp() throws Exception {
		systemUnderTest = new LatchWithClear();
		systemUnderTest.setPower(true);
	}
 
	@Test
	public final void test_GetDO_WhenDIIsOnAndClrIsOnAndWIsOnThenWIsOff_ReturnsOff() {
		systemUnderTest.setDI(true);
		((ILatchWithClear) systemUnderTest).setClr(true);
		systemUnderTest.setW(true);
		systemUnderTest.step();
		systemUnderTest.setW(false);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getDO());
	}

	@Test
	public final void test_GetDO_WhenDIIsOnAndWIsOnAndClrIsOn_ReturnsOff() {
		systemUnderTest.setDI(true);
		systemUnderTest.setW(true);
		((ILatchWithClear) systemUnderTest).setClr(true);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getDO());
	}

}

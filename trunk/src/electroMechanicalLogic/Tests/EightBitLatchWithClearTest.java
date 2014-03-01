/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalLogic.EightBitLatchWithClear;
import electroMechanicalLogic.Interfaces.IEightBitLatchWithClear;

public class EightBitLatchWithClearTest extends EightBitLatchTest {

	@Before
	@Override
	public void setUp() throws Exception {
		systemUnderTest = new EightBitLatchWithClear();
		systemUnderTest.setPower(true);
	}

	@Test
	public final void test_WhenClearSet_AllAddressesReturnOff() {
		for (int testValue = 0; testValue < 0x100; testValue++) {
			setDI(testValue);
			((IEightBitLatchWithClear) systemUnderTest).setClr(true);
			systemUnderTest.setW(true);
			systemUnderTest.step();
			systemUnderTest.setW(false);
			systemUnderTest.step();
			assertEquals(getDO(), 0);
		}
	}

}

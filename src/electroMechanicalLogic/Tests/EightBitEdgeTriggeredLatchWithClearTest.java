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

import electroMechanicalLogic.EightBitEdgeTriggeredLatchWithClear;
import electroMechanicalLogic.Interfaces.IEightBitLatchWithClear;

public class EightBitEdgeTriggeredLatchWithClearTest extends EightBitLatchTest {

	@Before
	@Override
	public void setUp() throws Exception {
		systemUnderTest = new EightBitEdgeTriggeredLatchWithClear();
		systemUnderTest.setPower(true);
		((IEightBitLatchWithClear) systemUnderTest).setClr(false);
		systemUnderTest.step();
	}

	@Test
	@Override
	public void test() {
		systemUnderTest.step();
		for (int testValue = 0; testValue < 0x100; testValue++) {
			setDI(testValue);
			systemUnderTest.setW(false);
			systemUnderTest.step();
			systemUnderTest.setW(true);
			systemUnderTest.step();
			assertEquals(testValue, getDO());
		}
	}

	@Test
	public final void test_WhenClearSet_AllAddressesReturnOff() {
		for (int testValue = 0; testValue < 0x100; testValue++) {
			setDI(testValue);
			((IEightBitLatchWithClear) systemUnderTest).setClr(true);
			systemUnderTest.setW(false);
			systemUnderTest.step();
			systemUnderTest.setW(true);
			systemUnderTest.step();
			assertEquals(0, getDO());
		}
	}

}

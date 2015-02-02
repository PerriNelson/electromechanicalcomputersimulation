/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Model.Tests;

import static electroMechanicalLogic.Tests.TestConstants.off;
import static electroMechanicalLogic.Tests.TestConstants.on;
import static electroMechanicalLogic.Tests.TestUtilities.getDataOut;
import static electroMechanicalLogic.Tests.TestUtilities.setDataIn;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalMachine.Model.MarkVIALU;
import electroMechanicalMachine.Model.Interfaces.IMarkVIALU;

public class MarkVIALUTest {
	protected IMarkVIALU systemUnderTest;

	@Before
	public void Setup() {
		systemUnderTest = new MarkVIALU();
		systemUnderTest.setPower(on);
	}

	@Test
	public void test_WhenAddIsOn_AfterOneClockCycle_DataOutReflectsAddition() {
		systemUnderTest.setAdd(on);

		int expectedResult = 0;
		for (int i = 0; i < 256; i++) {
			setDataIn(systemUnderTest, i);
			performOneClockCycle();

			expectedResult += i;
			expectedResult &= 0xff;

			assertEquals(expectedResult, getDataOut(systemUnderTest));
		}
	}

	@Test
	public void test_WhenClearIsOnAndAddIsOn_DataOutIsAlwaysZero() {
		final int expectedResult = 0;
		systemUnderTest.setAdd(on);
		systemUnderTest.setClear(on);

		for (int i = 0; i < 256; i++) {
			setDataIn(systemUnderTest, i);
			performOneClockCycle();

			assertEquals(expectedResult, getDataOut(systemUnderTest));
		}
	}

	@Test
	public void test_WhenClearIsOnAndLoadIsOn_DataOutIsAlwaysZero() {
		final int expectedResult = 0;
		systemUnderTest.setLoad(on);
		systemUnderTest.setClear(on);

		for (int i = 0; i < 256; i++) {
			setDataIn(systemUnderTest, i);
			performOneClockCycle();

			assertEquals(expectedResult, getDataOut(systemUnderTest));
		}
	}

	@Test
	public void test_WhenLoadIsOn_AfterOneClockCycle_DataInIsAvailableAsDataOut() {
		systemUnderTest.setLoad(on);

		for (int i = 0; i < 256; i++) {
			setDataIn(systemUnderTest, i);
			performOneClockCycle();

			assertEquals(i, getDataOut(systemUnderTest));
		}
	}

	protected void performOneClockCycle() {
		systemUnderTest.setClock(off);
		systemUnderTest.step();

		systemUnderTest.setClock(on);
		systemUnderTest.step();
	}
}

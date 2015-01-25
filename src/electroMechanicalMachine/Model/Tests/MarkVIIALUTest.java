/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Model.Tests;

import static electroMechanicalLogic.Tests.TestConstants.on;
import static electroMechanicalLogic.Tests.TestUtilities.getDataOut;
import static electroMechanicalLogic.Tests.TestUtilities.setDataIn;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalMachine.Model.MarkVIIALU;

public class MarkVIIALUTest extends MarkVIALUTest {

	@Override
	@Before
	public void Setup() {
		systemUnderTest = new MarkVIIALU();
		systemUnderTest.setPower(on);
	}

	@Test
	public void test_WhenSubtractIsOn_AfterOneClockCycle_DataOutReflectsAddition() {
		((MarkVIIALU) systemUnderTest).setSubtract(on);

		int expectedResult = 0;
		for (int i = 255; i < -1; i--) {
			setDataIn(systemUnderTest, i);
			performOneClockCycle();

			expectedResult -= i;
			expectedResult &= 0xff;

			assertEquals(expectedResult, getDataOut(systemUnderTest));
		}
	}

}

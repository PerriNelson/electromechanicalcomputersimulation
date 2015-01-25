/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.Tests;

import static electroMechanicalLogic.Tests.TestConstants.on;
import static electroMechanicalLogic.Tests.TestUtilities.getDataOut;
import static electroMechanicalLogic.Tests.TestUtilities.setDataIn;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalLogic.EightBitBuffer;
import electroMechanicalLogic.Interfaces.IEightBitBuffer;

public class EightBitBufferTest {
	private IEightBitBuffer systemUnderTest;

	@Before
	public void Setup() {
		systemUnderTest = new EightBitBuffer();
		systemUnderTest.setPower(on);
	}

	@Test
	public void test_ForAllInputs_DataOutReflectsDataIn() {
		for (int i = 0; i < 256; i++) {
			setDataIn(systemUnderTest, i);
			systemUnderTest.step();
			assertEquals(i, getDataOut(systemUnderTest));
		}
	}
}

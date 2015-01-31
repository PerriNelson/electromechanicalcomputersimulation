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

import electroMechanicalMachine.Model.MarkVIIIALU;

public class TestMarkVIIIALU extends MarkVIIALUTest {

	@Override
	@Before
	public void Setup() {
		systemUnderTest = new MarkVIIIALU();
		systemUnderTest.setPower(on);
	}

	@Test
	public void testMarkVIIIAlu_performsAdditionCorrectly_whenPreviousOperationResultedInCarryAndCurrentOperationIsAddWithCarry() {
		// Load it wit 0xff
		setDataIn(systemUnderTest, 0xff);
		systemUnderTest.setLoad(true);
		performOneClockCycle();

		// Add 1, should be 0 with a carry.
		setDataIn(systemUnderTest, 1);
		systemUnderTest.setLoad(false);
		systemUnderTest.setAdd(true);
		performOneClockCycle();

		// Load 0, should remain 0, but carry should be unaffected.
		setDataIn(systemUnderTest, 0);
		systemUnderTest.setAdd(false);
		systemUnderTest.setLoad(true);
		performOneClockCycle();

		// Add 1, with the carry, result should be 2.
		setDataIn(systemUnderTest, 1);
		systemUnderTest.setLoad(false);
		((MarkVIIIALU) systemUnderTest).setAddWithCarry(true);
		performOneClockCycle();

		assertEquals(2, getDataOut(systemUnderTest));
	}
}

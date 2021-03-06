/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Model.Tests;

import static electroMechanicalLogic.Tests.TestConstants.bit0;
import static electroMechanicalLogic.Tests.TestConstants.bit1;
import static electroMechanicalLogic.Tests.TestConstants.bit2;
import static electroMechanicalLogic.Tests.TestConstants.bit3;
import static electroMechanicalLogic.Tests.TestConstants.bit4;
import static electroMechanicalLogic.Tests.TestConstants.bit5;
import static electroMechanicalLogic.Tests.TestConstants.bit6;
import static electroMechanicalLogic.Tests.TestConstants.bit7;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalLogic.EightBitLatchWithClear;
import electroMechanicalMachine.Model.AddingMachineMarkIVModel;
import electroMechanicalMachine.Model.Interfaces.IAddingMachineMarkIVModel;

public class AddingMachineMarkIVModelTest {
	private IAddingMachineMarkIVModel systemUnderTest;

	@Before
	public void setUp() throws Exception {
		systemUnderTest = new AddingMachineMarkIVModel(
				new EightBitLatchWithClear());
		systemUnderTest.setPower(true);
		systemUnderTest.setClear(false);
		setAInputs(0);
		systemUnderTest.setAdd(false);
		systemUnderTest.step();
	}

	@Test
	public void test_ForAllInputAWhenAddIsLeftOnAndClearIsOff_AdditionIsPerformedEachStep() {
		int expectedResult = 0;
		systemUnderTest.setAdd(true);
		for (int a = 0; a < 256; a++) {
			setAInputs(a);
			for (int b = 0; b < 256; b++) {
				systemUnderTest.step();
				expectedResult += a;
				expectedResult &= 0xff;

				assertEquals(String.format("a = %d b = %d", a, b),
						expectedResult, getSum());
			}
		}
	}

	@Test
	public void test_ForAllInputAWhenAddIsToggledOffAndOnRepeatedlyAndClearIsOff_AdditionIsPerformedEachTime() {
		int expectedResult = 0;
		for (int a = 0; a < 256; a++) {
			setAInputs(a);
			systemUnderTest.setAdd(false);
			systemUnderTest.step();
			for (int b = 0; b < 256; b++) {
				systemUnderTest.setAdd(false);
				systemUnderTest.step();
				systemUnderTest.setAdd(true);
				systemUnderTest.step();
				expectedResult += a;
				expectedResult &= 0xff;

				assertEquals(String.format("a = %d b = %d", a, b),
						expectedResult, getSum());
			}
		}
	}

	@Test
	public void test_ForAllInputAWhenAddIsToggledOffAndOnRepeatedlyAndClearIsOn_ResultIsAlwaysZero() {
		systemUnderTest.setClear(true);
		for (int a = 0; a < 256; a++) {
			setAInputs(a);
			systemUnderTest.step();
			for (int b = 0; b < 256; b++) {
				systemUnderTest.setAdd(false);
				systemUnderTest.step();
				systemUnderTest.setAdd(true);
				systemUnderTest.step();

				assertEquals(String.format("a = %d b = %d", a, b), 0, getSum());
			}
		}
	}

	private int getSum() {
		int sum = 0;
		if (systemUnderTest.getS0()) {
			sum = sum | bit0;
		}
		if (systemUnderTest.getS1()) {
			sum = sum | bit1;
		}
		if (systemUnderTest.getS2()) {
			sum = sum | bit2;
		}
		if (systemUnderTest.getS3()) {
			sum = sum | bit3;
		}
		if (systemUnderTest.getS4()) {
			sum = sum | bit4;
		}
		if (systemUnderTest.getS5()) {
			sum = sum | bit5;
		}
		if (systemUnderTest.getS6()) {
			sum = sum | bit6;
		}
		if (systemUnderTest.getS7()) {
			sum = sum | bit7;
		}
		return sum;
	}

	private void setAInputs(final int value) {
		systemUnderTest.setA0((value & bit0) == bit0);
		systemUnderTest.setA1((value & bit1) == bit1);
		systemUnderTest.setA2((value & bit2) == bit2);
		systemUnderTest.setA3((value & bit3) == bit3);
		systemUnderTest.setA4((value & bit4) == bit4);
		systemUnderTest.setA5((value & bit5) == bit5);
		systemUnderTest.setA6((value & bit6) == bit6);
		systemUnderTest.setA7((value & bit7) == bit7);
	}
}

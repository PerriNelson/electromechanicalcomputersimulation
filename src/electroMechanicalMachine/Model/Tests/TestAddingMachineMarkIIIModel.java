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
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalLogic.EightBitLatch;
import electroMechanicalMachine.Model.AddingMachineMarkIIIModel;
import electroMechanicalMachine.Model.Interfaces.IAddingMachineMarkIIIModel;

public class TestAddingMachineMarkIIIModel {
	private IAddingMachineMarkIIIModel systemUnderTest;

	@Before
	public void setUp() throws Exception {
		systemUnderTest = new AddingMachineMarkIIIModel(new EightBitLatch());
		systemUnderTest.setPower(true);
		systemUnderTest.setFromLatch(false);
		systemUnderTest.setSave(false);
	}

	@Test
	public void test_ForAAndBFrom0To255AndSaveIsOffAndFromLatchIsOff_StepGivesExpectedResults() {
		for (int a = 0; a < 256; a++) {
			for (int b = 0; b < 256; b++) {
				setAInputs(a);
				setBInputs(b);
				systemUnderTest.step();
				final String message = String.format("a = %d b = %d", a, b);
				assertEquals(message, (a + b) & 0xff, getSum());
			}
		}
	}

	@Test
	public void test_ForAAndBFrom0To255AndSaveIsOffAndFromLatchIsOff_StepTwiceGivesExpectedResults() {
		for (int a = 0; a < 256; a++) {
			for (int b = 0; b < 256; b++) {
				setAInputs(a);
				setBInputs(b);
				systemUnderTest.step();
				systemUnderTest.step();

				final String message = String.format("a = %d b = %d", a, b);
				assertEquals(message, (a + b) & 0xff, getSum());
			}
		}
	}

	@Test
	public void test_ForAAndBFrom0To255AndSaveIsOffAndFromLatchIsOnWithLatchEmpty_StepGivesExpectedResults() {
		systemUnderTest.setFromLatch(true);
		for (int a = 0; a < 256; a++) {
			for (int b = 0; b < 256; b++) {
				setAInputs(a);
				setBInputs(b);
				systemUnderTest.step();
				final String message = String.format("a = %d b = %d", a, b);
				assertEquals(message, a & 0xff, getSum());
			}
		}
	}

	@Test
	public void test_ForAAndBFrom0To255AndSaveIsOnAndFromLatchIsOnWithLatchEmpty_StepGivesExpectedResults() {
		systemUnderTest.setFromLatch(true);
		systemUnderTest.setSave(true);

		int expectedSum = 0;
		for (int a = 0; a < 256; a++) {
			for (int b = 0; b < 256; b++) {
				setAInputs(a);
				setBInputs(b);
				systemUnderTest.step();
				final String message = String.format("a = %d b = %d", a, b);
				expectedSum += a;
				if ((expectedSum & 0x0100) == 0x0100) {
					assertTrue("Carry expected", systemUnderTest.getCO());
				}
				expectedSum &= 0x00ff;
				assertEquals(message, expectedSum, getSum());
			}
		}
	}

	@Test
	public void test_WhenSaveIsOnAndFromLatchIsOn_RepeatedSteppingActsLikeCounter() {
		systemUnderTest.setFromLatch(true);
		systemUnderTest.setSave(true);

		for (int a = 0; a < 256; a++) {
			int expectedSum = 0;
			setAInputs(a);
			for (int b = 0; b < 256; b++) {
				systemUnderTest.step();
				final String message = String.format("a = %d b = %d", a, b);
				expectedSum += a;
				if ((expectedSum & 0x0100) == 0x0100) {
					assertTrue("Carry expected", systemUnderTest.getCO());
				}
				expectedSum &= 0x00ff;
				assertEquals(message, expectedSum, getSum());
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

	private void setBInputs(final int value) {
		systemUnderTest.setB0((value & bit0) == bit0);
		systemUnderTest.setB1((value & bit1) == bit1);
		systemUnderTest.setB2((value & bit2) == bit2);
		systemUnderTest.setB3((value & bit3) == bit3);
		systemUnderTest.setB4((value & bit4) == bit4);
		systemUnderTest.setB5((value & bit5) == bit5);
		systemUnderTest.setB6((value & bit6) == bit6);
		systemUnderTest.setB7((value & bit7) == bit7);
	}
}

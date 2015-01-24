/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Model.Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalMachine.Model.AddingMachineMarkIModel;
import electroMechanicalMachine.Model.Interfaces.IAddingMachineMarkIModel;
import static electroMechanicalMachine.Model.Tests.TestConstants.*;

public class AddingMachineMarkIModelTest {

	private IAddingMachineMarkIModel systemUnderTest;
	private boolean eventFired = false;

	private int getSum() {
		int sum = 0;
		if (systemUnderTest.getS0())
			sum = sum | bit0;
		if (systemUnderTest.getS1())
			sum = sum | bit1;
		if (systemUnderTest.getS2())
			sum = sum | bit2;
		if (systemUnderTest.getS3())
			sum = sum | bit3;
		if (systemUnderTest.getS4())
			sum = sum | bit4;
		if (systemUnderTest.getS5())
			sum = sum | bit5;
		if (systemUnderTest.getS6())
			sum = sum | bit6;
		if (systemUnderTest.getS7())
			sum = sum | bit7;
		if (systemUnderTest.getCO())
			sum = sum | bit8;
		return sum;
	}

	private void setAInputs(int value) {
		systemUnderTest.setA0((value & bit0) == bit0);
		systemUnderTest.setA1((value & bit1) == bit1);
		systemUnderTest.setA2((value & bit2) == bit2);
		systemUnderTest.setA3((value & bit3) == bit3);
		systemUnderTest.setA4((value & bit4) == bit4);
		systemUnderTest.setA5((value & bit5) == bit5);
		systemUnderTest.setA6((value & bit6) == bit6);
		systemUnderTest.setA7((value & bit7) == bit7);
	}

	private void setBInputs(int value) {
		systemUnderTest.setB0((value & bit0) == bit0);
		systemUnderTest.setB1((value & bit1) == bit1);
		systemUnderTest.setB2((value & bit2) == bit2);
		systemUnderTest.setB3((value & bit3) == bit3);
		systemUnderTest.setB4((value & bit4) == bit4);
		systemUnderTest.setB5((value & bit5) == bit5);
		systemUnderTest.setB6((value & bit6) == bit6);
		systemUnderTest.setB7((value & bit7) == bit7);
	}

	@Before
	public void setUp() throws Exception {
		systemUnderTest = new AddingMachineMarkIModel();
		systemUnderTest.setPower(true);
	}

	@Test
	public void test_ForAAndBFrom0To255_StepGivesExpectedResults() {
		for (int a = 0; a < 256; a++) {
			for (int b = 0; b < 256; b++) {
				setAInputs(a);
				setBInputs(b);
				systemUnderTest.step();
				assertEquals(a + b, getSum());
			}
		}
	}

	@Test
	public void test_ForAAndBFrom0To255_StepTwiceGivesExpectedResults() {
		for (int a = 0; a < 256; a++) {
			for (int b = 0; b < 256; b++) {
				setAInputs(a);
				setBInputs(b);
				systemUnderTest.step();
				systemUnderTest.step();
				assertEquals(a + b, getSum());
			}
		}
	}

	@Test
	public void test_WhenStepped_FiresPropertyChangeEvent() {
		systemUnderTest.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				eventFired = true;
			}
		});
		systemUnderTest.step();
		assertTrue(eventFired);
	}
}

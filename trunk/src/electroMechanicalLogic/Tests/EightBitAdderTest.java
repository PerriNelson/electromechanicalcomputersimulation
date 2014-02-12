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

import electroMechanicalLogic.EightBitAdder;
import electroMechanicalLogic.IEightBitAdder;

public class EightBitAdderTest {
	private static final int bit0 = 0x01;
	private static final int bit1 = 0x02;
	private static final int bit2 = 0x04;
	private static final int bit3 = 0x08;
	private static final int bit4 = 0x10;
	private static final int bit5 = 0x20;
	private static final int bit6 = 0x40;
	private static final int bit7 = 0x80;
	private static final int bit8 = 0x100;

	private IEightBitAdder systemUnderTest;

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
		systemUnderTest = new EightBitAdder();
		systemUnderTest.setPower(true);
	}

	@Test
	public void test_AddWithCarryIn_GivesExpectedResults() {
		for (int a = 0; a < 256; a++) {
			for (int b = 0; b < 256; b++) {
				systemUnderTest.setPower(false);
				systemUnderTest.step();
				systemUnderTest.setPower(true);
				systemUnderTest.setCI(true);
				setAInputs(a);
				setBInputs(b);
				systemUnderTest.step();
				assertEquals(a + b + 1, getSum());
			}
		}
	}

	@Test
	public void test_AddWithoutCarryIn_GivesExpectedResults() {
		for (int a = 0; a < 256; a++) {
			for (int b = 0; b < 256; b++) {
				systemUnderTest.setPower(false);
				systemUnderTest.step();
				systemUnderTest.setPower(true);
				setAInputs(a);
				setBInputs(b);
				systemUnderTest.step();
				assertEquals(a + b, getSum());
			}
		}
	}
}

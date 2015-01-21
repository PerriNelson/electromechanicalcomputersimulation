/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Model.Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalMachine.Model.MarkVIALU;
import electroMechanicalMachine.Model.Interfaces.IMarkVIALU;

public class MarkVIALUTest {
	private static final int bit0 = 0x1;
	private static final int bit1 = 0x2;
	private static final int bit2 = 0x4;
	private static final int bit3 = 0x8;
	private static final int bit4 = 0x10;
	private static final int bit5 = 0x20;
	private static final int bit6 = 0x40;
	private static final int bit7 = 0x80;
	private static final boolean on = true;
	private static final boolean off = false;
	private IMarkVIALU systemUnderTest;

	private int getDataOut() {
		int dataOut = 0;
		dataOut |= (systemUnderTest.getDO0() ? bit0 : 0);
		dataOut |= (systemUnderTest.getDO1() ? bit1 : 0);
		dataOut |= (systemUnderTest.getDO2() ? bit2 : 0);
		dataOut |= (systemUnderTest.getDO3() ? bit3 : 0);
		dataOut |= (systemUnderTest.getDO4() ? bit4 : 0);
		dataOut |= (systemUnderTest.getDO5() ? bit5 : 0);
		dataOut |= (systemUnderTest.getDO6() ? bit6 : 0);
		dataOut |= (systemUnderTest.getDO7() ? bit7 : 0);
		return dataOut;
	}

	private void performOneClockCycle() {
		systemUnderTest.setClock(off);
		systemUnderTest.step();

		systemUnderTest.setClock(on);
		systemUnderTest.step();
	}

	private void setDataIn(int value) {
		systemUnderTest.setDI0((value & bit0) == bit0);
		systemUnderTest.setDI1((value & bit1) == bit1);
		systemUnderTest.setDI2((value & bit2) == bit2);
		systemUnderTest.setDI3((value & bit3) == bit3);
		systemUnderTest.setDI4((value & bit4) == bit4);
		systemUnderTest.setDI5((value & bit5) == bit5);
		systemUnderTest.setDI6((value & bit6) == bit6);
		systemUnderTest.setDI7((value & bit7) == bit7);
	}

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
			setDataIn(i);
			performOneClockCycle();

			expectedResult += i;
			expectedResult &= 0xff;

			assertEquals(expectedResult, getDataOut());
		}
	}

	@Test
	public void test_WhenClearIsOnAndAddIsOn_DataOutIsAlwaysZero() {
		int expectedResult = 0;
		systemUnderTest.setAdd(on);
		systemUnderTest.setClear(on);

		for (int i = 0; i < 256; i++) {
			setDataIn(i);
			performOneClockCycle();

			assertEquals(expectedResult, getDataOut());
		}
	}

	@Test
	public void test_WhenClearIsOnAndLoadIsOn_DataOutIsAlwaysZero() {
		int expectedResult = 0;
		systemUnderTest.setLoad(on);
		systemUnderTest.setClear(on);

		for (int i = 0; i < 256; i++) {
			setDataIn(i);
			performOneClockCycle();

			assertEquals(expectedResult, getDataOut());
		}
	}

	@Test
	public void test_WhenLoadIsOn_AfterOneClockCycle_DataInIsAvailableAsDataOut() {
		systemUnderTest.setLoad(on);

		for (int i = 0; i < 256; i++) {
			setDataIn(i);
			performOneClockCycle();

			assertEquals(i, getDataOut());
		}
	}
}

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

import electroMechanicalMachine.Model.MarkVITimingAndMemoryWriteControl;
import electroMechanicalMachine.Model.Interfaces.IMarkVITimingAndMemoryWriteControl;

public class MarkVITimingAndMemoryWriteControlTest {
	private static final int bit0 = 0x1;
	private static final int bit1 = 0x2;
	private static final int bit2 = 0x4;
	private static final int bit3 = 0x8;
	private static final int bit4 = 0x10;
	private static final int bit5 = 0x20;
	private static final int bit6 = 0x40;
	private static final int bit7 = 0x80;
	private static final int bit8 = 0x100;
	private static final int bit9 = 0x200;
	private static final int bitA = 0x400;
	private static final int bitB = 0x800;
	private static final int bitC = 0x1000;
	private static final int bitD = 0x2000;
	private static final int bitE = 0x4000;
	private static final int bitF = 0x8000;
	private static final boolean on = true;
	private static final boolean off = false;
	private IMarkVITimingAndMemoryWriteControl systemUnderTest;

	private int getAddress() {
		int address = 0;
		address |= (systemUnderTest.getA0() ? bit0 : 0);
		address |= (systemUnderTest.getA1() ? bit1 : 0);
		address |= (systemUnderTest.getA2() ? bit2 : 0);
		address |= (systemUnderTest.getA3() ? bit3 : 0);
		address |= (systemUnderTest.getA4() ? bit4 : 0);
		address |= (systemUnderTest.getA5() ? bit5 : 0);
		address |= (systemUnderTest.getA6() ? bit6 : 0);
		address |= (systemUnderTest.getA7() ? bit7 : 0);
		address |= (systemUnderTest.getA8() ? bit8 : 0);
		address |= (systemUnderTest.getA9() ? bit9 : 0);
		address |= (systemUnderTest.getAA() ? bitA : 0);
		address |= (systemUnderTest.getAB() ? bitB : 0);
		address |= (systemUnderTest.getAC() ? bitC : 0);
		address |= (systemUnderTest.getAD() ? bitD : 0);
		address |= (systemUnderTest.getAE() ? bitE : 0);
		address |= (systemUnderTest.getAF() ? bitF : 0);
		return address;
	}

	@Before
	public void Setup() {
		systemUnderTest = new MarkVITimingAndMemoryWriteControl();
		systemUnderTest.setPower(on);
	}

	@Test
	public void test_AddressBecomesZero_WhenClearIsTurnedOn() {
		for (int i = 0; i < 4; i++) {
			systemUnderTest.step();
		}
		systemUnderTest.setClear(on);
		systemUnderTest.step();
		assertEquals(0, getAddress());
	}

	@Test
	public void test_WhenClearIsOff_AddressStepsEveryClockCycle() {
		for (int i = 0; i < 65536; i++) {
			systemUnderTest.step();
			systemUnderTest.step();
			assertEquals(String.format("i == %d ", i), i, getAddress());
		}
	}

	@Test
	public void test_WhenClearIsOff_ClockStartsOffAndCyclesOnAndOffThroughMultipleSteps() {
		for (int i = 0; i < 4; i++) {
			systemUnderTest.step();
			assertEquals(String.format("i == %d ", i), i % 2 == 0 ? off : on,
					systemUnderTest.getClock());
		}
	}

	@Test
	public void test_WhenClearIsOn_AddressRemainsZeroThroughMultipleSteps() {
		systemUnderTest.setClear(on);
		for (int i = 0; i < 4; i++) {
			systemUnderTest.step();
			assertEquals(String.format("i == %d ", i), 0, getAddress());
		}

	}

	@Test
	public void test_WhenClearIsOn_ClockRemainsOffThroughMultipleSteps() {
		systemUnderTest.setClear(on);
		for (int i = 0; i < 4; i++) {
			systemUnderTest.step();
			assertEquals(String.format("i == %d ", i), off,
					systemUnderTest.getClock());
		}
	}

	@Test
	public void test_WhenHaltIsTurnedOn_AddressStopsAdvancing() {
		for (int address = 0; address < 32768; address++) {
			systemUnderTest.step();
			systemUnderTest.step();
		}
		int expectedAddress = getAddress();

		systemUnderTest.setHalt(on);

		for (int address = 32768; address < 65536; address++) {
			systemUnderTest.step();
			systemUnderTest.step();
			assertEquals(expectedAddress, getAddress());
		}
	}

	@Test
	public void test_WhenStoreIsOff_WriteIsOffThroughMultipleSteps() {
		for (int i = 0; i < 4; i++) {
			systemUnderTest.step();
			assertEquals(String.format("i == %d ", i), off,
					systemUnderTest.getWrite());
		}
	}

	@Test
	public void test_WhenStoreIsOn_WriteIsOffWheneverClockIsOn() {
		systemUnderTest.setStore(on);
		for (int i = 0; i < 4; i++) {
			systemUnderTest.step();
			if (systemUnderTest.getClock()) {
				assertEquals(String.format("i == %d ", i), off,
						systemUnderTest.getWrite());
			}
		}
	}

	@Test
	public void test_WhenStoreIsOn_WriteIsOnWheneverClockIsOff() {
		systemUnderTest.setStore(on);
		for (int i = 0; i < 4; i++) {
			systemUnderTest.step();
			if (!systemUnderTest.getClock()) {
				assertEquals(String.format("i == %d ", i), on,
						systemUnderTest.getWrite());
			}
		}
	}
}

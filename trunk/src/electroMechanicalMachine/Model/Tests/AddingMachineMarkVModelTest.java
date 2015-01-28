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
import static electroMechanicalLogic.Tests.TestConstants.bit8;
import static electroMechanicalLogic.Tests.TestConstants.bit9;
import static electroMechanicalLogic.Tests.TestConstants.bitA;
import static electroMechanicalLogic.Tests.TestConstants.bitB;
import static electroMechanicalLogic.Tests.TestConstants.bitC;
import static electroMechanicalLogic.Tests.TestConstants.bitD;
import static electroMechanicalLogic.Tests.TestConstants.bitE;
import static electroMechanicalLogic.Tests.TestConstants.bitF;
import static electroMechanicalLogic.Tests.TestConstants.off;
import static electroMechanicalLogic.Tests.TestConstants.on;
import static electroMechanicalLogic.Tests.TestUtilities.getDataOut;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalLogic.RAM.Fast.SixtyFourKilobyteRAM;
import electroMechanicalMachine.Model.AddingMachineMarkVModel;
import electroMechanicalMachine.Model.Interfaces.IAddingMachineMarkVModel;

public class AddingMachineMarkVModelTest {
	private IAddingMachineMarkVModel systemUnderTest;
	private boolean eventFired = false;

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

	private void performOneClockCycle() {
		systemUnderTest.step();
		systemUnderTest.step();
	}

	private void setAddress(final int address) {
		systemUnderTest.setA0((address & bit0) == bit0 ? on : off);
		systemUnderTest.setA1((address & bit1) == bit1 ? on : off);
		systemUnderTest.setA2((address & bit2) == bit2 ? on : off);
		systemUnderTest.setA3((address & bit3) == bit3 ? on : off);
		systemUnderTest.setA4((address & bit4) == bit4 ? on : off);
		systemUnderTest.setA5((address & bit5) == bit5 ? on : off);
		systemUnderTest.setA6((address & bit6) == bit6 ? on : off);
		systemUnderTest.setA7((address & bit7) == bit7 ? on : off);
		systemUnderTest.setA8((address & bit8) == bit8 ? on : off);
		systemUnderTest.setA9((address & bit9) == bit9 ? on : off);
		systemUnderTest.setAA((address & bitA) == bitA ? on : off);
		systemUnderTest.setAB((address & bitB) == bitB ? on : off);
		systemUnderTest.setAC((address & bitC) == bitC ? on : off);
		systemUnderTest.setAD((address & bitD) == bitD ? on : off);
		systemUnderTest.setAE((address & bitE) == bitE ? on : off);
		systemUnderTest.setAF((address & bitF) == bitF ? on : off);
	}

	private void setDataIn(final int value) {
		systemUnderTest.setDI0(((value & bit0) == bit0) ? on : off);
		systemUnderTest.setDI1(((value & bit1) == bit1) ? on : off);
		systemUnderTest.setDI2(((value & bit2) == bit2) ? on : off);
		systemUnderTest.setDI3(((value & bit3) == bit3) ? on : off);
		systemUnderTest.setDI4(((value & bit4) == bit4) ? on : off);
		systemUnderTest.setDI5(((value & bit5) == bit5) ? on : off);
		systemUnderTest.setDI6(((value & bit6) == bit6) ? on : off);
		systemUnderTest.setDI7(((value & bit7) == bit7) ? on : off);
	}

	@Before
	public void setUp() throws Exception {
		systemUnderTest = new AddingMachineMarkVModel(
				new SixtyFourKilobyteRAM());
		systemUnderTest.setPower(on);
		systemUnderTest.setClear(on);
		systemUnderTest.setTakeover(off);
		systemUnderTest.step();
	}

	@Test
	public void test_A0On_RepresentsADifferentAddressThanA0Off() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA0(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();
		systemUnderTest.setA0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A0On_RepresentsADifferentAddressThanA1On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA0(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA0(off);
		systemUnderTest.setA1(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A0On_RepresentsADifferentAddressThanA2On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA0(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA0(off);
		systemUnderTest.setA2(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A0On_RepresentsADifferentAddressThanA3On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA0(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA0(off);
		systemUnderTest.setA3(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A0On_RepresentsADifferentAddressThanA4On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA0(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA0(off);
		systemUnderTest.setA4(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A0On_RepresentsADifferentAddressThanA5On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA0(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA0(off);
		systemUnderTest.setA5(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A0On_RepresentsADifferentAddressThanA6On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA0(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA0(off);
		systemUnderTest.setA6(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A0On_RepresentsADifferentAddressThanA7On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA0(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA0(off);
		systemUnderTest.setA7(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A0On_RepresentsADifferentAddressThanA8On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA0(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA0(off);
		systemUnderTest.setA8(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A0On_RepresentsADifferentAddressThanA9On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA0(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA0(off);
		systemUnderTest.setA9(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A0On_RepresentsADifferentAddressThanAAOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA0(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA0(off);
		systemUnderTest.setAA(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A0On_RepresentsADifferentAddressThanABOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA0(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA0(off);
		systemUnderTest.setAB(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A0On_RepresentsADifferentAddressThanACOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA0(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA0(off);
		systemUnderTest.setAC(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A0On_RepresentsADifferentAddressThanADOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA0(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA0(off);
		systemUnderTest.setAD(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A0On_RepresentsADifferentAddressThanAEOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA0(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA0(off);
		systemUnderTest.setAE(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A0On_RepresentsADifferentAddressThanAFOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA0(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA0(off);
		systemUnderTest.setAF(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A1On_RepresentsADifferentAddressThanA1Off() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA1(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();
		systemUnderTest.setA1(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A1On_RepresentsADifferentAddressThanA2On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA1(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA1(off);
		systemUnderTest.setA2(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A1On_RepresentsADifferentAddressThanA3On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA1(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA1(off);
		systemUnderTest.setA3(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A1On_RepresentsADifferentAddressThanA4On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA1(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA1(off);
		systemUnderTest.setA4(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A1On_RepresentsADifferentAddressThanA5On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA1(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA1(off);
		systemUnderTest.setA5(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A1On_RepresentsADifferentAddressThanA6On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA1(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA1(off);
		systemUnderTest.setA6(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A1On_RepresentsADifferentAddressThanA7On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA1(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA1(off);
		systemUnderTest.setA7(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A1On_RepresentsADifferentAddressThanA8On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA1(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA1(off);
		systemUnderTest.setA8(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A1On_RepresentsADifferentAddressThanA9On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA1(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA1(off);
		systemUnderTest.setA9(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A1On_RepresentsADifferentAddressThanAAOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA1(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA1(off);
		systemUnderTest.setAA(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A1On_RepresentsADifferentAddressThanABOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA1(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA1(off);
		systemUnderTest.setAB(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A1On_RepresentsADifferentAddressThanACOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA1(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA1(off);
		systemUnderTest.setAC(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A1On_RepresentsADifferentAddressThanADOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA1(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA1(off);
		systemUnderTest.setAD(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A1On_RepresentsADifferentAddressThanAEOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA1(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA1(off);
		systemUnderTest.setAE(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A1On_RepresentsADifferentAddressThanAFOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA1(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA1(off);
		systemUnderTest.setAF(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A2On_RepresentsADifferentAddressThanA2Off() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA2(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();
		systemUnderTest.setA2(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A2On_RepresentsADifferentAddressThanA3On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA2(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA2(off);
		systemUnderTest.setA3(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A2On_RepresentsADifferentAddressThanA4On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA2(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA2(off);
		systemUnderTest.setA4(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A2On_RepresentsADifferentAddressThanA5On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA2(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA2(off);
		systemUnderTest.setA5(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A2On_RepresentsADifferentAddressThanA6On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA2(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA2(off);
		systemUnderTest.setA6(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A2On_RepresentsADifferentAddressThanA7On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA2(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA2(off);
		systemUnderTest.setA7(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A2On_RepresentsADifferentAddressThanA8On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA2(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA2(off);
		systemUnderTest.setA8(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A2On_RepresentsADifferentAddressThanA9On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA2(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA2(off);
		systemUnderTest.setA9(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A2On_RepresentsADifferentAddressThanAAOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA2(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA2(off);
		systemUnderTest.setAA(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A2On_RepresentsADifferentAddressThanABOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA2(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA2(off);
		systemUnderTest.setAB(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A2On_RepresentsADifferentAddressThanACOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA2(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA2(off);
		systemUnderTest.setAC(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A2On_RepresentsADifferentAddressThanADOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA2(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA2(off);
		systemUnderTest.setAD(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A2On_RepresentsADifferentAddressThanAEOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA2(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA2(off);
		systemUnderTest.setAE(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A2On_RepresentsADifferentAddressThanAFOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA2(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA2(off);
		systemUnderTest.setAF(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A3On_RepresentsADifferentAddressThanA3Off() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA3(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();
		systemUnderTest.setA3(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A3On_RepresentsADifferentAddressThanA4On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA3(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA3(off);
		systemUnderTest.setA4(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A3On_RepresentsADifferentAddressThanA5On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA3(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA3(off);
		systemUnderTest.setA5(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A3On_RepresentsADifferentAddressThanA6On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA3(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA3(off);
		systemUnderTest.setA6(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A3On_RepresentsADifferentAddressThanA7On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA3(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA3(off);
		systemUnderTest.setA7(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A3On_RepresentsADifferentAddressThanA8On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA3(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA3(off);
		systemUnderTest.setA8(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A3On_RepresentsADifferentAddressThanA9On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA3(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA3(off);
		systemUnderTest.setA9(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A3On_RepresentsADifferentAddressThanAAOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA3(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA3(off);
		systemUnderTest.setAA(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A3On_RepresentsADifferentAddressThanABOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA3(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA3(off);
		systemUnderTest.setAB(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A3On_RepresentsADifferentAddressThanACOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA3(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA3(off);
		systemUnderTest.setAC(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A3On_RepresentsADifferentAddressThanADOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA3(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA3(off);
		systemUnderTest.setAD(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A3On_RepresentsADifferentAddressThanAEOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA3(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA3(off);
		systemUnderTest.setAE(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A3On_RepresentsADifferentAddressThanAFOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA3(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA3(off);
		systemUnderTest.setAF(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A4On_RepresentsADifferentAddressThanA4Off() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA4(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();
		systemUnderTest.setA4(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A4On_RepresentsADifferentAddressThanA5On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA4(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA4(off);
		systemUnderTest.setA5(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A4On_RepresentsADifferentAddressThanA6On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA4(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA4(off);
		systemUnderTest.setA6(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A4On_RepresentsADifferentAddressThanA7On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA4(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA4(off);
		systemUnderTest.setA7(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A4On_RepresentsADifferentAddressThanA8On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA4(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA4(off);
		systemUnderTest.setA8(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A4On_RepresentsADifferentAddressThanA9On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA4(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA4(off);
		systemUnderTest.setA9(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A4On_RepresentsADifferentAddressThanAAOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA4(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA4(off);
		systemUnderTest.setAA(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A4On_RepresentsADifferentAddressThanABOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA4(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA4(off);
		systemUnderTest.setAB(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A4On_RepresentsADifferentAddressThanACOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA4(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA4(off);
		systemUnderTest.setAC(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A4On_RepresentsADifferentAddressThanADOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA4(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA4(off);
		systemUnderTest.setAD(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A4On_RepresentsADifferentAddressThanAEOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA4(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA4(off);
		systemUnderTest.setAE(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A4On_RepresentsADifferentAddressThanAFOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA4(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA4(off);
		systemUnderTest.setAF(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A5On_RepresentsADifferentAddressThanA5Off() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA5(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();
		systemUnderTest.setA5(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A5On_RepresentsADifferentAddressThanA6On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA5(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA5(off);
		systemUnderTest.setA6(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A5On_RepresentsADifferentAddressThanA7On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA5(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA5(off);
		systemUnderTest.setA7(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A5On_RepresentsADifferentAddressThanA8On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA5(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA5(off);
		systemUnderTest.setA8(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A5On_RepresentsADifferentAddressThanA9On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA5(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA5(off);
		systemUnderTest.setA9(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A5On_RepresentsADifferentAddressThanAAOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA5(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA5(off);
		systemUnderTest.setAA(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A5On_RepresentsADifferentAddressThanABOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA5(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA5(off);
		systemUnderTest.setAB(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A5On_RepresentsADifferentAddressThanACOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA5(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA5(off);
		systemUnderTest.setAC(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A5On_RepresentsADifferentAddressThanADOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA5(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA5(off);
		systemUnderTest.setAD(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A5On_RepresentsADifferentAddressThanAEOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA5(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA5(off);
		systemUnderTest.setAE(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A5On_RepresentsADifferentAddressThanAFOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA5(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA5(off);
		systemUnderTest.setAF(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A6On_RepresentsADifferentAddressThanA6Off() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA6(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();
		systemUnderTest.setA6(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A6On_RepresentsADifferentAddressThanA7On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA6(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA6(off);
		systemUnderTest.setA7(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A6On_RepresentsADifferentAddressThanA8On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA6(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA6(off);
		systemUnderTest.setA8(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A6On_RepresentsADifferentAddressThanA9On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA6(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA6(off);
		systemUnderTest.setA9(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A6On_RepresentsADifferentAddressThanAAOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA6(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA6(off);
		systemUnderTest.setAA(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A6On_RepresentsADifferentAddressThanABOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA6(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA6(off);
		systemUnderTest.setAB(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A6On_RepresentsADifferentAddressThanACOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA6(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA6(off);
		systemUnderTest.setAC(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A6On_RepresentsADifferentAddressThanADOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA6(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA6(off);
		systemUnderTest.setAD(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A6On_RepresentsADifferentAddressThanAEOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA6(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA6(off);
		systemUnderTest.setAE(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A6On_RepresentsADifferentAddressThanAFOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA6(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA6(off);
		systemUnderTest.setAF(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A7On_RepresentsADifferentAddressThanA7Off() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA7(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();
		systemUnderTest.setA7(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A7On_RepresentsADifferentAddressThanA8On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA7(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA7(off);
		systemUnderTest.setA8(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A7On_RepresentsADifferentAddressThanA9On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA7(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA7(off);
		systemUnderTest.setA9(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A7On_RepresentsADifferentAddressThanAAOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA7(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA7(off);
		systemUnderTest.setAA(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A7On_RepresentsADifferentAddressThanABOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA7(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA7(off);
		systemUnderTest.setAB(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A7On_RepresentsADifferentAddressThanACOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA7(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA7(off);
		systemUnderTest.setAC(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A7On_RepresentsADifferentAddressThanADOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA7(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA7(off);
		systemUnderTest.setAD(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A7On_RepresentsADifferentAddressThanAEOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA7(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA7(off);
		systemUnderTest.setAE(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A7On_RepresentsADifferentAddressThanAFOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA7(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA7(off);
		systemUnderTest.setAF(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A8On_RepresentsADifferentAddressThanA8Off() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA8(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();
		systemUnderTest.setA8(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A8On_RepresentsADifferentAddressThanA9On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA8(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA8(off);
		systemUnderTest.setA9(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A8On_RepresentsADifferentAddressThanAAOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA8(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA8(off);
		systemUnderTest.setAA(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A8On_RepresentsADifferentAddressThanABOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA8(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA8(off);
		systemUnderTest.setAB(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A8On_RepresentsADifferentAddressThanACOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA8(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA8(off);
		systemUnderTest.setAC(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A8On_RepresentsADifferentAddressThanADOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA8(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA8(off);
		systemUnderTest.setAD(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A8On_RepresentsADifferentAddressThanAEOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA8(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA8(off);
		systemUnderTest.setAE(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A8On_RepresentsADifferentAddressThanAFOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA8(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA8(off);
		systemUnderTest.setAF(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A9On_RepresentsADifferentAddressThanA9Off() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA9(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();
		systemUnderTest.setA9(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A9On_RepresentsADifferentAddressThanAAOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA9(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA9(off);
		systemUnderTest.setAA(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A9On_RepresentsADifferentAddressThanABOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA9(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA9(off);
		systemUnderTest.setAB(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A9On_RepresentsADifferentAddressThanACOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA9(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA9(off);
		systemUnderTest.setAC(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A9On_RepresentsADifferentAddressThanADOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA9(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA9(off);
		systemUnderTest.setAD(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A9On_RepresentsADifferentAddressThanAEOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA9(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA9(off);
		systemUnderTest.setAE(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_A9On_RepresentsADifferentAddressThanAFOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA9(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setA9(off);
		systemUnderTest.setAF(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_AAOn_RepresentsADifferentAddressThanAAOff() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setAA(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();
		systemUnderTest.setAA(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_AAOn_RepresentsADifferentAddressThanABOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setAA(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setAA(off);
		systemUnderTest.setAB(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_AAOn_RepresentsADifferentAddressThanACOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setAA(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setAA(off);
		systemUnderTest.setAC(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_AAOn_RepresentsADifferentAddressThanADOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setAA(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setAA(off);
		systemUnderTest.setAD(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_AAOn_RepresentsADifferentAddressThanAEOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setAA(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setAA(off);
		systemUnderTest.setAE(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_AAOn_RepresentsADifferentAddressThanAFOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setAA(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setAA(off);
		systemUnderTest.setAF(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_ABOn_RepresentsADifferentAddressThanABOff() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setAB(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();
		systemUnderTest.setAB(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_ABOn_RepresentsADifferentAddressThanACOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setAB(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setAB(off);
		systemUnderTest.setAC(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_ABOn_RepresentsADifferentAddressThanADOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setAB(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setAB(off);
		systemUnderTest.setAD(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_ABOn_RepresentsADifferentAddressThanAEOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setAB(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setAB(off);
		systemUnderTest.setAE(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_ABOn_RepresentsADifferentAddressThanAFOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setAB(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setAB(off);
		systemUnderTest.setAF(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_ACOn_RepresentsADifferentAddressThanACOff() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setAC(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();
		systemUnderTest.setAC(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_ACOn_RepresentsADifferentAddressThanADOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setAC(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setAC(off);
		systemUnderTest.setAD(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_ACOn_RepresentsADifferentAddressThanAEOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setAC(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setAC(off);
		systemUnderTest.setAE(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_ACOn_RepresentsADifferentAddressThanAFOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setAC(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setAC(off);
		systemUnderTest.setAF(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_ADOn_RepresentsADifferentAddressThanADOff() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setAD(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();
		systemUnderTest.setAD(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_ADOn_RepresentsADifferentAddressThanAEOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setAD(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setAD(off);
		systemUnderTest.setAE(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_ADOn_RepresentsADifferentAddressThanAFOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setAD(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setAD(off);
		systemUnderTest.setAF(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_AEOn_RepresentsADifferentAEdressThanAEOff() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setAE(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();
		systemUnderTest.setAE(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_AEOn_RepresentsADifferentAEdressThanAFOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setAE(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setAE(off);
		systemUnderTest.setAF(on);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_AFOn_RepresentsADifferentAEdressThanAFOff() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setAF(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();
		systemUnderTest.setAF(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_DataWrittenWithA0On_IsAvailableWithA0On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA0(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO0());
	}

	@Test
	public void test_DataWrittenWithA1On_IsAvailableWithA1On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA1(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO0());
	}

	@Test
	public void test_DataWrittenWithA2On_IsAvailableWithA2On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA2(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO0());
	}

	@Test
	public void test_DataWrittenWithA3On_IsAvailableWithA3On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA3(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO0());
	}

	@Test
	public void test_DataWrittenWithA4On_IsAvailableWithA4On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA4(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO0());
	}

	@Test
	public void test_DataWrittenWithA5On_IsAvailableWithA5On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA5(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO0());
	}

	@Test
	public void test_DataWrittenWithA6On_IsAvailableWithA6On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA6(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO0());
	}

	@Test
	public void test_DataWrittenWithA7On_IsAvailableWithA7On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA7(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO0());
	}

	@Test
	public void test_DataWrittenWithA8On_IsAvailableWithA8On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA8(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO0());
	}

	@Test
	public void test_DataWrittenWithA9On_IsAvailableWithA9On() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA9(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO0());
	}

	@Test
	public void test_DataWrittenWithAAOn_IsAvailableWithAAOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setAA(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO0());
	}

	@Test
	public void test_DataWrittenWithABOn_IsAvailableWithABOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setAB(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO0());
	}

	@Test
	public void test_DataWrittenWithACOn_IsAvailableWithACOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setAC(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO0());
	}

	@Test
	public void test_DataWrittenWithADOn_IsAvailableWithADOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setAD(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO0());
	}

	@Test
	public void test_DataWrittenWithAEOn_IsAvailableWithAEOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setAE(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO0());
	}

	@Test
	public void test_DataWrittenWithAFOn_IsAvailableWithAFOn() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setAF(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO0());
	}

	@Test
	public void test_Step_FiresPropertyChangeEvent() {
		systemUnderTest.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(final PropertyChangeEvent evt) {
				eventFired = true;
			}
		});
		systemUnderTest.step();
		assertTrue(eventFired);
	}

	@Test
	public void test_WhenCLearIsOn_SumIsZero() {
		systemUnderTest.setClear(on);
		systemUnderTest.step();

		assertEquals(0, getSum());
	}

	@Test
	public void test_WhenFirst100AddressesAreFilled_AllAreAddedCorrectlyThroughOneAddressCycle() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setClear(on);
		systemUnderTest.setW(on);
		for (int i = 0; i < 100; i++) {
			setAddress(i);
			setDataIn(i + 1);
			systemUnderTest.step();
		}
		for (int i = 100; i < 65536; i++) {
			setAddress(i);
			setDataIn(0);
			systemUnderTest.step();
		}

		systemUnderTest.setW(off);
		systemUnderTest.setTakeover(off);
		systemUnderTest.setClear(off);

		int expectedResult = 0;
		for (int i = 0; i < 100; i++) {
			performOneClockCycle();
			expectedResult += i + 1;
			expectedResult &= 0xff;
			assertEquals(String.format("i == %d ", i), expectedResult, getSum());
		}
		for (int i = 100; i < 65536; i++) {
			performOneClockCycle();
			assertEquals(String.format("i == %d ", i), expectedResult, getSum());
		}
	}

	@Test
	public void test_WhenTakeoverIsOff_DataAtFirstTwoAddressesIsAddedAfterTwoCycles() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setClear(on);
		systemUnderTest.setW(on);
		setDataIn(1);
		systemUnderTest.step();

		systemUnderTest.setA0(on);
		setDataIn(2);
		systemUnderTest.step();

		systemUnderTest.setW(off);
		systemUnderTest.setTakeover(off);
		systemUnderTest.setClear(off);
		performOneClockCycle();
		performOneClockCycle();

		assertEquals(3, getSum());
	}

	@Test
	public void test_WhenTakeoverIsOnAndNoDataHasBeenLoaded_DataOutIsZero() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WhenTakeoverIsOnDataAtAddressZeroHasOnlyBit0On_SumHasOnlyBit0OnAfterFirstAddition() {
		systemUnderTest.setClear(off);
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		performOneClockCycle();

		assertEquals(bit0, getSum());
	}

	@Test
	public void test_WhenTakeoverIsOnDataAtAddressZeroHasOnlyBit0OnAndClearIsOn_SumIsZeroAfterFirstAddition() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setClear(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		performOneClockCycle();

		assertEquals(0, getSum());
	}

	@Test
	public void test_WhenTakeoverIsOnDataAtAddressZeroHasOnlyBit1On_SumHasOnlyBit1OnAfterFirstAddition() {
		systemUnderTest.setClear(off);
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI1(on);
		systemUnderTest.setW(on);
		performOneClockCycle();

		assertEquals(bit1, getSum());
	}

	@Test
	public void test_WhenTakeoverIsOnDataAtAddressZeroHasOnlyBit1OnAndClearIsOn_SumIsZeroAfterFirstAddition() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setClear(on);
		systemUnderTest.setDI1(on);
		systemUnderTest.setW(on);
		performOneClockCycle();

		assertEquals(0, getSum());
	}

	@Test
	public void test_WhenTakeoverIsOnDataAtAddressZeroHasOnlyBit2On_SumHasOnlyBit2OnAfterFirstAddition() {
		systemUnderTest.setClear(off);
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI2(on);
		systemUnderTest.setW(on);
		performOneClockCycle();

		assertEquals(bit2, getSum());
	}

	@Test
	public void test_WhenTakeoverIsOnDataAtAddressZeroHasOnlyBit3On_SumHasOnlyBit3OnAfterFirstAddition() {
		systemUnderTest.setClear(off);
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI3(on);
		systemUnderTest.setW(on);
		performOneClockCycle();

		assertEquals(bit3, getSum());
	}

	@Test
	public void test_WhenTakeoverIsOnDataAtAddressZeroHasOnlyBit4On_SumHasOnlyBit4OnAfterFirstAddition() {
		systemUnderTest.setClear(off);
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI4(on);
		systemUnderTest.setW(on);
		performOneClockCycle();

		assertEquals(bit4, getSum());
	}

	@Test
	public void test_WhenTakeoverIsOnDataAtAddressZeroHasOnlyBit5On_SumHasOnlyBit5OnAfterFirstAddition() {
		systemUnderTest.setClear(off);
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI5(on);
		systemUnderTest.setW(on);
		performOneClockCycle();

		assertEquals(bit5, getSum());
	}

	@Test
	public void test_WhenTakeoverIsOnDataAtAddressZeroHasOnlyBit6On_SumHasOnlyBit6OnAfterFirstAddition() {
		systemUnderTest.setClear(off);
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI6(on);
		systemUnderTest.setW(on);
		performOneClockCycle();

		assertEquals(bit6, getSum());
	}

	@Test
	public void test_WhenTakeoverIsOnDataAtAddressZeroHasOnlyBit7On_SumHasOnlyBit7OnAfterFirstAddition() {
		systemUnderTest.setClear(off);
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI7(on);
		systemUnderTest.setW(on);
		performOneClockCycle();

		assertEquals(bit7, getSum());
	}

	@Test
	public void test_WhenTakeoverIsOnDataAtAddressZeroIs1_SumIsTwoAfterTwoCycles() {
		systemUnderTest.setClear(off);
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		performOneClockCycle();
		systemUnderTest.setW(off);
		performOneClockCycle();

		assertEquals(2, getSum());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI0_ChangesDO0() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI0_DoesNotChangeDO1() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO1());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI0_DoesNotChangeDO2() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO2());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI0_DoesNotChangeDO3() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO3());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI0_DoesNotChangeDO4() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO4());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI0_DoesNotChangeDO5() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO5());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI0_DoesNotChangeDO6() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO6());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI0_DoesNotChangeDO7() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO7());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI1_ChangesDO1() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI1(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO1());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI1_DoesNotChangeDO0() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI1(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI1_DoesNotChangeDO2() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI1(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO2());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI1_DoesNotChangeDO3() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI1(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO3());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI1_DoesNotChangeDO4() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI1(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO4());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI1_DoesNotChangeDO5() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI1(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO5());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI1_DoesNotChangeDO6() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI1(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO6());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI1_DoesNotChangeDO7() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI1(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO7());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI2_ChangesDO2() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI2(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO2());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI2_DoesNotChangeDO0() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI2(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI2_DoesNotChangeDO1() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI2(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO1());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI2_DoesNotChangeDO3() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI2(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO3());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI2_DoesNotChangeDO4() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI2(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO4());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI2_DoesNotChangeDO5() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI2(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO5());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI2_DoesNotChangeDO6() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI2(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO6());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI2_DoesNotChangeDO7() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI2(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO7());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI3_ChangesDO3() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI3(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO3());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI3_DoesNotChangeDO0() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI3(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI3_DoesNotChangeDO1() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI3(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO1());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI3_DoesNotChangeDO2() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI3(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO2());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI3_DoesNotChangeDO4() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI3(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO4());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI3_DoesNotChangeDO5() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI3(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO5());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI3_DoesNotChangeDO6() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI3(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO6());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI3_DoesNotChangeDO7() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI3(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO7());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI4_ChangesDO4() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI4(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO4());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI4_DoesNotChangeDO0() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI4(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI4_DoesNotChangeDO1() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI4(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO1());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI4_DoesNotChangeDO2() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI4(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO2());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI4_DoesNotChangeDO3() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI4(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO3());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI4_DoesNotChangeDO5() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI4(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO5());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI4_DoesNotChangeDO6() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI4(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO6());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI4_DoesNotChangeDO7() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI4(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO7());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI5_ChangesDO5() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI5(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO5());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI5_DoesNotChangeDO0() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI5(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI5_DoesNotChangeDO1() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI5(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO1());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI5_DoesNotChangeDO2() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI5(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO2());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI5_DoesNotChangeDO3() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI5(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO3());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI5_DoesNotChangeDO4() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI5(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO4());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI5_DoesNotChangeDO6() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI5(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO6());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI5_DoesNotChangeDO7() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI5(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO7());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI6_ChangesDO6() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI6(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO6());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI6_DoesNotChangeDO0() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI6(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI6_DoesNotChangeDO1() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI6(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO1());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI6_DoesNotChangeDO2() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI6(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO2());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI6_DoesNotChangeDO3() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI6(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO3());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI6_DoesNotChangeDO4() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI6(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO4());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI6_DoesNotChangeDO5() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI6(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO5());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI6_DoesNotChangeDO7() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI6(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO7());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI7_ChangesDO7() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI7(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO7());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI7_DoesNotChangeDO0() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI7(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI7_DoesNotChangeDO1() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI7(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO1());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI7_DoesNotChangeDO2() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI7(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO2());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI7_DoesNotChangeDO3() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI7(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO3());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI7_DoesNotChangeDO4() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI7(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO4());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI7_DoesNotChangeDO5() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI7(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO5());
	}

	@Test
	public void test_WithTakeoverOnWritingToDI7_DoesNotChangeDO6() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setDI7(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO6());
	}
}

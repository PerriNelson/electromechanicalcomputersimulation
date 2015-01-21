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

import electroMechanicalLogic.Fast.SixtyFourKilobyteRAM;
import electroMechanicalMachine.Model.AddingMachineMarkVIModel;
import electroMechanicalMachine.Model.Interfaces.IAddingMachineMarkVIModel;

public class AddingMachineMarkVIModelTest {
	private static final boolean on = true;
	private static final boolean off = false;
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

	private IAddingMachineMarkVIModel systemUnderTest;

	private void setAddress(int address) {
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
	
	private int getDataOut() {
		int dataOut = 0;
		dataOut |= systemUnderTest.getDO0() ? bit0 : 0;
		dataOut |= systemUnderTest.getDO1() ? bit1 : 0;
		dataOut |= systemUnderTest.getDO2() ? bit2 : 0;
		dataOut |= systemUnderTest.getDO3() ? bit3 : 0;
		dataOut |= systemUnderTest.getDO4() ? bit4 : 0;
		dataOut |= systemUnderTest.getDO5() ? bit5 : 0;
		dataOut |= systemUnderTest.getDO6() ? bit6 : 0;
		dataOut |= systemUnderTest.getDO7() ? bit7 : 0;
		return dataOut;
	}
	
	@Test
	public void test_DataWrittenWithUseCodePanelOn_CannotBeRetrievedWithUseCodePanelOff() {
		systemUnderTest.setTakeover(on);
		for (int i = 0; i < 65536; i++) {
			systemUnderTest.setUseCodePanel(on);
			systemUnderTest.step();
			
			setAddress(i);
			setDataIn(0xff);
			systemUnderTest.setW(on);
			systemUnderTest.step();
			
			systemUnderTest.setW(off);
			systemUnderTest.step();
			systemUnderTest.setUseCodePanel(off);
			systemUnderTest.step();
			
			assertEquals(0, getDataOut());
		}
	}
	
	@Test
	public void test_DataWrittenWithUseCodePanelOff_CannotBeRetrievedWithUseCodePanelOn() {
		systemUnderTest.setTakeover(on);
		for (int i = 0; i < 65536; i++) {
			systemUnderTest.setUseCodePanel(off);
			systemUnderTest.step();
			
			setAddress(i);
			setDataIn(0xff);
			systemUnderTest.setW(on);
			systemUnderTest.step();
			
			systemUnderTest.setW(off);
			systemUnderTest.step();
			systemUnderTest.setUseCodePanel(on);
			systemUnderTest.step();
			
			assertEquals(0, getDataOut());
		}
	}
	
	@Before
	public void Setup() {
		systemUnderTest = new AddingMachineMarkVIModel(
				new SixtyFourKilobyteRAM(), new SixtyFourKilobyteRAM());

		systemUnderTest.setPower(on);
		setAddress(0);
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA0_CannotBeRetrievedFromA1() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA0(on);
		systemUnderTest.step();
		systemUnderTest.setA0(off);
		systemUnderTest.setA1(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA0_CannotBeRetrievedFromA2() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA0(on);
		systemUnderTest.step();
		systemUnderTest.setA0(off);
		systemUnderTest.setA2(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA0_CannotBeRetrievedFromA3() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA0(on);
		systemUnderTest.step();
		systemUnderTest.setA0(off);
		systemUnderTest.setA3(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA0_CannotBeRetrievedFromA4() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA0(on);
		systemUnderTest.step();
		systemUnderTest.setA0(off);
		systemUnderTest.setA4(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA0_CannotBeRetrievedFromA5() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA0(on);
		systemUnderTest.step();
		systemUnderTest.setA0(off);
		systemUnderTest.setA5(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA0_CannotBeRetrievedFromA6() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA0(on);
		systemUnderTest.step();
		systemUnderTest.setA0(off);
		systemUnderTest.setA6(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA0_CannotBeRetrievedFromA7() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA0(on);
		systemUnderTest.step();
		systemUnderTest.setA0(off);
		systemUnderTest.setA7(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA0_CannotBeRetrievedFromA8() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA0(on);
		systemUnderTest.step();
		systemUnderTest.setA0(off);
		systemUnderTest.setA8(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA0_CannotBeRetrievedFromA9() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA0(on);
		systemUnderTest.step();
		systemUnderTest.setA0(off);
		systemUnderTest.setA9(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA0_CannotBeRetrievedFromAA() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA0(on);
		systemUnderTest.step();
		systemUnderTest.setA0(off);
		systemUnderTest.setAA(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA0_CannotBeRetrievedFromAB() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA0(on);
		systemUnderTest.step();
		systemUnderTest.setA0(off);
		systemUnderTest.setAB(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA0_CannotBeRetrievedFromAC() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA0(on);
		systemUnderTest.step();
		systemUnderTest.setA0(off);
		systemUnderTest.setAC(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA0_CannotBeRetrievedFromAD() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA0(on);
		systemUnderTest.step();
		systemUnderTest.setA0(off);
		systemUnderTest.setAD(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA0_CannotBeRetrievedFromAE() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA0(on);
		systemUnderTest.step();
		systemUnderTest.setA0(off);
		systemUnderTest.setAE(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA0_CannotBeRetrievedFromAF() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA0(on);
		systemUnderTest.step();
		systemUnderTest.setA0(off);
		systemUnderTest.setAF(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA1_CannotBeRetrievedFromA2() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA1(on);
		systemUnderTest.step();
		systemUnderTest.setA1(off);
		systemUnderTest.setA2(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA1_CannotBeRetrievedFromA3() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA1(on);
		systemUnderTest.step();
		systemUnderTest.setA1(off);
		systemUnderTest.setA3(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA1_CannotBeRetrievedFromA4() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA1(on);
		systemUnderTest.step();
		systemUnderTest.setA1(off);
		systemUnderTest.setA4(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA1_CannotBeRetrievedFromA5() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA1(on);
		systemUnderTest.step();
		systemUnderTest.setA1(off);
		systemUnderTest.setA5(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA1_CannotBeRetrievedFromA6() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA1(on);
		systemUnderTest.step();
		systemUnderTest.setA1(off);
		systemUnderTest.setA6(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA1_CannotBeRetrievedFromA7() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA1(on);
		systemUnderTest.step();
		systemUnderTest.setA1(off);
		systemUnderTest.setA7(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA1_CannotBeRetrievedFromA8() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA1(on);
		systemUnderTest.step();
		systemUnderTest.setA1(off);
		systemUnderTest.setA8(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA1_CannotBeRetrievedFromA9() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA1(on);
		systemUnderTest.step();
		systemUnderTest.setA1(off);
		systemUnderTest.setA9(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA1_CannotBeRetrievedFromAA() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA1(on);
		systemUnderTest.step();
		systemUnderTest.setA1(off);
		systemUnderTest.setAA(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA1_CannotBeRetrievedFromAB() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA1(on);
		systemUnderTest.step();
		systemUnderTest.setA1(off);
		systemUnderTest.setAB(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA1_CannotBeRetrievedFromAC() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA1(on);
		systemUnderTest.step();
		systemUnderTest.setA1(off);
		systemUnderTest.setAC(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA1_CannotBeRetrievedFromAD() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA1(on);
		systemUnderTest.step();
		systemUnderTest.setA1(off);
		systemUnderTest.setAD(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA1_CannotBeRetrievedFromAE() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA1(on);
		systemUnderTest.step();
		systemUnderTest.setA1(off);
		systemUnderTest.setAE(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA1_CannotBeRetrievedFromAF() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA1(on);
		systemUnderTest.step();
		systemUnderTest.setA1(off);
		systemUnderTest.setAF(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA2_CannotBeRetrievedFromA3() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA2(on);
		systemUnderTest.step();
		systemUnderTest.setA2(off);
		systemUnderTest.setA3(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA2_CannotBeRetrievedFromA4() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA2(on);
		systemUnderTest.step();
		systemUnderTest.setA2(off);
		systemUnderTest.setA4(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA2_CannotBeRetrievedFromA5() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA2(on);
		systemUnderTest.step();
		systemUnderTest.setA2(off);
		systemUnderTest.setA5(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA2_CannotBeRetrievedFromA6() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA2(on);
		systemUnderTest.step();
		systemUnderTest.setA2(off);
		systemUnderTest.setA6(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA2_CannotBeRetrievedFromA7() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA2(on);
		systemUnderTest.step();
		systemUnderTest.setA2(off);
		systemUnderTest.setA7(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA2_CannotBeRetrievedFromA8() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA2(on);
		systemUnderTest.step();
		systemUnderTest.setA2(off);
		systemUnderTest.setA8(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA2_CannotBeRetrievedFromA9() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA2(on);
		systemUnderTest.step();
		systemUnderTest.setA2(off);
		systemUnderTest.setA9(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA2_CannotBeRetrievedFromAA() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA2(on);
		systemUnderTest.step();
		systemUnderTest.setA2(off);
		systemUnderTest.setAA(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA2_CannotBeRetrievedFromAB() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA2(on);
		systemUnderTest.step();
		systemUnderTest.setA2(off);
		systemUnderTest.setAB(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA2_CannotBeRetrievedFromAC() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA2(on);
		systemUnderTest.step();
		systemUnderTest.setA2(off);
		systemUnderTest.setAC(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA2_CannotBeRetrievedFromAD() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA2(on);
		systemUnderTest.step();
		systemUnderTest.setA2(off);
		systemUnderTest.setAD(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA2_CannotBeRetrievedFromAE() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA2(on);
		systemUnderTest.step();
		systemUnderTest.setA2(off);
		systemUnderTest.setAE(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA2_CannotBeRetrievedFromAF() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA2(on);
		systemUnderTest.step();
		systemUnderTest.setA2(off);
		systemUnderTest.setAF(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA3_CannotBeRetrievedFromA4() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA3(on);
		systemUnderTest.step();
		systemUnderTest.setA3(off);
		systemUnderTest.setA4(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA3_CannotBeRetrievedFromA5() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA3(on);
		systemUnderTest.step();
		systemUnderTest.setA3(off);
		systemUnderTest.setA5(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA3_CannotBeRetrievedFromA6() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA3(on);
		systemUnderTest.step();
		systemUnderTest.setA3(off);
		systemUnderTest.setA6(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA3_CannotBeRetrievedFromA7() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA3(on);
		systemUnderTest.step();
		systemUnderTest.setA3(off);
		systemUnderTest.setA7(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA3_CannotBeRetrievedFromA8() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA3(on);
		systemUnderTest.step();
		systemUnderTest.setA3(off);
		systemUnderTest.setA8(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA3_CannotBeRetrievedFromA9() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA3(on);
		systemUnderTest.step();
		systemUnderTest.setA3(off);
		systemUnderTest.setA9(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA3_CannotBeRetrievedFromAA() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA3(on);
		systemUnderTest.step();
		systemUnderTest.setA3(off);
		systemUnderTest.setAA(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA3_CannotBeRetrievedFromAB() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA3(on);
		systemUnderTest.step();
		systemUnderTest.setA3(off);
		systemUnderTest.setAB(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA3_CannotBeRetrievedFromAC() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA3(on);
		systemUnderTest.step();
		systemUnderTest.setA3(off);
		systemUnderTest.setAC(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA3_CannotBeRetrievedFromAD() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA3(on);
		systemUnderTest.step();
		systemUnderTest.setA3(off);
		systemUnderTest.setAD(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA3_CannotBeRetrievedFromAE() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA3(on);
		systemUnderTest.step();
		systemUnderTest.setA3(off);
		systemUnderTest.setAE(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA3_CannotBeRetrievedFromAF() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA3(on);
		systemUnderTest.step();
		systemUnderTest.setA3(off);
		systemUnderTest.setAF(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA4_CannotBeRetrievedFromA5() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA4(on);
		systemUnderTest.step();
		systemUnderTest.setA4(off);
		systemUnderTest.setA5(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA4_CannotBeRetrievedFromA6() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA4(on);
		systemUnderTest.step();
		systemUnderTest.setA4(off);
		systemUnderTest.setA6(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA4_CannotBeRetrievedFromA7() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA4(on);
		systemUnderTest.step();
		systemUnderTest.setA4(off);
		systemUnderTest.setA7(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA4_CannotBeRetrievedFromA8() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA4(on);
		systemUnderTest.step();
		systemUnderTest.setA4(off);
		systemUnderTest.setA8(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA4_CannotBeRetrievedFromA9() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA4(on);
		systemUnderTest.step();
		systemUnderTest.setA4(off);
		systemUnderTest.setA9(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA4_CannotBeRetrievedFromAA() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA4(on);
		systemUnderTest.step();
		systemUnderTest.setA4(off);
		systemUnderTest.setAA(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA4_CannotBeRetrievedFromAB() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA4(on);
		systemUnderTest.step();
		systemUnderTest.setA4(off);
		systemUnderTest.setAB(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA4_CannotBeRetrievedFromAC() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA4(on);
		systemUnderTest.step();
		systemUnderTest.setA4(off);
		systemUnderTest.setAC(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA4_CannotBeRetrievedFromAD() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA4(on);
		systemUnderTest.step();
		systemUnderTest.setA4(off);
		systemUnderTest.setAD(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA4_CannotBeRetrievedFromAE() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA4(on);
		systemUnderTest.step();
		systemUnderTest.setA4(off);
		systemUnderTest.setAE(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA4_CannotBeRetrievedFromAF() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA4(on);
		systemUnderTest.step();
		systemUnderTest.setA4(off);
		systemUnderTest.setAF(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA5_CannotBeRetrievedFromA6() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA5(on);
		systemUnderTest.step();
		systemUnderTest.setA5(off);
		systemUnderTest.setA6(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA5_CannotBeRetrievedFromA7() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA5(on);
		systemUnderTest.step();
		systemUnderTest.setA5(off);
		systemUnderTest.setA7(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA5_CannotBeRetrievedFromA8() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA5(on);
		systemUnderTest.step();
		systemUnderTest.setA5(off);
		systemUnderTest.setA8(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA5_CannotBeRetrievedFromA9() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA5(on);
		systemUnderTest.step();
		systemUnderTest.setA5(off);
		systemUnderTest.setA9(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA5_CannotBeRetrievedFromAA() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA5(on);
		systemUnderTest.step();
		systemUnderTest.setA5(off);
		systemUnderTest.setAA(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA5_CannotBeRetrievedFromAB() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA5(on);
		systemUnderTest.step();
		systemUnderTest.setA5(off);
		systemUnderTest.setAB(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA5_CannotBeRetrievedFromAC() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA5(on);
		systemUnderTest.step();
		systemUnderTest.setA5(off);
		systemUnderTest.setAC(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA5_CannotBeRetrievedFromAD() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA5(on);
		systemUnderTest.step();
		systemUnderTest.setA5(off);
		systemUnderTest.setAD(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA5_CannotBeRetrievedFromAE() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA5(on);
		systemUnderTest.step();
		systemUnderTest.setA5(off);
		systemUnderTest.setAE(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA5_CannotBeRetrievedFromAF() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA5(on);
		systemUnderTest.step();
		systemUnderTest.setA5(off);
		systemUnderTest.setAF(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA6_CannotBeRetrievedFromA7() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA6(on);
		systemUnderTest.step();
		systemUnderTest.setA6(off);
		systemUnderTest.setA7(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA6_CannotBeRetrievedFromA8() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA6(on);
		systemUnderTest.step();
		systemUnderTest.setA6(off);
		systemUnderTest.setA8(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA6_CannotBeRetrievedFromA9() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA6(on);
		systemUnderTest.step();
		systemUnderTest.setA6(off);
		systemUnderTest.setA9(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA6_CannotBeRetrievedFromAA() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA6(on);
		systemUnderTest.step();
		systemUnderTest.setA6(off);
		systemUnderTest.setAA(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA6_CannotBeRetrievedFromAB() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA6(on);
		systemUnderTest.step();
		systemUnderTest.setA6(off);
		systemUnderTest.setAB(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA6_CannotBeRetrievedFromAC() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA6(on);
		systemUnderTest.step();
		systemUnderTest.setA6(off);
		systemUnderTest.setAC(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA6_CannotBeRetrievedFromAD() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA6(on);
		systemUnderTest.step();
		systemUnderTest.setA6(off);
		systemUnderTest.setAD(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA6_CannotBeRetrievedFromAE() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA6(on);
		systemUnderTest.step();
		systemUnderTest.setA6(off);
		systemUnderTest.setAE(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA6_CannotBeRetrievedFromAF() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA6(on);
		systemUnderTest.step();
		systemUnderTest.setA6(off);
		systemUnderTest.setAF(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA7_CannotBeRetrievedFromA8() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA7(on);
		systemUnderTest.step();
		systemUnderTest.setA7(off);
		systemUnderTest.setA8(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA7_CannotBeRetrievedFromA9() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA7(on);
		systemUnderTest.step();
		systemUnderTest.setA7(off);
		systemUnderTest.setA9(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA7_CannotBeRetrievedFromAA() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA7(on);
		systemUnderTest.step();
		systemUnderTest.setA7(off);
		systemUnderTest.setAA(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA7_CannotBeRetrievedFromAB() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA7(on);
		systemUnderTest.step();
		systemUnderTest.setA7(off);
		systemUnderTest.setAB(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA7_CannotBeRetrievedFromAC() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA7(on);
		systemUnderTest.step();
		systemUnderTest.setA7(off);
		systemUnderTest.setAC(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA7_CannotBeRetrievedFromAD() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA7(on);
		systemUnderTest.step();
		systemUnderTest.setA7(off);
		systemUnderTest.setAD(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA7_CannotBeRetrievedFromAE() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA7(on);
		systemUnderTest.step();
		systemUnderTest.setA7(off);
		systemUnderTest.setAE(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA7_CannotBeRetrievedFromAF() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA7(on);
		systemUnderTest.step();
		systemUnderTest.setA7(off);
		systemUnderTest.setAF(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA8_CannotBeRetrievedFromA9() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA8(on);
		systemUnderTest.step();
		systemUnderTest.setA8(off);
		systemUnderTest.setA9(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA8_CannotBeRetrievedFromAA() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA8(on);
		systemUnderTest.step();
		systemUnderTest.setA8(off);
		systemUnderTest.setAA(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA8_CannotBeRetrievedFromAB() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA8(on);
		systemUnderTest.step();
		systemUnderTest.setA8(off);
		systemUnderTest.setAB(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA8_CannotBeRetrievedFromAC() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA8(on);
		systemUnderTest.step();
		systemUnderTest.setA8(off);
		systemUnderTest.setAC(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA8_CannotBeRetrievedFromAD() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA8(on);
		systemUnderTest.step();
		systemUnderTest.setA8(off);
		systemUnderTest.setAD(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA8_CannotBeRetrievedFromAE() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA8(on);
		systemUnderTest.step();
		systemUnderTest.setA8(off);
		systemUnderTest.setAE(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA8_CannotBeRetrievedFromAF() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA8(on);
		systemUnderTest.step();
		systemUnderTest.setA8(off);
		systemUnderTest.setAF(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA9_CannotBeRetrievedFromAA() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA9(on);
		systemUnderTest.step();
		systemUnderTest.setA9(off);
		systemUnderTest.setAA(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA9_CannotBeRetrievedFromAB() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA9(on);
		systemUnderTest.step();
		systemUnderTest.setA9(off);
		systemUnderTest.setAB(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA9_CannotBeRetrievedFromAC() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA9(on);
		systemUnderTest.step();
		systemUnderTest.setA9(off);
		systemUnderTest.setAC(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA9_CannotBeRetrievedFromAD() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA9(on);
		systemUnderTest.step();
		systemUnderTest.setA9(off);
		systemUnderTest.setAD(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA9_CannotBeRetrievedFromAE() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA9(on);
		systemUnderTest.step();
		systemUnderTest.setA9(off);
		systemUnderTest.setAE(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToA9_CannotBeRetrievedFromAF() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA9(on);
		systemUnderTest.step();
		systemUnderTest.setA9(off);
		systemUnderTest.setAF(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToAA_CannotBeRetrievedFromAB() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setAA(on);
		systemUnderTest.step();
		systemUnderTest.setAA(off);
		systemUnderTest.setAB(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToAA_CannotBeRetrievedFromAC() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setAA(on);
		systemUnderTest.step();
		systemUnderTest.setAA(off);
		systemUnderTest.setAC(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToAA_CannotBeRetrievedFromAD() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setAA(on);
		systemUnderTest.step();
		systemUnderTest.setAA(off);
		systemUnderTest.setAD(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToAA_CannotBeRetrievedFromAE() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setAA(on);
		systemUnderTest.step();
		systemUnderTest.setAA(off);
		systemUnderTest.setAE(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToAA_CannotBeRetrievedFromAF() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setAA(on);
		systemUnderTest.step();
		systemUnderTest.setAA(off);
		systemUnderTest.setAF(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToAB_CannotBeRetrievedFromAC() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setAB(on);
		systemUnderTest.step();
		systemUnderTest.setAB(off);
		systemUnderTest.setAC(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToAB_CannotBeRetrievedFromAD() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setAB(on);
		systemUnderTest.step();
		systemUnderTest.setAB(off);
		systemUnderTest.setAD(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToAB_CannotBeRetrievedFromAE() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setAB(on);
		systemUnderTest.step();
		systemUnderTest.setAB(off);
		systemUnderTest.setAE(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToAB_CannotBeRetrievedFromAF() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setAB(on);
		systemUnderTest.step();
		systemUnderTest.setAB(off);
		systemUnderTest.setAF(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToAC_CannotBeRetrievedFromAD() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setAC(on);
		systemUnderTest.step();
		systemUnderTest.setAC(off);
		systemUnderTest.setAD(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToAC_CannotBeRetrievedFromAE() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setAC(on);
		systemUnderTest.step();
		systemUnderTest.setAC(off);
		systemUnderTest.setAE(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToAC_CannotBeRetrievedFromAF() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setAC(on);
		systemUnderTest.step();
		systemUnderTest.setAC(off);
		systemUnderTest.setAF(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToAD_CannotBeRetrievedFromAE() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setAD(on);
		systemUnderTest.step();
		systemUnderTest.setAD(off);
		systemUnderTest.setAE(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToAD_CannotBeRetrievedFromAF() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setAD(on);
		systemUnderTest.step();
		systemUnderTest.setAD(off);
		systemUnderTest.setAF(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverAndUseCodePanelOn_DataWrittenToAE_CannotBeRetrievedFromAF() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setAE(on);
		systemUnderTest.step();
		systemUnderTest.setAE(off);
		systemUnderTest.setAF(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA0_CannotBeRetrievedFromA1() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA0(on);
		systemUnderTest.step();
		systemUnderTest.setA0(off);
		systemUnderTest.setA1(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA0_CannotBeRetrievedFromA2() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA0(on);
		systemUnderTest.step();
		systemUnderTest.setA0(off);
		systemUnderTest.setA2(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA0_CannotBeRetrievedFromA3() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA0(on);
		systemUnderTest.step();
		systemUnderTest.setA0(off);
		systemUnderTest.setA3(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA0_CannotBeRetrievedFromA4() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA0(on);
		systemUnderTest.step();
		systemUnderTest.setA0(off);
		systemUnderTest.setA4(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA0_CannotBeRetrievedFromA5() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA0(on);
		systemUnderTest.step();
		systemUnderTest.setA0(off);
		systemUnderTest.setA5(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA0_CannotBeRetrievedFromA6() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA0(on);
		systemUnderTest.step();
		systemUnderTest.setA0(off);
		systemUnderTest.setA6(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA0_CannotBeRetrievedFromA7() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA0(on);
		systemUnderTest.step();
		systemUnderTest.setA0(off);
		systemUnderTest.setA7(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA0_CannotBeRetrievedFromA8() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA0(on);
		systemUnderTest.step();
		systemUnderTest.setA0(off);
		systemUnderTest.setA8(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA0_CannotBeRetrievedFromA9() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA0(on);
		systemUnderTest.step();
		systemUnderTest.setA0(off);
		systemUnderTest.setA9(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA0_CannotBeRetrievedFromAA() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA0(on);
		systemUnderTest.step();
		systemUnderTest.setA0(off);
		systemUnderTest.setAA(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA0_CannotBeRetrievedFromAB() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA0(on);
		systemUnderTest.step();
		systemUnderTest.setA0(off);
		systemUnderTest.setAB(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA0_CannotBeRetrievedFromAC() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA0(on);
		systemUnderTest.step();
		systemUnderTest.setA0(off);
		systemUnderTest.setAC(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA0_CannotBeRetrievedFromAD() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA0(on);
		systemUnderTest.step();
		systemUnderTest.setA0(off);
		systemUnderTest.setAD(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA0_CannotBeRetrievedFromAE() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA0(on);
		systemUnderTest.step();
		systemUnderTest.setA0(off);
		systemUnderTest.setAE(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA0_CannotBeRetrievedFromAF() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA0(on);
		systemUnderTest.step();
		systemUnderTest.setA0(off);
		systemUnderTest.setAF(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA0_CannotBeRetrievedWithA0Off() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA0(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();
		systemUnderTest.setA0(off);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA0WithUseCodePanelOn_CannotBeRetrievedFromA0WithUseCodePanelOff() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA0(on);
		systemUnderTest.step();
		systemUnderTest.setUseCodePanel(off);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA1_CannotBeRetrievedFromA2() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA1(on);
		systemUnderTest.step();
		systemUnderTest.setA1(off);
		systemUnderTest.setA2(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA1_CannotBeRetrievedFromA3() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA1(on);
		systemUnderTest.step();
		systemUnderTest.setA1(off);
		systemUnderTest.setA3(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA1_CannotBeRetrievedFromA4() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA1(on);
		systemUnderTest.step();
		systemUnderTest.setA1(off);
		systemUnderTest.setA4(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA1_CannotBeRetrievedFromA5() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA1(on);
		systemUnderTest.step();
		systemUnderTest.setA1(off);
		systemUnderTest.setA5(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA1_CannotBeRetrievedFromA6() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA1(on);
		systemUnderTest.step();
		systemUnderTest.setA1(off);
		systemUnderTest.setA6(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA1_CannotBeRetrievedFromA7() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA1(on);
		systemUnderTest.step();
		systemUnderTest.setA1(off);
		systemUnderTest.setA7(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA1_CannotBeRetrievedFromA8() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA1(on);
		systemUnderTest.step();
		systemUnderTest.setA1(off);
		systemUnderTest.setA8(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA1_CannotBeRetrievedFromA9() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA1(on);
		systemUnderTest.step();
		systemUnderTest.setA1(off);
		systemUnderTest.setA9(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA1_CannotBeRetrievedFromAA() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA1(on);
		systemUnderTest.step();
		systemUnderTest.setA1(off);
		systemUnderTest.setAA(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA1_CannotBeRetrievedFromAC() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA1(on);
		systemUnderTest.step();
		systemUnderTest.setA1(off);
		systemUnderTest.setAC(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA1_CannotBeRetrievedFromAD() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA1(on);
		systemUnderTest.step();
		systemUnderTest.setA1(off);
		systemUnderTest.setAD(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA1_CannotBeRetrievedFromAE() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA1(on);
		systemUnderTest.step();
		systemUnderTest.setA1(off);
		systemUnderTest.setAE(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA1_CannotBeRetrievedFromAF() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA1(on);
		systemUnderTest.step();
		systemUnderTest.setA1(off);
		systemUnderTest.setAF(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA1WithUseCodePanelOn_CannotBeRetrievedFromA1WithUseCodePanelOff() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA1(on);
		systemUnderTest.step();
		systemUnderTest.setUseCodePanel(off);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA2_CannotBeRetrievedFromA3() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA2(on);
		systemUnderTest.step();
		systemUnderTest.setA2(off);
		systemUnderTest.setA3(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA2_CannotBeRetrievedFromA4() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA2(on);
		systemUnderTest.step();
		systemUnderTest.setA2(off);
		systemUnderTest.setA4(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA2_CannotBeRetrievedFromA5() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA2(on);
		systemUnderTest.step();
		systemUnderTest.setA2(off);
		systemUnderTest.setA5(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA2_CannotBeRetrievedFromA6() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA2(on);
		systemUnderTest.step();
		systemUnderTest.setA2(off);
		systemUnderTest.setA6(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA2_CannotBeRetrievedFromA7() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA2(on);
		systemUnderTest.step();
		systemUnderTest.setA2(off);
		systemUnderTest.setA7(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA2_CannotBeRetrievedFromA8() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA2(on);
		systemUnderTest.step();
		systemUnderTest.setA2(off);
		systemUnderTest.setA8(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA2_CannotBeRetrievedFromA9() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA2(on);
		systemUnderTest.step();
		systemUnderTest.setA2(off);
		systemUnderTest.setA9(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA2_CannotBeRetrievedFromAA() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA2(on);
		systemUnderTest.step();
		systemUnderTest.setA2(off);
		systemUnderTest.setAA(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA2_CannotBeRetrievedFromAB() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA2(on);
		systemUnderTest.step();
		systemUnderTest.setA2(off);
		systemUnderTest.setAB(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA2_CannotBeRetrievedFromAC() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA2(on);
		systemUnderTest.step();
		systemUnderTest.setA2(off);
		systemUnderTest.setAC(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA2_CannotBeRetrievedFromAD() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA2(on);
		systemUnderTest.step();
		systemUnderTest.setA2(off);
		systemUnderTest.setAD(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA2_CannotBeRetrievedFromAE() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA2(on);
		systemUnderTest.step();
		systemUnderTest.setA2(off);
		systemUnderTest.setAE(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA2_CannotBeRetrievedFromAF() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA2(on);
		systemUnderTest.step();
		systemUnderTest.setA2(off);
		systemUnderTest.setAF(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA2WithUseCodePanelOn_CannotBeRetrievedFromA2WithUseCodePanelOff() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA2(on);
		systemUnderTest.step();
		systemUnderTest.setUseCodePanel(off);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA3_CannotBeRetrievedFromA4() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA3(on);
		systemUnderTest.step();
		systemUnderTest.setA3(off);
		systemUnderTest.setA4(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA3_CannotBeRetrievedFromA5() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA3(on);
		systemUnderTest.step();
		systemUnderTest.setA3(off);
		systemUnderTest.setA5(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA3_CannotBeRetrievedFromA6() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA3(on);
		systemUnderTest.step();
		systemUnderTest.setA3(off);
		systemUnderTest.setA6(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA3_CannotBeRetrievedFromA7() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA3(on);
		systemUnderTest.step();
		systemUnderTest.setA3(off);
		systemUnderTest.setA7(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA3_CannotBeRetrievedFromA8() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA3(on);
		systemUnderTest.step();
		systemUnderTest.setA3(off);
		systemUnderTest.setA8(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA3_CannotBeRetrievedFromA9() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA3(on);
		systemUnderTest.step();
		systemUnderTest.setA3(off);
		systemUnderTest.setA9(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA3_CannotBeRetrievedFromAA() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA3(on);
		systemUnderTest.step();
		systemUnderTest.setA3(off);
		systemUnderTest.setAA(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA3_CannotBeRetrievedFromAB() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA3(on);
		systemUnderTest.step();
		systemUnderTest.setA3(off);
		systemUnderTest.setAB(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA3_CannotBeRetrievedFromAC() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA3(on);
		systemUnderTest.step();
		systemUnderTest.setA3(off);
		systemUnderTest.setAC(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA3_CannotBeRetrievedFromAD() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA3(on);
		systemUnderTest.step();
		systemUnderTest.setA3(off);
		systemUnderTest.setAD(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA3_CannotBeRetrievedFromAE() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA3(on);
		systemUnderTest.step();
		systemUnderTest.setA3(off);
		systemUnderTest.setAE(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA3_CannotBeRetrievedFromAF() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA3(on);
		systemUnderTest.step();
		systemUnderTest.setA3(off);
		systemUnderTest.setAF(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA3WithUseCodePanelOn_CannotBeRetrievedFromA3WithUseCodePanelOff() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA3(on);
		systemUnderTest.step();
		systemUnderTest.setUseCodePanel(off);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA4_CannotBeRetrievedFromA5() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA4(on);
		systemUnderTest.step();
		systemUnderTest.setA4(off);
		systemUnderTest.setA5(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA4_CannotBeRetrievedFromA6() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA4(on);
		systemUnderTest.step();
		systemUnderTest.setA4(off);
		systemUnderTest.setA6(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA4_CannotBeRetrievedFromA7() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA4(on);
		systemUnderTest.step();
		systemUnderTest.setA4(off);
		systemUnderTest.setA7(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA4_CannotBeRetrievedFromA8() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA4(on);
		systemUnderTest.step();
		systemUnderTest.setA4(off);
		systemUnderTest.setA8(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA4_CannotBeRetrievedFromA9() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA4(on);
		systemUnderTest.step();
		systemUnderTest.setA4(off);
		systemUnderTest.setA9(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA4_CannotBeRetrievedFromAA() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA4(on);
		systemUnderTest.step();
		systemUnderTest.setA4(off);
		systemUnderTest.setAA(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA4_CannotBeRetrievedFromAB() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA4(on);
		systemUnderTest.step();
		systemUnderTest.setA4(off);
		systemUnderTest.setAB(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA4_CannotBeRetrievedFromAC() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA4(on);
		systemUnderTest.step();
		systemUnderTest.setA4(off);
		systemUnderTest.setAC(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA4_CannotBeRetrievedFromAD() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA4(on);
		systemUnderTest.step();
		systemUnderTest.setA4(off);
		systemUnderTest.setAD(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA4_CannotBeRetrievedFromAE() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA4(on);
		systemUnderTest.step();
		systemUnderTest.setA4(off);
		systemUnderTest.setAE(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA4_CannotBeRetrievedFromAF() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA4(on);
		systemUnderTest.step();
		systemUnderTest.setA4(off);
		systemUnderTest.setAF(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA4WithUseCodePanelOn_CannotBeRetrievedFromA4WithUseCodePanelOff() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA4(on);
		systemUnderTest.step();
		systemUnderTest.setUseCodePanel(off);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA5_CannotBeRetrievedFromA6() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA5(on);
		systemUnderTest.step();
		systemUnderTest.setA5(off);
		systemUnderTest.setA6(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA5_CannotBeRetrievedFromA7() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA5(on);
		systemUnderTest.step();
		systemUnderTest.setA5(off);
		systemUnderTest.setA7(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA5_CannotBeRetrievedFromA8() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA5(on);
		systemUnderTest.step();
		systemUnderTest.setA5(off);
		systemUnderTest.setA8(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA5_CannotBeRetrievedFromA9() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA5(on);
		systemUnderTest.step();
		systemUnderTest.setA5(off);
		systemUnderTest.setA9(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA5_CannotBeRetrievedFromAA() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA5(on);
		systemUnderTest.step();
		systemUnderTest.setA5(off);
		systemUnderTest.setAA(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA5_CannotBeRetrievedFromAB() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA5(on);
		systemUnderTest.step();
		systemUnderTest.setA5(off);
		systemUnderTest.setAB(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA5_CannotBeRetrievedFromAC() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA5(on);
		systemUnderTest.step();
		systemUnderTest.setA5(off);
		systemUnderTest.setAC(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA5_CannotBeRetrievedFromAD() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA5(on);
		systemUnderTest.step();
		systemUnderTest.setA5(off);
		systemUnderTest.setAD(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA5_CannotBeRetrievedFromAE() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA5(on);
		systemUnderTest.step();
		systemUnderTest.setA5(off);
		systemUnderTest.setAE(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA5_CannotBeRetrievedFromAF() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA5(on);
		systemUnderTest.step();
		systemUnderTest.setA5(off);
		systemUnderTest.setAF(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA5WithUseCodePanelOn_CannotBeRetrievedFromA5WithUseCodePanelOff() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA5(on);
		systemUnderTest.step();
		systemUnderTest.setUseCodePanel(off);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA6_CannotBeRetrievedFromA7() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA6(on);
		systemUnderTest.step();
		systemUnderTest.setA6(off);
		systemUnderTest.setA7(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA6_CannotBeRetrievedFromA8() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA6(on);
		systemUnderTest.step();
		systemUnderTest.setA6(off);
		systemUnderTest.setA8(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA6_CannotBeRetrievedFromA9() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA6(on);
		systemUnderTest.step();
		systemUnderTest.setA6(off);
		systemUnderTest.setA9(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA6_CannotBeRetrievedFromAA() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA6(on);
		systemUnderTest.step();
		systemUnderTest.setA6(off);
		systemUnderTest.setAA(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA6_CannotBeRetrievedFromAB() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA6(on);
		systemUnderTest.step();
		systemUnderTest.setA6(off);
		systemUnderTest.setAB(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA6_CannotBeRetrievedFromAC() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA6(on);
		systemUnderTest.step();
		systemUnderTest.setA6(off);
		systemUnderTest.setAC(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA6_CannotBeRetrievedFromAD() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA6(on);
		systemUnderTest.step();
		systemUnderTest.setA6(off);
		systemUnderTest.setAD(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA6_CannotBeRetrievedFromAE() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA6(on);
		systemUnderTest.step();
		systemUnderTest.setA6(off);
		systemUnderTest.setAE(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA6_CannotBeRetrievedFromAF() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA6(on);
		systemUnderTest.step();
		systemUnderTest.setA6(off);
		systemUnderTest.setAF(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA6WithUseCodePanelOn_CannotBeRetrievedFromA6WithUseCodePanelOff() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA6(on);
		systemUnderTest.step();
		systemUnderTest.setUseCodePanel(off);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA7_CannotBeRetrievedFromA8() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA7(on);
		systemUnderTest.step();
		systemUnderTest.setA7(off);
		systemUnderTest.setA8(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA7_CannotBeRetrievedFromA9() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA7(on);
		systemUnderTest.step();
		systemUnderTest.setA7(off);
		systemUnderTest.setA9(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA7_CannotBeRetrievedFromAA() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA7(on);
		systemUnderTest.step();
		systemUnderTest.setA7(off);
		systemUnderTest.setAA(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA7_CannotBeRetrievedFromAB() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA7(on);
		systemUnderTest.step();
		systemUnderTest.setA7(off);
		systemUnderTest.setAB(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA7_CannotBeRetrievedFromAC() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA7(on);
		systemUnderTest.step();
		systemUnderTest.setA7(off);
		systemUnderTest.setAC(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA7_CannotBeRetrievedFromAD() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA7(on);
		systemUnderTest.step();
		systemUnderTest.setA7(off);
		systemUnderTest.setAD(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA7_CannotBeRetrievedFromAE() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA7(on);
		systemUnderTest.step();
		systemUnderTest.setA7(off);
		systemUnderTest.setAE(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA7_CannotBeRetrievedFromAF() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA7(on);
		systemUnderTest.step();
		systemUnderTest.setA7(off);
		systemUnderTest.setAF(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA7WithUseCodePanelOn_CannotBeRetrievedFromA7WithUseCodePanelOff() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA7(on);
		systemUnderTest.step();
		systemUnderTest.setUseCodePanel(off);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA8_CannotBeRetrievedFromA9() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA8(on);
		systemUnderTest.step();
		systemUnderTest.setA8(off);
		systemUnderTest.setA9(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA8_CannotBeRetrievedFromAA() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA8(on);
		systemUnderTest.step();
		systemUnderTest.setA8(off);
		systemUnderTest.setAA(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA8_CannotBeRetrievedFromAB() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA8(on);
		systemUnderTest.step();
		systemUnderTest.setA8(off);
		systemUnderTest.setAB(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA8_CannotBeRetrievedFromAC() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA8(on);
		systemUnderTest.step();
		systemUnderTest.setA8(off);
		systemUnderTest.setAC(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA8_CannotBeRetrievedFromAD() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA8(on);
		systemUnderTest.step();
		systemUnderTest.setA8(off);
		systemUnderTest.setAD(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA8_CannotBeRetrievedFromAE() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA8(on);
		systemUnderTest.step();
		systemUnderTest.setA8(off);
		systemUnderTest.setAE(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA8_CannotBeRetrievedFromAF() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA8(on);
		systemUnderTest.step();
		systemUnderTest.setA8(off);
		systemUnderTest.setAF(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA8WithUseCodePanelOn_CannotBeRetrievedFromA8WithUseCodePanelOff() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA8(on);
		systemUnderTest.step();
		systemUnderTest.setUseCodePanel(off);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA9_CannotBeRetrievedFromAA() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA9(on);
		systemUnderTest.step();
		systemUnderTest.setA9(off);
		systemUnderTest.setAA(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA9_CannotBeRetrievedFromAB() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA9(on);
		systemUnderTest.step();
		systemUnderTest.setA9(off);
		systemUnderTest.setAB(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA9_CannotBeRetrievedFromAC() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA9(on);
		systemUnderTest.step();
		systemUnderTest.setA9(off);
		systemUnderTest.setAC(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA9_CannotBeRetrievedFromAD() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA9(on);
		systemUnderTest.step();
		systemUnderTest.setA9(off);
		systemUnderTest.setAD(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA9_CannotBeRetrievedFromAE() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA9(on);
		systemUnderTest.step();
		systemUnderTest.setA9(off);
		systemUnderTest.setAE(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA9_CannotBeRetrievedFromAF() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA9(on);
		systemUnderTest.step();
		systemUnderTest.setA9(off);
		systemUnderTest.setAF(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToA9WithUseCodePanelOn_CannotBeRetrievedFrom9FWithUseCodePanelOff() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA9(on);
		systemUnderTest.step();
		systemUnderTest.setUseCodePanel(off);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToAA_CannotBeRetrievedFromAB() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setAA(on);
		systemUnderTest.step();
		systemUnderTest.setAA(off);
		systemUnderTest.setAB(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToAA_CannotBeRetrievedFromAC() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setAA(on);
		systemUnderTest.step();
		systemUnderTest.setAA(off);
		systemUnderTest.setAC(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToAA_CannotBeRetrievedFromAD() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setAA(on);
		systemUnderTest.step();
		systemUnderTest.setAA(off);
		systemUnderTest.setAD(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToAA_CannotBeRetrievedFromAE() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setAA(on);
		systemUnderTest.step();
		systemUnderTest.setAA(off);
		systemUnderTest.setAE(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToAA_CannotBeRetrievedFromAF() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setAA(on);
		systemUnderTest.step();
		systemUnderTest.setAA(off);
		systemUnderTest.setAF(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToAAWithUseCodePanelOn_CannotBeRetrievedFromAAWithUseCodePanelOff() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setAA(on);
		systemUnderTest.step();
		systemUnderTest.setUseCodePanel(off);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToAB_CannotBeRetrievedFromAC() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setAB(on);
		systemUnderTest.step();
		systemUnderTest.setAB(off);
		systemUnderTest.setAC(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToAB_CannotBeRetrievedFromAD() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setAB(on);
		systemUnderTest.step();
		systemUnderTest.setAB(off);
		systemUnderTest.setAD(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToAB_CannotBeRetrievedFromAE() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setAB(on);
		systemUnderTest.step();
		systemUnderTest.setAB(off);
		systemUnderTest.setAE(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToAB_CannotBeRetrievedFromAF() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setAB(on);
		systemUnderTest.step();
		systemUnderTest.setAB(off);
		systemUnderTest.setAF(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToABWithUseCodePanelOn_CannotBeRetrievedFromABWithUseCodePanelOff() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setAB(on);
		systemUnderTest.step();
		systemUnderTest.setUseCodePanel(off);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToAC_CannotBeRetrievedFromAD() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setAC(on);
		systemUnderTest.step();
		systemUnderTest.setAC(off);
		systemUnderTest.setAD(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToAC_CannotBeRetrievedFromAE() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setAC(on);
		systemUnderTest.step();
		systemUnderTest.setAC(off);
		systemUnderTest.setAE(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToAC_CannotBeRetrievedFromAF() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setAC(on);
		systemUnderTest.step();
		systemUnderTest.setAC(off);
		systemUnderTest.setAF(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToACWithUseCodePanelOn_CannotBeRetrievedFromACWithUseCodePanelOff() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setAC(on);
		systemUnderTest.step();
		systemUnderTest.setUseCodePanel(off);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToAD_CannotBeRetrievedFromAE() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setAD(on);
		systemUnderTest.step();
		systemUnderTest.setAD(off);
		systemUnderTest.setAE(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToAD_CannotBeRetrievedFromAF() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setAD(on);
		systemUnderTest.step();
		systemUnderTest.setAD(off);
		systemUnderTest.setAF(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToADWithUseCodePanelOn_CannotBeRetrievedFromADWithUseCodePanelOff() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setAD(on);
		systemUnderTest.step();
		systemUnderTest.setUseCodePanel(off);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToAE_CannotBeRetrievedFromAF() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setAE(on);
		systemUnderTest.step();
		systemUnderTest.setAE(off);
		systemUnderTest.setAF(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToAEWithUseCodePanelOn_CannotBeRetrievedFromAEWithUseCodePanelOff() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setAE(on);
		systemUnderTest.step();
		systemUnderTest.setUseCodePanel(off);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOn_DataWrittenToAFWithUseCodePanelOn_CannotBeRetrievedFromAFWithUseCodePanelOff() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setAF(on);
		systemUnderTest.step();
		systemUnderTest.setUseCodePanel(off);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOnAndUseCodePanelOff_DataWrittenToA0_CanBeRetrievedFromA0() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(off);
		systemUnderTest.setA0(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOnAndUseCodePanelOff_DataWrittenToA1_CanBeRetrievedFromA1() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(off);
		systemUnderTest.setA1(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOnAndUseCodePanelOff_DataWrittenToA2_CanBeRetrievedFromA2() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(off);
		systemUnderTest.setA2(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOnAndUseCodePanelOff_DataWrittenToA3_CanBeRetrievedFromA3() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(off);
		systemUnderTest.setA3(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOnAndUseCodePanelOff_DataWrittenToA4_CanBeRetrievedFromA4() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(off);
		systemUnderTest.setA4(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOnAndUseCodePanelOff_DataWrittenToA5_CanBeRetrievedFromA5() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(off);
		systemUnderTest.setA5(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOnAndUseCodePanelOff_DataWrittenToA6_CanBeRetrievedFromA6() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(off);
		systemUnderTest.setA6(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOnAndUseCodePanelOff_DataWrittenToA7_CanBeRetrievedFromA7() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(off);
		systemUnderTest.setA7(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOnAndUseCodePanelOff_DataWrittenToA8_CanBeRetrievedFromA8() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(off);
		systemUnderTest.setA8(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOnAndUseCodePanelOff_DataWrittenToA9_CanBeRetrievedFromA9() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(off);
		systemUnderTest.setA9(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOnAndUseCodePanelOff_DataWrittenToAA_CanBeRetrievedFromAA() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(off);
		systemUnderTest.setAA(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOnAndUseCodePanelOff_DataWrittenToAB_CanBeRetrievedFromAB() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(off);
		systemUnderTest.setAB(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOnAndUseCodePanelOff_DataWrittenToAC_CanBeRetrievedFromAC() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(off);
		systemUnderTest.setAC(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOnAndUseCodePanelOff_DataWrittenToAD_CanBeRetrievedFromAD() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(off);
		systemUnderTest.setAD(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOnAndUseCodePanelOff_DataWrittenToAE_CanBeRetrievedFromAE() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(off);
		systemUnderTest.setAE(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOnAndUseCodePanelOff_DataWrittenToAF_CanBeRetrievedFromAF() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(off);
		systemUnderTest.setAF(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOnAndUseCodePanelOn_DataWrittenToA0_CanBeRetrievedFromA0() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA0(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOnAndUseCodePanelOn_DataWrittenToA0_CannotBeRetrievedWithA0Off() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA0(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();
		systemUnderTest.setA0(off);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOnAndUseCodePanelOn_DataWrittenToA1_CanBeRetrievedFromA1() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA1(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOnAndUseCodePanelOn_DataWrittenToA2_CanBeRetrievedFromA2() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA2(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOnAndUseCodePanelOn_DataWrittenToA3_CanBeRetrievedFromA3() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA3(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOnAndUseCodePanelOn_DataWrittenToA4_CanBeRetrievedFromA4() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA4(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOnAndUseCodePanelOn_DataWrittenToA5_CanBeRetrievedFromA5() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA5(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOnAndUseCodePanelOn_DataWrittenToA6_CanBeRetrievedFromA6() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA6(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOnAndUseCodePanelOn_DataWrittenToA7_CanBeRetrievedFromA7() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA7(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOnAndUseCodePanelOn_DataWrittenToA8_CanBeRetrievedFromA8() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA8(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOnAndUseCodePanelOn_DataWrittenToA9_CanBeRetrievedFromA9() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setA9(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOnAndUseCodePanelOn_DataWrittenToAA_CanBeRetrievedFromAA() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setAA(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOnAndUseCodePanelOn_DataWrittenToAB_CanBeRetrievedFromAB() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setAB(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOnAndUseCodePanelOn_DataWrittenToAC_CanBeRetrievedFromAC() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setAC(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOnAndUseCodePanelOn_DataWrittenToAD_CanBeRetrievedFromAD() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setAD(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOnAndUseCodePanelOn_DataWrittenToAE_CanBeRetrievedFromAE() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setAE(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverOnAndUseCodePanelOn_DataWrittenToAF_CanBeRetrievedFromAF() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setAF(on);
		systemUnderTest.setDI0(on);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		assertEquals(on, systemUnderTest.getDO0());
	}

	@Test
	public void test_WithTakeoverPanelOn_DataWrittenToA1_CannotBeRetrievedFromAB() {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setA1(on);
		systemUnderTest.step();
		systemUnderTest.setA1(off);
		systemUnderTest.setAB(on);
		systemUnderTest.setDI0(off);
		systemUnderTest.setW(off);
		systemUnderTest.step();

		assertEquals(off, systemUnderTest.getDO0());
	}
}
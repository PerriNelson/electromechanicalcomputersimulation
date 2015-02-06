/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Processor.Tests;

import static electroMechanicalMachine.Model.Tests.InstructionSet.ADC;
import static electroMechanicalMachine.Model.Tests.InstructionSet.ADD;
import static electroMechanicalMachine.Model.Tests.InstructionSet.HLT;
import static electroMechanicalMachine.Model.Tests.InstructionSet.JNZ;
import static electroMechanicalMachine.Model.Tests.InstructionSet.LOD;
import static electroMechanicalMachine.Model.Tests.InstructionSet.STO;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import electroMechanicalMachine.Processor.EMC0001;

public class TestEMC0001 extends TestAM0010 {

	@Override
	public void setProcessor() {
		setProcessor(new EMC0001());
	}

	@Test
	public void testAM0011_shouldGiveExpectedResults_forEightBitMultiplicationProgramFromBook() {
		final int[] code = { LOD, 0x10, 0x05, ADD, 0x10, 0x01, STO, 0x10, 0x05,
				LOD, 0x10, 0x04, ADC, 0x10, 0x00, STO, 0x10, 0x04, LOD, 0x10,
				0x03, ADD, 0x00, 0x1E, STO, 0x10, 0x03, JNZ, 0x00, 0x00, HLT };
		final int[] data = { 0x00, 0xA7, 0x00, 0x1C, 0x00, 0x00 };
		final int[] expectedValues = new int[] { 0x12, 0x44 };
		int[] actualValues = new int[expectedValues.length];

		loadRam(0, code);
		loadRam(0x1000, data);

		runProgram();

		readRam(0x1004, actualValues);
		for (int i = 0; i < expectedValues.length; i++) {
			assertEquals(expectedValues[i], actualValues[i]);
		}
	}

	@Test
	public void testECM0001_shouldGiveExpectedResults_whenJumpWithCarryAndCarryFlag() {

		// 0000 10,00,17 BEGIN: LOD A,[OP1] ; Load Operand 1
		// 0003 20,00,18 ADD A,[OP2] ; Add Operand 2
		// 0006 32,00,10 JC PASS ; Jump If Carry to PASS
		// 0009 10,00,19 LOD A,[FAIL] ; Load Failure
		// 000C 11,00,1B STO [RSLT],A ; Store Result
		// 000F FF HLT ; Stop
		// 0010 10,00,1A PASS: LOD A,[SCCS] ; Load Success
		// 0013 11,00,1B STO [RSLT],A ; Store Result
		// 0016 FF HLT ; Stop
		// 0017 FF OP1: #FF
		// 0018 01 OP2: #01
		// 0019 00 FAIL: #00
		// 001A FF SCCS: #FF
		// 001B 00 RSLT: #00 ; Expect FF

		final int[] code = { 0x10, 0x00, 0x17, 0x20, 0x00, 0x18, 0x32, 0x00,
				0x10, 0x10, 0x00, 0x19, 0x11, 0x00, 0x1B, 0xFF, 0x10, 0x00,
				0x1A, 0x11, 0x00, 0x1B, 0xFF, 0xFF, 0x01, 0x00, 0XFF, 0X00 };
		final int[] expectedValues = new int[] { 0xFF };
		int[] actualValues = new int[expectedValues.length];

		loadRam(0, code);

		runProgram();

		readRam(0x001B, actualValues);
		for (int i = 0; i < expectedValues.length; i++) {
			assertEquals(expectedValues[i], actualValues[i]);
		}
	}

}

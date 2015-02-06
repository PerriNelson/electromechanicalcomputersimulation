/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Processor.Tests;

import static electroMechanicalMachine.Model.Tests.InstructionSet.ADD;
import static electroMechanicalMachine.Model.Tests.InstructionSet.HLT;
import static electroMechanicalMachine.Model.Tests.InstructionSet.JMP;
import static electroMechanicalMachine.Model.Tests.InstructionSet.LOD;
import static electroMechanicalMachine.Model.Tests.InstructionSet.STO;
import static electroMechanicalMachine.Model.Tests.InstructionSet.SUB;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import electroMechanicalMachine.Processor.AM0011;

public class TestAM0011 extends TestAM0010 {

	@Override
	public void setProcessor() {
		setProcessor(new AM0011());
	}

	@Test
	public void testAM0011_shouldGiveExpectedResults_forMarkXIExampleProgramFromBook() {
		final int[] code1 = { LOD, 00, 0x10, ADD, 0x00, 0x11, SUB, 0x00, 0x12,
				STO, 0x00, 0x13, JMP, 0x00, 0x20 };
		final int[] code2 = { LOD, 00, 0x13, ADD, 0x00, 0x30, ADD, 0x00, 0x31,
				STO, 0x00, 0x32, HLT };
		final int[] data1 = { 0x45, 0xa9, 0x8e };
		final int[] data2 = { 0x43, 0x2f };
		final int[] expectedValues = new int[] { 0xD2 };
		int[] actualValues = new int[expectedValues.length];

		loadRam(0, code1);
		loadRam(0x20, code2);

		loadRam(0x0010, data1);
		loadRam(0x0030, data2);

		runProgram();

		readRam(0x0032, actualValues);
		for (int i = 0; i < expectedValues.length; i++) {
			assertEquals(expectedValues[i], actualValues[i]);
		}
	}

}

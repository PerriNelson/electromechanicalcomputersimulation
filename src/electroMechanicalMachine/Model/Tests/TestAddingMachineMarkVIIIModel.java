/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Model.Tests;

import static electroMechanicalLogic.Tests.TestConstants.on;
import static electroMechanicalLogic.Tests.TestUtilities.setAddress;
import static electroMechanicalMachine.Model.Tests.InstructionSet.ADC;
import static electroMechanicalMachine.Model.Tests.InstructionSet.ADD;
import static electroMechanicalMachine.Model.Tests.InstructionSet.HALT;
import static electroMechanicalMachine.Model.Tests.InstructionSet.LOD;
import static electroMechanicalMachine.Model.Tests.InstructionSet.SBB;
import static electroMechanicalMachine.Model.Tests.InstructionSet.STO;
import static electroMechanicalMachine.Model.Tests.InstructionSet.SUB;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalLogic.RAM.Fast.SixtyFourKilobyteRAM;
import electroMechanicalMachine.Model.AddingMachineMarkVIIIModel;

public class TestAddingMachineMarkVIIIModel extends
		AddingMachineMarkVIIModelTest {

	@Override
	@Before
	public void Setup() {
		systemUnderTest = new AddingMachineMarkVIIIModel(
				new SixtyFourKilobyteRAM(), new SixtyFourKilobyteRAM());

		systemUnderTest.setPower(on);
		setAddress(systemUnderTest, 0);
		systemUnderTest.setReset(on);
	}

	/**
	 * Adds 0x76ab (30379) and 0x232c (9004). Expected result is 0x99d7 (39383).
	 */
	@Test
	public void testAddingMachine_shouldProvideCorrectResults_forFirstExampleFromBook() {
		final int[] code = { LOD, ADD, STO, LOD, ADC, STO, HALT };
		final int[] data = { 0xab, 0x2c, 0x00, 0x76, 0x23 };

		loadCode(code);
		loadData(data);
		runProgram();

		assertEquals(0xd7, readData(2));
		assertEquals(0x99, readData(5));
	}

	/**
	 * Adds 0x7a892bcd (2055809997) and 0x65a872ff (1705538303). Expected result
	 * is 0xE0319ECC (3761348300).
	 */
	@Test
	public void testAddingMachine_shouldProvideCorrectResults_forSecondExampleFromBook() {
		final int[] code = { LOD, ADD, STO, LOD, ADC, STO, LOD, ADC, STO, LOD,
				ADC, STO, HALT };
		final int[] data = { 0xcd, 0xff, 0x00, 0x2b, 0x72, 0x00, 0x89, 0xa8,
				0x00, 0x7a, 0x65 };

		loadCode(code);
		loadData(data);
		runProgram();

		assertEquals(0xcc, readData(2));
		assertEquals(0x9e, readData(5));
		assertEquals(0x31, readData(8));
		assertEquals(0xe0, readData(11));
	}

	/**
	 * Subtracts 0x65a872ff (1705538303) from 0x7a892bcd (2055809997). Expected
	 * result is 0x14E0B8CE (350271694).
	 */
	@Test
	public void testAddingMachine_shouldProvideCorrectResults_forSubtraction() {
		final int[] code = { LOD, SUB, STO, LOD, SBB, STO, LOD, SBB, STO, LOD,
				SBB, STO, HALT };
		final int[] data = { 0xcd, 0xff, 0x00, 0x2b, 0x72, 0x00, 0x89, 0xa8,
				0x00, 0x7a, 0x65 };

		loadCode(code);
		loadData(data);
		runProgram();

		assertEquals(0xce, readData(2));
		assertEquals(0xb8, readData(5));
		assertEquals(0xe0, readData(8));
		assertEquals(0x14, readData(11));
	}
}

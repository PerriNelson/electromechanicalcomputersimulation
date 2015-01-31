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
import static electroMechanicalMachine.Model.Tests.InstructionSet.ADD;
import static electroMechanicalMachine.Model.Tests.InstructionSet.HALT;
import static electroMechanicalMachine.Model.Tests.InstructionSet.LOD;
import static electroMechanicalMachine.Model.Tests.InstructionSet.STO;
import static electroMechanicalMachine.Model.Tests.InstructionSet.SUB;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalLogic.RAM.Fast.SixtyFourKilobyteRAM;
import electroMechanicalMachine.Model.AddingMachineMarkVIIModel;

public class AddingMachineMarkVIIModelTest extends AddingMachineMarkVIModelTest {

	@Override
	@Before
	public void Setup() {
		systemUnderTest = new AddingMachineMarkVIIModel(
				new SixtyFourKilobyteRAM(), new SixtyFourKilobyteRAM());

		systemUnderTest.setPower(on);
		setAddress(systemUnderTest, 0);
		systemUnderTest.setReset(on);
	}

	protected int subtract(final int a, final int b) {
		return (a - b) & 0xff;
	}

	@Test
	public void test_LoadANumberSubtractItStoreResult_ResultIsZero() {
		int[] code = { LOD, SUB, STO, HALT };
		int[] data = { 0x56, 0x56, 0xAA };

		loadCode(code);
		loadData(data);
		runProgram();

		assertEquals(0, readData(2));
	}

	@Test
	public void test_MarkVII_ExampleFromBook_ProducesExpectedResults() {
		int[] code = { LOD, ADD, SUB, STO, HALT };
		int[] data = { 0x56, 0x2A, 0x38 };

		loadCode(code);
		loadData(data);
		runProgram();

		assertEquals(subtract(add(0x56, 0x2A), 0x38), readData(3));
	}
}
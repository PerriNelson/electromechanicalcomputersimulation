/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Model.Tests;

import static electroMechanicalLogic.Tests.TestConstants.off;
import static electroMechanicalLogic.Tests.TestConstants.on;
import static electroMechanicalLogic.Tests.TestUtilities.getDataOut;
import static electroMechanicalLogic.Tests.TestUtilities.setAddress;
import static electroMechanicalLogic.Tests.TestUtilities.setDataIn;
import static electroMechanicalMachine.Model.Tests.InstructionSet.ADC;
import static electroMechanicalMachine.Model.Tests.InstructionSet.ADD;
import static electroMechanicalMachine.Model.Tests.InstructionSet.HALT;
import static electroMechanicalMachine.Model.Tests.InstructionSet.LOD;
import static electroMechanicalMachine.Model.Tests.InstructionSet.STO;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalLogic.RAM.Fast.SixtyFourKilobyteRAM;
import electroMechanicalMachine.Model.AddingMachineMarkIXModel;
import electroMechanicalMachine.Model.Interfaces.IAddingMachineMarkVIModel;

public class TestAddingMachineMarkIXModel {
	private IAddingMachineMarkVIModel systemUnderTest;

	@Before
	public void setUp() {
		systemUnderTest = new AddingMachineMarkIXModel(
				new SixtyFourKilobyteRAM(), new SixtyFourKilobyteRAM());
		systemUnderTest.setPower(on);
		systemUnderTest.setReset(on);
	}

	@Test
	public void testMachine_shouldProduceExpectedResults_whenRunningFirstExampleFromBook() {
		final int[] code = { LOD, 0x00, 0x00, ADD, 0x00, 0x01, STO, 0x00, 0x02,
				HALT };
		final int[] data = { 0x4a, 0xb5 };

		loadCode(code);
		loadData(0, data);
		runProgram();

		assertEquals(0xff, readData(2));
	}

	@Test
	public void testMachine_shouldProduceExpectedResults_whenRunningSecondExampleFromBook() {
		final int[] code = { LOD, 0x40, 0x01, ADD, 0x40, 0x03, STO, 0x40, 0x05,
				LOD, 0x40, 0x00, ADC, 0x40, 0x02, STO, 0x40, 0x04, HALT };
		final int[] data = { 0x76, 0xab, 0x23, 0x2c };

		loadCode(code);
		loadData(0x4000, data);
		runProgram();

		assertEquals(0xd7, readData(0x4005));
		assertEquals(0x99, readData(0x4004));
	}

	protected void copyInputToRAM(final int startAddress, final int[] input) {
		systemUnderTest.setW(on);
		for (int i = 0; i < input.length; i++) {
			setAddress(systemUnderTest, startAddress + i);
			setDataIn(systemUnderTest, input[i]);
			systemUnderTest.step();
		}
		systemUnderTest.setW(off);
	}

	protected void loadCode(final int[] input) {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		copyInputToRAM(0, input);
		systemUnderTest.setTakeover(off);
	}

	protected void loadData(final int startAddress, final int[] input) {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(off);
		copyInputToRAM(startAddress, input);
		systemUnderTest.setTakeover(off);
	}

	protected void performOneClockCycle() {
		systemUnderTest.step();
		systemUnderTest.step();
	}

	protected void performWrite() {
		systemUnderTest.setW(on);
		systemUnderTest.step();

		systemUnderTest.setW(off);
		systemUnderTest.step();
	}

	protected int readData(final int address) {
		systemUnderTest.setUseCodePanel(off);
		setAddress(systemUnderTest, address);
		systemUnderTest.step();
		return getDataOut(systemUnderTest);
	}

	protected void runProgram() {
		systemUnderTest.setTakeover(off);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setReset(off);
		while (HALT != getDataOut(systemUnderTest)) {
			performOneClockCycle();
		}
		systemUnderTest.setReset(on);
		systemUnderTest.setTakeover(on);
	}

}

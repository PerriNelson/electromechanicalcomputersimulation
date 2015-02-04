/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Processor.Tests;

import static electroMechanicalLogic.DataChannel.EightBitDataPath.connectEightBitDataOutputToEightBitDataInput;
import static electroMechanicalLogic.DataChannel.SixteenBitDataPath.connectSixteenBitAOutputToSixteenBitAInput;
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
import electroMechanicalMachine.Processor.AM0010;
import electroMechanicalMachine.Processor.Interfaces.IProcessor;

public class TestAM0010 {
	private IProcessor systemUnderTest;
	private SixtyFourKilobyteRAM ram;

	@Before
	public void setUp() {
		systemUnderTest = new AM0010();
		systemUnderTest.setPower(on);
		systemUnderTest.setReset(on);
		systemUnderTest.step();
		ram = new SixtyFourKilobyteRAM();
		ram.setPower(on);
	}

	@Test
	public void testAM0010_shouldGiveExpectedResults_forExampleProgramFromBook() {
		final int[] code = { LOD, 0x40, 0x01, ADD, 0x40, 0x03, STO, 0x40, 0x05,
				LOD, 0x40, 0x00, ADC, 0x40, 0x02, STO, 0x40, 0x04, HALT };
		final int[] data = { 0x76, 0xab, 0x23, 0x2c };
		final int[] expectedValues = new int[] { 0x99, 0xD7 };
		int[] actualValues = new int[expectedValues.length];

		loadRam(0, code);
		loadRam(0x4000, data);

		systemUnderTest.setReset(off);
		for (int step = 0; step < (code.length * 4) / 3; step++) {
			performOneClockCycle();
		}

		readRam(0x4004, actualValues);
		for (int i = 0; i < expectedValues.length; i++) {
			assertEquals(expectedValues[i], actualValues[i]);
		}
	}

	private void performOneClockCycle() {
		performOneStep(on);
		performOneStep(off);
	}

	private void performOneStep(boolean clock) {
		connectEightBitDataOutputToEightBitDataInput(systemUnderTest, ram);
		connectSixteenBitAOutputToSixteenBitAInput(systemUnderTest, ram);
		ram.setW(systemUnderTest.getWrite());
		ram.step();

		connectEightBitDataOutputToEightBitDataInput(ram, systemUnderTest);
		systemUnderTest.setClock(clock);
		systemUnderTest.step();
	}

	protected void loadRam(final int startAddress, final int[] input) {
		ram.setW(on);
		for (int index = 0; index < input.length; index++) {
			setAddress(ram, startAddress + index);
			setDataIn(ram, input[index]);
			ram.step();
		}
		ram.setW(off);
	}

	protected void readRam(final int startAddress, final int[] output) {
		for (int index = 0; index < output.length; index++) {
			setAddress(ram, startAddress + index);
			ram.step();
			output[index] = getDataOut(ram);
		}
	}
}

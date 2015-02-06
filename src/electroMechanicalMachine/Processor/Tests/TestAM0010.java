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
import static electroMechanicalMachine.Model.Tests.InstructionSet.HLT;
import static electroMechanicalMachine.Model.Tests.InstructionSet.LOD;
import static electroMechanicalMachine.Model.Tests.InstructionSet.STO;
import static electroMechanicalMachine.Model.Tests.InstructionSet.SUB;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalLogic.RAM.Fast.SixtyFourKilobyteRAM;
import electroMechanicalMachine.Processor.AM0010;
import electroMechanicalMachine.Processor.Interfaces.IProcessor;

public class TestAM0010 {
	protected IProcessor systemUnderTest;
	protected SixtyFourKilobyteRAM ram;

	@Before
	public void setUp() {
		setProcessor();
		systemUnderTest.setPower(on);
		systemUnderTest.setReset(on);
		systemUnderTest.step();
		ram = new SixtyFourKilobyteRAM();
		ram.setPower(on);
	}

	protected void setProcessor() {
		setProcessor(new AM0010());
	}

	protected final void setProcessor(final IProcessor processor) {
		systemUnderTest = processor;
	}

	@Test
	public void testAM0010_shouldGiveExpectedResults_forSecondMarkIXExampleProgramFromBook() {
		final int[] code = { LOD, 0x40, 0x01, ADD, 0x40, 0x03, STO, 0x40, 0x05,
				LOD, 0x40, 0x00, ADC, 0x40, 0x02, STO, 0x40, 0x04, HLT };
		final int[] data = { 0x76, 0xab, 0x23, 0x5c };
		final int[] expectedValues = new int[] { 0x9A, 0x07 };
		int[] actualValues = new int[expectedValues.length];

		loadRam(0, code);
		loadRam(0x4000, data);

		runProgram();

		readRam(0x4004, actualValues);
		for (int i = 0; i < expectedValues.length; i++) {
			assertEquals(expectedValues[i], actualValues[i]);
		}
	}

	@Test
	public void testAM0010_shouldGiveExpectedResults_forMarkXExampleProgramFromBook() {
		final int[] code = { LOD, 00, 0x10, ADD, 0x00, 0x11, SUB, 0x00, 0x12,
				STO, 0x00, 0x13, HLT };
		final int[] data = { 0x45, 0xa9, 0x8e };
		final int[] expectedValues = new int[] { 0x60 };
		int[] actualValues = new int[expectedValues.length];

		loadRam(0, code);
		loadRam(0x0010, data);

		runProgram();

		readRam(0x0013, actualValues);
		for (int i = 0; i < expectedValues.length; i++) {
			assertEquals(expectedValues[i], actualValues[i]);
		}
	}

	protected final void runProgram() {
		systemUnderTest.setReset(off);
		while (!systemUnderTest.getHalt()) {
			performOneClockCycle();
		}
	}

	protected final void performOneClockCycle() {
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

	protected final void loadRam(final int startAddress, final int[] input) {
		ram.setW(on);
		for (int index = 0; index < input.length; index++) {
			setAddress(ram, startAddress + index);
			setDataIn(ram, input[index]);
			ram.step();
		}
		ram.setW(off);
	}

	protected final void readRam(final int startAddress, final int[] output) {
		for (int index = 0; index < output.length; index++) {
			setAddress(ram, startAddress + index);
			ram.step();
			output[index] = getDataOut(ram);
		}
	}
}

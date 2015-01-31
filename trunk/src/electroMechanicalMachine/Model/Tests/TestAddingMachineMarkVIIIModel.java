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

	protected void loadCode(final int[] input) {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(on);
		copyInputToRAM(input);
		systemUnderTest.setTakeover(off);
	}

	protected void loadData(final int[] input) {
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(off);
		copyInputToRAM(input);
		systemUnderTest.setTakeover(off);
	}

	private void copyInputToRAM(final int[] input) {
		systemUnderTest.setW(on);
		for (int address = 0; address < input.length; address++) {
			setAddress(systemUnderTest, address);
			setDataIn(systemUnderTest, input[address]);
			systemUnderTest.step();
		}
		systemUnderTest.setW(off);
	}

	private void runProgram() {
		systemUnderTest.setTakeover(off);
		systemUnderTest.setUseCodePanel(on);
		systemUnderTest.setReset(off);
		while (0xff != getDataOut(systemUnderTest)) {
			performOneClockCycle();
		}
		systemUnderTest.setReset(on);
		systemUnderTest.setTakeover(on);
	}

	private int readData(int address) {
		systemUnderTest.setUseCodePanel(off);
		setAddress(systemUnderTest, address);
		systemUnderTest.step();
		return getDataOut(systemUnderTest);
	}

	@Test
	public void testAddingMachine_shouldProvideCorrectResults_forFirstExampleFromBook() {
		int[] code = { 0x10, 0x20, 0x11, 0x10, 0x22, 0x11, 0xff };
		int[] data = { 0xab, 0x2c, 0x00, 0x76, 0x23 };

		loadCode(code);
		loadData(data);
		runProgram();

		assertEquals(0xd7, readData(2));
		assertEquals(0x99, readData(5));
	}

	@Test
	public void testAddingMachine_shouldProvideCorrectResults_forSecondExampleFromBook() {
		int[] code = { 0x10, 0x20, 0x11, 0x10, 0x22, 0x11, 0x10, 0x22, 0x11,
				0x10, 0x22, 0x11, 0xff };
		int[] data = { 0xcd, 0xff, 0x00, 0x2b, 0x72, 0x00, 0x89, 0xa8, 0x00,
				0x7a, 0x65 };

		loadCode(code);
		loadData(data);
		runProgram();

		assertEquals(0xcc, readData(2));
		assertEquals(0x9e, readData(5));
		assertEquals(0x31, readData(8));
		assertEquals(0xe0, readData(11));
	}
}

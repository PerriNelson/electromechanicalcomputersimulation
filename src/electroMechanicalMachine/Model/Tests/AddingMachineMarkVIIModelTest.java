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

import electroMechanicalLogic.Fast.SixtyFourKilobyteRAM;
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
		systemUnderTest.setReset(on);
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(off);
		systemUnderTest.setW(on);
		
		setAddress(systemUnderTest, 0);
		setDataIn(systemUnderTest, 0x56);
		systemUnderTest.step();
		
		setAddress(systemUnderTest, 1);
		setDataIn(systemUnderTest, 0x56);
		systemUnderTest.step();

		setAddress(systemUnderTest, 2);
		setDataIn(systemUnderTest, 0xAA);
		systemUnderTest.step();

		systemUnderTest.setUseCodePanel(on);
		setAddress(systemUnderTest, 0);
		setDataIn(systemUnderTest, 0x10);
		systemUnderTest.step();

		setAddress(systemUnderTest, 1);
		setDataIn(systemUnderTest, 0x21);
		systemUnderTest.step();

		setAddress(systemUnderTest, 2);
		setDataIn(systemUnderTest, 0x11);
		systemUnderTest.step();

		setAddress(systemUnderTest, 3);
		setDataIn(systemUnderTest, 0xFF);
		systemUnderTest.step();

		systemUnderTest.setW(off);
		systemUnderTest.setReset(off);
		systemUnderTest.setTakeover(off);

		for (int i = 0; i < 5; i++) {
			performOneClockCycle();
		}

		systemUnderTest.setReset(on);
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(off);

		setAddress(systemUnderTest, 2);
		systemUnderTest.step();
		assertEquals(0, getDataOut(systemUnderTest));
		
	}
	@Test
	public void test_MarkVII_ExampleFromBook_ProducesExpectedResults() {
		systemUnderTest.setReset(on);
		systemUnderTest.setTakeover(on);
		systemUnderTest.setUseCodePanel(off);
		setAddress(systemUnderTest, 0);
		setDataIn(systemUnderTest, 0x56);
		systemUnderTest.setW(on);
		systemUnderTest.step();

		setAddress(systemUnderTest, 1);
		setDataIn(systemUnderTest, 0x2A);
		systemUnderTest.step();

		setAddress(systemUnderTest, 2);
		setDataIn(systemUnderTest, 0x38);
		systemUnderTest.step();

		systemUnderTest.setUseCodePanel(on);
		setAddress(systemUnderTest, 0);
		setDataIn(systemUnderTest, 0x10);
		systemUnderTest.step();

		setAddress(systemUnderTest, 1);
		setDataIn(systemUnderTest, 0x20);
		systemUnderTest.step();

		setAddress(systemUnderTest, 2);
		setDataIn(systemUnderTest, 0x21);
		systemUnderTest.step();

		setAddress(systemUnderTest, 3);
		setDataIn(systemUnderTest, 0x11);
		systemUnderTest.step();

		setAddress(systemUnderTest, 4);
		setDataIn(systemUnderTest, 0xFF);
		systemUnderTest.step();

		systemUnderTest.setW(off);
		systemUnderTest.setReset(off);
		systemUnderTest.setTakeover(off);

		for (int i = 0; i < 5; i++) {
			performOneClockCycle();
		}

		systemUnderTest.setReset(on);
		systemUnderTest.setTakeover(on);
		systemUnderTest.setW(off);
		systemUnderTest.setUseCodePanel(off);

		setAddress(systemUnderTest, 3);
		systemUnderTest.step();
		assertEquals(subtract(add(0x56, 0x2A), 0x38),
				getDataOut(systemUnderTest));
	}
}

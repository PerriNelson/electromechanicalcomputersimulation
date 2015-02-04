/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Processor.Tests;

import static electroMechanicalLogic.Tests.TestConstants.off;
import static electroMechanicalLogic.Tests.TestConstants.on;
import static electroMechanicalLogic.Tests.TestUtilities.getAddress;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalMachine.Processor.BasicProgramCounter;
import electroMechanicalMachine.Processor.Interfaces.IProgramCounter;

public class TestBasicProgramCounter {
	private IProgramCounter systemUnderTest;

	@Before
	public void setUp() {
		systemUnderTest = new BasicProgramCounter();
		systemUnderTest.setPower(on);
		systemUnderTest.setReset(on);
		systemUnderTest.step();
		systemUnderTest.setReset(off);
	}

	@Test
	public void testCounter_shouldNotAdvance_whenResetIsOn() {
		systemUnderTest.setReset(on);
		for (int address = 0; address < 2; address++) {
			assertEquals(0, getAddress(systemUnderTest));
			performOneClockCycle();
		}
	}

	@Test
	public void testCounter_countsTo65536AndRollsOver_through65537ClockCycles() {
		for (int address = 0; address < 65536; address++) {
			assertEquals(address, getAddress(systemUnderTest));
			performOneClockCycle();
		}
		assertEquals(0, getAddress(systemUnderTest));
	}

	private void performOneClockCycle() {
		systemUnderTest.setClock(off);
		systemUnderTest.step();

		systemUnderTest.setClock(on);
		systemUnderTest.step();
	}
}

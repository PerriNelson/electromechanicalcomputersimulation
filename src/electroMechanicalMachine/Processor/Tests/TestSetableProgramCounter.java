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
import static electroMechanicalLogic.Tests.TestUtilities.setAddress;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalMachine.Processor.SetableProgramCounter;
import electroMechanicalMachine.Processor.Interfaces.ISetableProgramCounter;

public class TestSetableProgramCounter extends TestBasicProgramCounter {

	@Override
	@Before
	public void setUp() {
		systemUnderTest = new SetableProgramCounter();
		systemUnderTest.setPower(on);
		systemUnderTest.setReset(on);
		systemUnderTest.step();
		systemUnderTest.setReset(off);
	}

	@Test
	public void testCounter_shouldResumeCountingFromSetAddress_whenAddressHasBeenSet() {
		setAddress((ISetableProgramCounter) systemUnderTest, 0xaaaa);
		((ISetableProgramCounter) systemUnderTest).setJump(on);
		performOneClockCycle();
		((ISetableProgramCounter) systemUnderTest).setJump(off);
		performOneClockCycle();
		assertEquals(0xaaab, getAddress(systemUnderTest));
	}

	@Test
	public void testCounter_shouldReturnAddressSet_whenAddressIsSetForAllPossibleAddresses() {
		for (int address = 0; address < 65536; address++) {
			setAddress((ISetableProgramCounter) systemUnderTest, address);
			((ISetableProgramCounter) systemUnderTest).setJump(on);
			systemUnderTest.step();
			assertEquals(address, getAddress(systemUnderTest));
		}
	}
}

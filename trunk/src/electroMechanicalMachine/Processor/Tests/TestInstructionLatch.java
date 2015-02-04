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
import static electroMechanicalLogic.Tests.TestUtilities.getCode;
import static electroMechanicalLogic.Tests.TestUtilities.setDataIn;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalMachine.Processor.InstructionLatch;
import electroMechanicalMachine.Processor.Interfaces.IInstructionLatch;

public class TestInstructionLatch {
	private IInstructionLatch systemUnderTest;

	@Before
	public void setUp() {
		systemUnderTest = new InstructionLatch();
		systemUnderTest.setPower(on);
		systemUnderTest.setCode(off);
		systemUnderTest.setAddressHigh(off);
		systemUnderTest.setAddressLow(off);
	}

	@Test
	public void testInstructionLatch_shouldLatchCodeFromDataIn_whenSetCodeTransitionsToOnForAllPossibleCodes() {
		for (int code = 0; code < 256; code++) {
			setDataIn(systemUnderTest, code);
			transitionCodeToOn();
			assertEquals(code, getCode(systemUnderTest));
		}
	}

	@Test
	public void testInstructionLatch_shouldLatchAddressHighFromDataIn_whenSetAddressHighTransitionsToOnForAllPossibleCodes() {
		for (int value = 0; value < 256; value++) {
			setDataIn(systemUnderTest, value);
			transitionAddressHighToOn();
			assertEquals((value << 8) & 0xff00, getAddress(systemUnderTest));
		}
	}

	@Test
	public void testInstructionLatch_shouldLatchAddressLowFromDataIn_whenSetAddressLowTransitionsToOnForAllPossibleCodes() {
		for (int value = 0; value < 256; value++) {
			setDataIn(systemUnderTest, value);
			transitionAddressLowToOn();
			assertEquals(value & 0xff, getAddress(systemUnderTest));
		}
	}

	private void transitionCodeToOn() {
		systemUnderTest.setCode(off);
		systemUnderTest.step();

		systemUnderTest.setCode(on);
		systemUnderTest.step();
	}

	private void transitionAddressHighToOn() {
		systemUnderTest.setAddressHigh(off);
		systemUnderTest.step();

		systemUnderTest.setAddressHigh(on);
		systemUnderTest.step();
	}

	private void transitionAddressLowToOn() {
		systemUnderTest.setAddressLow(off);
		systemUnderTest.step();

		systemUnderTest.setAddressLow(on);
		systemUnderTest.step();
	}
}

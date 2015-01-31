/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Model.Tests;

import static electroMechanicalLogic.Tests.TestConstants.on;
import static electroMechanicalLogic.Tests.TestUtilities.getAddress;
import static electroMechanicalLogic.Tests.TestUtilities.setDataIn;
import static electroMechanicalMachine.Model.Tests.InstructionSet.ADC;
import static electroMechanicalMachine.Model.Tests.InstructionSet.ADD;
import static electroMechanicalMachine.Model.Tests.InstructionSet.HALT;
import static electroMechanicalMachine.Model.Tests.InstructionSet.LOD;
import static electroMechanicalMachine.Model.Tests.InstructionSet.SBB;
import static electroMechanicalMachine.Model.Tests.InstructionSet.STO;
import static electroMechanicalMachine.Model.Tests.InstructionSet.SUB;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalMachine.Model.MarkIXInstructionDecoder;
import electroMechanicalMachine.Model.Interfaces.IMarkIXInstructionDecoder;

public class TestMarkIXInstructionDecoder {
	private IMarkIXInstructionDecoder systemUnderTest;

	@Before
	public void setUp() {
		systemUnderTest = new MarkIXInstructionDecoder();
		systemUnderTest.setPower(on);
	}

	@Test
	public void testGetAdd_shouldReturnFalse_whenDataInIsNotADDAndfetchCodeTransitionsToOn() {
		for (int code = 0; code < 256; code++) {
			if (code == ADD) {
				continue;
			}
			setDataIn(systemUnderTest, code);
			transitionFetchCodeOffToOn();

			assertFalse(systemUnderTest.getAdd());
		}
	}

	@Test
	public void testGetAdd_shouldReturnTrue_whenDataInIsADDAndfetchCodeTransitionsToOn() {
		setDataIn(systemUnderTest, ADD);
		transitionFetchCodeOffToOn();

		assertTrue(systemUnderTest.getAdd());
	}

	@Test
	public void testGetLoad_shouldReturnFalse_whenDataInIsNotLODAndfetchCodeTransitionsToOn() {
		for (int code = 0; code < 256; code++) {
			if (code == LOD) {
				continue;
			}
			setDataIn(systemUnderTest, code);
			transitionFetchCodeOffToOn();

			assertFalse(systemUnderTest.getLoad());
		}
	}

	@Test
	public void testGetLoad_shouldReturnTrue_whenDataInIsLODAndfetchCodeTransitionsToOn() {
		setDataIn(systemUnderTest, LOD);
		transitionFetchCodeOffToOn();

		assertTrue(systemUnderTest.getLoad());
	}

	@Test
	public void testGetStore_shouldReturnFalse_whenDataInIsNotSTOAndfetchCodeTransitionsToOn() {
		for (int code = 0; code < 256; code++) {
			if (code == STO) {
				continue;
			}
			setDataIn(systemUnderTest, code);
			transitionFetchCodeOffToOn();

			assertFalse(systemUnderTest.getStore());
		}
	}

	@Test
	public void testGetStore_shouldReturnTrue_whenDataInIsSTOAndfetchCodeTransitionsToOn() {
		setDataIn(systemUnderTest, STO);
		transitionFetchCodeOffToOn();

		assertTrue(systemUnderTest.getStore());
	}

	@Test
	public void testGetHalt_shouldReturnFalse_whenDataInIsNotHALTAndfetchCodeTransitionsToOn() {
		for (int code = 0; code < 256; code++) {
			if (code == HALT) {
				continue;
			}
			setDataIn(systemUnderTest, code);
			transitionFetchCodeOffToOn();

			assertFalse(systemUnderTest.getHalt());
		}
	}

	@Test
	public void testGetHalt_shouldReturnTrue_whenDataInIsHALTAndfetchCodeTransitionsToOn() {
		setDataIn(systemUnderTest, HALT);
		transitionFetchCodeOffToOn();

		assertTrue(systemUnderTest.getHalt());
	}

	@Test
	public void testGetAddWithCarry_shouldReturnFalse_whenDataInIsNotADCAndfetchCodeTransitionsToOn() {
		for (int code = 0; code < 256; code++) {
			if (code == ADC) {
				continue;
			}
			setDataIn(systemUnderTest, code);
			transitionFetchCodeOffToOn();

			assertFalse(systemUnderTest.getAddWithCarry());
		}
	}

	@Test
	public void testGetAddWithCarry_shouldReturnTrue_whenDataInIsADCAndfetchCodeTransitionsToOn() {
		setDataIn(systemUnderTest, ADC);
		transitionFetchCodeOffToOn();

		assertTrue(systemUnderTest.getAddWithCarry());
	}

	@Test
	public void testGetSubtract_shouldReturnFalse_whenDataInIsNotSUBAndfetchCodeTransitionsToOn() {
		for (int code = 0; code < 256; code++) {
			if (code == SUB) {
				continue;
			}
			setDataIn(systemUnderTest, code);
			transitionFetchCodeOffToOn();

			assertFalse(systemUnderTest.getSubtract());
		}
	}

	@Test
	public void testGetSubtract_shouldReturnTrue_whenDataInIsSUBAndfetchCodeTransitionsToOn() {
		setDataIn(systemUnderTest, SUB);
		transitionFetchCodeOffToOn();

		assertTrue(systemUnderTest.getSubtract());
	}

	@Test
	public void testGetSubtractWithBorrow_shouldReturnFalse_whenDataInIsNotSBBAndfetchCodeTransitionsToOn() {
		for (int code = 0; code < 256; code++) {
			if (code == SBB) {
				continue;
			}
			setDataIn(systemUnderTest, code);
			transitionFetchCodeOffToOn();

			assertFalse(systemUnderTest.getSubtractWithBorrow());
		}
	}

	@Test
	public void testGetSubtractWithBorrow_shouldReturnTrue_whenDataInIsSBBAndfetchCodeTransitionsToOn() {
		setDataIn(systemUnderTest, SBB);
		transitionFetchCodeOffToOn();

		assertTrue(systemUnderTest.getSubtractWithBorrow());
	}

	@Test
	public void testAddress_shouldBe00AA_whenDataInIsAAAndFetchLowAddressTransitionsToOn() {
		setDataIn(systemUnderTest, 0xAA);
		transitionFetchLowAddressOffToOn();

		assertEquals(0x00AA, getAddress(systemUnderTest));
	}

	@Test
	public void testAddress_shouldBe5500_whenDataInIs55AndFetchHighAddressTransitionsToOn() {
		setDataIn(systemUnderTest, 0x55);
		transitionFetchHighAddressOffToOn();

		assertEquals(0x5500, getAddress(systemUnderTest));
	}

	@Test
	public void test_addressShouldBe55AA_andGetSubtractShouldBeTrue_afterFullInstructionCycleWithDataInIsSUBThen55ThenAA() {
		setDataIn(systemUnderTest, SUB);
		transitionFetchCodeOffToOn();

		setDataIn(systemUnderTest, 0x55);
		transitionFetchHighAddressOffToOn();

		setDataIn(systemUnderTest, 0xAA);
		transitionFetchLowAddressOffToOn();

		assertTrue(systemUnderTest.getSubtract());
		assertEquals(0x55AA, getAddress(systemUnderTest));
	}

	private void transitionFetchCodeOffToOn() {
		systemUnderTest.setFetchCode(false);
		systemUnderTest.step();
		systemUnderTest.setFetchCode(true);
		systemUnderTest.step();
	}

	private void transitionFetchHighAddressOffToOn() {
		systemUnderTest.setFetchHighAddress(false);
		systemUnderTest.step();
		systemUnderTest.setFetchHighAddress(true);
		systemUnderTest.step();
	}

	private void transitionFetchLowAddressOffToOn() {
		systemUnderTest.setFetchLowAddress(false);
		systemUnderTest.step();
		systemUnderTest.setFetchLowAddress(true);
		systemUnderTest.step();
	}
}

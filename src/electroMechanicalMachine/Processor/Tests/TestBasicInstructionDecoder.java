/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Processor.Tests;

import static electroMechanicalLogic.Tests.TestConstants.bit0;
import static electroMechanicalLogic.Tests.TestConstants.bit1;
import static electroMechanicalLogic.Tests.TestConstants.bit2;
import static electroMechanicalLogic.Tests.TestConstants.bit3;
import static electroMechanicalLogic.Tests.TestConstants.bit4;
import static electroMechanicalLogic.Tests.TestConstants.bit5;
import static electroMechanicalLogic.Tests.TestConstants.bit6;
import static electroMechanicalLogic.Tests.TestConstants.bit7;
import static electroMechanicalLogic.Tests.TestConstants.on;
import static electroMechanicalMachine.Model.Tests.InstructionSet.ADC;
import static electroMechanicalMachine.Model.Tests.InstructionSet.ADD;
import static electroMechanicalMachine.Model.Tests.InstructionSet.HLT;
import static electroMechanicalMachine.Model.Tests.InstructionSet.LOD;
import static electroMechanicalMachine.Model.Tests.InstructionSet.SBB;
import static electroMechanicalMachine.Model.Tests.InstructionSet.STO;
import static electroMechanicalMachine.Model.Tests.InstructionSet.SUB;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalMachine.Processor.BasicInstructionDecoder;
import electroMechanicalMachine.Processor.Interfaces.IInstructionDecoder;

public class TestBasicInstructionDecoder {
	protected IInstructionDecoder systemUnderTest;

	@Before
	public void setUp() {
		systemUnderTest = new BasicInstructionDecoder();
		systemUnderTest.setPower(on);
	}

	@Test
	public void testInstructionDecoder_shouldNotSignalAdd_whenInputCodeIsNotADD() {
		for (int code = 0; code < 256; code++) {
			if (code == ADD) {
				continue;
			}
			setCode(code);
			systemUnderTest.step();
			assertFalse(systemUnderTest.getAdd());
		}
	}

	@Test
	public void testInstructionDecoder_shouldNotSignalAddWithCarry_whenInputCodeIsNotADC() {
		for (int code = 0; code < 256; code++) {
			if (code == ADC) {
				continue;
			}
			setCode(code);
			systemUnderTest.step();
			assertFalse(systemUnderTest.getAddWithCarry());
		}
	}

	@Test
	public void testInstructionDecoder_shouldNotSignalHalt_whenInputCodeIsNotHALT() {
		for (int code = 0; code < 256; code++) {
			if (code == HLT) {
				continue;
			}
			setCode(code);
			systemUnderTest.step();
			assertFalse(systemUnderTest.getHalt());
		}
	}

	@Test
	public void testInstructionDecoder_shouldNotSignalLoad_whenInputCodeIsNotLOD() {
		for (int code = 0; code < 256; code++) {
			if (code == LOD) {
				continue;
			}
			setCode(code);
			systemUnderTest.step();
			assertFalse(systemUnderTest.getLoad());
		}
	}

	@Test
	public void testInstructionDecoder_shouldNotSignalStore_whenInputCodeIsNotSTO() {
		for (int code = 0; code < 256; code++) {
			if (code == STO) {
				continue;
			}
			setCode(code);
			systemUnderTest.step();
			assertFalse(systemUnderTest.getStore());
		}
	}

	@Test
	public void testInstructionDecoder_shouldNotSignalSubtract_whenInputCodeIsNotSUB() {
		for (int code = 0; code < 256; code++) {
			if (code == SUB) {
				continue;
			}
			setCode(code);
			systemUnderTest.step();
			assertFalse(systemUnderTest.getSubtract());
		}
	}

	@Test
	public void testInstructionDecoder_shouldNotSignalSubtractWithBorrow_whenInputCodeIsNotSBB() {
		for (int code = 0; code < 256; code++) {
			if (code == SBB) {
				continue;
			}
			setCode(code);
			systemUnderTest.step();
			assertFalse(systemUnderTest.getSubtractWithBorrow());
		}
	}

	@Test
	public void testInstructionDecoder_shouldSignalAdd_whenInputCodeIsADD() {
		setCode(ADD);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getAdd());
	}

	@Test
	public void testInstructionDecoder_shouldSignalAddWithCarry_whenInputCodeIsADC() {
		setCode(ADC);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getAddWithCarry());
	}

	@Test
	public void testInstructionDecoder_shouldSignalHalt_whenInputCodeIsHALT() {
		setCode(HLT);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getHalt());
	}

	@Test
	public void testInstructionDecoder_shouldSignalLoad_whenInputCodeIsLOD() {
		setCode(LOD);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getLoad());
	}

	@Test
	public void testInstructionDecoder_shouldSignalStore_whenInputCodeIsSTO() {
		setCode(STO);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getStore());
	}

	@Test
	public void testInstructionDecoder_shouldSignalSubtract_whenInputCodeIsSUB() {
		setCode(SUB);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getSubtract());
	}

	@Test
	public void testInstructionDecoder_shouldSignalSubtractWithBorrow_whenInputCodeIsSBB() {
		setCode(SBB);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getSubtractWithBorrow());
	}

	protected void setCode(final int code) {
		systemUnderTest.setC0((code & bit0) == bit0);
		systemUnderTest.setC1((code & bit1) == bit1);
		systemUnderTest.setC2((code & bit2) == bit2);
		systemUnderTest.setC3((code & bit3) == bit3);
		systemUnderTest.setC4((code & bit4) == bit4);
		systemUnderTest.setC5((code & bit5) == bit5);
		systemUnderTest.setC6((code & bit6) == bit6);
		systemUnderTest.setC7((code & bit7) == bit7);
	}
}

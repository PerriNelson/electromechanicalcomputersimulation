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
import static electroMechanicalMachine.Model.Tests.InstructionSet.JC;
import static electroMechanicalMachine.Model.Tests.InstructionSet.JMP;
import static electroMechanicalMachine.Model.Tests.InstructionSet.JNC;
import static electroMechanicalMachine.Model.Tests.InstructionSet.JNZ;
import static electroMechanicalMachine.Model.Tests.InstructionSet.JZ;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalMachine.Processor.JumpInstructionDecoder;
import electroMechanicalMachine.Processor.Interfaces.IJumpInstructionDecoder;

public class TestJumpInstructionDecoder {
	protected IJumpInstructionDecoder systemUnderTest;

	@Before
	public void setUp() {
		systemUnderTest = new JumpInstructionDecoder();
		systemUnderTest.setPower(on);
	}

	@Test
	public void testInstructionDecoder_shouldNotSignalJumpIfNotCarry_whenInputCodeIsNotJNC() {
		for (int code = 0; code < 256; code++) {
			if (code == JNC) {
				continue;
			}
			setCode(code);
			systemUnderTest.step();
			assertFalse(systemUnderTest.getJumpIfNotCarry());
		}
	}

	@Test
	public void testInstructionDecoder_shouldNotSignalJumpIfCarry_whenInputCodeIsNotJC() {
		for (int code = 0; code < 256; code++) {
			if (code == JC) {
				continue;
			}
			setCode(code);
			systemUnderTest.step();
			assertFalse(systemUnderTest.getJumpIfCarry());
		}
	}

	@Test
	public void testInstructionDecoder_shouldNotSignalJumpIfNotZero_whenInputCodeIsNotJNZ() {
		for (int code = 0; code < 256; code++) {
			if (code == JNZ) {
				continue;
			}
			setCode(code);
			systemUnderTest.step();
			assertFalse(systemUnderTest.getJumpIfNotZero());
		}
	}

	@Test
	public void testInstructionDecoder_shouldNotSignalJumpIfZero_whenInputCodeIsNotJZ() {
		for (int code = 0; code < 256; code++) {
			if (code == JZ) {
				continue;
			}
			setCode(code);
			systemUnderTest.step();
			assertFalse(systemUnderTest.getJumpIfZero());
		}
	}

	@Test
	public void testInstructionDecoder_shouldNotSignalJump_whenInputCodeIsNotJMP() {
		for (int code = 0; code < 256; code++) {
			if (code == JMP) {
				continue;
			}
			setCode(code);
			systemUnderTest.step();
			assertFalse(systemUnderTest.getJump());
		}
	}

	@Test
	public void testInstructionDecoder_shouldSignalJumpIfNotCarry_whenInputCodeIsJNC() {
		setCode(JNC);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getJumpIfNotCarry());
	}

	@Test
	public void testInstructionDecoder_shouldSignalJumpIfCarry_whenInputCodeIsJC() {
		setCode(JC);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getJumpIfCarry());
	}

	@Test
	public void testInstructionDecoder_shouldSignalJump_whenInputCodeIsJMP() {
		setCode(JMP);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getJump());
	}

	@Test
	public void testInstructionDecoder_shouldSignalJumpIfNotZero_whenInputCodeIsJNZ() {
		setCode(JNZ);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getJumpIfNotZero());
	}

	@Test
	public void testInstructionDecoder_shouldSignalJumpIfZero_whenInputCodeIsJZ() {
		setCode(JZ);
		systemUnderTest.step();
		assertTrue(systemUnderTest.getJumpIfZero());
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

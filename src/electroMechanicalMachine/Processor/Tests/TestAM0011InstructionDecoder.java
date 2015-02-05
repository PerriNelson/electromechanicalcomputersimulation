/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Processor.Tests;

import static electroMechanicalLogic.Tests.TestConstants.on;
import static electroMechanicalMachine.Model.Tests.InstructionSet.JMP;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalMachine.Processor.AM0011InstructionDecoder;
import electroMechanicalMachine.Processor.Interfaces.IGetJump;

public class TestAM0011InstructionDecoder extends TestBasicInstructionDecoder {

	@Override
	@Before
	public void setUp() {
		systemUnderTest = new AM0011InstructionDecoder();
		systemUnderTest.setPower(on);
	}

	@Test
	public void testInstructionDecoder_shouldNotSignalJump_whenInputCodeIsNotJMP() {
		for (int code = 0; code < 256; code++) {
			if (code == JMP) {
				continue;
			}
			setCode(code);
			systemUnderTest.step();
			assertFalse(((IGetJump) systemUnderTest).getJump());
		}
	}

	@Test
	public void testInstructionDecoder_shouldSignalJump_whenInputCodeIsJMP() {
		setCode(JMP);
		systemUnderTest.step();
		assertTrue(((IGetJump) systemUnderTest).getJump());
	}

}

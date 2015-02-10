/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Processor.Tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import electroMechanicalMachine.Processor.TimingControl;
import electroMechanicalMachine.Processor.Interfaces.ITimingControl;

public class TestTimingControl extends TestBasicInstructionTimer {

	@Override
	protected void setInstructionTimer() {
		setInstructionTimer(new TimingControl());
	}

	@Test
	public void testTimingControl_shouldAdvanceToExecute_afterFetchCode_whenSingleByteInstructionIsOn() {
		systemUnderTest.setClock(true);
		systemUnderTest.step();
		systemUnderTest.setClock(false);
		systemUnderTest.step();

		((ITimingControl) systemUnderTest).setSingleByteInstruction(true);
		systemUnderTest.setClock(true);
		systemUnderTest.step();
		systemUnderTest.setClock(false);
		systemUnderTest.step();

		assertTrue(systemUnderTest.getExecute());
	}

	@Test
	public void testTimingControl_shouldNotAdvanceToExecute_afterFetchCode_whenSingleByteInstructionIsOn() {
		systemUnderTest.setClock(true);
		systemUnderTest.step();
		systemUnderTest.setClock(false);
		systemUnderTest.step();

		((ITimingControl) systemUnderTest).setSingleByteInstruction(false);
		systemUnderTest.setClock(true);
		systemUnderTest.step();
		systemUnderTest.setClock(false);
		systemUnderTest.step();

		assertFalse(systemUnderTest.getExecute());
	}
}

/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Processor.Tests;

import static electroMechanicalLogic.Tests.TestConstants.on;
import static electroMechanicalLogic.Tests.TestUtilities.setAIn;
import static electroMechanicalLogic.Tests.TestUtilities.setBIn;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import electroMechanicalMachine.Processor.BasicALUWithFlags;
import electroMechanicalMachine.Processor.Interfaces.ICarryFlag;
import electroMechanicalMachine.Processor.Interfaces.IZeroFlag;

public class TestBasicALUWIthFlags extends TestBasicALU {

	@Override
	protected void setALU() {
		setALU(new BasicALUWithFlags());
	}

	@Test
	public void testGetCarryFlag_shouldReturnTrue_whenOperationResultsInCarry() {
		setAIn(systemUnderTest, 0xff);
		setBIn(systemUnderTest, 0x01);
		systemUnderTest.setAdd(on);
		performOneExecutionCycle();

		assertTrue(((ICarryFlag) systemUnderTest).getCarryFlag());
	}

	@Test
	public void testGetCarryFlag_shouldReturnFalse_whenOperationDoesNotResultInCarry() {
		setAIn(systemUnderTest, 0x01);
		setBIn(systemUnderTest, 0x01);
		systemUnderTest.setAdd(on);
		performOneExecutionCycle();

		assertFalse(((ICarryFlag) systemUnderTest).getCarryFlag());
	}

	@Test
	public void testGetZeroFlag_shouldReturnTrue_whenOperationResultsInZero() {
		setAIn(systemUnderTest, 0x01);
		setBIn(systemUnderTest, 0x01);
		systemUnderTest.setSubtract(on);
		performOneExecutionCycle();

		assertTrue(((IZeroFlag) systemUnderTest).getZeroFlag());
	}

	@Test
	public void testGetZeroFlag_shouldReturnFalse_whenOperationDoesNotResultInZero() {
		setAIn(systemUnderTest, 0x01);
		setBIn(systemUnderTest, 0x01);
		systemUnderTest.setAdd(on);
		performOneExecutionCycle();

		assertFalse(((IZeroFlag) systemUnderTest).getZeroFlag());
	}
}

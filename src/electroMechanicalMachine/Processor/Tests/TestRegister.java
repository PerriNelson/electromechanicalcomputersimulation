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
import static electroMechanicalLogic.Tests.TestUtilities.getDataOut;
import static electroMechanicalLogic.Tests.TestUtilities.setDataIn;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalMachine.Processor.Register;
import electroMechanicalMachine.Processor.Interfaces.IRegister;

public class TestRegister {
	private IRegister systemUnderTest;

	@Before
	public void setUp() {
		systemUnderTest = new Register();
		systemUnderTest.setPower(on);
	}

	@Test
	public void testRegister_shouldNotStoreData_whenWriteIsNotOn() {
		setDataIn(systemUnderTest, 0x0ff);
		systemUnderTest.step();
		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void testRegister_shouldStoreData_whenWriteTransitionsToOn() {
		setDataIn(systemUnderTest, 0xff);
		transitionWriteToOn();
		assertEquals(0xff, getDataOut(systemUnderTest));
	}

	@Test
	public void testRegister_shouldContainZero_whenWResetIsOn() {
		setDataIn(systemUnderTest, 0xff);
		transitionWriteToOn();

		systemUnderTest.setReset(on);
		systemUnderTest.step();
		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void testRegister_shouldNotStoreData_whenWResetIsOnAndWriteTransitonsToOn() {
		systemUnderTest.setReset(on);
		setDataIn(systemUnderTest, 0xff);
		transitionWriteToOn();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	private void transitionWriteToOn() {
		systemUnderTest.setWrite(off);
		systemUnderTest.step();

		systemUnderTest.setWrite(on);
		systemUnderTest.step();
	}
}

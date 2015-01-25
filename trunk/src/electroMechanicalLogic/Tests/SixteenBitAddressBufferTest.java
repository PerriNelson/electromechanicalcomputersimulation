/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.Tests;

import static electroMechanicalLogic.Tests.TestConstants.on;
import static electroMechanicalLogic.Tests.TestUtilities.getAddress;
import static electroMechanicalLogic.Tests.TestUtilities.setAddress;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalLogic.SixteenBitAddressBuffer;
import electroMechanicalLogic.Interfaces.ISixteenBitAddressBuffer;

public class SixteenBitAddressBufferTest {
	private ISixteenBitAddressBuffer systemUnderTest;

	@Before
	public void Setup() {
		systemUnderTest = new SixteenBitAddressBuffer();
		systemUnderTest.setPower(on);
	}

	@Test
	public void test_ForAllInputs_DataOutReflectsDataIn() {
		for (int address = 0; address < 65536; address++) {
			setAddress(systemUnderTest, address);
			systemUnderTest.step();
			assertEquals(address, getAddress(systemUnderTest));
		}
	}

}

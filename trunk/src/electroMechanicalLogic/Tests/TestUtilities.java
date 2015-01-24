/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.Tests;

import static electroMechanicalLogic.Tests.TestConstants.bit0;
import static electroMechanicalLogic.Tests.TestConstants.bit1;
import static electroMechanicalLogic.Tests.TestConstants.bit2;
import static electroMechanicalLogic.Tests.TestConstants.bit3;
import static electroMechanicalLogic.Tests.TestConstants.bit4;
import static electroMechanicalLogic.Tests.TestConstants.bit5;
import static electroMechanicalLogic.Tests.TestConstants.bit6;
import static electroMechanicalLogic.Tests.TestConstants.bit7;
import electroMechanicalLogic.Interfaces.IEightBitDataOut;

public class TestUtilities {
	public static int getDataOut(IEightBitDataOut systemUnderTest) {
		int dataOut = 0;
		dataOut |= (systemUnderTest.getDO0() ? bit0 : 0);
		dataOut |= (systemUnderTest.getDO1() ? bit1 : 0);
		dataOut |= (systemUnderTest.getDO2() ? bit2 : 0);
		dataOut |= (systemUnderTest.getDO3() ? bit3 : 0);
		dataOut |= (systemUnderTest.getDO4() ? bit4 : 0);
		dataOut |= (systemUnderTest.getDO5() ? bit5 : 0);
		dataOut |= (systemUnderTest.getDO6() ? bit6 : 0);
		dataOut |= (systemUnderTest.getDO7() ? bit7 : 0);
		return dataOut;
	}
}

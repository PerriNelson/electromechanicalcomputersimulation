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
import electroMechanicalLogic.Interfaces.IEightBitDataIn;
import electroMechanicalLogic.Interfaces.IEightBitDataOut;

public class TestUtilities {
	public static int getDataOut(final IEightBitDataOut systemUnderTest) {
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

	public static void setInput(final IEightBitDataIn systemUnderTest,
			final int value) {
		systemUnderTest.setDI0((value & bit0) == bit0);
		systemUnderTest.setDI1((value & bit1) == bit1);
		systemUnderTest.setDI2((value & bit2) == bit2);
		systemUnderTest.setDI3((value & bit3) == bit3);
		systemUnderTest.setDI4((value & bit4) == bit4);
		systemUnderTest.setDI5((value & bit5) == bit5);
		systemUnderTest.setDI6((value & bit6) == bit6);
		systemUnderTest.setDI7((value & bit7) == bit7);
	}
}

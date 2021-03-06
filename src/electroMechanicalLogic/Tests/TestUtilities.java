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
import static electroMechanicalLogic.Tests.TestConstants.bit8;
import static electroMechanicalLogic.Tests.TestConstants.bit9;
import static electroMechanicalLogic.Tests.TestConstants.bitA;
import static electroMechanicalLogic.Tests.TestConstants.bitB;
import static electroMechanicalLogic.Tests.TestConstants.bitC;
import static electroMechanicalLogic.Tests.TestConstants.bitD;
import static electroMechanicalLogic.Tests.TestConstants.bitE;
import static electroMechanicalLogic.Tests.TestConstants.bitF;
import static electroMechanicalLogic.Tests.TestConstants.off;
import static electroMechanicalLogic.Tests.TestConstants.on;
import electroMechanicalLogic.DataChannel.Interfaces.IEightBitAInput;
import electroMechanicalLogic.DataChannel.Interfaces.IEightBitBInput;
import electroMechanicalLogic.DataChannel.Interfaces.IEightBitCInput;
import electroMechanicalLogic.DataChannel.Interfaces.IEightBitCOutput;
import electroMechanicalLogic.DataChannel.Interfaces.IEightBitDInput;
import electroMechanicalLogic.DataChannel.Interfaces.IEightBitDataInput;
import electroMechanicalLogic.DataChannel.Interfaces.IEightBitDataOutput;
import electroMechanicalLogic.DataChannel.Interfaces.IEightBitSumOutput;
import electroMechanicalLogic.DataChannel.Interfaces.ISixteenBitAInput;
import electroMechanicalLogic.DataChannel.Interfaces.ISixteenBitAOutput;

public class TestUtilities {
	public static int getAddress(final ISixteenBitAOutput source) {
		int address = 0;
		address |= (source.getA0() ? bit0 : 0);
		address |= (source.getA1() ? bit1 : 0);
		address |= (source.getA2() ? bit2 : 0);
		address |= (source.getA3() ? bit3 : 0);
		address |= (source.getA4() ? bit4 : 0);
		address |= (source.getA5() ? bit5 : 0);
		address |= (source.getA6() ? bit6 : 0);
		address |= (source.getA7() ? bit7 : 0);
		address |= (source.getA8() ? bit8 : 0);
		address |= (source.getA9() ? bit9 : 0);
		address |= (source.getAA() ? bitA : 0);
		address |= (source.getAB() ? bitB : 0);
		address |= (source.getAC() ? bitC : 0);
		address |= (source.getAD() ? bitD : 0);
		address |= (source.getAE() ? bitE : 0);
		address |= (source.getAF() ? bitF : 0);
		return address;
	}

	public static int getCode(final IEightBitCOutput source) {
		int code = 0;
		code |= source.getC0() ? bit0 : 0;
		code |= source.getC1() ? bit1 : 0;
		code |= source.getC2() ? bit2 : 0;
		code |= source.getC3() ? bit3 : 0;
		code |= source.getC4() ? bit4 : 0;
		code |= source.getC5() ? bit5 : 0;
		code |= source.getC6() ? bit6 : 0;
		code |= source.getC7() ? bit7 : 0;
		return code;
	}

	public static int getDataOut(final IEightBitDataOutput source) {
		int dataOut = 0;
		dataOut |= (source.getDO0() ? bit0 : 0);
		dataOut |= (source.getDO1() ? bit1 : 0);
		dataOut |= (source.getDO2() ? bit2 : 0);
		dataOut |= (source.getDO3() ? bit3 : 0);
		dataOut |= (source.getDO4() ? bit4 : 0);
		dataOut |= (source.getDO5() ? bit5 : 0);
		dataOut |= (source.getDO6() ? bit6 : 0);
		dataOut |= (source.getDO7() ? bit7 : 0);
		return dataOut;
	}

	public static int getSum(final IEightBitSumOutput source) {
		int sum = 0;
		sum |= (source.getS0() ? bit0 : 0);
		sum |= (source.getS1() ? bit1 : 0);
		sum |= (source.getS2() ? bit2 : 0);
		sum |= (source.getS3() ? bit3 : 0);
		sum |= (source.getS4() ? bit4 : 0);
		sum |= (source.getS5() ? bit5 : 0);
		sum |= (source.getS6() ? bit6 : 0);
		sum |= (source.getS7() ? bit7 : 0);
		return sum;
	}

	public static void setAddress(final ISixteenBitAInput target,
			final int address) {
		target.setA0((address & bit0) == bit0 ? on : off);
		target.setA1((address & bit1) == bit1 ? on : off);
		target.setA2((address & bit2) == bit2 ? on : off);
		target.setA3((address & bit3) == bit3 ? on : off);
		target.setA4((address & bit4) == bit4 ? on : off);
		target.setA5((address & bit5) == bit5 ? on : off);
		target.setA6((address & bit6) == bit6 ? on : off);
		target.setA7((address & bit7) == bit7 ? on : off);
		target.setA8((address & bit8) == bit8 ? on : off);
		target.setA9((address & bit9) == bit9 ? on : off);
		target.setAA((address & bitA) == bitA ? on : off);
		target.setAB((address & bitB) == bitB ? on : off);
		target.setAC((address & bitC) == bitC ? on : off);
		target.setAD((address & bitD) == bitD ? on : off);
		target.setAE((address & bitE) == bitE ? on : off);
		target.setAF((address & bitF) == bitF ? on : off);
	}

	public static void setAIn(final IEightBitAInput target, final int value) {
		target.setA0((value & bit0) == bit0);
		target.setA1((value & bit1) == bit1);
		target.setA2((value & bit2) == bit2);
		target.setA3((value & bit3) == bit3);
		target.setA4((value & bit4) == bit4);
		target.setA5((value & bit5) == bit5);
		target.setA6((value & bit6) == bit6);
		target.setA7((value & bit7) == bit7);
	}

	public static void setBIn(final IEightBitBInput target, final int value) {
		target.setB0((value & bit0) == bit0);
		target.setB1((value & bit1) == bit1);
		target.setB2((value & bit2) == bit2);
		target.setB3((value & bit3) == bit3);
		target.setB4((value & bit4) == bit4);
		target.setB5((value & bit5) == bit5);
		target.setB6((value & bit6) == bit6);
		target.setB7((value & bit7) == bit7);
	}

	public static void setCIn(final IEightBitCInput target, final int value) {
		target.setC0((value & bit0) == bit0);
		target.setC1((value & bit1) == bit1);
		target.setC2((value & bit2) == bit2);
		target.setC3((value & bit3) == bit3);
		target.setC4((value & bit4) == bit4);
		target.setC5((value & bit5) == bit5);
		target.setC6((value & bit6) == bit6);
		target.setC7((value & bit7) == bit7);
	}

	public static void setDIn(final IEightBitDInput target, final int value) {
		target.setD0((value & bit0) == bit0);
		target.setD1((value & bit1) == bit1);
		target.setD2((value & bit2) == bit2);
		target.setD3((value & bit3) == bit3);
		target.setD4((value & bit4) == bit4);
		target.setD5((value & bit5) == bit5);
		target.setD6((value & bit6) == bit6);
		target.setD7((value & bit7) == bit7);
	}

	public static void setCode(final IEightBitCInput target, final int value) {
		target.setC0((value & bit0) == bit0);
		target.setC1((value & bit1) == bit1);
		target.setC2((value & bit2) == bit2);
		target.setC3((value & bit3) == bit3);
		target.setC4((value & bit4) == bit4);
		target.setC5((value & bit5) == bit5);
		target.setC6((value & bit6) == bit6);
		target.setC7((value & bit7) == bit7);
	}

	public static void setDataIn(final IEightBitDataInput target,
			final int value) {
		target.setDI0((value & bit0) == bit0);
		target.setDI1((value & bit1) == bit1);
		target.setDI2((value & bit2) == bit2);
		target.setDI3((value & bit3) == bit3);
		target.setDI4((value & bit4) == bit4);
		target.setDI5((value & bit5) == bit5);
		target.setDI6((value & bit6) == bit6);
		target.setDI7((value & bit7) == bit7);
	}

}

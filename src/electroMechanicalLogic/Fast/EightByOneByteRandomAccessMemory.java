/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.Fast;

import electroMechanicalLogic.Interfaces.IEightByOneByteRandomAccessMemory;
import electroMechanicalLogic.Interfaces.IRandomAccessMemory;

public class EightByOneByteRandomAccessMemory implements
IEightByOneByteRandomAccessMemory, IRandomAccessMemory {
	protected int addressIn;
	protected int addressOut;
	protected byte dataIn;
	protected byte dataOut;
	protected boolean writeIn;
	protected boolean writeOut;
	protected boolean powerIn;
	protected boolean powerOut;
	protected byte[] randomAccessMemory;

	protected static final int bit0 = 0x1;
	protected static final int bit1 = 0x2;
	protected static final int bit2 = 0x4;
	protected static final int bit3 = 0x8;
	protected static final int bit4 = 0x10;
	protected static final int bit5 = 0x20;
	protected static final int bit6 = 0x40;
	protected static final int bit7 = 0x80;

	public EightByOneByteRandomAccessMemory() {
		final int maxAddress = getMaxAddress();
		randomAccessMemory = new byte[maxAddress + 1];
		clearRandomAccessMemory();
	}

	private void clearRandomAccessMemory() {
		final int maxAddress = getMaxAddress();
		for (int address = 0; address < (maxAddress + 1); address++) {
			randomAccessMemory[address] = 0;
		}
	}

	@Override
	public boolean getDO0() {
		return (dataOut & bit0) == bit0;
	}

	@Override
	public boolean getDO1() {
		return (dataOut & bit1) == bit1;
	}

	@Override
	public boolean getDO2() {
		return (dataOut & bit2) == bit2;
	}

	@Override
	public boolean getDO3() {
		return (dataOut & bit3) == bit3;
	}

	@Override
	public boolean getDO4() {
		return (dataOut & bit4) == bit4;
	}

	@Override
	public boolean getDO5() {
		return (dataOut & bit5) == bit5;
	}

	@Override
	public boolean getDO6() {
		return (dataOut & bit6) == bit6;
	}

	@Override
	public boolean getDO7() {
		return (dataOut & bit7) == bit7;
	}

	@Override
	public int getMaxAddress() {
		return 0x7;
	}

	@Override
	public void setA0(final boolean value) {
		addressIn = value ? addressIn | bit0 : addressIn & ~bit0;
	}

	@Override
	public void setA1(final boolean value) {
		addressIn = value ? addressIn | bit1 : addressIn & ~bit1;
	}

	@Override
	public void setA2(final boolean value) {
		addressIn = value ? addressIn | bit2 : addressIn & ~bit2;
	}

	@Override
	public void setDI0(final boolean value) {
		dataIn = value ? (byte) (dataIn | bit0) : (byte) (dataIn & ~bit0);
	}

	@Override
	public void setDI1(final boolean value) {
		dataIn = value ? (byte) (dataIn | bit1) : (byte) (dataIn & ~bit1);
	}

	@Override
	public void setDI2(final boolean value) {
		dataIn = value ? (byte) (dataIn | bit2) : (byte) (dataIn & ~bit2);
	}

	@Override
	public void setDI3(final boolean value) {
		dataIn = value ? (byte) (dataIn | bit3) : (byte) (dataIn & ~bit3);
	}

	@Override
	public void setDI4(final boolean value) {
		dataIn = value ? (byte) (dataIn | bit4) : (byte) (dataIn & ~bit4);
	}

	@Override
	public void setDI5(final boolean value) {
		dataIn = value ? (byte) (dataIn | bit5) : (byte) (dataIn & ~bit5);
	}

	@Override
	public void setDI6(final boolean value) {
		dataIn = value ? (byte) (dataIn | bit6) : (byte) (dataIn & ~bit6);
	}

	@Override
	public void setDI7(final boolean value) {
		dataIn = value ? (byte) (dataIn | bit7) : (byte) (dataIn & ~bit7);
	}

	@Override
	public void setPower(final boolean value) {
		powerIn = value;
	}

	@Override
	public void setW(final boolean value) {
		writeIn = value;
	}

	@Override
	public void step() {
		if (!powerIn && powerOut) {
			clearRandomAccessMemory();
		}
		powerOut = powerIn;

		if (powerOut) {
			addressOut = addressIn;
			writeOut = writeIn;
			if (writeOut) {
				randomAccessMemory[addressOut] = dataIn;
			}
			dataOut = randomAccessMemory[addressOut];
		} else {
			writeOut = false;
			addressOut = 0;
			dataOut = 0;
		}
	}
}
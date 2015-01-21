/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.Fast;

import electroMechanicalLogic.Interfaces.ISixtyFourByOneByteRandomAccessMemory;

public class SixtyFourByOneByteRandomAccessMemory extends
		EightByOneByteRandomAccessMemory implements
		ISixtyFourByOneByteRandomAccessMemory {
	@Override
	public int getMaxAddress() {
		return 0x3f;
	}

	@Override
	public void setA3(boolean value) {
		addressIn = value ? addressIn | bit3 : addressIn & ~bit3;
	}

	@Override
	public void setA4(boolean value) {
		addressIn = value ? addressIn | bit4 : addressIn & ~bit4;
	}

	@Override
	public void setA5(boolean value) {
		addressIn = value ? addressIn | bit5 : addressIn & ~bit5;
	}
}
/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.RAM.Fast;

import electroMechanicalLogic.Interfaces.IFiveHundredTwelveByteRAM;

public class FiveHundredTwelveByteRAM extends SixtyFourByteRAM implements
		IFiveHundredTwelveByteRAM {
	protected static final int bit8 = 0x100;

	@Override
	public int getMaxAddress() {
		return 0x1ff;
	}

	@Override
	public void setA6(final boolean value) {
		addressIn = value ? addressIn | bit6 : addressIn & ~bit6;
	}

	@Override
	public void setA7(final boolean value) {
		addressIn = value ? addressIn | bit7 : addressIn & ~bit7;
	}

	@Override
	public void setA8(final boolean value) {
		addressIn = value ? addressIn | bit8 : addressIn & ~bit8;
	}
}
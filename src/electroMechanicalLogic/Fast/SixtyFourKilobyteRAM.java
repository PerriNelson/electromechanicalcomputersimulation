/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.Fast;

import electroMechanicalLogic.Interfaces.ISixtyFourKilobyteRAM;

public class SixtyFourKilobyteRAM extends ThirtyTwoKilobyteRAM implements
		ISixtyFourKilobyteRAM {
	protected static final int bitF = 0x8000;

	@Override
	public int getMaxAddress() {
		return 0xffff;
	}

	@Override
	public void setAF(boolean value) {
		addressIn = value ? addressIn | bitF : addressIn & ~bitF;
	}
}

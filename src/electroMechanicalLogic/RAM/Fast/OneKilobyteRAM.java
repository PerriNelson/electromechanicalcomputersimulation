/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.RAM.Fast;

import electroMechanicalLogic.RAM.Interfaces.IOneKilobyteRAM;

public class OneKilobyteRAM extends FiveHundredTwelveByteRAM implements
		IOneKilobyteRAM {
	protected static final int bit8 = 0x100;
	protected static final int bit9 = 0x200;

	@Override
	public int getMaxAddress() {
		return 0x3ff;
	}

	@Override
	public void setA9(final boolean value) {
		addressIn = value ? addressIn | bit9 : addressIn & ~bit9;
	}
}
/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.Fast;

import electroMechanicalLogic.Interfaces.IFourKilobyteRAM;

public class FourKilobyteRAM extends OneKilobyteRAM implements IFourKilobyteRAM {
	protected static final int bitA = 0x400;
	protected static final int bitB = 0x800;

	@Override
	public int getMaxAddress() {
		return 0xfff;
	}

	@Override
	public void setAA(boolean value) {
		addressIn = value ? addressIn | bitA : addressIn & ~bitA;
	}

	@Override
	public void setAB(boolean value) {
		addressIn = value ? addressIn | bitB : addressIn & ~bitB;
	}
}
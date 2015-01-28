/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.RAM.Fast;

import electroMechanicalLogic.Interfaces.IThirtyTwoKilobyteRAM;

public class ThirtyTwoKilobyteRAM extends FourKilobyteRAM implements
		IThirtyTwoKilobyteRAM {
	protected static final int bitC = 0x1000;
	protected static final int bitD = 0x2000;
	protected static final int bitE = 0x4000;

	@Override
	public int getMaxAddress() {
		return 0x7fff;
	}

	@Override
	public void setAC(final boolean value) {
		addressIn = value ? addressIn | bitC : addressIn & ~bitC;
	}

	@Override
	public void setAD(final boolean value) {
		addressIn = value ? addressIn | bitD : addressIn & ~bitD;
	}

	@Override
	public void setAE(final boolean value) {
		addressIn = value ? addressIn | bitE : addressIn & ~bitE;
	}
}
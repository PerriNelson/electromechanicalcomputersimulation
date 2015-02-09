/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.RAM.Tests;

import org.junit.Before;

import electroMechanicalLogic.RAM.ThirtyTwoKilobyteRAM;
import electroMechanicalLogic.RAM.Interfaces.IThirtyTwoKilobyteRAM;

public class ThirtyTwoKilobyteRAMTest extends FourKilobyteRAMTest {
	protected static final int bitC = 0x1000;
	protected static final int bitD = 0x2000;
	protected static final int bitE = 0x4000;

	@Override
	@Before
	public void setUp() throws Exception {
		systemUnderTest = new ThirtyTwoKilobyteRAM();
		systemUnderTest.setPower(true);
	}

	@Override
	protected void setA(final int value) {
		super.setA(value);
		((IThirtyTwoKilobyteRAM) systemUnderTest).setAC((value & bitC) == bitC);
		((IThirtyTwoKilobyteRAM) systemUnderTest).setAD((value & bitD) == bitD);
		((IThirtyTwoKilobyteRAM) systemUnderTest).setAE((value & bitE) == bitE);
	}

	@Override
	protected int translateAddress(final int address) {
		return (super.translateAddress(address) << 3) | address;
	}
}

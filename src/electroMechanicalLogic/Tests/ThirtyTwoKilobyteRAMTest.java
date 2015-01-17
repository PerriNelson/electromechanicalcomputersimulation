/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.Tests;

import org.junit.Before;

import electroMechanicalLogic.ThirtyTwoKilobyteRAM;
import electroMechanicalLogic.Interfaces.IThirtyTwoKilobyteRAM;

public class ThirtyTwoKilobyteRAMTest extends FourKilobyteRAMTest {
	protected static final int bitC = 0x1000;
	protected static final int bitD = 0x2000;
	protected static final int bitE = 0x4000;
 
	@Override
	protected void setA(int value) {
		super.setA(value);
		((IThirtyTwoKilobyteRAM) systemUnderTest).setAC((value & bitC) == bitC);
		((IThirtyTwoKilobyteRAM) systemUnderTest).setAD((value & bitD) == bitD);
		((IThirtyTwoKilobyteRAM) systemUnderTest).setAE((value & bitE) == bitE);
	}

	@Override
	@Before
	public void setUp() throws Exception {
		systemUnderTest = new ThirtyTwoKilobyteRAM();
		systemUnderTest.setPower(true);
	}

	@Override
	protected int translateAddress(int address) {
		return (super.translateAddress(address) << 3) | address;
	}
}

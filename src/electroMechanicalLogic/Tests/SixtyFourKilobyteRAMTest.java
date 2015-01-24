/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalLogic.SixtyFourKilobyteRAM;
import electroMechanicalLogic.Interfaces.ISixtyFourKilobyteRAM;

public class SixtyFourKilobyteRAMTest extends ThirtyTwoKilobyteRAMTest {
	protected static final int bitF = 0x8000;

	@Override
	protected void setA(final int value) {
		super.setA(value);
		((ISixtyFourKilobyteRAM) systemUnderTest).setAF((value & bitF) == bitF);
	}

	@Override
	@Before
	public void setUp() throws Exception {
		systemUnderTest = new SixtyFourKilobyteRAM();
		systemUnderTest.setPower(true);
	}

	@Test
	@Override
	public void test() {
		for (int i = 0; i < 2; i++) {
			for (int a = 0; a < 2; a++) {
				setA(translateAddress(a));
				setDI((a == i) ? 0xff : 0);
				systemUnderTest.setW(true);
				systemUnderTest.step();
				systemUnderTest.setW(false);
				systemUnderTest.step();
			}

			for (int a = 0; a < 2; a++) {
				setA(translateAddress(a));
				systemUnderTest.step();
				assertEquals(getDO(), (a == i) ? 0xff : 0);
			}
		}
	}

	@Override
	protected int translateAddress(final int address) {
		return address == 0 ? 0 : 0xffff;
	}
}

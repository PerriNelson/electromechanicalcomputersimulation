/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.RAM.Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalLogic.RAM.OneKilobyteRAM;
import electroMechanicalLogic.RAM.Interfaces.IOneKilobyteRAM;

public class OneKilobyteRAMTest extends FiveHundredTwelveByteRAMTest {

	protected static final int bit9 = 0x200;

	@Override
	@Before
	public void setUp() throws Exception {
		systemUnderTest = new OneKilobyteRAM();
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
	protected void setA(final int value) {
		super.setA(value);
		((IOneKilobyteRAM) systemUnderTest).setA9((value & bit9) == bit9);
	}

	@Override
	protected int translateAddress(final int address) {
		return address == 0 ? 0 : 0x3ff;
	}
}

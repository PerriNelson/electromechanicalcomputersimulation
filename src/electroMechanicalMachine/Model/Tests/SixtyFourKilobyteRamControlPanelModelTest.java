/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Model.Tests;

import static electroMechanicalLogic.Tests.TestConstants.bit0;
import static electroMechanicalLogic.Tests.TestConstants.bit1;
import static electroMechanicalLogic.Tests.TestConstants.bit2;
import static electroMechanicalLogic.Tests.TestConstants.bit3;
import static electroMechanicalLogic.Tests.TestConstants.bit4;
import static electroMechanicalLogic.Tests.TestConstants.bit5;
import static electroMechanicalLogic.Tests.TestConstants.bit6;
import static electroMechanicalLogic.Tests.TestConstants.bit7;
import static electroMechanicalLogic.Tests.TestConstants.off;
import static electroMechanicalLogic.Tests.TestConstants.on;
import static electroMechanicalLogic.Tests.TestUtilities.getDataOut;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalLogic.Fast.SixtyFourKilobyteRAM;
import electroMechanicalMachine.Model.SixtyFourKilobyteRamControlPanelModel;
import electroMechanicalMachine.Model.Interfaces.ISixtyFourKilobyteRamControlPanelModel;

public class SixtyFourKilobyteRamControlPanelModelTest {

	private ISixtyFourKilobyteRamControlPanelModel systemUnderTest;
	private boolean eventFired = false;

	@Before
	public void setUp() throws Exception {
		systemUnderTest = new SixtyFourKilobyteRamControlPanelModel(
				new SixtyFourKilobyteRAM());
		systemUnderTest.setPower(on);

		// Turn everything off.
		systemUnderTest.setCpTakeover(off);
		systemUnderTest.setCpA0(off);
		systemUnderTest.setCpA1(off);
		systemUnderTest.setCpA2(off);
		systemUnderTest.setCpA3(off);
		systemUnderTest.setCpA4(off);
		systemUnderTest.setCpA5(off);
		systemUnderTest.setCpA6(off);
		systemUnderTest.setCpA6(off);
		systemUnderTest.setCpA8(off);
		systemUnderTest.setCpA9(off);
		systemUnderTest.setCpAA(off);
		systemUnderTest.setCpAB(off);
		systemUnderTest.setCpAC(off);
		systemUnderTest.setCpAD(off);
		systemUnderTest.setCpAE(off);
		systemUnderTest.setCpAF(off);
		systemUnderTest.setCpDI0(off);
		systemUnderTest.setCpDI1(off);
		systemUnderTest.setCpDI2(off);
		systemUnderTest.setCpDI3(off);
		systemUnderTest.setCpDI4(off);
		systemUnderTest.setCpDI5(off);
		systemUnderTest.setCpDI6(off);
		systemUnderTest.setCpDI7(off);
		systemUnderTest.setCpW(off);
		systemUnderTest.setEcA0(off);
		systemUnderTest.setEcA1(off);
		systemUnderTest.setEcA2(off);
		systemUnderTest.setEcA3(off);
		systemUnderTest.setEcA4(off);
		systemUnderTest.setEcA5(off);
		systemUnderTest.setEcA6(off);
		systemUnderTest.setEcA6(off);
		systemUnderTest.setEcA8(off);
		systemUnderTest.setEcA9(off);
		systemUnderTest.setEcAA(off);
		systemUnderTest.setEcAB(off);
		systemUnderTest.setEcAC(off);
		systemUnderTest.setEcAD(off);
		systemUnderTest.setEcAE(off);
		systemUnderTest.setEcAF(off);
		systemUnderTest.setEcDI0(off);
		systemUnderTest.setEcDI1(off);
		systemUnderTest.setEcDI2(off);
		systemUnderTest.setEcDI3(off);
		systemUnderTest.setEcDI4(off);
		systemUnderTest.setEcDI5(off);
		systemUnderTest.setEcDI6(off);
		systemUnderTest.setEcDI7(off);
		systemUnderTest.setEcW(off);

		systemUnderTest.step();
	}

	@Test
	public void test_CpA0OffAndCpA0On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA0(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA0OnAndCpA1On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA0(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA0(off);
		systemUnderTest.setCpA1(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA0OnAndCpA2On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA0(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA0(off);
		systemUnderTest.setCpA2(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA0OnAndCpA3On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA0(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA0(off);
		systemUnderTest.setCpA3(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA0OnAndCpA4On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA0(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA0(off);
		systemUnderTest.setCpA4(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA0OnAndCpA5On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA0(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA0(off);
		systemUnderTest.setCpA5(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA0OnAndCpA6On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA0(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA0(off);
		systemUnderTest.setCpA6(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA0OnAndCpA7On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA0(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA0(off);
		systemUnderTest.setCpA7(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA0OnAndCpA8On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA0(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA0(off);
		systemUnderTest.setCpA8(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA0OnAndCpA9On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA0(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA0(off);
		systemUnderTest.setCpA9(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA0OnAndCpAAOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA0(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA0(off);
		systemUnderTest.setCpAA(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA0OnAndCpABOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA0(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA0(off);
		systemUnderTest.setCpAB(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA0OnAndCpACOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA0(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA0(off);
		systemUnderTest.setCpAC(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA0OnAndCpADOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA0(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA0(off);
		systemUnderTest.setCpAD(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA0OnAndCpAEOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA0(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA0(off);
		systemUnderTest.setCpAE(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA0OnAndCpAFOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA0(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA0(off);
		systemUnderTest.setCpAF(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA1OffAndCpA1On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA1(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA1OnAndCpA2On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA1(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA1(off);
		systemUnderTest.setCpA2(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA1OnAndCpA3On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA1(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA1(off);
		systemUnderTest.setCpA3(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA1OnAndCpA4On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA1(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA1(off);
		systemUnderTest.setCpA4(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA1OnAndCpA5On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA1(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA1(off);
		systemUnderTest.setCpA5(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA1OnAndCpA6On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA1(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA1(off);
		systemUnderTest.setCpA6(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA1OnAndCpA7On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA1(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA1(off);
		systemUnderTest.setCpA7(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA1OnAndCpA8On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA1(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA1(off);
		systemUnderTest.setCpA8(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA1OnAndCpA9On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA1(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA1(off);
		systemUnderTest.setCpA9(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA1OnAndCpAAOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA1(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA1(off);
		systemUnderTest.setCpAA(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA1OnAndCpABOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA1(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA1(off);
		systemUnderTest.setCpAB(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA1OnAndCpACOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA1(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA1(off);
		systemUnderTest.setCpAC(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA1OnAndCpADOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA1(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA1(off);
		systemUnderTest.setCpAD(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA1OnAndCpAEOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA1(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA1(off);
		systemUnderTest.setCpAE(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA1OnAndCpAFOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA1(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA1(off);
		systemUnderTest.setCpAF(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA2OffAndCpA2On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA2(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA2OnAndCpA3On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA2(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA2(off);
		systemUnderTest.setCpA3(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA2OnAndCpA4On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA2(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA2(off);
		systemUnderTest.setCpA4(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA2OnAndCpA5On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA2(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA2(off);
		systemUnderTest.setCpA5(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA2OnAndCpA6On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA2(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA2(off);
		systemUnderTest.setCpA6(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA2OnAndCpA7On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA2(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA2(off);
		systemUnderTest.setCpA7(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA2OnAndCpA8On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA2(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA2(off);
		systemUnderTest.setCpA8(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA2OnAndCpA9On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA2(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA2(off);
		systemUnderTest.setCpA9(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA2OnAndCpAAOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA2(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA2(off);
		systemUnderTest.setCpAA(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA2OnAndCpABOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA2(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA2(off);
		systemUnderTest.setCpAB(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA2OnAndCpACOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA2(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA2(off);
		systemUnderTest.setCpAC(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA2OnAndCpADOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA2(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA2(off);
		systemUnderTest.setCpAD(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA2OnAndCpAEOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA2(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA2(off);
		systemUnderTest.setCpAE(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA2OnAndCpAFOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA2(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA2(off);
		systemUnderTest.setCpAF(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA3OffAndCpA3On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA3(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA3OnAndCpA4On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA3(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA3(off);
		systemUnderTest.setCpA4(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA3OnAndCpA5On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA3(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA3(off);
		systemUnderTest.setCpA5(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA3OnAndCpA6On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA3(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA3(off);
		systemUnderTest.setCpA6(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA3OnAndCpA7On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA3(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA3(off);
		systemUnderTest.setCpA7(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA3OnAndCpA8On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA3(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA3(off);
		systemUnderTest.setCpA8(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA3OnAndCpA9On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA3(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA3(off);
		systemUnderTest.setCpA9(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA3OnAndCpAAOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA3(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA3(off);
		systemUnderTest.setCpAA(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA3OnAndCpABOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA3(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA3(off);
		systemUnderTest.setCpAB(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA3OnAndCpACOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA3(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA3(off);
		systemUnderTest.setCpAC(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA3OnAndCpADOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA3(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA3(off);
		systemUnderTest.setCpAD(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA3OnAndCpAEOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA3(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA3(off);
		systemUnderTest.setCpAE(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA3OnAndCpAFOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA3(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA3(off);
		systemUnderTest.setCpAF(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA4OffAndCpA4On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA4(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA4OnAndCpA5On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA4(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA4(off);
		systemUnderTest.setCpA5(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA4OnAndCpA6On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA4(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA4(off);
		systemUnderTest.setCpA6(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA4OnAndCpA7On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA4(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA4(off);
		systemUnderTest.setCpA7(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA4OnAndCpA8On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA4(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA4(off);
		systemUnderTest.setCpA8(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA4OnAndCpA9On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA4(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA4(off);
		systemUnderTest.setCpA9(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA4OnAndCpAAOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA4(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA4(off);
		systemUnderTest.setCpAA(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA4OnAndCpABOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA4(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA4(off);
		systemUnderTest.setCpAB(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA4OnAndCpACOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA4(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA4(off);
		systemUnderTest.setCpAC(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA4OnAndCpADOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA4(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA4(off);
		systemUnderTest.setCpAD(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA4OnAndCpAEOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA4(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA4(off);
		systemUnderTest.setCpAE(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA4OnAndCpAFOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA4(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA4(off);
		systemUnderTest.setCpAF(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA5OffAndCpA5On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA5(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA5OnAndCpA6On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA5(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA5(off);
		systemUnderTest.setCpA6(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA5OnAndCpA7On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA5(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA5(off);
		systemUnderTest.setCpA7(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA5OnAndCpA8On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA5(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA5(off);
		systemUnderTest.setCpA8(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA5OnAndCpA9On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA5(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA5(off);
		systemUnderTest.setCpA9(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA5OnAndCpAAOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA5(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA5(off);
		systemUnderTest.setCpAA(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA5OnAndCpABOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA5(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA5(off);
		systemUnderTest.setCpAB(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA5OnAndCpACOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA5(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA5(off);
		systemUnderTest.setCpAC(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA5OnAndCpADOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA5(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA5(off);
		systemUnderTest.setCpAD(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA5OnAndCpAEOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA5(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA5(off);
		systemUnderTest.setCpAE(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA5OnAndCpAFOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA5(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA5(off);
		systemUnderTest.setCpAF(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA6OffAndCpA6On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA6(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA6OnAndCpA7On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA6(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA6(off);
		systemUnderTest.setCpA7(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA6OnAndCpA8On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA6(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA6(off);
		systemUnderTest.setCpA8(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA6OnAndCpA9On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA6(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA6(off);
		systemUnderTest.setCpA9(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA6OnAndCpAAOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA6(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA6(off);
		systemUnderTest.setCpAA(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA6OnAndCpABOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA6(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA6(off);
		systemUnderTest.setCpAB(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA6OnAndCpACOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA6(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA6(off);
		systemUnderTest.setCpAC(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA6OnAndCpADOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA6(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA6(off);
		systemUnderTest.setCpAD(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA6OnAndCpAEOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA6(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA6(off);
		systemUnderTest.setCpAE(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA6OnAndCpAFOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA6(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA6(off);
		systemUnderTest.setCpAF(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA7OffAndCpA7On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA7(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA7OnAndCpA8On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA7(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA7(off);
		systemUnderTest.setCpA8(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA7OnAndCpA9On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA7(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA7(off);
		systemUnderTest.setCpA9(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA7OnAndCpAAOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA7(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA7(off);
		systemUnderTest.setCpAA(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA7OnAndCpABOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA7(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA7(off);
		systemUnderTest.setCpAB(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA7OnAndCpACOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA7(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA7(off);
		systemUnderTest.setCpAC(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA7OnAndCpADOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA7(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA7(off);
		systemUnderTest.setCpAD(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA7OnAndCpAEOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA7(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA7(off);
		systemUnderTest.setCpAE(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA7OnAndCpAFOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA7(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA7(off);
		systemUnderTest.setCpAF(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA8OffAndCpA8On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA8(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA8OnAndCpA9On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA8(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA8(off);
		systemUnderTest.setCpA9(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA8OnAndCpAAOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA8(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA8(off);
		systemUnderTest.setCpAA(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA8OnAndCpABOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA8(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA8(off);
		systemUnderTest.setCpAB(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA8OnAndCpACOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA8(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA8(off);
		systemUnderTest.setCpAC(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA8OnAndCpADOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA8(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA8(off);
		systemUnderTest.setCpAD(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA8OnAndCpAEOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA8(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA8(off);
		systemUnderTest.setCpAE(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA8OnAndCpAFOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA8(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA8(off);
		systemUnderTest.setCpAF(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA9OffAndCpA9On_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA9(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA9OnAndCpAAOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA9(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA9(off);
		systemUnderTest.setCpAA(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA9OnAndCpABOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA9(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA9(off);
		systemUnderTest.setCpAB(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA9OnAndCpACOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA9(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA9(off);
		systemUnderTest.setCpAC(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA9OnAndCpADOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA9(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA9(off);
		systemUnderTest.setCpAD(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA9OnAndCpAEOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA9(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA9(off);
		systemUnderTest.setCpAE(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpA9OnAndCpAFOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpA9(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA9(off);
		systemUnderTest.setCpAF(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpAAOffAndCpAAOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpAA(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpAAOnAndCpABOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpAA(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();

		systemUnderTest.setCpAA(off);
		systemUnderTest.setCpAB(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpAAOnAndCpACOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpAA(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();

		systemUnderTest.setCpAA(off);
		systemUnderTest.setCpAC(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpAAOnAndCpADOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpAA(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();

		systemUnderTest.setCpAA(off);
		systemUnderTest.setCpAD(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpAAOnAndCpAEOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpAA(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();

		systemUnderTest.setCpAA(off);
		systemUnderTest.setCpAE(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpAAOnAndCpAFOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpAA(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();

		systemUnderTest.setCpAA(off);
		systemUnderTest.setCpAF(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpABOffAndCpABOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpAB(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpABOnAndCpACOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpAB(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();

		systemUnderTest.setCpAB(off);
		systemUnderTest.setCpAC(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpABOnAndCpADOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpAB(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();

		systemUnderTest.setCpAB(off);
		systemUnderTest.setCpAD(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpABOnAndCpAEOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpAB(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();

		systemUnderTest.setCpAB(off);
		systemUnderTest.setCpAE(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpABOnAndCpAFOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpAB(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();

		systemUnderTest.setCpAB(off);
		systemUnderTest.setCpAF(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpACOffAndCpACOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpAC(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpACOnAndCpADOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpAC(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();

		systemUnderTest.setCpAC(off);
		systemUnderTest.setCpAD(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpACOnAndCpAEOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpAC(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();

		systemUnderTest.setCpAC(off);
		systemUnderTest.setCpAE(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpACOnAndCpAFOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpAC(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();

		systemUnderTest.setCpAC(off);
		systemUnderTest.setCpAF(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpADOffAndCpADOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpAD(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpADOnAndCpAEOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpAD(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();

		systemUnderTest.setCpAD(off);
		systemUnderTest.setCpAE(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpADOnAndCpAFOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpAD(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();

		systemUnderTest.setCpAD(off);
		systemUnderTest.setCpAF(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpAEOffAndCpAEOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpAE(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpAEOnAndCpAFOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpAE(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();

		systemUnderTest.setCpAE(off);
		systemUnderTest.setCpAF(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_CpAFOffAndCpAFOn_RepresentDifferentAddresses() {
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();
		systemUnderTest.setCpAF(on);
		systemUnderTest.setCpW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_DataEnteredUsingControlPanel_IsAvailableToExternalCircuitry() {
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();
		systemUnderTest.setCpTakeover(off);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_DataEnteredUsingControlPanelA0_IsAvailableToExternalCircuitryA0() {
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpA0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();
		systemUnderTest.setCpTakeover(off);
		systemUnderTest.setEcA0(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_DataEnteredUsingControlPanelA1_IsAvailableToExternalCircuitryA1() {
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpA1(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();
		systemUnderTest.setCpTakeover(off);
		systemUnderTest.setEcA1(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_DataEnteredUsingControlPanelA2_IsAvailableToExternalCircuitryA2() {
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpA2(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();
		systemUnderTest.setCpTakeover(off);
		systemUnderTest.setEcA2(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_DataEnteredUsingControlPanelA3_IsAvailableToExternalCircuitryA3() {
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpA3(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();
		systemUnderTest.setCpTakeover(off);
		systemUnderTest.setEcA3(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_DataEnteredUsingControlPanelA4_IsAvailableToExternalCircuitryA4() {
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpA4(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();
		systemUnderTest.setCpTakeover(off);
		systemUnderTest.setEcA4(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_DataEnteredUsingControlPanelA5_IsAvailableToExternalCircuitryA5() {
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpA5(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();
		systemUnderTest.setCpTakeover(off);
		systemUnderTest.setEcA5(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_DataEnteredUsingControlPanelA6_IsAvailableToExternalCircuitryA6() {
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpA6(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();
		systemUnderTest.setCpTakeover(off);
		systemUnderTest.setEcA6(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_DataEnteredUsingControlPanelA7_IsAvailableToExternalCircuitryA7() {
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpA7(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();
		systemUnderTest.setCpTakeover(off);
		systemUnderTest.setEcA7(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_DataEnteredUsingControlPanelA8_IsAvailableToExternalCircuitryA8() {
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpA8(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();
		systemUnderTest.setCpTakeover(off);
		systemUnderTest.setEcA8(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_DataEnteredUsingControlPanelA9_IsAvailableToExternalCircuitryA9() {
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpA9(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();
		systemUnderTest.setCpTakeover(off);
		systemUnderTest.setEcA9(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_DataEnteredUsingControlPanelAA_IsAvailableToExternalCircuitryAA() {
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpAA(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();
		systemUnderTest.setCpTakeover(off);
		systemUnderTest.setEcAA(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_DataEnteredUsingControlPanelAB_IsAvailableToExternalCircuitryAB() {
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpAB(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();
		systemUnderTest.setCpTakeover(off);
		systemUnderTest.setEcAB(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_DataEnteredUsingControlPanelAC_IsAvailableToExternalCircuitryAC() {
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpAC(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();
		systemUnderTest.setCpTakeover(off);
		systemUnderTest.setEcAC(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_DataEnteredUsingControlPanelAD_IsAvailableToExternalCircuitryAD() {
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpAD(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();
		systemUnderTest.setCpTakeover(off);
		systemUnderTest.setEcAD(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_DataEnteredUsingControlPanelAE_IsAvailableToExternalCircuitryAE() {
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpAE(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();
		systemUnderTest.setCpTakeover(off);
		systemUnderTest.setEcAE(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_DataEnteredUsingControlPanelAF_IsAvailableToExternalCircuitryAF() {
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpAF(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();
		systemUnderTest.setCpTakeover(off);
		systemUnderTest.setEcAF(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_DataEnteredUsingExternalCircuitry_IsAvailableToControlPanel() {
		systemUnderTest.setEcDI0(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_DataEnteredUsingExternalCircuitryA0_IsAvailableToControlPanelA0() {
		systemUnderTest.setEcA0(on);
		systemUnderTest.setEcDI0(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA0(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_DataEnteredUsingExternalCircuitryA1_IsAvailableToControlPanelA1() {
		systemUnderTest.setEcA1(on);
		systemUnderTest.setEcDI0(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA1(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_DataEnteredUsingExternalCircuitryA2_IsAvailableToControlPanelA2() {
		systemUnderTest.setEcA2(on);
		systemUnderTest.setEcDI0(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA2(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_DataEnteredUsingExternalCircuitryA3_IsAvailableToControlPanelA3() {
		systemUnderTest.setEcA3(on);
		systemUnderTest.setEcDI0(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA3(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_DataEnteredUsingExternalCircuitryA4_IsAvailableToControlPanelA4() {
		systemUnderTest.setEcA4(on);
		systemUnderTest.setEcDI0(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA4(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_DataEnteredUsingExternalCircuitryA5_IsAvailableToControlPanelA5() {
		systemUnderTest.setEcA5(on);
		systemUnderTest.setEcDI0(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA5(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_DataEnteredUsingExternalCircuitryA6_IsAvailableToControlPanelA6() {
		systemUnderTest.setEcA6(on);
		systemUnderTest.setEcDI0(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA6(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_DataEnteredUsingExternalCircuitryA7_IsAvailableToControlPanelA7() {
		systemUnderTest.setEcA7(on);
		systemUnderTest.setEcDI0(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA7(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_DataEnteredUsingExternalCircuitryA8_IsAvailableToControlPanelA8() {
		systemUnderTest.setEcA8(on);
		systemUnderTest.setEcDI0(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA8(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_DataEnteredUsingExternalCircuitryA9_IsAvailableToControlPanelA9() {
		systemUnderTest.setEcA9(on);
		systemUnderTest.setEcDI0(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA9(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_DataEnteredUsingExternalCircuitryAA_IsAvailableToControlPanelAA() {
		systemUnderTest.setEcAA(on);
		systemUnderTest.setEcDI0(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();
		systemUnderTest.setCpAA(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_DataEnteredUsingExternalCircuitryAB_IsAvailableToControlPanelAB() {
		systemUnderTest.setEcAB(on);
		systemUnderTest.setEcDI0(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();
		systemUnderTest.setCpAB(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_DataEnteredUsingExternalCircuitryAC_IsAvailableToControlPanelAC() {
		systemUnderTest.setEcAC(on);
		systemUnderTest.setEcDI0(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();
		systemUnderTest.setCpAC(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_DataEnteredUsingExternalCircuitryAD_IsAvailableToControlPanelAD() {
		systemUnderTest.setEcAD(on);
		systemUnderTest.setEcDI0(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();
		systemUnderTest.setCpAD(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_DataEnteredUsingExternalCircuitryAE_IsAvailableToControlPanelAE() {
		systemUnderTest.setEcA0(on);
		systemUnderTest.setEcDI0(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();
		systemUnderTest.setCpA0(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_DataEnteredUsingExternalCircuitryAF_IsAvailableToControlPanelAF() {
		systemUnderTest.setEcAF(on);
		systemUnderTest.setEcDI0(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();
		systemUnderTest.setCpAF(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_EcA0OffAndEcA0On_RepresentDifferentAddresses() {
		systemUnderTest.setEcDI0(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();
		systemUnderTest.setEcA0(on);
		systemUnderTest.setEcW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_EcA1OffAndEcA1On_RepresentDifferentAddresses() {
		systemUnderTest.setEcDI0(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();
		systemUnderTest.setEcA1(on);
		systemUnderTest.setEcW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_EcA2OffAndEcA2On_RepresentDifferentAddresses() {
		systemUnderTest.setEcDI0(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();
		systemUnderTest.setEcA2(on);
		systemUnderTest.setEcW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_EcA3OffAndEcA3On_RepresentDifferentAddresses() {
		systemUnderTest.setEcDI0(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();
		systemUnderTest.setEcA3(on);
		systemUnderTest.setEcW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_EcA4OffAndEcA4On_RepresentDifferentAddresses() {
		systemUnderTest.setEcDI0(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();
		systemUnderTest.setEcA4(on);
		systemUnderTest.setEcW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_EcA5OffAndEcA5On_RepresentDifferentAddresses() {
		systemUnderTest.setEcDI0(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();
		systemUnderTest.setEcA5(on);
		systemUnderTest.setEcW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_EcA6OffAndEcA6On_RepresentDifferentAddresses() {
		systemUnderTest.setEcDI0(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();
		systemUnderTest.setEcA6(on);
		systemUnderTest.setEcW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_EcA7OffAndEcA7On_RepresentDifferentAddresses() {
		systemUnderTest.setEcDI0(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();
		systemUnderTest.setEcA7(on);
		systemUnderTest.setEcW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_EcA8OffAndEcA8On_RepresentDifferentAddresses() {
		systemUnderTest.setEcDI0(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();
		systemUnderTest.setEcA8(on);
		systemUnderTest.setEcW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_EcA9OffAndEcA9On_RepresentDifferentAddresses() {
		systemUnderTest.setEcDI0(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();
		systemUnderTest.setEcA9(on);
		systemUnderTest.setEcW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_EcAAOffAndEcAAOn_RepresentDifferentAddresses() {
		systemUnderTest.setEcDI0(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();
		systemUnderTest.setEcAA(on);
		systemUnderTest.setEcW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_EcABOffAndEcABOn_RepresentDifferentAddresses() {
		systemUnderTest.setEcDI0(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();
		systemUnderTest.setEcAB(on);
		systemUnderTest.setEcW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_EcACOffAndEcACOn_RepresentDifferentAddresses() {
		systemUnderTest.setEcDI0(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();
		systemUnderTest.setEcAC(on);
		systemUnderTest.setEcW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_EcADOffAndEcADOn_RepresentDifferentAddresses() {
		systemUnderTest.setEcDI0(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();
		systemUnderTest.setEcAD(on);
		systemUnderTest.setEcW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_EcAFOffAndEcAFOn_RepresentDifferentAddresses() {
		systemUnderTest.setEcDI0(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();
		systemUnderTest.setEcAF(on);
		systemUnderTest.setEcW(off);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WhenStepped_FiresPropertyChangeEvent() {
		systemUnderTest.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(final PropertyChangeEvent evt) {
				eventFired = true;
			}
		});
		systemUnderTest.step();
		assertTrue(eventFired);
	}

	@Test
	public void test_WithOnlyCpDI0CpA0AndCpWOn_OutputIsUnchanged() {
		systemUnderTest.setCpA0(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyCpDI0CpA0CpWOnAbdCpTakeoverOn_OutputIsBit0() {
		systemUnderTest.setCpA0(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyCpDI0CpA1AndCpWOn_OutputIsUnchanged() {
		systemUnderTest.setCpA1(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyCpDI0CpA1CpWOnAbdCpTakeoverOn_OutputIsBit0() {
		systemUnderTest.setCpA1(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyCpDI0CpA2AndCpWOn_OutputIsUnchanged() {
		systemUnderTest.setCpA2(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyCpDI0CpA2CpWOnAbdCpTakeoverOn_OutputIsBit0() {
		systemUnderTest.setCpA2(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyCpDI0CpA3AndCpWOn_OutputIsUnchanged() {
		systemUnderTest.setCpA3(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyCpDI0CpA3CpWOnAbdCpTakeoverOn_OutputIsBit0() {
		systemUnderTest.setCpA3(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyCpDI0CpA4AndCpWOn_OutputIsUnchanged() {
		systemUnderTest.setCpA4(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyCpDI0CpA4CpWOnAbdCpTakeoverOn_OutputIsBit0() {
		systemUnderTest.setCpA4(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyCpDI0CpA5AndCpWOn_OutputIsUnchanged() {
		systemUnderTest.setCpA5(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyCpDI0CpA5CpWOnAbdCpTakeoverOn_OutputIsBit0() {
		systemUnderTest.setCpA5(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyCpDI0CpA6AndCpWOn_OutputIsUnchanged() {
		systemUnderTest.setCpA6(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyCpDI0CpA6CpWOnAbdCpTakeoverOn_OutputIsBit0() {
		systemUnderTest.setCpA6(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyCpDI0CpA7AndCpWOn_OutputIsUnchanged() {
		systemUnderTest.setCpA7(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyCpDI0CpA7CpWOnAbdCpTakeoverOn_OutputIsBit0() {
		systemUnderTest.setCpA7(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyCpDI0CpA8AndCpWOn_OutputIsUnchanged() {
		systemUnderTest.setCpA8(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyCpDI0CpA8CpWOnAbdCpTakeoverOn_OutputIsBit0() {
		systemUnderTest.setCpA8(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyCpDI0CpA9AndCpWOn_OutputIsUnchanged() {
		systemUnderTest.setCpA9(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyCpDI0CpA9CpWOnAbdCpTakeoverOn_OutputIsBit0() {
		systemUnderTest.setCpA9(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyCpDI0CpAAAndCpWOn_OutputIsUnchanged() {
		systemUnderTest.setCpAA(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyCpDI0CpAACpWOnAbdCpTakeoverOn_OutputIsBit0() {
		systemUnderTest.setCpAA(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyCpDI0CpABAndCpWOn_OutputIsUnchanged() {
		systemUnderTest.setCpAB(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyCpDI0CpABCpWOnAbdCpTakeoverOn_OutputIsBit0() {
		systemUnderTest.setCpAB(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyCpDI0CpACAndCpWOn_OutputIsUnchanged() {
		systemUnderTest.setCpAC(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyCpDI0CpACCpWOnAbdCpTakeoverOn_OutputIsBit0() {
		systemUnderTest.setCpAC(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyCpDI0CpADAndCpWOn_OutputIsUnchanged() {
		systemUnderTest.setCpAD(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyCpDI0CpADCpWOnAbdCpTakeoverOn_OutputIsBit0() {
		systemUnderTest.setCpAD(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyCpDI0CpAEAndCpWOn_OutputIsUnchanged() {
		systemUnderTest.setCpAE(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyCpDI0CpAECpWOnAbdCpTakeoverOn_OutputIsBit0() {
		systemUnderTest.setCpAE(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyCpDI0CpAFAndCpWOn_OutputIsUnchanged() {
		systemUnderTest.setCpAF(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyCpDI0CpAFCpWOnAbdCpTakeoverOn_OutputIsBit0() {
		systemUnderTest.setCpAF(on);
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyCpDI0OnAndCpWOn_OutputIsUnchanged() {
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyCpDI0OnCpWOnAndcpTakeoverOn_OutputIsBit0() {
		systemUnderTest.setCpDI0(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyCpDI1OnAndCpWOn_OutputIsUnchanged() {
		systemUnderTest.setCpDI1(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyCpDI1OnCpWOnAndcpTakeoverOn_OutputIsBit1() {
		systemUnderTest.setCpDI1(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();

		assertEquals(bit1, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyCpDI2OnAndCpWOn_OutputIsUnchanged() {
		systemUnderTest.setCpDI2(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyCpDI2OnCpWOnAndcpTakeoverOn_OutputIsBit2() {
		systemUnderTest.setCpDI2(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();

		assertEquals(bit2, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyCpDI3OnAndCpWOn_OutputIsUnchanged() {
		systemUnderTest.setCpDI3(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyCpDI3OnCpWOnAndcpTakeoverOn_OutputIsBit3() {
		systemUnderTest.setCpDI3(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();

		assertEquals(bit3, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyCpDI4OnAndCpWOn_OutputIsUnchanged() {
		systemUnderTest.setCpDI4(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyCpDI4OnCpWOnAndcpTakeoverOn_OutputIsBit4() {
		systemUnderTest.setCpDI4(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();

		assertEquals(bit4, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyCpDI5OnAndCpWOn_OutputIsUnchanged() {
		systemUnderTest.setCpDI5(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyCpDI5OnCpWOnAndcpTakeoverOn_OutputIsBit5() {
		systemUnderTest.setCpDI5(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();

		assertEquals(bit5, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyCpDI6OnAndCpWOn_OutputIsUnchanged() {
		systemUnderTest.setCpDI6(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyCpDI6OnCpWOnAndcpTakeoverOn_OutputIsBit6() {
		systemUnderTest.setCpDI6(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();

		assertEquals(bit6, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyCpDI7OnAndCpWOn_OutputIsUnchanged() {
		systemUnderTest.setCpDI7(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyCpDI7OnCpWOnAndcpTakeoverOn_OutputIsBit7() {
		systemUnderTest.setCpDI7(on);
		systemUnderTest.setCpW(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();

		assertEquals(bit7, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyEcDI0AndEcWOn_OutputIsBit0() {
		systemUnderTest.setEcDI0(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyEcDI0EcA0AndEcWOn_OutputIsBit0() {
		systemUnderTest.setEcA0(on);
		systemUnderTest.setEcDI0(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyEcDI0EcA1AndEcWOn_OutputIsBit0() {
		systemUnderTest.setEcA1(on);
		systemUnderTest.setEcDI0(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyEcDI0EcA2AndEcWOn_OutputIsBit0() {
		systemUnderTest.setEcA2(on);
		systemUnderTest.setEcDI0(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyEcDI0EcA3AndEcWOn_OutputIsBit0() {
		systemUnderTest.setEcA3(on);
		systemUnderTest.setEcDI0(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyEcDI0EcA4AndEcWOn_OutputIsBit0() {
		systemUnderTest.setEcA4(on);
		systemUnderTest.setEcDI0(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyEcDI0EcA5AndEcWOn_OutputIsBit0() {
		systemUnderTest.setEcA5(on);
		systemUnderTest.setEcDI0(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyEcDI0EcA6AndEcWOn_OutputIsBit0() {
		systemUnderTest.setEcA6(on);
		systemUnderTest.setEcDI0(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyEcDI0EcA7AndEcWOn_OutputIsBit0() {
		systemUnderTest.setEcA7(on);
		systemUnderTest.setEcDI0(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyEcDI0EcA8AndEcWOn_OutputIsBit0() {
		systemUnderTest.setEcA8(on);
		systemUnderTest.setEcDI0(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyEcDI0EcA9AndEcWOn_OutputIsBit0() {
		systemUnderTest.setEcA9(on);
		systemUnderTest.setEcDI0(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyEcDI0EcAAAndEcWOn_OutputIsBit0() {
		systemUnderTest.setEcAA(on);
		systemUnderTest.setEcDI0(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyEcDI0EcABAndEcWOn_OutputIsBit0() {
		systemUnderTest.setEcAB(on);
		systemUnderTest.setEcDI0(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyEcDI0EcACAndEcWOn_OutputIsBit0() {
		systemUnderTest.setEcAC(on);
		systemUnderTest.setEcDI0(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyEcDI0EcADAndEcWOn_OutputIsBit0() {
		systemUnderTest.setEcAD(on);
		systemUnderTest.setEcDI0(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyEcDI0EcAEAndEcWOn_OutputIsBit0() {
		systemUnderTest.setEcAE(on);
		systemUnderTest.setEcDI0(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyEcDI0EcAFAndEcWOn_OutputIsBit0() {
		systemUnderTest.setEcAF(on);
		systemUnderTest.setEcDI0(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();

		assertEquals(bit0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyEcDI0EcWOnAndCpTakeoverOn_OutputIsUnchanged() {
		systemUnderTest.setEcDI0(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyEcDI1AndEcWOn_OutputIsBit1() {
		systemUnderTest.setEcDI1(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();

		assertEquals(bit1, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyEcDI1EcWOnAndCpTakeoverOn_OutputIsUnchanged() {
		systemUnderTest.setEcDI1(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyEcDI2AndEcWOn_OutputIsBit2() {
		systemUnderTest.setEcDI2(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();

		assertEquals(bit2, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyEcDI2EcWOnAndCpTakeoverOn_OutputIsUnchanged() {
		systemUnderTest.setEcDI2(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyEcDI3AndEcWOn_OutputIsBit3() {
		systemUnderTest.setEcDI3(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();

		assertEquals(bit3, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyEcDI3EcWOnAndCpTakeoverOn_OutputIsUnchanged() {
		systemUnderTest.setEcDI3(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyEcDI4AndEcWOn_OutputIsBit4() {
		systemUnderTest.setEcDI4(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();

		assertEquals(bit4, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyEcDI4EcWOnAndCpTakeoverOn_OutputIsUnchanged() {
		systemUnderTest.setEcDI4(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyEcDI5AndEcWOn_OutputIsBit5() {
		systemUnderTest.setEcDI5(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();

		assertEquals(bit5, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyEcDI5EcWOnAndCpTakeoverOn_OutputIsUnchanged() {
		systemUnderTest.setEcDI5(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyEcDI6AndEcWOn_OutputIsBit6() {
		systemUnderTest.setEcDI6(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();

		assertEquals(bit6, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyEcDI6EcWOnAndCpTakeoverOn_OutputIsUnchanged() {
		systemUnderTest.setEcDI6(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyEcDI7AndEcWOn_OutputIsBit7() {
		systemUnderTest.setEcDI7(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.step();

		assertEquals(bit7, getDataOut(systemUnderTest));
	}

	@Test
	public void test_WithOnlyEcDI7EcWOnAndCpTakeoverOn_OutputIsUnchanged() {
		systemUnderTest.setEcDI7(on);
		systemUnderTest.setEcW(on);
		systemUnderTest.setCpTakeover(on);
		systemUnderTest.step();

		assertEquals(0, getDataOut(systemUnderTest));
	}
}

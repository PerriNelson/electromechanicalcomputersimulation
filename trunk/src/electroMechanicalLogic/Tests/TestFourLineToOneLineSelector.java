/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.Tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalLogic.FourLineToOneLineSelector;
import electroMechanicalLogic.Interfaces.IFourLineToOneLineSelector;

public class TestFourLineToOneLineSelector {
	private enum WhichInput {
		A, B, C, D
	}

	private IFourLineToOneLineSelector systemUnderTest;

	private static final int A = 0;;

	private static final int B = 1;
	private static final int C = 2;
	private static final int D = 3;

	@Before
	public void setUp() {
		systemUnderTest = new FourLineToOneLineSelector();
		systemUnderTest.setPower(true);
	}

	@Test
	public void testSelector_shouldSelectA_whenAddressingA_withAOff() {
		setInput(WhichInput.A, false);
		setAddress(A);

		systemUnderTest.step();
		assertFalse(systemUnderTest.getDO());
	}

	@Test
	public void testSelector_shouldSelectA_whenAddressingA_withAOn() {
		setInput(WhichInput.A, true);
		setAddress(A);

		systemUnderTest.step();
		assertTrue(systemUnderTest.getDO());
	}

	@Test
	public void testSelector_shouldSelectB__whenAddressingB_withBOff() {
		setInput(WhichInput.B, false);
		setAddress(B);

		systemUnderTest.step();
		assertFalse(systemUnderTest.getDO());
	}

	@Test
	public void testSelector_shouldSelectB_whenAddressingB_withBOn() {
		setInput(WhichInput.B, true);
		setAddress(B);

		systemUnderTest.step();
		assertTrue(systemUnderTest.getDO());
	}

	@Test
	public void testSelector_shouldSelectC_whenAddressingC_withCOff() {
		setInput(WhichInput.C, false);
		setAddress(C);

		systemUnderTest.step();
		assertFalse(systemUnderTest.getDO());
	}

	@Test
	public void testSelector_shouldSelectC_whenAddressingC_withCOn() {
		setInput(WhichInput.C, true);
		setAddress(C);

		systemUnderTest.step();
		assertTrue(systemUnderTest.getDO());
	}

	@Test
	public void testSelector_shouldSelectD_whenAddressingD_withDOff() {
		setInput(WhichInput.D, false);
		setAddress(D);

		systemUnderTest.step();
		assertFalse(systemUnderTest.getDO());
	}

	@Test
	public void testSelector_shouldSelectD_whenAddressingD_withDOn() {
		setInput(WhichInput.D, true);
		setAddress(D);

		systemUnderTest.step();
		assertTrue(systemUnderTest.getDO());
	}

	private void setAddress(final int address) {
		systemUnderTest.setS0((address & 1) == 1);
		systemUnderTest.setS1((address & 2) == 2);
	}

	private void setInput(final WhichInput whichInput, final boolean value) {
		systemUnderTest.setA(whichInput == WhichInput.A ? value : !value);
		systemUnderTest.setB(whichInput == WhichInput.B ? value : !value);
		systemUnderTest.setC(whichInput == WhichInput.C ? value : !value);
		systemUnderTest.setD(whichInput == WhichInput.D ? value : !value);
	}
}

/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */
package electroMechanicalLogic;

import electroMechanicalLogic.Interfaces.ITwoInputSingleOutputGate;

/**
 * A two input XOR gate. The output of an XOR gate is on when the power is on
 * and either of the "A" and "B" inputs is on but not both. The output of an XOR
 * gate is off when the power is off or both of the "A" and "B" inputs are off
 * or both of the "A" and "B" inputs are on.
 */
public final class TwoInputXOR implements ITwoInputSingleOutputGate {

	private final ITwoInputSingleOutputGate nAnd = new TwoInputNAND();
	private final ITwoInputSingleOutputGate or = new TwoInputOR();
	private final ITwoInputSingleOutputGate and = new TwoInputAND();

	@Override
	public boolean getOutput() {
		return and.getOutput();
	}

	@Override
	public void setA(final boolean value) {
		nAnd.setA(value);
		or.setA(value);
	}

	@Override
	public void setB(final boolean value) {
		nAnd.setB(value);
		or.setB(value);
	}

	@Override
	public void setPower(final boolean value) {
		nAnd.setPower(value);
		or.setPower(value);
		and.setPower(value);
	}

	@Override
	public void step() {
		nAnd.step();
		or.step();
		and.setA(nAnd.getOutput());
		and.setB(or.getOutput());
		and.step();
	}
}

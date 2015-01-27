/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */
package electroMechanicalLogic.Gates;

import electroMechanicalLogic.Buffer;
import electroMechanicalLogic.Gates.Interfaces.ITwoInputSingleOutputGate;

/**
 * A two input AND gate. The output of an AND gate is on when the power is on
 * and both the "A" and "B" inputs are on. The output of an AND gate is off when
 * the power is off or either or both of the "A" and "B" inputs is off.
 */
public final class TwoInputAND extends TwoRelaySingleOutputGate implements
		ITwoInputSingleOutputGate {

	public TwoInputAND() {
		super(new Buffer(), new Buffer());
	}

	@Override
	public boolean getOutput() {
		return b.getOutput();
	}

	@Override
	public void setPower(final boolean value) {
		a.setPower(value);
	}

	@Override
	public void step() {
		a.step();
		b.setPower(a.getOutput());
		b.step();
	}
}

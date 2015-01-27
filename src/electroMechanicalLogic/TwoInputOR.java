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
 * A two input OR gate. The output of an OR gate is on when the power is on and
 * either of the "A" and "B" inputs is on. The output of an OR gate is off when
 * the power is off or both of the "A" and "B" inputs are off.
 */
public final class TwoInputOR extends TwoRelaySingleOutputGate implements
		ITwoInputSingleOutputGate {

	public TwoInputOR() {
		super(new Buffer(), new Buffer());
	}

	@Override
	public boolean getOutput() {
		return a.getOutput() || b.getOutput();
	}

	@Override
	public void setPower(final boolean value) {
		a.setPower(value);
		b.setPower(value);
	}

	@Override
	public void step() {
		a.step();
		b.step();
	}
}

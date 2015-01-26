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
 * A two input NOR gate. The output of a NOR gate is on when the power is on and
 * both the "A" and "B" inputs are off. The output of a NOR gate is off when the
 * power is off or either the "A" or "B" input is on.
 */
public final class TwoInputNOR extends TwoRelaySingleOutputGate implements
		ITwoInputSingleOutputGate {

	public TwoInputNOR() {
		super(new Inverter(), new Inverter());
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

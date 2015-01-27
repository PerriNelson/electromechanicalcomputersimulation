/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */
package electroMechanicalLogic.Gates;

import electroMechanicalLogic.Inverter;
import electroMechanicalLogic.Gates.Interfaces.ITwoInputSingleOutputGate;

/**
 * A two input NAND gate. The output of a NAND gate is on when the power is on
 * and one or both of the "A" and "B" inputs are off. The output of a NAND gate
 * is off when the power is off or both the "A" and "B" input are on.
 */
public final class TwoInputNAND extends TwoRelaySingleOutputGate implements
		ITwoInputSingleOutputGate {

	public TwoInputNAND() {
		super(new Inverter(), new Inverter());
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

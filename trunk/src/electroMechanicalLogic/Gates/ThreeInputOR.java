/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */
package electroMechanicalLogic.Gates;

import electroMechanicalLogic.Buffer;
import electroMechanicalLogic.Gates.Interfaces.IThreeInputSingleOutputGate;
import electroMechanicalLogic.Interfaces.IRelay;

/**
 * A three input logic gate that performs a logical OR on all of its inputs. If
 * the power is on and any of the inputs is on the output is on. If the power is
 * off or none of the inputs are on the output is off.
 */
public final class ThreeInputOR implements IThreeInputSingleOutputGate {
	private final IRelay a = new Buffer();
	private final IRelay b = new Buffer();
	private final IRelay c = new Buffer();

	@Override
	public boolean getOutput() {
		return a.getOutput() || b.getOutput() || c.getOutput();
	}

	@Override
	public void setA(final boolean value) {
		a.setInput(value);
	}

	@Override
	public void setB(final boolean value) {
		b.setInput(value);
	}

	@Override
	public void setC(final boolean value) {
		c.setInput(value);
	}

	@Override
	public void setPower(final boolean value) {
		a.setPower(value);
		b.setPower(value);
		c.setPower(value);
	}

	@Override
	public void step() {
		a.step();
		b.step();
		c.step();
	}
}

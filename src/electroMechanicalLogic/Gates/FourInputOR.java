/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.Gates;

import electroMechanicalLogic.Buffer;
import electroMechanicalLogic.Gates.Interfaces.IFourInputSingleOutputGate;
import electroMechanicalLogic.Interfaces.IRelay;

public final class FourInputOR implements IFourInputSingleOutputGate {

	private final IRelay a = new Buffer();
	private final IRelay b = new Buffer();
	private final IRelay c = new Buffer();
	private final IRelay d = new Buffer();

	@Override
	public boolean getOutput() {
		return a.getOutput() || b.getOutput() || c.getOutput() || d.getOutput();
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
	public void setD(final boolean value) {
		d.setInput(value);
	}

	@Override
	public void setPower(final boolean value) {
		a.setPower(value);
		b.setPower(value);
		c.setPower(value);
		d.setPower(value);
	}

	@Override
	public void step() {
		a.step();
		b.step();
		c.step();
		d.step();
	}

}

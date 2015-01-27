/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic;

import electroMechanicalLogic.Interfaces.IRelay;
import electroMechanicalLogic.Interfaces.IThreeInputSingleOutputGate;

/**
 * A three input logic gate that performs a logical NOR on all of its inputs. If
 * the power is on and all of the inputs are off the output is on. If the power
 * is off or any of the inputs are on the output is off.
 */
public class ThreeInputNOR implements IThreeInputSingleOutputGate {

	private final IRelay a = new Inverter();
	private final IRelay b = new Inverter();
	private final IRelay c = new Inverter();

	@Override
	public boolean getOutput() {
		return c.getOutput();
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
	}

	@Override
	public void step() {
		a.step();

		b.setPower(a.getOutput());
		b.step();

		c.setPower(b.getOutput());
		c.step();
	}
}

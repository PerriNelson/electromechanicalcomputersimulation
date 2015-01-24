/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic;

import electroMechanicalLogic.Interfaces.IOneLineToTwoLineDecoder;
import electroMechanicalLogic.Interfaces.IRelay;
import electroMechanicalLogic.Interfaces.ITwoInputSingleOutputGate;

public class OneLineToTwoLineDecoder implements IOneLineToTwoLineDecoder {

	private final IRelay select = new Inverter();
	private final ITwoInputSingleOutputGate a = new TwoInputAndGate();
	private final ITwoInputSingleOutputGate b = new TwoInputAndGate();

	@Override
	public boolean getA() {
		return a.getOutput();
	}

	@Override
	public boolean getB() {
		return b.getOutput();
	}

	@Override
	public void setInput(final boolean value) {
		a.setA(value);
		b.setA(value);
	}

	@Override
	public void setPower(final boolean value) {
		select.setPower(value);
		a.setPower(value);
		b.setPower(value);
	}

	@Override
	public void setSelect(final boolean value) {
		b.setB(value);
		select.setInput(value);
	}

	@Override
	public void step() {
		select.step();

		a.setB(select.getOutput());
		a.step();

		b.step();
	}
}

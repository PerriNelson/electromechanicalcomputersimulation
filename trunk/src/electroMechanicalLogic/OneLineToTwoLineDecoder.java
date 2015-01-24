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

	private final IRelay inverter = new Inverter();
	private final ITwoInputSingleOutputGate and0 = new TwoInputAndGate();
	private final ITwoInputSingleOutputGate and1 = new TwoInputAndGate();

	@Override
	public boolean getO0() {
		return and0.getOutput();
	}

	@Override
	public boolean getO1() {
		return and1.getOutput();
	}

	@Override
	public void setInput(final boolean value) {
		and0.setA(value);
		and1.setA(value);
	}

	@Override
	public void setPower(final boolean value) {
		inverter.setPower(value);
		and0.setPower(value);
		and1.setPower(value);
	}

	@Override
	public void setSelect(final boolean value) {
		and1.setB(value);
		inverter.setInput(value);
	}

	@Override
	public void step() {
		inverter.step();

		and0.setB(inverter.getOutput());
		and0.step();

		and1.step();
	}
}

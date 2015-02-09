/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.Selectors;

import electroMechanicalLogic.Inverter;
import electroMechanicalLogic.Gates.TwoInputAND;
import electroMechanicalLogic.Gates.TwoInputOR;
import electroMechanicalLogic.Gates.Interfaces.ITwoInputSingleOutputGate;
import electroMechanicalLogic.Interfaces.IRelay;
import electroMechanicalLogic.Selectors.Interfaces.ITwoToOneSelector;

/**
 * A circuit that "selects" between two inputs to produce one output.
 */
public final class TwoToOneSelector implements ITwoToOneSelector {

	private final IRelay selectInverter = new Inverter();
	private final ITwoInputSingleOutputGate andA = new TwoInputAND();
	private final ITwoInputSingleOutputGate andB = new TwoInputAND();
	private final ITwoInputSingleOutputGate or = new TwoInputOR();

	@Override
	public boolean getDO() {
		return or.getOutput();
	}

	@Override
	public void setA(final boolean value) {
		andA.setA(value);
	}

	@Override
	public void setB(final boolean value) {
		andB.setB(value);
	}

	@Override
	public void setPower(final boolean value) {
		selectInverter.setPower(value);
		andA.setPower(value);
		andB.setPower(value);
		or.setPower(value);
	}

	@Override
	public void setSelect(final boolean value) {
		andB.setA(value);
		selectInverter.setInput(value);
	}

	@Override
	public void step() {
		selectInverter.step();

		andA.setB(selectInverter.getOutput());
		andA.step();

		andB.step();

		or.setA(andA.getOutput());
		or.setB(andB.getOutput());
		or.step();
	}
}

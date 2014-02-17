/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */
package electroMechanicalLogic;

import electroMechanicalLogic.Interfaces.ITwoInputSingleOutputGate;

public final class TwoInputXOrGate implements ITwoInputSingleOutputGate {

	private ITwoInputSingleOutputGate nAnd = new TwoInputNAndGate();
	private ITwoInputSingleOutputGate or = new TwoInputOrGate();
	private ITwoInputSingleOutputGate and = new TwoInputAndGate();

	@Override
	public boolean getOutput() {
		return and.getOutput();
	}

	@Override
	public void setA(boolean value) {
		nAnd.setA(value);
		or.setA(value);
	}

	@Override
	public void setB(boolean value) {
		nAnd.setB(value);
		or.setB(value);
	}

	@Override
	public void setPower(boolean value) {
		nAnd.setPower(value);
		or.setPower(value);
		and.setPower(value);
	}

	@Override
	public void step() {
		nAnd.step();
		or.step();
		and.setA(nAnd.getOutput());
		and.setB(or.getOutput());
		and.step();
	}

}

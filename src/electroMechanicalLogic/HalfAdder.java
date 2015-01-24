/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */
package electroMechanicalLogic;

import electroMechanicalLogic.Interfaces.IHalfAdder;
import electroMechanicalLogic.Interfaces.ITwoInputSingleOutputGate;

public final class HalfAdder implements IHalfAdder {

	private final ITwoInputSingleOutputGate xor = new TwoInputXOrGate();
	private final ITwoInputSingleOutputGate and = new TwoInputAndGate();

	@Override
	public boolean getCO() {
		return and.getOutput();
	}

	@Override
	public boolean getS() {
		return xor.getOutput();
	}

	@Override
	public void setA(final boolean value) {
		xor.setA(value);
		and.setA(value);
	}

	@Override
	public void setB(final boolean value) {
		xor.setB(value);
		and.setB(value);
	}

	@Override
	public void setPower(final boolean value) {
		xor.setPower(value);
		and.setPower(value);
	}

	@Override
	public void step() {
		xor.step();
		and.step();
	}
}

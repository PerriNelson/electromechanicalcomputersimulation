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

public final class ThreeInputOrGate implements IThreeInputSingleOutputGate {
	private final IRelay A = new Buffer();
	private final IRelay B = new Buffer();
	private final IRelay C = new Buffer();

	@Override
	public boolean getOutput() {
		return A.getOutput() || B.getOutput() || C.getOutput();
	}

	@Override
	public void setA(final boolean value) {
		A.setInput(value);
	}

	@Override
	public void setB(final boolean value) {
		B.setInput(value);
	}

	@Override
	public void setC(final boolean value) {
		C.setInput(value);
	}

	@Override
	public void setPower(final boolean value) {
		A.setPower(value);
		B.setPower(value);
		C.setPower(value);
	}

	@Override
	public void step() {
		A.step();
		B.step();
		C.step();
	}
}

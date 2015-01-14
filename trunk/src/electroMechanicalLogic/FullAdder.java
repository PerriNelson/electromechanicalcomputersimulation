/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */
package electroMechanicalLogic;

import electroMechanicalLogic.Interfaces.IFullAdder;
import electroMechanicalLogic.Interfaces.IHalfAdder;
import electroMechanicalLogic.Interfaces.ITwoInputSingleOutputGate;

public final class FullAdder implements IFullAdder {

	private IHalfAdder bottomHalf = new HalfAdder();
	private IHalfAdder topHalf = new HalfAdder();
	private ITwoInputSingleOutputGate or = new TwoInputOrGate();

	@Override
	public boolean getCO() {
		return or.getOutput();
	}

	@Override
	public boolean getS() {
		return bottomHalf.getS();
	}

	@Override
	public void setA(boolean value) {
		topHalf.setA(value);
	}

	@Override
	public void setB(boolean value) {
		topHalf.setB(value);
	}

	@Override
	public void setCI(boolean value) {
		bottomHalf.setA(value);
	}

	@Override
	public void setPower(boolean value) {
		bottomHalf.setPower(value);
		topHalf.setPower(value);
		or.setPower(value);
	}

	@Override
	public void step() {
		topHalf.step();

		bottomHalf.setB(topHalf.getS());
		bottomHalf.step();

		or.setA(bottomHalf.getCO());
		or.setB(topHalf.getCO());
		or.step();
	}
}

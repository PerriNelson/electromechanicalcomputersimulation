/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */
package electroMechanicalLogic;

import electroMechanicalLogic.Interfaces.IFullAdder;
import electroMechanicalLogic.Interfaces.ITwoInputSingleOutputGate;

public final class FullAdder implements IFullAdder {

	private HalfAdder bottomHalf = new HalfAdder();
	private HalfAdder topHalf = new HalfAdder();
	private ITwoInputSingleOutputGate or = new TwoInputOrGate();


	public boolean getCO() {
		return or.getOutput();
	}

	public boolean getS() {
		return bottomHalf.getS();
	}

	public void setA(boolean value) {
		topHalf.setA(value);
	}

	public void setB(boolean value) {
		topHalf.setB(value);
	}

	public void setCI(boolean value) {
		bottomHalf.setA(value);
	}

	public void setPower(boolean value) {
		bottomHalf.setPower(value);
		topHalf.setPower(value);
		or.setPower(value);
	}

	public void step() {
		topHalf.step();
		bottomHalf.setB(topHalf.getS());
		bottomHalf.step();
		or.setA(bottomHalf.getCO());
		or.setB(topHalf.getCO());
		or.step();
	}
}

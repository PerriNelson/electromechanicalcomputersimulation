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

/**
 * A full adder is a circuit that accepts two binary inputs and a binary carry
 * input and produces the result of adding them together, a sum and a carry bit.
 */
public final class FullAdder implements IFullAdder {

	private final IHalfAdder bottomHalf = new HalfAdder();
	private final IHalfAdder topHalf = new HalfAdder();
	private final ITwoInputSingleOutputGate or = new TwoInputOR();

	@Override
	public boolean getCO() {
		return or.getOutput();
	}

	@Override
	public boolean getS() {
		return bottomHalf.getS();
	}

	@Override
	public void setA(final boolean value) {
		topHalf.setA(value);
	}

	@Override
	public void setB(final boolean value) {
		topHalf.setB(value);
	}

	@Override
	public void setCI(final boolean value) {
		bottomHalf.setA(value);
	}

	@Override
	public void setPower(final boolean value) {
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

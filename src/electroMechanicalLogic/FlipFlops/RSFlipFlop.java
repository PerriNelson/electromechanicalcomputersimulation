/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.FlipFlops;

import electroMechanicalLogic.FlipFlops.Interfaces.IRSFlipFlop;
import electroMechanicalLogic.Gates.TwoInputNOR;
import electroMechanicalLogic.Gates.Interfaces.ITwoInputSingleOutputGate;

/**
 * A simple set/reset flip-flop circuit. A flip-flop circuit "remembers" which
 * of its inputs was last on when both inputs are off. The outputs of an RS type
 * flip-flop are invalid when both inputs are or were on simultaneously. For an
 * RS type flip-flop the "Q" output is on when the "R" input was the last input
 * turned on. It is off when the "S" input was the last input turned on (or when
 * power to the entire circuit is off).
 */
public final class RSFlipFlop implements IRSFlipFlop {

	private final ITwoInputSingleOutputGate r = new TwoInputNOR();
	private final ITwoInputSingleOutputGate s = new TwoInputNOR();

	@Override
	public boolean getQ() {
		return r.getOutput();
	}

	@Override
	public boolean getQBar() {
		return s.getOutput();
	}

	private void halfStep() {
		r.setA(s.getOutput());
		s.setB(r.getOutput());

		r.step();
		s.step();
	}

	@Override
	public void setPower(final boolean value) {
		r.setPower(value);
		s.setPower(value);
	}

	@Override
	public void setR(final boolean value) {
		r.setB(value);
	}

	@Override
	public void setS(final boolean value) {
		s.setA(value);
	}

	@Override
	public void step() {
		halfStep();
		halfStep();
	}
}

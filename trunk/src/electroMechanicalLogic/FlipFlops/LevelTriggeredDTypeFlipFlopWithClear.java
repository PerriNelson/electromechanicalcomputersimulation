/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.FlipFlops;

import electroMechanicalLogic.FlipFlops.Interfaces.IDTypeFlipFlopWithClear;
import electroMechanicalLogic.Gates.TwoInputOR;
import electroMechanicalLogic.Gates.Interfaces.ITwoInputSingleOutputGate;

/**
 * A Level-Triggered D-Type flip-flop with a "Clear" input that clears any value
 * stored in the flip-flop when it is on.
 */
public final class LevelTriggeredDTypeFlipFlopWithClear extends
		LevelTriggeredDTypeFlipFlop implements IDTypeFlipFlopWithClear {

	private final ITwoInputSingleOutputGate clear = new TwoInputOR();

	@Override
	public void setClear(final boolean value) {
		clear.setB(value);
	}

	@Override
	public void setPower(final boolean value) {
		super.setPower(value);
		clear.setPower(value);
	}

	@Override
	public void step() {
		dBar.step();

		reset.setB(dBar.getOutput());
		reset.step();

		clear.setA(reset.getOutput());
		clear.step();

		set.step();

		flipFlop.setS(set.getOutput());
		flipFlop.setR(clear.getOutput());
		flipFlop.step();
	}
}

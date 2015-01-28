/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.FlipFlops;

import electroMechanicalLogic.Inverter;
import electroMechanicalLogic.FlipFlops.Interfaces.IDTypeFlipFlop;
import electroMechanicalLogic.FlipFlops.Interfaces.IRSFlipFlop;
import electroMechanicalLogic.Gates.TwoInputAND;
import electroMechanicalLogic.Gates.Interfaces.ITwoInputSingleOutputGate;
import electroMechanicalLogic.Interfaces.IRelay;

/**
 * A Level-Triggered D-Type flip-flop is a flip-flop used to store one bit of
 * data whenever the clock signal is on.
 */
public class LevelTriggeredDTypeFlipFlop implements IDTypeFlipFlop {

	protected final IRSFlipFlop flipFlop = new RSFlipFlop();
	protected final ITwoInputSingleOutputGate set = new TwoInputAND();
	protected final ITwoInputSingleOutputGate reset = new TwoInputAND();
	protected final IRelay dBar = new Inverter();

	@Override
	public boolean getQ() {
		return flipFlop.getQ();
	}

	@Override
	public boolean getQBar() {
		return flipFlop.getQBar();
	}

	@Override
	public void setClk(final boolean value) {
		set.setB(value);
		reset.setA(value);
	}

	@Override
	public void setD(final boolean value) {
		dBar.setInput(value);
		set.setA(value);
	}

	@Override
	public void setPower(final boolean value) {
		dBar.setPower(value);
		set.setPower(value);
		reset.setPower(value);
		flipFlop.setPower(value);
	}

	@Override
	public void step() {
		dBar.step();

		reset.setB(dBar.getOutput());
		reset.step();

		set.step();

		flipFlop.setS(set.getOutput());
		flipFlop.setR(reset.getOutput());
		flipFlop.step();
	}

}

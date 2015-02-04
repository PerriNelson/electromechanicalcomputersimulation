/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Processor;

import electroMechanicalLogic.Inverter;
import electroMechanicalLogic.FlipFlops.EdgeTriggeredDTypeFlipFlopWithPresetAndClear;
import electroMechanicalLogic.FlipFlops.Interfaces.IDTypeFlipFlopWithPresetAndClear;
import electroMechanicalLogic.Gates.TwoInputAND;
import electroMechanicalLogic.Gates.TwoInputOR;
import electroMechanicalLogic.Gates.Interfaces.ITwoInputSingleOutputGate;
import electroMechanicalLogic.Interfaces.IRelay;
import electroMechanicalMachine.Processor.Interfaces.ISetableFlipFlop;

/**
 * An edge triggered D-Type flip-flop that can be set to contain a specific
 * value regardless of the clock input.
 */
public class SetableEdgeTriggeredFlipFlop implements ISetableFlipFlop {
	private final IDTypeFlipFlopWithPresetAndClear flipflop = new EdgeTriggeredDTypeFlipFlopWithPresetAndClear();
	private final ITwoInputSingleOutputGate resetOrSetABar = new TwoInputOR();
	private final ITwoInputSingleOutputGate setABar = new TwoInputAND();
	private final ITwoInputSingleOutputGate setA = new TwoInputAND();
	private final IRelay aBar = new Inverter();

	@Override
	public boolean getQ() {
		return flipflop.getQ();
	}

	@Override
	public boolean getQBar() {
		return flipflop.getQBar();
	}

	@Override
	public void setA(final boolean value) {
		setA.setB(value);
		aBar.setInput(value);
	}

	@Override
	public void setClk(final boolean value) {
		flipflop.setClk(value);
	}

	@Override
	public void setD(final boolean value) {
		flipflop.setD(value);
	}

	@Override
	public void setPower(final boolean value) {
		flipflop.setPower(value);
		resetOrSetABar.setPower(value);
		setABar.setPower(value);
		setA.setPower(value);
		aBar.setPower(value);
	}

	@Override
	public void setReset(final boolean value) {
		resetOrSetABar.setA(value);
	}

	@Override
	public void setSet(final boolean value) {
		setA.setA(value);
		setABar.setA(value);
	}

	@Override
	public void step() {

		aBar.step();
		setABar.setB(aBar.getOutput());
		setABar.step();

		resetOrSetABar.setB(setABar.getOutput());
		resetOrSetABar.step();

		setA.step();

		flipflop.setPreset(setA.getOutput());
		flipflop.setClear(resetOrSetABar.getOutput());
		flipflop.step();
	}

}

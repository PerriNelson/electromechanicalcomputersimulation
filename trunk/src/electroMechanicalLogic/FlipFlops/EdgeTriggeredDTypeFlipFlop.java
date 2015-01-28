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
 * An Edge-Triggered D-Type flip-flop is a flip-flop used to store one bit of
 * data when the clock signal transitions from off to on. The value present at
 * the "D" input when the clock signal is off will be stored in the flip-flop at
 * the moment the clock signal transitions to on.
 * 
 * For this simulation's purposes that means that you must set the "D" input
 * with the "Clk" input off and make sure that the circuit is stepped before
 * setting the "Clk" input on and stepping the circuit. If the "D" value is
 * changed at the same time the "Clk" input is changed the "D" value that was
 * present when the "Clk" input was off will be stored in the flip-flop.
 */
public final class EdgeTriggeredDTypeFlipFlop implements IDTypeFlipFlop {
	private final IRSFlipFlop stage1 = new RSFlipFlop();
	private final IRSFlipFlop stage2 = new RSFlipFlop();
	private final ITwoInputSingleOutputGate sAnd1 = new TwoInputAND();
	private final ITwoInputSingleOutputGate rAnd1 = new TwoInputAND();
	private final ITwoInputSingleOutputGate sAnd2 = new TwoInputAND();
	private final ITwoInputSingleOutputGate rAnd2 = new TwoInputAND();
	private final IRelay dBar = new Inverter();
	private final IRelay clkBar = new Inverter();

	@Override
	public boolean getQ() {
		return stage2.getQ();
	}

	@Override
	public boolean getQBar() {
		return stage2.getQBar();
	}

	@Override
	public void setClk(final boolean value) {
		clkBar.setInput(value);
		sAnd2.setB(value);
		rAnd2.setA(value);
	}

	@Override
	public void setD(final boolean value) {
		dBar.setInput(value);
		rAnd1.setB(value);
	}

	@Override
	public void setPower(final boolean value) {
		dBar.setPower(value);
		clkBar.setPower(value);
		sAnd1.setPower(value);
		rAnd1.setPower(value);
		stage1.setPower(value);
		sAnd2.setPower(value);
		rAnd2.setPower(value);
		stage2.setPower(value);
	}

	@Override
	public void step() {
		clkBar.step();
		dBar.step();

		sAnd1.setA(dBar.getOutput());
		sAnd1.setB(clkBar.getOutput());

		rAnd1.setA(clkBar.getOutput());

		sAnd1.step();
		rAnd1.step();

		stage1.setS(sAnd1.getOutput());
		stage1.setR(rAnd1.getOutput());
		stage1.step();

		sAnd2.setA(stage1.getQBar());
		rAnd2.setB(stage1.getQ());

		sAnd2.step();
		rAnd2.step();

		stage2.setS(sAnd2.getOutput());
		stage2.setR(rAnd2.getOutput());
		stage2.step();
	}
}

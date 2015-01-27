/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic;

import electroMechanicalLogic.Interfaces.IDTypeFlipFlop;
import electroMechanicalLogic.Interfaces.IRSFlipFlop;
import electroMechanicalLogic.Interfaces.IRelay;
import electroMechanicalLogic.Interfaces.ITwoInputSingleOutputGate;

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

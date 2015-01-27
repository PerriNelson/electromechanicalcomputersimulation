/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic;

import electroMechanicalLogic.Gates.ThreeInputNOR;
import electroMechanicalLogic.Gates.Interfaces.IThreeInputSingleOutputGate;
import electroMechanicalLogic.Interfaces.IDTypeFlipFlopWithPresetAndClear;
import electroMechanicalLogic.Interfaces.IRelay;

public final class EdgeTriggeredDTypeFlipFlopWithPresetAndClear implements
		IDTypeFlipFlopWithPresetAndClear {

	private final IRelay clkBar = new Inverter();
	private final IThreeInputSingleOutputGate norD = new ThreeInputNOR();
	private final IThreeInputSingleOutputGate norClk = new ThreeInputNOR();
	private final IThreeInputSingleOutputGate norPreset = new ThreeInputNOR();
	private final IThreeInputSingleOutputGate norClear = new ThreeInputNOR();
	private final IThreeInputSingleOutputGate norQ = new ThreeInputNOR();
	private final IThreeInputSingleOutputGate norQBar = new ThreeInputNOR();

	@Override
	public boolean getQ() {
		return norQ.getOutput();
	}

	@Override
	public boolean getQBar() {
		return norQBar.getOutput();
	}

	private void internalStep() {
		norClear.setB(norD.getOutput());
		norClear.setA(norPreset.getOutput());

		norPreset.setC(norClear.getOutput());

		norClk.setC(norPreset.getOutput());
		norClk.setA(norD.getOutput());

		norD.setC(norClk.getOutput());

		norQ.setB(norPreset.getOutput());
		norQ.setA(norQBar.getOutput());

		norQBar.setA(norClk.getOutput());
		norQBar.setC(norQ.getOutput());

		norClear.step();
		norPreset.step();
		norClk.step();
		norD.step();
		norQ.step();
		norQBar.step();
	}

	@Override
	public void setClear(final boolean value) {
		norClear.setC(value);
		norQ.setC(value);
	}

	@Override
	public void setClk(final boolean value) {
		clkBar.setInput(value);
	}

	@Override
	public void setD(final boolean value) {
		norD.setA(value);
	}

	@Override
	public void setPower(final boolean value) {
		clkBar.setPower(value);
		norD.setPower(value);
		norPreset.setPower(value);
		norClk.setPower(value);
		norClear.setPower(value);
		norQ.setPower(value);
		norQBar.setPower(value);
	}

	@Override
	public void setPreset(final boolean value) {
		norPreset.setB(value);
		norD.setB(value);
		norQBar.setB(value);
	}

	@Override
	public void step() {
		clkBar.step();

		norPreset.setA(clkBar.getOutput());
		norClk.setB(clkBar.getOutput());

		internalStep();
		internalStep();
		internalStep();

		internalStep();
		internalStep();
		internalStep();
	}
}

/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic;

import electroMechanicalLogic.Interfaces.IDTypeFlipFlopWithPresetAndClear;
import electroMechanicalLogic.Interfaces.IRelay;
import electroMechanicalLogic.Interfaces.IThreeInputSingleOutputGate;

public final class EdgeTriggeredDTypeFlipFlopWithPresetAndClear implements
		IDTypeFlipFlopWithPresetAndClear {

	private IRelay clkBar = new Inverter();
	private IThreeInputSingleOutputGate norD = new ThreeInputNOrGate();
	private IThreeInputSingleOutputGate norClk = new ThreeInputNOrGate();
	private IThreeInputSingleOutputGate norPreset = new ThreeInputNOrGate();
	private IThreeInputSingleOutputGate norClear = new ThreeInputNOrGate();
	private IThreeInputSingleOutputGate norQ = new ThreeInputNOrGate();
	private IThreeInputSingleOutputGate norQBar = new ThreeInputNOrGate();

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
	public void setClear(boolean value) {
		norClear.setC(value);
		norQ.setC(value);
	}

	@Override
	public void setClk(boolean value) {
		clkBar.setInput(value);
	}

	@Override
	public void setD(boolean value) {
		norD.setA(value);
	}

	@Override
	public void setPower(boolean value) {
		clkBar.setPower(value);
		norD.setPower(value);
		norPreset.setPower(value);
		norClk.setPower(value);
		norClear.setPower(value);
		norQ.setPower(value);
		norQBar.setPower(value);
	}

	@Override
	public void setPreset(boolean value) {
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
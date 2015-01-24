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

public class LevelTriggeredDTypeFlipFlop implements IDTypeFlipFlop {

	protected final IRSFlipFlop flipFlop = new RSFlipFlop();
	protected final ITwoInputSingleOutputGate sAnd = new TwoInputAndGate();
	protected final ITwoInputSingleOutputGate rAnd = new TwoInputAndGate();
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
		sAnd.setB(value);
		rAnd.setA(value);
	}

	@Override
	public void setD(final boolean value) {
		dBar.setInput(value);
		sAnd.setA(value);
	}

	@Override
	public void setPower(final boolean value) {
		dBar.setPower(value);
		sAnd.setPower(value);
		rAnd.setPower(value);
		flipFlop.setPower(value);
	}

	@Override
	public void step() {
		dBar.step();

		rAnd.setB(dBar.getOutput());
		rAnd.step();

		sAnd.step();

		flipFlop.setS(sAnd.getOutput());
		flipFlop.setR(rAnd.getOutput());
		flipFlop.step();
	}

}

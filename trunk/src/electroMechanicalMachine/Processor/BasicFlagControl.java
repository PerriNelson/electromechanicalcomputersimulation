/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Processor;

import electroMechanicalLogic.Gates.FourInputOR;
import electroMechanicalLogic.Gates.TwoInputAND;
import electroMechanicalLogic.Gates.Interfaces.IFourInputSingleOutputGate;
import electroMechanicalLogic.Gates.Interfaces.ITwoInputSingleOutputGate;
import electroMechanicalLogic.Interfaces.ISimulatedCircuit;
import electroMechanicalMachine.Processor.Interfaces.IFlagControl;

public class BasicFlagControl implements ISimulatedCircuit, IFlagControl {
	private final IFourInputSingleOutputGate operationAffectsFlags = new FourInputOR();
	private final ITwoInputSingleOutputGate latchFlags = new TwoInputAND();

	@Override
	public boolean getLatchFlags() {
		return latchFlags.getOutput();
	}

	@Override
	public void setAdd(boolean value) {
		operationAffectsFlags.setA(value);
	}

	@Override
	public void setAddWithCarry(boolean value) {
		operationAffectsFlags.setB(value);
	}

	@Override
	public void setExecute(boolean value) {
		latchFlags.setB(value);
	}

	@Override
	public void setSubtract(boolean value) {
		operationAffectsFlags.setC(value);
	}

	@Override
	public void setSubtractWithBorrow(boolean value) {
		operationAffectsFlags.setD(value);
	}

	@Override
	public void setPower(boolean value) {
		operationAffectsFlags.setPower(value);
		latchFlags.setPower(value);
	}

	@Override
	public void step() {
		operationAffectsFlags.step();
		latchFlags.setA(operationAffectsFlags.getOutput());
		latchFlags.step();
	}
}

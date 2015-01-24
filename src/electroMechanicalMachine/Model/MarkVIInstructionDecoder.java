/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Model;

import electroMechanicalLogic.EightInputANDGate;
import electroMechanicalLogic.EightInputNORGate;
import electroMechanicalLogic.Inverter;
import electroMechanicalLogic.Interfaces.IEightInputSingleOutputGate;
import electroMechanicalLogic.Interfaces.IRelay;
import electroMechanicalMachine.Model.Interfaces.IMarkVIInstructionDecoder;

public class MarkVIInstructionDecoder implements IMarkVIInstructionDecoder {
	protected IRelay ci0Bar;
	private final IRelay ci4Bar;
	protected IRelay ci5Bar;
	private final IEightInputSingleOutputGate add;
	private final IEightInputSingleOutputGate halt;
	private final IEightInputSingleOutputGate load;
	private final IEightInputSingleOutputGate store;

	public MarkVIInstructionDecoder() {
		ci0Bar = new Inverter();
		ci4Bar = new Inverter();
		ci5Bar = new Inverter();
		add = new EightInputNORGate();
		halt = new EightInputANDGate();
		load = new EightInputNORGate();
		store = new EightInputNORGate();
	}

	@Override
	public boolean getAdd() {
		return add.getOutput();
	}

	@Override
	public boolean getHalt() {
		return halt.getOutput();
	}

	@Override
	public boolean getLoad() {
		return load.getOutput();
	}

	@Override
	public boolean getStore() {
		return store.getOutput();
	}

	@Override
	public void setCI0(final boolean value) {
		ci0Bar.setInput(value);
		add.setI0(value);
		load.setI0(value);
		halt.setI0(value);
	}

	@Override
	public void setCI1(final boolean value) {
		add.setI1(value);
		halt.setI1(value);
		load.setI1(value);
		store.setI1(value);
	}

	@Override
	public void setCI2(final boolean value) {
		add.setI2(value);
		halt.setI2(value);
		load.setI2(value);
		store.setI2(value);
	}

	@Override
	public void setCI3(final boolean value) {
		add.setI3(value);
		halt.setI3(value);
		load.setI3(value);
		store.setI3(value);
	}

	@Override
	public void setCI4(final boolean value) {
		ci4Bar.setInput(value);
		add.setI4(value);
		halt.setI4(value);
	}

	@Override
	public void setCI5(final boolean value) {
		ci5Bar.setInput(value);
		halt.setI5(value);
		load.setI5(value);
		store.setI5(value);
	}

	@Override
	public void setCI6(final boolean value) {
		add.setI6(value);
		halt.setI6(value);
		load.setI6(value);
		store.setI6(value);
	}

	@Override
	public void setCI7(final boolean value) {
		add.setI7(value);
		halt.setI7(value);
		load.setI7(value);
		store.setI7(value);
	}

	@Override
	public void setPower(final boolean value) {
		ci0Bar.setPower(value);
		ci4Bar.setPower(value);
		ci5Bar.setPower(value);
		add.setPower(value);
		halt.setPower(value);
		load.setPower(value);
		store.setPower(value);
	}

	@Override
	public void step() {
		ci0Bar.step();
		ci4Bar.step();
		ci5Bar.step();

		add.setI5(ci5Bar.getOutput());
		add.step();

		halt.step();

		load.setI4(ci4Bar.getOutput());
		load.step();

		store.setI0(ci0Bar.getOutput());
		store.setI4(ci4Bar.getOutput());
		store.step();
	}

}

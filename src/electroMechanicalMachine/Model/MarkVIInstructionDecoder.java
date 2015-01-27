/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Model;

import electroMechanicalLogic.Inverter;
import electroMechanicalLogic.Gates.EightInputAND;
import electroMechanicalLogic.Gates.EightInputNOR;
import electroMechanicalLogic.Gates.Interfaces.IEightInputSingleOutputGate;
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
		add = new EightInputNOR();
		halt = new EightInputAND();
		load = new EightInputNOR();
		store = new EightInputNOR();
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
	public void setDI0(final boolean value) {
		ci0Bar.setInput(value);
		add.setDI0(value);
		load.setDI0(value);
		halt.setDI0(value);
	}

	@Override
	public void setDI1(final boolean value) {
		add.setDI1(value);
		halt.setDI1(value);
		load.setDI1(value);
		store.setDI1(value);
	}

	@Override
	public void setDI2(final boolean value) {
		add.setDI2(value);
		halt.setDI2(value);
		load.setDI2(value);
		store.setDI2(value);
	}

	@Override
	public void setDI3(final boolean value) {
		add.setDI3(value);
		halt.setDI3(value);
		load.setDI3(value);
		store.setDI3(value);
	}

	@Override
	public void setDI4(final boolean value) {
		ci4Bar.setInput(value);
		add.setDI4(value);
		halt.setDI4(value);
	}

	@Override
	public void setDI5(final boolean value) {
		ci5Bar.setInput(value);
		halt.setDI5(value);
		load.setDI5(value);
		store.setDI5(value);
	}

	@Override
	public void setDI6(final boolean value) {
		add.setDI6(value);
		halt.setDI6(value);
		load.setDI6(value);
		store.setDI6(value);
	}

	@Override
	public void setDI7(final boolean value) {
		add.setDI7(value);
		halt.setDI7(value);
		load.setDI7(value);
		store.setDI7(value);
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

		add.setDI5(ci5Bar.getOutput());
		add.step();

		halt.step();

		load.setDI4(ci4Bar.getOutput());
		load.step();

		store.setDI0(ci0Bar.getOutput());
		store.setDI4(ci4Bar.getOutput());
		store.step();
	}

}

/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Processor;

import electroMechanicalLogic.Inverter;
import electroMechanicalLogic.Gates.EightInputAND;
import electroMechanicalLogic.Gates.EightInputNOR;
import electroMechanicalLogic.Gates.Interfaces.IEightInputSingleOutputGate;
import electroMechanicalLogic.Interfaces.IRelay;
import electroMechanicalMachine.Processor.Interfaces.IInstructionDecoder;

public class BasicInstructionDecoder implements IInstructionDecoder {
	protected final IRelay c0Bar = new Inverter();
	protected final IRelay c1Bar = new Inverter();
	protected final IRelay c4Bar = new Inverter();
	protected final IRelay c5Bar = new Inverter();
	private final IEightInputSingleOutputGate halt = new EightInputAND();
	private final IEightInputSingleOutputGate load = new EightInputNOR();
	private final IEightInputSingleOutputGate store = new EightInputNOR();
	private final IEightInputSingleOutputGate add = new EightInputNOR();
	private final IEightInputSingleOutputGate subtract = new EightInputNOR();
	private final IEightInputSingleOutputGate addWithCarry = new EightInputNOR();
	private final IEightInputSingleOutputGate subtractWithBorrow = new EightInputNOR();

	@Override
	public boolean getAdd() {
		return add.getOutput();
	}

	@Override
	public boolean getAddWithCarry() {
		return addWithCarry.getOutput();
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
	public boolean getSubtract() {
		return subtract.getOutput();
	}

	@Override
	public boolean getSubtractWithBorrow() {
		return subtractWithBorrow.getOutput();
	}

	@Override
	public void setC0(final boolean value) {
		c0Bar.setInput(value);
		halt.setDI0(value);
		load.setDI0(value);
		add.setDI0(value);
		addWithCarry.setDI0(value);
	}

	@Override
	public void setC1(final boolean value) {
		c1Bar.setInput(value);
		halt.setDI1(value);
		load.setDI1(value);
		store.setDI1(value);
		add.setDI1(value);
		subtract.setDI1(value);
	}

	@Override
	public void setC2(final boolean value) {
		halt.setDI2(value);
		load.setDI2(value);
		store.setDI2(value);
		add.setDI2(value);
		subtract.setDI2(value);
		addWithCarry.setDI2(value);
		subtractWithBorrow.setDI2(value);
	}

	@Override
	public void setC3(final boolean value) {
		halt.setDI3(value);
		load.setDI3(value);
		store.setDI3(value);
		add.setDI3(value);
		subtract.setDI3(value);
		addWithCarry.setDI3(value);
		subtractWithBorrow.setDI3(value);
	}

	@Override
	public void setC4(final boolean value) {
		c4Bar.setInput(value);
		halt.setDI4(value);
		add.setDI4(value);
		subtract.setDI4(value);
		addWithCarry.setDI4(value);
		subtractWithBorrow.setDI4(value);
	}

	@Override
	public void setC5(final boolean value) {
		halt.setDI5(value);
		load.setDI5(value);
		store.setDI5(value);
		c5Bar.setInput(value);
	}

	@Override
	public void setC6(final boolean value) {
		halt.setDI6(value);
		load.setDI6(value);
		store.setDI6(value);
		add.setDI6(value);
		subtract.setDI6(value);
		addWithCarry.setDI6(value);
		subtractWithBorrow.setDI6(value);
	}

	@Override
	public void setC7(final boolean value) {
		halt.setDI7(value);
		load.setDI7(value);
		store.setDI7(value);
		add.setDI7(value);
		subtract.setDI7(value);
		addWithCarry.setDI7(value);
		subtractWithBorrow.setDI7(value);
	}

	@Override
	public void setPower(final boolean value) {
		c0Bar.setPower(value);
		c1Bar.setPower(value);
		c4Bar.setPower(value);
		c5Bar.setPower(value);
		halt.setPower(value);
		load.setPower(value);
		store.setPower(value);
		add.setPower(value);
		subtract.setPower(value);
		addWithCarry.setPower(value);
		subtractWithBorrow.setPower(value);
	}

	@Override
	public void step() {
		c0Bar.step();
		c1Bar.step();
		c4Bar.step();
		c5Bar.step();

		halt.step();

		load.setDI4(c4Bar.getOutput());
		load.step();

		store.setDI0(c0Bar.getOutput());
		store.setDI4(c4Bar.getOutput());
		store.step();

		add.setDI5(c5Bar.getOutput());
		add.step();

		subtract.setDI0(c0Bar.getOutput());
		subtract.setDI5(c5Bar.getOutput());
		subtract.step();

		addWithCarry.setDI1(c1Bar.getOutput());
		addWithCarry.setDI5(c5Bar.getOutput());
		addWithCarry.step();

		subtractWithBorrow.setDI0(c0Bar.getOutput());
		subtractWithBorrow.setDI1(c1Bar.getOutput());
		subtractWithBorrow.setDI5(c5Bar.getOutput());
		subtractWithBorrow.step();
	}

}

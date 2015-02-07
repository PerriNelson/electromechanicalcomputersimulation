/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Processor;

import electroMechanicalLogic.Gates.Interfaces.ITwoInputSingleOutputGate;
import electroMechanicalMachine.Processor.Interfaces.ILogicalOperation;

public abstract class LogicalOperation implements ILogicalOperation {
	protected ITwoInputSingleOutputGate bit0;
	protected ITwoInputSingleOutputGate bit1;
	protected ITwoInputSingleOutputGate bit2;
	protected ITwoInputSingleOutputGate bit3;
	protected ITwoInputSingleOutputGate bit4;
	protected ITwoInputSingleOutputGate bit5;
	protected ITwoInputSingleOutputGate bit6;
	protected ITwoInputSingleOutputGate bit7;

	@Override
	public boolean getDO0() {
		return bit0.getOutput();
	}

	@Override
	public boolean getDO1() {
		return bit1.getOutput();
	}

	@Override
	public boolean getDO2() {
		return bit2.getOutput();
	}

	@Override
	public boolean getDO3() {
		return bit3.getOutput();
	}

	@Override
	public boolean getDO4() {
		return bit4.getOutput();
	}

	@Override
	public boolean getDO5() {
		return bit5.getOutput();
	}

	@Override
	public boolean getDO6() {
		return bit6.getOutput();
	}

	@Override
	public boolean getDO7() {
		return bit7.getOutput();
	}

	@Override
	public void setA0(final boolean value) {
		bit0.setA(value);
	}

	@Override
	public void setA1(final boolean value) {
		bit1.setA(value);
	}

	@Override
	public void setA2(final boolean value) {
		bit2.setA(value);
	}

	@Override
	public void setA3(final boolean value) {
		bit3.setA(value);
	}

	@Override
	public void setA4(final boolean value) {
		bit4.setA(value);
	}

	@Override
	public void setA5(final boolean value) {
		bit5.setA(value);
	}

	@Override
	public void setA6(final boolean value) {
		bit6.setA(value);
	}

	@Override
	public void setA7(final boolean value) {
		bit7.setA(value);
	}

	@Override
	public void setB0(final boolean value) {
		bit0.setB(value);
	}

	@Override
	public void setB1(final boolean value) {
		bit1.setB(value);
	}

	@Override
	public void setB2(final boolean value) {
		bit2.setB(value);
	}

	@Override
	public void setB3(final boolean value) {
		bit3.setB(value);
	}

	@Override
	public void setB4(final boolean value) {
		bit4.setB(value);
	}

	@Override
	public void setB5(final boolean value) {
		bit5.setB(value);
	}

	@Override
	public void setB6(final boolean value) {
		bit6.setB(value);
	}

	@Override
	public void setB7(final boolean value) {
		bit7.setB(value);
	}

	@Override
	public void setPower(final boolean value) {
		bit0.setPower(value);
		bit1.setPower(value);
		bit2.setPower(value);
		bit3.setPower(value);
		bit4.setPower(value);
		bit5.setPower(value);
		bit6.setPower(value);
		bit7.setPower(value);
	}

	@Override
	public void step() {
		bit0.step();
		bit1.step();
		bit2.step();
		bit3.step();
		bit4.step();
		bit5.step();
		bit6.step();
		bit7.step();
	}

}
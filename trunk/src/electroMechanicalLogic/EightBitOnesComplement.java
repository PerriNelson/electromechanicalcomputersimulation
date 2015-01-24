/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic;

import electroMechanicalLogic.Interfaces.IEightBitOnesComplement;
import electroMechanicalLogic.Interfaces.ITwoInputSingleOutputGate;

public class EightBitOnesComplement implements IEightBitOnesComplement {

	private final ITwoInputSingleOutputGate bit0 = new TwoInputXOrGate();
	private final ITwoInputSingleOutputGate bit1 = new TwoInputXOrGate();
	private final ITwoInputSingleOutputGate bit2 = new TwoInputXOrGate();
	private final ITwoInputSingleOutputGate bit3 = new TwoInputXOrGate();
	private final ITwoInputSingleOutputGate bit4 = new TwoInputXOrGate();
	private final ITwoInputSingleOutputGate bit5 = new TwoInputXOrGate();
	private final ITwoInputSingleOutputGate bit6 = new TwoInputXOrGate();
	private final ITwoInputSingleOutputGate bit7 = new TwoInputXOrGate();

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
	public void setDI0(final boolean value) {
		bit0.setA(value);
	}

	@Override
	public void setDI1(final boolean value) {
		bit1.setA(value);
	}

	@Override
	public void setDI2(final boolean value) {
		bit2.setA(value);
	}

	@Override
	public void setDI3(final boolean value) {
		bit3.setA(value);
	}

	@Override
	public void setDI4(final boolean value) {
		bit4.setA(value);
	}

	@Override
	public void setDI5(final boolean value) {
		bit5.setA(value);
	}

	@Override
	public void setDI6(final boolean value) {
		bit6.setA(value);
	}

	@Override
	public void setDI7(final boolean value) {
		bit7.setA(value);
	}

	@Override
	public void setInvert(final boolean value) {
		bit0.setB(value);
		bit1.setB(value);
		bit2.setB(value);
		bit3.setB(value);
		bit4.setB(value);
		bit5.setB(value);
		bit6.setB(value);
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

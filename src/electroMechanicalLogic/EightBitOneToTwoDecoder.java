/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic;

import electroMechanicalLogic.Interfaces.IEightBitOneToTwoDecoder;
import electroMechanicalLogic.Interfaces.IOneLineToTwoLineDecoder;

public class EightBitOneToTwoDecoder implements IEightBitOneToTwoDecoder {
	private final IOneLineToTwoLineDecoder bit0 = new OneLineToTwoLineDecoder();
	private final IOneLineToTwoLineDecoder bit1 = new OneLineToTwoLineDecoder();
	private final IOneLineToTwoLineDecoder bit2 = new OneLineToTwoLineDecoder();
	private final IOneLineToTwoLineDecoder bit3 = new OneLineToTwoLineDecoder();
	private final IOneLineToTwoLineDecoder bit4 = new OneLineToTwoLineDecoder();
	private final IOneLineToTwoLineDecoder bit5 = new OneLineToTwoLineDecoder();
	private final IOneLineToTwoLineDecoder bit6 = new OneLineToTwoLineDecoder();
	private final IOneLineToTwoLineDecoder bit7 = new OneLineToTwoLineDecoder();

	@Override
	public boolean getA0() {
		return bit0.getA();
	}

	@Override
	public boolean getA1() {
		return bit1.getA();
	}

	@Override
	public boolean getA2() {
		return bit2.getA();
	}

	@Override
	public boolean getA3() {
		return bit3.getA();
	}

	@Override
	public boolean getA4() {
		return bit4.getA();
	}

	@Override
	public boolean getA5() {
		return bit5.getA();
	}

	@Override
	public boolean getA6() {
		return bit6.getA();
	}

	@Override
	public boolean getA7() {
		return bit7.getA();
	}

	@Override
	public boolean getB0() {
		return bit0.getB();
	}

	@Override
	public boolean getB1() {
		return bit1.getB();
	}

	@Override
	public boolean getB2() {
		return bit2.getB();
	}

	@Override
	public boolean getB3() {
		return bit3.getB();
	}

	@Override
	public boolean getB4() {
		return bit4.getB();
	}

	@Override
	public boolean getB5() {
		return bit5.getB();
	}

	@Override
	public boolean getB6() {
		return bit6.getB();
	}

	@Override
	public boolean getB7() {
		return bit7.getB();
	}

	@Override
	public void setDI0(final boolean value) {
		bit0.setInput(value);
	}

	@Override
	public void setDI1(final boolean value) {
		bit1.setInput(value);
	}

	@Override
	public void setDI2(final boolean value) {
		bit2.setInput(value);
	}

	@Override
	public void setDI3(final boolean value) {
		bit3.setInput(value);
	}

	@Override
	public void setDI4(final boolean value) {
		bit4.setInput(value);
	}

	@Override
	public void setDI5(final boolean value) {
		bit5.setInput(value);
	}

	@Override
	public void setDI6(final boolean value) {
		bit6.setInput(value);
	}

	@Override
	public void setDI7(final boolean value) {
		bit7.setInput(value);
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
	public void setSelect(final boolean value) {
		bit0.setSelect(value);
		bit1.setSelect(value);
		bit2.setSelect(value);
		bit3.setSelect(value);
		bit4.setSelect(value);
		bit5.setSelect(value);
		bit6.setSelect(value);
		bit7.setSelect(value);
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

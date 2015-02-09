/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.Selectors;

import electroMechanicalLogic.Selectors.Interfaces.IEightBitFourToOneSelector;
import electroMechanicalLogic.Selectors.Interfaces.IFourToOneSelector;

/**
 * A circuit that "selects" between four eight bit wide inputs to produce one
 * eight bit wide output.
 */
public class EightBitFourToOneSelector implements IEightBitFourToOneSelector {
	private final IFourToOneSelector bit0 = new FourToOneSelector();
	private final IFourToOneSelector bit1 = new FourToOneSelector();
	private final IFourToOneSelector bit2 = new FourToOneSelector();
	private final IFourToOneSelector bit3 = new FourToOneSelector();
	private final IFourToOneSelector bit4 = new FourToOneSelector();
	private final IFourToOneSelector bit5 = new FourToOneSelector();
	private final IFourToOneSelector bit6 = new FourToOneSelector();
	private final IFourToOneSelector bit7 = new FourToOneSelector();

	@Override
	public boolean getDO0() {
		return bit0.getDO();
	}

	@Override
	public boolean getDO1() {
		return bit1.getDO();
	}

	@Override
	public boolean getDO2() {
		return bit2.getDO();
	}

	@Override
	public boolean getDO3() {
		return bit3.getDO();
	}

	@Override
	public boolean getDO4() {
		return bit4.getDO();
	}

	@Override
	public boolean getDO5() {
		return bit5.getDO();
	}

	@Override
	public boolean getDO6() {
		return bit6.getDO();
	}

	@Override
	public boolean getDO7() {
		return bit7.getDO();
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
	public void setC0(final boolean value) {
		bit0.setC(value);
	}

	@Override
	public void setC1(final boolean value) {
		bit1.setC(value);
	}

	@Override
	public void setC2(final boolean value) {
		bit2.setC(value);
	}

	@Override
	public void setC3(final boolean value) {
		bit3.setC(value);
	}

	@Override
	public void setC4(final boolean value) {
		bit4.setC(value);
	}

	@Override
	public void setC5(final boolean value) {
		bit5.setC(value);
	}

	@Override
	public void setC6(final boolean value) {
		bit6.setC(value);
	}

	@Override
	public void setC7(final boolean value) {
		bit7.setC(value);
	}

	@Override
	public void setD0(final boolean value) {
		bit0.setD(value);
	}

	@Override
	public void setD1(final boolean value) {
		bit1.setD(value);
	}

	@Override
	public void setD2(final boolean value) {
		bit2.setD(value);
	}

	@Override
	public void setD3(final boolean value) {
		bit3.setD(value);
	}

	@Override
	public void setD4(final boolean value) {
		bit4.setD(value);
	}

	@Override
	public void setD5(final boolean value) {
		bit5.setD(value);
	}

	@Override
	public void setD6(final boolean value) {
		bit6.setD(value);
	}

	@Override
	public void setD7(final boolean value) {
		bit7.setD(value);
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
	public void setS0(final boolean value) {
		bit0.setS0(value);
		bit1.setS0(value);
		bit2.setS0(value);
		bit3.setS0(value);
		bit4.setS0(value);
		bit5.setS0(value);
		bit6.setS0(value);
		bit7.setS0(value);
	}

	@Override
	public void setS1(final boolean value) {
		bit0.setS1(value);
		bit1.setS1(value);
		bit2.setS1(value);
		bit3.setS1(value);
		bit4.setS1(value);
		bit5.setS1(value);
		bit6.setS1(value);
		bit7.setS1(value);
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

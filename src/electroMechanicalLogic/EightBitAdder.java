/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic;

import electroMechanicalLogic.Interfaces.IEightBitAdder;
import electroMechanicalLogic.Interfaces.IFullAdder;

/**
 * An eight bit adder accepts two eight bit inputs and a carry input bit and
 * produces an eight bit sum with a carry output bit.
 */
public final class EightBitAdder implements IEightBitAdder {
	private final IFullAdder adder0 = new FullAdder();
	private final IFullAdder adder1 = new FullAdder();
	private final IFullAdder adder2 = new FullAdder();
	private final IFullAdder adder3 = new FullAdder();
	private final IFullAdder adder4 = new FullAdder();
	private final IFullAdder adder5 = new FullAdder();
	private final IFullAdder adder6 = new FullAdder();
	private final IFullAdder adder7 = new FullAdder();

	@Override
	public boolean getCO() {
		return adder7.getCO();
	}

	@Override
	public boolean getS0() {
		return adder0.getS();
	}

	@Override
	public boolean getS1() {
		return adder1.getS();
	}

	@Override
	public boolean getS2() {
		return adder2.getS();
	}

	@Override
	public boolean getS3() {
		return adder3.getS();
	}

	@Override
	public boolean getS4() {
		return adder4.getS();
	}

	@Override
	public boolean getS5() {
		return adder5.getS();
	}

	@Override
	public boolean getS6() {
		return adder6.getS();
	}

	@Override
	public boolean getS7() {
		return adder7.getS();
	}

	@Override
	public void setA0(final boolean value) {
		adder0.setA(value);
	}

	@Override
	public void setA1(final boolean value) {
		adder1.setA(value);
	}

	@Override
	public void setA2(final boolean value) {
		adder2.setA(value);
	}

	@Override
	public void setA3(final boolean value) {
		adder3.setA(value);
	}

	@Override
	public void setA4(final boolean value) {
		adder4.setA(value);
	}

	@Override
	public void setA5(final boolean value) {
		adder5.setA(value);
	}

	@Override
	public void setA6(final boolean value) {
		adder6.setA(value);
	}

	@Override
	public void setA7(final boolean value) {
		adder7.setA(value);
	}

	@Override
	public void setB0(final boolean value) {
		adder0.setB(value);
	}

	@Override
	public void setB1(final boolean value) {
		adder1.setB(value);
	}

	@Override
	public void setB2(final boolean value) {
		adder2.setB(value);
	}

	@Override
	public void setB3(final boolean value) {
		adder3.setB(value);
	}

	@Override
	public void setB4(final boolean value) {
		adder4.setB(value);
	}

	@Override
	public void setB5(final boolean value) {
		adder5.setB(value);
	}

	@Override
	public void setB6(final boolean value) {
		adder6.setB(value);
	}

	@Override
	public void setB7(final boolean value) {
		adder7.setB(value);
	}

	@Override
	public void setCI(final boolean value) {
		adder0.setCI(value);
	}

	@Override
	public void setPower(final boolean value) {
		adder0.setPower(value);
		adder1.setPower(value);
		adder2.setPower(value);
		adder3.setPower(value);
		adder4.setPower(value);
		adder5.setPower(value);
		adder6.setPower(value);
		adder7.setPower(value);
	}

	@Override
	public void step() {
		adder0.step();

		adder1.setCI(adder0.getCO());
		adder1.step();

		adder2.setCI(adder1.getCO());
		adder2.step();

		adder3.setCI(adder2.getCO());
		adder3.step();

		adder4.setCI(adder3.getCO());
		adder4.step();

		adder5.setCI(adder4.getCO());
		adder5.step();

		adder6.setCI(adder5.getCO());
		adder6.step();

		adder7.setCI(adder6.getCO());
		adder7.step();
	}
}

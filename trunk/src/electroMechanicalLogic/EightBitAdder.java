/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic;

public final class EightBitAdder implements IEightBitAdder {
	private final FullAdder adder0;
	private final FullAdder adder1;
	private final FullAdder adder2;
	private final FullAdder adder3;
	private final FullAdder adder4;
	private final FullAdder adder5;
	private final FullAdder adder6;
	private final FullAdder adder7;

	public EightBitAdder() {
		adder0 = new FullAdder();
		adder1 = new FullAdder();
		adder2 = new FullAdder();
		adder3 = new FullAdder();
		adder4 = new FullAdder();
		adder5 = new FullAdder();
		adder6 = new FullAdder();
		adder7 = new FullAdder();
	}

	@Override
	public boolean getCO() {
		return adder7.getCO();
	}

	@Override
	public boolean getPower() {
		return adder0.getPower();
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
	public void setA0(boolean value) {
		adder0.setA(value);
	}

	@Override
	public void setA1(boolean value) {
		adder1.setA(value);
	}

	@Override
	public void setA2(boolean value) {
		adder2.setA(value);
	}

	@Override
	public void setA3(boolean value) {
		adder3.setA(value);
	}

	@Override
	public void setA4(boolean value) {
		adder4.setA(value);
	}

	@Override
	public void setA5(boolean value) {
		adder5.setA(value);
	}

	@Override
	public void setA6(boolean value) {
		adder6.setA(value);
	}

	@Override
	public void setA7(boolean value) {
		adder7.setA(value);
	}

	@Override
	public void setB0(boolean value) {
		adder0.setB(value);
	}

	@Override
	public void setB1(boolean value) {
		adder1.setB(value);
	}

	@Override
	public void setB2(boolean value) {
		adder2.setB(value);
	}

	@Override
	public void setB3(boolean value) {
		adder3.setB(value);
	}

	@Override
	public void setB4(boolean value) {
		adder4.setB(value);
	}

	@Override
	public void setB5(boolean value) {
		adder5.setB(value);
	}

	@Override
	public void setB6(boolean value) {
		adder6.setB(value);
	}

	@Override
	public void setB7(boolean value) {
		adder7.setB(value);
	}

	@Override
	public void setCI(boolean value) {
		adder0.setCI(value);
	}

	@Override
	public void setPower(boolean value) {
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

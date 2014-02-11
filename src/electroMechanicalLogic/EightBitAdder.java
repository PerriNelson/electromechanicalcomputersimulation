/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic;

public final class EightBitAdder implements IEightBitAdder {
	private FullAdder adder0 = new FullAdder();
	private FullAdder adder1 = new FullAdder();
	private FullAdder adder2 = new FullAdder();
	private FullAdder adder3 = new FullAdder();
	private FullAdder adder4 = new FullAdder();
	private FullAdder adder5 = new FullAdder();
	private FullAdder adder6 = new FullAdder();
	private FullAdder adder7 = new FullAdder();

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

	public boolean getPower() {
		return adder0.getPower();
	}

	public void setCI(boolean value) {
		adder0.setCI(value);
	}

	public boolean getCO() {
		return adder7.getCO();
	}

	public void setA0(boolean value) {
		adder0.setA(value);
	}

	public void setA1(boolean value) {
		adder1.setA(value);
	}

	public void setA2(boolean value) {
		adder2.setA(value);
	}

	public void setA3(boolean value) {
		adder3.setA(value);
	}

	public void setA4(boolean value) {
		adder4.setA(value);
	}

	public void setA5(boolean value) {
		adder5.setA(value);
	}

	public void setA6(boolean value) {
		adder6.setA(value);
	}

	public void setA7(boolean value) {
		adder7.setA(value);
	}

	public void setB0(boolean value) {
		adder0.setB(value);
	}

	public void setB1(boolean value) {
		adder1.setB(value);
	}

	public void setB2(boolean value) {
		adder2.setB(value);
	}

	public void setB3(boolean value) {
		adder3.setB(value);
	}

	public void setB4(boolean value) {
		adder4.setB(value);
	}

	public void setB5(boolean value) {
		adder5.setB(value);
	}

	public void setB6(boolean value) {
		adder6.setB(value);
	}

	public void setB7(boolean value) {
		adder7.setB(value);
	}

	public boolean getS0() {
		return adder0.getS();
	}

	public boolean getS1() {
		return adder1.getS();
	}

	public boolean getS2() {
		return adder2.getS();
	}

	public boolean getS3() {
		return adder3.getS();
	}

	public boolean getS4() {
		return adder4.getS();
	}

	public boolean getS5() {
		return adder5.getS();
	}

	public boolean getS6() {
		return adder6.getS();
	}

	public boolean getS7() {
		return adder7.getS();
	}

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

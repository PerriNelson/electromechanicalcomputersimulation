/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */
package electroMechanicalLogic;

public final class FullAdder {

	private HalfAdder bottomHalf = new HalfAdder();
	private HalfAdder topHalf = new HalfAdder();
	private ITwoInputSingleOutputGate or = new TwoInputOrGate();
	
	public boolean getA() {
		return topHalf.getA();
	}
	
	public boolean getB() {
		return topHalf.getB();
	}
	
	public boolean getCO() {
		return or.getOutput();
	}
	
	public boolean getS() {
		return bottomHalf.getS();
	}
	
	public boolean getPower() {
		return bottomHalf.getPower();
	}
	
	public void setA(boolean value) {
		topHalf.setA(value);
	}

	public void setB(boolean value) {
		topHalf.setB(value);
	}
	
	public void setCI(boolean value) {
		bottomHalf.setA(value);
	}
	
	public void setPower(boolean value) {
		bottomHalf.setPower(value);
		topHalf.setPower(value);
		or.setPower(value);
	}
	
	public void step() {
		topHalf.step();
		bottomHalf.setB(topHalf.getS());
		bottomHalf.step();
		or.setA(bottomHalf.getCO());
		or.setB(topHalf.getCO());
		or.step();
	}
}
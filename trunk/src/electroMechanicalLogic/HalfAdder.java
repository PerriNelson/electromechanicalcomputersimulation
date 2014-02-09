/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */
package electroMechanicalLogic;

public final class HalfAdder {

	private ITwoInputSingleOutputGate xor = new TwoInputXOrGate();
	private ITwoInputSingleOutputGate and = new TwoInputAndGate();
	
	public boolean getA() {
		return xor.getA();
	}
	
	public boolean getB() {
		return xor.getB();
	}
	
	public boolean getCO() {
		return and.getOutput();
	}
	
	public boolean getS() {
		return xor.getOutput();
	}
	
	public boolean getPower() {
		return xor.getPower();
	}
	
	public void setA(boolean value) {
		xor.setA(value);
		and.setA(value);
	}

	public void setB(boolean value) {
		xor.setB(value);
		and.setB(value);
	}
	
	public void setPower(boolean value) {
		xor.setPower(value);
		and.setPower(value);
	}
	
	public void step() {
		xor.step();
		and.step();
	}
}

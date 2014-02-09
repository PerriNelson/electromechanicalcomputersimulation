/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */
package electroMechanicalLogic;

public final class TwoInputXOrGate implements ITwoInputSingleOutputGate {

	private ITwoInputSingleOutputGate nAnd = new TwoInputNAndGate();
	private ITwoInputSingleOutputGate or = new TwoInputOrGate();
	private ITwoInputSingleOutputGate and = new TwoInputAndGate();

	public boolean getA() {
		return nAnd.getA();
	}

	public boolean getB() {
		return nAnd.getB();
	}

	public boolean getOutput() {
		return and.getOutput();
	}

	public boolean getPower() {
		return nAnd.getPower();
	}

	public void setA(boolean value) {
		nAnd.setA(value);
		or.setA(value);
	}

	public void setB(boolean value) {
		nAnd.setB(value);
		or.setB(value);
	}

	public void setPower(boolean value) {
		nAnd.setPower(value);
		or.setPower(value);
		and.setPower(value);
	}

	public void step() {
		nAnd.step();
		or.step();
		and.setA(nAnd.getOutput());
		and.setB(or.getOutput());
		and.step();
	}

}
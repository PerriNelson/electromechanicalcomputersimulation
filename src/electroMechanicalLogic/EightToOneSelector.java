/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic;

import electroMechanicalLogic.Interfaces.IEightInputSingleOutputGate;
import electroMechanicalLogic.Interfaces.IEightToOneSelector;
import electroMechanicalLogic.Interfaces.IFourInputSingleOutputGate;
import electroMechanicalLogic.Interfaces.IRelay;

public final class EightToOneSelector implements IEightToOneSelector {

	private IEightInputSingleOutputGate or = new EightInputSingleOutputOrGate();
	private IFourInputSingleOutputGate and0 = new FourInputSingleOutputAndGate();
	private IFourInputSingleOutputGate and1 = new FourInputSingleOutputAndGate();
	private IFourInputSingleOutputGate and2 = new FourInputSingleOutputAndGate();
	private IFourInputSingleOutputGate and3 = new FourInputSingleOutputAndGate();
	private IFourInputSingleOutputGate and4 = new FourInputSingleOutputAndGate();
	private IFourInputSingleOutputGate and5 = new FourInputSingleOutputAndGate();
	private IFourInputSingleOutputGate and6 = new FourInputSingleOutputAndGate();
	private IFourInputSingleOutputGate and7 = new FourInputSingleOutputAndGate();
	private IRelay inverter0 = new Inverter();
	private IRelay inverter1 = new Inverter();
	private IRelay inverter2 = new Inverter();

	@Override
	public boolean getOutput() {
		return or.getOutput();
	}

	@Override
	public void setD0(boolean value) {
		and0.setD(value);
	}

	@Override
	public void setD1(boolean value) {
		and1.setD(value);
	}

	@Override
	public void setD2(boolean value) {
		and2.setD(value);
	}

	@Override
	public void setD3(boolean value) {
		and3.setD(value);
	}

	@Override
	public void setD4(boolean value) {
		and4.setD(value);
	}

	@Override
	public void setD5(boolean value) {
		and5.setD(value);
	}

	@Override
	public void setD6(boolean value) {
		and6.setD(value);
	}

	@Override
	public void setD7(boolean value) {
		and7.setD(value);
	}

	@Override
	public void setPower(boolean value) {
		or.setPower(value);
		and0.setPower(value);
		and1.setPower(value);
		and2.setPower(value);
		and3.setPower(value);
		and4.setPower(value);
		and5.setPower(value);
		and6.setPower(value);
		and7.setPower(value);
		inverter0.setPower(value);
		inverter1.setPower(value);
		inverter2.setPower(value);
	}

	@Override
	public void setS0(boolean value) {
		and1.setC(value);
		and3.setC(value);
		and5.setC(value);
		and7.setC(value);
		inverter0.setInput(value);
	}

	@Override
	public void setS1(boolean value) {
		and2.setC(value);
		and3.setB(value);
		and6.setC(value);
		and7.setB(value);
		inverter1.setInput(value);
	}

	@Override
	public void setS2(boolean value) {
		and4.setC(value);
		and5.setB(value);
		and6.setB(value);
		and7.setA(value);
		inverter2.setInput(value);
	}

	@Override
	public void step() {
		inverter0.step();
		inverter1.step();
		inverter2.step();

		boolean s0Bar = inverter0.getOutput();
		boolean s1Bar = inverter1.getOutput();
		boolean s2Bar = inverter2.getOutput();

		and0.setA(s2Bar);
		and0.setB(s1Bar);
		and0.setC(s0Bar);

		and1.setA(s2Bar);
		and1.setB(s1Bar);

		and2.setA(s2Bar);
		and2.setB(s0Bar);

		and3.setA(s2Bar);

		and4.setA(s1Bar);
		and4.setB(s0Bar);

		and5.setA(s1Bar);

		and6.setA(s0Bar);

		and0.step();
		and1.step();
		and2.step();
		and3.step();
		and4.step();
		and5.step();
		and6.step();
		and7.step();

		or.setI0(and0.getOutput());
		or.setI1(and1.getOutput());
		or.setI2(and2.getOutput());
		or.setI3(and3.getOutput());
		or.setI4(and4.getOutput());
		or.setI5(and5.getOutput());
		or.setI6(and6.getOutput());
		or.setI7(and7.getOutput());

		or.step();
	}

}

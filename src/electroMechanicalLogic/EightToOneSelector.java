/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic;

import electroMechanicalLogic.Gates.EightInputOR;
import electroMechanicalLogic.Gates.FourInputAND;
import electroMechanicalLogic.Gates.Interfaces.IEightInputSingleOutputGate;
import electroMechanicalLogic.Gates.Interfaces.IFourInputSingleOutputGate;
import electroMechanicalLogic.Interfaces.IEightToOneSelector;
import electroMechanicalLogic.Interfaces.IRelay;

public final class EightToOneSelector implements IEightToOneSelector {

	private final IEightInputSingleOutputGate or = new EightInputOR();
	private final IFourInputSingleOutputGate and0 = new FourInputAND();
	private final IFourInputSingleOutputGate and1 = new FourInputAND();
	private final IFourInputSingleOutputGate and2 = new FourInputAND();
	private final IFourInputSingleOutputGate and3 = new FourInputAND();
	private final IFourInputSingleOutputGate and4 = new FourInputAND();
	private final IFourInputSingleOutputGate and5 = new FourInputAND();
	private final IFourInputSingleOutputGate and6 = new FourInputAND();
	private final IFourInputSingleOutputGate and7 = new FourInputAND();
	private final IRelay inverter0 = new Inverter();
	private final IRelay inverter1 = new Inverter();
	private final IRelay inverter2 = new Inverter();

	@Override
	public boolean getOutput() {
		return or.getOutput();
	}

	@Override
	public void setDI0(final boolean value) {
		and0.setD(value);
	}

	@Override
	public void setDI1(final boolean value) {
		and1.setD(value);
	}

	@Override
	public void setDI2(final boolean value) {
		and2.setD(value);
	}

	@Override
	public void setDI3(final boolean value) {
		and3.setD(value);
	}

	@Override
	public void setDI4(final boolean value) {
		and4.setD(value);
	}

	@Override
	public void setDI5(final boolean value) {
		and5.setD(value);
	}

	@Override
	public void setDI6(final boolean value) {
		and6.setD(value);
	}

	@Override
	public void setDI7(final boolean value) {
		and7.setD(value);
	}

	@Override
	public void setPower(final boolean value) {
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
	public void setS0(final boolean value) {
		and1.setC(value);
		and3.setC(value);
		and5.setC(value);
		and7.setC(value);
		inverter0.setInput(value);
	}

	@Override
	public void setS1(final boolean value) {
		and2.setC(value);
		and3.setB(value);
		and6.setC(value);
		and7.setB(value);
		inverter1.setInput(value);
	}

	@Override
	public void setS2(final boolean value) {
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

		final boolean s0Bar = inverter0.getOutput();
		final boolean s1Bar = inverter1.getOutput();
		final boolean s2Bar = inverter2.getOutput();

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

		or.setDI0(and0.getOutput());
		or.setDI1(and1.getOutput());
		or.setDI2(and2.getOutput());
		or.setDI3(and3.getOutput());
		or.setDI4(and4.getOutput());
		or.setDI5(and5.getOutput());
		or.setDI6(and6.getOutput());
		or.setDI7(and7.getOutput());

		or.step();
	}

}

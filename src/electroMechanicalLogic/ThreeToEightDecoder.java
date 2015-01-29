/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic;

import electroMechanicalLogic.Gates.FourInputAND;
import electroMechanicalLogic.Gates.Interfaces.IFourInputSingleOutputGate;
import electroMechanicalLogic.Interfaces.IRelay;
import electroMechanicalLogic.Interfaces.IThreeToEightDecoder;

public final class ThreeToEightDecoder implements IThreeToEightDecoder {

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
	public boolean getO0() {
		return and0.getOutput();
	}

	@Override
	public boolean getO1() {
		return and1.getOutput();
	}

	@Override
	public boolean getO2() {
		return and2.getOutput();
	}

	@Override
	public boolean getO3() {
		return and3.getOutput();
	}

	@Override
	public boolean getO4() {
		return and4.getOutput();
	}

	@Override
	public boolean getO5() {
		return and5.getOutput();
	}

	@Override
	public boolean getO6() {
		return and6.getOutput();
	}

	@Override
	public boolean getO7() {
		return and7.getOutput();
	}

	@Override
	public void setData(final boolean value) {
		and0.setD(value);
		and1.setD(value);
		and2.setD(value);
		and3.setD(value);
		and4.setD(value);
		and5.setD(value);
		and6.setD(value);
		and7.setD(value);
	}

	@Override
	public void setPower(final boolean value) {
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
		inverter0.setInput(value);
		and1.setC(value);
		and3.setC(value);
		and5.setC(value);
		and7.setC(value);
	}

	@Override
	public void setS1(final boolean value) {
		inverter1.setInput(value);
		and2.setC(value);
		and3.setB(value);
		and6.setC(value);
		and7.setB(value);
	}

	@Override
	public void setS2(final boolean value) {
		inverter2.setInput(value);
		and4.setC(value);
		and5.setB(value);
		and6.setB(value);
		and7.setA(value);
	}

	@Override
	public void step() {
		inverter0.step();
		inverter1.step();
		inverter2.step();

		final boolean s0bar = inverter0.getOutput();
		final boolean s1bar = inverter1.getOutput();
		final boolean s2bar = inverter2.getOutput();

		and0.setC(s0bar);
		and0.setB(s1bar);
		and0.setA(s2bar);

		and1.setB(s1bar);
		and1.setA(s2bar);

		and2.setB(s0bar);
		and2.setA(s2bar);

		and3.setA(s2bar);

		and4.setB(s0bar);
		and4.setA(s1bar);

		and5.setA(s1bar);

		and6.setA(s0bar);

		and0.step();
		and1.step();
		and2.step();
		and3.step();
		and4.step();
		and5.step();
		and6.step();
		and7.step();
	}
}

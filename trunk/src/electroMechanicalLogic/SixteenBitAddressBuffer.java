/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic;

import electroMechanicalLogic.Interfaces.IRelay;
import electroMechanicalLogic.Interfaces.ISixteenBitAddressBuffer;

public class SixteenBitAddressBuffer implements ISixteenBitAddressBuffer {
	private final IRelay A0 = new Buffer();
	private final IRelay A1 = new Buffer();
	private final IRelay A2 = new Buffer();
	private final IRelay A3 = new Buffer();
	private final IRelay A4 = new Buffer();
	private final IRelay A5 = new Buffer();
	private final IRelay A6 = new Buffer();
	private final IRelay A7 = new Buffer();
	private final IRelay A8 = new Buffer();
	private final IRelay A9 = new Buffer();
	private final IRelay AA = new Buffer();
	private final IRelay AB = new Buffer();
	private final IRelay AC = new Buffer();
	private final IRelay AD = new Buffer();
	private final IRelay AE = new Buffer();
	private final IRelay AF = new Buffer();

	@Override
	public boolean getA0() {
		return A0.getOutput();
	}

	@Override
	public boolean getA1() {
		return A1.getOutput();
	}

	@Override
	public boolean getA2() {
		return A2.getOutput();
	}

	@Override
	public boolean getA3() {
		return A3.getOutput();
	}

	@Override
	public boolean getA4() {
		return A4.getOutput();
	}

	@Override
	public boolean getA5() {
		return A5.getOutput();
	}

	@Override
	public boolean getA6() {
		return A6.getOutput();
	}

	@Override
	public boolean getA7() {
		return A7.getOutput();
	}

	@Override
	public boolean getA8() {
		return A8.getOutput();
	}

	@Override
	public boolean getA9() {
		return A9.getOutput();
	}

	@Override
	public boolean getAA() {
		return AA.getOutput();
	}

	@Override
	public boolean getAB() {
		return AB.getOutput();
	}

	@Override
	public boolean getAC() {
		return AC.getOutput();
	}

	@Override
	public boolean getAD() {
		return AD.getOutput();
	}

	@Override
	public boolean getAE() {
		return AE.getOutput();
	}

	@Override
	public boolean getAF() {
		return AF.getOutput();
	}

	@Override
	public void setA0(final boolean value) {
		A0.setInput(value);
	}

	@Override
	public void setA1(final boolean value) {
		A1.setInput(value);
	}

	@Override
	public void setA2(final boolean value) {
		A2.setInput(value);
	}

	@Override
	public void setA3(final boolean value) {
		A3.setInput(value);
	}

	@Override
	public void setA4(final boolean value) {
		A4.setInput(value);
	}

	@Override
	public void setA5(final boolean value) {
		A5.setInput(value);
	}

	@Override
	public void setA6(final boolean value) {
		A6.setInput(value);
	}

	@Override
	public void setA7(final boolean value) {
		A7.setInput(value);
	}

	@Override
	public void setA8(final boolean value) {
		A8.setInput(value);
	}

	@Override
	public void setA9(final boolean value) {
		A9.setInput(value);
	}

	@Override
	public void setAA(final boolean value) {
		AA.setInput(value);
	}

	@Override
	public void setAB(final boolean value) {
		AB.setInput(value);
	}

	@Override
	public void setAC(final boolean value) {
		AC.setInput(value);
	}

	@Override
	public void setAD(final boolean value) {
		AD.setInput(value);
	}

	@Override
	public void setAE(final boolean value) {
		AE.setInput(value);
	}

	@Override
	public void setAF(final boolean value) {
		AF.setInput(value);
	}

	@Override
	public void setPower(final boolean value) {
		A0.setPower(value);
		A1.setPower(value);
		A2.setPower(value);
		A3.setPower(value);
		A4.setPower(value);
		A5.setPower(value);
		A6.setPower(value);
		A7.setPower(value);
		A8.setPower(value);
		A9.setPower(value);
		AA.setPower(value);
		AB.setPower(value);
		AC.setPower(value);
		AD.setPower(value);
		AE.setPower(value);
		AF.setPower(value);
	}

	@Override
	public void step() {
		A0.step();
		A1.step();
		A2.step();
		A3.step();
		A4.step();
		A5.step();
		A6.step();
		A7.step();
		A8.step();
		A9.step();
		AA.step();
		AB.step();
		AC.step();
		AD.step();
		AE.step();
		AF.step();
	}

}

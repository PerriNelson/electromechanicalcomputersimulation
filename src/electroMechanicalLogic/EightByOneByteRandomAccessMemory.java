/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic;

import electroMechanicalLogic.Interfaces.IEightBitLatch;
import electroMechanicalLogic.Interfaces.IEightByOneByteRandomAccessMemory;
import electroMechanicalLogic.Interfaces.IEightToOneSelector;
import electroMechanicalLogic.Interfaces.IThreeToEightDecoder;

public class EightByOneByteRandomAccessMemory implements
		IEightByOneByteRandomAccessMemory {

	private IThreeToEightDecoder w = new ThreeToEightDecoder();
	private IEightBitLatch byte0 = new EightBitLatch();
	private IEightBitLatch byte1 = new EightBitLatch();
	private IEightBitLatch byte2 = new EightBitLatch();
	private IEightBitLatch byte3 = new EightBitLatch();
	private IEightBitLatch byte4 = new EightBitLatch();
	private IEightBitLatch byte5 = new EightBitLatch();
	private IEightBitLatch byte6 = new EightBitLatch();
	private IEightBitLatch byte7 = new EightBitLatch();
	private IEightToOneSelector dO0 = new EightToOneSelector();
	private IEightToOneSelector dO1 = new EightToOneSelector();
	private IEightToOneSelector dO2 = new EightToOneSelector();
	private IEightToOneSelector dO3 = new EightToOneSelector();
	private IEightToOneSelector dO4 = new EightToOneSelector();
	private IEightToOneSelector dO5 = new EightToOneSelector();
	private IEightToOneSelector dO6 = new EightToOneSelector();
	private IEightToOneSelector dO7 = new EightToOneSelector();

	@Override
	public boolean getDO0() {
		return dO0.getOutput();
	}

	@Override
	public boolean getDO1() {
		return dO1.getOutput();
	}

	@Override
	public boolean getDO2() {
		return dO2.getOutput();
	}

	@Override
	public boolean getDO3() {
		return dO3.getOutput();
	}

	@Override
	public boolean getDO4() {
		return dO4.getOutput();
	}

	@Override
	public boolean getDO5() {
		return dO5.getOutput();
	}

	@Override
	public boolean getDO6() {
		return dO6.getOutput();

	}

	@Override
	public boolean getDO7() {
		return dO7.getOutput();
	}

	@Override
	public void setA0(boolean value) {
		w.setS0(value);
		dO0.setS0(value);
		dO1.setS0(value);
		dO2.setS0(value);
		dO3.setS0(value);
		dO4.setS0(value);
		dO5.setS0(value);
		dO6.setS0(value);
		dO7.setS0(value);
	}

	@Override
	public void setA1(boolean value) {
		w.setS1(value);
		dO0.setS1(value);
		dO1.setS1(value);
		dO2.setS1(value);
		dO3.setS1(value);
		dO4.setS1(value);
		dO5.setS1(value);
		dO6.setS1(value);
		dO7.setS1(value);
	}

	@Override
	public void setA2(boolean value) {
		w.setS2(value);
		dO0.setS2(value);
		dO1.setS2(value);
		dO2.setS2(value);
		dO3.setS2(value);
		dO4.setS2(value);
		dO5.setS2(value);
		dO6.setS2(value);
		dO7.setS2(value);
	}

	@Override
	public void setDI0(boolean value) {
		byte0.setDI0(value);
		byte1.setDI0(value);
		byte2.setDI0(value);
		byte3.setDI0(value);
		byte4.setDI0(value);
		byte5.setDI0(value);
		byte6.setDI0(value);
		byte7.setDI0(value);
	}

	@Override
	public void setDI1(boolean value) {
		byte0.setDI1(value);
		byte1.setDI1(value);
		byte2.setDI1(value);
		byte3.setDI1(value);
		byte4.setDI1(value);
		byte5.setDI1(value);
		byte6.setDI1(value);
		byte7.setDI1(value);
	}

	@Override
	public void setDI2(boolean value) {
		byte0.setDI2(value);
		byte1.setDI2(value);
		byte2.setDI2(value);
		byte3.setDI2(value);
		byte4.setDI2(value);
		byte5.setDI2(value);
		byte6.setDI2(value);
		byte7.setDI2(value);
	}

	@Override
	public void setDI3(boolean value) {
		byte0.setDI3(value);
		byte1.setDI3(value);
		byte2.setDI3(value);
		byte3.setDI3(value);
		byte4.setDI3(value);
		byte5.setDI3(value);
		byte6.setDI3(value);
		byte7.setDI3(value);
	}

	@Override
	public void setDI4(boolean value) {
		byte0.setDI4(value);
		byte1.setDI4(value);
		byte2.setDI4(value);
		byte3.setDI4(value);
		byte4.setDI4(value);
		byte5.setDI4(value);
		byte6.setDI4(value);
		byte7.setDI4(value);
	}

	@Override
	public void setDI5(boolean value) {
		byte0.setDI5(value);
		byte1.setDI5(value);
		byte2.setDI5(value);
		byte3.setDI5(value);
		byte4.setDI5(value);
		byte5.setDI5(value);
		byte6.setDI5(value);
		byte7.setDI5(value);
	}

	@Override
	public void setDI6(boolean value) {
		byte0.setDI6(value);
		byte1.setDI6(value);
		byte2.setDI6(value);
		byte3.setDI6(value);
		byte4.setDI6(value);
		byte5.setDI6(value);
		byte6.setDI6(value);
		byte7.setDI6(value);
	}

	@Override
	public void setDI7(boolean value) {
		byte0.setDI7(value);
		byte1.setDI7(value);
		byte2.setDI7(value);
		byte3.setDI7(value);
		byte4.setDI7(value);
		byte5.setDI7(value);
		byte6.setDI7(value);
		byte7.setDI7(value);
	}

	@Override
	public void setPower(boolean value) {
		w.setPower(value);
		byte0.setPower(value);
		byte1.setPower(value);
		byte2.setPower(value);
		byte3.setPower(value);
		byte4.setPower(value);
		byte5.setPower(value);
		byte6.setPower(value);
		byte7.setPower(value);
		dO0.setPower(value);
		dO1.setPower(value);
		dO2.setPower(value);
		dO3.setPower(value);
		dO4.setPower(value);
		dO5.setPower(value);
		dO6.setPower(value);
		dO7.setPower(value);
	}

	@Override
	public void setW(boolean value) {
		w.setData(value);
	}

	@Override
	public void step() {
		w.step();

		byte0.setW(w.getO0());
		byte0.step();

		byte1.setW(w.getO1());
		byte1.step();

		byte2.setW(w.getO2());
		byte2.step();

		byte3.setW(w.getO3());
		byte3.step();

		byte4.setW(w.getO4());
		byte4.step();

		byte5.setW(w.getO5());
		byte5.step();

		byte6.setW(w.getO6());
		byte6.step();

		byte7.setW(w.getO7());
		byte7.step();

		dO0.setD0(byte0.getDO0());
		dO0.setD1(byte1.getDO0());
		dO0.setD2(byte2.getDO0());
		dO0.setD3(byte3.getDO0());
		dO0.setD4(byte4.getDO0());
		dO0.setD5(byte5.getDO0());
		dO0.setD6(byte6.getDO0());
		dO0.setD7(byte7.getDO0());
		dO0.step();

		dO1.setD0(byte0.getDO1());
		dO1.setD1(byte1.getDO1());
		dO1.setD2(byte2.getDO1());
		dO1.setD3(byte3.getDO1());
		dO1.setD4(byte4.getDO1());
		dO1.setD5(byte5.getDO1());
		dO1.setD6(byte6.getDO1());
		dO1.setD7(byte7.getDO1());
		dO1.step();

		dO2.setD0(byte0.getDO2());
		dO2.setD1(byte1.getDO2());
		dO2.setD2(byte2.getDO2());
		dO2.setD3(byte3.getDO2());
		dO2.setD4(byte4.getDO2());
		dO2.setD5(byte5.getDO2());
		dO2.setD6(byte6.getDO2());
		dO2.setD7(byte7.getDO2());
		dO2.step();

		dO3.setD0(byte0.getDO3());
		dO3.setD1(byte1.getDO3());
		dO3.setD2(byte2.getDO3());
		dO3.setD3(byte3.getDO3());
		dO3.setD4(byte4.getDO3());
		dO3.setD5(byte5.getDO3());
		dO3.setD6(byte6.getDO3());
		dO3.setD7(byte7.getDO3());
		dO3.step();

		dO4.setD0(byte0.getDO4());
		dO4.setD1(byte1.getDO4());
		dO4.setD2(byte2.getDO4());
		dO4.setD3(byte3.getDO4());
		dO4.setD4(byte4.getDO4());
		dO4.setD5(byte5.getDO4());
		dO4.setD6(byte6.getDO4());
		dO4.setD7(byte7.getDO4());
		dO4.step();

		dO5.setD0(byte0.getDO5());
		dO5.setD1(byte1.getDO5());
		dO5.setD2(byte2.getDO5());
		dO5.setD3(byte3.getDO5());
		dO5.setD4(byte4.getDO5());
		dO5.setD5(byte5.getDO5());
		dO5.setD6(byte6.getDO5());
		dO5.setD7(byte7.getDO5());
		dO5.step();

		dO6.setD0(byte0.getDO6());
		dO6.setD1(byte1.getDO6());
		dO6.setD2(byte2.getDO6());
		dO6.setD3(byte3.getDO6());
		dO6.setD4(byte4.getDO6());
		dO6.setD5(byte5.getDO6());
		dO6.setD6(byte6.getDO6());
		dO6.setD7(byte7.getDO6());
		dO6.step();

		dO7.setD0(byte0.getDO7());
		dO7.setD1(byte1.getDO7());
		dO7.setD2(byte2.getDO7());
		dO7.setD3(byte3.getDO7());
		dO7.setD4(byte4.getDO7());
		dO7.setD5(byte5.getDO7());
		dO7.setD6(byte6.getDO7());
		dO7.setD7(byte7.getDO7());
		dO7.step();
	}

}

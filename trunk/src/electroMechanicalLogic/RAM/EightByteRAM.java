/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.RAM;

import electroMechanicalLogic.EightBitLatch;
import electroMechanicalLogic.ThreeToEightDecoder;
import electroMechanicalLogic.Interfaces.IEightBitLatch;
import electroMechanicalLogic.Interfaces.IThreeToEightDecoder;
import electroMechanicalLogic.RAM.Interfaces.IEightByteRAM;
import electroMechanicalLogic.Selectors.EightToOneSelector;
import electroMechanicalLogic.Selectors.Interfaces.IEightToOneSelector;

/**
 * An eight byte Random Access Memory.
 */
public class EightByteRAM implements IEightByteRAM {

	protected IThreeToEightDecoder w = new ThreeToEightDecoder();
	protected IEightToOneSelector dO0 = new EightToOneSelector();
	protected IEightToOneSelector dO1 = new EightToOneSelector();
	protected IEightToOneSelector dO2 = new EightToOneSelector();
	protected IEightToOneSelector dO3 = new EightToOneSelector();
	protected IEightToOneSelector dO4 = new EightToOneSelector();
	protected IEightToOneSelector dO5 = new EightToOneSelector();
	protected IEightToOneSelector dO6 = new EightToOneSelector();
	protected IEightToOneSelector dO7 = new EightToOneSelector();

	protected IEightBitLatch bank0;
	protected IEightBitLatch bank1;
	protected IEightBitLatch bank2;
	protected IEightBitLatch bank3;
	protected IEightBitLatch bank4;
	protected IEightBitLatch bank5;
	protected IEightBitLatch bank6;
	protected IEightBitLatch bank7;

	public EightByteRAM() {
		initializeBanks();
	}

	@Override
	public boolean getDO0() {
		return dO0.getDO();
	}

	@Override
	public boolean getDO1() {
		return dO1.getDO();
	}

	@Override
	public boolean getDO2() {
		return dO2.getDO();
	}

	@Override
	public boolean getDO3() {
		return dO3.getDO();
	}

	@Override
	public boolean getDO4() {
		return dO4.getDO();
	}

	@Override
	public boolean getDO5() {
		return dO5.getDO();
	}

	@Override
	public boolean getDO6() {
		return dO6.getDO();

	}

	@Override
	public boolean getDO7() {
		return dO7.getDO();
	}

	@Override
	public void setA0(final boolean value) {
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
	public void setA1(final boolean value) {
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
	public void setA2(final boolean value) {
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
	public void setDI0(final boolean value) {
		bank0.setDI0(value);
		bank1.setDI0(value);
		bank2.setDI0(value);
		bank3.setDI0(value);
		bank4.setDI0(value);
		bank5.setDI0(value);
		bank6.setDI0(value);
		bank7.setDI0(value);
	}

	@Override
	public void setDI1(final boolean value) {
		bank0.setDI1(value);
		bank1.setDI1(value);
		bank2.setDI1(value);
		bank3.setDI1(value);
		bank4.setDI1(value);
		bank5.setDI1(value);
		bank6.setDI1(value);
		bank7.setDI1(value);
	}

	@Override
	public void setDI2(final boolean value) {
		bank0.setDI2(value);
		bank1.setDI2(value);
		bank2.setDI2(value);
		bank3.setDI2(value);
		bank4.setDI2(value);
		bank5.setDI2(value);
		bank6.setDI2(value);
		bank7.setDI2(value);
	}

	@Override
	public void setDI3(final boolean value) {
		bank0.setDI3(value);
		bank1.setDI3(value);
		bank2.setDI3(value);
		bank3.setDI3(value);
		bank4.setDI3(value);
		bank5.setDI3(value);
		bank6.setDI3(value);
		bank7.setDI3(value);
	}

	@Override
	public void setDI4(final boolean value) {
		bank0.setDI4(value);
		bank1.setDI4(value);
		bank2.setDI4(value);
		bank3.setDI4(value);
		bank4.setDI4(value);
		bank5.setDI4(value);
		bank6.setDI4(value);
		bank7.setDI4(value);
	}

	@Override
	public void setDI5(final boolean value) {
		bank0.setDI5(value);
		bank1.setDI5(value);
		bank2.setDI5(value);
		bank3.setDI5(value);
		bank4.setDI5(value);
		bank5.setDI5(value);
		bank6.setDI5(value);
		bank7.setDI5(value);
	}

	@Override
	public void setDI6(final boolean value) {
		bank0.setDI6(value);
		bank1.setDI6(value);
		bank2.setDI6(value);
		bank3.setDI6(value);
		bank4.setDI6(value);
		bank5.setDI6(value);
		bank6.setDI6(value);
		bank7.setDI6(value);
	}

	@Override
	public void setDI7(final boolean value) {
		bank0.setDI7(value);
		bank1.setDI7(value);
		bank2.setDI7(value);
		bank3.setDI7(value);
		bank4.setDI7(value);
		bank5.setDI7(value);
		bank6.setDI7(value);
		bank7.setDI7(value);
	}

	@Override
	public void setPower(final boolean value) {
		w.setPower(value);
		bank0.setPower(value);
		bank1.setPower(value);
		bank2.setPower(value);
		bank3.setPower(value);
		bank4.setPower(value);
		bank5.setPower(value);
		bank6.setPower(value);
		bank7.setPower(value);
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
	public void setW(final boolean value) {
		w.setData(value);
	}

	@Override
	public void step() {
		w.step();

		bank0.setW(w.getO0());
		bank0.step();

		bank1.setW(w.getO1());
		bank1.step();

		bank2.setW(w.getO2());
		bank2.step();

		bank3.setW(w.getO3());
		bank3.step();

		bank4.setW(w.getO4());
		bank4.step();

		bank5.setW(w.getO5());
		bank5.step();

		bank6.setW(w.getO6());
		bank6.step();

		bank7.setW(w.getO7());
		bank7.step();

		dO0.setA(bank0.getDO0());
		dO0.setB(bank1.getDO0());
		dO0.setC(bank2.getDO0());
		dO0.setD(bank3.getDO0());
		dO0.setE(bank4.getDO0());
		dO0.setF(bank5.getDO0());
		dO0.setG(bank6.getDO0());
		dO0.setH(bank7.getDO0());
		dO0.step();

		dO1.setA(bank0.getDO1());
		dO1.setB(bank1.getDO1());
		dO1.setC(bank2.getDO1());
		dO1.setD(bank3.getDO1());
		dO1.setE(bank4.getDO1());
		dO1.setF(bank5.getDO1());
		dO1.setG(bank6.getDO1());
		dO1.setH(bank7.getDO1());
		dO1.step();

		dO2.setA(bank0.getDO2());
		dO2.setB(bank1.getDO2());
		dO2.setC(bank2.getDO2());
		dO2.setD(bank3.getDO2());
		dO2.setE(bank4.getDO2());
		dO2.setF(bank5.getDO2());
		dO2.setG(bank6.getDO2());
		dO2.setH(bank7.getDO2());
		dO2.step();

		dO3.setA(bank0.getDO3());
		dO3.setB(bank1.getDO3());
		dO3.setC(bank2.getDO3());
		dO3.setD(bank3.getDO3());
		dO3.setE(bank4.getDO3());
		dO3.setF(bank5.getDO3());
		dO3.setG(bank6.getDO3());
		dO3.setH(bank7.getDO3());
		dO3.step();

		dO4.setA(bank0.getDO4());
		dO4.setB(bank1.getDO4());
		dO4.setC(bank2.getDO4());
		dO4.setD(bank3.getDO4());
		dO4.setE(bank4.getDO4());
		dO4.setF(bank5.getDO4());
		dO4.setG(bank6.getDO4());
		dO4.setH(bank7.getDO4());
		dO4.step();

		dO5.setA(bank0.getDO5());
		dO5.setB(bank1.getDO5());
		dO5.setC(bank2.getDO5());
		dO5.setD(bank3.getDO5());
		dO5.setE(bank4.getDO5());
		dO5.setF(bank5.getDO5());
		dO5.setG(bank6.getDO5());
		dO5.setH(bank7.getDO5());
		dO5.step();

		dO6.setA(bank0.getDO6());
		dO6.setB(bank1.getDO6());
		dO6.setC(bank2.getDO6());
		dO6.setD(bank3.getDO6());
		dO6.setE(bank4.getDO6());
		dO6.setF(bank5.getDO6());
		dO6.setG(bank6.getDO6());
		dO6.setH(bank7.getDO6());
		dO6.step();

		dO7.setA(bank0.getDO7());
		dO7.setB(bank1.getDO7());
		dO7.setC(bank2.getDO7());
		dO7.setD(bank3.getDO7());
		dO7.setE(bank4.getDO7());
		dO7.setF(bank5.getDO7());
		dO7.setG(bank6.getDO7());
		dO7.setH(bank7.getDO7());
		dO7.step();
	}

	protected void initializeBanks() {
		bank0 = new EightBitLatch();
		bank1 = new EightBitLatch();
		bank2 = new EightBitLatch();
		bank3 = new EightBitLatch();
		bank4 = new EightBitLatch();
		bank5 = new EightBitLatch();
		bank6 = new EightBitLatch();
		bank7 = new EightBitLatch();
	}

}

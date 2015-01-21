/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Model;

import electroMechanicalLogic.EightBitAdder;
import electroMechanicalLogic.EightBitEdgeTriggeredLatchWithClear;
import electroMechanicalLogic.EightBitTwoToOneSelector;
import electroMechanicalLogic.Inverter;
import electroMechanicalLogic.TwoInputAndGate;
import electroMechanicalLogic.TwoInputOrGate;
import electroMechanicalLogic.Interfaces.IEightBitAdder;
import electroMechanicalLogic.Interfaces.IEightBitLatchWithClear;
import electroMechanicalLogic.Interfaces.IEightBitTwoToOneSelector;
import electroMechanicalLogic.Interfaces.IRelay;
import electroMechanicalLogic.Interfaces.ITwoInputSingleOutputGate;
import electroMechanicalMachine.Model.Interfaces.IMarkVIALU;

public class MarkVIALU implements IMarkVIALU {
	private IEightBitAdder adder = new EightBitAdder();
	private ITwoInputSingleOutputGate clockAndLoadOrAdd = new TwoInputAndGate();
	private IEightBitLatchWithClear latch = new EightBitEdgeTriggeredLatchWithClear();
	private IRelay loadBar = new Inverter();
	private ITwoInputSingleOutputGate loadOrAdd = new TwoInputOrGate();
	private IEightBitTwoToOneSelector loadSelector = new EightBitTwoToOneSelector();

	@Override
	public boolean getDO0() {
		return latch.getDO0();
	}

	@Override
	public boolean getDO1() {
		return latch.getDO1();
	}

	@Override
	public boolean getDO2() {
		return latch.getDO2();
	}

	@Override
	public boolean getDO3() {
		return latch.getDO3();
	}

	@Override
	public boolean getDO4() {
		return latch.getDO4();
	}

	@Override
	public boolean getDO5() {
		return latch.getDO5();
	}

	@Override
	public boolean getDO6() {
		return latch.getDO6();
	}

	@Override
	public boolean getDO7() {
		return latch.getDO7();
	}

	@Override
	public void setAdd(boolean value) {
		loadOrAdd.setB(value);
	}

	@Override
	public void setClear(boolean value) {
		latch.setClr(value);
	}

	@Override
	public void setClock(boolean value) {
		clockAndLoadOrAdd.setA(value);
	}

	@Override
	public void setDI0(boolean value) {
		adder.setA0(value);
		loadSelector.setA0(value);
	}

	@Override
	public void setDI1(boolean value) {
		adder.setA1(value);
		loadSelector.setA1(value);
	}

	@Override
	public void setDI2(boolean value) {
		adder.setA2(value);
		loadSelector.setA2(value);
	}

	@Override
	public void setDI3(boolean value) {
		adder.setA3(value);
		loadSelector.setA3(value);
	}

	@Override
	public void setDI4(boolean value) {
		adder.setA4(value);
		loadSelector.setA4(value);
	}

	@Override
	public void setDI5(boolean value) {
		adder.setA5(value);
		loadSelector.setA5(value);
	}

	@Override
	public void setDI6(boolean value) {
		adder.setA6(value);
		loadSelector.setA6(value);
	}

	@Override
	public void setDI7(boolean value) {
		adder.setA7(value);
		loadSelector.setA7(value);
	}

	@Override
	public void setLoad(boolean value) {
		loadBar.setInput(value);
		loadOrAdd.setA(value);
	}

	@Override
	public void setPower(boolean value) {
		adder.setPower(value);
		clockAndLoadOrAdd.setPower(value);
		latch.setPower(value);
		loadBar.setPower(value);
		loadOrAdd.setPower(value);
		loadSelector.setPower(value);
	}

	@Override
	public void step() {
		stepAdder();

		loadBar.step();

		stepLoadSelector();

		loadOrAdd.step();
		clockAndLoadOrAdd.setB(loadOrAdd.getOutput());
		clockAndLoadOrAdd.step();

		stepLatch();
	}

	private void stepAdder() {
		adder.setB0(latch.getDO0());
		adder.setB1(latch.getDO1());
		adder.setB2(latch.getDO2());
		adder.setB3(latch.getDO3());
		adder.setB4(latch.getDO4());
		adder.setB5(latch.getDO5());
		adder.setB6(latch.getDO6());
		adder.setB7(latch.getDO7());
		adder.step();
	}

	private void stepLatch() {
		latch.setDI0(loadSelector.getO0());
		latch.setDI1(loadSelector.getO1());
		latch.setDI2(loadSelector.getO2());
		latch.setDI3(loadSelector.getO3());
		latch.setDI4(loadSelector.getO4());
		latch.setDI5(loadSelector.getO5());
		latch.setDI6(loadSelector.getO6());
		latch.setDI7(loadSelector.getO7());
		latch.setW(clockAndLoadOrAdd.getOutput());
		latch.step();
	}

	private void stepLoadSelector() {
		loadSelector.setSelect(loadBar.getOutput());
		loadSelector.setB0(adder.getS0());
		loadSelector.setB1(adder.getS1());
		loadSelector.setB2(adder.getS2());
		loadSelector.setB3(adder.getS3());
		loadSelector.setB4(adder.getS4());
		loadSelector.setB5(adder.getS5());
		loadSelector.setB6(adder.getS6());
		loadSelector.setB7(adder.getS7());
		loadSelector.step();
	}
}

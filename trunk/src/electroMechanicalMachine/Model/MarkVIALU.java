/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Model;

import electroMechanicalLogic.EightBitAdder;
import electroMechanicalLogic.EightBitDataPath;
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
	private final IEightBitAdder adder = new EightBitAdder();
	private final ITwoInputSingleOutputGate clockAndLoadOrAdd = new TwoInputAndGate();
	private final IEightBitLatchWithClear latch = new EightBitEdgeTriggeredLatchWithClear();
	private final IRelay loadBar = new Inverter();
	private final ITwoInputSingleOutputGate loadOrAdd = new TwoInputOrGate();
	private final IEightBitTwoToOneSelector loadSelector = new EightBitTwoToOneSelector();

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
	public void setAdd(final boolean value) {
		loadOrAdd.setB(value);
	}

	@Override
	public void setClear(final boolean value) {
		latch.setClr(value);
	}

	@Override
	public void setClock(final boolean value) {
		clockAndLoadOrAdd.setA(value);
	}

	@Override
	public void setDI0(final boolean value) {
		adder.setA0(value);
		loadSelector.setA0(value);
	}

	@Override
	public void setDI1(final boolean value) {
		adder.setA1(value);
		loadSelector.setA1(value);
	}

	@Override
	public void setDI2(final boolean value) {
		adder.setA2(value);
		loadSelector.setA2(value);
	}

	@Override
	public void setDI3(final boolean value) {
		adder.setA3(value);
		loadSelector.setA3(value);
	}

	@Override
	public void setDI4(final boolean value) {
		adder.setA4(value);
		loadSelector.setA4(value);
	}

	@Override
	public void setDI5(final boolean value) {
		adder.setA5(value);
		loadSelector.setA5(value);
	}

	@Override
	public void setDI6(final boolean value) {
		adder.setA6(value);
		loadSelector.setA6(value);
	}

	@Override
	public void setDI7(final boolean value) {
		adder.setA7(value);
		loadSelector.setA7(value);
	}

	@Override
	public void setLoad(final boolean value) {
		loadBar.setInput(value);
		loadOrAdd.setA(value);
	}

	@Override
	public void setPower(final boolean value) {
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
		EightBitDataPath.DataOutToBIn(latch, adder);
		adder.step();
	}

	private void stepLatch() {
		EightBitDataPath.DataOutToDataIn(loadSelector, latch);
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

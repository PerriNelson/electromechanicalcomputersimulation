/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.event.EventListenerList;

import electroMechanicalLogic.EightBitAdder;
import electroMechanicalLogic.EightBitEdgeTriggeredLatchWithClear;
import electroMechanicalLogic.Inverter;
import electroMechanicalLogic.Oscillator;
import electroMechanicalLogic.SixteenBitCounterWithClear;
import electroMechanicalLogic.SixtyFourKilobyteRAM;
import electroMechanicalLogic.Interfaces.IEightBitAdder;
import electroMechanicalLogic.Interfaces.IEightBitLatchWithClear;
import electroMechanicalLogic.Interfaces.IOscillator;
import electroMechanicalLogic.Interfaces.ISixteenBitCounterWithClear;
import electroMechanicalLogic.Interfaces.ISixtyFourKilobyteRAM;
import electroMechanicalMachine.Model.Interfaces.IAddingMachineMarkVModel;
import electroMechanicalMachine.Model.Interfaces.ISixtyFourKilobyteRamControlPanelModel;

public class AddingMachineMarkVModel implements IAddingMachineMarkVModel {
	private EventListenerList eventListeners = new EventListenerList();
	private ISixtyFourKilobyteRamControlPanelModel controlPanel;
	private IEightBitLatchWithClear latch;
	private IEightBitAdder adder;
	private IOscillator clock;
	private Inverter clearBar;
	private Inverter clkBar;
	private ISixteenBitCounterWithClear counter;

	public AddingMachineMarkVModel() {
		this(new SixtyFourKilobyteRAM());
	}

	public AddingMachineMarkVModel(ISixtyFourKilobyteRAM ram) {
		controlPanel = new SixtyFourKilobyteRamControlPanelModel(ram);
		adder = new EightBitAdder();
		latch = new EightBitEdgeTriggeredLatchWithClear();
		clock = new Oscillator();
		counter = new SixteenBitCounterWithClear();
		clearBar = new Inverter();
		clkBar = new Inverter();
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		eventListeners.add(PropertyChangeListener.class, listener);
	}

	protected void fireOnPropertyChange() {
		PropertyChangeEvent propertyChangeEvent = null;

		Object[] listeners = eventListeners.getListenerList();
		for (int index = listeners.length - 2; index >= 0; index -= 2) {
			if (listeners[index] == PropertyChangeListener.class) {
				if (propertyChangeEvent == null) {
					propertyChangeEvent = new PropertyChangeEvent(this, null,
							null, null);
				}
				((PropertyChangeListener) listeners[index + 1])
						.propertyChange(propertyChangeEvent);
			}
		}
	}

	@Override
	public boolean getDO0() {
		return controlPanel.getDO0();
	}

	@Override
	public boolean getDO1() {
		return controlPanel.getDO1();
	}

	@Override
	public boolean getDO2() {
		return controlPanel.getDO2();
	}

	@Override
	public boolean getDO3() {
		return controlPanel.getDO3();
	}

	@Override
	public boolean getDO4() {
		return controlPanel.getDO4();
	}

	@Override
	public boolean getDO5() {
		return controlPanel.getDO5();
	}

	@Override
	public boolean getDO6() {
		return controlPanel.getDO6();
	}

	@Override
	public boolean getDO7() {
		return controlPanel.getDO7();
	}

	@Override
	public boolean getS0() {
		return latch.getDO0();
	}

	@Override
	public boolean getS1() {
		return latch.getDO1();
	}

	@Override
	public boolean getS2() {
		return latch.getDO2();
	}

	@Override
	public boolean getS3() {
		return latch.getDO3();
	}

	@Override
	public boolean getS4() {
		return latch.getDO4();
	}

	@Override
	public boolean getS5() {
		return latch.getDO5();
	}

	@Override
	public boolean getS6() {
		return latch.getDO6();
	}

	@Override
	public boolean getS7() {
		return latch.getDO7();
	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		eventListeners.remove(PropertyChangeListener.class, listener);
	}

	@Override
	public void setA0(boolean value) {
		controlPanel.setCpA0(value);
	}

	@Override
	public void setA1(boolean value) {
		controlPanel.setCpA1(value);
	}

	@Override
	public void setA2(boolean value) {
		controlPanel.setCpA2(value);
	}

	@Override
	public void setA3(boolean value) {
		controlPanel.setCpA3(value);
	}

	@Override
	public void setA4(boolean value) {
		controlPanel.setCpA4(value);
	}

	@Override
	public void setA5(boolean value) {
		controlPanel.setCpA5(value);
	}

	@Override
	public void setA6(boolean value) {
		controlPanel.setCpA6(value);
	}

	@Override
	public void setA7(boolean value) {
		controlPanel.setCpA7(value);
	}

	@Override
	public void setA8(boolean value) {
		controlPanel.setCpA8(value);
	}

	@Override
	public void setA9(boolean value) {
		controlPanel.setCpA9(value);
	}

	@Override
	public void setAA(boolean value) {
		controlPanel.setCpAA(value);
	}

	@Override
	public void setAB(boolean value) {
		controlPanel.setCpAB(value);
	}

	@Override
	public void setAC(boolean value) {
		controlPanel.setCpAC(value);
	}

	@Override
	public void setAD(boolean value) {
		controlPanel.setCpAD(value);
	}

	@Override
	public void setAE(boolean value) {
		controlPanel.setCpAE(value);
	}

	@Override
	public void setAF(boolean value) {
		controlPanel.setCpAF(value);
	}

	@Override
	public void setClear(boolean value) {
		latch.setClr(value);
		counter.setClear(value);
		clearBar.setInput(value);
	}

	@Override
	public void setDI0(boolean value) {
		controlPanel.setCpDI0(value);
	}

	@Override
	public void setDI1(boolean value) {
		controlPanel.setCpDI1(value);
	}

	@Override
	public void setDI2(boolean value) {
		controlPanel.setCpDI2(value);
	}

	@Override
	public void setDI3(boolean value) {
		controlPanel.setCpDI3(value);
	}

	@Override
	public void setDI4(boolean value) {
		controlPanel.setCpDI4(value);
	}

	@Override
	public void setDI5(boolean value) {
		controlPanel.setCpDI5(value);
	}

	@Override
	public void setDI6(boolean value) {
		controlPanel.setCpDI6(value);
	}

	@Override
	public void setDI7(boolean value) {
		controlPanel.setCpDI7(value);
	}

	@Override
	public void setPower(boolean value) {
		controlPanel.setPower(value);
		adder.setPower(value);
		latch.setPower(value);
		counter.setPower(value);
		clearBar.setPower(value);
	}

	@Override
	public void setTakeover(boolean value) {
		controlPanel.setCpTakeover(value);
	}

	@Override
	public void setW(boolean value) {
		controlPanel.setCpW(value);
	}

	@Override
	public void step() {

		controlPanel.setEcA0(counter.getQ0());
		controlPanel.setEcA1(counter.getQ1());
		controlPanel.setEcA2(counter.getQ2());
		controlPanel.setEcA3(counter.getQ3());
		controlPanel.setEcA4(counter.getQ4());
		controlPanel.setEcA5(counter.getQ5());
		controlPanel.setEcA6(counter.getQ6());
		controlPanel.setEcA7(counter.getQ7());
		controlPanel.setEcA8(counter.getQ8());
		controlPanel.setEcA9(counter.getQ9());
		controlPanel.setEcAA(counter.getQA());
		controlPanel.setEcAB(counter.getQB());
		controlPanel.setEcAC(counter.getQC());
		controlPanel.setEcAD(counter.getQD());
		controlPanel.setEcAE(counter.getQE());
		controlPanel.setEcAF(counter.getQF());

		controlPanel.step();

		adder.setA0(controlPanel.getDO0());
		adder.setA1(controlPanel.getDO1());
		adder.setA2(controlPanel.getDO2());
		adder.setA3(controlPanel.getDO3());
		adder.setA4(controlPanel.getDO4());
		adder.setA5(controlPanel.getDO5());
		adder.setA6(controlPanel.getDO6());
		adder.setA7(controlPanel.getDO7());

		adder.setB0(latch.getDO0());
		adder.setB1(latch.getDO1());
		adder.setB2(latch.getDO2());
		adder.setB3(latch.getDO3());
		adder.setB4(latch.getDO4());
		adder.setB5(latch.getDO5());
		adder.setB6(latch.getDO6());
		adder.setB7(latch.getDO7());
		adder.step();

		latch.setDI0(adder.getS0());
		latch.setDI1(adder.getS1());
		latch.setDI2(adder.getS2());
		latch.setDI3(adder.getS3());
		latch.setDI4(adder.getS4());
		latch.setDI5(adder.getS5());
		latch.setDI6(adder.getS6());
		latch.setDI7(adder.getS7());

		clearBar.step();
		clock.setPower(clearBar.getOutput());
		clock.step();

		clkBar.setPower(clearBar.getOutput());
		clkBar.setInput(clock.getOutput());
		clkBar.step();

		latch.setW(clkBar.getOutput());

		latch.step();

		counter.setClk(clkBar.getOutput());
		counter.step();

		fireOnPropertyChange();
	}

}

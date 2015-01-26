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
import electroMechanicalLogic.DataChannel.EightBitDataPath;
import electroMechanicalLogic.Interfaces.IEightBitAdder;
import electroMechanicalLogic.Interfaces.IEightBitLatchWithClear;
import electroMechanicalLogic.Interfaces.IOscillator;
import electroMechanicalLogic.Interfaces.ISixteenBitCounterWithClear;
import electroMechanicalLogic.Interfaces.ISixtyFourKilobyteRAM;
import electroMechanicalMachine.Model.Interfaces.IAddingMachineMarkVModel;
import electroMechanicalMachine.Model.Interfaces.ISixtyFourKilobyteRamControlPanelModel;

public class AddingMachineMarkVModel implements IAddingMachineMarkVModel {
	private final EventListenerList eventListeners = new EventListenerList();
	private final ISixtyFourKilobyteRamControlPanelModel controlPanel;
	private final IEightBitLatchWithClear latch;
	private final IEightBitAdder adder;
	private final IOscillator clock;
	private final Inverter clearBar;
	private final Inverter clkBar;
	private final ISixteenBitCounterWithClear counter;

	public AddingMachineMarkVModel() {
		this(new SixtyFourKilobyteRAM());
	}

	public AddingMachineMarkVModel(final ISixtyFourKilobyteRAM ram) {
		controlPanel = new SixtyFourKilobyteRamControlPanelModel(ram);
		adder = new EightBitAdder();
		latch = new EightBitEdgeTriggeredLatchWithClear();
		clock = new Oscillator();
		counter = new SixteenBitCounterWithClear();
		clearBar = new Inverter();
		clkBar = new Inverter();
	}

	@Override
	public void addPropertyChangeListener(final PropertyChangeListener listener) {
		eventListeners.add(PropertyChangeListener.class, listener);
	}

	protected void fireOnPropertyChange() {
		PropertyChangeEvent propertyChangeEvent = null;

		final Object[] listeners = eventListeners.getListenerList();
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
	public void removePropertyChangeListener(
			final PropertyChangeListener listener) {
		eventListeners.remove(PropertyChangeListener.class, listener);
	}

	@Override
	public void setA0(final boolean value) {
		controlPanel.setCpA0(value);
	}

	@Override
	public void setA1(final boolean value) {
		controlPanel.setCpA1(value);
	}

	@Override
	public void setA2(final boolean value) {
		controlPanel.setCpA2(value);
	}

	@Override
	public void setA3(final boolean value) {
		controlPanel.setCpA3(value);
	}

	@Override
	public void setA4(final boolean value) {
		controlPanel.setCpA4(value);
	}

	@Override
	public void setA5(final boolean value) {
		controlPanel.setCpA5(value);
	}

	@Override
	public void setA6(final boolean value) {
		controlPanel.setCpA6(value);
	}

	@Override
	public void setA7(final boolean value) {
		controlPanel.setCpA7(value);
	}

	@Override
	public void setA8(final boolean value) {
		controlPanel.setCpA8(value);
	}

	@Override
	public void setA9(final boolean value) {
		controlPanel.setCpA9(value);
	}

	@Override
	public void setAA(final boolean value) {
		controlPanel.setCpAA(value);
	}

	@Override
	public void setAB(final boolean value) {
		controlPanel.setCpAB(value);
	}

	@Override
	public void setAC(final boolean value) {
		controlPanel.setCpAC(value);
	}

	@Override
	public void setAD(final boolean value) {
		controlPanel.setCpAD(value);
	}

	@Override
	public void setAE(final boolean value) {
		controlPanel.setCpAE(value);
	}

	@Override
	public void setAF(final boolean value) {
		controlPanel.setCpAF(value);
	}

	@Override
	public void setClear(final boolean value) {
		latch.setClr(value);
		counter.setClear(value);
		clearBar.setInput(value);
	}

	@Override
	public void setDI0(final boolean value) {
		controlPanel.setCpDI0(value);
	}

	@Override
	public void setDI1(final boolean value) {
		controlPanel.setCpDI1(value);
	}

	@Override
	public void setDI2(final boolean value) {
		controlPanel.setCpDI2(value);
	}

	@Override
	public void setDI3(final boolean value) {
		controlPanel.setCpDI3(value);
	}

	@Override
	public void setDI4(final boolean value) {
		controlPanel.setCpDI4(value);
	}

	@Override
	public void setDI5(final boolean value) {
		controlPanel.setCpDI5(value);
	}

	@Override
	public void setDI6(final boolean value) {
		controlPanel.setCpDI6(value);
	}

	@Override
	public void setDI7(final boolean value) {
		controlPanel.setCpDI7(value);
	}

	@Override
	public void setPower(final boolean value) {
		controlPanel.setPower(value);
		adder.setPower(value);
		latch.setPower(value);
		counter.setPower(value);
		clearBar.setPower(value);
	}

	@Override
	public void setTakeover(final boolean value) {
		controlPanel.setTakeover(value);
	}

	@Override
	public void setW(final boolean value) {
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

		EightBitDataPath.DataOutToAIn(controlPanel, adder);
		EightBitDataPath.connectEightBitDataOutputToEightBitBInput(latch, adder);
		adder.step();

		EightBitDataPath.connectEightBitSumToEightBitDataInput(adder, latch);

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

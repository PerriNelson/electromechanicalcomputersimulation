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

import electroMechanicalLogic.SixtyFourKilobyteRAM;
import electroMechanicalLogic.TwoLineToOneLineSelector;
import electroMechanicalLogic.Interfaces.ISixtyFourKilobyteRAM;
import electroMechanicalMachine.Model.Interfaces.ISixtyFourKilobyteRamControlPanelModel;

public class SixtyFourKilobyteRamControlPanelModel implements
ISixtyFourKilobyteRamControlPanelModel {

	private final ISixtyFourKilobyteRAM ram;
	private final TwoLineToOneLineSelector[] addressSelectors;
	private final TwoLineToOneLineSelector[] dataSelectors;
	private final TwoLineToOneLineSelector writeSelector;

	private final EventListenerList eventListeners = new EventListenerList();

	public SixtyFourKilobyteRamControlPanelModel() {
		this(new SixtyFourKilobyteRAM());
	}

	public SixtyFourKilobyteRamControlPanelModel(
			final ISixtyFourKilobyteRAM sixtyFourKilobyteRAM) {
		ram = sixtyFourKilobyteRAM;
		addressSelectors = new TwoLineToOneLineSelector[16];
		for (int i = 0; i < 16; i++) {
			addressSelectors[i] = new TwoLineToOneLineSelector();
		}
		dataSelectors = new TwoLineToOneLineSelector[8];
		for (int i = 0; i < 8; i++) {
			dataSelectors[i] = new TwoLineToOneLineSelector();
		}
		writeSelector = new TwoLineToOneLineSelector();
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
		return ram.getDO0();
	}

	@Override
	public boolean getDO1() {
		return ram.getDO1();
	}

	@Override
	public boolean getDO2() {
		return ram.getDO2();
	}

	@Override
	public boolean getDO3() {
		return ram.getDO3();
	}

	@Override
	public boolean getDO4() {
		return ram.getDO4();
	}

	@Override
	public boolean getDO5() {
		return ram.getDO5();
	}

	@Override
	public boolean getDO6() {
		return ram.getDO6();
	}

	@Override
	public boolean getDO7() {
		return ram.getDO7();
	}

	@Override
	public void removePropertyChangeListener(
			final PropertyChangeListener listener) {
		eventListeners.remove(PropertyChangeListener.class, listener);
	}

	@Override
	public void setCpA0(final boolean value) {
		addressSelectors[0].setB(value);
	}

	@Override
	public void setCpA1(final boolean value) {
		addressSelectors[1].setB(value);
	}

	@Override
	public void setCpA2(final boolean value) {
		addressSelectors[2].setB(value);
	}

	@Override
	public void setCpA3(final boolean value) {
		addressSelectors[3].setB(value);
	}

	@Override
	public void setCpA4(final boolean value) {
		addressSelectors[4].setB(value);
	}

	@Override
	public void setCpA5(final boolean value) {
		addressSelectors[5].setB(value);
	}

	@Override
	public void setCpA6(final boolean value) {
		addressSelectors[6].setB(value);
	}

	@Override
	public void setCpA7(final boolean value) {
		addressSelectors[7].setB(value);
	}

	@Override
	public void setCpA8(final boolean value) {
		addressSelectors[8].setB(value);
	}

	@Override
	public void setCpA9(final boolean value) {
		addressSelectors[9].setB(value);
	}

	@Override
	public void setCpAA(final boolean value) {
		addressSelectors[10].setB(value);
	}

	@Override
	public void setCpAB(final boolean value) {
		addressSelectors[11].setB(value);
	}

	@Override
	public void setCpAC(final boolean value) {
		addressSelectors[12].setB(value);
	}

	@Override
	public void setCpAD(final boolean value) {
		addressSelectors[13].setB(value);
	}

	@Override
	public void setCpAE(final boolean value) {
		addressSelectors[14].setB(value);
	}

	@Override
	public void setCpAF(final boolean value) {
		addressSelectors[15].setB(value);
	}

	@Override
	public void setCpDI0(final boolean value) {
		dataSelectors[0].setB(value);
	}

	@Override
	public void setCpDI1(final boolean value) {
		dataSelectors[1].setB(value);
	}

	@Override
	public void setCpDI2(final boolean value) {
		dataSelectors[2].setB(value);
	}

	@Override
	public void setCpDI3(final boolean value) {
		dataSelectors[3].setB(value);
	}

	@Override
	public void setCpDI4(final boolean value) {
		dataSelectors[4].setB(value);
	}

	@Override
	public void setCpDI5(final boolean value) {
		dataSelectors[5].setB(value);
	}

	@Override
	public void setCpDI6(final boolean value) {
		dataSelectors[6].setB(value);
	}

	@Override
	public void setCpDI7(final boolean value) {
		dataSelectors[7].setB(value);
	}

	@Override
	public void setCpTakeover(final boolean value) {
		for (int i = 0; i < 16; i++) {
			addressSelectors[i].setSelect(value);
		}
		for (int i = 0; i < 8; i++) {
			dataSelectors[i].setSelect(value);
		}
		writeSelector.setSelect(value);
	}

	@Override
	public void setCpW(final boolean value) {
		writeSelector.setB(value);
	}

	@Override
	public void setEcA0(final boolean value) {
		addressSelectors[0].setA(value);
	}

	@Override
	public void setEcA1(final boolean value) {
		addressSelectors[1].setA(value);
	}

	@Override
	public void setEcA2(final boolean value) {
		addressSelectors[2].setA(value);
	}

	@Override
	public void setEcA3(final boolean value) {
		addressSelectors[3].setA(value);
	}

	@Override
	public void setEcA4(final boolean value) {
		addressSelectors[4].setA(value);
	}

	@Override
	public void setEcA5(final boolean value) {
		addressSelectors[5].setA(value);
	}

	@Override
	public void setEcA6(final boolean value) {
		addressSelectors[6].setA(value);
	}

	@Override
	public void setEcA7(final boolean value) {
		addressSelectors[7].setA(value);
	}

	@Override
	public void setEcA8(final boolean value) {
		addressSelectors[8].setA(value);
	}

	@Override
	public void setEcA9(final boolean value) {
		addressSelectors[9].setA(value);
	}

	@Override
	public void setEcAA(final boolean value) {
		addressSelectors[10].setA(value);
	}

	@Override
	public void setEcAB(final boolean value) {
		addressSelectors[11].setA(value);
	}

	@Override
	public void setEcAC(final boolean value) {
		addressSelectors[12].setA(value);
	}

	@Override
	public void setEcAD(final boolean value) {
		addressSelectors[13].setA(value);
	}

	@Override
	public void setEcAE(final boolean value) {
		addressSelectors[14].setA(value);
	}

	@Override
	public void setEcAF(final boolean value) {
		addressSelectors[15].setA(value);
	}

	@Override
	public void setEcDI0(final boolean value) {
		dataSelectors[0].setA(value);
	}

	@Override
	public void setEcDI1(final boolean value) {
		dataSelectors[1].setA(value);
	}

	@Override
	public void setEcDI2(final boolean value) {
		dataSelectors[2].setA(value);
	}

	@Override
	public void setEcDI3(final boolean value) {
		dataSelectors[3].setA(value);
	}

	@Override
	public void setEcDI4(final boolean value) {
		dataSelectors[4].setA(value);
	}

	@Override
	public void setEcDI5(final boolean value) {
		dataSelectors[5].setA(value);
	}

	@Override
	public void setEcDI6(final boolean value) {
		dataSelectors[6].setA(value);
	}

	@Override
	public void setEcDI7(final boolean value) {
		dataSelectors[7].setA(value);
	}

	@Override
	public void setEcW(final boolean value) {
		writeSelector.setA(value);
	}

	@Override
	public void setPower(final boolean value) {
		ram.setPower(value);
		for (int i = 0; i < 16; i++) {
			addressSelectors[i].setPower(value);
		}
		for (int i = 0; i < 8; i++) {
			dataSelectors[i].setPower(value);
		}
		writeSelector.setPower(value);
	}

	@Override
	public void step() {
		for (int i = 0; i < 16; i++) {
			addressSelectors[i].step();
		}
		for (int i = 0; i < 8; i++) {
			dataSelectors[i].step();
		}
		writeSelector.step();

		ram.setA0(addressSelectors[0].getQ());
		ram.setA1(addressSelectors[1].getQ());
		ram.setA2(addressSelectors[2].getQ());
		ram.setA3(addressSelectors[3].getQ());
		ram.setA4(addressSelectors[4].getQ());
		ram.setA5(addressSelectors[5].getQ());
		ram.setA6(addressSelectors[6].getQ());
		ram.setA7(addressSelectors[7].getQ());
		ram.setA8(addressSelectors[8].getQ());
		ram.setA9(addressSelectors[9].getQ());
		ram.setAA(addressSelectors[10].getQ());
		ram.setAB(addressSelectors[11].getQ());
		ram.setAC(addressSelectors[12].getQ());
		ram.setAD(addressSelectors[13].getQ());
		ram.setAE(addressSelectors[14].getQ());
		ram.setAF(addressSelectors[15].getQ());
		ram.setDI0(dataSelectors[0].getQ());
		ram.setDI1(dataSelectors[1].getQ());
		ram.setDI2(dataSelectors[2].getQ());
		ram.setDI3(dataSelectors[3].getQ());
		ram.setDI4(dataSelectors[4].getQ());
		ram.setDI5(dataSelectors[5].getQ());
		ram.setDI6(dataSelectors[6].getQ());
		ram.setDI7(dataSelectors[7].getQ());
		ram.setW(writeSelector.getQ());

		ram.step();

		fireOnPropertyChange();
	}
}

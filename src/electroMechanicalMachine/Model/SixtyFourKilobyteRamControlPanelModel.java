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

	private static ISixtyFourKilobyteRAM ram;
	private TwoLineToOneLineSelector[] addressSelectors;
	private TwoLineToOneLineSelector[] dataSelectors;
	private TwoLineToOneLineSelector writeSelector;

	private EventListenerList eventListeners = new EventListenerList();

	
	public SixtyFourKilobyteRamControlPanelModel() {
		this(new SixtyFourKilobyteRAM());
	}
	
	public SixtyFourKilobyteRamControlPanelModel(ISixtyFourKilobyteRAM sixtyFourKilobyteRAM) {
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
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		eventListeners.remove(PropertyChangeListener.class, listener);
	}

	@Override
	public void setPower(boolean value) {
		ram.setPower(value);
		for (int i = 0; i < 16; i++) {
			addressSelectors[i].setPower(true);
		}
		for (int i = 0; i < 8; i++) {
			dataSelectors[i].setPower(true);
		}
		writeSelector.setPower(true);
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
	public void setCpA0(boolean value) {
		addressSelectors[0].setB(value);
	}

	@Override
	public void setCpA1(boolean value) {
		addressSelectors[1].setB(value);
	}

	@Override
	public void setCpA2(boolean value) {
		addressSelectors[2].setB(value);
	}

	@Override
	public void setCpA3(boolean value) {
		addressSelectors[3].setB(value);
	}

	@Override
	public void setCpA4(boolean value) {
		addressSelectors[4].setB(value);
	}

	@Override
	public void setCpA5(boolean value) {
		addressSelectors[5].setB(value);
	}

	@Override
	public void setCpA6(boolean value) {
		addressSelectors[6].setB(value);
	}

	@Override
	public void setCpA7(boolean value) {
		addressSelectors[7].setB(value);
	}

	@Override
	public void setCpA8(boolean value) {
		addressSelectors[8].setB(value);
	}

	@Override
	public void setCpA9(boolean value) {
		addressSelectors[9].setB(value);
	}

	@Override
	public void setCpAA(boolean value) {
		addressSelectors[10].setB(value);
	}

	@Override
	public void setCpAB(boolean value) {
		addressSelectors[11].setB(value);
	}

	@Override
	public void setCpAC(boolean value) {
		addressSelectors[12].setB(value);
	}

	@Override
	public void setCpAD(boolean value) {
		addressSelectors[13].setB(value);
	}

	@Override
	public void setCpAE(boolean value) {
		addressSelectors[14].setB(value);
	}

	@Override
	public void setCpAF(boolean value) {
		addressSelectors[15].setB(value);
	}

	@Override
	public void setCpDI0(boolean value) {
		dataSelectors[0].setB(value);
	}

	@Override
	public void setCpDI1(boolean value) {
		dataSelectors[1].setB(value);
	}

	@Override
	public void setCpDI2(boolean value) {
		dataSelectors[2].setB(value);
	}

	@Override
	public void setCpDI3(boolean value) {
		dataSelectors[3].setB(value);
	}

	@Override
	public void setCpDI4(boolean value) {
		dataSelectors[4].setB(value);
	}

	@Override
	public void setCpDI5(boolean value) {
		dataSelectors[5].setB(value);
	}

	@Override
	public void setCpDI6(boolean value) {
		dataSelectors[6].setB(value);
	}

	@Override
	public void setCpDI7(boolean value) {
		dataSelectors[7].setB(value);
	}

	@Override
	public void setCpTakeover(boolean value) {
		for (int i = 0; i < 16; i++) {
			addressSelectors[i].setSelect(value);
		}
		for (int i = 0; i < 8; i++) {
			dataSelectors[i].setSelect(value);
		}
		writeSelector.setSelect(value);
	}

	@Override
	public void setCpW(boolean value) {
		writeSelector.setB(value);
	}

	@Override
	public void setEcA0(boolean value) {
		addressSelectors[0].setA(value);
	}

	@Override
	public void setEcA1(boolean value) {
		addressSelectors[1].setA(value);
	}

	@Override
	public void setEcA2(boolean value) {
		addressSelectors[2].setA(value);
	}

	@Override
	public void setEcA3(boolean value) {
		addressSelectors[3].setA(value);
	}

	@Override
	public void setEcA4(boolean value) {
		addressSelectors[4].setA(value);
	}

	@Override
	public void setEcA5(boolean value) {
		addressSelectors[5].setA(value);
	}

	@Override
	public void setEcA6(boolean value) {
		addressSelectors[6].setA(value);
	}

	@Override
	public void setEcA7(boolean value) {
		addressSelectors[7].setA(value);
	}

	@Override
	public void setEcA8(boolean value) {
		addressSelectors[8].setA(value);
	}

	@Override
	public void setEcA9(boolean value) {
		addressSelectors[9].setA(value);
	}

	@Override
	public void setEcAA(boolean value) {
		addressSelectors[10].setA(value);
	}

	@Override
	public void setEcAB(boolean value) {
		addressSelectors[11].setA(value);
	}

	@Override
	public void setEcAC(boolean value) {
		addressSelectors[12].setA(value);
	}

	@Override
	public void setEcAD(boolean value) {
		addressSelectors[13].setA(value);
	}

	@Override
	public void setEcAE(boolean value) {
		addressSelectors[14].setA(value);
	}

	@Override
	public void setEcAF(boolean value) {
		addressSelectors[15].setA(value);
	}

	@Override
	public void setEcDI0(boolean value) {
		dataSelectors[0].setA(value);
	}

	@Override
	public void setEcDI1(boolean value) {
		dataSelectors[1].setA(value);
	}

	@Override
	public void setEcDI2(boolean value) {
		dataSelectors[2].setA(value);
	}

	@Override
	public void setEcDI3(boolean value) {
		dataSelectors[3].setA(value);
	}

	@Override
	public void setEcDI4(boolean value) {
		dataSelectors[4].setA(value);
	}

	@Override
	public void setEcDI5(boolean value) {
		dataSelectors[5].setA(value);
	}

	@Override
	public void setEcDI6(boolean value) {
		dataSelectors[6].setA(value);
	}

	@Override
	public void setEcDI7(boolean value) {
		dataSelectors[7].setA(value);
	}

	@Override
	public void setEcW(boolean value) {
		writeSelector.setA(value);
	}
}

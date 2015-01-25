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

import electroMechanicalLogic.EightBitBuffer;
import electroMechanicalLogic.SixteenBitAddressBuffer;
import electroMechanicalLogic.SixtyFourKilobyteRAM;
import electroMechanicalLogic.TwoLineToOneLineSelector;
import electroMechanicalLogic.Interfaces.IEightBitBuffer;
import electroMechanicalLogic.Interfaces.ISixteenBitAddressBuffer;
import electroMechanicalLogic.Interfaces.ISixtyFourKilobyteRAM;
import electroMechanicalLogic.Interfaces.DataChannels.IEightBitDataIn;
import electroMechanicalLogic.Interfaces.DataChannels.ISixteenBitAInput;
import electroMechanicalMachine.Model.Interfaces.ISixtyFourKilobyteRamControlPanelModel;

public class SixtyFourKilobyteRamControlPanelModel implements
		ISixtyFourKilobyteRamControlPanelModel {

	private final ISixteenBitAddressBuffer panelAddress;
	private final ISixteenBitAddressBuffer externalAddress;
	private final IEightBitBuffer panelData;
	private final IEightBitBuffer externalData;

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
		panelAddress = new SixteenBitAddressBuffer();
		externalAddress = new SixteenBitAddressBuffer();
		panelData = new EightBitBuffer();
		externalData = new EightBitBuffer();

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
	public ISixteenBitAInput getExternalAddressIn() {
		return externalAddress;
	}

	@Override
	public IEightBitDataIn getExternalDataIn() {
		return externalData;
	}

	@Override
	public ISixteenBitAInput getPanelAddressIn() {
		return panelAddress;
	}

	@Override
	public IEightBitDataIn getPanelDataIn() {
		return panelData;
	}

	@Override
	public void removePropertyChangeListener(
			final PropertyChangeListener listener) {
		eventListeners.remove(PropertyChangeListener.class, listener);
	}

	@Override
	public void setCpA0(final boolean value) {
		panelAddress.setA0(value);
	}

	@Override
	public void setCpA1(final boolean value) {
		panelAddress.setA1(value);
	}

	@Override
	public void setCpA2(final boolean value) {
		panelAddress.setA2(value);
	}

	@Override
	public void setCpA3(final boolean value) {
		panelAddress.setA3(value);
	}

	@Override
	public void setCpA4(final boolean value) {
		panelAddress.setA4(value);
	}

	@Override
	public void setCpA5(final boolean value) {
		panelAddress.setA5(value);
	}

	@Override
	public void setCpA6(final boolean value) {
		panelAddress.setA6(value);
	}

	@Override
	public void setCpA7(final boolean value) {
		panelAddress.setA7(value);
	}

	@Override
	public void setCpA8(final boolean value) {
		panelAddress.setA8(value);
	}

	@Override
	public void setCpA9(final boolean value) {
		panelAddress.setA9(value);
	}

	@Override
	public void setCpAA(final boolean value) {
		panelAddress.setAA(value);
	}

	@Override
	public void setCpAB(final boolean value) {
		panelAddress.setAB(value);
	}

	@Override
	public void setCpAC(final boolean value) {
		panelAddress.setAC(value);
	}

	@Override
	public void setCpAD(final boolean value) {
		panelAddress.setAD(value);
	}

	@Override
	public void setCpAE(final boolean value) {
		panelAddress.setAE(value);
	}

	@Override
	public void setCpAF(final boolean value) {
		panelAddress.setAF(value);
	}

	@Override
	public void setCpDI0(final boolean value) {
		panelData.setDI0(value);
	}

	@Override
	public void setCpDI1(final boolean value) {
		panelData.setDI1(value);
	}

	@Override
	public void setCpDI2(final boolean value) {
		panelData.setDI2(value);
	}

	@Override
	public void setCpDI3(final boolean value) {
		panelData.setDI3(value);
	}

	@Override
	public void setCpDI4(final boolean value) {
		panelData.setDI4(value);
	}

	@Override
	public void setCpDI5(final boolean value) {
		panelData.setDI5(value);
	}

	@Override
	public void setCpDI6(final boolean value) {
		panelData.setDI6(value);
	}

	@Override
	public void setCpDI7(final boolean value) {
		panelData.setDI7(value);
	}

	@Override
	public void setCpW(final boolean value) {
		writeSelector.setB(value);
	}

	@Override
	public void setEcA0(final boolean value) {
		externalAddress.setA0(value);
	}

	@Override
	public void setEcA1(final boolean value) {
		externalAddress.setA1(value);
	}

	@Override
	public void setEcA2(final boolean value) {
		externalAddress.setA2(value);
	}

	@Override
	public void setEcA3(final boolean value) {
		externalAddress.setA3(value);
	}

	@Override
	public void setEcA4(final boolean value) {
		externalAddress.setA4(value);
	}

	@Override
	public void setEcA5(final boolean value) {
		externalAddress.setA5(value);
	}

	@Override
	public void setEcA6(final boolean value) {
		externalAddress.setA6(value);
	}

	@Override
	public void setEcA7(final boolean value) {
		externalAddress.setA7(value);
	}

	@Override
	public void setEcA8(final boolean value) {
		externalAddress.setA8(value);
	}

	@Override
	public void setEcA9(final boolean value) {
		externalAddress.setA9(value);
	}

	@Override
	public void setEcAA(final boolean value) {
		externalAddress.setAA(value);
	}

	@Override
	public void setEcAB(final boolean value) {
		externalAddress.setAB(value);
	}

	@Override
	public void setEcAC(final boolean value) {
		externalAddress.setAC(value);
	}

	@Override
	public void setEcAD(final boolean value) {
		externalAddress.setAD(value);
	}

	@Override
	public void setEcAE(final boolean value) {
		externalAddress.setAE(value);
	}

	@Override
	public void setEcAF(final boolean value) {
		externalAddress.setAF(value);
	}

	@Override
	public void setEcDI0(final boolean value) {
		externalData.setDI0(value);
	}

	@Override
	public void setEcDI1(final boolean value) {
		externalData.setDI1(value);
	}

	@Override
	public void setEcDI2(final boolean value) {
		externalData.setDI2(value);
	}

	@Override
	public void setEcDI3(final boolean value) {
		externalData.setDI3(value);
	}

	@Override
	public void setEcDI4(final boolean value) {
		externalData.setDI4(value);
	}

	@Override
	public void setEcDI5(final boolean value) {
		externalData.setDI5(value);
	}

	@Override
	public void setEcDI6(final boolean value) {
		externalData.setDI6(value);
	}

	@Override
	public void setEcDI7(final boolean value) {
		externalData.setDI7(value);
	}

	@Override
	public void setEcW(final boolean value) {
		writeSelector.setA(value);
	}

	@Override
	public void setPower(final boolean value) {
		panelAddress.setPower(value);
		panelData.setPower(value);

		externalAddress.setPower(value);
		externalData.setPower(value);

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
	public void setTakeover(final boolean value) {
		for (int i = 0; i < 16; i++) {
			addressSelectors[i].setSelect(value);
		}
		for (int i = 0; i < 8; i++) {
			dataSelectors[i].setSelect(value);
		}
		writeSelector.setSelect(value);
	}

	@Override
	public void step() {
		panelAddress.step();
		panelData.step();
		externalAddress.step();
		externalData.step();

		stepAddressSelectors();
		stepDataSelectors();

		writeSelector.step();

		ram.setA0(addressSelectors[0].getDO());
		ram.setA1(addressSelectors[1].getDO());
		ram.setA2(addressSelectors[2].getDO());
		ram.setA3(addressSelectors[3].getDO());
		ram.setA4(addressSelectors[4].getDO());
		ram.setA5(addressSelectors[5].getDO());
		ram.setA6(addressSelectors[6].getDO());
		ram.setA7(addressSelectors[7].getDO());
		ram.setA8(addressSelectors[8].getDO());
		ram.setA9(addressSelectors[9].getDO());
		ram.setAA(addressSelectors[10].getDO());
		ram.setAB(addressSelectors[11].getDO());
		ram.setAC(addressSelectors[12].getDO());
		ram.setAD(addressSelectors[13].getDO());
		ram.setAE(addressSelectors[14].getDO());
		ram.setAF(addressSelectors[15].getDO());

		ram.setDI0(dataSelectors[0].getDO());
		ram.setDI1(dataSelectors[1].getDO());
		ram.setDI2(dataSelectors[2].getDO());
		ram.setDI3(dataSelectors[3].getDO());
		ram.setDI4(dataSelectors[4].getDO());
		ram.setDI5(dataSelectors[5].getDO());
		ram.setDI6(dataSelectors[6].getDO());
		ram.setDI7(dataSelectors[7].getDO());

		ram.setW(writeSelector.getDO());

		ram.step();

		fireOnPropertyChange();
	}

	private void stepAddressSelectors() {
		addressSelectors[0].setA(externalAddress.getA0());
		addressSelectors[1].setA(externalAddress.getA1());
		addressSelectors[2].setA(externalAddress.getA2());
		addressSelectors[3].setA(externalAddress.getA3());
		addressSelectors[4].setA(externalAddress.getA4());
		addressSelectors[5].setA(externalAddress.getA5());
		addressSelectors[6].setA(externalAddress.getA6());
		addressSelectors[7].setA(externalAddress.getA7());
		addressSelectors[8].setA(externalAddress.getA8());
		addressSelectors[9].setA(externalAddress.getA9());
		addressSelectors[10].setA(externalAddress.getAA());
		addressSelectors[11].setA(externalAddress.getAB());
		addressSelectors[12].setA(externalAddress.getAC());
		addressSelectors[13].setA(externalAddress.getAD());
		addressSelectors[14].setA(externalAddress.getAE());
		addressSelectors[15].setA(externalAddress.getAF());

		addressSelectors[0].setB(panelAddress.getA0());
		addressSelectors[1].setB(panelAddress.getA1());
		addressSelectors[2].setB(panelAddress.getA2());
		addressSelectors[3].setB(panelAddress.getA3());
		addressSelectors[4].setB(panelAddress.getA4());
		addressSelectors[5].setB(panelAddress.getA5());
		addressSelectors[6].setB(panelAddress.getA6());
		addressSelectors[7].setB(panelAddress.getA7());
		addressSelectors[8].setB(panelAddress.getA8());
		addressSelectors[9].setB(panelAddress.getA9());
		addressSelectors[10].setB(panelAddress.getAA());
		addressSelectors[11].setB(panelAddress.getAB());
		addressSelectors[12].setB(panelAddress.getAC());
		addressSelectors[13].setB(panelAddress.getAD());
		addressSelectors[14].setB(panelAddress.getAE());
		addressSelectors[15].setB(panelAddress.getAF());

		for (int i = 0; i < 16; i++) {
			addressSelectors[i].step();
		}
	}

	private void stepDataSelectors() {
		dataSelectors[0].setA(externalData.getDO0());
		dataSelectors[1].setA(externalData.getDO1());
		dataSelectors[2].setA(externalData.getDO2());
		dataSelectors[3].setA(externalData.getDO3());
		dataSelectors[4].setA(externalData.getDO4());
		dataSelectors[5].setA(externalData.getDO5());
		dataSelectors[6].setA(externalData.getDO6());
		dataSelectors[7].setA(externalData.getDO7());

		dataSelectors[0].setB(panelData.getDO0());
		dataSelectors[1].setB(panelData.getDO1());
		dataSelectors[2].setB(panelData.getDO2());
		dataSelectors[3].setB(panelData.getDO3());
		dataSelectors[4].setB(panelData.getDO4());
		dataSelectors[5].setB(panelData.getDO5());
		dataSelectors[6].setB(panelData.getDO6());
		dataSelectors[7].setB(panelData.getDO7());

		for (int i = 0; i < 8; i++) {
			dataSelectors[i].step();
		}
	}
}

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
import electroMechanicalLogic.EightBitTwoToOneSelector;
import electroMechanicalLogic.SixteenBitAddressBuffer;
import electroMechanicalLogic.SixtyFourKilobyteRAM;
import electroMechanicalLogic.TwoLineToOneLineSelector;
import electroMechanicalLogic.Interfaces.IEightBitBuffer;
import electroMechanicalLogic.Interfaces.IEightBitTwoToOneSelector;
import electroMechanicalLogic.Interfaces.ISixteenBitAddressBuffer;
import electroMechanicalLogic.Interfaces.ISixtyFourKilobyteRAM;
import electroMechanicalLogic.Interfaces.ITwoLineToOneLineSelector;
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

	private final IEightBitTwoToOneSelector addressInHigh;
	private final IEightBitTwoToOneSelector addressInLow;
	private final IEightBitTwoToOneSelector dataIn;
	private final ITwoLineToOneLineSelector writeSelector;

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
		addressInHigh = new EightBitTwoToOneSelector();
		addressInLow = new EightBitTwoToOneSelector();
		dataIn = new EightBitTwoToOneSelector();
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

		addressInHigh.setPower(value);
		addressInLow.setPower(value);

		dataIn.setPower(value);

		writeSelector.setPower(value);
	}

	@Override
	public void setTakeover(final boolean value) {
		addressInHigh.setSelect(value);
		addressInLow.setSelect(value);
		dataIn.setSelect(value);
		writeSelector.setSelect(value);
	}

	@Override
	public void step() {
		panelAddress.step();
		panelData.step();
		externalAddress.step();
		externalData.step();

		stepAddressIn();
		stepDataIn();

		writeSelector.step();

		stepRam();

		fireOnPropertyChange();
	}

	private void stepAddressIn() {
		addressInLow.setA0(externalAddress.getA0());
		addressInLow.setA1(externalAddress.getA1());
		addressInLow.setA2(externalAddress.getA2());
		addressInLow.setA3(externalAddress.getA3());
		addressInLow.setA4(externalAddress.getA4());
		addressInLow.setA5(externalAddress.getA5());
		addressInLow.setA6(externalAddress.getA6());
		addressInLow.setA7(externalAddress.getA7());
		addressInHigh.setA0(externalAddress.getA8());
		addressInHigh.setA1(externalAddress.getA9());
		addressInHigh.setA2(externalAddress.getAA());
		addressInHigh.setA3(externalAddress.getAB());
		addressInHigh.setA4(externalAddress.getAC());
		addressInHigh.setA5(externalAddress.getAD());
		addressInHigh.setA6(externalAddress.getAE());
		addressInHigh.setA7(externalAddress.getAF());

		addressInLow.setB0(panelAddress.getA0());
		addressInLow.setB1(panelAddress.getA1());
		addressInLow.setB2(panelAddress.getA2());
		addressInLow.setB3(panelAddress.getA3());
		addressInLow.setB4(panelAddress.getA4());
		addressInLow.setB5(panelAddress.getA5());
		addressInLow.setB6(panelAddress.getA6());
		addressInLow.setB7(panelAddress.getA7());
		addressInHigh.setB0(panelAddress.getA8());
		addressInHigh.setB1(panelAddress.getA9());
		addressInHigh.setB2(panelAddress.getAA());
		addressInHigh.setB3(panelAddress.getAB());
		addressInHigh.setB4(panelAddress.getAC());
		addressInHigh.setB5(panelAddress.getAD());
		addressInHigh.setB6(panelAddress.getAE());
		addressInHigh.setB7(panelAddress.getAF());

		addressInLow.step();
		addressInHigh.step();
	}

	private void stepDataIn() {
		dataIn.setA0(externalData.getDO0());
		dataIn.setA1(externalData.getDO1());
		dataIn.setA2(externalData.getDO2());
		dataIn.setA3(externalData.getDO3());
		dataIn.setA4(externalData.getDO4());
		dataIn.setA5(externalData.getDO5());
		dataIn.setA6(externalData.getDO6());
		dataIn.setA7(externalData.getDO7());

		dataIn.setB0(panelData.getDO0());
		dataIn.setB1(panelData.getDO1());
		dataIn.setB2(panelData.getDO2());
		dataIn.setB3(panelData.getDO3());
		dataIn.setB4(panelData.getDO4());
		dataIn.setB5(panelData.getDO5());
		dataIn.setB6(panelData.getDO6());
		dataIn.setB7(panelData.getDO7());

		dataIn.step();
	}

	private void stepRam() {
		ram.setA0(addressInLow.getDO0());
		ram.setA1(addressInLow.getDO1());
		ram.setA2(addressInLow.getDO2());
		ram.setA3(addressInLow.getDO3());
		ram.setA4(addressInLow.getDO4());
		ram.setA5(addressInLow.getDO5());
		ram.setA6(addressInLow.getDO6());
		ram.setA7(addressInLow.getDO7());

		ram.setA8(addressInHigh.getDO0());
		ram.setA9(addressInHigh.getDO1());
		ram.setAA(addressInHigh.getDO2());
		ram.setAB(addressInHigh.getDO3());
		ram.setAC(addressInHigh.getDO4());
		ram.setAD(addressInHigh.getDO5());
		ram.setAE(addressInHigh.getDO6());
		ram.setAF(addressInHigh.getDO7());

		ram.setDI0(dataIn.getDO0());
		ram.setDI1(dataIn.getDO1());
		ram.setDI2(dataIn.getDO2());
		ram.setDI3(dataIn.getDO3());
		ram.setDI4(dataIn.getDO4());
		ram.setDI5(dataIn.getDO5());
		ram.setDI6(dataIn.getDO6());
		ram.setDI7(dataIn.getDO7());

		ram.setW(writeSelector.getDO());

		ram.step();
	}
}

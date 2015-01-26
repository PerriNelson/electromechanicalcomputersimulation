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
import electroMechanicalLogic.DataChannel.EightBitDataPath;
import electroMechanicalLogic.DataChannel.SixteenBitDataPath;
import electroMechanicalLogic.DataChannel.Interfaces.IEightBitDataIn;
import electroMechanicalLogic.DataChannel.Interfaces.ISixteenBitAInput;
import electroMechanicalLogic.Interfaces.IEightBitBuffer;
import electroMechanicalLogic.Interfaces.IEightBitTwoToOneSelector;
import electroMechanicalLogic.Interfaces.ISixteenBitAddressBuffer;
import electroMechanicalLogic.Interfaces.ISixtyFourKilobyteRAM;
import electroMechanicalLogic.Interfaces.ITwoLineToOneLineSelector;
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
		SixteenBitDataPath.AOutToAIn(externalAddress, addressInLow,
				addressInHigh);
		SixteenBitDataPath.AOutToBIn(panelAddress, addressInLow, addressInHigh);

		addressInLow.step();
		addressInHigh.step();
	}

	private void stepDataIn() {
		EightBitDataPath.DataOutToAIn(externalData, dataIn);
		EightBitDataPath.connectEightBitDataOutputToEightBitBInput(panelData, dataIn);

		dataIn.step();
	}

	private void stepRam() {
		SixteenBitDataPath.DataOutToAIn(addressInLow, addressInHigh, ram);
		EightBitDataPath.DataOutToDataIn(dataIn, ram);

		ram.setW(writeSelector.getDO());

		ram.step();
	}
}

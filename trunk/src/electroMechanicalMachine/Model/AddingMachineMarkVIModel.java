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

import electroMechanicalLogic.EightBitDataPath;
import electroMechanicalLogic.EightBitOneToTwoDecoder;
import electroMechanicalLogic.EightBitTwoToOneSelector;
import electroMechanicalLogic.OneLineToTwoLineDecoder;
import electroMechanicalLogic.SixtyFourKilobyteRAM;
import electroMechanicalLogic.Interfaces.IEightBitOneToTwoDecoder;
import electroMechanicalLogic.Interfaces.IEightBitTwoToOneSelector;
import electroMechanicalLogic.Interfaces.IOneLineToTwoLineDecoder;
import electroMechanicalLogic.Interfaces.ISixtyFourKilobyteRAM;
import electroMechanicalMachine.Model.Interfaces.IAddingMachineMarkVIModel;
import electroMechanicalMachine.Model.Interfaces.IMarkVIALU;
import electroMechanicalMachine.Model.Interfaces.IMarkVIInstructionDecoder;
import electroMechanicalMachine.Model.Interfaces.IMarkVITimingAndMemoryWriteControl;
import electroMechanicalMachine.Model.Interfaces.ISixtyFourKilobyteRamControlPanelModel;

public class AddingMachineMarkVIModel implements IAddingMachineMarkVIModel {
	private final EventListenerList eventListeners = new EventListenerList();
	private final ISixtyFourKilobyteRamControlPanelModel code;
	private final ISixtyFourKilobyteRamControlPanelModel data;
	private final IEightBitOneToTwoDecoder addressLow;
	private final IEightBitOneToTwoDecoder addressHigh;
	private final IEightBitOneToTwoDecoder dataIn;
	private final IOneLineToTwoLineDecoder write;
	private final IEightBitTwoToOneSelector dataOut;
	protected IMarkVIInstructionDecoder instructionDecoder;
	protected IMarkVIALU alu;
	private final IMarkVITimingAndMemoryWriteControl timingAndMemoryWriteControl;

	public AddingMachineMarkVIModel() {
		this(new SixtyFourKilobyteRAM(), new SixtyFourKilobyteRAM());
	}

	public AddingMachineMarkVIModel(final ISixtyFourKilobyteRAM codeRAM,
			final ISixtyFourKilobyteRAM dataRAM) {

		addressLow = new EightBitOneToTwoDecoder();
		addressHigh = new EightBitOneToTwoDecoder();
		dataIn = new EightBitOneToTwoDecoder();

		write = new OneLineToTwoLineDecoder();

		dataOut = new EightBitTwoToOneSelector();

		code = new SixtyFourKilobyteRamControlPanelModel(codeRAM);
		data = new SixtyFourKilobyteRamControlPanelModel(dataRAM);

		timingAndMemoryWriteControl = new MarkVITimingAndMemoryWriteControl();
		setALU();
		setInstructionDecoder();
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
		return dataOut.getDO0();
	}

	@Override
	public boolean getDO1() {
		return dataOut.getDO1();
	}

	@Override
	public boolean getDO2() {
		return dataOut.getDO2();
	}

	@Override
	public boolean getDO3() {
		return dataOut.getDO3();
	}

	@Override
	public boolean getDO4() {
		return dataOut.getDO4();
	}

	@Override
	public boolean getDO5() {
		return dataOut.getDO5();
	}

	@Override
	public boolean getDO6() {
		return dataOut.getDO6();
	}

	@Override
	public boolean getDO7() {
		return dataOut.getDO7();
	}

	@Override
	public void removePropertyChangeListener(
			final PropertyChangeListener listener) {
		eventListeners.remove(PropertyChangeListener.class, listener);
	}

	@Override
	public void setA0(final boolean value) {
		addressLow.setDI0(value);
	}

	@Override
	public void setA1(final boolean value) {
		addressLow.setDI1(value);
	}

	@Override
	public void setA2(final boolean value) {
		addressLow.setDI2(value);
	}

	@Override
	public void setA3(final boolean value) {
		addressLow.setDI3(value);
	}

	@Override
	public void setA4(final boolean value) {
		addressLow.setDI4(value);
	}

	@Override
	public void setA5(final boolean value) {
		addressLow.setDI5(value);
	}

	@Override
	public void setA6(final boolean value) {
		addressLow.setDI6(value);
	}

	@Override
	public void setA7(final boolean value) {
		addressLow.setDI7(value);
	}

	@Override
	public void setA8(final boolean value) {
		addressHigh.setDI0(value);
	}

	@Override
	public void setA9(final boolean value) {
		addressHigh.setDI1(value);
	}

	@Override
	public void setAA(final boolean value) {
		addressHigh.setDI2(value);
	}

	@Override
	public void setAB(final boolean value) {
		addressHigh.setDI3(value);
	}

	@Override
	public void setAC(final boolean value) {
		addressHigh.setDI4(value);
	}

	@Override
	public void setAD(final boolean value) {
		addressHigh.setDI5(value);
	}

	@Override
	public void setAE(final boolean value) {
		addressHigh.setDI6(value);
	}

	@Override
	public void setAF(final boolean value) {
		addressHigh.setDI7(value);
	}

	protected void setALU() {
		alu = new MarkVIALU();
	}

	@Override
	public void setDI0(final boolean value) {
		dataIn.setDI0(value);
	}

	@Override
	public void setDI1(final boolean value) {
		dataIn.setDI1(value);
	}

	@Override
	public void setDI2(final boolean value) {
		dataIn.setDI2(value);
	}

	@Override
	public void setDI3(final boolean value) {
		dataIn.setDI3(value);
	}

	@Override
	public void setDI4(final boolean value) {
		dataIn.setDI4(value);
	}

	@Override
	public void setDI5(final boolean value) {
		dataIn.setDI5(value);
	}

	@Override
	public void setDI6(final boolean value) {
		dataIn.setDI6(value);
	}

	@Override
	public void setDI7(final boolean value) {
		dataIn.setDI7(value);
	}

	protected void setInstructionDecoder() {
		instructionDecoder = new MarkVIInstructionDecoder();
	}

	@Override
	public void setPower(final boolean value) {
		code.setPower(value);
		data.setPower(value);

		addressLow.setPower(value);
		addressHigh.setPower(value);

		dataIn.setPower(value);
		write.setPower(value);
		dataOut.setPower(value);

		instructionDecoder.setPower(value);
		alu.setPower(value);
		timingAndMemoryWriteControl.setPower(value);
	}

	@Override
	public void setReset(final boolean value) {
		timingAndMemoryWriteControl.setClear(value);
		alu.setClear(value);
	}

	@Override
	public void setTakeover(final boolean value) {
		code.setCpTakeover(value);
		data.setCpTakeover(value);
	}

	@Override
	public void setUseCodePanel(final boolean value) {
		addressLow.setSelect(value);
		addressHigh.setSelect(value);

		dataIn.setSelect(value);
		write.setSelect(value);

		dataOut.setSelect(value);
	}

	@Override
	public void setW(final boolean value) {
		write.setInput(value);
	}

	@Override
	public void step() {
		stepDecoders();

		stepData();
		stepCode();

		stepInstructionDecoder();
		stepTimingAndMemoryWriteControl();
		stepALU();

		stepDataOut();

		fireOnPropertyChange();
	}

	protected void stepALU() {
		EightBitDataPath.DataOutToDataIn(data, alu);
		alu.setAdd(instructionDecoder.getAdd());
		alu.setLoad(instructionDecoder.getLoad());
		alu.setClock(timingAndMemoryWriteControl.getClock());
		alu.step();
	}

	private void stepCode() {
		code.setCpA0(addressLow.getB0());
		code.setCpA1(addressLow.getB1());
		code.setCpA2(addressLow.getB2());
		code.setCpA3(addressLow.getB3());
		code.setCpA4(addressLow.getB4());
		code.setCpA5(addressLow.getB5());
		code.setCpA6(addressLow.getB6());
		code.setCpA7(addressLow.getB7());
		code.setCpA8(addressHigh.getB0());
		code.setCpA9(addressHigh.getB1());
		code.setCpAA(addressHigh.getB2());
		code.setCpAB(addressHigh.getB3());
		code.setCpAC(addressHigh.getB4());
		code.setCpAD(addressHigh.getB5());
		code.setCpAE(addressHigh.getB6());
		code.setCpAF(addressHigh.getB7());

		code.setEcA0(timingAndMemoryWriteControl.getA0());
		code.setEcA1(timingAndMemoryWriteControl.getA1());
		code.setEcA2(timingAndMemoryWriteControl.getA2());
		code.setEcA3(timingAndMemoryWriteControl.getA3());
		code.setEcA4(timingAndMemoryWriteControl.getA4());
		code.setEcA5(timingAndMemoryWriteControl.getA5());
		code.setEcA6(timingAndMemoryWriteControl.getA6());
		code.setEcA7(timingAndMemoryWriteControl.getA7());
		code.setEcA8(timingAndMemoryWriteControl.getA8());
		code.setEcA9(timingAndMemoryWriteControl.getA9());
		code.setEcAA(timingAndMemoryWriteControl.getAA());
		code.setEcAB(timingAndMemoryWriteControl.getAB());
		code.setEcAC(timingAndMemoryWriteControl.getAC());
		code.setEcAD(timingAndMemoryWriteControl.getAD());
		code.setEcAE(timingAndMemoryWriteControl.getAE());
		code.setEcAF(timingAndMemoryWriteControl.getAF());

		code.setCpDI0(dataIn.getB0());
		code.setCpDI1(dataIn.getB1());
		code.setCpDI2(dataIn.getB2());
		code.setCpDI3(dataIn.getB3());
		code.setCpDI4(dataIn.getB4());
		code.setCpDI5(dataIn.getB5());
		code.setCpDI6(dataIn.getB6());
		code.setCpDI7(dataIn.getB7());

		code.setCpW(write.getB());

		code.step();
	}

	private void stepData() {
		data.setCpA0(addressLow.getA0());
		data.setCpA1(addressLow.getA1());
		data.setCpA2(addressLow.getA2());
		data.setCpA3(addressLow.getA3());
		data.setCpA4(addressLow.getA4());
		data.setCpA5(addressLow.getA5());
		data.setCpA6(addressLow.getA6());
		data.setCpA7(addressLow.getA7());
		data.setCpA8(addressHigh.getA0());
		data.setCpA9(addressHigh.getA1());
		data.setCpAA(addressHigh.getA2());
		data.setCpAB(addressHigh.getA3());
		data.setCpAC(addressHigh.getA4());
		data.setCpAD(addressHigh.getA5());
		data.setCpAE(addressHigh.getA6());
		data.setCpAF(addressHigh.getA7());

		data.setEcA0(timingAndMemoryWriteControl.getA0());
		data.setEcA1(timingAndMemoryWriteControl.getA1());
		data.setEcA2(timingAndMemoryWriteControl.getA2());
		data.setEcA3(timingAndMemoryWriteControl.getA3());
		data.setEcA4(timingAndMemoryWriteControl.getA4());
		data.setEcA5(timingAndMemoryWriteControl.getA5());
		data.setEcA6(timingAndMemoryWriteControl.getA6());
		data.setEcA7(timingAndMemoryWriteControl.getA7());
		data.setEcA8(timingAndMemoryWriteControl.getA8());
		data.setEcA9(timingAndMemoryWriteControl.getA9());
		data.setEcAA(timingAndMemoryWriteControl.getAA());
		data.setEcAB(timingAndMemoryWriteControl.getAB());
		data.setEcAC(timingAndMemoryWriteControl.getAC());
		data.setEcAD(timingAndMemoryWriteControl.getAD());
		data.setEcAE(timingAndMemoryWriteControl.getAE());
		data.setEcAF(timingAndMemoryWriteControl.getAF());

		data.setCpDI0(dataIn.getA0());
		data.setCpDI1(dataIn.getA1());
		data.setCpDI2(dataIn.getA2());
		data.setCpDI3(dataIn.getA3());
		data.setCpDI4(dataIn.getA4());
		data.setCpDI5(dataIn.getA5());
		data.setCpDI6(dataIn.getA6());
		data.setCpDI7(dataIn.getA7());

		data.setEcDI0(alu.getDO0());
		data.setEcDI1(alu.getDO1());
		data.setEcDI2(alu.getDO2());
		data.setEcDI3(alu.getDO3());
		data.setEcDI4(alu.getDO4());
		data.setEcDI5(alu.getDO5());
		data.setEcDI6(alu.getDO6());
		data.setEcDI7(alu.getDO7());

		data.setCpW(write.getA());
		data.setEcW(timingAndMemoryWriteControl.getWrite());

		data.step();
	}

	private void stepDataOut() {
		EightBitDataPath.DataOutToAIn(data, dataOut);
		EightBitDataPath.DataOutToBIn(code, dataOut);
		dataOut.step();
	}

	private void stepDecoders() {
		addressLow.step();
		addressHigh.step();

		dataIn.step();
		write.step();
	}

	private void stepInstructionDecoder() {
		EightBitDataPath.DataOutToDataIn(code, instructionDecoder);
		instructionDecoder.step();
	}

	private void stepTimingAndMemoryWriteControl() {
		timingAndMemoryWriteControl.setHalt(instructionDecoder.getHalt());
		timingAndMemoryWriteControl.setStore(instructionDecoder.getStore());
		timingAndMemoryWriteControl.step();
	}
}

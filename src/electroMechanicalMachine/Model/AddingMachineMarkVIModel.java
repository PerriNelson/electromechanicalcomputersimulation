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
	private final IOneLineToTwoLineDecoder decodeA0;
	private final IOneLineToTwoLineDecoder decodeA1;
	private final IOneLineToTwoLineDecoder decodeA2;
	private final IOneLineToTwoLineDecoder decodeA3;
	private final IOneLineToTwoLineDecoder decodeA4;
	private final IOneLineToTwoLineDecoder decodeA5;
	private final IOneLineToTwoLineDecoder decodeA6;
	private final IOneLineToTwoLineDecoder decodeA7;
	private final IOneLineToTwoLineDecoder decodeA8;
	private final IOneLineToTwoLineDecoder decodeA9;
	private final IOneLineToTwoLineDecoder decodeAA;
	private final IOneLineToTwoLineDecoder decodeAB;
	private final IOneLineToTwoLineDecoder decodeAC;
	private final IOneLineToTwoLineDecoder decodeAD;
	private final IOneLineToTwoLineDecoder decodeAE;
	private final IOneLineToTwoLineDecoder decodeAF;
	private final IEightBitOneToTwoDecoder dataIn;
	private final IOneLineToTwoLineDecoder write;
	private final IEightBitTwoToOneSelector dataOut;
	private final IMarkVIInstructionDecoder instructionDecoder;
	private final IMarkVIALU alu;
	private final IMarkVITimingAndMemoryWriteControl timingAndMemoryWriteControl;

	public AddingMachineMarkVIModel() {
		this(new SixtyFourKilobyteRAM(), new SixtyFourKilobyteRAM());
	}

	public AddingMachineMarkVIModel(final ISixtyFourKilobyteRAM codeRAM,
			final ISixtyFourKilobyteRAM dataRAM) {

		decodeA0 = new OneLineToTwoLineDecoder();
		decodeA1 = new OneLineToTwoLineDecoder();
		decodeA2 = new OneLineToTwoLineDecoder();
		decodeA3 = new OneLineToTwoLineDecoder();
		decodeA4 = new OneLineToTwoLineDecoder();
		decodeA5 = new OneLineToTwoLineDecoder();
		decodeA6 = new OneLineToTwoLineDecoder();
		decodeA7 = new OneLineToTwoLineDecoder();
		decodeA8 = new OneLineToTwoLineDecoder();
		decodeA9 = new OneLineToTwoLineDecoder();
		decodeAA = new OneLineToTwoLineDecoder();
		decodeAB = new OneLineToTwoLineDecoder();
		decodeAC = new OneLineToTwoLineDecoder();
		decodeAD = new OneLineToTwoLineDecoder();
		decodeAE = new OneLineToTwoLineDecoder();
		decodeAF = new OneLineToTwoLineDecoder();

		dataIn = new EightBitOneToTwoDecoder();

		write = new OneLineToTwoLineDecoder();

		dataOut = new EightBitTwoToOneSelector();

		code = new SixtyFourKilobyteRamControlPanelModel(codeRAM);
		data = new SixtyFourKilobyteRamControlPanelModel(dataRAM);

		instructionDecoder = new MarkVIInstructionDecoder();
		alu = new MarkVIALU();
		timingAndMemoryWriteControl = new MarkVITimingAndMemoryWriteControl();
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
		decodeA0.setInput(value);
	}

	@Override
	public void setA1(final boolean value) {
		decodeA1.setInput(value);
	}

	@Override
	public void setA2(final boolean value) {
		decodeA2.setInput(value);
	}

	@Override
	public void setA3(final boolean value) {
		decodeA3.setInput(value);
	}

	@Override
	public void setA4(final boolean value) {
		decodeA4.setInput(value);
	}

	@Override
	public void setA5(final boolean value) {
		decodeA5.setInput(value);
	}

	@Override
	public void setA6(final boolean value) {
		decodeA6.setInput(value);
	}

	@Override
	public void setA7(final boolean value) {
		decodeA7.setInput(value);
	}

	@Override
	public void setA8(final boolean value) {
		decodeA8.setInput(value);
	}

	@Override
	public void setA9(final boolean value) {
		decodeA9.setInput(value);
	}

	@Override
	public void setAA(final boolean value) {
		decodeAA.setInput(value);
	}

	@Override
	public void setAB(final boolean value) {
		decodeAB.setInput(value);
	}

	@Override
	public void setAC(final boolean value) {
		decodeAC.setInput(value);
	}

	@Override
	public void setAD(final boolean value) {
		decodeAD.setInput(value);
	}

	@Override
	public void setAE(final boolean value) {
		decodeAE.setInput(value);
	}

	@Override
	public void setAF(final boolean value) {
		decodeAF.setInput(value);
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

	@Override
	public void setPower(final boolean value) {
		code.setPower(value);
		data.setPower(value);

		decodeA0.setPower(value);
		decodeA1.setPower(value);
		decodeA2.setPower(value);
		decodeA3.setPower(value);
		decodeA4.setPower(value);
		decodeA5.setPower(value);
		decodeA6.setPower(value);
		decodeA7.setPower(value);
		decodeA8.setPower(value);
		decodeA9.setPower(value);
		decodeAA.setPower(value);
		decodeAB.setPower(value);
		decodeAC.setPower(value);
		decodeAD.setPower(value);
		decodeAE.setPower(value);
		decodeAF.setPower(value);

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
		decodeA0.setSelect(value);
		decodeA1.setSelect(value);
		decodeA2.setSelect(value);
		decodeA3.setSelect(value);
		decodeA4.setSelect(value);
		decodeA5.setSelect(value);
		decodeA6.setSelect(value);
		decodeA7.setSelect(value);
		decodeA8.setSelect(value);
		decodeA9.setSelect(value);
		decodeAA.setSelect(value);
		decodeAB.setSelect(value);
		decodeAC.setSelect(value);
		decodeAD.setSelect(value);
		decodeAE.setSelect(value);
		decodeAF.setSelect(value);

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

		stepdata();
		stepCodeRam();

		stepInstructionDecoder();
		stepTimingAndMemoryWriteControl();
		stepALU();

		stepDataOut();

		fireOnPropertyChange();
	}

	private void stepALU() {
		EightBitDataPath.DataOutToDataIn(data, alu);
		alu.setAdd(instructionDecoder.getAdd());
		alu.setLoad(instructionDecoder.getLoad());
		alu.setClock(timingAndMemoryWriteControl.getClock());
		alu.step();
	}

	private void stepCodeRam() {
		code.setCpA0(decodeA0.getB());
		code.setCpA1(decodeA1.getB());
		code.setCpA2(decodeA2.getB());
		code.setCpA3(decodeA3.getB());
		code.setCpA4(decodeA4.getB());
		code.setCpA5(decodeA5.getB());
		code.setCpA6(decodeA6.getB());
		code.setCpA7(decodeA7.getB());
		code.setCpA8(decodeA8.getB());
		code.setCpA9(decodeA9.getB());
		code.setCpAA(decodeAA.getB());
		code.setCpAB(decodeAB.getB());
		code.setCpAC(decodeAC.getB());
		code.setCpAD(decodeAD.getB());
		code.setCpAE(decodeAE.getB());
		code.setCpAF(decodeAF.getB());

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

	private void stepdata() {
		data.setCpA0(decodeA0.getA());
		data.setCpA1(decodeA1.getA());
		data.setCpA2(decodeA2.getA());
		data.setCpA3(decodeA3.getA());
		data.setCpA4(decodeA4.getA());
		data.setCpA5(decodeA5.getA());
		data.setCpA6(decodeA6.getA());
		data.setCpA7(decodeA7.getA());
		data.setCpA8(decodeA8.getA());
		data.setCpA9(decodeA9.getA());
		data.setCpAA(decodeAA.getA());
		data.setCpAB(decodeAB.getA());
		data.setCpAC(decodeAC.getA());
		data.setCpAD(decodeAD.getA());
		data.setCpAE(decodeAE.getA());
		data.setCpAF(decodeAF.getA());

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
		decodeA0.step();
		decodeA1.step();
		decodeA2.step();
		decodeA3.step();
		decodeA4.step();
		decodeA5.step();
		decodeA6.step();
		decodeA7.step();
		decodeA8.step();
		decodeA9.step();
		decodeAA.step();
		decodeAB.step();
		decodeAC.step();
		decodeAD.step();
		decodeAE.step();
		decodeAF.step();

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

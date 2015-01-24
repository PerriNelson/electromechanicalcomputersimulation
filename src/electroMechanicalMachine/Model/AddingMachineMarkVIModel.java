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

import electroMechanicalLogic.OneLineToTwoLineDecoder;
import electroMechanicalLogic.SixtyFourKilobyteRAM;
import electroMechanicalLogic.TwoLineToOneLineSelector;
import electroMechanicalLogic.Interfaces.IOneLineToTwoLineDecoder;
import electroMechanicalLogic.Interfaces.ISixtyFourKilobyteRAM;
import electroMechanicalLogic.Interfaces.ITwoLineToOneLineSelector;
import electroMechanicalMachine.Model.Interfaces.IAddingMachineMarkVIModel;
import electroMechanicalMachine.Model.Interfaces.IMarkVIALU;
import electroMechanicalMachine.Model.Interfaces.IMarkVIInstructionDecoder;
import electroMechanicalMachine.Model.Interfaces.IMarkVITimingAndMemoryWriteControl;
import electroMechanicalMachine.Model.Interfaces.ISixtyFourKilobyteRamControlPanelModel;

public class AddingMachineMarkVIModel implements IAddingMachineMarkVIModel {
	private EventListenerList eventListeners = new EventListenerList();
	private ISixtyFourKilobyteRamControlPanelModel codeRam;
	private ISixtyFourKilobyteRamControlPanelModel dataRam;
	private IOneLineToTwoLineDecoder decodeA0;
	private IOneLineToTwoLineDecoder decodeA1;
	private IOneLineToTwoLineDecoder decodeA2;
	private IOneLineToTwoLineDecoder decodeA3;
	private IOneLineToTwoLineDecoder decodeA4;
	private IOneLineToTwoLineDecoder decodeA5;
	private IOneLineToTwoLineDecoder decodeA6;
	private IOneLineToTwoLineDecoder decodeA7;
	private IOneLineToTwoLineDecoder decodeA8;
	private IOneLineToTwoLineDecoder decodeA9;
	private IOneLineToTwoLineDecoder decodeAA;
	private IOneLineToTwoLineDecoder decodeAB;
	private IOneLineToTwoLineDecoder decodeAC;
	private IOneLineToTwoLineDecoder decodeAD;
	private IOneLineToTwoLineDecoder decodeAE;
	private IOneLineToTwoLineDecoder decodeAF;
	private IOneLineToTwoLineDecoder decodeDI0;
	private IOneLineToTwoLineDecoder decodeDI1;
	private IOneLineToTwoLineDecoder decodeDI2;
	private IOneLineToTwoLineDecoder decodeDI3;
	private IOneLineToTwoLineDecoder decodeDI4;
	private IOneLineToTwoLineDecoder decodeDI5;
	private IOneLineToTwoLineDecoder decodeDI6;
	private IOneLineToTwoLineDecoder decodeDI7;
	private IOneLineToTwoLineDecoder decodeW;
	private ITwoLineToOneLineSelector selectDO0;
	private ITwoLineToOneLineSelector selectDO1;
	private ITwoLineToOneLineSelector selectDO2;
	private ITwoLineToOneLineSelector selectDO3;
	private ITwoLineToOneLineSelector selectDO4;
	private ITwoLineToOneLineSelector selectDO5;
	private ITwoLineToOneLineSelector selectDO6;
	private ITwoLineToOneLineSelector selectDO7;
	private IMarkVIInstructionDecoder instructionDecoder;
	private IMarkVIALU alu;
	private IMarkVITimingAndMemoryWriteControl timingAndMemoryWriteControl;

	public AddingMachineMarkVIModel() {
		this(new SixtyFourKilobyteRAM(), new SixtyFourKilobyteRAM());
	}

	public AddingMachineMarkVIModel(ISixtyFourKilobyteRAM codeRAM,
			ISixtyFourKilobyteRAM dataRAM) {

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

		decodeDI0 = new OneLineToTwoLineDecoder();
		decodeDI1 = new OneLineToTwoLineDecoder();
		decodeDI2 = new OneLineToTwoLineDecoder();
		decodeDI3 = new OneLineToTwoLineDecoder();
		decodeDI4 = new OneLineToTwoLineDecoder();
		decodeDI5 = new OneLineToTwoLineDecoder();
		decodeDI6 = new OneLineToTwoLineDecoder();
		decodeDI7 = new OneLineToTwoLineDecoder();

		decodeW = new OneLineToTwoLineDecoder();

		selectDO0 = new TwoLineToOneLineSelector();
		selectDO1 = new TwoLineToOneLineSelector();
		selectDO2 = new TwoLineToOneLineSelector();
		selectDO3 = new TwoLineToOneLineSelector();
		selectDO4 = new TwoLineToOneLineSelector();
		selectDO5 = new TwoLineToOneLineSelector();
		selectDO6 = new TwoLineToOneLineSelector();
		selectDO7 = new TwoLineToOneLineSelector();

		codeRam = new SixtyFourKilobyteRamControlPanelModel(codeRAM);
		dataRam = new SixtyFourKilobyteRamControlPanelModel(dataRAM);

		instructionDecoder = new MarkVIInstructionDecoder();
		alu = new MarkVIALU();
		timingAndMemoryWriteControl = new MarkVITimingAndMemoryWriteControl();
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
		return selectDO0.getQ();
	}

	@Override
	public boolean getDO1() {
		return selectDO1.getQ();
	}

	@Override
	public boolean getDO2() {
		return selectDO2.getQ();
	}

	@Override
	public boolean getDO3() {
		return selectDO3.getQ();
	}

	@Override
	public boolean getDO4() {
		return selectDO4.getQ();
	}

	@Override
	public boolean getDO5() {
		return selectDO5.getQ();
	}

	@Override
	public boolean getDO6() {
		return selectDO6.getQ();
	}

	@Override
	public boolean getDO7() {
		return selectDO7.getQ();
	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		eventListeners.remove(PropertyChangeListener.class, listener);
	}

	@Override
	public void setA0(boolean value) {
		decodeA0.setInput(value);
	}

	@Override
	public void setA1(boolean value) {
		decodeA1.setInput(value);
	}

	@Override
	public void setA2(boolean value) {
		decodeA2.setInput(value);
	}

	@Override
	public void setA3(boolean value) {
		decodeA3.setInput(value);
	}

	@Override
	public void setA4(boolean value) {
		decodeA4.setInput(value);
	}

	@Override
	public void setA5(boolean value) {
		decodeA5.setInput(value);
	}

	@Override
	public void setA6(boolean value) {
		decodeA6.setInput(value);
	}

	@Override
	public void setA7(boolean value) {
		decodeA7.setInput(value);
	}

	@Override
	public void setA8(boolean value) {
		decodeA8.setInput(value);
	}

	@Override
	public void setA9(boolean value) {
		decodeA9.setInput(value);
	}

	@Override
	public void setAA(boolean value) {
		decodeAA.setInput(value);
	}

	@Override
	public void setAB(boolean value) {
		decodeAB.setInput(value);
	}

	@Override
	public void setAC(boolean value) {
		decodeAC.setInput(value);
	}

	@Override
	public void setAD(boolean value) {
		decodeAD.setInput(value);
	}

	@Override
	public void setAE(boolean value) {
		decodeAE.setInput(value);
	}

	@Override
	public void setAF(boolean value) {
		decodeAF.setInput(value);
	}

	@Override
	public void setDI0(boolean value) {
		decodeDI0.setInput(value);
	}

	@Override
	public void setDI1(boolean value) {
		decodeDI1.setInput(value);
	}

	@Override
	public void setDI2(boolean value) {
		decodeDI2.setInput(value);
	}

	@Override
	public void setDI3(boolean value) {
		decodeDI3.setInput(value);
	}

	@Override
	public void setDI4(boolean value) {
		decodeDI4.setInput(value);
	}

	@Override
	public void setDI5(boolean value) {
		decodeDI5.setInput(value);
	}

	@Override
	public void setDI6(boolean value) {
		decodeDI6.setInput(value);
	}

	@Override
	public void setDI7(boolean value) {
		decodeDI7.setInput(value);
	}

	@Override
	public void setPower(boolean value) {
		codeRam.setPower(value);
		dataRam.setPower(value);

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

		decodeDI0.setPower(value);
		decodeDI1.setPower(value);
		decodeDI2.setPower(value);
		decodeDI3.setPower(value);
		decodeDI4.setPower(value);
		decodeDI5.setPower(value);
		decodeDI6.setPower(value);
		decodeDI7.setPower(value);

		decodeW.setPower(value);

		selectDO0.setPower(value);
		selectDO1.setPower(value);
		selectDO2.setPower(value);
		selectDO3.setPower(value);
		selectDO4.setPower(value);
		selectDO5.setPower(value);
		selectDO6.setPower(value);
		selectDO7.setPower(value);

		instructionDecoder.setPower(value);
		alu.setPower(value);
		timingAndMemoryWriteControl.setPower(value);
	}

	@Override
	public void setReset(boolean value) {
		timingAndMemoryWriteControl.setClear(value);
		alu.setClear(value);
	}

	@Override
	public void setTakeover(boolean value) {
		codeRam.setCpTakeover(value);
		dataRam.setCpTakeover(value);
	}

	@Override
	public void setUseCodePanel(boolean value) {
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

		decodeDI0.setSelect(value);
		decodeDI1.setSelect(value);
		decodeDI2.setSelect(value);
		decodeDI3.setSelect(value);
		decodeDI4.setSelect(value);
		decodeDI5.setSelect(value);
		decodeDI6.setSelect(value);
		decodeDI7.setSelect(value);

		decodeW.setSelect(value);

		selectDO0.setSelect(value);
		selectDO1.setSelect(value);
		selectDO2.setSelect(value);
		selectDO3.setSelect(value);
		selectDO4.setSelect(value);
		selectDO5.setSelect(value);
		selectDO6.setSelect(value);
		selectDO7.setSelect(value);
	}

	@Override
	public void setW(boolean value) {
		decodeW.setInput(value);
	}

	@Override
	public void step() {
		stepDecoders();

		stepDataRam();
		stepCodeRam();

		stepInstructionDecoder();
		stepTimingAndMemoryWriteControl();
		stepALU();

		stepSelectors();

		fireOnPropertyChange();
	}

	private void stepALU() {
		alu.setDI0(dataRam.getDO0());
		alu.setDI1(dataRam.getDO1());
		alu.setDI2(dataRam.getDO2());
		alu.setDI3(dataRam.getDO3());
		alu.setDI4(dataRam.getDO4());
		alu.setDI5(dataRam.getDO5());
		alu.setDI6(dataRam.getDO6());
		alu.setDI7(dataRam.getDO7());
		alu.setAdd(instructionDecoder.getAdd());
		alu.setLoad(instructionDecoder.getLoad());
		alu.setClock(timingAndMemoryWriteControl.getClock());
		alu.step();
	}

	private void stepCodeRam() {
		codeRam.setCpA0(decodeA0.getO1());
		codeRam.setCpA1(decodeA1.getO1());
		codeRam.setCpA2(decodeA2.getO1());
		codeRam.setCpA3(decodeA3.getO1());
		codeRam.setCpA4(decodeA4.getO1());
		codeRam.setCpA5(decodeA5.getO1());
		codeRam.setCpA6(decodeA6.getO1());
		codeRam.setCpA7(decodeA7.getO1());
		codeRam.setCpA8(decodeA8.getO1());
		codeRam.setCpA9(decodeA9.getO1());
		codeRam.setCpAA(decodeAA.getO1());
		codeRam.setCpAB(decodeAB.getO1());
		codeRam.setCpAC(decodeAC.getO1());
		codeRam.setCpAD(decodeAD.getO1());
		codeRam.setCpAE(decodeAE.getO1());
		codeRam.setCpAF(decodeAF.getO1());

		codeRam.setEcA0(timingAndMemoryWriteControl.getA0());
		codeRam.setEcA1(timingAndMemoryWriteControl.getA1());
		codeRam.setEcA2(timingAndMemoryWriteControl.getA2());
		codeRam.setEcA3(timingAndMemoryWriteControl.getA3());
		codeRam.setEcA4(timingAndMemoryWriteControl.getA4());
		codeRam.setEcA5(timingAndMemoryWriteControl.getA5());
		codeRam.setEcA6(timingAndMemoryWriteControl.getA6());
		codeRam.setEcA7(timingAndMemoryWriteControl.getA7());
		codeRam.setEcA8(timingAndMemoryWriteControl.getA8());
		codeRam.setEcA9(timingAndMemoryWriteControl.getA9());
		codeRam.setEcAA(timingAndMemoryWriteControl.getAA());
		codeRam.setEcAB(timingAndMemoryWriteControl.getAB());
		codeRam.setEcAC(timingAndMemoryWriteControl.getAC());
		codeRam.setEcAD(timingAndMemoryWriteControl.getAD());
		codeRam.setEcAE(timingAndMemoryWriteControl.getAE());
		codeRam.setEcAF(timingAndMemoryWriteControl.getAF());

		codeRam.setCpDI0(decodeDI0.getO1());
		codeRam.setCpDI1(decodeDI1.getO1());
		codeRam.setCpDI2(decodeDI2.getO1());
		codeRam.setCpDI3(decodeDI3.getO1());
		codeRam.setCpDI4(decodeDI4.getO1());
		codeRam.setCpDI5(decodeDI5.getO1());
		codeRam.setCpDI6(decodeDI6.getO1());
		codeRam.setCpDI7(decodeDI7.getO1());

		codeRam.setCpW(decodeW.getO1());

		codeRam.step();
	}

	private void stepDataRam() {
		dataRam.setCpA0(decodeA0.getO0());
		dataRam.setCpA1(decodeA1.getO0());
		dataRam.setCpA2(decodeA2.getO0());
		dataRam.setCpA3(decodeA3.getO0());
		dataRam.setCpA4(decodeA4.getO0());
		dataRam.setCpA5(decodeA5.getO0());
		dataRam.setCpA6(decodeA6.getO0());
		dataRam.setCpA7(decodeA7.getO0());
		dataRam.setCpA8(decodeA8.getO0());
		dataRam.setCpA9(decodeA9.getO0());
		dataRam.setCpAA(decodeAA.getO0());
		dataRam.setCpAB(decodeAB.getO0());
		dataRam.setCpAC(decodeAC.getO0());
		dataRam.setCpAD(decodeAD.getO0());
		dataRam.setCpAE(decodeAE.getO0());
		dataRam.setCpAF(decodeAF.getO0());

		dataRam.setEcA0(timingAndMemoryWriteControl.getA0());
		dataRam.setEcA1(timingAndMemoryWriteControl.getA1());
		dataRam.setEcA2(timingAndMemoryWriteControl.getA2());
		dataRam.setEcA3(timingAndMemoryWriteControl.getA3());
		dataRam.setEcA4(timingAndMemoryWriteControl.getA4());
		dataRam.setEcA5(timingAndMemoryWriteControl.getA5());
		dataRam.setEcA6(timingAndMemoryWriteControl.getA6());
		dataRam.setEcA7(timingAndMemoryWriteControl.getA7());
		dataRam.setEcA8(timingAndMemoryWriteControl.getA8());
		dataRam.setEcA9(timingAndMemoryWriteControl.getA9());
		dataRam.setEcAA(timingAndMemoryWriteControl.getAA());
		dataRam.setEcAB(timingAndMemoryWriteControl.getAB());
		dataRam.setEcAC(timingAndMemoryWriteControl.getAC());
		dataRam.setEcAD(timingAndMemoryWriteControl.getAD());
		dataRam.setEcAE(timingAndMemoryWriteControl.getAE());
		dataRam.setEcAF(timingAndMemoryWriteControl.getAF());

		dataRam.setCpDI0(decodeDI0.getO0());
		dataRam.setCpDI1(decodeDI1.getO0());
		dataRam.setCpDI2(decodeDI2.getO0());
		dataRam.setCpDI3(decodeDI3.getO0());
		dataRam.setCpDI4(decodeDI4.getO0());
		dataRam.setCpDI5(decodeDI5.getO0());
		dataRam.setCpDI6(decodeDI6.getO0());
		dataRam.setCpDI7(decodeDI7.getO0());

		dataRam.setEcDI0(alu.getDO0());
		dataRam.setEcDI1(alu.getDO1());
		dataRam.setEcDI2(alu.getDO2());
		dataRam.setEcDI3(alu.getDO3());
		dataRam.setEcDI4(alu.getDO4());
		dataRam.setEcDI5(alu.getDO5());
		dataRam.setEcDI6(alu.getDO6());
		dataRam.setEcDI7(alu.getDO7());

		dataRam.setCpW(decodeW.getO0());
		dataRam.setEcW(timingAndMemoryWriteControl.getWrite());

		dataRam.step();
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

		decodeDI0.step();
		decodeDI1.step();
		decodeDI2.step();
		decodeDI3.step();
		decodeDI4.step();
		decodeDI5.step();
		decodeDI6.step();
		decodeDI7.step();

		decodeW.step();
	}

	private void stepInstructionDecoder() {
		instructionDecoder.setCI0(codeRam.getDO0());
		instructionDecoder.setCI1(codeRam.getDO1());
		instructionDecoder.setCI2(codeRam.getDO2());
		instructionDecoder.setCI3(codeRam.getDO3());
		instructionDecoder.setCI4(codeRam.getDO4());
		instructionDecoder.setCI5(codeRam.getDO5());
		instructionDecoder.setCI6(codeRam.getDO6());
		instructionDecoder.setCI7(codeRam.getDO7());
		instructionDecoder.step();
	}

	private void stepSelectors() {
		selectDO0.setA(dataRam.getDO0());
		selectDO1.setA(dataRam.getDO1());
		selectDO2.setA(dataRam.getDO2());
		selectDO3.setA(dataRam.getDO3());
		selectDO4.setA(dataRam.getDO4());
		selectDO5.setA(dataRam.getDO5());
		selectDO6.setA(dataRam.getDO6());
		selectDO7.setA(dataRam.getDO7());

		selectDO0.setB(codeRam.getDO0());
		selectDO1.setB(codeRam.getDO1());
		selectDO2.setB(codeRam.getDO2());
		selectDO3.setB(codeRam.getDO3());
		selectDO4.setB(codeRam.getDO4());
		selectDO5.setB(codeRam.getDO5());
		selectDO6.setB(codeRam.getDO6());
		selectDO7.setB(codeRam.getDO7());

		selectDO0.step();
		selectDO1.step();
		selectDO2.step();
		selectDO3.step();
		selectDO4.step();
		selectDO5.step();
		selectDO6.step();
		selectDO7.step();
	}

	private void stepTimingAndMemoryWriteControl() {
		timingAndMemoryWriteControl.setHalt(instructionDecoder.getHalt());
		timingAndMemoryWriteControl.setStore(instructionDecoder.getStore());
		timingAndMemoryWriteControl.step();
	}
}

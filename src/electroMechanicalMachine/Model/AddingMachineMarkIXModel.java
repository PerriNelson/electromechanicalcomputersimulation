/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Model;

import static electroMechanicalLogic.DataChannel.EightBitDataPath.connectEightBitAOutputToEightBitDataInput;
import static electroMechanicalLogic.DataChannel.EightBitDataPath.connectEightBitBOutputToEightBitDataInput;
import static electroMechanicalLogic.DataChannel.EightBitDataPath.connectEightBitDataOutputToEightBitAInput;
import static electroMechanicalLogic.DataChannel.EightBitDataPath.connectEightBitDataOutputToEightBitBInput;
import static electroMechanicalLogic.DataChannel.EightBitDataPath.connectEightBitDataOutputToEightBitDataInput;
import static electroMechanicalLogic.DataChannel.SixteenBitDataPath.connectSixteenBitAOutputToSixteenBitAInput;
import static electroMechanicalLogic.DataChannel.SixteenBitDataPath.connectTwoEightBitAOutputsToSixteenBitAInput;
import static electroMechanicalLogic.DataChannel.SixteenBitDataPath.connectTwoEightBitBOutputsToSixteenBitAInput;
import electroMechanicalLogic.EightBitOneToTwoDecoder;
import electroMechanicalLogic.EightBitTwoToOneSelector;
import electroMechanicalLogic.Inverter;
import electroMechanicalLogic.OneLineToTwoLineDecoder;
import electroMechanicalLogic.Oscillator;
import electroMechanicalLogic.Interfaces.IEightBitOneToTwoDecoder;
import electroMechanicalLogic.Interfaces.IEightBitTwoToOneSelector;
import electroMechanicalLogic.Interfaces.IOneLineToTwoLineDecoder;
import electroMechanicalLogic.Interfaces.IOscillator;
import electroMechanicalLogic.Interfaces.IRelay;
import electroMechanicalLogic.RAM.SixtyFourKilobyteRAM;
import electroMechanicalLogic.RAM.Interfaces.ISixtyFourKilobyteRAM;
import electroMechanicalMachine.Model.Interfaces.IAddingMachineMarkVIModel;
import electroMechanicalMachine.Model.Interfaces.IMarkIXInstructionDecoder;
import electroMechanicalMachine.Model.Interfaces.IMarkIXTimingControl;
import electroMechanicalMachine.Model.Interfaces.IMarkVIIIALU;
import electroMechanicalMachine.Model.Interfaces.ISixtyFourKilobyteRamControlPanelModel;

public class AddingMachineMarkIXModel implements IAddingMachineMarkVIModel {
	private final ISixtyFourKilobyteRamControlPanelModel code;
	private final ISixtyFourKilobyteRamControlPanelModel data;
	private final IMarkIXInstructionDecoder instructionDecoder;
	private final IMarkVIIIALU alu;
	private final IMarkIXTimingControl timingControl;
	private final IOscillator clock;
	private final IEightBitOneToTwoDecoder addressLow;
	private final IEightBitOneToTwoDecoder addressHigh;
	private final IEightBitOneToTwoDecoder dataIn;
	private final IOneLineToTwoLineDecoder write;
	private final IEightBitTwoToOneSelector dataOut;
	private final IRelay clearBar;
	private final IRelay clockBar;

	public AddingMachineMarkIXModel() {
		this(new SixtyFourKilobyteRAM(), new SixtyFourKilobyteRAM());
	}

	public AddingMachineMarkIXModel(final ISixtyFourKilobyteRAM codeRAM,
			final ISixtyFourKilobyteRAM dataRAM) {
		code = new SixtyFourKilobyteRamControlPanelModel(codeRAM);
		data = new SixtyFourKilobyteRamControlPanelModel(dataRAM);
		instructionDecoder = new MarkIXInstructionDecoder();
		alu = new MarkVIIIALU();
		timingControl = new MarkIXTimingControl();
		clock = new Oscillator();
		addressLow = new EightBitOneToTwoDecoder();
		addressHigh = new EightBitOneToTwoDecoder();
		dataIn = new EightBitOneToTwoDecoder();
		write = new OneLineToTwoLineDecoder();
		dataOut = new EightBitTwoToOneSelector();
		clearBar = new Inverter();
		clockBar = new Inverter();
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
		instructionDecoder.setPower(value);
		alu.setPower(value);
		timingControl.setPower(value);
		clock.setPower(value);
		addressHigh.setPower(value);
		addressLow.setPower(value);
		dataIn.setPower(value);
		write.setPower(value);
		dataOut.setPower(value);
		clearBar.setPower(value);
		clockBar.setPower(value);
	}

	@Override
	public void setReset(final boolean value) {
		clearBar.setInput(value);
		timingControl.setClear(value);
		instructionDecoder.setClear(value);
		alu.setClear(value);
	}

	@Override
	public void setTakeover(final boolean value) {
		code.setTakeover(value);
		data.setTakeover(value);
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

		stepCode();

		stepTimingControl();
		stepInstructionDecoder();

		stepALU();
		stepData();

		stepDataOut();
	}

	private void stepCode() {
		connectTwoEightBitBOutputsToSixteenBitAInput(addressLow, addressHigh,
				code.getPanelAddressIn());
		connectSixteenBitAOutputToSixteenBitAInput(timingControl,
				code.getExternalAddressIn());
		connectEightBitBOutputToEightBitDataInput(dataIn, code.getPanelDataIn());

		code.setCpW(write.getB());
		code.step();
	}

	private void stepData() {
		connectTwoEightBitAOutputsToSixteenBitAInput(addressLow, addressHigh,
				data.getPanelAddressIn());
		connectSixteenBitAOutputToSixteenBitAInput(instructionDecoder,
				data.getExternalAddressIn());
		connectEightBitAOutputToEightBitDataInput(dataIn, data.getPanelDataIn());
		connectEightBitDataOutputToEightBitDataInput(alu,
				data.getExternalDataIn());

		data.setCpW(write.getA());
		data.setEcW(timingControl.getWrite());

		data.step();
	}

	private void stepDataOut() {
		connectEightBitDataOutputToEightBitAInput(data, dataOut);
		connectEightBitDataOutputToEightBitBInput(code, dataOut);
		dataOut.step();
	}

	private void stepDecoders() {
		addressLow.step();
		addressHigh.step();

		dataIn.step();
		write.step();
	}

	private void stepInstructionDecoder() {
		connectEightBitDataOutputToEightBitDataInput(code, instructionDecoder);
		instructionDecoder.setFetchCode(timingControl.getFetchCode());
		instructionDecoder.setFetchHighAddress(timingControl
				.getFetchHighAddress());
		instructionDecoder.setFetchLowAddress(timingControl
				.getFetchLowAddress());
		instructionDecoder.step();
	}

	private void stepTimingControl() {
		clearBar.step();
		clock.setPower(clearBar.getOutput());
		clock.step();
		timingControl.setClock(clock.getOutput());
		timingControl.setHalt(instructionDecoder.getHalt());
		timingControl.setStore(instructionDecoder.getStore());
		timingControl.step();
	}

	protected void stepALU() {
		connectEightBitDataOutputToEightBitDataInput(data, alu);
		alu.setAdd(instructionDecoder.getAdd());
		alu.setLoad(instructionDecoder.getLoad());
		alu.setAddWithCarry(instructionDecoder.getAddWithCarry());
		alu.setSubtract(instructionDecoder.getSubtract());
		alu.setSubtractWithBorrow(instructionDecoder.getSubtractWithBorrow());
		alu.setClock(timingControl.getExecute());
		alu.step();
	}

}

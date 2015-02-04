/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Model;

import static electroMechanicalLogic.DataChannel.EightBitDataPath.connectEightBitDataOutputToEightBitDataInput;
import static electroMechanicalLogic.DataChannel.SixteenBitDataPath.connectSixteenBitAOutputToSixteenBitAInput;
import electroMechanicalLogic.Inverter;
import electroMechanicalLogic.Oscillator;
import electroMechanicalLogic.Interfaces.IOscillator;
import electroMechanicalLogic.Interfaces.IRelay;
import electroMechanicalLogic.RAM.Interfaces.ISixtyFourKilobyteRAM;
import electroMechanicalMachine.Model.Interfaces.IProcessingMachineModel;
import electroMechanicalMachine.Model.Interfaces.ISixtyFourKilobyteRamControlPanelModel;
import electroMechanicalMachine.Processor.Interfaces.IProcessor;

/**
 * A basic processing machine.
 */
public class ProcessingMachineModel implements IProcessingMachineModel {

	private final IRelay resetBar = new Inverter();
	private final IOscillator clock = new Oscillator();
	private final IProcessor processor;
	private final ISixtyFourKilobyteRamControlPanelModel ram;

	public ProcessingMachineModel(final IProcessor processor,
			final ISixtyFourKilobyteRAM ram) {
		this.processor = processor;
		this.ram = new SixtyFourKilobyteRamControlPanelModel(ram);
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
	public boolean getHalt() {
		return processor.getHalt();
	}

	@Override
	public void setA0(final boolean value) {
		ram.setCpA0(value);
	}

	@Override
	public void setA1(final boolean value) {
		ram.setCpA1(value);
	}

	@Override
	public void setA2(final boolean value) {
		ram.setCpA2(value);
	}

	@Override
	public void setA3(final boolean value) {
		ram.setCpA3(value);
	}

	@Override
	public void setA4(final boolean value) {
		ram.setCpA4(value);
	}

	@Override
	public void setA5(final boolean value) {
		ram.setCpA5(value);
	}

	@Override
	public void setA6(final boolean value) {
		ram.setCpA6(value);
	}

	@Override
	public void setA7(final boolean value) {
		ram.setCpA7(value);
	}

	@Override
	public void setA8(final boolean value) {
		ram.setCpA8(value);
	}

	@Override
	public void setA9(final boolean value) {
		ram.setCpA9(value);
	}

	@Override
	public void setAA(final boolean value) {
		ram.setCpAA(value);
	}

	@Override
	public void setAB(final boolean value) {
		ram.setCpAB(value);
	}

	@Override
	public void setAC(final boolean value) {
		ram.setCpAC(value);
	}

	@Override
	public void setAD(final boolean value) {
		ram.setCpAD(value);
	}

	@Override
	public void setAE(final boolean value) {
		ram.setCpAE(value);
	}

	@Override
	public void setAF(final boolean value) {
		ram.setCpAF(value);
	}

	@Override
	public void setDI0(final boolean value) {
		ram.setCpDI0(value);
	}

	@Override
	public void setDI1(final boolean value) {
		ram.setCpDI1(value);
	}

	@Override
	public void setDI2(final boolean value) {
		ram.setCpDI2(value);
	}

	@Override
	public void setDI3(final boolean value) {
		ram.setCpDI3(value);
	}

	@Override
	public void setDI4(final boolean value) {
		ram.setCpDI4(value);
	}

	@Override
	public void setDI5(final boolean value) {
		ram.setCpDI5(value);
	}

	@Override
	public void setDI6(final boolean value) {
		ram.setCpDI6(value);
	}

	@Override
	public void setDI7(final boolean value) {
		ram.setCpDI7(value);
	}

	@Override
	public void setPower(final boolean value) {
		resetBar.setPower(value);
		processor.setPower(value);
		ram.setPower(value);
	}

	@Override
	public void setReset(final boolean value) {
		resetBar.setInput(value);
		processor.setReset(value);
	}

	@Override
	public void setTakeover(final boolean value) {
		ram.setTakeover(value);
	}

	@Override
	public void setWrite(final boolean value) {
		ram.setCpW(value);
	}

	@Override
	public void step() {
		connectEightBitDataOutputToEightBitDataInput(processor,
				ram.getExternalDataIn());
		connectSixteenBitAOutputToSixteenBitAInput(processor,
				ram.getExternalAddressIn());
		ram.setEcW(processor.getWrite());
		ram.step();

		resetBar.step();

		// This seems a bit odd - if power to the whole machine is off, the
		// clock will be cycling. Since everything else will be off it won't
		// have an affect on the rest of the machine, but it's still somehow
		// wrong.
		clock.setPower(resetBar.getOutput());
		clock.step();

		connectEightBitDataOutputToEightBitDataInput(ram, processor);
		processor.setClock(clock.getOutput());
		processor.step();
	}
}

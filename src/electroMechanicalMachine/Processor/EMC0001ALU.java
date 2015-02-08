/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Processor;

import static electroMechanicalLogic.DataChannel.EightBitDataPath.connectEightBitSumToEightBitDataInput;
import electroMechanicalLogic.EdgeTriggeredLatchWithClear;
import electroMechanicalLogic.Gates.EightInputNOR;
import electroMechanicalLogic.Gates.Interfaces.IEightInputSingleOutputGate;
import electroMechanicalLogic.Interfaces.ILatchWithClear;
import electroMechanicalMachine.Processor.Interfaces.ICarryFlag;
import electroMechanicalMachine.Processor.Interfaces.IZeroFlag;

public class EMC0001ALU extends MarkXALU implements ICarryFlag,
		IZeroFlag {
	private final IEightInputSingleOutputGate zero = new EightInputNOR();
	private final ILatchWithClear zeroFlag = new EdgeTriggeredLatchWithClear();

	@Override
	public boolean getCarryFlag() {
		return carryFlag.getDO();
	}

	@Override
	public boolean getZeroFlag() {
		return zeroFlag.getDO();
	}

	@Override
	public void setPower(final boolean value) {
		super.setPower(value);
		zero.setPower(value);
		zeroFlag.setPower(value);
	}

	@Override
	public void setReset(final boolean value) {
		super.setReset(value);
		zeroFlag.setClr(value);
	}

	@Override
	public void step() {
		super.step();

		connectEightBitSumToEightBitDataInput(adder, zero);
		zero.step();

		zeroFlag.setDI(zero.getOutput());
		zeroFlag.setW(flagControl.getLatchFlags());
		zeroFlag.step();
	}

}

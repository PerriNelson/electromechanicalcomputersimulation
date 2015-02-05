/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Processor;

import static electroMechanicalLogic.DataChannel.SixteenBitDataPath.connectSixteenBitAOutputToSixteenBitAInput;
import electroMechanicalLogic.Gates.TwoInputAND;
import electroMechanicalLogic.Gates.Interfaces.ITwoInputSingleOutputGate;
import electroMechanicalMachine.Processor.Interfaces.IGetJump;
import electroMechanicalMachine.Processor.Interfaces.ISetableProgramCounter;

public class AM0011 extends AM0010 {
	private final ITwoInputSingleOutputGate jump = new TwoInputAND();

	public AM0011() {
		super(new SetableProgramCounter(), new AM0011InstructionDecoder());
	}

	protected ISetableProgramCounter getProgramCounter() {
		return (ISetableProgramCounter) programCounter;
	}

	@Override
	public void setPower(boolean value) {
		super.setPower(value);
		jump.setPower(value);
	}

	@Override
	protected void stepProgramCounter() {
		jump.setA(addressHasBeenLatched.getOutput());
		jump.setB(((IGetJump) instructionDecoder).getJump());
		jump.step();

		connectSixteenBitAOutputToSixteenBitAInput(instructionLatch,
				getProgramCounter());
		getProgramCounter().setJump(jump.getOutput());
		super.stepProgramCounter();
	}

}

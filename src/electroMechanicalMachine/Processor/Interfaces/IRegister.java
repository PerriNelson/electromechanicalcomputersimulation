/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Processor.Interfaces;

import electroMechanicalLogic.DataChannel.Interfaces.IEightBitDataInput;
import electroMechanicalLogic.DataChannel.Interfaces.IEightBitDataOutput;
import electroMechanicalLogic.Interfaces.ISimulatedCircuit;

/**
 * A register is essentially a latch used to store a value in the processor. The
 * accumulator in a processor is a register.
 */
public interface IRegister extends ISimulatedCircuit, IEightBitDataInput,
		IEightBitDataOutput, IResetable {

	/**
	 * Sets a value that indicates whether power is flowing to the "Write"
	 * terminal of the register or not.
	 * 
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setWrite(boolean value);

}

/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Model.Interfaces;

import electroMechanicalLogic.DataChannel.Interfaces.IEightBitDataInput;
import electroMechanicalLogic.DataChannel.Interfaces.IEightBitDataOutput;
import electroMechanicalLogic.DataChannel.Interfaces.ISixteenBitAInput;
import electroMechanicalLogic.Interfaces.ISimulatedCircuit;
import electroMechanicalMachine.Processor.Interfaces.IResetable;

/**
 * A basic processing machine.
 */
public interface IProcessingMachineModel extends IEightBitDataInput,
		IEightBitDataOutput, IResetable, ISimulatedCircuit, ISixteenBitAInput {

	/**
	 * Gets a value indicating whether power is flowing from the "Halt" output
	 * terminal of the processor. If power is flowing from this terminal it
	 * indicates that the processor is halted.
	 * 
	 * @return true to indicate that power is flowing from the terminal; false
	 *         otherwise.
	 */
	public abstract boolean getHalt();

	/**
	 * sets a value indicating whether power is flowing to the "Takeover" input
	 * terminal of the machine. When power is flowing to this terminal, the
	 * machine should respond to its data, write, and address inputs.
	 *
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setTakeover(boolean value);

	/**
	 * sets a value indicating whether power is flowing to the "Write" input
	 * terminal of the machine.
	 *
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setWrite(boolean value);

}

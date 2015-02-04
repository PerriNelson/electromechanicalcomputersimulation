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
import electroMechanicalLogic.DataChannel.Interfaces.ISixteenBitAOutput;
import electroMechanicalLogic.Interfaces.ISimulatedCircuit;

/**
 * A processor is a device driven by a clock that can access an external memory
 * both to read from it and to write to it.
 */
public interface IProcessor extends ISimulatedCircuit, IEightBitDataInput,
		IEightBitDataOutput, IResetable, ISixteenBitAOutput {

	/**
	 * Gets a value indicating whether power is flowing from the "Write" output
	 * terminal of the processor.
	 * 
	 * @return true to indicate that power is flowing from the terminal; false
	 *         otherwise.
	 */
	public abstract boolean getWrite();

	/**
	 * Sets a value indicating whether power is flowing to the "Clock" input
	 * terminal of the processor or not.
	 * 
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setClock(boolean value);

}

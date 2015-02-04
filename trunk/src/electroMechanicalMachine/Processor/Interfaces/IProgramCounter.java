/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Processor.Interfaces;

import electroMechanicalLogic.DataChannel.Interfaces.ISixteenBitAOutput;
import electroMechanicalLogic.Interfaces.ISimulatedCircuit;

/**
 * A basic program counter.
 */
public interface IProgramCounter extends ISimulatedCircuit, ISixteenBitAOutput,
		IResetable {

	/**
	 * Sets a value indicating whether power is flowing to the "Clock" terminal
	 * of the circuit or not.
	 * 
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setClock(boolean value);
}

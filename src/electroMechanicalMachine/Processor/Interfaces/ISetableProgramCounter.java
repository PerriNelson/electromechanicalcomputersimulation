/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Processor.Interfaces;

import electroMechanicalLogic.DataChannel.Interfaces.ISixteenBitAInput;

/**
 * A program counter that can have its address set.
 */
public interface ISetableProgramCounter extends IProgramCounter,
		ISixteenBitAInput {

	/**
	 * Sets a value indicating whether power is flowing to the "Set" input
	 * terminal of the circuit or not. When power is flowing to this terminal
	 * the program counter's address should be set to the input address.
	 * 
	 * @param value
	 *            ; true to indicate that power is flowing to the terminal;
	 *            false otherwise.
	 */
	public abstract void setSet(boolean value);
}

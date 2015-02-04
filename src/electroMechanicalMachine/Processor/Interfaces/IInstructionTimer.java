/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Processor.Interfaces;

import electroMechanicalLogic.Interfaces.ISimulatedCircuit;

/**
 * A basic instruction timer.
 */
public interface IInstructionTimer extends ISimulatedCircuit, IResetable {

	/**
	 * Gets a value indicating whether power is flowing from the "Clock" output
	 * terminal of the circuit or not. As long as the circuit has power and the
	 * "Reset" signal is off, this should actually be the inverse of the clock
	 * input.
	 * 
	 * @return true to indicate that power is flowing from the terminal; false
	 *         otherwise.
	 */
	public abstract boolean getClock();

	/**
	 * Gets a value indicating whether power is flowing from the "ClockBar"
	 * output terminal of the circuit or not. As long as the circuit has power
	 * and the "Reset" signal is off, this should actually be the same as the
	 * clock input.
	 * 
	 * @return true to indicate that power is flowing from the terminal; false
	 *         otherwise.
	 */
	public abstract boolean getClockBar();

	/**
	 * Gets a value indicating whether power is flowing from the "Execute"
	 * output terminal of the circuit or not. When power is flowing from this
	 * terminal it indicates that the execute phase of the instruction cycle is
	 * active.
	 * 
	 * @return true to indicate that power is flowing from the terminal; false
	 *         otherwise.
	 */
	public abstract boolean getExecute();

	/**
	 * Gets a value indicating whether power is flowing from the
	 * "FetchAddressHigh" output terminal of the circuit or not. When power is
	 * flowing from this terminal it indicates that the "fetch address high"
	 * phase of the instruction cycle is active.
	 * 
	 * @return true to indicate that power is flowing from the terminal; false
	 *         otherwise.
	 */
	public abstract boolean getFetchAddressHigh();

	/**
	 * Gets a value indicating whether power is flowing from the
	 * "FetchAddressLow" output terminal of the circuit or not. When power is
	 * flowing from this terminal it indicates that the "fetch address low"
	 * phase of the instruction cycle is active.
	 * 
	 * @return true to indicate that power is flowing from the terminal; false
	 *         otherwise.
	 */
	public abstract boolean getFetchAddressLow();

	/**
	 * Gets a value indicating whether power is flowing from the "FetchCode"
	 * output terminal of the circuit or not. When power is flowing from this
	 * terminal it indicates that the "fetch code" phase of the instruction
	 * cycle is active.
	 * 
	 * @return true to indicate that power is flowing from the terminal; false
	 *         otherwise.
	 */
	public abstract boolean getFetchCode();

	/**
	 * Sets a value indicating whether power is flowing to the "Clock" input
	 * terminal of the circuit or not.
	 *
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setClock(boolean value);

	/**
	 * Sets a value indicating whether power is flowing to the "Halt" input
	 * terminal of the circuit or not.
	 *
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setHalt(boolean value);
}

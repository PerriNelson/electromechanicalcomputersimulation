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
 * Processes instruction signals and a carry out signal to produce a carry in
 * signal.
 */
public interface ICarryControl extends ISimulatedCircuit {

	/**
	 * Gets a value indicating whether the "Carry In" terminal of the circuit
	 * has power flowing from it or not. Typically this output would be used to
	 * set the carry input signal to an adder.
	 *
	 * @return true indicates that power is flowing from the terminal; false
	 *         indicates that it is not.
	 */
	public abstract boolean getCarryIn();

	/**
	 * Sets a value indicating whether power is flowing to the "Add With Carry"
	 * input terminal of the circuit or not. When power is flowing to this
	 * terminal it typically indicates that the current instruction is
	 * "Add With Carry".
	 *
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setAddWithCarry(boolean value);

	/**
	 * Sets a value indicating whether power is flowing to the "Carry Out" input
	 * terminal of the circuit or not. When power is flowing to this terminal it
	 * typically indicates that the result of the last addition or subtraction
	 * resulted in a carry or overflow.
	 *
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setCarryFlag(boolean value);

	/**
	 * Sets a value indicating whether power is flowing to the "Subtract" input
	 * terminal of the circuit or not. When power is flowing to this terminal it
	 * typically indicates that the current instruction is "Subtract".
	 *
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setSubtract(boolean value);

	/**
	 * Sets a value indicating whether power is flowing to the
	 * "Subtract With Borrow" input terminal of the circuit or not. When power
	 * is flowing to this terminal it typically indicates that the current
	 * instruction is "Subtract With Borrow".
	 *
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setSubtractWithBorrow(boolean value);

}
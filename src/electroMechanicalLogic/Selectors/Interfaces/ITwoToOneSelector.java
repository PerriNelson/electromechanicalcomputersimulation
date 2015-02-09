/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */
package electroMechanicalLogic.Selectors.Interfaces;

import electroMechanicalLogic.Interfaces.ISimulatedCircuit;

/**
 * A circuit that "selects" between two inputs to produce one output.
 */
public interface ITwoToOneSelector extends ISimulatedCircuit {

	/**
	 * Gets a value indicating whether power is flowing from the "DO" output
	 * terminal of the circuit or not.
	 * 
	 * @return true indicates that power is flowing from the terminal; false
	 *         otherwise.
	 */
	public abstract boolean getDO();

	/**
	 * Sets a value indicating whether power is flowing to the "A" input
	 * terminal of the circuit or not.
	 * 
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setA(boolean value);

	/**
	 * Sets a value indicating whether power is flowing to the "B" input
	 * terminal of the circuit or not.
	 * 
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setB(boolean value);

	/**
	 * Sets a value indicating whether power is flowing to the "Select" input
	 * terminal of the circuit or not. When power is flowing to this terminal
	 * the circuit's output ("DO") should match its "B" input. When no power is
	 * flowing to this terminal the circuit's output should match its "A" input.
	 * 
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setSelect(boolean value);
}

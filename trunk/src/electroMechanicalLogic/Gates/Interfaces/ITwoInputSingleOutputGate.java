/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */
package electroMechanicalLogic.Gates.Interfaces;

import electroMechanicalLogic.Interfaces.ISimulatedCircuit;

/**
 * A basic logic gate with two inputs and one output.
 */
public interface ITwoInputSingleOutputGate extends ISimulatedCircuit {
	/**
	 * Retrieves a value indicating the result of the logical operation
	 * implemented by this gate upon its inputs.
	 * 
	 * @return true indicating that power is flowing from the output terminal of
	 *         the gate; false indicating that power is not flowing from the
	 *         output terminal of the gate.
	 */
	public abstract boolean getOutput();

	/**
	 * Sets a value indicating whether power is flowing to the "A" terminal of
	 * the gate or not.
	 * 
	 * @param value
	 *            true to indicate that power is flowing to the "A" terminal of
	 *            the gate; false to indicate that it is not.
	 */
	public abstract void setA(boolean value);

	/**
	 * Sets a value indicating whether power is flowing to the "B" terminal of
	 * the gate or not.
	 * 
	 * @param value
	 *            true to indicate that power is flowing to the "B" terminal of
	 *            the gate; false to indicate that it is not.
	 */
	public abstract void setB(boolean value);
}
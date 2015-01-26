/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.Interfaces;

/**
 * A simulated electrical circuit.
 */
public interface ISimulatedCircuit {
	/**
	 * Sets a value indicating whether power is flowing to the circuit or not.
	 * All electrical circuits require power to operate. For the purposes of our
	 * simulation it is assumed that all circuits are connected to a common
	 * ground to complete the circuit.
	 * 
	 * @param value
	 *            true to indicate that power is flowing to the circuit; false
	 *            to indicate that it is not.
	 */
	public abstract void setPower(boolean value);

	/**
	 * Causes the simulated circuit to process all of its inputs to yield its
	 * outputs. 
	 */
	public abstract void step();
}

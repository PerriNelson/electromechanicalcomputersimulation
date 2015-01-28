/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.FlipFlops.Interfaces;

/**
 * Outputs common to all flip-flops
 */
public interface IFlipFlopOutput {

	/**
	 * Retrieves a value indicating whether power is flowing to the "Q" output
	 * terminal of the circuit.
	 * 
	 * @return true to indicate power is flowing through the output terminal;
	 *         false otherwise.
	 */
	public abstract boolean getQ();

	/**
	 * Retrieves a value indicating whether power is flowing to the "Q-bar"
	 * output terminal of the circuit. Unless the power is off the "Q-bar"
	 * output should always be the opposite of the "Q" output.
	 * 
	 * @return true to indicate power is flowing through the output terminal;
	 *         false otherwise.
	 */
	public abstract boolean getQBar();

}
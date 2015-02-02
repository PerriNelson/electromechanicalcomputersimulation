/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */
package electroMechanicalLogic.Interfaces;

/**
 * A simulated electromechanical relay based on a model of the telegraph relay.
 */
public interface IRelay extends ISimulatedCircuit {
	/**
	 * Retrieves a value indicating whether power is flowing from the relay's
	 * output terminal or not.
	 *
	 * @return true indicates that power is flowing from the relay's output
	 *         terminal; false indicates that it is not.
	 */
	public abstract boolean getOutput();

	/**
	 * Sets a value indicating whether power is flowing into the relay's input
	 * terminal.
	 *
	 * @param value
	 *            true to indicate that power is flowing into the relay's input
	 *            terminal; false to indicate that it is not.
	 */
	public abstract void setInput(boolean value);
}
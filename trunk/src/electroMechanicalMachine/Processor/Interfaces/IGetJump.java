/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Processor.Interfaces;

/**
 * Circuits that implement this interface have a "Jump" output terminal.
 */
public interface IGetJump {

	/**
	 * Gets a value indicating whether power is flowing from the "Jump" output
	 * terminal of the circuit or not.
	 * 
	 * @return true indicates that power is flowing from the terminal; false
	 *         indicates that it is not.
	 */
	public abstract boolean getJump();
}

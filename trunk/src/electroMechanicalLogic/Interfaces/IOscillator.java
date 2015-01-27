/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.Interfaces;

/**
 * An oscillator is a circuit where the output alternates between on and off as
 * long as power is flowing to it.
 */
public interface IOscillator extends ISimulatedCircuit {
	/**
	 * Retrieves a value indicating whether power is flowing from the
	 * oscillator's output terminal or not.
	 * 
	 * @return true indicates that power is flowing from the oscillator's output
	 *         terminal; false indicates that it is not.
	 */
	public abstract boolean getOutput();
}

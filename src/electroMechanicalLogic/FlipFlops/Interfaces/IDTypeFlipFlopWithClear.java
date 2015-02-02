/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.FlipFlops.Interfaces;

/**
 * A D type flip-flop with a clear input. The clear input will clear the
 * contents of the flip-flop regardless of the state of its other inputs.
 */
public interface IDTypeFlipFlopWithClear extends IDTypeFlipFlop {

	/**
	 * Sets a value indicating the state of the "Clear" input. This is done by
	 * turning power to the "Clear" terminal on or off.
	 *
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setClear(boolean value);
}

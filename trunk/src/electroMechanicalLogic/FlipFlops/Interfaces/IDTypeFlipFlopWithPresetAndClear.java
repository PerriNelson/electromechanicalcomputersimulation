/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.FlipFlops.Interfaces;

/**
 * A D type flip-flop with both a clear and a preset input. Setting the Preset
 * input causes the Q output of the flip-flop to be true regardless of the other
 * inputs. Only one of Preset or Clear should be on at a given time or the
 * output state may be invalid.
 */
public interface IDTypeFlipFlopWithPresetAndClear extends
		IDTypeFlipFlopWithClear {

	/**
	 * Sets a value indicating the state of the "Preset" input. This is done by
	 * turning power to the "Preset" terminal on or off.
	 *
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setPreset(boolean value);
}

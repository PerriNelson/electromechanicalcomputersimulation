/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.Gates.Interfaces;

/**
 * A logic gate with three inputs and one output.
 */
public interface IThreeInputSingleOutputGate extends ITwoInputSingleOutputGate {

	/**
	 * Sets a value indicating whether power is flowing to the "C" terminal of
	 * the gate or not.
	 *
	 * @param value
	 *            true to indicate that power is flowing to the "C" terminal of
	 *            the gate; false to indicate that it is not.
	 */
	public abstract void setC(boolean value);
}

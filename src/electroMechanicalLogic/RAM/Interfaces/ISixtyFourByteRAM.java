/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.RAM.Interfaces;

/**
 * A sixty four byte random access memory.
 */
public interface ISixtyFourByteRAM extends IEightByteRAM {

	/**
	 * Sets a value indicating whether power is flowing to the "A3" terminal of
	 * the circuit or not. The "A3" terminal represents bit 3 of the address to
	 * the RAM.
	 *
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setA3(boolean value);

	/**
	 * Sets a value indicating whether power is flowing to the "A4" terminal of
	 * the circuit or not. The "A4" terminal represents bit 4 of the address to
	 * the RAM.
	 *
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setA4(boolean value);

	/**
	 * Sets a value indicating whether power is flowing to the "A5" terminal of
	 * the circuit or not. The "A5" terminal represents bit 5 of the address to
	 * the RAM.
	 *
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setA5(boolean value);
}

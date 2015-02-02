/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.RAM.Interfaces;

import electroMechanicalLogic.Interfaces.IEightBitLatch;

/**
 * An eight byte random access memory.
 */
public interface IEightByteRAM extends IEightBitLatch {

	/**
	 * Sets a value indicating whether power is flowing to the "A0" terminal of
	 * the circuit or not. The "A0" terminal represents bit 0 of the address to
	 * the RAM.
	 *
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setA0(boolean value);

	/**
	 * Sets a value indicating whether power is flowing to the "A1" terminal of
	 * the circuit or not. The "A1" terminal represents bit 1 of the address to
	 * the RAM.
	 *
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setA1(boolean value);

	/**
	 * Sets a value indicating whether power is flowing to the "A2" terminal of
	 * the circuit or not. The "A2" terminal represents bit 2 of the address to
	 * the RAM.
	 *
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setA2(boolean value);
}

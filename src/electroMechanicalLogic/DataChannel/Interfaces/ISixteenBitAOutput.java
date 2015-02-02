/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.DataChannel.Interfaces;

/**
 * A sixteen bit wide "A" output generally used for addresses.
 */
public interface ISixteenBitAOutput {

	/**
	 * Gets a value indicating if bit 0 of the "A" output is on or not.
	 *
	 * @return true indicates the bit is on; false indicates it is off.
	 */
	public abstract boolean getA0();

	/**
	 * Gets a value indicating if bit 1 of the "A" output is on or not.
	 *
	 * @return true indicates the bit is on; false indicates it is off.
	 */
	public abstract boolean getA1();

	/**
	 * Gets a value indicating if bit 2 of the "A" output is on or not.
	 *
	 * @return true indicates the bit is on; false indicates it is off.
	 */
	public abstract boolean getA2();

	/**
	 * Gets a value indicating if bit 3 of the "A" output is on or not.
	 *
	 * @return true indicates the bit is on; false indicates it is off.
	 */
	public abstract boolean getA3();

	/**
	 * Gets a value indicating if bit 4 of the "A" output is on or not.
	 *
	 * @return true indicates the bit is on; false indicates it is off.
	 */
	public abstract boolean getA4();

	/**
	 * Gets a value indicating if bit 5 of the "A" output is on or not.
	 *
	 * @return true indicates the bit is on; false indicates it is off.
	 */
	public abstract boolean getA5();

	/**
	 * Gets a value indicating if bit 6 of the "A" output is on or not.
	 *
	 * @return true indicates the bit is on; false indicates it is off.
	 */
	public abstract boolean getA6();

	/**
	 * Gets a value indicating if bit 7 of the "A" output is on or not.
	 *
	 * @return true indicates the bit is on; false indicates it is off.
	 */
	public abstract boolean getA7();

	/**
	 * Gets a value indicating if bit 8 of the "A" output is on or not.
	 *
	 * @return true indicates the bit is on; false indicates it is off.
	 */
	public abstract boolean getA8();

	/**
	 * Gets a value indicating if bit 9 of the "A" output is on or not.
	 *
	 * @return true indicates the bit is on; false indicates it is off.
	 */
	public abstract boolean getA9();

	/**
	 * Gets a value indicating if bit 10 of the "A" output is on or not.
	 *
	 * @return true indicates the bit is on; false indicates it is off.
	 */
	public abstract boolean getAA();

	/**
	 * Gets a value indicating if bit 11 of the "A" output is on or not.
	 *
	 * @return true indicates the bit is on; false indicates it is off.
	 */
	public abstract boolean getAB();

	/**
	 * Gets a value indicating if bit 12 of the "A" output is on or not.
	 *
	 * @return true indicates the bit is on; false indicates it is off.
	 */
	public abstract boolean getAC();

	/**
	 * Gets a value indicating if bit 13 of the "A" output is on or not.
	 *
	 * @return true indicates the bit is on; false indicates it is off.
	 */
	public abstract boolean getAD();

	/**
	 * Gets a value indicating if bit 14 of the "A" output is on or not.
	 *
	 * @return true indicates the bit is on; false indicates it is off.
	 */
	public abstract boolean getAE();

	/**
	 * Gets a value indicating if bit 15 of the "A" output is on or not.
	 *
	 * @return true indicates the bit is on; false indicates it is off.
	 */
	public abstract boolean getAF();

}

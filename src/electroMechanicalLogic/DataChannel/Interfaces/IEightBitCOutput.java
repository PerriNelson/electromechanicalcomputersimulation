/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.DataChannel.Interfaces;

/**
 * An eight bit wide "C" output such as from an instruction latch.
 */
public interface IEightBitCOutput {

	/**
	 * Gets a value indicating if bit 0 of the "C" output is on or not.
	 *
	 * @return true indicates the bit is on; false indicates it is off.
	 */
	public abstract boolean getC0();

	/**
	 * Gets a value indicating if bit 1 of the "C" output is on or not.
	 *
	 * @return true indicates the bit is on; false indicates it is off.
	 */
	public abstract boolean getC1();

	/**
	 * Gets a value indicating if bit 2 of the "C" output is on or not.
	 *
	 * @return true indicates the bit is on; false indicates it is off.
	 */
	public abstract boolean getC2();

	/**
	 * Gets a value indicating if bit 3 of the "C" output is on or not.
	 *
	 * @return true indicates the bit is on; false indicates it is off.
	 */
	public abstract boolean getC3();

	/**
	 * Gets a value indicating if bit 4 of the "C" output is on or not.
	 *
	 * @return true indicates the bit is on; false indicates it is off.
	 */
	public abstract boolean getC4();

	/**
	 * Gets a value indicating if bit 5 of the "C" output is on or not.
	 *
	 * @return true indicates the bit is on; false indicates it is off.
	 */
	public abstract boolean getC5();

	/**
	 * Gets a value indicating if bit 6 of the "C" output is on or not.
	 *
	 * @return true indicates the bit is on; false indicates it is off.
	 */
	public abstract boolean getC6();

	/**
	 * Gets a value indicating if bit 7 of the "C" output is on or not.
	 *
	 * @return true indicates the bit is on; false indicates it is off.
	 */
	public abstract boolean getC7();

}

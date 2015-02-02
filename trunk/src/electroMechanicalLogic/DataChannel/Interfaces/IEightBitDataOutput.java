/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.DataChannel.Interfaces;

/**
 * An eight bit wide "Data" output such as from a latch.
 */
public interface IEightBitDataOutput {

	/**
	 * Gets a value indicating if bit 0 of the "Data" output is on or not.
	 *
	 * @return true indicates the bit is on; false indicates it is off.
	 */
	public abstract boolean getDO0();

	/**
	 * Gets a value indicating if bit 1 of the "Data" output is on or not.
	 *
	 * @return true indicates the bit is on; false indicates it is off.
	 */
	public abstract boolean getDO1();

	/**
	 * Gets a value indicating if bit 2 of the "Data" output is on or not.
	 *
	 * @return true indicates the bit is on; false indicates it is off.
	 */
	public abstract boolean getDO2();

	/**
	 * Gets a value indicating if bit 3 of the "Data" output is on or not.
	 *
	 * @return true indicates the bit is on; false indicates it is off.
	 */
	public abstract boolean getDO3();

	/**
	 * Gets a value indicating if bit 4 of the "Data" output is on or not.
	 *
	 * @return true indicates the bit is on; false indicates it is off.
	 */
	public abstract boolean getDO4();

	/**
	 * Gets a value indicating if bit 5 of the "Data" output is on or not.
	 *
	 * @return true indicates the bit is on; false indicates it is off.
	 */
	public abstract boolean getDO5();

	/**
	 * Gets a value indicating if bit 6 of the "Data" output is on or not.
	 *
	 * @return true indicates the bit is on; false indicates it is off.
	 */
	public abstract boolean getDO6();

	/**
	 * Gets a value indicating if bit 7 of the "Data" output is on or not.
	 *
	 * @return true indicates the bit is on; false indicates it is off.
	 */
	public abstract boolean getDO7();

}

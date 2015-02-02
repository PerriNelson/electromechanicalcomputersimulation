/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.DataChannel.Interfaces;

/**
 * An eight bit wide "Data" input such as on a latch.
 */
public interface IEightBitDataInput {

	/**
	 * Sets a value that turns bit 0 of the "Data" input on or off.
	 *
	 * @param value
	 *            true to turn the bit on; false to turn it off.
	 */
	public abstract void setDI0(boolean value);

	/**
	 * Sets a value that turns bit 1 of the "Data" input on or off.
	 *
	 * @param value
	 *            true to turn the bit on; false to turn it off.
	 */
	public abstract void setDI1(boolean value);

	/**
	 * Sets a value that turns bit 2 of the "Data" input on or off.
	 *
	 * @param value
	 *            true to turn the bit on; false to turn it off.
	 */
	public abstract void setDI2(boolean value);

	/**
	 * Sets a value that turns bit 3 of the "Data" input on or off.
	 *
	 * @param value
	 *            true to turn the bit on; false to turn it off.
	 */
	public abstract void setDI3(boolean value);

	/**
	 * Sets a value that turns bit 4 of the "Data" input on or off.
	 *
	 * @param value
	 *            true to turn the bit on; false to turn it off.
	 */
	public abstract void setDI4(boolean value);

	/**
	 * Sets a value that turns bit 5 of the "Data" input on or off.
	 *
	 * @param value
	 *            true to turn the bit on; false to turn it off.
	 */
	public abstract void setDI5(boolean value);

	/**
	 * Sets a value that turns bit 6 of the "Data" input on or off.
	 *
	 * @param value
	 *            true to turn the bit on; false to turn it off.
	 */
	public abstract void setDI6(boolean value);

	/**
	 * Sets a value that turns bit 7 of the "Data" input on or off.
	 *
	 * @param value
	 *            true to turn the bit on; false to turn it off.
	 */
	public abstract void setDI7(boolean value);
}

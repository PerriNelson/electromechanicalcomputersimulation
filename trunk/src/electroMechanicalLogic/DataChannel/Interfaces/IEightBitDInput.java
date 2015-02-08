/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.DataChannel.Interfaces;

/**
 * An eight bit "D" input typical of an instruction decoder.
 */
public interface IEightBitDInput {

	/**
	 * Sets a value that turns bit 0 of the "D" input on or off.
	 *
	 * @param value
	 *            true to turn the bit on; false to turn it off.
	 */
	public abstract void setD0(boolean value);

	/**
	 * Sets a value that turns bit 1 of the "D" input on or off.
	 *
	 * @param value
	 *            true to turn the bit on; false to turn it off.
	 */
	public abstract void setD1(boolean value);

	/**
	 * Sets a value that turns bit 2 of the "D" input on or off.
	 *
	 * @param value
	 *            true to turn the bit on; false to turn it off.
	 */
	public abstract void setD2(boolean value);

	/**
	 * Sets a value that turns bit 3 of the "D" input on or off.
	 *
	 * @param value
	 *            true to turn the bit on; false to turn it off.
	 */
	public abstract void setD3(boolean value);

	/**
	 * Sets a value that turns bit 4 of the "D" input on or off.
	 *
	 * @param value
	 *            true to turn the bit on; false to turn it off.
	 */
	public abstract void setD4(boolean value);

	/**
	 * Sets a value that turns bit 5 of the "D" input on or off.
	 *
	 * @param value
	 *            true to turn the bit on; false to turn it off.
	 */
	public abstract void setD5(boolean value);

	/**
	 * Sets a value that turns bit 6 of the "D" input on or off.
	 *
	 * @param value
	 *            true to turn the bit on; false to turn it off.
	 */
	public abstract void setD6(boolean value);

	/**
	 * Sets a value that turns bit 7 of the "D" input on or off.
	 *
	 * @param value
	 *            true to turn the bit on; false to turn it off.
	 */
	public abstract void setD7(boolean value);
}

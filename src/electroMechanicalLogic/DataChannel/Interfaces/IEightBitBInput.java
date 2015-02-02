/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.DataChannel.Interfaces;

/**
 * An eight bit wide "B" input such as on a selector or an adder.
 */
public interface IEightBitBInput {

	/**
	 * Sets a value that turns bit 0 of the "A" input on or off.
	 *
	 * @param value
	 *            true to turn the bit on; false to turn it off.
	 */
	public abstract void setB0(boolean value);

	/**
	 * Sets a value that turns bit 1 of the "B" input on or off.
	 *
	 * @param value
	 *            true to turn the bit on; false to turn it off.
	 */
	public abstract void setB1(boolean value);

	/**
	 * Sets a value that turns bit 2 of the "B" input on or off.
	 *
	 * @param value
	 *            true to turn the bit on; false to turn it off.
	 */
	public abstract void setB2(boolean value);

	/**
	 * Sets a value that turns bit 3 of the "B" input on or off.
	 *
	 * @param value
	 *            true to turn the bit on; false to turn it off.
	 */
	public abstract void setB3(boolean value);

	/**
	 * Sets a value that turns bit 4 of the "B" input on or off.
	 *
	 * @param value
	 *            true to turn the bit on; false to turn it off.
	 */
	public abstract void setB4(boolean value);

	/**
	 * Sets a value that turns bit 5 of the "B" input on or off.
	 *
	 * @param value
	 *            true to turn the bit on; false to turn it off.
	 */
	public abstract void setB5(boolean value);

	/**
	 * Sets a value that turns bit 6 of the "B" input on or off.
	 *
	 * @param value
	 *            true to turn the bit on; false to turn it off.
	 */
	public abstract void setB6(boolean value);

	/**
	 * Sets a value that turns bit 7 of the "B" input on or off.
	 *
	 * @param value
	 *            true to turn the bit on; false to turn it off.
	 */
	public abstract void setB7(boolean value);

}
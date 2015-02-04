/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.DataChannel.Interfaces;

/**
 * An eight bit "C" input typical of an instruction decoder.
 */
public interface IEightBitCInput {

	/**
	 * Sets a value that turns bit 0 of the "C" input on or off.
	 *
	 * @param value
	 *            true to turn the bit on; false to turn it off.
	 */
	public abstract void setC0(boolean value);

	/**
	 * Sets a value that turns bit 1 of the "C" input on or off.
	 *
	 * @param value
	 *            true to turn the bit on; false to turn it off.
	 */
	public abstract void setC1(boolean value);

	/**
	 * Sets a value that turns bit 2 of the "C" input on or off.
	 *
	 * @param value
	 *            true to turn the bit on; false to turn it off.
	 */
	public abstract void setC2(boolean value);

	/**
	 * Sets a value that turns bit 3 of the "C" input on or off.
	 *
	 * @param value
	 *            true to turn the bit on; false to turn it off.
	 */
	public abstract void setC3(boolean value);

	/**
	 * Sets a value that turns bit 4 of the "C" input on or off.
	 *
	 * @param value
	 *            true to turn the bit on; false to turn it off.
	 */
	public abstract void setC4(boolean value);

	/**
	 * Sets a value that turns bit 5 of the "C" input on or off.
	 *
	 * @param value
	 *            true to turn the bit on; false to turn it off.
	 */
	public abstract void setC5(boolean value);

	/**
	 * Sets a value that turns bit 6 of the "C" input on or off.
	 *
	 * @param value
	 *            true to turn the bit on; false to turn it off.
	 */
	public abstract void setC6(boolean value);

	/**
	 * Sets a value that turns bit 7 of the "C" input on or off.
	 *
	 * @param value
	 *            true to turn the bit on; false to turn it off.
	 */
	public abstract void setC7(boolean value);
}

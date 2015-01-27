/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */
package electroMechanicalLogic.Interfaces;

/**
 * A full adder is a circuit that accepts two binary inputs and a binary carry
 * input and produces the result of adding them together, a sum and a carry bit.
 */
public interface IFullAdder extends IHalfAdder {

	/**
	 * Sets a value representing the carry input to the addition.
	 * 
	 * @param value
	 *            true to indicate that the carry input is a one; false to
	 *            indicate that it is a zero.
	 */
	public abstract void setCI(boolean value);
}
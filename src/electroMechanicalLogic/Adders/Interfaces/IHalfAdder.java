/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */
package electroMechanicalLogic.Adders.Interfaces;

import electroMechanicalLogic.Interfaces.ISimulatedCircuit;

/**
 * A half adder is a circuit that accepts two binary inputs and produces the
 * result of adding them together, a sum and a carry bit. Half adders do not
 * account for an incoming carry bit.
 */
public interface IHalfAdder extends ISimulatedCircuit {

	/**
	 * Gets a value indicating whether the addition of the two binary inputs
	 * produced a carry bit or not.
	 * 
	 * @return true indicates that the addition of the two binary digits
	 *         resulted in a carry; false indicates that it did not.
	 */
	public abstract boolean getCO();

	/**
	 * Gets a value containing the sum of the two binary inputs without the
	 * carry bit.
	 * 
	 * @return true indicates that the sum is one; false indicates that it is
	 *         zero.
	 */
	public abstract boolean getS();

	/**
	 * Sets a value representing the first of the two binary digits to be added.
	 * 
	 * @param value
	 *            true to indicate that the binary digit is a one; false to
	 *            indicate that it is a zero.
	 */
	public abstract void setA(boolean value);

	/**
	 * Sets a value representing the second of the two binary digits to be
	 * added.
	 * 
	 * @param value
	 *            true to indicate that the binary digit is a one; false to
	 *            indicate that it is a zero.
	 */
	public abstract void setB(boolean value);
}
/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */
package electroMechanicalLogic.Adders.Interfaces;

import electroMechanicalLogic.DataChannel.Interfaces.IEightBitAInput;
import electroMechanicalLogic.DataChannel.Interfaces.IEightBitBInput;
import electroMechanicalLogic.DataChannel.Interfaces.IEightBitSumOutput;
import electroMechanicalLogic.Interfaces.ISimulatedCircuit;

/**
 * An eight bit adder accepts two eight bit inputs and a carry input bit and
 * produces an eight bit sum with a carry output bit.
 */
public interface IEightBitAdder extends ISimulatedCircuit, IEightBitAInput,
		IEightBitBInput, IEightBitSumOutput {

	/**
	 * Gets a value indicating whether the addition produced a carry bit or not.
	 *
	 * @return true indicates that the addition resulted in a carry; false
	 *         indicates that it did not.
	 */
	public abstract boolean getCO();

	/**
	 * Sets a value representing the carry input to the addition.
	 *
	 * @param value
	 *            true to indicate that the carry input is a one; false to
	 *            indicate that it is a zero.
	 */
	public abstract void setCI(boolean value);
}
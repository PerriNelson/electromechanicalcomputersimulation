/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Processor.Interfaces;

import electroMechanicalLogic.DataChannel.Interfaces.IEightBitAInput;
import electroMechanicalLogic.DataChannel.Interfaces.IEightBitBInput;
import electroMechanicalLogic.DataChannel.Interfaces.IEightBitDataOutput;
import electroMechanicalLogic.Interfaces.ISimulatedCircuit;

/**
 * Performs addition and subtraction, with and without a carry input.
 */
public interface IBasicArithmeticHandler extends ISimulatedCircuit,
		IEightBitAInput, IEightBitBInput, IEightBitDataOutput {

	/**
	 * Gets a value indicating whether power is flowing from the "CarryOut"
	 * terminal of the circuit or not. When power is flowing from this terminal
	 * it indicates that the operation resulted in a carry output.
	 * 
	 * @return true indicates that power is flowing from the terminal; false
	 *         otherwise.
	 */
	public abstract boolean getCarryOut();

	/**
	 * Gets a value indicating whether power is flowing from the
	 * "IsArithmeticOperation" terminal of the circuit or not. When power is
	 * flowing from this terminal it indicates that the handler was instructed
	 * to perform an arithmetic operation.
	 * 
	 * @return true indicates that power is flowing from the terminal; false
	 *         otherwise.
	 */
	public abstract boolean getIsArithmeticOperation();

	/**
	 * sets a value to indicate whether power is flowing to the "Add" input
	 * terminal of the circuit or not. When power is flowing to this terminal
	 * the circuit should perform binary addition on its "A" and "B" inputs.
	 * 
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setAdd(boolean value);

	/**
	 * sets a value to indicate whether power is flowing to the "Add"WithCarry
	 * input terminal of the circuit or not. When power is flowing to this
	 * terminal the circuit should perform binary addition on its "A" and "B"
	 * inputs, using the carry output from a previous operation as the carry
	 * input to the addition.
	 * 
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setAddWithCarry(boolean value);

	/**
	 * sets a value to indicate whether power is flowing to the "CarryIn" input
	 * terminal of the circuit or not.
	 * 
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setCarryIn(boolean value);

	/**
	 * sets a value to indicate whether power is flowing to the "Subtract" input
	 * terminal of the circuit or not. When power is flowing to this terminal
	 * the circuit should subtract its "A" input from its "B" input. Binary
	 * subtraction is typically performed by adding the twos-complement of the
	 * "A" input to the "B" input. The twos-complement of the "A" input is
	 * calculated by inverting all of the bits of the "A" input and adding 1
	 * typically by setting the carry input to the regular addition to 1.
	 * 
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setSubtract(boolean value);

	/**
	 * sets a value to indicate whether power is flowing to the
	 * "SubtractWithBorrow" input terminal of the circuit or not. When power is
	 * flowing to this terminal the circuit should subtract its "A" input from
	 * its "B" input, using the carry output from a previous operation as the
	 * carry input to the subtraction. Normal subtraction sets the carry input
	 * to 1 and results in an underflow (the adder's carry output will be on) if
	 * the subtrahend is smaller than the minuend. When the subtrahend is larger
	 * than the minuend no underflow occurs (the adder's carry output will be
	 * off). By taking this into account, the carry input to the subtraction
	 * should be off when a borrow takes place.
	 * 
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setSubtractWithBorrow(boolean value);
}

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

public interface IBasicArithmeticLogicUnit extends ISimulatedCircuit,
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
	 * Gets a value indicating whether power is flowing from the
	 * "IsBitwiseOperation" terminal of the circuit or not. When power is
	 * flowing from this terminal it indicates that the handler was instructed
	 * to perform a bitwise operation.
	 *
	 * @return true indicates that power is flowing from the terminal; false
	 *         otherwise.
	 */
	public abstract boolean getIsBitwiseOperation();

	/**
	 * Gets a value indicating whether power is flowing from the
	 * "IsRotationOperation" terminal of the circuit or not. When power is
	 * flowing from this terminal it indicates that the handler was instructed
	 * to perform a rotation operation.
	 *
	 * @return true indicates that power is flowing from the terminal; false
	 *         otherwise.
	 */
	public abstract boolean getIsRotationOperation();

	/**
	 * Sets a value to indicate whether power is flowing to the "Add" input
	 * terminal of the circuit or not. When power is flowing to this terminal
	 * the circuit should perform binary addition on its "A" and "B" inputs.
	 *
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setAdd(boolean value);

	/**
	 * Sets a value to indicate whether power is flowing to the "Add"WithCarry
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
	 * Sets a value to indicate whether power is flowing to the "AND" input
	 * terminal of the circuit or not. When power is flowing to this terminal
	 * the circuit should perform a bitwise AND on its inputs to produce its
	 * output.
	 *
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setAND(boolean value);

	/**
	 * Sets a value to indicate whether power is flowing to the "CarryIn" input
	 * terminal of the circuit or not.
	 *
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setCarryIn(boolean value);

	/**
	 * Sets a value to indicate whether power is flowing to the "OR" input
	 * terminal of the circuit or not. When power is flowing to this terminal
	 * the circuit should perform a bitwise OR on its inputs to produce its
	 * output.
	 *
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setOR(boolean value);

	/**
	 * Sets a value to indicate whether power is flowing to the "RotateLeft"
	 * input terminal of the circuit or not. If power is flowing to this
	 * terminal it indicates that the circuit should rotate its input left, so
	 * that each bit is shifted into the next higher bit position. Bit 7 should
	 * be shifted to bit 0 and to the carry output.
	 *
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setRotateLeft(boolean value);

	/**
	 * Sets a value to indicate whether power is flowing to the
	 * "RotateLeftThroughCarry" input terminal of the circuit or not. If power
	 * is flowing to this terminal it indicates that the circuit should rotate
	 * its input left, so that each bit is shifted into the next higher bit
	 * position. Bit 7 should be shifted to the carry output, and the carry
	 * input should be shifted into bit 0.
	 *
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setRotateLeftThroughCarry(boolean value);

	/**
	 * Sets a value to indicate whether power is flowing to the "RotateRight"
	 * input terminal of the circuit or not. If power is flowing to this
	 * terminal it indicates that the circuit should rotate its input right, so
	 * that each bit is shifted into the next lower bit position. Bit 0 should
	 * be shifted to bit 7 and to the carry output.
	 *
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setRotateRight(boolean value);

	/**
	 * Sets a value to indicate whether power is flowing to the
	 * "RotateRightThroughCarry" input terminal of the circuit or not. If power
	 * is flowing to this terminal it indicates that the circuit should rotate
	 * its input right, so that each bit is shifted into the next lower bit
	 * position. Bit 0 should be shifted to the carry output and the carry input
	 * should be shifted to bit 7.
	 *
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setRotateRightThroughCarry(boolean value);

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

	/**
	 * Sets a value to indicate whether power is flowing to the "XOR" input
	 * terminal of the circuit or not. When power is flowing to this terminal
	 * the circuit should perform a bitwise XOR on its inputs to produce its
	 * output.
	 *
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setXOR(boolean value);

}

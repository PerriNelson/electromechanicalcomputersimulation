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
 * Performs bitwise operations such as OR, AND, and XOR on its inputs to produce
 * outputs.
 */
public interface IBitwiseOperationHandler extends ISimulatedCircuit,
		IEightBitAInput, IEightBitBInput, IEightBitDataOutput {

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

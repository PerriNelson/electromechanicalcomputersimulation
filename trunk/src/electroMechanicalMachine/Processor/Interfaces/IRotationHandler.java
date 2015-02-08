/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Processor.Interfaces;

import electroMechanicalLogic.DataChannel.Interfaces.IEightBitDataInput;
import electroMechanicalLogic.DataChannel.Interfaces.IEightBitDataOutput;
import electroMechanicalLogic.Interfaces.ISimulatedCircuit;

public interface IRotationHandler extends IEightBitDataOutput,
		IEightBitDataInput, ISimulatedCircuit {

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
	 * "IsRotationOperation" terminal of the circuit or not. When power is
	 * flowing from this terminal it indicates that the handler was instructed
	 * to perform a rotation operation.
	 * 
	 * @return true indicates that power is flowing from the terminal; false
	 *         otherwise.
	 */
	public abstract boolean getIsRotationOperation();

	/**
	 * sets a value to indicate whether power is flowing to the "CarryIn" input
	 * terminal of the circuit or not.
	 *
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setCarryIn(boolean value);

	public abstract void setRotateLeft(boolean value);

	public abstract void setRotateLeftThroughCarry(boolean value);

	public abstract void setRotateRight(boolean value);

	public abstract void setRotateRightThroughCarry(boolean value);
}

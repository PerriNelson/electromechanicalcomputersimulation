/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Processor.Interfaces;

import electroMechanicalLogic.DataChannel.Interfaces.IEightBitCInput;
import electroMechanicalLogic.Interfaces.ISimulatedCircuit;

/**
 * A basic instruction decoder for our minimal processor.
 */
public interface IInstructionDecoder extends ISimulatedCircuit, IEightBitCInput {

	/**
	 * Gets a value indicating whether power is flowing from the "Add" output of
	 * the decoder.
	 * 
	 * @return true indicates power is flowing from the terminal; false that it
	 *         is not.
	 */
	public abstract boolean getAdd();

	/**
	 * Gets a value indicating whether power is flowing from the
	 * "Add With Carry" output of the decoder.
	 * 
	 * @return true indicates power is flowing from the terminal; false that it
	 *         is not.
	 */
	public abstract boolean getAddWithCarry();

	/**
	 * Gets a value indicating whether power is flowing from the "Halt" output
	 * of the decoder.
	 * 
	 * @return true indicates power is flowing from the terminal; false that it
	 *         is not.
	 */
	public abstract boolean getHalt();

	/**
	 * Gets a value indicating whether power is flowing from the "Load" output
	 * of the decoder.
	 * 
	 * @return true indicates power is flowing from the terminal; false that it
	 *         is not.
	 */
	public abstract boolean getLoad();

	/**
	 * Gets a value indicating whether power is flowing from the "Store" output
	 * of the decoder.
	 * 
	 * @return true indicates power is flowing from the terminal; false that it
	 *         is not.
	 */
	public abstract boolean getStore();

	/**
	 * Gets a value indicating whether power is flowing from the "Subtract"
	 * output of the decoder.
	 * 
	 * @return true indicates power is flowing from the terminal; false that it
	 *         is not.
	 */
	public abstract boolean getSubtract();

	/**
	 * Gets a value indicating whether power is flowing from the
	 * "Subtract With Borrow" output of the decoder.
	 * 
	 * @return true indicates power is flowing from the terminal; false that it
	 *         is not.
	 */
	public abstract boolean getSubtractWithBorrow();
}

/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Processor.Interfaces;

import electroMechanicalLogic.DataChannel.Interfaces.IEightBitCOutput;
import electroMechanicalLogic.DataChannel.Interfaces.IEightBitDataInput;
import electroMechanicalLogic.DataChannel.Interfaces.ISixteenBitAOutput;
import electroMechanicalLogic.Interfaces.ISimulatedCircuit;

/**
 * An instruction latch latches the code, high address and low address of the
 * instruction in our basic processors.
 */
public interface IInstructionLatch extends IEightBitDataInput,
		ISixteenBitAOutput, IEightBitCOutput, IResetable, ISimulatedCircuit {

	/**
	 * Sets a value indicating whether power is flowing to the "AddressHigh"
	 * input terminal of the circuit or not.
	 *
	 * @param value
	 *            true to indicate power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setAddressHigh(boolean value);

	/**
	 * Sets a value indicating whether power is flowing to the "AddressLow"
	 * input terminal of the circuit or not.
	 *
	 * @param value
	 *            true to indicate power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setAddressLow(boolean value);

	/**
	 * Sets a value indicating whether power is flowing to the "Code" input
	 * terminal of the circuit or not.
	 *
	 * @param value
	 *            true to indicate power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setCode(boolean value);
}

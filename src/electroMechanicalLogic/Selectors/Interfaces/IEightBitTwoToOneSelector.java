/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.Selectors.Interfaces;

import electroMechanicalLogic.DataChannel.Interfaces.IEightBitAInput;
import electroMechanicalLogic.DataChannel.Interfaces.IEightBitBInput;
import electroMechanicalLogic.DataChannel.Interfaces.IEightBitDataOutput;
import electroMechanicalLogic.Interfaces.ISimulatedCircuit;

/**
 * A circuit that selects between two eight bit wide inputs to produce one eight
 * bit wide output.
 */
public interface IEightBitTwoToOneSelector extends ISimulatedCircuit,
		IEightBitAInput, IEightBitBInput, IEightBitDataOutput {

	/**
	 * Sets a value indicating whether power is flowing to the "Select" input
	 * terminal of the circuit or not. When power is flowing to this terminal
	 * the circuit's output ("DO") should match its "B" input. When no power is
	 * flowing to this terminal the circuit's output should match its "A" input.
	 * 
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setSelect(boolean value);
}

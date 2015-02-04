/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Processor.Interfaces;

import electroMechanicalLogic.FlipFlops.Interfaces.IDTypeFlipFlop;
import electroMechanicalLogic.Interfaces.ISimulatedCircuit;

/**
 * A D-type flip flop that can be set to contain a specific value regardless of
 * the clock input.
 */
public interface ISetableFlipFlop extends IDTypeFlipFlop, IResetable,
		ISimulatedCircuit {

	/**
	 * Sets a value that indicates whether power is flowing to the "A" input
	 * terminal of the circuit or not. The "A" input will override the contents
	 * of the flip-flop when the "Set" input is high, regardless of the state of
	 * the clock.
	 * 
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setA(boolean value);

	/**
	 * Sets a value that indicates whether power is flowing to the "Set" input
	 * terminal of the circuit or not.
	 * 
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setSet(boolean value);
}

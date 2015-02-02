/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.FlipFlops.Interfaces;

import electroMechanicalLogic.Interfaces.ISimulatedCircuit;

/**
 * A D-Type flip flop is a flip-flop used to store one bit of data when the
 * clock signal is on.
 */
public interface IDTypeFlipFlop extends IFlipFlopOutput, ISimulatedCircuit {

	/**
	 * Sets a value indicating whether power is flowing to the "Clk" terminal of
	 * the flip-flop.
	 *
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            to indicate that it is not.
	 */
	public abstract void setClk(boolean value);

	/**
	 * Sets a value indicating whether power is flowing to the "D" terminal of
	 * the flip-flop.
	 *
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            to indicate that it is not.
	 */
	public abstract void setD(boolean value);
}

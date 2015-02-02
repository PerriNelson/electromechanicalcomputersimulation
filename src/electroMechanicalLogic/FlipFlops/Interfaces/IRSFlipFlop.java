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
 * A simple set/reset flip-flop circuit. A flip-flop circuit "remembers" which
 * of its inputs was last on when both inputs are off. The outputs of an RS type
 * flip-flop are invalid when both inputs are or were on simultaneously. For an
 * RS type flip-flop the "Q" output is on when the "R" input was the last input
 * turned on. It is off when the "S" input was the last input turned on (or when
 * power to the entire circuit is off).
 */
public interface IRSFlipFlop extends ISimulatedCircuit, IFlipFlopOutput {

	/**
	 * Sets a value that turns the "R" input to the circuit on or off.
	 *
	 * @param value
	 *            true to turn the input on; false to turn it off.
	 */
	public abstract void setR(boolean value);

	/**
	 * Sets a value that turns the "S" input to the circuit on or off.
	 *
	 * @param value
	 *            true to turn the input on; false to turn it off.
	 */
	public abstract void setS(boolean value);
}

/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */
package electroMechanicalLogic.Gates;

import electroMechanicalLogic.Interfaces.IRelay;

/**
 * Provides functionality common to all two input gates that use single relays
 * for the "A" and "B" inputs.
 */
abstract class TwoRelaySingleOutputGate {
	/**
	 * The relay connected to the "A" input of the gate.
	 */
	protected final IRelay a;

	/**
	 * The relay connected to the "B" input of the gate.
	 */
	protected final IRelay b;

	/**
	 * Constructs the gate.
	 *
	 * @param relayA
	 *            the relay to be connected to the "A" input terminal.
	 * @param relayB
	 *            the relay to be connected to the "B" input terminal.
	 */
	TwoRelaySingleOutputGate(final IRelay relayA, final IRelay relayB) {
		a = relayA;
		b = relayB;
	}

	/**
	 * Sets a value indicating whether power is flowing to the "A" terminal of
	 * the gate or not.
	 *
	 * @param value
	 *            true to indicate that power is flowing to the "A" terminal of
	 *            the gate; false to indicate that it is not.
	 */
	public void setA(final boolean value) {
		a.setInput(value);
	}

	/**
	 * Sets a value indicating whether power is flowing to the "B" terminal of
	 * the gate or not.
	 *
	 * @param value
	 *            true to indicate that power is flowing to the "B" terminal of
	 *            the gate; false to indicate that it is not.
	 */
	public void setB(final boolean value) {
		b.setInput(value);
	}
}
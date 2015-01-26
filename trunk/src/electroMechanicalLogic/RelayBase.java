/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */
package electroMechanicalLogic;

import electroMechanicalLogic.Interfaces.ISimulatedCircuit;

/**
 * Provides basic functionality for all relays in the simulation.
 */
abstract class RelayBase implements ISimulatedCircuit {

	private static final byte PowerMaskIn = (byte) 0x80;
	private static final byte InputMaskIn = (byte) 0x40;
	/**
	 * A bit mask that can be applied to the relay's state to determine whether
	 * power is flowing to the relay's power terminal.
	 */
	protected static final byte PowerMaskOut = (byte) 0x08;
	/**
	 * A bit mask that can be applied to the relay's state to determine whether
	 * power is flowing to the relay's input terminal.
	 */
	protected static final byte InputMaskOut = (byte) 0x04;
	private static final byte StateMaskOut = (byte) 0x0F;
	private static final byte StateMaskIn = (byte) 0xF0;

	protected byte state;

	public final void setInput(final boolean value) {
		state = value ? (byte) (state | InputMaskIn)
				: (byte) (state & ~InputMaskIn);
	}

	@Override
	public final void setPower(final boolean value) {
		state = value ? (byte) (state | PowerMaskIn)
				: (byte) (state & ~PowerMaskIn);

	}

	@Override
	public final void step() {
		state = (byte) ((state & StateMaskIn) | ((state >> 4) & StateMaskOut));
	}
}
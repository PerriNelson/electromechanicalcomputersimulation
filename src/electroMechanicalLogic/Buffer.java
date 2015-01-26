/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */
package electroMechanicalLogic;

import electroMechanicalLogic.Interfaces.IRelay;

/**
 * A buffer is a relay configured so that when both the power and the input are
 * on the output is on, and when either the power or the input is off the output
 * is off.
 */
public final class Buffer extends RelayBase implements IRelay {

	private static final byte OutputMask = PowerMaskOut | InputMaskOut;

	@Override
	public boolean getOutput() {
		return (state & OutputMask) == OutputMask;
	}

}

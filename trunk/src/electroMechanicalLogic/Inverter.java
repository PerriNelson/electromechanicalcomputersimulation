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
 * An inverter is a relay wired so that when the power is on and the input is
 * off the output is on and when the power is off or the input is on the output
 * is off.
 */
public final class Inverter extends RelayBase implements IRelay {

	@Override
	public boolean getOutput() {
		return ((state & PowerMaskOut) == PowerMaskOut)
				&& ((state & InputMaskOut) == 0);
	}

}

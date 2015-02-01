/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Model.Interfaces;

import electroMechanicalLogic.DataChannel.Interfaces.ISixteenBitAOutput;
import electroMechanicalLogic.Interfaces.ISimulatedCircuit;

public interface IMarkIXTimingControl extends ISimulatedCircuit,
		ISixteenBitAOutput {
	public abstract boolean getExecute();

	public abstract boolean getFetchCode();

	public abstract boolean getFetchHighAddress();

	public abstract boolean getFetchLowAddress();

	public abstract boolean getWrite();

	public abstract void setClear(boolean value);

	public abstract void setClock(boolean value);

	public abstract void setHalt(boolean value);

	public abstract void setStore(boolean value);
}

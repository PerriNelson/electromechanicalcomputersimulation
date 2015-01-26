/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Model.Interfaces;

import electroMechanicalLogic.Interfaces.ISimulatedCircuit;
import electroMechanicalLogic.Interfaces.DataChannels.ISixteenBitAOutput;

public interface IMarkVITimingAndMemoryWriteControl extends ISimulatedCircuit,
		ISixteenBitAOutput {

	public abstract boolean getClock();

	public abstract boolean getWrite();

	public abstract void setClear(boolean value);

	public abstract void setHalt(boolean value);

	public abstract void setStore(boolean value);

}

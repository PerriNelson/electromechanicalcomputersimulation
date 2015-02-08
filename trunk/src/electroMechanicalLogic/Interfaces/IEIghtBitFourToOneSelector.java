/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.Interfaces;

import electroMechanicalLogic.DataChannel.Interfaces.IEightBitAInput;
import electroMechanicalLogic.DataChannel.Interfaces.IEightBitBInput;
import electroMechanicalLogic.DataChannel.Interfaces.IEightBitCInput;
import electroMechanicalLogic.DataChannel.Interfaces.IEightBitDInput;
import electroMechanicalLogic.DataChannel.Interfaces.IEightBitDataOutput;

public interface IEIghtBitFourToOneSelector extends IEightBitAInput,
		IEightBitBInput, IEightBitCInput, IEightBitDInput, IEightBitDataOutput,
		ISimulatedCircuit {

	public abstract void setS0(boolean value);

	public abstract void setS1(boolean value);
}

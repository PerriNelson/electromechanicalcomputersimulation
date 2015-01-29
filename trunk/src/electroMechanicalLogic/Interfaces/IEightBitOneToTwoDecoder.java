/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.Interfaces;

import electroMechanicalLogic.DataChannel.Interfaces.IEightBitAOutput;
import electroMechanicalLogic.DataChannel.Interfaces.IEightBitBOutput;
import electroMechanicalLogic.DataChannel.Interfaces.IEightBitDataInput;

public interface IEightBitOneToTwoDecoder extends ISimulatedCircuit,
		IEightBitAOutput, IEightBitBOutput, IEightBitDataInput {
	public abstract void setSelect(boolean value);
}

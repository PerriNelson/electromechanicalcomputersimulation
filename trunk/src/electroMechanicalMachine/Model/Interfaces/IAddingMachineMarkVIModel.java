/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Model.Interfaces;

import electroMechanicalLogic.DataChannel.Interfaces.IEightBitDataIn;
import electroMechanicalLogic.DataChannel.Interfaces.IEightBitDataOut;
import electroMechanicalLogic.DataChannel.Interfaces.ISixteenBitAInput;

public interface IAddingMachineMarkVIModel extends IMachineModel,
IEightBitDataOut, IEightBitDataIn, ISixteenBitAInput {

	public abstract void setReset(boolean value);

	public abstract void setTakeover(boolean value);

	public abstract void setUseCodePanel(boolean value);

	public abstract void setW(boolean value);

}

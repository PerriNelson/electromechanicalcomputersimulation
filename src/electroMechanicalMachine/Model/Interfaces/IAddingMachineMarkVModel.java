/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Model.Interfaces;

import electroMechanicalLogic.DataChannel.Interfaces.IEightBitDataInput;
import electroMechanicalLogic.DataChannel.Interfaces.IEightBitDataOutput;
import electroMechanicalLogic.DataChannel.Interfaces.IEightBitSumOutput;
import electroMechanicalLogic.DataChannel.Interfaces.ISixteenBitAInput;
import electroMechanicalLogic.Interfaces.ISimulatedCircuit;

public interface IAddingMachineMarkVModel extends ISimulatedCircuit,
		IEightBitDataOutput, IEightBitSumOutput, ISixteenBitAInput,
		IEightBitDataInput {

	public abstract void setClear(boolean value);

	public abstract void setTakeover(boolean value);

	public abstract void setW(boolean value);
}

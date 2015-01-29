/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.Interfaces;

import electroMechanicalLogic.DataChannel.Interfaces.ISixteenBitAInput;
import electroMechanicalLogic.DataChannel.Interfaces.ISixteenBitAOutput;

public interface ISixteenBitAddressBuffer extends ISixteenBitAInput,
		ISixteenBitAOutput, ISimulatedCircuit {

}

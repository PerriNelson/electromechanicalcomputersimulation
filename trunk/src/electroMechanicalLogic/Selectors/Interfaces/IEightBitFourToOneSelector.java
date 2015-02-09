/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.Selectors.Interfaces;

import electroMechanicalLogic.DataChannel.Interfaces.IEightBitAInput;
import electroMechanicalLogic.DataChannel.Interfaces.IEightBitBInput;
import electroMechanicalLogic.DataChannel.Interfaces.IEightBitCInput;
import electroMechanicalLogic.DataChannel.Interfaces.IEightBitDInput;
import electroMechanicalLogic.DataChannel.Interfaces.IEightBitDataOutput;
import electroMechanicalLogic.Interfaces.ISimulatedCircuit;

/**
 * A circuit that "selects" between four eight bit wide inputs to produce one
 * eight bit wide output.
 */
public interface IEightBitFourToOneSelector extends IEightBitAInput,
		IEightBitBInput, IEightBitCInput, IEightBitDInput, IEightBitDataOutput,
		ISimulatedCircuit {

	/**
	 * Sets a value indicating whether power is flowing to the "S0" input
	 * terminal of the circuit or not. The S0 and S1 inputs together act to
	 * select between the inputs. When both S0 and S1 are low the "A" input is
	 * selected. When S0 is high and S1 is low the "B" input is selected. When
	 * S0 is low and S1 is high the "C" input is selected. When both S0 and S1
	 * are high the "D" input is selected.
	 * 
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setS0(boolean value);

	/**
	 * Sets a value indicating whether power is flowing to the "S1" input
	 * terminal of the circuit or not. The S0 and S1 inputs together act to
	 * select between the inputs. When both S0 and S1 are low the "A" input is
	 * selected. When S0 is high and S1 is low the "B" input is selected. When
	 * S0 is low and S1 is high the "C" input is selected. When both S0 and S1
	 * are high the "D" input is selected.
	 * 
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setS1(boolean value);
}

/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.Selectors.Interfaces;

import electroMechanicalLogic.Interfaces.ISimulatedCircuit;

/**
 * A circuit that "selects" between four inputs to produce one output.
 */
public interface IFourToOneSelector extends ISimulatedCircuit {

	/**
	 * Gets a value indicating whether power is flowing from the "DO" output
	 * terminal of the circuit or not.
	 * 
	 * @return true indicates that power is flowing from the terminal; false
	 *         otherwise.
	 */
	public abstract boolean getDO();

	/**
	 * Sets a value indicating whether power is flowing to the "A" input
	 * terminal of the circuit or not.
	 * 
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setA(boolean value);

	/**
	 * Sets a value indicating whether power is flowing to the "B" input
	 * terminal of the circuit or not.
	 * 
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setB(boolean value);

	/**
	 * Sets a value indicating whether power is flowing to the "C" input
	 * terminal of the circuit or not.
	 * 
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setC(boolean value);

	/**
	 * Sets a value indicating whether power is flowing to the "D" input
	 * terminal of the circuit or not.
	 * 
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setD(boolean value);

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

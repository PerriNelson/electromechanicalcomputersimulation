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
 * A circuit that "selects" between eight inputs to produce one output.
 * <p>
 * The "S0", "S1', and "S2" inputs are used to select the output as follows:
 * </p>
 * 
 * <table border="1">
 * <col width="12pt"/> <col width="12pt"/> <col width="12pt"/> <col
 * width="12pt"/> <thead>
 * <tr>
 * <th>S0</th>
 * <th>S1</th>
 * <th>S2</th>
 * <th>DO</th>
 * </tr>
 * <thead> <tbody>
 * <tr>
 * <td>off</td>
 * <td>off</td>
 * <td>off</td>
 * <td>A</td>
 * </tr>
 * <tr>
 * <td>off</td>
 * <td>off</td>
 * <td>on</td>
 * <td>B</td>
 * </tr>
 * <tr>
 * <td>off</td>
 * <td>on</td>
 * <td>off</td>
 * <td>C</td>
 * </tr>
 * <tr>
 * <td>off</td>
 * <td>on</td>
 * <td>on</td>
 * <td>D</td>
 * </tr>
 * <tr>
 * <td>on</td>
 * <td>off</td>
 * <td>off</td>
 * <td>E</td>
 * </tr>
 * <tr>
 * <td>on</td>
 * <td>off</td>
 * <td>on</td>
 * <td>F</td>
 * </tr>
 * <tr>
 * <td>on</td>
 * <td>on</td>
 * <td>off</td>
 * <td>G</td>
 * </tr>
 * <tr>
 * <td>on</td>
 * <td>on</td>
 * <td>on</td>
 * <td>H</td>
 * </tr>
 * </tbody>
 * </table>
 */
public interface IEightToOneSelector extends ISimulatedCircuit {

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
	 * Sets a value indicating whether power is flowing to the "E" input
	 * terminal of the circuit or not.
	 * 
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setE(boolean value);

	/**
	 * Sets a value indicating whether power is flowing to the "F" input
	 * terminal of the circuit or not.
	 * 
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setF(boolean value);

	/**
	 * Sets a value indicating whether power is flowing to the "G" input
	 * terminal of the circuit or not.
	 * 
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setG(boolean value);

	/**
	 * Sets a value indicating whether power is flowing to the "H" input
	 * terminal of the circuit or not.
	 * 
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setH(boolean value);

	/**
	 * Sets a value indicating whether power is flowing to the "S0" input
	 * terminal of the circuit or not.
	 * 
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setS0(boolean value);

	/**
	 * Sets a value indicating whether power is flowing to the "S1" input
	 * terminal of the circuit or not.
	 * 
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setS1(boolean value);

	/**
	 * Sets a value indicating whether power is flowing to the "S2" input
	 * terminal of the circuit or not.
	 * 
	 * @param value
	 *            true to indicate that power is flowing to the terminal; false
	 *            otherwise.
	 */
	public abstract void setS2(boolean value);
}

/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.Interfaces;

public interface IEightBitCounter extends ISimulatedCircuit {
	public abstract boolean getQ0();

	public abstract boolean getQ1();

	public abstract boolean getQ2();

	public abstract boolean getQ3();

	public abstract boolean getQ4();

	public abstract boolean getQ5();

	public abstract boolean getQ6();

	public abstract boolean getQ7();

	public abstract void setClk(boolean value);
}

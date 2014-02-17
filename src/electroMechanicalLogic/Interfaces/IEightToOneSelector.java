/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.Interfaces;

public interface IEightToOneSelector extends ISimulatedCircuit {

	public abstract boolean getOutput();

	public abstract void setD0(boolean value);

	public abstract void setD1(boolean value);

	public abstract void setD2(boolean value);

	public abstract void setD3(boolean value);

	public abstract void setD4(boolean value);

	public abstract void setD5(boolean value);

	public abstract void setD6(boolean value);

	public abstract void setD7(boolean value);

	public abstract void setS0(boolean value);

	public abstract void setS1(boolean value);

	public abstract void setS2(boolean value);
}

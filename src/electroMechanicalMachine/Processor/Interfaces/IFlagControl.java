/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Processor.Interfaces;

import electroMechanicalLogic.Interfaces.ISimulatedCircuit;

public interface IFlagControl extends ISimulatedCircuit {
	public abstract boolean getLatchFlags();

	public abstract void setAdd(boolean value);

	public abstract void setClockBar(boolean value);

	public abstract void setAddWithCarry(boolean value);

	public abstract void setExecute(boolean value);

	public abstract void setSubtract(boolean value);

	public abstract void setSubtractWithBorrow(boolean value);
}

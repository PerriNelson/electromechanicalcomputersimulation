/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.Interfaces;

public interface IEightBitLatch extends ISimulatedCircuit, IEightBitDataOut {
	public abstract void setDI0(boolean value);

	public abstract void setDI1(boolean value);

	public abstract void setDI2(boolean value);

	public abstract void setDI3(boolean value);

	public abstract void setDI4(boolean value);

	public abstract void setDI5(boolean value);

	public abstract void setDI6(boolean value);

	public abstract void setDI7(boolean value);

	public abstract void setW(boolean value);
}

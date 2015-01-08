/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.Interfaces;

public interface IEightBitOnesComplement extends ISimulatedCircuit {

	public abstract boolean getO0();

	public abstract boolean getO1();

	public abstract boolean getO2();

	public abstract boolean getO3();

	public abstract boolean getO4();

	public abstract boolean getO5();

	public abstract boolean getO6();

	public abstract boolean getO7();

	public abstract void setI0(boolean value);

	public abstract void setI1(boolean value);

	public abstract void setI2(boolean value);

	public abstract void setI3(boolean value);

	public abstract void setI4(boolean value);

	public abstract void setI5(boolean value);

	public abstract void setI6(boolean value);

	public abstract void setI7(boolean value);

	public abstract void setInvert(boolean value);
}

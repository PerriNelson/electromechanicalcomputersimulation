/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.Interfaces;

public interface IEightBitTwoToOneSelector extends ISimulatedCircuit {

	public abstract boolean getO0();

	public abstract boolean getO1();

	public abstract boolean getO2();

	public abstract boolean getO3();

	public abstract boolean getO4();

	public abstract boolean getO5();

	public abstract boolean getO6();

	public abstract boolean getO7();

	public abstract void setA0(boolean value);

	public abstract void setA1(boolean value);

	public abstract void setA2(boolean value);

	public abstract void setA3(boolean value);

	public abstract void setA4(boolean value);

	public abstract void setA5(boolean value);

	public abstract void setA6(boolean value);

	public abstract void setA7(boolean value);

	public abstract void setB0(boolean value);

	public abstract void setB1(boolean value);

	public abstract void setB2(boolean value);

	public abstract void setB3(boolean value);

	public abstract void setB4(boolean value);

	public abstract void setB5(boolean value);

	public abstract void setB6(boolean value);

	public abstract void setB7(boolean value);

	public abstract void setSelect(boolean value);
}
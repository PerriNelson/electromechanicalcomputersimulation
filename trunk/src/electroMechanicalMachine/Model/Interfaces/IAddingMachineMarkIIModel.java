/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Model.Interfaces;

import electroMechanicalLogic.Interfaces.ISimulatedCircuit;

public interface IAddingMachineMarkIIModel extends ISimulatedCircuit {
	public abstract boolean getOverflow();

	public abstract boolean getS0();

	public abstract boolean getS1();

	public abstract boolean getS2();

	public abstract boolean getS3();

	public abstract boolean getS4();

	public abstract boolean getS5();

	public abstract boolean getS6();

	public abstract boolean getS7();

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

	public abstract void setSubtract(boolean value);
}

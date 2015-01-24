/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Model.Interfaces;

import electroMechanicalLogic.Interfaces.IEightBitDataOut;

public interface IAddingMachineMarkVModel extends IMachineModel,
		IEightBitDataOut {

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

	public abstract void setA8(boolean value);

	public abstract void setA9(boolean value);

	public abstract void setAA(boolean value);

	public abstract void setAB(boolean value);

	public abstract void setAC(boolean value);

	public abstract void setAD(boolean value);

	public abstract void setAE(boolean value);

	public abstract void setAF(boolean value);

	public abstract void setClear(boolean value);

	public abstract void setDI0(boolean value);

	public abstract void setDI1(boolean value);

	public abstract void setDI2(boolean value);

	public abstract void setDI3(boolean value);

	public abstract void setDI4(boolean value);

	public abstract void setDI5(boolean value);

	public abstract void setDI6(boolean value);

	public abstract void setDI7(boolean value);

	public abstract void setTakeover(boolean value);

	public abstract void setW(boolean value);
}

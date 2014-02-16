/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.Interfaces;

public interface IThreeInputSingleOutputGate {

	public abstract boolean getOutput();

	public abstract void setA(boolean value);

	public abstract void setB(boolean value);

	public abstract void setC(boolean value);

	public abstract void setPower(boolean value);
	
	public abstract void step();
}

/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.Interfaces;

public interface IRSFlipFlop {
	public abstract boolean getQ();

	public abstract boolean getQBar();

	public abstract void setPower(boolean value);

	public abstract void setR(boolean value);

	public abstract void setS(boolean value);

	public abstract void step();
}

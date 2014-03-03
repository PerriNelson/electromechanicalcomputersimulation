/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.Interfaces;

public interface IThirtyTwoKilobyteRAM extends IFourKilobyteRAM {

	public abstract void setAC(boolean value);
	
	public abstract void setAD(boolean value);
	
	public abstract void setAE(boolean value);
	
}
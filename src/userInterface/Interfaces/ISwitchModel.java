/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package userInterface.Interfaces;

import java.beans.PropertyChangeListener;

public interface ISwitchModel {

	public abstract void addPropertyChangeListener(
			PropertyChangeListener listener);

	public abstract PowerState getPowerOut();

	public abstract boolean isClosed();

	public abstract void removePropertyChangeListener(
			PropertyChangeListener listener);

	public abstract void setClosed(boolean value);

	public abstract void setPowerIn(PowerState value);

}

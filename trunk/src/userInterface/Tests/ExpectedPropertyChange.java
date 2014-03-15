/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package userInterface.Tests;

public class ExpectedPropertyChange {
	private String propertyName;
	private boolean propertyChanged = false;
	
	public ExpectedPropertyChange(String propertyName) {
		this.propertyName = propertyName;
	}
	
	public String getPropertyName() {
		return propertyName;
	}
	
	public boolean getPropertyChanged () {
		return propertyChanged;
	}
	public void setPropertyChanged() {
		propertyChanged = true;
	}
}

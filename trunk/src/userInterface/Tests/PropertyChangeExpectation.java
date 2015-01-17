/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package userInterface.Tests;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PropertyChangeExpectation {
	public static PropertyChangeListener getListener(
			final PropertyChangeExpectation[] expectedChanges) {

		return new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				for (PropertyChangeExpectation expectedChange : expectedChanges) {
					if (expectedChange.getPropertyName().equalsIgnoreCase(
							evt.getPropertyName())) {
						expectedChange.setPropertyChanged();
					}
				}
			}
		};
	}
 
	private String propertyName;

	private boolean propertyChanged = false;

	public PropertyChangeExpectation(String propertyName) {
		this.propertyName = propertyName;
	}

	public boolean getPropertyChanged() {
		return propertyChanged;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyChanged() {
		propertyChanged = true;
	}
}

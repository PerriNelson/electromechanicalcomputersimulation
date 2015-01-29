/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.UIComponents.Model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.event.EventListenerList;

import electroMechanicalMachine.UIComponents.Interfaces.ILampModel;

public class LampModel implements ILampModel {
	protected transient PropertyChangeEvent propertyChangeEvent = null;

	private final EventListenerList eventListeners = new EventListenerList();
	private boolean on;

	@Override
	public void addPropertyChangeListener(final PropertyChangeListener listener) {
		eventListeners.add(PropertyChangeListener.class, listener);
	}

	protected void fireOnPropertyChange(final String propertyName,
			final boolean oldValue, final boolean newValue) {
		final Object[] listeners = eventListeners.getListenerList();
		for (int index = listeners.length - 2; index >= 0; index -= 2) {
			if (listeners[index] == PropertyChangeListener.class) {
				if (propertyChangeEvent == null) {
					propertyChangeEvent = new PropertyChangeEvent(this,
							propertyName, oldValue, newValue);
				}
				((PropertyChangeListener) listeners[index + 1])
						.propertyChange(propertyChangeEvent);
			}
		}
	}

	@Override
	public boolean isOn() {
		return on;
	}

	@Override
	public void removePropertyChangeListener(
			final PropertyChangeListener listener) {
		eventListeners.remove(PropertyChangeListener.class, listener);
	}

	@Override
	public void setOn(final boolean value) {
		if (value != on) {
			on = value;
			fireOnPropertyChange("on", !on, on);
		}
	}
}

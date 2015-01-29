/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package userinterface.Model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.event.EventListenerList;

import electroMechanicalMachine.UserInterfaceComponents.Interfaces.ISwitchModel;
import electroMechanicalMachine.UserInterfaceComponents.Interfaces.PowerState;

public class SwitchModel implements ISwitchModel {
	private static final String closedPropertyName = "closed";
	private static final String powerOutPropertyName = "powerOut";

	private final EventListenerList eventListeners = new EventListenerList();
	private boolean closed;
	private PowerState powerState;

	public SwitchModel() {
		this(false, PowerState.off);
	}

	public SwitchModel(final boolean closed) {
		this(closed, PowerState.off);
	}

	public SwitchModel(final boolean closed, final PowerState powerState) {
		this.closed = closed;
		this.powerState = powerState;
	}

	public SwitchModel(final PowerState powerState) {
		this(false, powerState);
	}

	@Override
	public void addPropertyChangeListener(final PropertyChangeListener listener) {
		eventListeners.add(PropertyChangeListener.class, listener);
	}

	protected void fireOnPropertyChange(final String propertyName,
			final Object oldValue, final Object newValue) {
		PropertyChangeEvent propertyChangeEvent = null;

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
	public PowerState getPowerOut() {
		return closed ? powerState : PowerState.off;
	}

	@Override
	public boolean isClosed() {
		return closed;
	}

	@Override
	public void removePropertyChangeListener(
			final PropertyChangeListener listener) {
		eventListeners.remove(PropertyChangeListener.class, listener);
	}

	@Override
	public void setClosed(final boolean newValue) {
		final boolean oldValue = closed;

		if (newValue != oldValue) {
			closed = newValue;
			fireOnPropertyChange(closedPropertyName, oldValue, newValue);
			if (powerState == PowerState.on) {
				if (closed) {
					fireOnPropertyChange(powerOutPropertyName, PowerState.off,
							PowerState.on);
				} else {
					fireOnPropertyChange(powerOutPropertyName, PowerState.on,
							PowerState.off);
				}
			}
		}
	}

	@Override
	public void setPowerIn(final PowerState newValue) {
		final PowerState oldValue = powerState;

		if (oldValue != newValue) {
			powerState = newValue;
			if (closed) {
				fireOnPropertyChange(powerOutPropertyName, oldValue, newValue);
			}
		}
	}
}

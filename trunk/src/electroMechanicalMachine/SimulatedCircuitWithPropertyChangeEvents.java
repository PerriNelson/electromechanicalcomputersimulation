/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.event.EventListenerList;

import electroMechanicalLogic.Interfaces.ISimulatedCircuit;
import electroMechanicalMachine.Interfaces.ISimulatedCircuitWithPropertyChangeEvents;

public class SimulatedCircuitWithPropertyChangeEvents implements
		ISimulatedCircuitWithPropertyChangeEvents {
	private final ISimulatedCircuit circuit;
	private final EventListenerList eventListeners = new EventListenerList();

	public SimulatedCircuitWithPropertyChangeEvents(
			ISimulatedCircuit simulatedCircuit) {
		circuit = simulatedCircuit;
	}

	@Override
	public void setPower(boolean value) {
		circuit.setPower(value);
	}

	@Override
	public void step() {
		circuit.step();
		fireOnPropertyChange();
	}

	private void fireOnPropertyChange() {
		PropertyChangeEvent propertyChangeEvent = null;

		final Object[] listeners = eventListeners.getListenerList();
		for (int index = listeners.length - 2; index >= 0; index -= 2) {
			if (listeners[index] == PropertyChangeListener.class) {
				if (propertyChangeEvent == null) {
					propertyChangeEvent = new PropertyChangeEvent(this, null,
							null, null);
				}
				((PropertyChangeListener) listeners[index + 1])
						.propertyChange(propertyChangeEvent);
			}
		}
	}

	@Override
	public void addPropertyChangeListener(final PropertyChangeListener listener) {
		eventListeners.add(PropertyChangeListener.class, listener);
	}

	@Override
	public void removePropertyChangeListener(
			final PropertyChangeListener listener) {
		eventListeners.remove(PropertyChangeListener.class, listener);
	}
}

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

import electroMechanicalLogic.Interfaces.ISimulatedCircuit;
import electroMechanicalMachine.Interfaces.ISimulatedCircuitWithPropertyChangeEvents;
import electroMechanicalMachine.Interfaces.ISimulationDriver;

/**
 * Base class for simulation control panels.
 */
public abstract class ControlPanel extends BasicUIFrame {
	private static final long serialVersionUID = 1L;
	private ISimulationDriver automationDriver;

	/**
	 * Constructs the control panel.
	 * 
	 * @param caption
	 *            the window caption for the control panel.
	 */
	public ControlPanel(String caption) {
		super(caption);
		setTitle();
	}

	private final ISimulatedCircuit attachEventsToCircuit(
			final ISimulatedCircuit model) {
		final ISimulatedCircuitWithPropertyChangeEvents simulatedCircuit = new SimulatedCircuitWithPropertyChangeEvents(
				model);

		simulatedCircuit
				.addPropertyChangeListener(new PropertyChangeListener() {
					@Override
					public void propertyChange(PropertyChangeEvent arg0) {
						onModelUpdated();
					}
				});
		return simulatedCircuit;
	}

	protected abstract void setTitle();

	/**
	 * Handles notification that the model has been updated.
	 */
	protected abstract void onModelUpdated();

	/**
	 * Runs the simulation by stepping the simulated circuit at regular
	 * intervals.
	 * 
	 * @param circuit
	 *            the circuit to be stepped.
	 * 
	 * @param cycleTimeInMilliseconds
	 *            the interval to wait between each step of the circuit.
	 */
	protected final void runSimulation(final ISimulatedCircuit circuit,
			int cycleTimeInMilliseconds) {

		automationDriver = new SimulationDriver(attachEventsToCircuit(circuit),
				cycleTimeInMilliseconds);
		automationDriver.runSimulation();
	}
}
/*
  ElectroMechanIcalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import electroMechanicalLogic.Interfaces.ISimulatedCircuit;
import electroMechanicalMachine.Interfaces.ISimulationDriver;

/**
 * Drives the simulation of a circuit.
 */
public class SimulationDriver implements ISimulationDriver {
	private final int cycleTime;
	private Timer timer;
	private final ISimulatedCircuit circuit;

	/**
	 * Constructs a simulation driver for the specified circuit with the
	 * specified cycle time.
	 */
	public SimulationDriver(final ISimulatedCircuit circuit,
			final int cycleTimeInMilliseconds) {
		this.circuit = circuit;
		cycleTime = cycleTimeInMilliseconds;
	}

	@Override
	public void runSimulation() {
		timer = new Timer(cycleTime, new ActionListener() {
			@Override
			public void actionPerformed(final ActionEvent arg0) {
				timer.stop();
				circuit.step();
				timer.restart();
			}
		});
		timer.start();
	}
}

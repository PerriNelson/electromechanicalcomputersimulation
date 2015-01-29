/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Interfaces;

/**
 * In the real world, electrical circuits are always active as long as power is
 * flowing through the circuit. Our simulation is designed to model this by
 * repeatedly stepping simulated circuits so that they appear active.
 */
public interface ISimulationDriver {
	/**
	 * Runs the simulation by stepping the simulated circuit.
	 */
	public void runSimulation();
}

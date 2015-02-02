/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import org.junit.Before;
import org.junit.Test;

import electroMechanicalLogic.Interfaces.ISimulatedCircuit;
import electroMechanicalMachine.SimulatedCircuitWithPropertyChangeEvents;
import electroMechanicalMachine.Interfaces.ISimulatedCircuitWithPropertyChangeEvents;

public class TestSimulatedCircuitWithPropertyChangeEvents implements
		PropertyChangeListener {
	private ISimulatedCircuitWithPropertyChangeEvents systemUnderTest;
	private boolean notified;
	private boolean powerOn;
	private boolean stepCalled;

	@Override
	public void propertyChange(final PropertyChangeEvent evt) {
		notified = true;
	}

	@Before
	public void setUp() {
		systemUnderTest = new SimulatedCircuitWithPropertyChangeEvents(
				new ISimulatedCircuit() {
					@Override
					public void setPower(final boolean value) {
						powerOn = value;
					}

					@Override
					public void step() {
						stepCalled = true;
					}
				});

		notified = false;
		powerOn = false;
		stepCalled = false;
	}

	@Test
	public void testSimulatedCircuitWithPropertyChangeEvents_shouldNotifyListener_whenStepCalled() {
		systemUnderTest.addPropertyChangeListener(this);
		systemUnderTest.step();

		assertTrue(notified);
	}

	@Test
	public void testSimulatedCircuitWithPropertyChangeEvents_shouldNotNotifyRemovedListener_whenStepCalled() {
		systemUnderTest.addPropertyChangeListener(this);
		systemUnderTest.removePropertyChangeListener(this);

		systemUnderTest.step();

		assertFalse(notified);
	}

	@Test
	public void testSimulatedCircuitWithPropertyChangeEvents_shouldStepDecoratedCircuit_whenStepCalled() {
		systemUnderTest.step();

		assertTrue(stepCalled);
	}

	@Test
	public void testSimulatedCircuitWithPropertyChangeEvents_shouldTurnOffPowerToDecoratedCircuit_whenSetPowerCalledWithFalse() {
		powerOn = true;
		systemUnderTest.setPower(false);

		assertFalse(powerOn);
	}

	@Test
	public void testSimulatedCircuitWithPropertyChangeEvents_shouldTurnOnPowerToDecoratedCircuit_whenSetPowerCalledWithTrue() {
		systemUnderTest.setPower(true);

		assertTrue(powerOn);
	}
}

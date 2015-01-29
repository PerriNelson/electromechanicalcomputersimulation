/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.UserInterfaceComponents.Model.Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.beans.PropertyChangeListener;

import org.junit.Test;

import electroMechanicalMachine.UserInterfaceComponents.Interfaces.PowerState;
import userinterface.Model.SwitchModel;

public class SwitchModelTest {

	@Test
	public void GetPowerOut_ReturnsPowerStateOff_WhenClosedFalseAndSetPowerInCalledWithPowerStateOff() {
		final SwitchModel systemUnderTest = new SwitchModel(false);
		systemUnderTest.setPowerIn(PowerState.off);

		final PowerState actualValue = systemUnderTest.getPowerOut();

		assertEquals(PowerState.off, actualValue);
	}

	@Test
	public void GetPowerOut_ReturnsPowerStateOff_WhenClosedFalseAndSetPowerInCalledWithPowerStateOn() {
		final SwitchModel systemUnderTest = new SwitchModel(false);
		systemUnderTest.setPowerIn(PowerState.on);

		final PowerState actualValue = systemUnderTest.getPowerOut();

		assertEquals(PowerState.off, actualValue);
	}

	@Test
	public void GetPowerOut_ReturnsPowerStateOff_WhenClosedTrueAndSetPowerInCalledWithPowerStateOff() {
		final SwitchModel systemUnderTest = new SwitchModel(true);
		systemUnderTest.setPowerIn(PowerState.off);

		final PowerState actualValue = systemUnderTest.getPowerOut();

		assertEquals(PowerState.off, actualValue);
	}

	@Test
	public void GetPowerOut_ReturnsPowerStateOff_WhenSwitchModelConstructedWithClosedFalseAndNoPowerState() {
		final SwitchModel systemUnderTest = new SwitchModel(false);

		final PowerState actualValue = systemUnderTest.getPowerOut();

		assertEquals(PowerState.off, actualValue);
	}

	@Test
	public void GetPowerOut_ReturnsPowerStateOff_WhenSwitchModelConstructedWithClosedFalseAndPowerStateOff() {
		final SwitchModel systemUnderTest = new SwitchModel(false,
				PowerState.off);

		final PowerState actualValue = systemUnderTest.getPowerOut();

		assertEquals(PowerState.off, actualValue);
	}

	@Test
	public void GetPowerOut_ReturnsPowerStateOff_WhenSwitchModelConstructedWithClosedFalseAndPowerStateOn() {
		final SwitchModel systemUnderTest = new SwitchModel(false,
				PowerState.on);

		final PowerState actualValue = systemUnderTest.getPowerOut();

		assertEquals(PowerState.off, actualValue);
	}

	@Test
	public void GetPowerOut_ReturnsPowerStateOff_WhenSwitchModelConstructedWithClosedTrueAndNoPowerState() {
		final SwitchModel systemUnderTest = new SwitchModel(true);

		final PowerState actualValue = systemUnderTest.getPowerOut();

		assertEquals(PowerState.off, actualValue);
	}

	@Test
	public void GetPowerOut_ReturnsPowerStateOff_WhenSwitchModelConstructedWithClosedTrueAndPowerStateOff() {
		final SwitchModel systemUnderTest = new SwitchModel(true,
				PowerState.off);

		final PowerState actualValue = systemUnderTest.getPowerOut();

		assertEquals(PowerState.off, actualValue);
	}

	@Test
	public void GetPowerOut_ReturnsPowerStateOff_WhenSwitchModelConstructedWithNoParameters() {
		final SwitchModel systemUnderTest = new SwitchModel();

		final PowerState actualValue = systemUnderTest.getPowerOut();

		assertEquals(PowerState.off, actualValue);
	}

	@Test
	public void GetPowerOut_ReturnsPowerStateOff_WhenSwitchModelConstructedWithoutClosedAndPowerStateOff() {
		final SwitchModel systemUnderTest = new SwitchModel(PowerState.off);

		final PowerState actualValue = systemUnderTest.getPowerOut();

		assertEquals(PowerState.off, actualValue);
	}

	@Test
	public void GetPowerOut_ReturnsPowerStateOff_WhenSwitchModelConstructedWithoutClosedAndPowerStateOn() {
		final SwitchModel systemUnderTest = new SwitchModel(PowerState.on);

		final PowerState actualValue = systemUnderTest.getPowerOut();

		assertEquals(PowerState.off, actualValue);
	}

	@Test
	public void GetPowerOut_ReturnsPowerStateOn_WhenClosedTrueAndSetPowerInCalledWithPowerStateOn() {
		final SwitchModel systemUnderTest = new SwitchModel(true);
		systemUnderTest.setPowerIn(PowerState.on);

		final PowerState actualValue = systemUnderTest.getPowerOut();

		assertEquals(PowerState.on, actualValue);
	}

	@Test
	public void GetPowerOut_ReturnsPowerStateOn_WhenSwitchModelConstructedWithClosedTrueAndPowerStateOn() {
		final SwitchModel systemUnderTest = new SwitchModel(true, PowerState.on);

		final PowerState actualValue = systemUnderTest.getPowerOut();

		assertEquals(PowerState.on, actualValue);
	}

	@Test
	public void IsClosed_ReturnsFalse_WhenSetClosedCalledWIthFalse() {
		final SwitchModel systemUnderTest = new SwitchModel(true);

		systemUnderTest.setClosed(false);

		assertFalse(systemUnderTest.isClosed());
	}

	@Test
	public void IsClosed_ReturnsFalse_WhenSwitchModelConstructedWithNoParameters() {
		final SwitchModel systemUnderTest = new SwitchModel();

		assertFalse(systemUnderTest.isClosed());
	}

	@Test
	public void IsClosed_ReturnsTrue_WhenSetClosedCalledWIthTrue() {
		final SwitchModel systemUnderTest = new SwitchModel(false);

		systemUnderTest.setClosed(true);

		assertTrue(systemUnderTest.isClosed());
	}

	@Test
	public void SetClosed_DoesNotFirePropertyChanged_WhenCalledWithFalseAndInitializedWithFalse() {
		final PropertyChangeExpectation[] expectedChanges = new PropertyChangeExpectation[] { new PropertyChangeExpectation(
				"closed") };
		final SwitchModel systemUnderTest = new SwitchModel(false);

		final PropertyChangeListener listener = PropertyChangeExpectation
				.getListener(expectedChanges);

		systemUnderTest.addPropertyChangeListener(listener);
		systemUnderTest.setClosed(false);
		systemUnderTest.removePropertyChangeListener(listener);

		assertFalse(expectedChanges[0].getPropertyChanged());
	}

	@Test
	public void SetClosed_FiresPowerOutPropertyChanged_WhenCalledWithFalseAndInitializedWithTrueAndPowerOn() {
		final PropertyChangeExpectation[] expectedChanges = new PropertyChangeExpectation[] {
				new PropertyChangeExpectation("closed"),
				new PropertyChangeExpectation("powerOut") };

		final SwitchModel systemUnderTest = new SwitchModel(true, PowerState.on);

		final PropertyChangeListener listener = PropertyChangeExpectation
				.getListener(expectedChanges);

		systemUnderTest.addPropertyChangeListener(listener);
		systemUnderTest.setClosed(false);
		systemUnderTest.removePropertyChangeListener(listener);

		assertTrue(expectedChanges[1].getPropertyChanged());
	}

	@Test
	public void SetClosed_FiresPowerOutPropertyChanged_WhenCalledWithTrueAndInitializedWithFalseAndPowerOn() {
		final PropertyChangeExpectation[] expectedChanges = new PropertyChangeExpectation[] {
				new PropertyChangeExpectation("closed"),
				new PropertyChangeExpectation("powerOut") };

		final SwitchModel systemUnderTest = new SwitchModel(false,
				PowerState.on);

		final PropertyChangeListener listener = PropertyChangeExpectation
				.getListener(expectedChanges);

		systemUnderTest.addPropertyChangeListener(listener);
		systemUnderTest.setClosed(true);
		systemUnderTest.removePropertyChangeListener(listener);

		assertTrue(expectedChanges[1].getPropertyChanged());
	}

	@Test
	public void SetClosed_FiresPropertyChanged_WhenCalledWithFalseAndInitializedWithTrue() {
		final PropertyChangeExpectation[] expectedChanges = new PropertyChangeExpectation[] { new PropertyChangeExpectation(
				"closed") };
		final SwitchModel systemUnderTest = new SwitchModel(true);

		final PropertyChangeListener listener = PropertyChangeExpectation
				.getListener(expectedChanges);

		systemUnderTest.addPropertyChangeListener(listener);
		systemUnderTest.setClosed(false);
		systemUnderTest.removePropertyChangeListener(listener);

		assertTrue(expectedChanges[0].getPropertyChanged());
	}

	@Test
	public void SetClosed_FiresPropertyChanged_WhenCalledWithTrueAndInitializedWithFalse() {
		final PropertyChangeExpectation[] expectedChanges = new PropertyChangeExpectation[] { new PropertyChangeExpectation(
				"closed") };
		final SwitchModel systemUnderTest = new SwitchModel(false);

		final PropertyChangeListener listener = PropertyChangeExpectation
				.getListener(expectedChanges);

		systemUnderTest.addPropertyChangeListener(listener);
		systemUnderTest.setClosed(true);
		systemUnderTest.removePropertyChangeListener(listener);

		assertTrue(expectedChanges[0].getPropertyChanged());
	}
}

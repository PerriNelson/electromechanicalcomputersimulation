/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package userInterface.Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.beans.PropertyChangeListener;

import org.junit.Test;

import userInterface.SwitchModel;
import userInterface.Interfaces.PowerState;

public class SwitchModelTest {

	@Test
	public void GetPowerOut_ReturnsPowerStateOff_WhenClosedFalseAndSetPowerInCalledWithPowerStateOff() {
		SwitchModel systemUnderTest = new SwitchModel(false);
		systemUnderTest.setPowerIn(PowerState.off);

		PowerState actualValue = systemUnderTest.getPowerOut();

		assertEquals(PowerState.off, actualValue);
	}

	@Test
	public void GetPowerOut_ReturnsPowerStateOff_WhenClosedFalseAndSetPowerInCalledWithPowerStateOn() {
		SwitchModel systemUnderTest = new SwitchModel(false);
		systemUnderTest.setPowerIn(PowerState.on);

		PowerState actualValue = systemUnderTest.getPowerOut();

		assertEquals(PowerState.off, actualValue);
	}

	@Test
	public void GetPowerOut_ReturnsPowerStateOff_WhenClosedTrueAndSetPowerInCalledWithPowerStateOff() {
		SwitchModel systemUnderTest = new SwitchModel(true);
		systemUnderTest.setPowerIn(PowerState.off);

		PowerState actualValue = systemUnderTest.getPowerOut();

		assertEquals(PowerState.off, actualValue);
	}

	@Test
	public void GetPowerOut_ReturnsPowerStateOff_WhenSwitchModelConstructedWithClosedFalseAndNoPowerState() {
		SwitchModel systemUnderTest = new SwitchModel(false);

		PowerState actualValue = systemUnderTest.getPowerOut();

		assertEquals(PowerState.off, actualValue);
	}

	@Test
	public void GetPowerOut_ReturnsPowerStateOff_WhenSwitchModelConstructedWithClosedFalseAndPowerStateOff() {
		SwitchModel systemUnderTest = new SwitchModel(false, PowerState.off);

		PowerState actualValue = systemUnderTest.getPowerOut();

		assertEquals(PowerState.off, actualValue);
	}

	@Test
	public void GetPowerOut_ReturnsPowerStateOff_WhenSwitchModelConstructedWithClosedFalseAndPowerStateOn() {
		SwitchModel systemUnderTest = new SwitchModel(false, PowerState.on);

		PowerState actualValue = systemUnderTest.getPowerOut();

		assertEquals(PowerState.off, actualValue);
	}

	@Test
	public void GetPowerOut_ReturnsPowerStateOff_WhenSwitchModelConstructedWithClosedTrueAndNoPowerState() {
		SwitchModel systemUnderTest = new SwitchModel(true);

		PowerState actualValue = systemUnderTest.getPowerOut();

		assertEquals(PowerState.off, actualValue);
	}

	@Test
	public void GetPowerOut_ReturnsPowerStateOff_WhenSwitchModelConstructedWithClosedTrueAndPowerStateOff() {
		SwitchModel systemUnderTest = new SwitchModel(true, PowerState.off);

		PowerState actualValue = systemUnderTest.getPowerOut();

		assertEquals(PowerState.off, actualValue);
	}

	@Test
	public void GetPowerOut_ReturnsPowerStateOff_WhenSwitchModelConstructedWithNoParameters() {
		SwitchModel systemUnderTest = new SwitchModel();

		PowerState actualValue = systemUnderTest.getPowerOut();

		assertEquals(PowerState.off, actualValue);
	}

	@Test
	public void GetPowerOut_ReturnsPowerStateOff_WhenSwitchModelConstructedWithoutClosedAndPowerStateOff() {
		SwitchModel systemUnderTest = new SwitchModel(PowerState.off);

		PowerState actualValue = systemUnderTest.getPowerOut();

		assertEquals(PowerState.off, actualValue);
	}

	@Test
	public void GetPowerOut_ReturnsPowerStateOff_WhenSwitchModelConstructedWithoutClosedAndPowerStateOn() {
		SwitchModel systemUnderTest = new SwitchModel(PowerState.on);

		PowerState actualValue = systemUnderTest.getPowerOut();

		assertEquals(PowerState.off, actualValue);
	}

	@Test
	public void GetPowerOut_ReturnsPowerStateOn_WhenClosedTrueAndSetPowerInCalledWithPowerStateOn() {
		SwitchModel systemUnderTest = new SwitchModel(true);
		systemUnderTest.setPowerIn(PowerState.on);

		PowerState actualValue = systemUnderTest.getPowerOut();

		assertEquals(PowerState.on, actualValue);
	}

	@Test
	public void GetPowerOut_ReturnsPowerStateOn_WhenSwitchModelConstructedWithClosedTrueAndPowerStateOn() {
		SwitchModel systemUnderTest = new SwitchModel(true, PowerState.on);

		PowerState actualValue = systemUnderTest.getPowerOut();

		assertEquals(PowerState.on, actualValue);
	}

	@Test
	public void IsClosed_ReturnsFalse_WhenSetClosedCalledWIthFalse() {
		SwitchModel systemUnderTest = new SwitchModel(true);

		systemUnderTest.setClosed(false);

		assertFalse(systemUnderTest.isClosed());
	}

	@Test
	public void IsClosed_ReturnsFalse_WhenSwitchModelConstructedWithNoParameters() {
		SwitchModel systemUnderTest = new SwitchModel();

		assertFalse(systemUnderTest.isClosed());
	}

	@Test
	public void IsClosed_ReturnsTrue_WhenSetClosedCalledWIthTrue() {
		SwitchModel systemUnderTest = new SwitchModel(false);

		systemUnderTest.setClosed(true);

		assertTrue(systemUnderTest.isClosed());
	}

	@Test
	public void SetClosed_DoesNotFirePropertyChanged_WhenCalledWithFalseAndInitializedWithFalse() {
		PropertyChangeExpectation[] expectedChanges = new PropertyChangeExpectation[] { new PropertyChangeExpectation(
				"closed") };
		SwitchModel systemUnderTest = new SwitchModel(false);

		PropertyChangeListener listener = PropertyChangeExpectation
				.getListener(expectedChanges);

		systemUnderTest.addPropertyChangeListener(listener);
		systemUnderTest.setClosed(false);
		systemUnderTest.removePropertyChangeListener(listener);

		assertFalse(expectedChanges[0].getPropertyChanged());
	}

	@Test
	public void SetClosed_FiresPowerOutPropertyChanged_WhenCalledWithFalseAndInitializedWithTrueAndPowerOn() {
		PropertyChangeExpectation[] expectedChanges = new PropertyChangeExpectation[] {
				new PropertyChangeExpectation("closed"),
				new PropertyChangeExpectation("powerOut") };

		SwitchModel systemUnderTest = new SwitchModel(true, PowerState.on);

		PropertyChangeListener listener = PropertyChangeExpectation
				.getListener(expectedChanges);

		systemUnderTest.addPropertyChangeListener(listener);
		systemUnderTest.setClosed(false);
		systemUnderTest.removePropertyChangeListener(listener);

		assertTrue(expectedChanges[1].getPropertyChanged());
	}

	@Test
	public void SetClosed_FiresPowerOutPropertyChanged_WhenCalledWithTrueAndInitializedWithFalseAndPowerOn() {
		PropertyChangeExpectation[] expectedChanges = new PropertyChangeExpectation[] {
				new PropertyChangeExpectation("closed"),
				new PropertyChangeExpectation("powerOut") };

		SwitchModel systemUnderTest = new SwitchModel(false, PowerState.on);

		PropertyChangeListener listener = PropertyChangeExpectation
				.getListener(expectedChanges);

		systemUnderTest.addPropertyChangeListener(listener);
		systemUnderTest.setClosed(true);
		systemUnderTest.removePropertyChangeListener(listener);

		assertTrue(expectedChanges[1].getPropertyChanged());
	}

	@Test
	public void SetClosed_FiresPropertyChanged_WhenCalledWithFalseAndInitializedWithTrue() {
		PropertyChangeExpectation[] expectedChanges = new PropertyChangeExpectation[] { new PropertyChangeExpectation(
				"closed") };
		SwitchModel systemUnderTest = new SwitchModel(true);

		PropertyChangeListener listener = PropertyChangeExpectation
				.getListener(expectedChanges);

		systemUnderTest.addPropertyChangeListener(listener);
		systemUnderTest.setClosed(false);
		systemUnderTest.removePropertyChangeListener(listener);

		assertTrue(expectedChanges[0].getPropertyChanged());
	}

	@Test
	public void SetClosed_FiresPropertyChanged_WhenCalledWithTrueAndInitializedWithFalse() {
		PropertyChangeExpectation[] expectedChanges = new PropertyChangeExpectation[] { new PropertyChangeExpectation(
				"closed") };
		SwitchModel systemUnderTest = new SwitchModel(false);

		PropertyChangeListener listener = PropertyChangeExpectation
				.getListener(expectedChanges);

		systemUnderTest.addPropertyChangeListener(listener);
		systemUnderTest.setClosed(true);
		systemUnderTest.removePropertyChangeListener(listener);

		assertTrue(expectedChanges[0].getPropertyChanged());
	}
}

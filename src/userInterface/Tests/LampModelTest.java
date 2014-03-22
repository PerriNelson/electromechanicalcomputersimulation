/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package userInterface.Tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.beans.PropertyChangeListener;

import org.junit.Before;
import org.junit.Test;

import userInterface.LampModel;

public class LampModelTest {

	private PropertyChangeExpectation[] expectedChanges;
	private LampModel systemUnderTest;

	@Test
	public void IsOn_ReturnsFalse_WhenCalledAfterInitialization() {
		assertFalse(systemUnderTest.isOn());
	}

	@Test
	public void IsOn_ReturnsTrue_WhenCalledAfterSetOnCalledWithTrue() {
		systemUnderTest.setOn(true);
		assertTrue(systemUnderTest.isOn());
	}

	@Test
	public void SetOn_DoesNotFireOnPropertyChanged_WhenCalledWithFalseAfterInitialized() {
		PropertyChangeListener listener = PropertyChangeExpectation
				.getListener(expectedChanges);

		systemUnderTest.addPropertyChangeListener(listener);
		systemUnderTest.setOn(false);
		systemUnderTest.removePropertyChangeListener(listener);

		assertFalse(expectedChanges[0].getPropertyChanged());
	}

	@Test
	public void SetOn_DoesNotFireOnPropertyChanged_WhenCalledWithTrueAfterCalledWithTrue() {
		systemUnderTest.setOn(true);

		PropertyChangeListener listener = PropertyChangeExpectation
				.getListener(expectedChanges);

		systemUnderTest.addPropertyChangeListener(listener);
		systemUnderTest.setOn(true);
		systemUnderTest.removePropertyChangeListener(listener);

		assertFalse(expectedChanges[0].getPropertyChanged());
	}

	@Test
	public void SetOn_FiresOnPropertyChanged_WhenCalledWithFalseAfterCalledWithTrue() {
		systemUnderTest.setOn(true);

		PropertyChangeListener listener = PropertyChangeExpectation
				.getListener(expectedChanges);

		systemUnderTest.addPropertyChangeListener(listener);
		systemUnderTest.setOn(false);
		systemUnderTest.removePropertyChangeListener(listener);

		assertTrue(expectedChanges[0].getPropertyChanged());
	}

	@Test
	public void SetOn_FiresOnPropertyChanged_WhenCalledWithTrueAfterInitialization() {

		PropertyChangeListener listener = PropertyChangeExpectation
				.getListener(expectedChanges);

		systemUnderTest.addPropertyChangeListener(listener);
		systemUnderTest.setOn(true);
		systemUnderTest.removePropertyChangeListener(listener);

		assertTrue(expectedChanges[0].getPropertyChanged());
	}

	@Before
	public void SetUp() {
		expectedChanges = new PropertyChangeExpectation[] { new PropertyChangeExpectation(
				"on") };
		systemUnderTest = new LampModel();
	}

}

/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Model;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.event.EventListenerList;

import electroMechanicalLogic.EightBitAdder;
import electroMechanicalMachine.Model.Interfaces.IAddingMachineMarkIModel;

public class AddingMachineMarkIModel implements IAddingMachineMarkIModel {

	private final EightBitAdder adder = new EightBitAdder();
	private final EventListenerList eventListeners = new EventListenerList();

	@Override
	public void addPropertyChangeListener(final PropertyChangeListener listener) {
		eventListeners.add(PropertyChangeListener.class, listener);
	}

	protected void fireOnPropertyChange() {
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
	public boolean getCO() {
		return adder.getCO();
	}

	@Override
	public boolean getS0() {
		return adder.getS0();
	}

	@Override
	public boolean getS1() {
		return adder.getS1();
	}

	@Override
	public boolean getS2() {
		return adder.getS2();
	}

	@Override
	public boolean getS3() {
		return adder.getS3();
	}

	@Override
	public boolean getS4() {
		return adder.getS4();
	}

	@Override
	public boolean getS5() {
		return adder.getS5();
	}

	@Override
	public boolean getS6() {
		return adder.getS6();
	}

	@Override
	public boolean getS7() {
		return adder.getS7();
	}

	@Override
	public void removePropertyChangeListener(
			final PropertyChangeListener listener) {
		eventListeners.remove(PropertyChangeListener.class, listener);
	}

	@Override
	public void setA0(final boolean value) {
		adder.setA0(value);
	}

	@Override
	public void setA1(final boolean value) {
		adder.setA1(value);
	}

	@Override
	public void setA2(final boolean value) {
		adder.setA2(value);
	}

	@Override
	public void setA3(final boolean value) {
		adder.setA3(value);
	}

	@Override
	public void setA4(final boolean value) {
		adder.setA4(value);
	}

	@Override
	public void setA5(final boolean value) {
		adder.setA5(value);
	}

	@Override
	public void setA6(final boolean value) {
		adder.setA6(value);
	}

	@Override
	public void setA7(final boolean value) {
		adder.setA7(value);
	}

	@Override
	public void setB0(final boolean value) {
		adder.setB0(value);
	}

	@Override
	public void setB1(final boolean value) {
		adder.setB1(value);
	}

	@Override
	public void setB2(final boolean value) {
		adder.setB2(value);
	}

	@Override
	public void setB3(final boolean value) {
		adder.setB3(value);
	}

	@Override
	public void setB4(final boolean value) {
		adder.setB4(value);
	}

	@Override
	public void setB5(final boolean value) {
		adder.setB5(value);
	}

	@Override
	public void setB6(final boolean value) {
		adder.setB6(value);
	}

	@Override
	public void setB7(final boolean value) {
		adder.setB7(value);
	}

	@Override
	public void setCI(final boolean value) {
		adder.setCI(value);
	}

	@Override
	public void setPower(final boolean value) {
		adder.setPower(value);
	}

	@Override
	public void step() {
		adder.step();
		fireOnPropertyChange();
	}
}

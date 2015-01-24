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
import electroMechanicalLogic.EightBitTwoToOneSelector;
import electroMechanicalLogic.Interfaces.IEightBitAdder;
import electroMechanicalLogic.Interfaces.IEightBitLatch;
import electroMechanicalLogic.Interfaces.IEightBitTwoToOneSelector;
import electroMechanicalMachine.Model.Interfaces.IAddingMachineMarkIIIModel;

public class AddingMachineMarkIIIModel implements IAddingMachineMarkIIIModel {

	private final IEightBitAdder adder = new EightBitAdder();
	private final IEightBitLatch latch;
	private final IEightBitTwoToOneSelector selector = new EightBitTwoToOneSelector();
	private final EventListenerList eventListeners = new EventListenerList();

	public AddingMachineMarkIIIModel(final IEightBitLatch eightBitLatch) {
		latch = eightBitLatch;
	}

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
		selector.setA0(value);
	}

	@Override
	public void setB1(final boolean value) {
		selector.setA1(value);
	}

	@Override
	public void setB2(final boolean value) {
		selector.setA2(value);
	}

	@Override
	public void setB3(final boolean value) {
		selector.setA3(value);
	}

	@Override
	public void setB4(final boolean value) {
		selector.setA4(value);
	}

	@Override
	public void setB5(final boolean value) {
		selector.setA5(value);
	}

	@Override
	public void setB6(final boolean value) {
		selector.setA6(value);
	}

	@Override
	public void setB7(final boolean value) {
		selector.setA7(value);
	}

	@Override
	public void setFromLatch(final boolean value) {
		selector.setSelect(value);
	}

	@Override
	public void setPower(final boolean value) {
		adder.setPower(true);
		latch.setPower(true);
		selector.setPower(true);
	}

	@Override
	public void setSave(final boolean value) {
		latch.setW(value);
	}

	@Override
	public void step() {
		selector.step();

		adder.setB0(selector.getDO0());
		adder.setB1(selector.getDO1());
		adder.setB2(selector.getDO2());
		adder.setB3(selector.getDO3());
		adder.setB4(selector.getDO4());
		adder.setB5(selector.getDO5());
		adder.setB6(selector.getDO6());
		adder.setB7(selector.getDO7());

		adder.step();

		latch.setDI0(adder.getS0());
		latch.setDI1(adder.getS1());
		latch.setDI2(adder.getS2());
		latch.setDI3(adder.getS3());
		latch.setDI4(adder.getS4());
		latch.setDI5(adder.getS5());
		latch.setDI6(adder.getS6());
		latch.setDI7(adder.getS7());

		latch.step();

		selector.setB0(latch.getDO0());
		selector.setB1(latch.getDO1());
		selector.setB2(latch.getDO2());
		selector.setB3(latch.getDO3());
		selector.setB4(latch.getDO4());
		selector.setB5(latch.getDO5());
		selector.setB6(latch.getDO6());
		selector.setB7(latch.getDO7());
		fireOnPropertyChange();
	}

}

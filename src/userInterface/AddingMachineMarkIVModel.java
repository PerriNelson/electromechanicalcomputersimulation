/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package userInterface;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.event.EventListenerList;

import electroMechanicalLogic.EightBitAdder;
import electroMechanicalLogic.Interfaces.IEightBitAdder;
import electroMechanicalLogic.Interfaces.IEightBitLatchWithClear;

import userInterface.Interfaces.IAddingMachineMarkIVModel;

public class AddingMachineMarkIVModel implements IAddingMachineMarkIVModel {
	private final IEightBitAdder adder = new EightBitAdder();
	private IEightBitLatchWithClear latch;
	private EventListenerList eventListeners = new EventListenerList();

	public AddingMachineMarkIVModel(IEightBitLatchWithClear theLatch) {
		latch = theLatch;
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		eventListeners.add(PropertyChangeListener.class, listener);
	}

	protected void fireOnPropertyChange() {
		PropertyChangeEvent propertyChangeEvent = null;

		Object[] listeners = eventListeners.getListenerList();
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
	public boolean getS0() {
		return latch.getDO0();
	}

	@Override
	public boolean getS1() {
		return latch.getDO1();
	}

	@Override
	public boolean getS2() {
		return latch.getDO2();
	}

	@Override
	public boolean getS3() {
		return latch.getDO3();
	}

	@Override
	public boolean getS4() {
		return latch.getDO4();
	}

	@Override
	public boolean getS5() {
		return latch.getDO5();
	}

	@Override
	public boolean getS6() {
		return latch.getDO6();
	}

	@Override
	public boolean getS7() {
		return latch.getDO7();
	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		eventListeners.remove(PropertyChangeListener.class, listener);
	}

	@Override
	public void setA0(boolean value) {
		adder.setA0(value);
	}

	@Override
	public void setA1(boolean value) {
		adder.setA1(value);
	}

	@Override
	public void setA2(boolean value) {
		adder.setA2(value);
	}

	@Override
	public void setA3(boolean value) {
		adder.setA3(value);
	}

	@Override
	public void setA4(boolean value) {
		adder.setA4(value);
	}

	@Override
	public void setA5(boolean value) {
		adder.setA5(value);
	}

	@Override
	public void setA6(boolean value) {
		adder.setA6(value);
	}

	@Override
	public void setA7(boolean value) {
		adder.setA7(value);
	}

	@Override
	public void setAdd(boolean value) {
		latch.setW(value);
	}

	@Override
	public void setClear(boolean value) {
		latch.setClr(value);
	}

	@Override
	public void setPower(boolean value) {
		adder.setPower(value);
		latch.setPower(value);
	}

	@Override
	public void step() {
		adder.setB0(latch.getDO0());
		adder.setB1(latch.getDO1());
		adder.setB2(latch.getDO2());
		adder.setB3(latch.getDO3());
		adder.setB4(latch.getDO4());
		adder.setB5(latch.getDO5());
		adder.setB6(latch.getDO6());
		adder.setB7(latch.getDO7());

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

		fireOnPropertyChange();
	}

}

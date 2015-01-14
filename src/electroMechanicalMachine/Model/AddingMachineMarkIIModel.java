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
import electroMechanicalLogic.EightBitOnesComplement;
import electroMechanicalLogic.TwoInputXOrGate;
import electroMechanicalLogic.Interfaces.IEightBitAdder;
import electroMechanicalLogic.Interfaces.IEightBitOnesComplement;
import electroMechanicalLogic.Interfaces.ITwoInputSingleOutputGate;
import electroMechanicalMachine.Model.Interfaces.IAddingMachineMarkIIModel;

public class AddingMachineMarkIIModel implements IAddingMachineMarkIIModel {

	private final IEightBitAdder adder = new EightBitAdder();
	private final IEightBitOnesComplement complement = new EightBitOnesComplement();
	private final ITwoInputSingleOutputGate overflowUnderflow = new TwoInputXOrGate();
	private EventListenerList eventListeners = new EventListenerList();

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
	public boolean getOverflow() {
		return overflowUnderflow.getOutput();
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
	public void setB0(boolean value) {
		complement.setI0(value);
	}

	@Override
	public void setB1(boolean value) {
		complement.setI1(value);
	}

	@Override
	public void setB2(boolean value) {
		complement.setI2(value);
	}

	@Override
	public void setB3(boolean value) {
		complement.setI3(value);
	}

	@Override
	public void setB4(boolean value) {
		complement.setI4(value);
	}

	@Override
	public void setB5(boolean value) {
		complement.setI5(value);
	}

	@Override
	public void setB6(boolean value) {
		complement.setI6(value);
	}

	@Override
	public void setB7(boolean value) {
		complement.setI7(value);
	}

	@Override
	public void setPower(boolean value) {
		adder.setPower(value);
		complement.setPower(value);
		overflowUnderflow.setPower(value);
	}

	@Override
	public void setSubtract(boolean value) {
		complement.setInvert(value);
		adder.setCI(value);
		overflowUnderflow.setB(value);
	}

	@Override
	public void step() {
		complement.step();

		adder.setB0(complement.getO0());
		adder.setB1(complement.getO1());
		adder.setB2(complement.getO2());
		adder.setB3(complement.getO3());
		adder.setB4(complement.getO4());
		adder.setB5(complement.getO5());
		adder.setB6(complement.getO6());
		adder.setB7(complement.getO7());

		adder.step();

		overflowUnderflow.setA(adder.getCO());
		overflowUnderflow.step();

		fireOnPropertyChange();
	}
}
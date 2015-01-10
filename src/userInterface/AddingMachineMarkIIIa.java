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

import userInterface.Interfaces.PowerState;
import electroMechanicalLogic.EightBitAdder;
import electroMechanicalLogic.EightBitEdgeTriggeredLatchWithClear;
import electroMechanicalLogic.EightBitLatch;
import electroMechanicalLogic.EightBitTwoToOneSelector;

public class AddingMachineMarkIIIa extends BasicUIFrame implements
		PropertyChangeListener {
	public static final long serialVersionUID = 1l;
	private static final String powerOutPropertyName = "powerOut";

	private static final int aRow = 0;
	private static final int bRow = 1;
	private static final int lampRow = 2;

	private static final int columnCO = 0;
	private static final int columnControl = 10;
	private static final int columnLabel = 9;
	private static final int column0 = 8;
	private static final int column1 = 7;
	private static final int column2 = 6;
	private static final int column3 = 5;
	private static final int column4 = 4;
	private static final int column5 = 3;
	private static final int column6 = 2;
	private static final int column7 = 1;

	public static void main(String[] args) {
		AddingMachineMarkIIIa frame = new AddingMachineMarkIIIa();
		frame.setVisible(true);
	}

	private ToggleSwitch toggleSwitchA0;
	private ToggleSwitch toggleSwitchB0;
	private ToggleSwitch toggleSwitchA1;
	private ToggleSwitch toggleSwitchB1;
	private ToggleSwitch toggleSwitchA2;
	private ToggleSwitch toggleSwitchB2;
	private ToggleSwitch toggleSwitchA3;
	private ToggleSwitch toggleSwitchB3;
	private ToggleSwitch toggleSwitchA4;
	private ToggleSwitch toggleSwitchB4;
	private ToggleSwitch toggleSwitchA5;
	private ToggleSwitch toggleSwitchB5;
	private ToggleSwitch toggleSwitchA6;
	private ToggleSwitch toggleSwitchB6;
	private ToggleSwitch toggleSwitchA7;
	private ToggleSwitch toggleSwitchB7;
	private ToggleSwitch toggleSwitchSave;
	private ToggleSwitch toggleSwitchFromLatch;
	private Lamp lampCO;
	private Lamp lampS0;
	private Lamp lampS1;
	private Lamp lampS2;
	private Lamp lampS3;
	private Lamp lampS4;
	private Lamp lampS5;
	private Lamp lampS6;
	private Lamp lampS7;
	private EightBitAdder adder;
	private EightBitEdgeTriggeredLatchWithClear latch;
	private EightBitTwoToOneSelector selector;

	public AddingMachineMarkIIIa() {
		super("Adding Machine Mark IIIa");
		setSize(650, 300);

		adder = new EightBitAdder();
		adder.setPower(true);
		latch = new EightBitEdgeTriggeredLatchWithClear();
		latch.setPower(true);
		selector = new EightBitTwoToOneSelector();
		selector.setPower(true);

		toggleSwitchA0 = placeToggleSwitch(column0, aRow);
		toggleSwitchA1 = placeToggleSwitch(column1, aRow);
		toggleSwitchA2 = placeToggleSwitch(column2, aRow);
		toggleSwitchA3 = placeToggleSwitch(column3, aRow);
		toggleSwitchA4 = placeToggleSwitch(column4, aRow);
		toggleSwitchA5 = placeToggleSwitch(column5, aRow);
		toggleSwitchA6 = placeToggleSwitch(column6, aRow);
		toggleSwitchA7 = placeToggleSwitch(column7, aRow);

		toggleSwitchB0 = placeToggleSwitch(column0, bRow);
		toggleSwitchB1 = placeToggleSwitch(column1, bRow);
		toggleSwitchB2 = placeToggleSwitch(column2, bRow);
		toggleSwitchB3 = placeToggleSwitch(column3, bRow);
		toggleSwitchB4 = placeToggleSwitch(column4, bRow);
		toggleSwitchB5 = placeToggleSwitch(column5, bRow);
		toggleSwitchB6 = placeToggleSwitch(column6, bRow);
		toggleSwitchB7 = placeToggleSwitch(column7, bRow);
		
		toggleSwitchSave = placeToggleSwitch(columnControl, aRow);
		toggleSwitchFromLatch = placeToggleSwitch(columnControl, bRow);

		placeLabel("images/SaveLabel.jpg", "Save", columnLabel, aRow, 1);
		placeLabel("images/FromLatchLabel.jpg", "From Latch", columnLabel, bRow, 1);

		lampCO = placeLamp(columnCO, lampRow);
		lampS0 = placeLamp(column0, lampRow);
		lampS1 = placeLamp(column1, lampRow);
		lampS2 = placeLamp(column2, lampRow);
		lampS3 = placeLamp(column3, lampRow);
		lampS4 = placeLamp(column4, lampRow);
		lampS5 = placeLamp(column5, lampRow);
		lampS6 = placeLamp(column6, lampRow);
		lampS7 = placeLamp(column7, lampRow);

		placeLabel("images/PlusLabel.jpg", " + ", columnCO, bRow, 1);
	}

	@Override
	protected ToggleSwitch placeToggleSwitch(int column, int row) {
		ToggleSwitch toggleSwitch = super.placeToggleSwitch(column, row);
		toggleSwitch.addPropertyChangeListener(this);
		return toggleSwitch;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (powerOutPropertyName.equalsIgnoreCase(evt.getPropertyName())) {
			boolean powerState = PowerState.on == evt.getNewValue();
			
			if (evt.getSource() == toggleSwitchA0) {
				adder.setA0(powerState);
			} else if (evt.getSource() == toggleSwitchA1) {
				adder.setA1(powerState);
			} else if (evt.getSource() == toggleSwitchA2) {
				adder.setA2(powerState);
			} else if (evt.getSource() == toggleSwitchA3) {
				adder.setA3(powerState);
			} else if (evt.getSource() == toggleSwitchA4) {
				adder.setA4(powerState);
			} else if (evt.getSource() == toggleSwitchA5) {
				adder.setA5(powerState);
			} else if (evt.getSource() == toggleSwitchA6) {
				adder.setA6(powerState);
			} else if (evt.getSource() == toggleSwitchA7) {
				adder.setA7(powerState);
			} else if (evt.getSource() == toggleSwitchB0) {
				selector.setA0(powerState);
			} else if (evt.getSource() == toggleSwitchB1) {
				selector.setA1(powerState);
			} else if (evt.getSource() == toggleSwitchB2) {
				selector.setA2(powerState);
			} else if (evt.getSource() == toggleSwitchB3) {
				selector.setA3(powerState);
			} else if (evt.getSource() == toggleSwitchB4) {
				selector.setA4(powerState);
			} else if (evt.getSource() == toggleSwitchB5) {
				selector.setA5(powerState);
			} else if (evt.getSource() == toggleSwitchB6) {
				selector.setA6(powerState);
			} else if (evt.getSource() == toggleSwitchB7) {
				selector.setA7(powerState);
			} else if (evt.getSource() == toggleSwitchSave) {
				latch.setW(powerState);
			} else if (evt.getSource() == toggleSwitchFromLatch) {
				selector.setSelect(powerState);
			}
		}

		step();
	}

	private void step() {
		selector.step();
		
		adder.setB0(selector.getO0());
		adder.setB1(selector.getO1());
		adder.setB2(selector.getO2());
		adder.setB3(selector.getO3());
		adder.setB4(selector.getO4());
		adder.setB5(selector.getO5());
		adder.setB6(selector.getO6());
		adder.setB7(selector.getO7());

		adder.step();
		
		lampCO.setOn(adder.getCO());
		lampS0.setOn(adder.getS0());
		lampS1.setOn(adder.getS1());
		lampS2.setOn(adder.getS2());
		lampS3.setOn(adder.getS3());
		lampS4.setOn(adder.getS4());
		lampS5.setOn(adder.getS5());
		lampS6.setOn(adder.getS6());
		lampS7.setOn(adder.getS7());

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
	}
}

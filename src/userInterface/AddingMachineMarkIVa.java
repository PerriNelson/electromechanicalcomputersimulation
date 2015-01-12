/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package userInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Timer;

import userInterface.Interfaces.PowerState;
import electroMechanicalLogic.EightBitAdder;
import electroMechanicalLogic.EightBitEdgeTriggeredLatchWithClear;

public class AddingMachineMarkIVa extends BasicUIFrame implements
		PropertyChangeListener {
	public static final long serialVersionUID = 1l;
	private static final String powerOutPropertyName = "powerOut";

	private static final int aRow = 0;
	private static final int bRow = 1;
	private static final int lampRow = 1;

	private static final int columnControl = 9;
	private static final int columnLabel = 8;
	private static final int column0 = 7;
	private static final int column1 = 6;
	private static final int column2 = 5;
	private static final int column3 = 4;
	private static final int column4 = 3;
	private static final int column5 = 2;
	private static final int column6 = 1;
	private static final int column7 = 0;

	public static void main(String[] args) {
		AddingMachineMarkIVa frame = new AddingMachineMarkIVa();
		frame.setVisible(true);
	}

	private ToggleSwitch toggleSwitchA0;
	private ToggleSwitch toggleSwitchA1;
	private ToggleSwitch toggleSwitchA2;
	private ToggleSwitch toggleSwitchA3;
	private ToggleSwitch toggleSwitchA4;
	private ToggleSwitch toggleSwitchA5;
	private ToggleSwitch toggleSwitchA6;
	private ToggleSwitch toggleSwitchA7;
	private ToggleSwitch toggleSwitchAdd;
	private ToggleSwitch toggleSwitchClear;
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
	private Timer timer;

	public AddingMachineMarkIVa() {
		super("Adding Machine Mark IV");
		setSize(595, 200);

		adder = new EightBitAdder();
		adder.setPower(true);
		latch = new EightBitEdgeTriggeredLatchWithClear();
		latch.setPower(true);

		toggleSwitchA0 = placeToggleSwitch(column0, aRow);
		toggleSwitchA1 = placeToggleSwitch(column1, aRow);
		toggleSwitchA2 = placeToggleSwitch(column2, aRow);
		toggleSwitchA3 = placeToggleSwitch(column3, aRow);
		toggleSwitchA4 = placeToggleSwitch(column4, aRow);
		toggleSwitchA5 = placeToggleSwitch(column5, aRow);
		toggleSwitchA6 = placeToggleSwitch(column6, aRow);
		toggleSwitchA7 = placeToggleSwitch(column7, aRow);

		toggleSwitchAdd = placeToggleSwitch(columnControl, aRow);
		toggleSwitchClear = placeToggleSwitch(columnControl, bRow);

		placeLabel("images/AddLabel.jpg", "Add", columnLabel, aRow, 1);
		placeLabel("images/ClearLabel.jpg", "Clear", columnLabel, bRow, 1);

		lampS0 = placeLamp(column0, lampRow);
		lampS1 = placeLamp(column1, lampRow);
		lampS2 = placeLamp(column2, lampRow);
		lampS3 = placeLamp(column3, lampRow);
		lampS4 = placeLamp(column4, lampRow);
		lampS5 = placeLamp(column5, lampRow);
		lampS6 = placeLamp(column6, lampRow);
		lampS7 = placeLamp(column7, lampRow);

		timer = new Timer(10, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				step();
			}
		});
		timer.start();
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
			} else if (evt.getSource() == toggleSwitchAdd) {
				latch.setW(powerState);
			} else if (evt.getSource() == toggleSwitchClear) {
				latch.setClr(powerState);
			}
		}
	}

	private void step() {
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

		lampS0.setOn(latch.getDO0());
		lampS1.setOn(latch.getDO1());
		lampS2.setOn(latch.getDO2());
		lampS3.setOn(latch.getDO3());
		lampS4.setOn(latch.getDO4());
		lampS5.setOn(latch.getDO5());
		lampS6.setOn(latch.getDO6());
		lampS7.setOn(latch.getDO7());
	}
}

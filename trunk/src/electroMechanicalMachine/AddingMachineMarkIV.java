/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import userInterface.AutomationDriver;
import userInterface.BasicUIFrame;
import userInterface.Lamp;
import userInterface.ToggleSwitch;
import userInterface.Interfaces.IAutomationDriver;
import userInterface.Interfaces.PowerState;
import electroMechanicalLogic.EightBitLatchWithClear;
import electroMechanicalMachine.Model.AddingMachineMarkIVModel;
import electroMechanicalMachine.Model.Interfaces.IAddingMachineMarkIVModel;

public class AddingMachineMarkIV extends BasicUIFrame implements
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

	public static void main(final String[] args) {
		final AddingMachineMarkIV frame = new AddingMachineMarkIV();
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

	private IAddingMachineMarkIVModel model;
	private IAutomationDriver automationDriver;

	public AddingMachineMarkIV() {
		this("Adding Machine Mark IV", new AddingMachineMarkIVModel(
				new EightBitLatchWithClear()));
	}

	protected AddingMachineMarkIV(final String caption,
			final IAddingMachineMarkIVModel model) {
		super(caption);
		placeControls();

		initializeModel(model);

		startAutomation();
	}

	protected void initializeModel(final IAddingMachineMarkIVModel theModel) {
		model = theModel;
		model.addPropertyChangeListener(this);
		model.setPower(true);
	}

	private void placeControls() {
		setSize(595, 200);

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

		placeLabel("Labels/AddLabel.jpg", "Add", columnLabel, aRow, 1);
		placeLabel("Labels/ClearLabel.jpg", "Clear", columnLabel, bRow, 1);

		lampS0 = placeLamp(column0, lampRow);
		lampS1 = placeLamp(column1, lampRow);
		lampS2 = placeLamp(column2, lampRow);
		lampS3 = placeLamp(column3, lampRow);
		lampS4 = placeLamp(column4, lampRow);
		lampS5 = placeLamp(column5, lampRow);
		lampS6 = placeLamp(column6, lampRow);
		lampS7 = placeLamp(column7, lampRow);
	}

	@Override
	protected ToggleSwitch placeToggleSwitch(final int column, final int row) {
		final ToggleSwitch toggleSwitch = super.placeToggleSwitch(column, row);
		toggleSwitch.addPropertyChangeListener(this);
		return toggleSwitch;
	}

	@Override
	public void propertyChange(final PropertyChangeEvent evt) {
		if (powerOutPropertyName.equalsIgnoreCase(evt.getPropertyName())) {
			final boolean powerState = PowerState.on == evt.getNewValue();

			if (evt.getSource() == toggleSwitchA0) {
				model.setA0(powerState);
			} else if (evt.getSource() == toggleSwitchA1) {
				model.setA1(powerState);
			} else if (evt.getSource() == toggleSwitchA2) {
				model.setA2(powerState);
			} else if (evt.getSource() == toggleSwitchA3) {
				model.setA3(powerState);
			} else if (evt.getSource() == toggleSwitchA4) {
				model.setA4(powerState);
			} else if (evt.getSource() == toggleSwitchA5) {
				model.setA5(powerState);
			} else if (evt.getSource() == toggleSwitchA6) {
				model.setA6(powerState);
			} else if (evt.getSource() == toggleSwitchA7) {
				model.setA7(powerState);
			} else if (evt.getSource() == toggleSwitchAdd) {
				model.setAdd(powerState);
			} else if (evt.getSource() == toggleSwitchClear) {
				model.setClear(powerState);
			}
		} else if (evt.getSource() == model) {
			lampS0.setOn(model.getS0());
			lampS1.setOn(model.getS1());
			lampS2.setOn(model.getS2());
			lampS3.setOn(model.getS3());
			lampS4.setOn(model.getS4());
			lampS5.setOn(model.getS5());
			lampS6.setOn(model.getS6());
			lampS7.setOn(model.getS7());

		}
	}

	public void startAutomation() {
		automationDriver = new AutomationDriver(model);
		automationDriver.start();
	}
}

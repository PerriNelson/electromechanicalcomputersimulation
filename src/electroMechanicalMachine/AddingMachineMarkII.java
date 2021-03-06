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

import electroMechanicalMachine.Model.AddingMachineMarkIIModel;
import electroMechanicalMachine.Model.Interfaces.IAddingMachineMarkIIModel;
import electroMechanicalMachine.UIComponents.Lamp;
import electroMechanicalMachine.UIComponents.ToggleSwitch;
import electroMechanicalMachine.UIComponents.Interfaces.PowerState;

public class AddingMachineMarkII extends ControlPanel implements
		PropertyChangeListener {
	public static void main(final String[] args) {
		final AddingMachineMarkII frame = new AddingMachineMarkII();
		frame.setVisible(true);
	}

	public static final long serialVersionUID = 1l;

	private static final String powerOutPropertyName = "powerOut";
	private static final int aRow = 0;
	private static final int labelRow0 = 1;
	private static final int bRow = 2;
	private static final int labelRow1 = 3;
	private static final int lampRow = 4;

	private static final int labelRow2 = 5;
	private static final int columnCO = 0;
	private static final int column0 = 8;
	private static final int column1 = 7;
	private static final int column2 = 6;
	private static final int column3 = 5;
	private static final int column4 = 4;
	private static final int column5 = 3;
	private static final int column6 = 2;

	private static final int column7 = 1;

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
	private ToggleSwitch toggleSwitchAddSubtract;

	private Lamp lampCO;
	private Lamp lampS0;
	private Lamp lampS1;
	private Lamp lampS2;
	private Lamp lampS3;
	private Lamp lampS4;
	private Lamp lampS5;
	private Lamp lampS6;
	private Lamp lampS7;
	private IAddingMachineMarkIIModel model;

	public AddingMachineMarkII() {
		super("Adding Machine Mark II");
		placeControls();

		initializeModel();

		runSimulation(model, 10);
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
			} else if (evt.getSource() == toggleSwitchB0) {
				model.setB0(powerState);
			} else if (evt.getSource() == toggleSwitchB1) {
				model.setB1(powerState);
			} else if (evt.getSource() == toggleSwitchB2) {
				model.setB2(powerState);
			} else if (evt.getSource() == toggleSwitchB3) {
				model.setB3(powerState);
			} else if (evt.getSource() == toggleSwitchB4) {
				model.setB4(powerState);
			} else if (evt.getSource() == toggleSwitchB5) {
				model.setB5(powerState);
			} else if (evt.getSource() == toggleSwitchB6) {
				model.setB6(powerState);
			} else if (evt.getSource() == toggleSwitchB7) {
				model.setB7(powerState);
			} else if (evt.getSource() == toggleSwitchAddSubtract) {
				model.setSubtract(powerState);
			}
		}
	}

	private void initializeModel() {
		model = new AddingMachineMarkIIModel();
		model.setPower(true);
	}

	private void placeControls() {
		setSize(650, 420);

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

		placeLabel("Labels/SubtractLabel.jpg", "", columnCO, labelRow0, 1);
		placeLabel("Labels/AddLabel.jpg", "", columnCO, labelRow1, 1);
		placeLabel("Labels/OverflowUnderflowLabel.jpg", "", columnCO,
				labelRow2, 1);
		toggleSwitchAddSubtract = placeToggleSwitch(columnCO, bRow);

		lampCO = placeLamp(columnCO, lampRow);
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
	protected void onModelUpdated() {
		lampCO.setOn(model.getOverflow());

		lampS0.setOn(model.getS0());
		lampS1.setOn(model.getS1());
		lampS2.setOn(model.getS2());
		lampS3.setOn(model.getS3());
		lampS4.setOn(model.getS4());
		lampS5.setOn(model.getS5());
		lampS6.setOn(model.getS6());
		lampS7.setOn(model.getS7());
	}

	@Override
	protected ToggleSwitch placeToggleSwitch(final int column, final int row) {
		final ToggleSwitch toggleSwitch = super.placeToggleSwitch(column, row);
		toggleSwitch.addPropertyChangeListener(this);
		return toggleSwitch;
	}

	@Override
	protected void setTitle() {
		placeTitleLabel(" Adding Machine Mark II ",
				"Labels/AddingMachineMarkIILabel.jpg");
	}
}

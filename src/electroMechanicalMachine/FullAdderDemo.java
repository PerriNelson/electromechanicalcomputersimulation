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

import electroMechanicalLogic.Adders.FullAdder;
import electroMechanicalMachine.UIComponents.Lamp;
import electroMechanicalMachine.UIComponents.ToggleSwitch;
import electroMechanicalMachine.UIComponents.Interfaces.PowerState;

public class FullAdderDemo extends ControlPanel implements
		PropertyChangeListener {
	public static void main(final String[] args) {
		final FullAdderDemo frame = new FullAdderDemo();
		frame.setVisible(true);
	}

	public static final long serialVersionUID = 1l;

	private static final String powerOutPropertyName = "powerOut";
	private static final int labelRow = 1;

	private static final int controlRow = 0;
	private static final int columnA = 1;
	private static final int columnB = 2;
	private static final int columnCI = 0;
	private static final int columnCO = 3;

	private static final int columnS = 4;

	private final ToggleSwitch toggleSwitchCI;
	private final ToggleSwitch toggleSwitchA;
	private final ToggleSwitch toggleSwitchB;
	private final Lamp lampCO;
	private final Lamp lampS;
	private final FullAdder fullAdder;

	public FullAdderDemo() {
		super("Full Adder");
		setSize(350, 170);

		fullAdder = new FullAdder();
		fullAdder.setPower(true);

		placeLabel("Labels/CILabel.jpg", " CI ", columnCI, labelRow, 1);
		placeLabel("Labels/ALabel.jpg", " A ", columnA, labelRow, 1);
		placeLabel("Labels/BLabel.jpg", " B ", columnB, labelRow, 1);
		placeLabel("Labels/COLabel.jpg", " CO ", columnCO, labelRow, 1);
		placeLabel("Labels/SLabel.jpg", " S ", columnS, labelRow, 1);

		toggleSwitchCI = placeToggleSwitch(columnCI, controlRow);
		toggleSwitchA = placeToggleSwitch(columnA, controlRow);
		toggleSwitchB = placeToggleSwitch(columnB, controlRow);

		lampCO = placeLamp(columnCO, controlRow);
		lampS = placeLamp(columnS, controlRow);

		runSimulation(fullAdder, 10);
	}

	@Override
	public void propertyChange(final PropertyChangeEvent evt) {
		if (powerOutPropertyName.equalsIgnoreCase(evt.getPropertyName())) {
			if (evt.getSource() == toggleSwitchCI) {
				fullAdder.setCI(PowerState.on == evt.getNewValue());
			} else if (evt.getSource() == toggleSwitchA) {
				fullAdder.setA(PowerState.on == evt.getNewValue());
			} else if (evt.getSource() == toggleSwitchB) {
				fullAdder.setB(PowerState.on == evt.getNewValue());
			}
		}
	}

	@Override
	protected void onModelUpdated() {
		lampCO.setOn(fullAdder.getCO());
		lampS.setOn(fullAdder.getS());
	}

	@Override
	protected ToggleSwitch placeToggleSwitch(final int column, final int row) {
		final ToggleSwitch toggleSwitch = super.placeToggleSwitch(column, row);
		toggleSwitch.addPropertyChangeListener(this);
		return toggleSwitch;
	}

	@Override
	protected void setTitle() {
		placeTitleLabel(" Full Adder Demo ", "Labels/FullAdderDemoLabel.jpg");

	}
}

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

import electroMechanicalLogic.Adders.HalfAdder;
import electroMechanicalMachine.UIComponents.Lamp;
import electroMechanicalMachine.UIComponents.ToggleSwitch;
import electroMechanicalMachine.UIComponents.Interfaces.PowerState;

public class HalfAdderDemo extends ControlPanel implements
		PropertyChangeListener {
	public static void main(final String[] args) {
		final HalfAdderDemo frame = new HalfAdderDemo();
		frame.setVisible(true);
	}

	public static final long serialVersionUID = 1l;

	private static final String powerOutPropertyName = "powerOut";
	private static final int labelRow = 1;

	private static final int controlRow = 0;
	private static final int columnA = 0;
	private static final int columnB = 1;
	private static final int columnCO = 2;

	private static final int columnS = 3;

	private final ToggleSwitch toggleSwitchA;
	private final ToggleSwitch toggleSwitchB;
	private final Lamp lampCO;
	private final Lamp lampS;
	private final HalfAdder halfAdder;

	public HalfAdderDemo() {
		super("Half Adder");
		setSize(300, 170);

		halfAdder = new HalfAdder();
		halfAdder.setPower(true);

		toggleSwitchA = placeToggleSwitch(columnA, controlRow);
		toggleSwitchB = placeToggleSwitch(columnB, controlRow);

		placeLabel("Labels/ALabel.jpg", " A ", columnA, labelRow, 1);
		placeLabel("Labels/BLabel.jpg", " B ", columnB, labelRow, 1);
		placeLabel("Labels/COLabel.jpg", " CO ", columnCO, labelRow, 1);
		placeLabel("Labels/SLabel.jpg", " S ", columnS, labelRow, 1);

		lampCO = placeLamp(columnCO, controlRow);
		lampS = placeLamp(columnS, controlRow);

		runSimulation(halfAdder, 10);
	}

	@Override
	public void propertyChange(final PropertyChangeEvent evt) {
		if (powerOutPropertyName.equalsIgnoreCase(evt.getPropertyName())) {
			if (evt.getSource() == toggleSwitchA) {
				halfAdder.setA(PowerState.on == evt.getNewValue());
			} else if (evt.getSource() == toggleSwitchB) {
				halfAdder.setB(PowerState.on == evt.getNewValue());
			}
		}
	}

	@Override
	protected void onModelUpdated() {
		lampCO.setOn(halfAdder.getCO());
		lampS.setOn(halfAdder.getS());
	}

	@Override
	protected ToggleSwitch placeToggleSwitch(final int column, final int row) {
		final ToggleSwitch toggleSwitch = super.placeToggleSwitch(column, row);
		toggleSwitch.addPropertyChangeListener(this);
		return toggleSwitch;
	}

	@Override
	protected void setTitle() {
		placeTitleLabel(" Hald Adder Demo ", "Labels/HalfAdderDemoLabel.jpg");
	}
}

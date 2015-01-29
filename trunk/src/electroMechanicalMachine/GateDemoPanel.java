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

import electroMechanicalLogic.Gates.Interfaces.ITwoInputSingleOutputGate;
import electroMechanicalMachine.UIComponents.Lamp;
import electroMechanicalMachine.UIComponents.ToggleSwitch;
import electroMechanicalMachine.UIComponents.Interfaces.PowerState;

public class GateDemoPanel extends ControlPanel implements
		PropertyChangeListener {
	public static final long serialVersionUID = 1l;

	private static final String powerOutPropertyName = "powerOut";

	private ToggleSwitch toggleSwitchA;
	private ToggleSwitch toggleSwitchB;
	private Lamp lamp;

	private ITwoInputSingleOutputGate model;

	public GateDemoPanel(String caption, ITwoInputSingleOutputGate gate) {
		super(caption);

		placeControls();

		initializeModel(gate);

		runSimulation(model, 10);
	}

	private void initializeModel(ITwoInputSingleOutputGate gate) {
		model = gate;
		model.setPower(true);
	}

	private void placeControls() {
		setSize(300, 103);

		toggleSwitchA = placeToggleSwitch(0, 0);
		toggleSwitchB = placeToggleSwitch(1, 0);
		lamp = placeLamp(2, 0);
	}

	@Override
	public void propertyChange(final PropertyChangeEvent evt) {
		if (powerOutPropertyName.equalsIgnoreCase(evt.getPropertyName())) {
			final boolean powerState = PowerState.on == evt.getNewValue();

			if (evt.getSource() == toggleSwitchA) {
				model.setA(powerState);
			} else if (evt.getSource() == toggleSwitchB) {
				model.setB(powerState);
			}
		}
	}

	@Override
	protected ToggleSwitch placeToggleSwitch(final int column, final int row) {
		final ToggleSwitch toggleSwitch = super.placeToggleSwitch(column, row);
		toggleSwitch.addPropertyChangeListener(this);
		return toggleSwitch;
	}

	@Override
	protected void onModelUpdated() {
		lamp.setOn(model.getOutput());
	}
}

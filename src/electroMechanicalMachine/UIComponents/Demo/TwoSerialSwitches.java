/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.UIComponents.Demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;

import electroMechanicalMachine.UIComponents.Lamp;
import electroMechanicalMachine.UIComponents.ToggleSwitch;
import electroMechanicalMachine.UIComponents.Interfaces.PowerState;

public class TwoSerialSwitches extends Frame implements PropertyChangeListener {
	public static final long serialVersionUID = 1l;

	private static final String powerOutPropertyName = "powerOut";

	public static void main(final String[] args) {
		final TwoSerialSwitches frame = new TwoSerialSwitches();
		frame.setVisible(true);
	}

	private final ToggleSwitch toggleSwitch1;
	private final ToggleSwitch toggleSwitch2;
	private final Lamp lamp;

	public TwoSerialSwitches() {
		super("Two Serial Switches");
		setSize(300, 103);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(final WindowEvent event) {
				System.exit(0);
			}
		});
		final JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		toggleSwitch1 = new ToggleSwitch();
		toggleSwitch1.setPowerIn(PowerState.on);
		toggleSwitch1.addPropertyChangeListener(this);
		panel.add(toggleSwitch1);
		toggleSwitch2 = new ToggleSwitch();
		toggleSwitch2.setPowerIn(PowerState.off);
		toggleSwitch2.addPropertyChangeListener(this);
		panel.add(toggleSwitch2);
		lamp = new Lamp();
		panel.add(lamp);
		panel.setBackground(new Color(60, 60, 60));
		add(panel, BorderLayout.NORTH);
	}

	@Override
	public void propertyChange(final PropertyChangeEvent evt) {
		if (evt.getSource() == toggleSwitch1) {
			if (powerOutPropertyName.equalsIgnoreCase(evt.getPropertyName())) {
				toggleSwitch2.setPowerIn((PowerState) evt.getNewValue());
			}
		}
		if (evt.getSource() == toggleSwitch2) {
			if (powerOutPropertyName.equalsIgnoreCase(evt.getPropertyName())) {
				lamp.setOn(PowerState.on == evt.getNewValue());
			}
		}
	}
}

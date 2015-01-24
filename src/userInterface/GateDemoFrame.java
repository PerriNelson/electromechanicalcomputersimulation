/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package userInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;

import userInterface.Interfaces.PowerState;
import electroMechanicalLogic.Interfaces.ITwoInputSingleOutputGate;

public abstract class GateDemoFrame extends Frame implements
PropertyChangeListener {
	public static final long serialVersionUID = 1l;
	private static final String powerOutPropertyName = "powerOut";

	private final ToggleSwitch toggleSwitch1;
	private final ToggleSwitch toggleSwitch2;
	private final ITwoInputSingleOutputGate gate;
	private final Lamp lamp;

	public GateDemoFrame(final String caption) {
		super(caption);
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
		toggleSwitch2.setPowerIn(PowerState.on);
		toggleSwitch2.addPropertyChangeListener(this);
		panel.add(toggleSwitch2);
		gate = getGate();
		gate.setPower(true);
		lamp = new Lamp();
		panel.add(lamp);
		panel.setBackground(new Color(60, 60, 60));
		add(panel, BorderLayout.NORTH);
	}

	protected abstract ITwoInputSingleOutputGate getGate();

	@Override
	public void propertyChange(final PropertyChangeEvent evt) {
		if (evt.getSource() == toggleSwitch1) {
			if (powerOutPropertyName.equalsIgnoreCase(evt.getPropertyName())) {
				gate.setA(PowerState.on == evt.getNewValue());
			}
		}
		if (evt.getSource() == toggleSwitch2) {
			if (powerOutPropertyName.equalsIgnoreCase(evt.getPropertyName())) {
				gate.setB(PowerState.on == evt.getNewValue());
			}
		}
		gate.step();
		lamp.setOn(gate.getOutput());
	}
}

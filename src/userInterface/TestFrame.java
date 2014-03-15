/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
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

public class TestFrame extends Frame implements PropertyChangeListener {
	public static final long serialVersionUID = 1l;
	private static final String powerOutPropertyName = "powerOut";

	public static void main(String[] args) {
		TestFrame frame = new TestFrame();
		frame.setVisible(true);
	}

	private ToggleSwitch toggleSwitch;
	private Lamp lamp;

	public TestFrame() {
		super("UI Components sample");
		setSize(300, 100);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent event) {
				System.exit(0);
			}
		});
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		toggleSwitch = new ToggleSwitch();
		toggleSwitch.setPowerIn(PowerState.on);
		toggleSwitch.addPropertyChangeListener(this);
		panel.add(toggleSwitch);
		lamp = new Lamp();
		panel.add(lamp);
		panel.setBackground(new Color(192, 192, 192));
		add(panel, BorderLayout.NORTH);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getSource() == toggleSwitch) {
			if (powerOutPropertyName.equalsIgnoreCase(evt.getPropertyName())) {
				lamp.setOn(PowerState.on == evt.getNewValue());
			}
		}
	}
}

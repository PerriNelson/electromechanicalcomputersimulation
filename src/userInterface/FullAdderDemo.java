/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package userInterface;

import java.awt.Color;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import userInterface.Interfaces.PowerState;
import electroMechanicalLogic.FullAdder;

public class FullAdderDemo extends Frame implements PropertyChangeListener {
	public static void main(String[] args) {
		FullAdderDemo frame = new FullAdderDemo();
		frame.setVisible(true);
	}

	public static final long serialVersionUID = 1l;

	private static final String powerOutPropertyName = "powerOut";
	private static final int labelRow = 0;

	private static final int controlRow = 1;
	private static final int columnA = 1;
	private static final int columnB = 2;
	private static final int columnCI = 0;
	private static final int columnCO = 3;

	private static final int columnS = 4;

	private JLabel labelCI;
	private JLabel labelA;
	private JLabel labelB;
	private JLabel labelCO;
	private JLabel labelS;
	private ToggleSwitch toggleSwitchCI;
	private ToggleSwitch toggleSwitchA;
	private ToggleSwitch toggleSwitchB;
	private Lamp lampCO;
	private Lamp lampS;
	private FullAdder fullAdder;

	public FullAdderDemo() {
		super("Full Adder");
		setSize(350, 170);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent event) {
				System.exit(0);
			}
		});
		fullAdder = new FullAdder();
		fullAdder.setPower(true);

		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setBackground(new Color(60, 60, 60));

		labelCI = new JLabel();
		setLabel(labelCI, "images/CILabel.jpg", " CI ");
		placeComponent(panel, labelCI, columnCI, labelRow);

		toggleSwitchCI = new ToggleSwitch();
		toggleSwitchCI.setPowerIn(PowerState.on);
		toggleSwitchCI.addPropertyChangeListener(this);
		placeComponent(panel, toggleSwitchCI, columnCI, controlRow);

		labelA = new JLabel();
		setLabel(labelA, "images/ALabel.jpg", " A ");
		placeComponent(panel, labelA, columnA, labelRow);

		toggleSwitchA = new ToggleSwitch();
		toggleSwitchA.setPowerIn(PowerState.on);
		toggleSwitchA.addPropertyChangeListener(this);
		placeComponent(panel, toggleSwitchA, columnA, controlRow);

		labelB = new JLabel();
		setLabel(labelB, "images/BLabel.jpg", " B ");
		placeComponent(panel, labelB, columnB, labelRow);

		toggleSwitchB = new ToggleSwitch();
		toggleSwitchB.setPowerIn(PowerState.on);
		toggleSwitchB.addPropertyChangeListener(this);
		placeComponent(panel, toggleSwitchB, columnB, controlRow);

		labelCO = new JLabel();
		setLabel(labelCO, "images/COLabel.jpg", " CO ");
		placeComponent(panel, labelCO, columnCO, labelRow);

		lampCO = new Lamp();
		placeComponent(panel, lampCO, columnCO, controlRow);

		labelS = new JLabel();
		setLabel(labelS, "images/SLabel.jpg", " S ");
		placeComponent(panel, labelS, columnS, labelRow);

		lampS = new Lamp();
		placeComponent(panel, lampS, columnS, controlRow);

		add(panel);
	}

	private void placeComponent(JPanel panel, JComponent component, int column,
			int row) {
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.CENTER;
		constraints.gridx = column;
		constraints.gridy = row;
		constraints.weightx = .1;
		constraints.weighty = .1;
		panel.add(component, constraints);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getSource() == toggleSwitchCI) {
			if (powerOutPropertyName.equalsIgnoreCase(evt.getPropertyName())) {
				fullAdder.setCI(PowerState.on == evt.getNewValue());
			}
		}
		if (evt.getSource() == toggleSwitchA) {
			if (powerOutPropertyName.equalsIgnoreCase(evt.getPropertyName())) {
				fullAdder.setA(PowerState.on == evt.getNewValue());
			}
		}
		if (evt.getSource() == toggleSwitchB) {
			if (powerOutPropertyName.equalsIgnoreCase(evt.getPropertyName())) {
				fullAdder.setB(PowerState.on == evt.getNewValue());
			}
		}
		fullAdder.step();
		lampCO.setOn(fullAdder.getCO());
		lampS.setOn(fullAdder.getS());
	}

	private void setLabel(JLabel label, String imagePath, String alternateText) {
		try {
			label.setIcon(new ImageIcon(ImageIO.read(this.getClass()
					.getResource(imagePath))));
		} catch (Exception exception) {
			label.setText(alternateText);
			label.setForeground(Color.white);
			label.setBackground(Color.black);
			label.setOpaque(true);
		}
	}
}

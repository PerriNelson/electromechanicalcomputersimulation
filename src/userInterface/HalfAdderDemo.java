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
import electroMechanicalLogic.HalfAdder;

public class HalfAdderDemo extends Frame implements PropertyChangeListener {
	public static final long serialVersionUID = 1l;

	private static final String powerOutPropertyName = "powerOut";

	private static final int labelRow = 0;
	private static final int controlRow = 1;

	private static final int columnA = 0;
	private static final int columnB = 1;
	private static final int columnCO = 2;
	private static final int columnS = 3;

	public static void main(final String[] args) {
		final HalfAdderDemo frame = new HalfAdderDemo();
		frame.setVisible(true);
	}

	private final JLabel labelA;
	private final JLabel labelB;
	private final JLabel labelCO;
	private final JLabel labelS;
	private final ToggleSwitch toggleSwitchA;
	private final ToggleSwitch toggleSwitchB;
	private final Lamp lampCO;
	private final Lamp lampS;
	private final HalfAdder halfAdder;

	public HalfAdderDemo() {
		super("Half Adder");
		setSize(300, 170);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(final WindowEvent event) {
				System.exit(0);
			}
		});
		halfAdder = new HalfAdder();
		halfAdder.setPower(true);

		final JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setBackground(new Color(60, 60, 60));

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

	private void placeComponent(final JPanel panel, final JComponent component,
			final int column, final int row) {
		final GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.CENTER;
		constraints.gridx = column;
		constraints.gridy = row;
		constraints.weightx = .1;
		constraints.weighty = .1;
		panel.add(component, constraints);
	}

	@Override
	public void propertyChange(final PropertyChangeEvent evt) {
		if (evt.getSource() == toggleSwitchA) {
			if (powerOutPropertyName.equalsIgnoreCase(evt.getPropertyName())) {
				halfAdder.setA(PowerState.on == evt.getNewValue());
			}
		}
		if (evt.getSource() == toggleSwitchB) {
			if (powerOutPropertyName.equalsIgnoreCase(evt.getPropertyName())) {
				halfAdder.setB(PowerState.on == evt.getNewValue());
			}
		}
		halfAdder.step();
		lampCO.setOn(halfAdder.getCO());
		lampS.setOn(halfAdder.getS());
	}

	private void setLabel(final JLabel label, final String imagePath,
			final String alternateText) {
		try {
			label.setIcon(new ImageIcon(ImageIO.read(this.getClass()
					.getResource(imagePath))));
		} catch (final Exception exception) {
			label.setText(alternateText);
			label.setForeground(Color.white);
			label.setBackground(Color.black);
			label.setOpaque(true);
		}
	}
}

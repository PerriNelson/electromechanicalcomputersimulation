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
import electroMechanicalLogic.EightBitAdder;

public class AddingMachineMarkI extends Frame implements PropertyChangeListener {
	public static final long serialVersionUID = 1l;
	private static final String powerOutPropertyName = "powerOut";

	private static final int aRow = 0;
	private static final int bRow = 1;
	private static final int lampRow = 2;

	private static final int columnCO = 0;
	private static final int column0 = 8;
	private static final int column1 = 7;
	private static final int column2 = 6;
	private static final int column3 = 5;
	private static final int column4 = 4;
	private static final int column5 = 3;
	private static final int column6 = 2;
	private static final int column7 = 1;

	public static void main(String[] args) {
		AddingMachineMarkI frame = new AddingMachineMarkI();
		frame.setVisible(true);
	}

	private JLabel labelPlus;
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
	private Lamp lampCO;
	private Lamp lampS0;
	private Lamp lampS1;
	private Lamp lampS2;
	private Lamp lampS3;
	private Lamp lampS4;
	private Lamp lampS5;
	private Lamp lampS6;
	private Lamp lampS7;
	private EightBitAdder adder;

	public AddingMachineMarkI() {
		super("Adding Machine Mark I");
		setSize(550, 300);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent event) {
				System.exit(0);
			}
		});
		adder = new EightBitAdder();
		adder.setPower(true);

		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setBackground(new Color(60, 60, 60));

		toggleSwitchA0 = placeToggleSwitch(panel, column0, aRow);
		toggleSwitchA1 = placeToggleSwitch(panel, column1, aRow);
		toggleSwitchA2 = placeToggleSwitch(panel, column2, aRow);
		toggleSwitchA3 = placeToggleSwitch(panel, column3, aRow);
		toggleSwitchA4 = placeToggleSwitch(panel, column4, aRow);
		toggleSwitchA5 = placeToggleSwitch(panel, column5, aRow);
		toggleSwitchA6 = placeToggleSwitch(panel, column6, aRow);
		toggleSwitchA7 = placeToggleSwitch(panel, column7, aRow);

		toggleSwitchB0 = placeToggleSwitch(panel, column0, bRow);
		toggleSwitchB1 = placeToggleSwitch(panel, column1, bRow);
		toggleSwitchB2 = placeToggleSwitch(panel, column2, bRow);
		toggleSwitchB3 = placeToggleSwitch(panel, column3, bRow);
		toggleSwitchB4 = placeToggleSwitch(panel, column4, bRow);
		toggleSwitchB5 = placeToggleSwitch(panel, column5, bRow);
		toggleSwitchB6 = placeToggleSwitch(panel, column6, bRow);
		toggleSwitchB7 = placeToggleSwitch(panel, column7, bRow);

		lampCO = placeLamp(panel, columnCO, lampRow);
		lampS0 = placeLamp(panel, column0, lampRow);
		lampS1 = placeLamp(panel, column1, lampRow);
		lampS2 = placeLamp(panel, column2, lampRow);
		lampS3 = placeLamp(panel, column3, lampRow);
		lampS4 = placeLamp(panel, column4, lampRow);
		lampS5 = placeLamp(panel, column5, lampRow);
		lampS6 = placeLamp(panel, column6, lampRow);
		lampS7 = placeLamp(panel, column7, lampRow);

		labelPlus = new JLabel();
		setLabel(labelPlus, "images/PlusLabel.jpg", " + ");
		placeComponent(panel, labelPlus, columnCO, bRow);

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

	private Lamp placeLamp(JPanel panel, int column, int row) {
		Lamp lamp = new Lamp();
		placeComponent(panel, lamp, column, row);
		return lamp;
	}

	private ToggleSwitch placeToggleSwitch(JPanel panel, int column, int row) {
		ToggleSwitch toggleSwitch = new ToggleSwitch();
		toggleSwitch.setPowerIn(PowerState.on);
		toggleSwitch.addPropertyChangeListener(this);
		placeComponent(panel, toggleSwitch, column, row);
		return toggleSwitch;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getSource() == toggleSwitchA0) {
			if (powerOutPropertyName.equalsIgnoreCase(evt.getPropertyName())) {
				adder.setA0(PowerState.on == evt.getNewValue());
			}
		}
		if (evt.getSource() == toggleSwitchA1) {
			if (powerOutPropertyName.equalsIgnoreCase(evt.getPropertyName())) {
				adder.setA1(PowerState.on == evt.getNewValue());
			}
		}
		if (evt.getSource() == toggleSwitchA2) {
			if (powerOutPropertyName.equalsIgnoreCase(evt.getPropertyName())) {
				adder.setA2(PowerState.on == evt.getNewValue());
			}
		}
		if (evt.getSource() == toggleSwitchA3) {
			if (powerOutPropertyName.equalsIgnoreCase(evt.getPropertyName())) {
				adder.setA3(PowerState.on == evt.getNewValue());
			}
		}
		if (evt.getSource() == toggleSwitchA4) {
			if (powerOutPropertyName.equalsIgnoreCase(evt.getPropertyName())) {
				adder.setA4(PowerState.on == evt.getNewValue());
			}
		}
		if (evt.getSource() == toggleSwitchA5) {
			if (powerOutPropertyName.equalsIgnoreCase(evt.getPropertyName())) {
				adder.setA5(PowerState.on == evt.getNewValue());
			}
		}
		if (evt.getSource() == toggleSwitchA6) {
			if (powerOutPropertyName.equalsIgnoreCase(evt.getPropertyName())) {
				adder.setA6(PowerState.on == evt.getNewValue());
			}
		}
		if (evt.getSource() == toggleSwitchA7) {
			if (powerOutPropertyName.equalsIgnoreCase(evt.getPropertyName())) {
				adder.setA7(PowerState.on == evt.getNewValue());
			}
		}
		if (evt.getSource() == toggleSwitchB0) {
			if (powerOutPropertyName.equalsIgnoreCase(evt.getPropertyName())) {
				adder.setB0(PowerState.on == evt.getNewValue());
			}
		}
		if (evt.getSource() == toggleSwitchB1) {
			if (powerOutPropertyName.equalsIgnoreCase(evt.getPropertyName())) {
				adder.setB1(PowerState.on == evt.getNewValue());
			}
		}
		if (evt.getSource() == toggleSwitchB2) {
			if (powerOutPropertyName.equalsIgnoreCase(evt.getPropertyName())) {
				adder.setB2(PowerState.on == evt.getNewValue());
			}
		}
		if (evt.getSource() == toggleSwitchB3) {
			if (powerOutPropertyName.equalsIgnoreCase(evt.getPropertyName())) {
				adder.setB3(PowerState.on == evt.getNewValue());
			}
		}
		if (evt.getSource() == toggleSwitchB4) {
			if (powerOutPropertyName.equalsIgnoreCase(evt.getPropertyName())) {
				adder.setB4(PowerState.on == evt.getNewValue());
			}
		}
		if (evt.getSource() == toggleSwitchB5) {
			if (powerOutPropertyName.equalsIgnoreCase(evt.getPropertyName())) {
				adder.setB5(PowerState.on == evt.getNewValue());
			}
		}
		if (evt.getSource() == toggleSwitchB6) {
			if (powerOutPropertyName.equalsIgnoreCase(evt.getPropertyName())) {
				adder.setB6(PowerState.on == evt.getNewValue());
			}
		}
		if (evt.getSource() == toggleSwitchB7) {
			if (powerOutPropertyName.equalsIgnoreCase(evt.getPropertyName())) {
				adder.setB7(PowerState.on == evt.getNewValue());
			}
		}

		adder.step();
		lampCO.setOn(adder.getCO());
		lampS0.setOn(adder.getS0());
		lampS1.setOn(adder.getS1());
		lampS2.setOn(adder.getS2());
		lampS3.setOn(adder.getS3());
		lampS4.setOn(adder.getS4());
		lampS5.setOn(adder.getS5());
		lampS6.setOn(adder.getS6());
		lampS7.setOn(adder.getS7());
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

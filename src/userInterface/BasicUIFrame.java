/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
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

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import userInterface.Interfaces.PowerState;

public class BasicUIFrame extends Frame {
	public static final long serialVersionUID = 1l;

	private JPanel panel;

	public BasicUIFrame(String caption) {
		super(caption);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent event) {
				System.exit(0);
			}
		});

		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setBackground(new Color(60, 60, 60));

		add(panel);
	}

	protected void placeComponent(JComponent component, int column, int row,
			int columns) {
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.CENTER;
		constraints.gridx = column;
		constraints.gridwidth = columns;
		constraints.gridy = row;
		constraints.weightx = .1;
		constraints.weighty = .1;
		panel.add(component, constraints);
	}

	protected void placeLabel(String imagePath, String alternateText,
			int column, int row, int columns) {
		JLabel label = new JLabel();
		try {
			label.setIcon(new ImageIcon(ImageIO.read(this.getClass()
					.getResource(imagePath))));
		} catch (Exception exception) {
			label.setText(alternateText);
			label.setForeground(Color.white);
			label.setBackground(Color.black);
			label.setOpaque(true);
		}
		placeComponent(label, column, row, columns);
	}

	protected Lamp placeLamp(int column, int row) {
		Lamp lamp = new Lamp();
		placeComponent(lamp, column, row, 1);
		return lamp;
	}

	protected ToggleSwitch placeToggleSwitch(int column, int row) {
		ToggleSwitch toggleSwitch = new ToggleSwitch();
		toggleSwitch.setPowerIn(PowerState.on);
		placeComponent(toggleSwitch, column, row, 1);
		return toggleSwitch;
	}
}

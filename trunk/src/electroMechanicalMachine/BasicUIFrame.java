/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine;

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

import electroMechanicalMachine.UIComponents.Lamp;
import electroMechanicalMachine.UIComponents.ToggleSwitch;
import electroMechanicalMachine.UIComponents.Interfaces.PowerState;

public class BasicUIFrame extends Frame {
	public static final long serialVersionUID = 1l;

	private final JPanel outerPanel;
	private final JPanel panel;

	public BasicUIFrame(final String caption) {
		super(caption);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(final WindowEvent event) {
				System.exit(0);
			}
		});

		outerPanel = new JPanel();
		outerPanel.setLayout(new GridBagLayout());
		outerPanel.setBackground(new Color(60, 60, 60));
		add(outerPanel);

		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		panel.setBackground(new Color(60, 60, 60));

		final GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.CENTER;
		constraints.gridx = 1;
		constraints.gridwidth = 1;
		constraints.gridy = 1;
		constraints.weightx = .1;
		constraints.weighty = .1;
		outerPanel.add(panel, constraints);
	}

	protected final void placeTitleLabel(String labelText, String imagePath) {

		final JLabel label = generateLabel(labelText, imagePath);

		final GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridwidth = 3;
		constraints.gridy = 0;
		constraints.weightx = .1;
		constraints.weighty = .1;
		outerPanel.add(label, constraints);
	}

	private JLabel generateLabel(String labelText, String imagePath) {
		final JLabel label = new JLabel();
		try {
			label.setIcon(new ImageIcon(ImageIO.read(this.getClass()
					.getResource(imagePath))));
		} catch (final Exception exception) {
			label.setText(labelText);
			label.setForeground(Color.white);
			label.setBackground(Color.black);
			label.setOpaque(true);
		}
		return label;
	}

	protected void placeComponent(final JComponent component, final int column,
			final int row, final int columns) {
		final GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.CENTER;
		constraints.gridx = column;
		constraints.gridwidth = columns;
		constraints.gridy = row;
		constraints.weightx = .1;
		constraints.weighty = .1;
		panel.add(component, constraints);
	}

	protected void placeLabel(final String imagePath,
			final String alternateText, final int column, final int row,
			final int columns) {
		final JLabel label = generateLabel(alternateText, imagePath);
		placeComponent(label, column, row, columns);
	}

	protected Lamp placeLamp(final int column, final int row) {
		final Lamp lamp = new Lamp();
		placeComponent(lamp, column, row, 1);
		return lamp;
	}

	protected ToggleSwitch placeToggleSwitch(final int column, final int row) {
		return placeToggleSwitch(column, row, 1);
	}

	protected ToggleSwitch placeToggleSwitch(final int column, final int row,
			final int columns) {
		final ToggleSwitch toggleSwitch = new ToggleSwitch();
		toggleSwitch.setPowerIn(PowerState.on);
		placeComponent(toggleSwitch, column, row, columns);
		return toggleSwitch;
	}
}

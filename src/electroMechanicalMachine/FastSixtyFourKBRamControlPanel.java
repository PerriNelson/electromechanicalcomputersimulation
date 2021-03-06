/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine;

import electroMechanicalLogic.RAM.Fast.SixtyFourKilobyteRAM;
import electroMechanicalMachine.Model.SixtyFourKilobyteRamControlPanelModel;

public class FastSixtyFourKBRamControlPanel extends SixtyFourKBRamControlPanel {
	public static void main(final String[] args) {
		final FastSixtyFourKBRamControlPanel frame = new FastSixtyFourKBRamControlPanel();
		frame.setVisible(true);
	}

	public static final long serialVersionUID = 1l;

	public FastSixtyFourKBRamControlPanel() {
		super("Fast 64KB RAM Control Panel",
				new SixtyFourKilobyteRamControlPanelModel(
						new SixtyFourKilobyteRAM()));
	}

	@Override
	protected void setTitle() {
		placeTitleLabel(" Fast 64KB Control Panel ",
				"Labels/Fast64KBControlPanelLabel.jpg");
	}
}

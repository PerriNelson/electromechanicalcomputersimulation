/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine;

import electroMechanicalLogic.Gates.TwoInputNAND;

public class NANDGate extends GateDemoPanel {
	public static final long serialVersionUID = 1l;

	public static void main(final String[] args) {
		final NANDGate frame = new NANDGate();
		frame.setVisible(true);
	}

	public NANDGate() {
		super("NAND Gate", new TwoInputNAND());
	}

	@Override
	protected void setTitle() {
		placeTitleLabel(" NAND Gate Demo ", "Labels/NandGateDemoLabel.jpg");
	}
}

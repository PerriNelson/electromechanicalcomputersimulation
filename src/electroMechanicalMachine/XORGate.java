/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine;

import electroMechanicalLogic.Gates.TwoInputXOR;

public class XORGate extends GateDemoPanel {
	public static void main(final String[] args) {
		final XORGate frame = new XORGate();
		frame.setVisible(true);
	}

	public static final long serialVersionUID = 1l;

	public XORGate() {
		super("Two Input XOR Gate", new TwoInputXOR());
	}

	@Override
	protected void setTitle() {
		placeTitleLabel(" XOR Gate Demo ", "Labels/XorGateDemoLabel.jpg");
	}
}

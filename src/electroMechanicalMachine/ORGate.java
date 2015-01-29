/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine;

import electroMechanicalLogic.Gates.TwoInputOR;

public class ORGate extends GateDemoPanel {
	public static final long serialVersionUID = 1l;

	public static void main(final String[] args) {
		final ORGate frame = new ORGate();
		frame.setVisible(true);
	}

	public ORGate() {
		super("OR Gate", new TwoInputOR());
	}
}

/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine;

import electroMechanicalLogic.Gates.TwoInputAND;

public class ANDGate extends GateDemoPanel {
	public static final long serialVersionUID = 1l;

	public static void main(final String[] args) {
		final ANDGate frame = new ANDGate();
		frame.setVisible(true);
	}

	public ANDGate() {
		super("AND Gate", new TwoInputAND());
	}
}

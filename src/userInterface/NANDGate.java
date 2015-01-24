/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package userInterface;

import electroMechanicalLogic.TwoInputNAndGate;
import electroMechanicalLogic.Interfaces.ITwoInputSingleOutputGate;

public class NANDGate extends GateDemoFrame {
	public static void main(final String[] args) {
		final NANDGate frame = new NANDGate();
		frame.setVisible(true);
	}

	public static final long serialVersionUID = 1l;

	public NANDGate() {
		super("Two Input NAND Gate");
	}

	@Override
	protected ITwoInputSingleOutputGate getGate() {
		return new TwoInputNAndGate();
	}
}

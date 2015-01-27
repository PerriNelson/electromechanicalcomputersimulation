/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package userInterface;

import electroMechanicalLogic.Gates.TwoInputNOR;
import electroMechanicalLogic.Gates.Interfaces.ITwoInputSingleOutputGate;

public class NOrGate extends GateDemoFrame {
	public static final long serialVersionUID = 1l;

	public static void main(final String[] args) {
		final NOrGate frame = new NOrGate();
		frame.setVisible(true);
	}

	public NOrGate() {
		super("Two Input NOR Gate");
	}

	@Override
	protected ITwoInputSingleOutputGate getGate() {
		return new TwoInputNOR();
	}
}

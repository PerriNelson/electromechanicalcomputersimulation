/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package userInterface;

import electroMechanicalLogic.TwoInputOR;
import electroMechanicalLogic.Interfaces.ITwoInputSingleOutputGate;

public class OrGate extends GateDemoFrame {
	public static final long serialVersionUID = 1l;

	public static void main(final String[] args) {
		final OrGate frame = new OrGate();
		frame.setVisible(true);
	}

	public OrGate() {
		super("Two Input OR Gate");
	}

	@Override
	protected ITwoInputSingleOutputGate getGate() {
		return new TwoInputOR();
	}
}

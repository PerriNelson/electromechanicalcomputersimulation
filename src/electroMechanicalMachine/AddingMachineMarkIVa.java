/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine;

import electroMechanicalLogic.EightBitEdgeTriggeredLatchWithClear;
import electroMechanicalMachine.Model.AddingMachineMarkIVModel;

public class AddingMachineMarkIVa extends AddingMachineMarkIV {
	public static void main(final String[] args) {
		final AddingMachineMarkIVa frame = new AddingMachineMarkIVa();
		frame.setVisible(true);
	}

	public static final long serialVersionUID = 1l;

	public AddingMachineMarkIVa() {
		super("Adding Machine Mark IVa", new AddingMachineMarkIVModel(
				new EightBitEdgeTriggeredLatchWithClear()));
	}

	@Override
	protected void setTitle() {
		placeTitleLabel(" Adding Machine Mark IVa ",
				"Labels/AddingMachineMarkIVaLabel.jpg");
	}

}

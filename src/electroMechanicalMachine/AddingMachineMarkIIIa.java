/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine;

import electroMechanicalLogic.EightBitEdgeTriggeredLatchWithClear;
import electroMechanicalMachine.Model.AddingMachineMarkIIIModel;

public class AddingMachineMarkIIIa extends AddingMachineMarkIII {
	public static final long serialVersionUID = 1l;

	public static void main(final String[] args) {
		final AddingMachineMarkIIIa frame = new AddingMachineMarkIIIa();
		frame.setVisible(true);
	}

	public AddingMachineMarkIIIa() {
		super("Adding Machine Mark IIIa", new AddingMachineMarkIIIModel(
				new EightBitEdgeTriggeredLatchWithClear()));
	}
}
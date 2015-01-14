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
	public static final long serialVersionUID = 1l;

	public static void main(String[] args) {
		AddingMachineMarkIVa frame = new AddingMachineMarkIVa();
		frame.setVisible(true);
	}

	public AddingMachineMarkIVa() {
		super("Adding Machine Mark IVa", new AddingMachineMarkIVModel(
				new EightBitEdgeTriggeredLatchWithClear()));
	}
}

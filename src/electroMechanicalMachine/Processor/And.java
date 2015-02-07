/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Processor;

import electroMechanicalLogic.Gates.TwoInputAND;

public class And extends LogicalOperation {

	public And() {
		bit0 = new TwoInputAND();
		bit1 = new TwoInputAND();
		bit2 = new TwoInputAND();
		bit3 = new TwoInputAND();
		bit4 = new TwoInputAND();
		bit5 = new TwoInputAND();
		bit6 = new TwoInputAND();
		bit7 = new TwoInputAND();
	}

}

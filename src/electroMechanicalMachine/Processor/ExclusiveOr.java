/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Processor;

import electroMechanicalLogic.Gates.TwoInputXOR;

public class ExclusiveOr extends LogicalOperation {

	public ExclusiveOr() {
		bit0 = new TwoInputXOR();
		bit1 = new TwoInputXOR();
		bit2 = new TwoInputXOR();
		bit3 = new TwoInputXOR();
		bit4 = new TwoInputXOR();
		bit5 = new TwoInputXOR();
		bit6 = new TwoInputXOR();
		bit7 = new TwoInputXOR();
	}

}

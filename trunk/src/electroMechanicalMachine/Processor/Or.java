/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Processor;

import electroMechanicalLogic.Gates.TwoInputOR;

public class Or extends LogicalOperation {
	public Or() {
		bit0 = new TwoInputOR();
		bit1 = new TwoInputOR();
		bit2 = new TwoInputOR();
		bit3 = new TwoInputOR();
		bit4 = new TwoInputOR();
		bit5 = new TwoInputOR();
		bit6 = new TwoInputOR();
		bit7 = new TwoInputOR();
	}
}

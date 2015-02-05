/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Model.Tests;

/**
 * The instruction set used by our machines.
 */
public class InstructionSet {

	/**
	 * Load a byte into the accumulator
	 */
	public static final int LOD = 0x10;

	/**
	 * Store a byte from the accumulator.
	 */
	public static final int STO = 0x11;

	/**
	 * Add a byte to the accumulator.
	 */
	public static final int ADD = 0x20;

	/**
	 * Subtract a byte from the accumulator.
	 */
	public static final int SUB = 0x21;

	/**
	 * Add a byte to the accumulator with carry.
	 */
	public static final int ADC = 0x22;

	/**
	 * Subtract a byte from the accumulator with borrow.
	 */
	public static final int SBB = 0x23;

	/**
	 * Jump to a new address (GO TO).
	 */
	public static final int JMP = 0x30;

	/**
	 * Halt the processor.
	 */
	public static final int HALT = 0xff;
}

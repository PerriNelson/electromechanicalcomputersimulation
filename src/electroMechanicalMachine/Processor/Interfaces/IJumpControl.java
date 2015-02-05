/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Processor.Interfaces;

import electroMechanicalLogic.Interfaces.ISimulatedCircuit;

public interface IJumpControl extends ISimulatedCircuit {

	public abstract boolean getJump();

	public abstract void setAddressHasBeenLatched(final boolean value);

	public abstract void setCarryFlag(final boolean value);

	public abstract void setJump(final boolean value);

	public abstract void setJumpIfCarry(final boolean value);

	public abstract void setJumpIfNotCarry(final boolean value);

	public abstract void setJumpIfNotZero(final boolean value);

	public abstract void setJumpIfZero(final boolean value);

	public abstract void setZeroFlag(final boolean value);
}

/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Model;

import electroMechanicalLogic.EightBitDataPath;
import electroMechanicalLogic.EightBitOnesComplement;
import electroMechanicalLogic.Interfaces.IEightBitOnesComplement;
import electroMechanicalMachine.Model.Interfaces.IMarkVIIALU;

public class MarkVIIALU extends MarkVIALU implements IMarkVIIALU {
	private final IEightBitOnesComplement subtract = new EightBitOnesComplement();

	@Override
	public void setDI0(final boolean value) {
		subtract.setDI0(value);
		loadSelector.setA0(value);
	}

	@Override
	public void setDI1(final boolean value) {
		subtract.setDI1(value);
		loadSelector.setA1(value);
	}

	@Override
	public void setDI2(final boolean value) {
		subtract.setDI2(value);
		loadSelector.setA2(value);
	}

	@Override
	public void setDI3(final boolean value) {
		subtract.setDI3(value);
		loadSelector.setA3(value);
	}

	@Override
	public void setDI4(final boolean value) {
		subtract.setDI4(value);
		loadSelector.setA4(value);
	}

	@Override
	public void setDI5(final boolean value) {
		subtract.setDI5(value);
		loadSelector.setA5(value);
	}

	@Override
	public void setDI6(final boolean value) {
		subtract.setDI6(value);
		loadSelector.setA6(value);
	}

	@Override
	public void setDI7(final boolean value) {
		subtract.setDI7(value);
		loadSelector.setA7(value);
	}

	@Override
	public void setPower(final boolean value) {
		super.setPower(value);
		subtract.setPower(value);
	}

	@Override
	public void setSubtract(final boolean value) {
		subtract.setInvert(value);
		adder.setCI(value);
	}

	@Override
	public void step() {
		subtract.step();
		EightBitDataPath.DataOutToAIn(subtract, adder);
		super.step();
	}
}

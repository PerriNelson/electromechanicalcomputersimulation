/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Model;

import electroMechanicalLogic.Gates.ThreeInputOR;
import electroMechanicalLogic.Gates.TwoInputOR;
import electroMechanicalLogic.Gates.Interfaces.IThreeInputSingleOutputGate;
import electroMechanicalLogic.Gates.Interfaces.ITwoInputSingleOutputGate;
import electroMechanicalMachine.Model.Interfaces.ICarryControl;
import electroMechanicalMachine.Model.Interfaces.IMarkVIIIALU;

public class MarkVIIIALU extends MarkVIIALU implements IMarkVIIIALU {
	private final ICarryControl carryControl = new CarryControl();
	private final ITwoInputSingleOutputGate subtractOrSubtractWithBorrow = new TwoInputOR();
	private final IThreeInputSingleOutputGate loadAddSubtractAddWithCarryOrSubtractWithBorrow = new ThreeInputOR();

	@Override
	public void setAdd(final boolean value) {
		super.setAdd(value);
		carryControl.setAdd(value);
	}

	@Override
	public void setAddWithCarry(final boolean value) {
		carryControl.setAddWithCarry(value);
		loadAddSubtractAddWithCarryOrSubtractWithBorrow.setA(value);
	}

	@Override
	public void setClear(final boolean value) {
		super.setClear(value);
		carryControl.setClear(value);
	}

	@Override
	public void setClock(final boolean value) {
		super.setClock(value);
		carryControl.setClock(value);
	}

	@Override
	public void setPower(final boolean value) {
		super.setPower(value);
		subtractOrSubtractWithBorrow.setPower(value);
		carryControl.setPower(value);
		loadAddSubtractAddWithCarryOrSubtractWithBorrow.setPower(value);
	}

	@Override
	public void setSubtract(final boolean value) {
		loadAddOrSubtract.setC(value);
		subtractOrSubtractWithBorrow.setA(value);
		carryControl.setSubtract(value);
	}

	@Override
	public void setSubtractWithBorrow(final boolean value) {
		carryControl.setSubtractWithBorrow(value);
		subtractOrSubtractWithBorrow.setB(value);
		loadAddSubtractAddWithCarryOrSubtractWithBorrow.setB(value);
	}

	@Override
	public void step() {
		subtractOrSubtractWithBorrow.step();

		subtract.setInvert(subtractOrSubtractWithBorrow.getOutput());
		subtract.step();

		carryControl.step();
		adder.setCI(carryControl.getCarryIn());
		stepAdder();

		carryControl.setCarryOut(adder.getCO());
		carryControl.step();

		loadBar.step();
		stepLoadSelector();

		loadAddOrSubtract.step();
		loadAddSubtractAddWithCarryOrSubtractWithBorrow.setC(loadAddOrSubtract
				.getOutput());

		loadAddSubtractAddWithCarryOrSubtractWithBorrow.step();

		write.setB(loadAddSubtractAddWithCarryOrSubtractWithBorrow.getOutput());
		write.step();

		stepLatch();
	}
}

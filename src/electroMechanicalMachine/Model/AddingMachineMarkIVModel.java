/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Model;

import static electroMechanicalLogic.DataChannel.EightBitDataPath.connectEightBitDataOutputToEightBitBInput;
import static electroMechanicalLogic.DataChannel.EightBitDataPath.connectEightBitSumToEightBitDataInput;
import electroMechanicalLogic.Adders.EightBitAdder;
import electroMechanicalLogic.Adders.Interfaces.IEightBitAdder;
import electroMechanicalLogic.Interfaces.IEightBitLatchWithClear;
import electroMechanicalMachine.Model.Interfaces.IAddingMachineMarkIVModel;

public class AddingMachineMarkIVModel implements IAddingMachineMarkIVModel {
	private final IEightBitAdder adder = new EightBitAdder();
	private final IEightBitLatchWithClear latch;

	public AddingMachineMarkIVModel(final IEightBitLatchWithClear theLatch) {
		latch = theLatch;
	}

	@Override
	public boolean getS0() {
		return latch.getDO0();
	}

	@Override
	public boolean getS1() {
		return latch.getDO1();
	}

	@Override
	public boolean getS2() {
		return latch.getDO2();
	}

	@Override
	public boolean getS3() {
		return latch.getDO3();
	}

	@Override
	public boolean getS4() {
		return latch.getDO4();
	}

	@Override
	public boolean getS5() {
		return latch.getDO5();
	}

	@Override
	public boolean getS6() {
		return latch.getDO6();
	}

	@Override
	public boolean getS7() {
		return latch.getDO7();
	}

	@Override
	public void setA0(final boolean value) {
		adder.setA0(value);
	}

	@Override
	public void setA1(final boolean value) {
		adder.setA1(value);
	}

	@Override
	public void setA2(final boolean value) {
		adder.setA2(value);
	}

	@Override
	public void setA3(final boolean value) {
		adder.setA3(value);
	}

	@Override
	public void setA4(final boolean value) {
		adder.setA4(value);
	}

	@Override
	public void setA5(final boolean value) {
		adder.setA5(value);
	}

	@Override
	public void setA6(final boolean value) {
		adder.setA6(value);
	}

	@Override
	public void setA7(final boolean value) {
		adder.setA7(value);
	}

	@Override
	public void setAdd(final boolean value) {
		latch.setW(value);
	}

	@Override
	public void setClear(final boolean value) {
		latch.setClr(value);
	}

	@Override
	public void setPower(final boolean value) {
		adder.setPower(value);
		latch.setPower(value);
	}

	@Override
	public void step() {
		connectEightBitDataOutputToEightBitBInput(latch, adder);
		adder.step();

		connectEightBitSumToEightBitDataInput(adder, latch);
		latch.step();
	}
}

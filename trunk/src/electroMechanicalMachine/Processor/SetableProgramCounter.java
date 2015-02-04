/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Processor;

import electroMechanicalMachine.Processor.Interfaces.ISetableFlipFlop;
import electroMechanicalMachine.Processor.Interfaces.ISetableProgramCounter;

public class SetableProgramCounter implements ISetableProgramCounter {
	private final ISetableFlipFlop a0 = new SetableEdgeTriggeredFlipFlop();
	private final ISetableFlipFlop a1 = new SetableEdgeTriggeredFlipFlop();
	private final ISetableFlipFlop a2 = new SetableEdgeTriggeredFlipFlop();
	private final ISetableFlipFlop a3 = new SetableEdgeTriggeredFlipFlop();
	private final ISetableFlipFlop a4 = new SetableEdgeTriggeredFlipFlop();
	private final ISetableFlipFlop a5 = new SetableEdgeTriggeredFlipFlop();
	private final ISetableFlipFlop a6 = new SetableEdgeTriggeredFlipFlop();
	private final ISetableFlipFlop a7 = new SetableEdgeTriggeredFlipFlop();
	private final ISetableFlipFlop a8 = new SetableEdgeTriggeredFlipFlop();
	private final ISetableFlipFlop a9 = new SetableEdgeTriggeredFlipFlop();
	private final ISetableFlipFlop aA = new SetableEdgeTriggeredFlipFlop();
	private final ISetableFlipFlop aB = new SetableEdgeTriggeredFlipFlop();
	private final ISetableFlipFlop aC = new SetableEdgeTriggeredFlipFlop();
	private final ISetableFlipFlop aD = new SetableEdgeTriggeredFlipFlop();
	private final ISetableFlipFlop aE = new SetableEdgeTriggeredFlipFlop();
	private final ISetableFlipFlop aF = new SetableEdgeTriggeredFlipFlop();

	@Override
	public void setClock(boolean value) {
		a0.setClk(value);
	}

	@Override
	public void setPower(boolean value) {
		a0.setPower(value);
		a1.setPower(value);
		a2.setPower(value);
		a3.setPower(value);
		a4.setPower(value);
		a5.setPower(value);
		a6.setPower(value);
		a7.setPower(value);
		a8.setPower(value);
		a9.setPower(value);
		aA.setPower(value);
		aB.setPower(value);
		aC.setPower(value);
		aD.setPower(value);
		aE.setPower(value);
		aF.setPower(value);
	}

	@Override
	public void step() {
		a0.setD(a0.getQBar());
		a0.step();

		a1.setClk(a0.getQBar());
		a1.setD(a1.getQBar());
		a1.step();

		a2.setClk(a1.getQBar());
		a2.setD(a2.getQBar());
		a2.step();

		a3.setClk(a2.getQBar());
		a3.setD(a3.getQBar());
		a3.step();

		a4.setClk(a3.getQBar());
		a4.setD(a4.getQBar());
		a4.step();

		a5.setClk(a4.getQBar());
		a5.setD(a5.getQBar());
		a5.step();

		a6.setClk(a5.getQBar());
		a6.setD(a6.getQBar());
		a6.step();

		a7.setClk(a6.getQBar());
		a7.setD(a7.getQBar());
		a7.step();

		a8.setClk(a7.getQBar());
		a8.setD(a8.getQBar());
		a8.step();

		a9.setClk(a8.getQBar());
		a9.setD(a9.getQBar());
		a9.step();

		aA.setClk(a9.getQBar());
		aA.setD(aA.getQBar());
		aA.step();

		aB.setClk(aA.getQBar());
		aB.setD(aB.getQBar());
		aB.step();

		aC.setClk(aB.getQBar());
		aC.setD(aC.getQBar());
		aC.step();

		aD.setClk(aC.getQBar());
		aD.setD(aD.getQBar());
		aD.step();

		aE.setClk(aD.getQBar());
		aE.setD(aE.getQBar());
		aE.step();

		aF.setClk(aE.getQBar());
		aF.setD(aF.getQBar());
		aF.step();
	}

	@Override
	public boolean getA0() {
		return a0.getQ();
	}

	@Override
	public boolean getA1() {
		return a1.getQ();
	}

	@Override
	public boolean getA2() {
		return a2.getQ();
	}

	@Override
	public boolean getA3() {
		return a3.getQ();
	}

	@Override
	public boolean getA4() {
		return a4.getQ();
	}

	@Override
	public boolean getA5() {
		return a5.getQ();
	}

	@Override
	public boolean getA6() {
		return a6.getQ();
	}

	@Override
	public boolean getA7() {
		return a7.getQ();
	}

	@Override
	public boolean getA8() {
		return a8.getQ();
	}

	@Override
	public boolean getA9() {
		return a9.getQ();
	}

	@Override
	public boolean getAA() {
		return aA.getQ();
	}

	@Override
	public boolean getAB() {
		return aB.getQ();
	}

	@Override
	public boolean getAC() {
		return aC.getQ();
	}

	@Override
	public boolean getAD() {
		return aD.getQ();
	}

	@Override
	public boolean getAE() {
		return aE.getQ();
	}

	@Override
	public boolean getAF() {
		return aF.getQ();
	}

	@Override
	public void setReset(boolean value) {
		a0.setReset(value);
		a1.setReset(value);
		a2.setReset(value);
		a3.setReset(value);
		a4.setReset(value);
		a5.setReset(value);
		a6.setReset(value);
		a7.setReset(value);
		a8.setReset(value);
		a9.setReset(value);
		aA.setReset(value);
		aB.setReset(value);
		aC.setReset(value);
		aD.setReset(value);
		aE.setReset(value);
		aF.setReset(value);
	}

	@Override
	public void setA0(boolean value) {
		a0.setA(value);
	}

	@Override
	public void setA1(boolean value) {
		a1.setA(value);
	}

	@Override
	public void setA2(boolean value) {
		a2.setA(value);
	}

	@Override
	public void setA3(boolean value) {
		a3.setA(value);
	}

	@Override
	public void setA4(boolean value) {
		a4.setA(value);
	}

	@Override
	public void setA5(boolean value) {
		a5.setA(value);
	}

	@Override
	public void setA6(boolean value) {
		a6.setA(value);
	}

	@Override
	public void setA7(boolean value) {
		a7.setA(value);
	}

	@Override
	public void setA8(boolean value) {
		a8.setA(value);
	}

	@Override
	public void setA9(boolean value) {
		a9.setA(value);
	}

	@Override
	public void setAA(boolean value) {
		aA.setA(value);
	}

	@Override
	public void setAB(boolean value) {
		aB.setA(value);
	}

	@Override
	public void setAC(boolean value) {
		aC.setA(value);
	}

	@Override
	public void setAD(boolean value) {
		aD.setA(value);
	}

	@Override
	public void setAE(boolean value) {
		aE.setA(value);
	}

	@Override
	public void setAF(boolean value) {
		aF.setA(value);
	}

	@Override
	public void setSet(boolean value) {
		a0.setSet(value);
		a1.setSet(value);
		a2.setSet(value);
		a3.setSet(value);
		a4.setSet(value);
		a5.setSet(value);
		a6.setSet(value);
		a7.setSet(value);
		a8.setSet(value);
		a9.setSet(value);
		aA.setSet(value);
		aB.setSet(value);
		aC.setSet(value);
		aD.setSet(value);
		aE.setSet(value);
		aF.setSet(value);
	}

}

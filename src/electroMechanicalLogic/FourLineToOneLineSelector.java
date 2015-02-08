/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic;

import electroMechanicalLogic.Gates.FourInputOR;
import electroMechanicalLogic.Gates.ThreeInputAND;
import electroMechanicalLogic.Gates.Interfaces.IFourInputSingleOutputGate;
import electroMechanicalLogic.Gates.Interfaces.IThreeInputSingleOutputGate;
import electroMechanicalLogic.Interfaces.IFourLineToOneLineSelector;
import electroMechanicalLogic.Interfaces.IRelay;

public class FourLineToOneLineSelector implements IFourLineToOneLineSelector {
	private final IFourInputSingleOutputGate output = new FourInputOR();

	private final IThreeInputSingleOutputGate a = new ThreeInputAND();
	private final IThreeInputSingleOutputGate b = new ThreeInputAND();
	private final IThreeInputSingleOutputGate c = new ThreeInputAND();
	private final IThreeInputSingleOutputGate d = new ThreeInputAND();

	private final IRelay s0Bar = new Inverter();
	private final IRelay s1Bar = new Inverter();

	@Override
	public boolean getDO() {
		return output.getOutput();
	}

	@Override
	public void setA(final boolean value) {
		a.setA(value);
	}

	@Override
	public void setB(final boolean value) {
		b.setA(value);
	}

	@Override
	public void setC(final boolean value) {
		c.setA(value);
	}

	@Override
	public void setD(final boolean value) {
		d.setA(value);
	}

	@Override
	public void setPower(final boolean value) {
		output.setPower(value);

		a.setPower(value);
		b.setPower(value);
		c.setPower(value);
		d.setPower(value);

		s0Bar.setPower(value);
		s1Bar.setPower(value);
	}

	@Override
	public void setS0(final boolean value) {
		s0Bar.setInput(value);

		b.setB(value);
		d.setB(value);
	}

	@Override
	public void setS1(final boolean value) {
		s1Bar.setInput(value);

		c.setC(value);
		d.setC(value);
	}

	@Override
	public void step() {
		s0Bar.step();
		s1Bar.step();

		a.setB(s0Bar.getOutput());
		a.setC(s1Bar.getOutput());
		a.step();

		b.setC(s1Bar.getOutput());
		b.step();

		c.setB(s0Bar.getOutput());
		c.step();

		d.step();

		output.setA(a.getOutput());
		output.setB(b.getOutput());
		output.setC(c.getOutput());
		output.setD(d.getOutput());
		output.step();
	}

}

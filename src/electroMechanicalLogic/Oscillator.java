/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic;

import electroMechanicalLogic.Interfaces.IOscillator;
import electroMechanicalLogic.Interfaces.IRelay;

public final class Oscillator implements IOscillator {
	private IRelay inverter = new Inverter();

	@Override
	public boolean getOutput() {
		return inverter.getOutput();
	}

	@Override
	public void setPower(boolean value) {
		inverter.setPower(value);
	}

	@Override
	public void step() {
		inverter.setInput(inverter.getOutput());
		inverter.step();
	}
}

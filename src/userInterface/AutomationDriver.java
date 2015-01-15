/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package userInterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import userInterface.Interfaces.IAutomationDriver;
import electroMechanicalMachine.Model.Interfaces.IMachineModel;

public class AutomationDriver implements IAutomationDriver {
	private int cycleTime;
	private Timer timer;
	private IMachineModel model;

	public AutomationDriver(IMachineModel machine) {
		this(machine, 10);
	}

	public AutomationDriver(IMachineModel machine, int cycleTimeInMilliseconds) {
		model = machine;
		cycleTime = cycleTimeInMilliseconds;
	}

	@Override
	public void start() {
		timer = new Timer(cycleTime, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				model.step();
			}
		});
		timer.start();
	}
}

/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine;

import electroMechanicalLogic.RAM.Fast.SixtyFourKilobyteRAM;
import electroMechanicalLogic.RAM.Interfaces.ISixtyFourKilobyteRAM;
import electroMechanicalMachine.Processor.EMC0001;
import electroMechanicalMachine.Processor.Interfaces.IProcessor;

public class ElectroMechanicalComputerVersion0001 extends
		ProcessingMachineControlPanel {
	public static void main(final String[] args) {
		final ElectroMechanicalComputerVersion0001 frame = new ElectroMechanicalComputerVersion0001();
		frame.setVisible(true);
	}

	private static final long serialVersionUID = 1L;

	public ElectroMechanicalComputerVersion0001() {
		this("Electro-Mechancial Computer Version ", new EMC0001(),
				new SixtyFourKilobyteRAM());
	}

	protected ElectroMechanicalComputerVersion0001(String caption,
			IProcessor processor, ISixtyFourKilobyteRAM ram) {
		super(caption, processor, ram);
	}

	@Override
	protected void setTitle() {
		placeTitleLabel(" Electro-Mechancial Computer Version 1",
				"Labels/EMC0001Label.jpg");
	}

}

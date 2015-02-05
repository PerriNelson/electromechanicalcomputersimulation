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
import electroMechanicalMachine.Processor.AM0011;
import electroMechanicalMachine.Processor.Interfaces.IProcessor;

public class AddingMachineMarkXI extends ProcessingMachineControlPanel {
	public static void main(final String[] args) {
		final AddingMachineMarkXI frame = new AddingMachineMarkXI();
		frame.setVisible(true);
	}

	private static final long serialVersionUID = 1L;

	public AddingMachineMarkXI() {
		this("Adding Machine Mark XI", new AM0011(), new SixtyFourKilobyteRAM());
	}

	protected AddingMachineMarkXI(String caption, IProcessor processor,
			ISixtyFourKilobyteRAM ram) {
		super(caption, processor, ram);
	}

	@Override
	protected void setTitle() {
		placeTitleLabel(" Adding Machine Mark XI ",
				"Labels/AddingMachineMarkXILabel.jpg");
	}

}

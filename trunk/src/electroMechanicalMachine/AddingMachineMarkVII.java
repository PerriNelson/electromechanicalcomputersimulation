/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine;

import electroMechanicalLogic.RAM.Fast.SixtyFourKilobyteRAM;
import electroMechanicalMachine.Model.AddingMachineMarkVIIModel;
import electroMechanicalMachine.Model.Interfaces.IAddingMachineMarkVIModel;

public class AddingMachineMarkVII extends AddingMachineMarkVI {
	public static void main(final String[] args) {
		final AddingMachineMarkVII frame = new AddingMachineMarkVII();
		frame.setVisible(true);
	}

	public static final long serialVersionUID = 1l;

	public AddingMachineMarkVII() {
		this("AddingMachineMark VII", new AddingMachineMarkVIIModel(
				new SixtyFourKilobyteRAM(), new SixtyFourKilobyteRAM()));

	}

	public AddingMachineMarkVII(final String caption,
			final IAddingMachineMarkVIModel theModel) {
		super(caption, theModel);
	}

	@Override
	protected void setTitle() {
		placeTitleLabel(" Adding Machine Mark VII ",
				"Labels/AddingMachineMarkVIILabel.jpg");
	}
}

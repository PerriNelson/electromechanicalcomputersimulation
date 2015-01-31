/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine;

import electroMechanicalLogic.RAM.Fast.SixtyFourKilobyteRAM;
import electroMechanicalMachine.Model.AddingMachineMarkVIIIModel;
import electroMechanicalMachine.Model.Interfaces.IAddingMachineMarkVIModel;

public class AddingMachineMarkVIII extends AddingMachineMarkVI {
	public static final long serialVersionUID = 1l;

	public static void main(final String[] args) {
		final AddingMachineMarkVIII frame = new AddingMachineMarkVIII();
		frame.setVisible(true);
	}

	public AddingMachineMarkVIII() {
		this("AddingMachineMark VIII", new AddingMachineMarkVIIIModel(
				new SixtyFourKilobyteRAM(), new SixtyFourKilobyteRAM()));

	}

	public AddingMachineMarkVIII(final String caption,
			final IAddingMachineMarkVIModel theModel) {
		super(caption, theModel);
	}

	@Override
	protected void setTitle() {
		placeTitleLabel(" Adding Machine Mark VIII ",
				"Labels/AddingMachineMarkVIIILabel.jpg");
	}
}

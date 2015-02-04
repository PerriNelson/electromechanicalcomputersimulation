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
import electroMechanicalMachine.Processor.AM0010;
import electroMechanicalMachine.Processor.Interfaces.IProcessor;
import electroMechanicalMachine.UIComponents.ToggleSwitch;

public class AddingMachineMarkX extends ProcessingMachineControlPanel {
	public static void main(final String[] args) {
		final AddingMachineMarkX frame = new AddingMachineMarkX();
		frame.setVisible(true);
	}

	private static final long serialVersionUID = 1L;

	public AddingMachineMarkX() {
		this("Adding Machine Mark X", new AM0010(), new SixtyFourKilobyteRAM());
	}

	protected AddingMachineMarkX(String caption, IProcessor processor,
			ISixtyFourKilobyteRAM ram) {
		super(caption, processor, ram);
	}

	@Override
	protected ToggleSwitch placeToggleSwitch(final int column, final int row) {
		return placeToggleSwitch(column, row, 1);
	}

	@Override
	protected ToggleSwitch placeToggleSwitch(final int column, final int row,
			final int columns) {
		final ToggleSwitch toggleSwitch = super.placeToggleSwitch(column, row,
				columns);
		toggleSwitch.addPropertyChangeListener(this);
		return toggleSwitch;
	}

	@Override
	protected void setTitle() {
		placeTitleLabel(" Adding Machine Mark X ",
				"Labels/AddingMachineMarkXLabel.jpg");
	}

}

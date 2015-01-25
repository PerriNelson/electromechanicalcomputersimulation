/*
ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Model;

import electroMechanicalLogic.SixtyFourKilobyteRAM;
import electroMechanicalLogic.Interfaces.ISixtyFourKilobyteRAM;
import electroMechanicalMachine.Model.Interfaces.IMarkVIIALU;
import electroMechanicalMachine.Model.Interfaces.IMarkVIIInstructionDecoder;

public class AddingMachineMarkVIIModel extends AddingMachineMarkVIModel {

	public AddingMachineMarkVIIModel() {
		super(new SixtyFourKilobyteRAM(), new SixtyFourKilobyteRAM());
	}

	public AddingMachineMarkVIIModel(final ISixtyFourKilobyteRAM codeRAM,
			final ISixtyFourKilobyteRAM dataRAM) {
		super(codeRAM, dataRAM);
	}

	@Override
	protected void setALU() {
		alu = new MarkVIIALU();
	}

	@Override
	protected void setInstructionDecoder() {
		instructionDecoder = new MarkVIIInstructionDecoder();
	}

	@Override
	protected void stepALU() {
		((IMarkVIIALU) alu)
				.setSubtract(((IMarkVIIInstructionDecoder) instructionDecoder)
						.getSubtract());
		super.stepALU();
	}

}

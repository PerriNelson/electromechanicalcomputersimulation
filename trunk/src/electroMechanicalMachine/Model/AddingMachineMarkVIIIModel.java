/*
ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Model;

import electroMechanicalLogic.RAM.SixtyFourKilobyteRAM;
import electroMechanicalLogic.RAM.Interfaces.ISixtyFourKilobyteRAM;
import electroMechanicalMachine.Model.Interfaces.IMarkVIIIALU;
import electroMechanicalMachine.Model.Interfaces.IMarkVIIIInstructionDecoder;

public class AddingMachineMarkVIIIModel extends AddingMachineMarkVIIModel {

	public AddingMachineMarkVIIIModel() {
		super(new SixtyFourKilobyteRAM(), new SixtyFourKilobyteRAM());
	}

	public AddingMachineMarkVIIIModel(final ISixtyFourKilobyteRAM codeRAM,
			final ISixtyFourKilobyteRAM dataRAM) {
		super(codeRAM, dataRAM);
	}

	@Override
	protected void setALU() {
		alu = new MarkVIIIALU();
	}

	@Override
	protected void setInstructionDecoder() {
		instructionDecoder = new MarkVIIIInstructionDecoder();
	}

	@Override
	protected void stepALU() {
		((IMarkVIIIALU) alu)
				.setAddWithCarry(((IMarkVIIIInstructionDecoder) instructionDecoder)
						.getAddWithCarry());
		((IMarkVIIIALU) alu)
				.setSubtractWithBorrow(((IMarkVIIIInstructionDecoder) instructionDecoder)
						.getSubtractWithBorrow());
		super.stepALU();
	}

}

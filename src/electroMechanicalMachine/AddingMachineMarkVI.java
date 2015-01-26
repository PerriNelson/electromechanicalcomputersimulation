/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import userInterface.AutomationDriver;
import userInterface.BasicUIFrame;
import userInterface.Lamp;
import userInterface.ToggleSwitch;
import userInterface.Interfaces.IAutomationDriver;
import userInterface.Interfaces.PowerState;
import electroMechanicalLogic.Fast.SixtyFourKilobyteRAM;
import electroMechanicalMachine.Model.AddingMachineMarkVIModel;
import electroMechanicalMachine.Model.Interfaces.IAddingMachineMarkVIModel;

public class AddingMachineMarkVI extends BasicUIFrame implements
		PropertyChangeListener {
	public static final long serialVersionUID = 1l;

	private static final String powerOutPropertyName = "powerOut";

	private static final int titleRow = 0;

	private static final int codeSwitchRow = 1;
	private static final int codeLabelRow = 2;
	private static final int addressSwitchRow = 3;
	private static final int addressLabelRow = 4;
	private static final int dataSwitchRow = 5;
	private static final int dataLabelRow = 6;
	private static final int dataLampRow = 7;

	private static final int column0 = 16;
	private static final int column1 = 15;
	private static final int column2 = 14;
	private static final int column3 = 13;
	private static final int column4 = 12;
	private static final int column5 = 11;
	private static final int column6 = 10;
	private static final int column7 = 9;
	private static final int column8 = 8;
	private static final int column9 = 7;
	private static final int columnA = 6;
	private static final int columnB = 5;
	private static final int columnC = 4;
	private static final int columnD = 3;
	private static final int columnE = 2;
	private static final int columnF = 1;

	public static void main(final String[] args) {
		final AddingMachineMarkVI frame = new AddingMachineMarkVI();
		frame.setVisible(true);
	}

	private ToggleSwitch useCodePanelSwitch;
	private ToggleSwitch resetSwitch;
	private ToggleSwitch addressSwitch0;
	private ToggleSwitch addressSwitch1;
	private ToggleSwitch addressSwitch2;
	private ToggleSwitch addressSwitch3;
	private ToggleSwitch addressSwitch4;
	private ToggleSwitch addressSwitch5;
	private ToggleSwitch addressSwitch6;
	private ToggleSwitch addressSwitch7;
	private ToggleSwitch addressSwitch8;
	private ToggleSwitch addressSwitch9;
	private ToggleSwitch addressSwitchA;
	private ToggleSwitch addressSwitchB;
	private ToggleSwitch addressSwitchC;
	private ToggleSwitch addressSwitchD;
	private ToggleSwitch addressSwitchE;
	private ToggleSwitch addressSwitchF;
	private ToggleSwitch dataSwitch0;
	private ToggleSwitch dataSwitch1;
	private ToggleSwitch dataSwitch2;
	private ToggleSwitch dataSwitch3;
	private ToggleSwitch dataSwitch4;
	private ToggleSwitch dataSwitch5;
	private ToggleSwitch dataSwitch6;
	private ToggleSwitch dataSwitch7;
	private Lamp dataLamp0;
	private Lamp dataLamp1;
	private Lamp dataLamp2;
	private Lamp dataLamp3;
	private Lamp dataLamp4;
	private Lamp dataLamp5;
	private Lamp dataLamp6;
	private Lamp dataLamp7;
	private ToggleSwitch write;
	private ToggleSwitch takeOver;

	protected IAddingMachineMarkVIModel model;
	protected IAutomationDriver automationDriver;

	public AddingMachineMarkVI() {
		this("AddingMachineMark VI", new AddingMachineMarkVIModel(
				new SixtyFourKilobyteRAM(), new SixtyFourKilobyteRAM()));

	}

	public AddingMachineMarkVI(final String caption,
			final IAddingMachineMarkVIModel theModel) {
		super(caption);
		placeControls();

		initializeModel(theModel);

		startAutomation();
	}

	protected void initializeModel(final IAddingMachineMarkVIModel theModel) {
		model = theModel;
		model.addPropertyChangeListener(this);
		model.setPower(true);
	}

	private void placeControls() {
		setSize(950, 500);
		placeLabel("Labels/AddingMachineMarkVILabel.jpg",
				"Adding Machine Mark VI", columnF, titleRow, 16);

		useCodePanelSwitch = placeToggleSwitch(column3, codeSwitchRow, 4);
		placeLabel("Labels/UseCodeRAMLabel.jpg", " Use Code RAM ", column3,
				codeLabelRow, 4);

		resetSwitch = placeToggleSwitch(column5, codeSwitchRow, 2);
		placeLabel("Labels/ResetLabel.jpg", " Reset ", column5, codeLabelRow, 2);

		addressSwitch0 = placeToggleSwitch(column0, addressSwitchRow);
		addressSwitch1 = placeToggleSwitch(column1, addressSwitchRow);
		addressSwitch2 = placeToggleSwitch(column2, addressSwitchRow);
		addressSwitch3 = placeToggleSwitch(column3, addressSwitchRow);
		addressSwitch4 = placeToggleSwitch(column4, addressSwitchRow);
		addressSwitch5 = placeToggleSwitch(column5, addressSwitchRow);
		addressSwitch6 = placeToggleSwitch(column6, addressSwitchRow);
		addressSwitch7 = placeToggleSwitch(column7, addressSwitchRow);
		addressSwitch8 = placeToggleSwitch(column8, addressSwitchRow);
		addressSwitch9 = placeToggleSwitch(column9, addressSwitchRow);
		addressSwitchA = placeToggleSwitch(columnA, addressSwitchRow);
		addressSwitchB = placeToggleSwitch(columnB, addressSwitchRow);
		addressSwitchC = placeToggleSwitch(columnC, addressSwitchRow);
		addressSwitchD = placeToggleSwitch(columnD, addressSwitchRow);
		addressSwitchE = placeToggleSwitch(columnE, addressSwitchRow);
		addressSwitchF = placeToggleSwitch(columnF, addressSwitchRow);

		placeLabel("Labels/A0Label.jpg", " A0 ", column0, addressLabelRow, 1);
		placeLabel("Labels/A1Label.jpg", " A1 ", column1, addressLabelRow, 1);
		placeLabel("Labels/A2Label.jpg", " A2 ", column2, addressLabelRow, 1);
		placeLabel("Labels/A3Label.jpg", " A3 ", column3, addressLabelRow, 1);
		placeLabel("Labels/A4Label.jpg", " A4 ", column4, addressLabelRow, 1);
		placeLabel("Labels/A5Label.jpg", " A5 ", column5, addressLabelRow, 1);
		placeLabel("Labels/A6Label.jpg", " A6 ", column6, addressLabelRow, 1);
		placeLabel("Labels/A7Label.jpg", " A7 ", column7, addressLabelRow, 1);
		placeLabel("Labels/A8Label.jpg", " A8 ", column8, addressLabelRow, 1);
		placeLabel("Labels/A9Label.jpg", " A9 ", column9, addressLabelRow, 1);
		placeLabel("Labels/AALabel.jpg", " AA ", columnA, addressLabelRow, 1);
		placeLabel("Labels/ABLabel.jpg", " AB ", columnB, addressLabelRow, 1);
		placeLabel("Labels/ACLabel.jpg", " AC ", columnC, addressLabelRow, 1);
		placeLabel("Labels/ADLabel.jpg", " AD ", columnD, addressLabelRow, 1);
		placeLabel("Labels/AELabel.jpg", " AE ", columnE, addressLabelRow, 1);
		placeLabel("Labels/AFLabel.jpg", " AF ", columnF, addressLabelRow, 1);

		dataSwitch0 = placeToggleSwitch(column8, dataSwitchRow);
		dataSwitch1 = placeToggleSwitch(column9, dataSwitchRow);
		dataSwitch2 = placeToggleSwitch(columnA, dataSwitchRow);
		dataSwitch3 = placeToggleSwitch(columnB, dataSwitchRow);
		dataSwitch4 = placeToggleSwitch(columnC, dataSwitchRow);
		dataSwitch5 = placeToggleSwitch(columnD, dataSwitchRow);
		dataSwitch6 = placeToggleSwitch(columnE, dataSwitchRow);
		dataSwitch7 = placeToggleSwitch(columnF, dataSwitchRow);

		write = placeToggleSwitch(column5, dataSwitchRow);
		placeLabel("Labels/WriteLabel.jpg", " Write ", column6, dataLabelRow, 3);

		takeOver = placeToggleSwitch(column2, dataSwitchRow);
		placeLabel("Labels/TakeOverLabel.jpg", " Take Over ", column3,
				dataLabelRow, 3);

		placeLabel("Labels/D0Label.jpg", " D0 ", column8, dataLabelRow, 1);
		placeLabel("Labels/D1Label.jpg", " D1 ", column9, dataLabelRow, 1);
		placeLabel("Labels/D2Label.jpg", " D2 ", columnA, dataLabelRow, 1);
		placeLabel("Labels/D3Label.jpg", " D3 ", columnB, dataLabelRow, 1);
		placeLabel("Labels/D4Label.jpg", " D4 ", columnC, dataLabelRow, 1);
		placeLabel("Labels/D5Label.jpg", " D5 ", columnD, dataLabelRow, 1);
		placeLabel("Labels/D6Label.jpg", " D6 ", columnE, dataLabelRow, 1);
		placeLabel("Labels/D7Label.jpg", " D7 ", columnF, dataLabelRow, 1);

		dataLamp0 = placeLamp(column8, dataLampRow);
		dataLamp1 = placeLamp(column9, dataLampRow);
		dataLamp2 = placeLamp(columnA, dataLampRow);
		dataLamp3 = placeLamp(columnB, dataLampRow);
		dataLamp4 = placeLamp(columnC, dataLampRow);
		dataLamp5 = placeLamp(columnD, dataLampRow);
		dataLamp6 = placeLamp(columnE, dataLampRow);
		dataLamp7 = placeLamp(columnF, dataLampRow);
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
	public void propertyChange(final PropertyChangeEvent evt) {
		final Object source = evt.getSource();
		if (powerOutPropertyName.equalsIgnoreCase(evt.getPropertyName())) {
			final Boolean value = PowerState.on == evt.getNewValue();
			if (source == useCodePanelSwitch) {
				model.setUseCodePanel(value);
			} else if (source == resetSwitch) {
				model.setReset(value);
			} else if (source == addressSwitch0) {
				model.setA0(value);
			} else if (source == addressSwitch1) {
				model.setA1(value);
			} else if (source == addressSwitch2) {
				model.setA2(value);
			} else if (source == addressSwitch3) {
				model.setA3(value);
			} else if (source == addressSwitch4) {
				model.setA4(value);
			} else if (source == addressSwitch5) {
				model.setA5(value);
			} else if (source == addressSwitch6) {
				model.setA6(value);
			} else if (source == addressSwitch7) {
				model.setA7(value);
			} else if (source == addressSwitch8) {
				model.setA8(value);
			} else if (source == addressSwitch9) {
				model.setA9(value);
			} else if (source == addressSwitchA) {
				model.setAA(value);
			} else if (source == addressSwitchB) {
				model.setAB(value);
			} else if (source == addressSwitchC) {
				model.setAC(value);
			} else if (source == addressSwitchD) {
				model.setAD(value);
			} else if (source == addressSwitchE) {
				model.setAE(value);
			} else if (source == addressSwitchF) {
				model.setAF(value);
			} else if (source == dataSwitch0) {
				model.setDI0(value);
			} else if (source == dataSwitch1) {
				model.setDI1(value);
			} else if (source == dataSwitch2) {
				model.setDI2(value);
			} else if (source == dataSwitch3) {
				model.setDI3(value);
			} else if (source == dataSwitch4) {
				model.setDI4(value);
			} else if (source == dataSwitch5) {
				model.setDI5(value);
			} else if (source == dataSwitch6) {
				model.setDI6(value);
			} else if (source == dataSwitch7) {
				model.setDI7(value);
			} else if (source == write) {
				model.setW(value);
			} else if (source == takeOver) {
				model.setTakeover(value);
			}
		} else if (source == model) {
			dataLamp0.setOn(model.getDO0());
			dataLamp1.setOn(model.getDO1());
			dataLamp2.setOn(model.getDO2());
			dataLamp3.setOn(model.getDO3());
			dataLamp4.setOn(model.getDO4());
			dataLamp5.setOn(model.getDO5());
			dataLamp6.setOn(model.getDO6());
			dataLamp7.setOn(model.getDO7());
		}
	}

	protected void startAutomation() {
		automationDriver = new AutomationDriver(model, 10);
		automationDriver.start();
	}
}

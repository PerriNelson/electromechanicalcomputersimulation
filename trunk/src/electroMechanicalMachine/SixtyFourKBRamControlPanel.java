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

import userInterface.Lamp;
import userInterface.ToggleSwitch;
import userInterface.Interfaces.PowerState;
import electroMechanicalMachine.Interfaces.ISimulationDriver;
import electroMechanicalMachine.Model.SixtyFourKilobyteRamControlPanelModel;
import electroMechanicalMachine.Model.Interfaces.ISixtyFourKilobyteRamControlPanelModel;

/**
 *
 */
public class SixtyFourKBRamControlPanel extends ControlPanel implements
		PropertyChangeListener {
	public static final long serialVersionUID = 1l;

	private static final String powerOutPropertyName = "powerOut";

	private static final int titleRow = 0;
	private static final int addressSwitchRow = 1;
	private static final int addressLabelRow = 2;
	private static final int dataSwitchRow = 3;
	private static final int dataLabelRow = 4;
	private static final int dataLampRow = 5;

	private static final int column0 = 15;
	private static final int column1 = 14;
	private static final int column2 = 13;
	private static final int column3 = 12;
	private static final int column4 = 11;
	private static final int column5 = 10;
	private static final int column6 = 9;
	private static final int column7 = 8;
	private static final int column8 = 7;
	private static final int column9 = 6;
	private static final int columnA = 5;
	private static final int columnB = 4;
	private static final int columnC = 3;
	private static final int columnD = 2;
	private static final int columnE = 1;
	private static final int columnF = 0;

	public static void main(final String[] args) {
		final SixtyFourKBRamControlPanel frame = new SixtyFourKBRamControlPanel();
		frame.setVisible(true);
	}

	private ToggleSwitch[] addressSwitches;
	private ToggleSwitch[] dataSwitches;
	private Lamp[] lamps;
	private ToggleSwitch write;
	private ToggleSwitch takeOver;

	protected ISixtyFourKilobyteRamControlPanelModel model;
	protected ISimulationDriver automationDriver;

	public SixtyFourKBRamControlPanel() {
		this("64KB RAM Control Panel",
				new SixtyFourKilobyteRamControlPanelModel());

	}

	public SixtyFourKBRamControlPanel(final String caption,
			final ISixtyFourKilobyteRamControlPanelModel theModel) {
		super(caption);
		placeControls();

		initializeModel(theModel);

		runSimulation(theModel, 10);
	}

	protected void initializeModel(
			final ISixtyFourKilobyteRamControlPanelModel theModel) {
		model = theModel;
		model.setPower(true);
	}

	private void placeControls() {
		setSize(925, 370);
		placeLabel("Labels/64KbRamControlPanelLabel.jpg",
				"64KB RAM Control Panel", columnF, titleRow, 16);

		addressSwitches = new ToggleSwitch[16];
		addressSwitches[0] = placeToggleSwitch(column0, addressSwitchRow);
		addressSwitches[1] = placeToggleSwitch(column1, addressSwitchRow);
		addressSwitches[2] = placeToggleSwitch(column2, addressSwitchRow);
		addressSwitches[3] = placeToggleSwitch(column3, addressSwitchRow);
		addressSwitches[4] = placeToggleSwitch(column4, addressSwitchRow);
		addressSwitches[5] = placeToggleSwitch(column5, addressSwitchRow);
		addressSwitches[6] = placeToggleSwitch(column6, addressSwitchRow);
		addressSwitches[7] = placeToggleSwitch(column7, addressSwitchRow);
		addressSwitches[8] = placeToggleSwitch(column8, addressSwitchRow);
		addressSwitches[9] = placeToggleSwitch(column9, addressSwitchRow);
		addressSwitches[10] = placeToggleSwitch(columnA, addressSwitchRow);
		addressSwitches[11] = placeToggleSwitch(columnB, addressSwitchRow);
		addressSwitches[12] = placeToggleSwitch(columnC, addressSwitchRow);
		addressSwitches[13] = placeToggleSwitch(columnD, addressSwitchRow);
		addressSwitches[14] = placeToggleSwitch(columnE, addressSwitchRow);
		addressSwitches[15] = placeToggleSwitch(columnF, addressSwitchRow);

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

		dataSwitches = new ToggleSwitch[8];
		dataSwitches[0] = placeToggleSwitch(column8, dataSwitchRow);
		dataSwitches[1] = placeToggleSwitch(column9, dataSwitchRow);
		dataSwitches[2] = placeToggleSwitch(columnA, dataSwitchRow);
		dataSwitches[3] = placeToggleSwitch(columnB, dataSwitchRow);
		dataSwitches[4] = placeToggleSwitch(columnC, dataSwitchRow);
		dataSwitches[5] = placeToggleSwitch(columnD, dataSwitchRow);
		dataSwitches[6] = placeToggleSwitch(columnE, dataSwitchRow);
		dataSwitches[7] = placeToggleSwitch(columnF, dataSwitchRow);

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

		lamps = new Lamp[8];
		lamps[0] = placeLamp(column8, dataLampRow);
		lamps[1] = placeLamp(column9, dataLampRow);
		lamps[2] = placeLamp(columnA, dataLampRow);
		lamps[3] = placeLamp(columnB, dataLampRow);
		lamps[4] = placeLamp(columnC, dataLampRow);
		lamps[5] = placeLamp(columnD, dataLampRow);
		lamps[6] = placeLamp(columnE, dataLampRow);
		lamps[7] = placeLamp(columnF, dataLampRow);
	}

	@Override
	protected ToggleSwitch placeToggleSwitch(final int column, final int row) {
		final ToggleSwitch toggleSwitch = super.placeToggleSwitch(column, row);
		toggleSwitch.addPropertyChangeListener(this);
		return toggleSwitch;
	}

	@Override
	public void propertyChange(final PropertyChangeEvent evt) {
		final Object source = evt.getSource();
		if (powerOutPropertyName.equalsIgnoreCase(evt.getPropertyName())) {
			final Boolean value = PowerState.on == evt.getNewValue();
			for (int i = 0; i < 16; i++) {

				if (source == addressSwitches[i]) {
					setAddress(i, value);
					return;
				}
			}
			for (int i = 0; i < 8; i++) {
				if (source == dataSwitches[i]) {
					setData(i, value);
					return;
				}
			}
			if (source == write) {
				model.setCpW(value);
			} else if (source == takeOver) {
				model.setTakeover(value);
			}
		}
	}

	private void setAddress(final int bit, final Boolean value) {
		switch (bit) {
		case 0:
			model.setCpA0(value);
			break;
		case 1:
			model.setCpA1(value);
			break;
		case 2:
			model.setCpA2(value);
			break;
		case 3:
			model.setCpA3(value);
			break;
		case 4:
			model.setCpA4(value);
			break;
		case 5:
			model.setCpA5(value);
			break;
		case 6:
			model.setCpA6(value);
			break;
		case 7:
			model.setCpA7(value);
			break;
		case 8:
			model.setCpA8(value);
			break;
		case 9:
			model.setCpA9(value);
			break;
		case 10:
			model.setCpAA(value);
			break;
		case 11:
			model.setCpAB(value);
			break;
		case 12:
			model.setCpAC(value);
			break;
		case 13:
			model.setCpAD(value);
			break;
		case 14:
			model.setCpAE(value);
			break;
		case 15:
			model.setCpAF(value);
			break;
		}
	}

	private void setData(final int bit, final Boolean value) {
		switch (bit) {
		case 0:
			model.setCpDI0(value);
			break;
		case 1:
			model.setCpDI1(value);
			break;
		case 2:
			model.setCpDI2(value);
			break;
		case 3:
			model.setCpDI3(value);
			break;
		case 4:
			model.setCpDI4(value);
			break;
		case 5:
			model.setCpDI5(value);
			break;
		case 6:
			model.setCpDI6(value);
			break;
		case 7:
			model.setCpDI7(value);
			break;
		}
	}

	@Override
	protected void onModelUpdated() {
		lamps[0].setOn(model.getDO0());
		lamps[1].setOn(model.getDO1());
		lamps[2].setOn(model.getDO2());
		lamps[3].setOn(model.getDO3());
		lamps[4].setOn(model.getDO4());
		lamps[5].setOn(model.getDO5());
		lamps[6].setOn(model.getDO6());
		lamps[7].setOn(model.getDO7());
	}
}

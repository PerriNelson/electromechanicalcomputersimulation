/*
  ElectroMechancialComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package userInterface;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import userInterface.Interfaces.PowerState;
import electroMechanicalLogic.TwoLineToOneLineSelector;
import electroMechanicalLogic.SixtyFourKilobyteRAM;

public class SixtyFourKBRamControlPanel extends BasicUIFrame implements
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

	public static void main(String[] args) {
		SixtyFourKBRamControlPanel frame = new SixtyFourKBRamControlPanel();
		frame.setVisible(true);
	}

	private ToggleSwitch[] addressSwitches;
	private TwoLineToOneLineSelector[] addressSelectors;
	private ToggleSwitch[] dataSwitches;
	private TwoLineToOneLineSelector[] dataSelectors;
	private Lamp[] lamps;
	private ToggleSwitch write;
	private TwoLineToOneLineSelector writeSelector;
	private ToggleSwitch takeOver;
	private SixtyFourKilobyteRAM ram;

	public SixtyFourKBRamControlPanel() {
		super("64KB RAM Control Panel");
		setSize(925, 370);

		placeLabel("images/64KbRamControlPanelLabel.jpg",
				"64KB RAM Control Panel", columnF, titleRow, 16);

		addressSelectors = new TwoLineToOneLineSelector[16];
		for (int i = 0; i < 16; i++) {
			addressSelectors[i] = new TwoLineToOneLineSelector();
			addressSelectors[i].setPower(true);
		}
		dataSelectors = new TwoLineToOneLineSelector[8];
		for (int i = 0; i < 8; i++) {
			dataSelectors[i] = new TwoLineToOneLineSelector();
			dataSelectors[i].setPower(true);
		}
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

		placeLabel("images/A0Label.jpg", " A0 ", column0, addressLabelRow, 1);
		placeLabel("images/A1Label.jpg", " A1 ", column1, addressLabelRow, 1);
		placeLabel("images/A2Label.jpg", " A2 ", column2, addressLabelRow, 1);
		placeLabel("images/A3Label.jpg", " A3 ", column3, addressLabelRow, 1);
		placeLabel("images/A4Label.jpg", " A4 ", column4, addressLabelRow, 1);
		placeLabel("images/A5Label.jpg", " A5 ", column5, addressLabelRow, 1);
		placeLabel("images/A6Label.jpg", " A6 ", column6, addressLabelRow, 1);
		placeLabel("images/A7Label.jpg", " A7 ", column7, addressLabelRow, 1);
		placeLabel("images/A8Label.jpg", " A8 ", column8, addressLabelRow, 1);
		placeLabel("images/A9Label.jpg", " A9 ", column9, addressLabelRow, 1);
		placeLabel("images/AALabel.jpg", " AA ", columnA, addressLabelRow, 1);
		placeLabel("images/ABLabel.jpg", " AB ", columnB, addressLabelRow, 1);
		placeLabel("images/ACLabel.jpg", " AC ", columnC, addressLabelRow, 1);
		placeLabel("images/ADLabel.jpg", " AD ", columnD, addressLabelRow, 1);
		placeLabel("images/AELabel.jpg", " AE ", columnE, addressLabelRow, 1);
		placeLabel("images/AFLabel.jpg", " AF ", columnF, addressLabelRow, 1);

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
		placeLabel("images/WriteLabel.jpg", " Write ", column6, dataLabelRow, 3);
		writeSelector = new TwoLineToOneLineSelector();
		writeSelector.setPower(true);
		takeOver = placeToggleSwitch(column2, dataSwitchRow);
		placeLabel("images/TakeOverLabel.jpg", " Take Over ", column3,
				dataLabelRow, 3);

		placeLabel("images/D0Label.jpg", " D0 ", column8, dataLabelRow, 1);
		placeLabel("images/D1Label.jpg", " D1 ", column9, dataLabelRow, 1);
		placeLabel("images/D2Label.jpg", " D2 ", columnA, dataLabelRow, 1);
		placeLabel("images/D3Label.jpg", " D3 ", columnB, dataLabelRow, 1);
		placeLabel("images/D4Label.jpg", " D4 ", columnC, dataLabelRow, 1);
		placeLabel("images/D5Label.jpg", " D5 ", columnD, dataLabelRow, 1);
		placeLabel("images/D6Label.jpg", " D6 ", columnE, dataLabelRow, 1);
		placeLabel("images/D7Label.jpg", " D7 ", columnF, dataLabelRow, 1);

		lamps = new Lamp[8];
		lamps[0] = placeLamp(column8, dataLampRow);
		lamps[1] = placeLamp(column9, dataLampRow);
		lamps[2] = placeLamp(columnA, dataLampRow);
		lamps[3] = placeLamp(columnB, dataLampRow);
		lamps[4] = placeLamp(columnC, dataLampRow);
		lamps[5] = placeLamp(columnD, dataLampRow);
		lamps[6] = placeLamp(columnE, dataLampRow);
		lamps[7] = placeLamp(columnF, dataLampRow);

		ram = new SixtyFourKilobyteRAM();
		ram.setPower(true);
	}

	@Override
	protected ToggleSwitch placeToggleSwitch(int column, int row) {
		ToggleSwitch toggleSwitch = super.placeToggleSwitch(column, row);
		toggleSwitch.addPropertyChangeListener(this);
		return toggleSwitch;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (powerOutPropertyName.equalsIgnoreCase(evt.getPropertyName())) {
			Object source = evt.getSource();
			Boolean value = PowerState.on == evt.getNewValue();
			for (int i = 0; i < 16; i++) {

				if (source == addressSwitches[i]) {
					setAddress(i, value);
					step();
					return;
				}
			}
			for (int i = 0; i < 8; i++) {
				if (source == dataSwitches[i]) {
					setData(i, value);
					step();
					return;
				}
			}
			if (source == write) {
				writeSelector.setB(value);
				step();
				return;
			}
			if (source == takeOver) {
				setTakeOver(value);
				step();
				return;
			}
		}
	}

	private void setAddress(int bit, Boolean value) {
		addressSelectors[bit].setB(value);
	}

	private void setData(int bit, Boolean value) {
		dataSelectors[bit].setB(value);
	}

	private void setTakeOver(Boolean value) {
		for (int i = 0; i < 16; i++) {
			addressSelectors[i].setSelect(value);
		}
		for (int i = 0; i < 8; i++) {
			dataSelectors[i].setSelect(value);
		}
		writeSelector.setSelect(value);
	}

	private void step() {
		for (int i = 0; i < 16; i++) {
			addressSelectors[i].step();
		}
		for (int i = 0; i < 8; i++) {
			dataSelectors[i].step();
		}
		writeSelector.step();
		ram.setA0(addressSelectors[0].getQ());
		ram.setA1(addressSelectors[1].getQ());
		ram.setA2(addressSelectors[2].getQ());
		ram.setA3(addressSelectors[3].getQ());
		ram.setA4(addressSelectors[4].getQ());
		ram.setA5(addressSelectors[5].getQ());
		ram.setA6(addressSelectors[6].getQ());
		ram.setA7(addressSelectors[7].getQ());
		ram.setA8(addressSelectors[8].getQ());
		ram.setA9(addressSelectors[9].getQ());
		ram.setAA(addressSelectors[10].getQ());
		ram.setAB(addressSelectors[11].getQ());
		ram.setAC(addressSelectors[12].getQ());
		ram.setAD(addressSelectors[13].getQ());
		ram.setAE(addressSelectors[14].getQ());
		ram.setAF(addressSelectors[15].getQ());
		ram.setDI0(dataSelectors[0].getQ());
		ram.setDI1(dataSelectors[1].getQ());
		ram.setDI2(dataSelectors[2].getQ());
		ram.setDI3(dataSelectors[3].getQ());
		ram.setDI4(dataSelectors[4].getQ());
		ram.setDI5(dataSelectors[5].getQ());
		ram.setDI6(dataSelectors[6].getQ());
		ram.setDI7(dataSelectors[7].getQ());
		ram.setW(writeSelector.getQ());

		ram.step();

		lamps[0].setOn(ram.getDO0());
		lamps[1].setOn(ram.getDO1());
		lamps[2].setOn(ram.getDO2());
		lamps[3].setOn(ram.getDO3());
		lamps[4].setOn(ram.getDO4());
		lamps[5].setOn(ram.getDO5());
		lamps[6].setOn(ram.getDO6());
		lamps[7].setOn(ram.getDO7());
	}

}

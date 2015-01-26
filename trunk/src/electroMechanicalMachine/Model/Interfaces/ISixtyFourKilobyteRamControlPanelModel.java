/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalMachine.Model.Interfaces;

import electroMechanicalLogic.DataChannel.Interfaces.IEightBitDataIn;
import electroMechanicalLogic.DataChannel.Interfaces.IEightBitDataOut;
import electroMechanicalLogic.DataChannel.Interfaces.ISixteenBitAInput;

public interface ISixtyFourKilobyteRamControlPanelModel extends IMachineModel,
IEightBitDataOut {

	public abstract ISixteenBitAInput getPanelAddressIn();
	public abstract IEightBitDataIn getPanelDataIn();
	public abstract ISixteenBitAInput getExternalAddressIn();
	public abstract IEightBitDataIn getExternalDataIn();
	
	// Control Panel Inputs
	public abstract void setCpA0(boolean value);

	public abstract void setCpA1(boolean value);

	public abstract void setCpA2(boolean value);

	public abstract void setCpA3(boolean value);

	public abstract void setCpA4(boolean value);

	public abstract void setCpA5(boolean value);

	public abstract void setCpA6(boolean value);

	public abstract void setCpA7(boolean value);

	public abstract void setCpA8(boolean value);

	public abstract void setCpA9(boolean value);

	public abstract void setCpAA(boolean value);

	public abstract void setCpAB(boolean value);

	public abstract void setCpAC(boolean value);

	public abstract void setCpAD(boolean value);

	public abstract void setCpAE(boolean value);

	public abstract void setCpAF(boolean value);

	public abstract void setCpDI0(boolean value);

	public abstract void setCpDI1(boolean value);

	public abstract void setCpDI2(boolean value);

	public abstract void setCpDI3(boolean value);

	public abstract void setCpDI4(boolean value);

	public abstract void setCpDI5(boolean value);

	public abstract void setCpDI6(boolean value);

	public abstract void setCpDI7(boolean value);

	public abstract void setTakeover(boolean value);

	public abstract void setCpW(boolean value);

	// External Circuitry Inputs
	public abstract void setEcA0(boolean value);

	public abstract void setEcA1(boolean value);

	public abstract void setEcA2(boolean value);

	public abstract void setEcA3(boolean value);

	public abstract void setEcA4(boolean value);

	public abstract void setEcA5(boolean value);

	public abstract void setEcA6(boolean value);

	public abstract void setEcA7(boolean value);

	public abstract void setEcA8(boolean value);

	public abstract void setEcA9(boolean value);

	public abstract void setEcAA(boolean value);

	public abstract void setEcAB(boolean value);

	public abstract void setEcAC(boolean value);

	public abstract void setEcAD(boolean value);

	public abstract void setEcAE(boolean value);

	public abstract void setEcAF(boolean value);

	public abstract void setEcDI0(boolean value);

	public abstract void setEcDI1(boolean value);

	public abstract void setEcDI2(boolean value);

	public abstract void setEcDI3(boolean value);

	public abstract void setEcDI4(boolean value);

	public abstract void setEcDI5(boolean value);

	public abstract void setEcDI6(boolean value);

	public abstract void setEcDI7(boolean value);

	public abstract void setEcW(boolean value);
}

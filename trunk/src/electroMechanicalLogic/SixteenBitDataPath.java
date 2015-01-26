/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic;

import electroMechanicalLogic.Interfaces.DataChannels.IEightBitAInput;
import electroMechanicalLogic.Interfaces.DataChannels.IEightBitAOut;
import electroMechanicalLogic.Interfaces.DataChannels.IEightBitBInput;
import electroMechanicalLogic.Interfaces.DataChannels.IEightBitBOut;
import electroMechanicalLogic.Interfaces.DataChannels.IEightBitDataOut;
import electroMechanicalLogic.Interfaces.DataChannels.ISixteenBitAInput;
import electroMechanicalLogic.Interfaces.DataChannels.ISixteenBitAOutput;

public class SixteenBitDataPath {
	public static void AOutToAIn(final IEightBitAOut sourceLow,
			final IEightBitAOut sourceHigh, final ISixteenBitAInput target) {
		target.setA0(sourceLow.getA0());
		target.setA1(sourceLow.getA1());
		target.setA2(sourceLow.getA2());
		target.setA3(sourceLow.getA3());
		target.setA4(sourceLow.getA4());
		target.setA5(sourceLow.getA5());
		target.setA6(sourceLow.getA6());
		target.setA7(sourceLow.getA7());
		target.setA8(sourceHigh.getA0());
		target.setA9(sourceHigh.getA1());
		target.setAA(sourceHigh.getA2());
		target.setAB(sourceHigh.getA3());
		target.setAC(sourceHigh.getA4());
		target.setAD(sourceHigh.getA5());
		target.setAE(sourceHigh.getA6());
		target.setAF(sourceHigh.getA7());
	}

	public static void AOutToAIn(final ISixteenBitAOutput source,
			final IEightBitAInput targetLow, final IEightBitAInput targetHigh) {
		targetLow.setA0(source.getA0());
		targetLow.setA1(source.getA1());
		targetLow.setA2(source.getA2());
		targetLow.setA3(source.getA3());
		targetLow.setA4(source.getA4());
		targetLow.setA5(source.getA5());
		targetLow.setA6(source.getA6());
		targetLow.setA7(source.getA7());

		targetHigh.setA0(source.getA8());
		targetHigh.setA1(source.getA9());
		targetHigh.setA2(source.getAA());
		targetHigh.setA3(source.getAB());
		targetHigh.setA4(source.getAC());
		targetHigh.setA5(source.getAD());
		targetHigh.setA6(source.getAE());
		targetHigh.setA7(source.getAF());
	}

	public static void AOutToAIn(final ISixteenBitAOutput source,
			final ISixteenBitAInput target) {
		target.setA0(source.getA0());
		target.setA1(source.getA1());
		target.setA2(source.getA2());
		target.setA3(source.getA3());
		target.setA4(source.getA4());
		target.setA5(source.getA5());
		target.setA6(source.getA6());
		target.setA7(source.getA7());
		target.setA8(source.getA8());
		target.setA9(source.getA9());
		target.setAA(source.getAA());
		target.setAB(source.getAB());
		target.setAC(source.getAC());
		target.setAD(source.getAD());
		target.setAE(source.getAE());
		target.setAF(source.getAF());
	}

	public static void AOutToBIn(final ISixteenBitAOutput source,
			final IEightBitBInput targetLow, final IEightBitBInput targetHigh) {
		targetLow.setB0(source.getA0());
		targetLow.setB1(source.getA1());
		targetLow.setB2(source.getA2());
		targetLow.setB3(source.getA3());
		targetLow.setB4(source.getA4());
		targetLow.setB5(source.getA5());
		targetLow.setB6(source.getA6());
		targetLow.setB7(source.getA7());

		targetHigh.setB0(source.getA8());
		targetHigh.setB1(source.getA9());
		targetHigh.setB2(source.getAA());
		targetHigh.setB3(source.getAB());
		targetHigh.setB4(source.getAC());
		targetHigh.setB5(source.getAD());
		targetHigh.setB6(source.getAE());
		targetHigh.setB7(source.getAF());
	}

	public static void BOutToAIn(final IEightBitBOut sourceLow,
			final IEightBitBOut sourceHigh, final ISixteenBitAInput target) {
		target.setA0(sourceLow.getB0());
		target.setA1(sourceLow.getB1());
		target.setA2(sourceLow.getB2());
		target.setA3(sourceLow.getB3());
		target.setA4(sourceLow.getB4());
		target.setA5(sourceLow.getB5());
		target.setA6(sourceLow.getB6());
		target.setA7(sourceLow.getB7());
		target.setA8(sourceHigh.getB0());
		target.setA9(sourceHigh.getB1());
		target.setAA(sourceHigh.getB2());
		target.setAB(sourceHigh.getB3());
		target.setAC(sourceHigh.getB4());
		target.setAD(sourceHigh.getB5());
		target.setAE(sourceHigh.getB6());
		target.setAF(sourceHigh.getB7());
	}

	public static void DataOutToAIn(final IEightBitDataOut sourceLow,
			final IEightBitDataOut sourceHigh, final ISixteenBitAInput target) {
		target.setA0(sourceLow.getDO0());
		target.setA1(sourceLow.getDO1());
		target.setA2(sourceLow.getDO2());
		target.setA3(sourceLow.getDO3());
		target.setA4(sourceLow.getDO4());
		target.setA5(sourceLow.getDO5());
		target.setA6(sourceLow.getDO6());
		target.setA7(sourceLow.getDO7());

		target.setA8(sourceHigh.getDO0());
		target.setA9(sourceHigh.getDO1());
		target.setAA(sourceHigh.getDO2());
		target.setAB(sourceHigh.getDO3());
		target.setAC(sourceHigh.getDO4());
		target.setAD(sourceHigh.getDO5());
		target.setAE(sourceHigh.getDO6());
		target.setAF(sourceHigh.getDO7());
	}
}

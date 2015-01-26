/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.DataChannel;

import electroMechanicalLogic.DataChannel.Interfaces.IEightBitAInput;
import electroMechanicalLogic.DataChannel.Interfaces.IEightBitAOut;
import electroMechanicalLogic.DataChannel.Interfaces.IEightBitBInput;
import electroMechanicalLogic.DataChannel.Interfaces.IEightBitBOut;
import electroMechanicalLogic.DataChannel.Interfaces.IEightBitDataIn;
import electroMechanicalLogic.DataChannel.Interfaces.IEightBitDataOut;
import electroMechanicalLogic.DataChannel.Interfaces.IEightBitSum;

public class EightBitDataPath {
	public static void AOutToDataIn(final IEightBitAOut source,
			final IEightBitDataIn target) {
		target.setDI0(source.getA0());
		target.setDI1(source.getA1());
		target.setDI2(source.getA2());
		target.setDI3(source.getA3());
		target.setDI4(source.getA4());
		target.setDI5(source.getA5());
		target.setDI6(source.getA6());
		target.setDI7(source.getA7());
	}

	public static void BOutToDataIn(final IEightBitBOut source,
			final IEightBitDataIn target) {
		target.setDI0(source.getB0());
		target.setDI1(source.getB1());
		target.setDI2(source.getB2());
		target.setDI3(source.getB3());
		target.setDI4(source.getB4());
		target.setDI5(source.getB5());
		target.setDI6(source.getB6());
		target.setDI7(source.getB7());
	}

	public static void DataOutToAIn(final IEightBitDataOut source,
			final IEightBitAInput target) {
		target.setA0(source.getDO0());
		target.setA1(source.getDO1());
		target.setA2(source.getDO2());
		target.setA3(source.getDO3());
		target.setA4(source.getDO4());
		target.setA5(source.getDO5());
		target.setA6(source.getDO6());
		target.setA7(source.getDO7());
	}

	public static void DataOutToBIn(final IEightBitDataOut source,
			final IEightBitBInput target) {
		target.setB0(source.getDO0());
		target.setB1(source.getDO1());
		target.setB2(source.getDO2());
		target.setB3(source.getDO3());
		target.setB4(source.getDO4());
		target.setB5(source.getDO5());
		target.setB6(source.getDO6());
		target.setB7(source.getDO7());
	}

	public static void DataOutToDataIn(final IEightBitDataOut source,
			final IEightBitDataIn target) {
		target.setDI0(source.getDO0());
		target.setDI1(source.getDO1());
		target.setDI2(source.getDO2());
		target.setDI3(source.getDO3());
		target.setDI4(source.getDO4());
		target.setDI5(source.getDO5());
		target.setDI6(source.getDO6());
		target.setDI7(source.getDO7());
	}

	public static void SumToBIn(final IEightBitSum source,
			final IEightBitBInput target) {
		target.setB0(source.getS0());
		target.setB1(source.getS1());
		target.setB2(source.getS2());
		target.setB3(source.getS3());
		target.setB4(source.getS4());
		target.setB5(source.getS5());
		target.setB6(source.getS6());
		target.setB7(source.getS7());
	}

	public static void SumToDataIn(final IEightBitSum source,
			final IEightBitDataIn target) {
		target.setDI0(source.getS0());
		target.setDI1(source.getS1());
		target.setDI2(source.getS2());
		target.setDI3(source.getS3());
		target.setDI4(source.getS4());
		target.setDI5(source.getS5());
		target.setDI6(source.getS6());
		target.setDI7(source.getS7());
	}

}

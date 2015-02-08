/*
  ElectroMechanicalComputerSimulation by Perri D. Nelson is licensed under the Creative Commons
  Attribution-ShareAlike 3.0 Unported License.
  To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
  a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041,
  USA.
 */

package electroMechanicalLogic.DataChannel;

import electroMechanicalLogic.DataChannel.Interfaces.IEightBitAInput;
import electroMechanicalLogic.DataChannel.Interfaces.IEightBitAOutput;
import electroMechanicalLogic.DataChannel.Interfaces.IEightBitBInput;
import electroMechanicalLogic.DataChannel.Interfaces.IEightBitBOutput;
import electroMechanicalLogic.DataChannel.Interfaces.IEightBitCInput;
import electroMechanicalLogic.DataChannel.Interfaces.IEightBitCOutput;
import electroMechanicalLogic.DataChannel.Interfaces.IEightBitDInput;
import electroMechanicalLogic.DataChannel.Interfaces.IEightBitDataInput;
import electroMechanicalLogic.DataChannel.Interfaces.IEightBitDataOutput;
import electroMechanicalLogic.DataChannel.Interfaces.IEightBitSumOutput;

/**
 * Provides methods to connect eight bit inputs with eight bit outputs.
 */
public class EightBitDataPath {
	/**
	 * Connects an eight bit "A" output to an eight bit "Data" input.
	 *
	 * @param source
	 *            the eight bit source of the data to be transferred to the
	 *            target.
	 * @param target
	 *            the eight bit target to receive the data from the source
	 */
	public static void connectEightBitAOutputToEightBitDataInput(
			final IEightBitAOutput source, final IEightBitDataInput target) {
		target.setDI0(source.getA0());
		target.setDI1(source.getA1());
		target.setDI2(source.getA2());
		target.setDI3(source.getA3());
		target.setDI4(source.getA4());
		target.setDI5(source.getA5());
		target.setDI6(source.getA6());
		target.setDI7(source.getA7());
	}

	/**
	 * Connects an eight bit "B" output to an eight it "Data" input.
	 *
	 * @param source
	 *            the eight bit source of the data to be transferred to the
	 *            target.
	 * @param target
	 *            the eight bit target to receive the data from the source
	 */
	public static void connectEightBitBOutputToEightBitDataInput(
			final IEightBitBOutput source, final IEightBitDataInput target) {
		target.setDI0(source.getB0());
		target.setDI1(source.getB1());
		target.setDI2(source.getB2());
		target.setDI3(source.getB3());
		target.setDI4(source.getB4());
		target.setDI5(source.getB5());
		target.setDI6(source.getB6());
		target.setDI7(source.getB7());
	}

	/**
	 * Connects an eight bit "Data" output to an eight it "A" input.
	 *
	 * @param source
	 *            the eight bit source of the data to be transferred to the
	 *            target.
	 * @param target
	 *            the eight bit target to receive the data from the source
	 */
	public static void connectEightBitDataOutputToEightBitAInput(
			final IEightBitDataOutput source, final IEightBitAInput target) {
		target.setA0(source.getDO0());
		target.setA1(source.getDO1());
		target.setA2(source.getDO2());
		target.setA3(source.getDO3());
		target.setA4(source.getDO4());
		target.setA5(source.getDO5());
		target.setA6(source.getDO6());
		target.setA7(source.getDO7());
	}

	/**
	 * Connects an eight bit "Data" output to an eight it "B" input.
	 *
	 * @param source
	 *            the eight bit source of the data to be transferred to the
	 *            target.
	 * @param target
	 *            the eight bit target to receive the data from the source
	 */
	public static void connectEightBitDataOutputToEightBitBInput(
			final IEightBitDataOutput source, final IEightBitBInput target) {
		target.setB0(source.getDO0());
		target.setB1(source.getDO1());
		target.setB2(source.getDO2());
		target.setB3(source.getDO3());
		target.setB4(source.getDO4());
		target.setB5(source.getDO5());
		target.setB6(source.getDO6());
		target.setB7(source.getDO7());
	}

	/**
	 * Connects an eight bit "Data" output to an eight it "C" input.
	 *
	 * @param source
	 *            the eight bit source of the data to be transferred to the
	 *            target.
	 * @param target
	 *            the eight bit target to receive the data from the source
	 */
	public static void connectEightBitDataOutputToEightBitCInput(
			final IEightBitDataOutput source, final IEightBitCInput target) {
		target.setC0(source.getDO0());
		target.setC1(source.getDO1());
		target.setC2(source.getDO2());
		target.setC3(source.getDO3());
		target.setC4(source.getDO4());
		target.setC5(source.getDO5());
		target.setC6(source.getDO6());
		target.setC7(source.getDO7());
	}

	/**
	 * Connects an eight bit "Data" output to an eight it "D" input.
	 *
	 * @param source
	 *            the eight bit source of the data to be transferred to the
	 *            target.
	 * @param target
	 *            the eight bit target to receive the data from the source
	 */
	public static void connectEightBitDataOutputToEightBitDInput(
			final IEightBitDataOutput source, final IEightBitDInput target) {
		target.setD0(source.getDO0());
		target.setD1(source.getDO1());
		target.setD2(source.getDO2());
		target.setD3(source.getDO3());
		target.setD4(source.getDO4());
		target.setD5(source.getDO5());
		target.setD6(source.getDO6());
		target.setD7(source.getDO7());
	}

	/**
	 * Connects an eight bit "Data" output to an eight it "Data" input.
	 *
	 * @param source
	 *            the eight bit source of the data to be transferred to the
	 *            target.
	 * @param target
	 *            the eight bit target to receive the data from the source
	 */
	public static void connectEightBitDataOutputToEightBitDataInput(
			final IEightBitDataOutput source, final IEightBitDataInput target) {
		target.setDI0(source.getDO0());
		target.setDI1(source.getDO1());
		target.setDI2(source.getDO2());
		target.setDI3(source.getDO3());
		target.setDI4(source.getDO4());
		target.setDI5(source.getDO5());
		target.setDI6(source.getDO6());
		target.setDI7(source.getDO7());
	}

	/**
	 * Connects an eight bit "Sum" output to an eight it "B" input.
	 *
	 * @param source
	 *            the eight bit source of the data to be transferred to the
	 *            target.
	 * @param target
	 *            the eight bit target to receive the data from the source
	 */
	public static void connectEightBitSumToEightBitBInput(
			final IEightBitSumOutput source, final IEightBitBInput target) {
		target.setB0(source.getS0());
		target.setB1(source.getS1());
		target.setB2(source.getS2());
		target.setB3(source.getS3());
		target.setB4(source.getS4());
		target.setB5(source.getS5());
		target.setB6(source.getS6());
		target.setB7(source.getS7());
	}

	/**
	 * Connects an eight bit "Sum" output to an eight it "Data" input.
	 *
	 * @param source
	 *            the eight bit source of the data to be transferred to the
	 *            target.
	 * @param target
	 *            the eight bit target to receive the data from the source
	 */
	public static void connectEightBitSumToEightBitDataInput(
			final IEightBitSumOutput source, final IEightBitDataInput target) {
		target.setDI0(source.getS0());
		target.setDI1(source.getS1());
		target.setDI2(source.getS2());
		target.setDI3(source.getS3());
		target.setDI4(source.getS4());
		target.setDI5(source.getS5());
		target.setDI6(source.getS6());
		target.setDI7(source.getS7());
	}

	/**
	 * Connects an eight bit "C" output to an eight it "C" input.
	 *
	 * @param source
	 *            the eight bit source of the data to be transferred to the
	 *            target.
	 * @param target
	 *            the eight bit target to receive the data from the source
	 */
	public static void connectEightBitCOutputToEightBitCInput(
			final IEightBitCOutput source, final IEightBitCInput target) {
		target.setC0(source.getC0());
		target.setC1(source.getC1());
		target.setC2(source.getC2());
		target.setC3(source.getC3());
		target.setC4(source.getC4());
		target.setC5(source.getC5());
		target.setC6(source.getC6());
		target.setC7(source.getC7());
	}

}

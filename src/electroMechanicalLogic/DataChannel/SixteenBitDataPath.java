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
import electroMechanicalLogic.DataChannel.Interfaces.IEightBitDataOutput;
import electroMechanicalLogic.DataChannel.Interfaces.ISixteenBitAInput;
import electroMechanicalLogic.DataChannel.Interfaces.ISixteenBitAOutput;

/**
 * Provides methods to connect eight bit inputs with sixteen bit outputs,
 * sixteen bit inputs with eight bit outputs and sixteen bit inputs with sixteen
 * bit outputs.
 */
public class SixteenBitDataPath {

	/**
	 * Connects a sixteen bit "A" output to a sixteen bit "A" input.
	 * 
	 * @param source
	 *            the sixteen bit source of the data to be transferred to the
	 *            sixteen bit input.
	 * @param target
	 *            the sixteen bit input to receive the data from the source
	 *            output.
	 */
	public static void connectSixteenBitAOutputToSixteenBitAInput(
			final ISixteenBitAOutput source, final ISixteenBitAInput target) {
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

	/**
	 * Connects a sixteen bit "A" output to two eight bit "A" inputs.
	 * 
	 * @param source
	 *            the sixteen bit source of the data to be transferred to the
	 *            eight bit inputs.
	 * @param targetLow
	 *            the eight bit input to receive the data from the low order
	 *            eight bits of the source output.
	 * @param targetHigh
	 *            the eight bit input to receive the data from the high order
	 *            eight bits of the source output.
	 */
	public static void connectSixteenBitAOutputToTwoEightBitAInputs(
			final ISixteenBitAOutput source, final IEightBitAInput targetLow,
			final IEightBitAInput targetHigh) {
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

	/**
	 * Connects a sixteen bit "A" output to two eight bit "B" inputs.
	 * 
	 * @param source
	 *            the sixteen bit source of the data to be transferred to the
	 *            eight bit inputs.
	 * @param targetLow
	 *            the eight bit input to receive the data from the low order
	 *            eight bits of the source output.
	 * @param targetHigh
	 *            the eight bit input to receive the data from the high order
	 *            eight bits of the source output.
	 */
	public static void connectSixteenBitAOutputToTwoEightBitBInputs(
			final ISixteenBitAOutput source, final IEightBitBInput targetLow,
			final IEightBitBInput targetHigh) {
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

	/**
	 * Connects two eight bit "A" outputs to a sixteen bit "A" input.
	 * 
	 * @param sourceLow
	 *            the eight bit source of the low order eight bits to be
	 *            transferred to the sixteen bit input.
	 * @param sourceHigh
	 *            the eight bit source of the high order eight bits to be
	 *            transferred to the sixteen bit input.
	 * @param target
	 *            the sixteen bit input to receive the data from the two source
	 *            outputs.
	 */
	public static void connectTwoEightBitAOutputsToSixteenBitAInput(
			final IEightBitAOutput sourceLow,
			final IEightBitAOutput sourceHigh, final ISixteenBitAInput target) {
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

	/**
	 * Connects two eight bit "B" outputs to a sixteen bit "A" input.
	 * 
	 * @param sourceLow
	 *            the eight bit source of the low order eight bits to be
	 *            transferred to the sixteen bit input.
	 * @param sourceHigh
	 *            the eight bit source of the high order eight bits to be
	 *            transferred to the sixteen bit input.
	 * @param target
	 *            the sixteen bit input to receive the data from the two source
	 *            outputs.
	 */
	public static void connectTwoEightBitBOutputsToSixteenBitAInput(
			final IEightBitBOutput sourceLow,
			final IEightBitBOutput sourceHigh, final ISixteenBitAInput target) {
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

	/**
	 * Connects two eight bit "Data" outputs to a sixteen bit "A" input.
	 * 
	 * @param sourceLow
	 *            the eight bit source of the low order eight bits to be
	 *            transferred to the sixteen bit input.
	 * @param sourceHigh
	 *            the eight bit source of the high order eight bits to be
	 *            transferred to the sixteen bit input.
	 * @param target
	 *            the sixteen bit input to receive the data from the two source
	 *            outputs.
	 */
	public static void connectTwoEightBitDataOutputsToSixteenBitAInput(
			final IEightBitDataOutput sourceLow,
			final IEightBitDataOutput sourceHigh, final ISixteenBitAInput target) {
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

package electroMechanicalLogic;

public final class Inverter extends RelayBase implements IRelay {

	public boolean getOutput() {
		return (state & PowerMaskOut) == PowerMaskOut
				&& (state & InputMaskOut) == 0;
	}

}

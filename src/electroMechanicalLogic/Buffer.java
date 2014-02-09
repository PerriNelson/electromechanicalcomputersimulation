package electroMechanicalLogic;

public final class Buffer extends RelayBase implements IRelay {

	public boolean getOutput() {
		return (state & OutputMask) == OutputMask;
	}

}

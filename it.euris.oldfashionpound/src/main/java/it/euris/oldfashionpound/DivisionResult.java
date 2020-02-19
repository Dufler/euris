package it.euris.oldfashionpound;

/**
 * This class is meant to be the result of the division of a PoundValue by a int value.
 * @author Duff
 *
 */
public class DivisionResult {
	
	private final PoundValue result;
	private final PoundValue remainder;
	
	public DivisionResult(PoundValue result, PoundValue remainder) {
		this.result = result;
		this.remainder = remainder;
	}

	@Override
	public String toString() {
		return result.toString() + "( " + remainder.toString() + ")";
	}

	public PoundValue getResult() {
		return result;
	}

	public PoundValue getRemainder() {
		return remainder;
	}

}

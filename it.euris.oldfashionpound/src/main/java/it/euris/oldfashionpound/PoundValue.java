package it.euris.oldfashionpound;

/**
 * This class represents a value in UK Pounds in a old fashioned way. Under the
 * old money system of UK, before 1970, there were 12 pence in a shilling and 20
 * shillings, or 240 pence, in a pound. Thus, a price in th OldUK Money system
 * was expressed in Pounds, Shillings and Pence.
 * 
 * @author Duff
 *
 */
public class PoundValue {

	private static final int SHILLING_IN_POUNDS = 20;
	private static final int PENCE_IN_SHILLING = 12;
	private static final int PENCE_IN_POUND = SHILLING_IN_POUNDS * PENCE_IN_SHILLING;

	private int pound;
	private int shilling;
	private int pence;
	
	/**
	 * Returns a new instance of PoundValue from the pound, shilling and pence values passed as arguments.
	 * An IllegalArgumentException may be thrown if the pence exceed 12 or if the shilling exceed 20.
	 * @param pound
	 * @param shilling
	 * @param pence
	 */
	public PoundValue(int pound, int shilling, int pence) {
		if (pence > PENCE_IN_SHILLING)
			throw new IllegalArgumentException(
					String.format("There can be a maximum of %d pence in a Pound value", PENCE_IN_SHILLING));
		if (shilling > SHILLING_IN_POUNDS)
			throw new IllegalArgumentException(
					String.format("There can be a maximum of %d shilling in a Pound value", SHILLING_IN_POUNDS));
		this.pound = pound;
		this.shilling = shilling;
		this.pence = pence;
	}
	
	/**
	 * Sums the 2 values and return the result as a new instance.
	 */
	public static PoundValue sum(PoundValue a, PoundValue b) {
		int penceValueA = a.toPence();
		int penceValueB = b.toPence();
		return getValueFromPence(penceValueA + penceValueB);
	}

	/**
	 * Subtracts b from a, a negative result may be returned.
	 */
	public static PoundValue subtract(PoundValue a, PoundValue b) {
		// subtracts b from a starting from pence, then shillings and pounds at last.
		int pence = 0;
		int shilling = 0;
		int pound = 0;
		pence = a.getPence() - b.getPence();
		if (pence < 0) {
			pence += PENCE_IN_SHILLING;
			shilling -= 1;
		}
		shilling += a.getShilling() - b.getShilling();
		if (shilling < 0) {
			shilling += SHILLING_IN_POUNDS;
			pound -= 1;
		}
		pound += a.getPound() - b.getPound();
		return new PoundValue(pound, shilling, pence);
	}
	
	/**
	 * Multiply the PoundValue for the int and returns the result as a new Instance.
	 */
	public static PoundValue multiply(PoundValue pv, int m) {
		int penceValue = pv.toPence() * m;
		return getValueFromPence(penceValue);
	}
	
	/**
	 * Divide the PoundValue for the int and returns 2 PoundValue instances: 1 for the result and 1 for the remainder.
	 */
	public static DivisionResult divide(PoundValue pv, int d) {
		int penceValue = pv.toPence() / d;
		int penceRemainder = pv.toPence() % d;
		PoundValue result = getValueFromPence(penceValue);
		PoundValue remainder = getValueFromPence(penceRemainder);
		return new DivisionResult(result, remainder);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + pence;
		result = prime * result + pound;
		result = prime * result + shilling;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PoundValue other = (PoundValue) obj;
		if (pence != other.pence)
			return false;
		if (pound != other.pound)
			return false;
		if (shilling != other.shilling)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("%d p %d s %d d", pound, shilling, pence);
	}
	
	/**
	 * Returns the equivalent in pence of the PoundValue.
	 * @return
	 */
	public int toPence() {
		int totalPence = pence;
		totalPence += shilling * PENCE_IN_SHILLING;
		totalPence += pound * PENCE_IN_POUND;
		return totalPence;
	}
	
	/**
	 * Returns a PoundValue instance constructed from the total of pences passed as argument.
	 */
	public static PoundValue getValueFromPence(int totalPence) {
		int shilling = 0;
		int pound = 0;
		while (totalPence >= PENCE_IN_POUND) {
			pound += 1;
			totalPence -= PENCE_IN_POUND;
		}
		while (totalPence >= PENCE_IN_SHILLING) {
			shilling += 1;
			totalPence -= PENCE_IN_SHILLING;
		}
		return new PoundValue(pound, shilling, totalPence);
	}

	public int getPound() {
		return pound;
	}

	public void setPound(int pound) {
		this.pound = pound;
	}

	public int getShilling() {
		return shilling;
	}

	public void setShilling(int shilling) {
		this.shilling = shilling;
	}

	public int getPence() {
		return pence;
	}

	public void setPence(int pence) {
		this.pence = pence;
	}

}

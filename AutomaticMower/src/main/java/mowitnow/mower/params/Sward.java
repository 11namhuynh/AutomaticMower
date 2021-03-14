package mowitnow.mower.params;

/**
 * class containing the lawn data.
 * 
 * @author phuong-nam.huynh
 * 
 * @version 0.0.1
 *
 */
public class Sward {

	private Informations positionMax;

	public Sward() {

	}

	/**
	 * @param pPositionMax
	 */
	public Sward(Informations pPositionMax) {
		this.positionMax = pPositionMax;
	}

	/**
	 * @return positionMax
	 */
	public Informations getPositionMax() {
		return positionMax;
	}

	/**
	 * @param positionMax
	 */
	public void setPositionMax(Informations positionMax) {
		this.positionMax = positionMax;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((positionMax == null) ? 0 : positionMax.hashCode());
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
		Sward other = (Sward) obj;
		if (positionMax == null) {
			if (other.positionMax != null)
				return false;
		} else if (!positionMax.equals(other.positionMax))
			return false;
		return true;
	}
}
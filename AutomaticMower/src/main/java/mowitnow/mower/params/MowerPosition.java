package mowitnow.mower.params;

/**
 * class containing the mower position.
 * 
 * @author phuong-nam.huynh
 * 
 * @version 0.0.1
 *
 */
public class MowerPosition {

	private Informations informationsMower;
	private Params.Orientation orientationMower;

	/**
	 * Mower Position
	 * 
	 * @param positionInformationsMower
	 * @param positionOrientationMower
	 */
	public MowerPosition(Informations positionInformationsMower, Params.Orientation positionOrientationMower) {
		this.informationsMower = positionInformationsMower;
		this.orientationMower = positionOrientationMower;
	}

	/**
	 * @return orientationMower
	 */
	public Params.Orientation getOrientationMower() {
		return orientationMower;
	}

	/**
	 * @param positionOrientationMower
	 */
	public void setOrientationMower(Params.Orientation positionOrientationMower) {
		this.orientationMower = positionOrientationMower;
	}

	/**
	 * @return informationsMower
	 */
	public Informations getInformationsMower() {
		return informationsMower;
	}

	/**
	 * @param positionInformationsMower
	 */
	public void setInformationsMower(Informations positionInformationsMower) {
		this.informationsMower = positionInformationsMower;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((informationsMower == null) ? 0 : informationsMower.hashCode());
		result = prime * result + ((orientationMower == null) ? 0 : orientationMower.hashCode());
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
		MowerPosition other = (MowerPosition) obj;
		if (informationsMower == null) {
			if (other.informationsMower != null)
				return false;
		} else if (!informationsMower.equals(other.informationsMower))
			return false;
		if (orientationMower != other.orientationMower)
			return false;
		return true;
	}
}
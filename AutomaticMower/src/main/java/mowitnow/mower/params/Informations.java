package mowitnow.mower.params;

/**
 * class containing the information.
 * 
 * @author phuong-nam.huynh
 * 
 * @version 0.0.1
 *
 */
public class Informations {

	private int x;
	private int y;

	/**
	 * @param pX
	 * @param pY
	 */
	public Informations(int pX, int pY) {
		this.x = pX;
		this.y = pY;
	}

	/**
	 * check if the coordinates of the mower
	 * after movement are outside those of the lawn
	 * 
	 * @param objectInformations
	 * @return true if the mower coordinates are inside the lawn
	 */
	public boolean isOutCoordinatesMax(Informations objectInformations) {
		return objectInformations.getX() >= 0 && objectInformations.getY() >= 0 && objectInformations.getX() <= this.x
				&& objectInformations.getY() <= this.y;
	}

	/**
	 * @return x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return y
	 */
	public int getY() {
		return y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
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
		Informations other = (Informations) obj;
		if (x != other.x || y != other.y)
			return false;

		return true;
	}
}
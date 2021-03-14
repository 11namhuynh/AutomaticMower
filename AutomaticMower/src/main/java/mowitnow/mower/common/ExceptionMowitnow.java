package mowitnow.mower.common;

/**
 * class containing the methods used to display the exception messages.
 * 
 * @author phuong-nam.huynh
 * 
 * @version 0.0.1
 *
 */

public class ExceptionMowitnow extends Exception {
	/**
	 * the methods used to display the exception messages.
	 */
	private static final long serialVersionUID = -6889594904009935600L;

	/**
	 * @param message
	 */
	public ExceptionMowitnow(String message) {
		super(message);
	}
}

package net.vidageek.dbff.exception;

/**
 * @author jonasabreu
 * 
 */
final public class DBFFException extends RuntimeException {

	private static final long serialVersionUID = 1274861480730240627L;

	public DBFFException(final String message, final Throwable e) {
		super(message, e);
	}

}

package exceptions;

public class RouteNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2345314520149842729L;

	private final String MESSAGE = "NO SUCH ROUTE";

	public String getMESSAGE() {

		return this.MESSAGE;
	}

}

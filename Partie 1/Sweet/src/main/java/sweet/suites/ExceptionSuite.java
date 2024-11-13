package sweet.suites;

/**
 * Cette classe correspond aux exceptions pouvant être levées lors de la manipulation de suites.
 * @author Jean-François Condotta - 25/04/23
 *
 */
public class ExceptionSuite extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur permettant de construire une instance de la classe ExceptionSuite associée à un message. 
	 * @param message Le message associé.
	 */
	public ExceptionSuite(String message) {
		super(message);
	}
}

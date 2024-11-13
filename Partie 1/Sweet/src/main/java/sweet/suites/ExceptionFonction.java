package sweet.suites;

/**
 * Cette classe correspond aux exceptions pouvant être levées par la classe Fonction.
 * @author Jean-François Condotta - 25/04/23
 *
 */
public class ExceptionFonction extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur permettant de construire une instance de la classe ExceptionFonction associée à un message. 
	 * @param message Le message associé.
	 */
	public ExceptionFonction(String message) {
		super(message);
	}
}

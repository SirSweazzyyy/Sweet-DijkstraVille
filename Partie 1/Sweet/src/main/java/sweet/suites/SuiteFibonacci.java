package sweet.suites;

/**
 * Cette classe correspond à la suite de Fibonacci.
 * @author Jean-François Condotta - 25/04/23
 *
 */
final public class SuiteFibonacci extends SuiteLineaire {

	/**
	 * Constructeur permettant de créer une nouvelle suite de Fibonacci.
	 * Une suite de Fibonacci sera toujours représentée par la chaîne de caractères
	 * u[0]=0;u[1]=1;u[n+2]=1*u[n]+1*u[n+1].
	 */
	public SuiteFibonacci() {
		super("u[0]=0;u[1]=1;u[n+2]=1*u[n]+1*u[n+1]",new double[] {0.0,1.0},new double[] {1.0,1.0});
	}
}

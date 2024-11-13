package sweet.suites;

/**
 * Une instance de cette classe permet de gérer un ensemble fini et ordonné de suites.
 * Les suites sont simplement stockées dans un tableau. La suite positionnée à la position 0
 * sera stockée à l'indice 0, celle à la position 1 à l'indice 1 ...
 * 
 * @author Jean-François Condotta - 25/04/23
 *
 */
public class EnsembleSuites {
	
	/**
	 * Les suites de l'ensemble.
	 */
	private Suite suites[];
	
	/**
	 * Constructeur permettant de créer un ensemble de suites.
	 * @param nbSuites Le nombre de suites que l'ensemble pourra contenir (supposé strictement supérieur à 0).
	 */
	public EnsembleSuites(int nbSuites) {
		suites=new Suite[nbSuites];
		for (int i=0;i<suites.length;i++)
			suites[i]=null;
	}
	
	/**
	 * Methode retournant le nombre d'éléments peut contenir l'ensemble de suites.
	 * @return Le nombre d'éléments peut contenir l'ensemble de suites.
	 */
	public int getCapacite() {
		return suites.length;
	}
	/**
	 * Méthode permettant d'ajouter une suite à une certaine position.
	 * 
	 * @param position Un entier compris (au sens large) entre 0 et capacite()-1.
	 * @param suite La suite à mettre à la position donnée (peut être null).
	 */
	public void ajouter(int position,Suite suite) {
		suites[position]=suite;
	}
	
	/**
	 * Méthode permettant de supprimer une suite se trouvant à une certaine position.
	 * 
	 * @param position Un entier compris (au sens large) entre 0 et capacite()-1.
	 */
	public void supprimer(int position) {
		for (int i=0;i<suites.length;i++)
			if (suites[i]==null) {
				suites[i]=null;
			}
	}
	
	/**
	 * Méthode retournant la suite se trouvant à une certaine position.
	 * @param position Un entier compris (au sens large) entre 0 et capacite()-1.
	 * @return La suite se trouvant à la position donnée (possiblement null).
	 */
	public Suite getSuite(int position) {
		return suites[position];
	}
	
}

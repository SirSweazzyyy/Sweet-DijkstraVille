package sweet.suites;

import java.util.Arrays;

/**
 * Cette classe correspond aux suites récurrentes.
 * 
 * @author Jean-François Condotta - 25/04/23
 */

abstract public class SuiteRecurrente extends Suite{
	/**
	 * Les valeurs des premiers termes.
	 */
	private double valPremiersTermes[];

	/**
	 * Constructeur permettant de créer une nouvelle suite récurrente.
	 * Un nouveau tableau est créé en dupliquant le tableau donné en paramètre 
	 * afin de stocker les valeurs des premiers termes de la suite.
	 * @param chaineSuite La chaîne de caractères représentant la suite.
	 * @param valPremiersTermes Les valeurs des premiers termes de la suite récurrente (supposé non null et contenant au moins un élément).
	 */
	protected SuiteRecurrente(String chaineSuite,double valPremiersTermes[]) {
		super(chaineSuite);
		this.valPremiersTermes=Arrays.copyOf(valPremiersTermes,valPremiersTermes.length);
	}

	/**
	 * Méthode retournant l'ordre de la suite (le nombre des premiers termes pour lesquels les valeurs sont déjà définis).
	 * @return L'ordre de la suite récurrente (un nombre entier strictement positif).
	 */
	public int getOrdre() {
		if (valPremiersTermes!=null){
			return valPremiersTermes.length;
		}
		return 0;

	}

	/**
	 * Méthode retournant la valeur d'un des premiers termes de la suite.
	 * @param rangTerme Le rang du terme pour lequel nous souhaitons la valeur (un nombre entier entre (au sens large) 0 et getOrdre()-1).
	 * @return La valeur du terme de rang rangTerme.
	 */
	public double getValPremierTerme(int rangTerme) {
		if (valPremiersTermes!=null && rangTerme>=0 && rangTerme<valPremiersTermes.length)
			return valPremiersTermes[rangTerme];
		return 0.0;
	}
	
	@Override
	public void calculeEtAffiche(int rangMaxTermes) {
		super.calculeEtAffiche(rangMaxTermes);
		System.out.println("Ordre de la suite : "+getOrdre());
		System.out.print("Valeurs des premiers termes : ");
		for (int i=0;i<getOrdre();i++)
			System.out.print(getValPremierTerme(i)+" ");
		System.out.println();
	}
}

package sweet.suites;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Cette classe correspond aux suites linéaires.
 * @author Jean-François Condotta - 25/04/23
 *
 */

public class SuiteLineaire extends SuiteRecurrente {
	/**
	 * Les coefficients définissant la suite linéaire (la taille du tableau est égal à l'ordre de la suite).
	 */
	private double coefficients[];

	/**
	 * Constructeur permettant de créer une nouvelle suite linéaire.
	 * Des nouveaux tableaux sont créés en dupliquant les tableaux donnés en paramètres 
	 * afin de stocker les valeurs des premiers termes de la suite et les coefficients définissant la suite.
	 * @param chaineSuite La chaîne de caractères représentant la suite.
	 * @param valPremiersTermes Les valeurs des premiers termes de la suite linéaire (supposé non null et contenant au moins un élément).
	 * @param coefficients Les coefficients définissant la suite linéaire (même taille que valPremiersTermes).
	 */
	public SuiteLineaire(String chaineSuite,double valPremiersTermes[],double coefficients[]) {
		super(chaineSuite,valPremiersTermes);
		this.coefficients=Arrays.copyOf(coefficients,coefficients.length);
	}

	/**
	 * Méthode retournant la valeur d'un des coefficients définissant la suite linéaire.
	 * @param positionCoef La position du coefficient pour lequel nous souhaitons la valeur (un nombre entier entre (au sens large) 0 et getOrdre()-1).
	 * @return La valeur du coeffcient à la position positionCoef.
	 */
	public double getValCoef(int positionCoef) {
		return coefficients[positionCoef];
	}

	@Override
	public ArrayList<Double> getValeursTermes(int rangMaxTermes) {
		ArrayList<Double> valeurs = new ArrayList<Double>();
		int ordre = getOrdre();

		for (int i = 0; i < ordre; i++) {
			valeurs.add(getValPremierTerme(i));
		}

		for (int i = ordre; i <= rangMaxTermes; i++) {
			double val = 0.0;


			for (int j = 0; j < ordre; j++) {
				val += getValCoef(j) * valeurs.get(i - ordre + j);
			}


			if (Double.isNaN(val) || Double.isInfinite(val)) {
				return valeurs;
			}

			valeurs.add(val);
		}

		return valeurs;
	}



	@Override
	public void calculeEtAffiche(int rangMaxTermes) {
		super.calculeEtAffiche(rangMaxTermes);
		System.out.print("Valeurs des coefficients : ");
		for (int i=0;i<getOrdre();i++)
			System.out.print(getValCoef(i)+" ");
		System.out.println();
	}


}

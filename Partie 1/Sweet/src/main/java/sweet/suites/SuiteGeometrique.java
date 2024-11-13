package sweet.suites;

import java.util.ArrayList;

/**
 * Cette classe correspond aux suites géométriques.
 * @author Jean-François Condotta - 25/04/23
 *
 */
final public class SuiteGeometrique extends SuiteLineaire {

	/**
	 * Constructeur permettant de créer une nouvelle suite geometrique.
	 * @param chaineSuite La chaîne de caractères représentant la suite.
	 * @param valPremierTerme La valeur du premier terme de la suite.
	 * @param raison La raison de la suite géométrique.
	 */
	public SuiteGeometrique(String chaineSuite,double valPremierTerme,double raison) {
		super(chaineSuite,doubleVersTableau(valPremierTerme),doubleVersTableau(raison));
	}


	/**
	 * Méthode retournant la raison de la suite géométrique.
	 * @return La raison de la suite géométrique.
	 */
	public double getRaison() {
		return getValCoef(0);
	}

	/**
	 * Méthode retournant la valeur du premier terme de la suite géométrique.
	 * @return La valeur du premier terme de la suite géométrique.
	 */
	public double getValeurPremierTerme() {
		return getValPremierTerme(0);
	}
	
	/**
	 * Redéfinition de la méthode getValeurTerme sans utiliser la méthode getValeursTermes.
	 */
	@Override
	public Double getValeurTerme(int rangTerme) {
		return getValeurPremierTerme()*Math.pow(getRaison(),rangTerme);
	}
	
	
	@Override
	public void calculeEtAffiche(int rangMaxTermes) {
		super.calculeEtAffiche(rangMaxTermes);
		System.out.println("Valeur de la raison : "+getRaison());
	}
}

package sweet.suites;

import java.util.ArrayList;
/**
 * Cette classe correspond aux suites logistiques.
 * @author Jean-François Condotta - 25/04/23
 *
 */
public class SuiteLogistique extends SuiteRecurrente {

	/**
	 * La valeur de la constante A utilisée dans la définition de la suite logistique u[n+1]=A*u[n]*(1-u[n]).
	 */
	private double valA;

	/**
	 * Constructeur permettant de créer une nouvelle suite logistique.
	 * @param chaineSuite La chaîne de caractères représentant la suite.
	 * @param valPremierTerme La valeur du premier terme de la suite logistique qui doit être comprise entre 0 et 1.
	 * @param valA La constante qui doit être comprise entre 0 et 4 utilisée dans la suite logistique.
	 * @throws ExceptionSuite Une exception de cette classe est levée dans le cas où la valeur de valPremierTerme ou valA ne sont pas valides.
	 */
	public SuiteLogistique(String chaineSuite,double valPremierTerme,double valA) throws ExceptionSuite {
		super(chaineSuite,SuiteGeometrique.doubleVersTableau(valPremierTerme));
		this.valA=valA;
		if ((valA<0)||(valA>4))
			throw new ExceptionSuite("La valeur "+valA+" n'est pas comprise entre 0 et 4 !");
		if ((valPremierTerme<0)||(valPremierTerme>1))
			throw new ExceptionSuite("La valeur "+valPremierTerme+" n'est pas comprise entre 0 et 1 !");
	}

	/**
	 * Méthode retournant la valeur de la constante A de la suite logistique.
	 * @return La valeur de la constante A de la suite logistique
	 */
	public double getValA() {
		return this.valA; //rajouté //Modifié par Bylel à 13:30
	}

	/**
	 * Méthode retournant la valeur du premier terme de la suite logistique.
	 * @return La valeur du premier terme de la suite logisitique.
	 */
	public double getValeurPremierTerme() {
		return getValPremierTerme(0); //rajouté
	}

	@Override
	public ArrayList<Double> getValeursTermes(int rangMaxTermes) {
		ArrayList<Double> valeurs=new ArrayList<Double>();
		double val=getValPremierTerme(0);
		valeurs.add(val);
		try {
			for (int i=1;i<=rangMaxTermes;i++) {
				val = getValA()*val*(1-val); //rajouté
				if (Double.isNaN(val)||Double.isInfinite(val))
					return valeurs;
				valeurs.add(val);
			}
		}catch(Exception e) {}
		return valeurs;
	}
	
	@Override
	public void calculeEtAffiche(int rangMaxTermes) {
		super.calculeEtAffiche(rangMaxTermes);
		System.out.println("Valeur du coefficient A : "+getValA()); // raj
	}
}

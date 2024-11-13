package sweet.suites;

import java.util.ArrayList;

/**
 * Cette classe correspond aux suites explicites, c'est-à-dire les suites définies explicitement par une fonction.
 * Par exemple, la suite u[n]=n+(3*n*n) est définie à partir de la fonction f(n)=n+(3*n*n).
 * 
 * @author Jean-François Condotta - 25/04/23
 */

public class SuiteExplicite extends Suite {

	/**
	 * La fonction correspondant à la suite (une fonction ayant n comme variable).
	 */
	private Fonction fonction;

	/**
	 * Constructeur permettant de construire la suite à partir d'une fonction.
	 * @param chaineSuite La chaîne de caractères représentnant la suite.
	 * @param fonction La fonction correspondant à la suite (une fonction en n).
	 */
	public SuiteExplicite(String chaineSuite,Fonction fonction) {
		super(chaineSuite);
		this.fonction=fonction;
	}

	@Override
	public ArrayList<Double> getValeursTermes(int rangMaxTermes){
		ArrayList<Double> valeurs=new ArrayList<Double>();
		try {
			for (int i=0;i<=rangMaxTermes;i++) {
				double val=fonction.valeurFonction(i);
				if (Double.isNaN(val)||Double.isInfinite(val))
					return valeurs;
				valeurs.add(val);
			}
		}catch(Exception e) {}
		return valeurs;
	}

	@Override
	public Double getValeurTerme(int rangTerme) {
		try {
			ArrayList<Double> listValues = this.getValeursTermes(rangTerme);
			return listValues.get(rangTerme);
		} catch(ArrayIndexOutOfBoundsException e) {
			return 0.0;
		}
	}

}
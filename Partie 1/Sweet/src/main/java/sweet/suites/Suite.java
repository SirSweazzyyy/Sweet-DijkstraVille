package sweet.suites;

import java.util.ArrayList;
/**
 * Cette classe abstraite est la classe racine de toutes les classes permettant de représenter une suite.
 * Chaque suite est associée à une chaîne de caractères la représentant ({@link #chaineSuite}).
 * La classe {@link #Suite} contient la méthode abstraite {@link #getValeursTermes(int)} qui devra être implantée par les sous-classes concrètes
 * afin de permettre le calcul des valeurs des termes de la suite.
 * 
 * @author Jean-François Condotta - 25/04/23
 */
abstract public class Suite {
	/**
	 * La chaine de caractères représentant la suite.
	 */
	private String chaineSuite;

	/**
	 * Constructeur permettant d'initialiser la suite avec la chaîne de caractères la représentant.
	 * @param chaineSuite La chaîne de caractères représentant la suite.
	 */
	protected Suite(String chaineSuite) {
		this.chaineSuite=chaineSuite;
	}

	/**
	 * Méthode calculant la valeur de chaque terme compris entre le rang 0 et le rang rangMaxTermes (entier donné en paramètre).
	 * Si jamais la valeur d'un terme de rang i ne peut pas être calculée (son calcul conduit par exemple à la valeur infini), le calcul de la valeur de ce terme et de ceux des valeurs des termes suivants ne sont pas
	 * effectués. Dans ce cas, seules les valeurs des termes jusqu'au rang i-1 seront retournées.
	 * 
	 * @param rangMaxTermes Le rang maximal des termes pour lesquels les valeurs sont calculées.  
	 * @return Un ArrayList contenant à l'indice i la valeur (un Double non null représentant une valeur forcément finie) du terme de rang i. Cet ArrayList peut être vide.
	 */
	abstract public ArrayList<Double> getValeursTermes(int rangMaxTermes);

	/**
	 * Méthode retournant la valeur du terme de la suite de rang rangTerme.
	 * Par défaut, cette méthode utilise la méthode {@link  #getValeursTermes} pour calculer la valeur
	 * demandée. Dans le cas où la valeur ne peut pas être calculée, null est retournée.
	 * Lorsque cela sera jugé utile, cette implantation pourra être redéfinie dans les différentes sous-classes.
	 * @param rangTerme Le rang du terme pour lequel nous souhaiton la valeur.
	 * @return La valeur du terme de rang rangTerme de la suite (null si il ne peut pas être calculé).
	 */
	public Double getValeurTerme(int rangTerme) {
		ArrayList<Double> valeursTermes=getValeursTermes(rangTerme);
		if (valeursTermes.size()==rangTerme+1)
			return valeursTermes.get(rangTerme);
		return null;
	}
	
	/**
	 * Retourne la chaîne de caractères représentant la suite.
	 */
	public String toString() {
		return chaineSuite;
	}

	/**
	 * Méthode retournant la valeur maximale appartenant à un tableau.
	 * @param valeurs Un tableau non null de valeurs non null (pouvant être vide).
	 * @return La valeur maximale appartenant au tableau (-Double.MAX_VALUE dans le cas où le tableau est vide).
	 */
	public static double getValeurMax(ArrayList<Double> valeurs) {
		double valMax=-Double.MAX_VALUE;
		for (Double val:valeurs)
			if (val>valMax)
				valMax=val;
		return valMax;
	}

	/**
	 * Méthode retournant la valeur minimale appartenant à un tableau.
	 * @param valeurs Un tableau non null de valeurs (pouvant être vide).
	 * @return La valeur minimale appartenant au tableau (Double.MAX_VALUE dans le cas où le tableau est vide).
	 */
	public static double getValeurMin(ArrayList<Double> valeurs) {
		double valMin=Double.MAX_VALUE;
		for (Double val:valeurs)
			if (val<valMin)
				valMin=val;
		return valMin;
	}
	
	
	/**
	 * Méthode retournant un nouveau tableau contenant un seul élément correspondant à la valeur (de type double) passée en paramètre.
	 * @param valeur La valeur qui sera seul élément du tableau retourné.
	 * @return Un nouveau tableau de taille 1 contenant valeur comme seul élément.
	 */
	static public double[] doubleVersTableau(double valeur) {
			double tab[]=new double[1];
			tab[0]=valeur;
			return tab;
		}

	/**
	 * Méthode permettant de calculer et d'afficher les valeurs des premiers termes de la suite.
	 * Cette méthode affiche également la valeur minimale et la valeur maximale des valeurs des termes calculées.
	 * Elle affiche également la valeur du premier terme et dernier terme parmi les termes affichés.
	 * @param rangMaxTermes Le rang maximal des termes pour lequel le calcul et l'affichage sont effectués.
	 */
	public void calculeEtAffiche(int rangMaxTermes) {
		System.out.println("===============================================================");
		System.out.println("Suite : "+this+"(classe "+this.getClass().getName()+")");
		System.out.println("Valeurs des "+(rangMaxTermes+1)+" termes :");
		ArrayList<Double> valeursTermes=getValeursTermes(rangMaxTermes);
		for (int i=0; i<valeursTermes.size();i++)
			System.out.print(i+":"+valeursTermes.get(i)+" ");
		System.out.println("");
		System.out.println("Valeur Minimale / Valeur Maximale : "+getValeurMin(valeursTermes)+" / "+getValeurMax(valeursTermes));
		if (valeursTermes.size()>=0) {
			Double valPremier=getValeurTerme(0);
			Double valDernier=getValeurTerme(valeursTermes.size()-1);
			System.out.println("Valeur Premier / Valeur Dernier : "+valPremier+" / "+valDernier);
			
		}
	}
}

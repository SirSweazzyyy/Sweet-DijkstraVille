package sweet.suites;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

/**
 * 
 * Classe permettant de définir des fonctions sur le domaine des entiers positifs vers l'ensemble des nombres à virgule flottante (les double).
 * Une fonction sera définie par une expression (une chaîne de caractères) avec n comme seule argument, par exemple "2*n*n".
 * Cette classe utilise la librairie exp4j.
 * La documentation de exp4j peut être consultée pour connaitre les expressions possibles https://www.objecthunter.net/exp4j/. 
 * <br>
 * Un constructeur permet de constuire une Fonction à partir d'une chaîne de caractères la représentant.
 * <br>
 * La méthode {@link #valeurFonction(int)} permet d'obtenir la valeur de la fonction pour un entier donné en paramètre.
 * 
 * @author Jean-François Condotta - 25/04/23
 *
 */
public class Fonction {

	/**
	 * L'expression représentant la fonction, cette expression à juste n comme variable entière.
	 */
	private Expression expression;

	/**
	 * Constructeur permettant de construire une fonction avec n comme paramètre.
	 * @param expressionFonction L'expression représentant la fonction, par exemple "2*n*n".
	 * @throws ExceptionFonction Une exception de la classe ExceptionFonction est levée dans le cas où la fonction ne peut pas être créée.
	 */
	public Fonction(String expressionFonction) throws ExceptionFonction {
		try {
			this.expression=new ExpressionBuilder(expressionFonction).variables("n").build();
		}catch(Exception e) {
			throw new ExceptionFonction("Impossible de créer la fonction \""+expressionFonction+"\" !");
		}
	}

	/**
	 * Méthode retournant l'évaluation de la fonction pour une valeur de n donné.
	 * @param n La valeur de n pour laquelle nous souhaitons l'évaluation de la fonction.
	 * @return La valeur de la fonction pour la valeur de n donnée.
	 * @throws ExceptionFonction Dans le cas où un problème survient lors du calcul de la fonction, une exception de la classe ExceptionFonction est levée.
	 */
	public double valeurFonction(int n) throws ExceptionFonction {
		try {
		expression.setVariable("n", n);
		return expression.evaluate();
		}catch (Exception e) {
			throw new ExceptionFonction(e.getMessage());
		}
	}


}

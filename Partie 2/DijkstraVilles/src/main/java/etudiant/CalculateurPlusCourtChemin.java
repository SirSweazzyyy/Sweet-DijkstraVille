package etudiant;

import java.util.ArrayList;

import jfc.ICalculateurPlusCourtChemin;
import jfc.Ville;
/**
 * Les instances de cette classe permettent de calculer un plus court chemin entre deux villes en utilisant l'algorithme de Dijkstra.
 * @author Jean-François Condotta, 04 juin 2023.
 *
 */
public class CalculateurPlusCourtChemin implements ICalculateurPlusCourtChemin{

	@Override
	public ArrayList<Ville> plusCourtChemin(ArrayList<Ville> toutesLesVilles, Ville villeDepart, Ville villeArrivee) {

		// On creer des ArrayList pour stocker le chemin le plus court, l'ensemble des sommets ainsi que les sommets visités
		ArrayList<Ville> chemin = new ArrayList<Ville>();
		ArrayList<Sommet> sommets = new ArrayList<Sommet>();
		ArrayList<Sommet> sommetsNonVisites = new ArrayList<Sommet>();

		// On initialise l'ArrayList de sommets avec chaque ville
		for (Ville ville : toutesLesVilles) {
			Sommet sommet = new Sommet(ville);
			sommets.add(sommet);
			sommetsNonVisites.add(sommet);
		}

		// On initialise le sommet de départ
		Sommet sommetDepart = Sommet.getSommet(sommets, villeDepart);
		sommetDepart.setCout(0);

		// Algorithm de Dijkstra
		while (!sommetsNonVisites.isEmpty()) {
			// On selectionne le prochain sommet en fonction du coût minimal
			Sommet sommetCourant = Sommet.getSommetCoutMin(sommetsNonVisites);
			sommetsNonVisites.remove(sommetCourant);

			// On test si le sommet courant est le sommet d'arrivé
			if (sommetCourant.getVille().equals(villeArrivee)) {
				break;
			}

			// On met ensuite à jour le coût des sommets voisins et on met à jour le predecesseur si le coût est plus petit
			for (Sommet sommetVoisin : Sommet.getSommetsVoisins(sommets, sommetCourant)) {
				if (sommetsNonVisites.contains(sommetVoisin)) {
					int cout = sommetCourant.getCout() + sommetCourant.getVille().getDistanceMetres(sommetVoisin.getVille());
					if (cout < sommetVoisin.getCout()) {
						sommetVoisin.setCout(cout);
						sommetVoisin.setPredecesseur(sommetCourant);
					}
				}
			}
		}

		// Reconstruction du chemin en partant de l'arrivée
		Sommet sommetCourant = Sommet.getSommet(sommets, villeArrivee);
		while (sommetCourant != null) {
			chemin.add(0, sommetCourant.getVille());
			sommetCourant = sommetCourant.getPredecesseur();
		}

		return chemin;
	}

}

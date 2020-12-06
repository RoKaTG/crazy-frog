package gameCommons;

import util.Case;

public interface IEnvironment {

	/**
	 * Teste si une case est sure, c'est � dire que la grenouille peut s'y poser
	 * sans mourir
	 * 
	 * @param c
	 *            la case � tester
	 * @return vrai s'il n'y a pas danger
	 */
	public boolean isSafe(Case c);

	/**
	 * Teste si la case est une case d'arrivee
	 * 
	 * @param c
	 * @return vrai si la case est une case de victoire
	 */
	public boolean isWinningPosition(Case c);

	/**
	 * Ajoute une ligne pour le mode "Infinie"
	 */
	public void addLane();

	/**
	 * Change l'ordonnée des voitures et lignes
	 *
	 * @param i
	 */
	public void changeOrd(int i);

	/**
	 * Effectue une étape d'actualisation de l'environnement
	 */
	public void update();

}

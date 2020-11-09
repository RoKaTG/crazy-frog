package gameCommons;

import util.Case;

public interface IEnvironment {

	/**
	 * Teste si une case est sure, c'est à dire que la grenouille peut s'y poser
	 * sans mourir
	 * 
	 * @param c
	 *            la case à tester
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
	 * Effectue une étape d'actualisation de l'environnement
	 */
	public void update();

}

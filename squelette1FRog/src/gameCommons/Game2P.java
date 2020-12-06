package gameCommons;

import graphicalElements.Element;
import graphicalElements.IFroggerGraphics;
import util.Direction;

import java.awt.*;
import java.util.Random;

public class Game2P {

	public final Random randomGen = new Random();

	// Afin d'éviter la victoire après la défaite et inversement
	private boolean detectedEnd;

	// Caracteristique de la partie
	public final int width;
	public final int height;
	public final int minSpeedInTimerLoops;
	public final double defaultDensity;

	// Lien aux objets utilis�s
	private IEnvironment environment;
	private IFrog frog;
	private IFrog frog2;
	private IFroggerGraphics graphic;

	/**
	 *
	 * @param graphic
	 *            l'interface graphique
	 * @param width
	 *            largeur en cases
	 * @param height
	 *            hauteur en cases
	 * @param minSpeedInTimerLoop
	 *            Vitesse minimale, en nombre de tour de timer avant d�placement
	 * @param defaultDensity
	 *            densite de voiture utilisee par defaut pour les routes
	 */
	public Game2P(IFroggerGraphics graphic, int width, int height, int minSpeedInTimerLoop, double defaultDensity) {
		super();
		this.graphic = graphic;
		this.width = width;
		this.height = height;
		this.minSpeedInTimerLoops = minSpeedInTimerLoop;
		this.defaultDensity = defaultDensity;
	}

	/**
	 * Lie l'objet frog � la partie
	 *
	 * @param frog
	 */
	public void setFrog(IFrog frog) {
		this.frog = frog;
	}

	/**
	 * Lie l'objet environment a la partie
	 *
	 * @param environment
	 */
	public void setEnvironment(IEnvironment environment) {
		this.environment = environment;
	}

	/**
	 *
	 * @return l'interface graphique
	 */
	public IFroggerGraphics getGraphic() {
		return graphic;
	}

	/**
	 * Teste si la partie est perdue et lance un �cran de fin appropri� si tel
	 * est le cas
	 *
	 * @return true si le partie est perdue
	 */
	public boolean testLose() {
		if(!environment.isSafe(frog.getPosition())) {
			for(int i=0; i<frog.getPosition().ord; i++) {
				frog2.move(Direction.down);
			}
		}
		if(!environment.isSafe(frog2.getPosition())) {
			for(int i=0; i<frog2.getPosition().ord; i++) {
				frog2.move(Direction.down);
			}
		}
		return false;
	}

	/**
	 * Teste si la partie est gagnee et lance un �cran de fin appropri� si tel
	 * est le cas
	 *
	 * @return true si la partie est gagn�e
	 */
	public boolean testWin() {
		if(environment.isWinningPosition(frog.getPosition())) {
			graphic.endGameScreen("Green Won");
			return true;
		}
		if(environment.isWinningPosition(frog2.getPosition())) {
			graphic.endGameScreen("Red Won");
			return true;
		}
		return false;
	}

	/**
	 * Actualise l'environnement, affiche la grenouille et verifie la fin de
	 * partie.
	 */
	public void update() {
		graphic.clear();
		environment.update();
		this.graphic.add(new Element(frog.getPosition(), Color.GREEN));
		this.graphic.add(new Element(frog2.getPosition(), Color.RED));
		if(!detectedEnd){
			if(testLose()) {
				detectedEnd = true;
			}
			if (testWin()) {
				detectedEnd = true;
			}
		}
	}
}
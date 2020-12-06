package environment;

import gameCommons.Game;
import util.Case;

import java.util.ArrayList;

public class Lane {
	private Game game;
	private int ord;
	private int speed;
	private ArrayList<Car> cars = new ArrayList<>();
	private boolean leftToRight;
	private double density;
	private int time;

	public Lane(Game game, int ord, double density){
		this.game = game;
		this.ord = ord;
		this.speed = game.randomGen.nextInt(game.minSpeedInTimerLoops) + 3;
		this.leftToRight = game.randomGen.nextBoolean();
		this.density = density;
	}

	public void update() {
		this.time++;
		if(this.time < this.speed) {
			moveCar(false);
			mayAddCar();
		} else{
			moveCar(true);
			removeCar();
			this.time=0;
		}

		// Toutes les voitures se déplacent d'une case au bout d'un nombre "tic
		// d'horloge" égal à leur vitesse
		// Notez que cette méthode est appelée à chaque tic d'horloge

		// Les voitures doivent etre ajoutes a l interface graphique meme quand
		// elle ne bougent pas

		// A chaque tic d'horloge, une voiture peut être ajoutée

	}

	private void removeCar(){
		ArrayList<Car> trash = new ArrayList();
		for(Car car:cars) {
			if (!car.isInGame()) {
				trash.add(car);
			}
		}
		cars.removeAll(trash);
		trash.clear();
	}

	private void moveCar(boolean b){
		for(Car car:cars){
			car.move(b);
		}
	}

	public boolean isSafe(Case c){
		for(Car car:cars){
			if(car.isCarSCase(c)){
				return false;
			}
		}
		return true;
	}

	public void changeOrd(int i){
		for(Car car:cars){
			car.changeOrd(i);
		}
		this.ord +=i;
	}

	/*
	 * Fourni : mayAddCar(), getFirstCase() et getBeforeFirstCase() 
	 */

	/**
	 * Ajoute une voiture au début de la voie avec probabilité égale à la
	 * densité, si la premiére case de la voie est vide
	 */
	private void mayAddCar() {
		if (isSafe(getFirstCase()) && isSafe(getBeforeFirstCase())) {
			if (game.randomGen.nextDouble() < density) {
				cars.add(new Car(game, getBeforeFirstCase(), leftToRight));
			}
		}
	}

	private Case getFirstCase() {
		if (leftToRight) {
			return new Case(0, ord);
		} else
			return new Case(game.width - 1, ord);
	}

	private Case getBeforeFirstCase() {
		if (leftToRight) {
			return new Case(-1, ord);
		} else
			return new Case(game.width, ord);
	}

}

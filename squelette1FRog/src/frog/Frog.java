package frog;

import gameCommons.Game;
import gameCommons.IFrog;
import util.Case;
import util.Direction;

public class Frog implements IFrog {
	
	private Game game;
	private Direction direction;
	private Case position;

	public Frog(Game game){
		this.game = game;
		this.direction = Direction.up;
		this.position = new Case(0, game.width/2);
	}

	@Override
	public Case getPosition() {
		return this.position;
	}

	@Override
	public Direction getDirection() {
		return this.direction;
	}

	@Override
	public void move(Direction key) {

	}
}

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
		this.position = new Case(game.width/2, 0);
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
		if(key == Direction.up) { this.position.ord = Math.min(position.ord+1, game.height-1); }
		if(key == Direction.down) { this.position.ord = Math.max(position.ord-1, 0); }
		if(key == Direction.right) { this.position.absc = Math.min(position.absc+1, game.width-1); }
		if(key == Direction.left) { this.position.absc = Math.max(position.absc-1, 0); }
	}
}

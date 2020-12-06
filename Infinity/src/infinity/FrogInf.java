package infinity;

import gameCommons.Game;
import gameCommons.IFrog;
import util.Case;
import util.Direction;

public class FrogInf implements IFrog {

	private Game game;
	private Direction direction;
	private Case position;

	public FrogInf(Game game){
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
		if(key == Direction.up) {
			this.game.score++;
			if(this.position.ord == 8){
				this.game.changeOrd(-1);
				this.game.addLane();
			} else{
				this.position.ord++;
			}
			if(this.game.score > this.game.record){
				this.game.record = this.game.score;
			}
		}
		if(key == Direction.down) {
			this.game.score--;
			if(this.position.ord == 2){
				this.game.changeOrd(1);
			} else if(this.position.ord > 0){
				this.position.ord--;
			}
		}
		if(key == Direction.right) { this.position.absc = Math.min(position.absc+1, game.width-1); }
		if(key == Direction.left) { this.position.absc = Math.max(position.absc-1, 0); }
	}

}

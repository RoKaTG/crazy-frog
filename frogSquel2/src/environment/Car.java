package environment;

import gameCommons.Game;
import graphicalElements.Element;
import util.Case;
import java.awt.*;

public class Car {
	private Game game;
	private Case leftPosition;
	private boolean leftToRight;
	private int length;
	private final Color colorLtR = Color.BLACK;
	private final Color colorRtL = Color.BLUE;

	public Car(Game game, Case leftPosition, boolean leftToRight){
		this.game = game;
		this.leftPosition = leftPosition;
		this.leftToRight = leftToRight;
		this.length = game.randomGen.nextInt(3)+1;
	}

	public void move(boolean b){
		if(b) {
			if (leftToRight) {
				this.leftPosition.absc++;
			} else {
				this.leftPosition.absc--;
			}
		}
		addToGraphics();
	}

	public boolean isCarSCase(Case c){
		for(int i=0; i<this.length; i++){
			if(c.ord==this.leftPosition.ord && c.absc==this.leftPosition.absc+i) {
				return true;
			}
		}
		return false;
	}

	public boolean isInGame(){
		if(leftToRight){
			return this.leftPosition.absc < this.game.width;
		} else {
			return this.leftPosition.absc+this.length > 1;
		}
	}

	public void changeOrd(int i){
		this.leftPosition.ord += i;
	}

	/* Fourni : addToGraphics() permettant d'ajouter un element graphique correspondant a la voiture*/
	private void addToGraphics() {
		for (int i = 0; i < length; i++) {
			Color color = colorRtL;
			if (this.leftToRight){
				color = colorLtR;
			}
			game.getGraphic()
					.add(new Element(leftPosition.absc + i, leftPosition.ord, color));
		}
	}

}

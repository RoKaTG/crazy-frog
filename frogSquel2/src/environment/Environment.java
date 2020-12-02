package environment;

import gameCommons.Game;
import gameCommons.IEnvironment;
import util.Case;

import java.util.ArrayList;

public class Environment implements IEnvironment {
    private Game game;
    private ArrayList<Lane> lanes = new ArrayList<>();

    public Environment(Game game){
        this.game = game;

        for(int i=1; i<game.height-1; i++){
            this.lanes.add(new Lane(game, i, game.defaultDensity));
        }
    }

    public boolean isSafe(Case c) {
        for(Lane lane:lanes){
            if(!lane.isSafe(c)){
                return false;
            }
        }
        return true;
    }

    public boolean isWinningPosition(Case c) {
        return c.ord == this.game.height-1;
    }

    public void update() {
        for(Lane lane:lanes){
            lane.update();
        }
    }
}

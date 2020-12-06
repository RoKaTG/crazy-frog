package infinity;

import environment.Lane;
import gameCommons.Game;
import gameCommons.IEnvironment;
import util.Case;

import java.util.ArrayList;

public class EnvInf implements IEnvironment{
    private Game game;
    private ArrayList<Lane> lanes = new ArrayList<>();

    public EnvInf(Game game){
        this.game = game;
        for(int i=1; i<game.height; i++){
            this.lanes.add(new Lane(game, i, game.defaultDensity));
        }
        for(int i=0; i<100; i++) {
            update();
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
        return false;
    }

    public void addLane(){
        this.lanes.add(new Lane(game, game.height, game.defaultDensity));
        for(int i=0; i<100; i++) {
            lanes.get(lanes.size()-1).update();
        }
    }

    public void changeOrd(int i){
        for(Lane lane:lanes){
            lane.changeOrd(i);
        }
    }

    public void update() {
        for(Lane lane:lanes){
            lane.update();
        }
    }
}
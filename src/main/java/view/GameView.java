package view;

import controller.GameController;

/**
 * Created by Guilherme on 11/03/2016.
 */
public class GameView {

    private GameController gameController;

    public GameView(GameController gameController){
        this.gameController = gameController;
    }

    public GameController getGameController() {
        return gameController;
    }
}

package controller;

import model.Game;

public class GameController {

    private Game game;

    public GameController(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }
}

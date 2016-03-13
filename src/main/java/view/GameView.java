package view;

import controller.GameController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Game;
import model.Player;
import util.AlertBox;
import util.HangmanUtils;

import java.util.Scanner;

/**
 * Created by Guilherme on 11/03/2016.
 */
public class GameView{

    private GameController gameController;

    public GameView(GameController gameController){
        this.gameController = gameController;
    }

    public GameController getGameController() {
        return gameController;
    }

    public void guessTurn(){
        if(gameController.playerIsDead()){
            new AlertBox().display("You lost!", "Face it, you just sucks.");
            gameController.stopRunning();
        }
        if(gameController.playerIsWinner()){
            new AlertBox().display("You won!", "Grats you won... absolutely nothing!");
            gameController.stopRunning();
        }
    }
}

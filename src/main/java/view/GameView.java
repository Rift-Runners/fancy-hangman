package view;

import controller.GameController;
import model.Game;
import model.Player;
import util.HangmanUtils;

import java.util.Scanner;

/**
 * Created by Guilherme on 11/03/2016.
 */
public class GameView {

    private GameController gameController;
    private HangmanUtils hangmanUtils;

    public GameView(GameController gameController){
        this.gameController = gameController;
        this.hangmanUtils = new HangmanUtils();
    }

    public GameController getGameController() {
        return gameController;
    }

    public void playGame(){
        while(gameController.isRunning()){
            System.out.println("Palavra: "+gameController.getExploreWord()+"\n" +
                    "Tentativas: "+gameController.getGame().getPlayer().getAttempts()+"/6\n" +
                    "Letras utilizadas: "+gameController.getUsedLetters()+"\n"+
                    "Dica: É uma fruta.");

            char letterInput = Character.toUpperCase(hangmanUtils.charReader("Digite uma letra: "));

            if(hangmanUtils.isAValidLetter(letterInput)){
                gameController.guessLetter(letterInput);
            } else{
                System.out.println("Você digitou um caracter inválido!");
            }

            if(gameController.playerIsDead()){
                System.out.println("Você morreu!");
                gameController.stopRunning();
            }
            if(gameController.playerIsWinner()){
                System.out.println("Você ganhou!");
                gameController.stopRunning();
            }
        }
    }
}

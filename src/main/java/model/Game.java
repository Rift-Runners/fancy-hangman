package model;

public class Game {

    private String secretWord;
    private Player player;


    public Game(String secretWord, Player player){
        this.secretWord = secretWord;
        this.player = player;
    }

    public String getSecretWord() {
        return secretWord;
    }

    public Player getPlayer() {
        return player;
    }

}

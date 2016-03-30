package model;

public class Game {

    private SecretWord secretWord;
    private Player player;


    public Game(SecretWord secretWord, Player player){
        this.secretWord = secretWord;
        this.player = player;
    }

    public SecretWord getSecretWord() {
        return secretWord;
    }

    public Player getPlayer() {
        return player;
    }

}

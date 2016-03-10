package model;

public class Game {

    private String secretWord;
    private Player player;
    private boolean running;


    public Game(String secretWord, Player player){
        this.secretWord = secretWord;
        this.player = player;
        this.running = true;
    }

    public String getSecretWord() {
        return secretWord;
    }

    public Player getPlayer() {
        return player;
    }

    public boolean isRunning() {
        return running;
    }
}

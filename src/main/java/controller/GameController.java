package controller;

import model.Game;

public class GameController {

    private Game game;
    private boolean running;
    private String usedLetters;
    private String exploreWord;

    public GameController(Game game) {
        this.game = game;
        this.exploreWord = buildExploreWord();
        this.usedLetters = "";
        this.running = true;
    }

    private String buildExploreWord() {
        StringBuilder buildRevealedWord = new StringBuilder();
        for (int i = 0; i < game.getSecretWord().length(); i++) {
            buildRevealedWord.append("_");
        }
        return buildRevealedWord.toString();
    }

    //refatorar
    public void guessLetter(char letter){
        boolean hasFound = false;
        for (int i = 0; i < game.getSecretWord().length(); i++) {
            char testLetter = game.getSecretWord().charAt(i); //Apple
            if(testLetter == letter){
                String temporaryExploreWord = exploreWord;
                if(game.getSecretWord().length()-1 == i) {
                    exploreWord = temporaryExploreWord.substring(0,i)+testLetter;
                }else {
                    exploreWord = temporaryExploreWord.substring(0,i)+testLetter+temporaryExploreWord.substring(i+1);
                }
                hasFound = true;
            }
        }
        if(!hasFound){
            usedLetters += letter+" ";
            game.getPlayer().hasAttempted();
        }
    }

    //A situação de attempts ser maior "possivelmente" nunca acontecerá, == 6 ou >= 6 (tem diferença?)
    public boolean isDead(){
        return (game.getPlayer().getAttempts() >= 6);
    }

    public Game getGame() {
        return game;
    }

    public String getExploreWord() {
        return exploreWord;
    }

    public String getUsedLetters() {
        return usedLetters;
    }

    public boolean isRunning() {
        return running;
    }
}

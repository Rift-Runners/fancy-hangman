package util;

import model.SecretWord;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class HangmanUtils {

    private Map<Integer, SecretWord> wordsDictionary;

    public HangmanUtils(){
        this.wordsDictionary = wordsReader();
    }

    public boolean isAValidLetter(char input){
        return Character.isLetter(input);
    }

    public SecretWord randomWord(){
        return wordsDictionary.get(new Random().nextInt(wordsDictionary.size()));
    }

    public HashMap<Integer, SecretWord> wordsReader(){

    }
}

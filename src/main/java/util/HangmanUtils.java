package util;

import java.util.Random;

public class HangmanUtils {

    public HangmanUtils(){}

    public boolean isAValidLetter(char input){
        return Character.isLetter(input);
    }

    public String randomWord(){
        String[] wordDictionary = new String[]
                {"APPLE", "BANANA","PINEAPPLE",
                        "MELON","LEMON","WATERMELON","ORANGE"};
        Random randomizer = new Random();
        return wordDictionary[randomizer.nextInt(wordDictionary.length)];
    }
}

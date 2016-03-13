package util;

import java.util.Random;

public class HangmanUtils {

    public HangmanUtils(){}

    public String randomWord(){
        String[] wordDictionary = new String[]
                {"APPLE", "BANANA","PINEAPPLE",
                        "MELON","LEMON","WATERMELON","ORANGE"};
        return wordDictionary[new Random().nextInt(wordDictionary.length)];
    }
}

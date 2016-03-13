package util;

import java.util.Random;
import java.util.Scanner;

public class HangmanUtils {

    public HangmanUtils(){}

    public boolean isAValidLetter(char input){
        return Character.isLetter(input);
    }

    public String randomWord(){
        String[] wordDictionary = new String[]
                {"APPLE", "BANANA","PINEAPPLE",
                        "MELON","LEMON","WATERMELON","ORANGE"};
        return wordDictionary[new Random().nextInt(wordDictionary.length)];
    }

    public String stringReader(Object o){
        System.out.println(o);
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }
}

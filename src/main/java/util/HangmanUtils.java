package util;

import model.SecretWord;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Stream;

public class HangmanUtils {

    private Map<Integer, SecretWord> wordsDictionary;

    public HangmanUtils() throws IOException{
        this.wordsDictionary = wordsReader();
    }

    public boolean isAValidLetter(char input){
        return Character.isLetter(input);
    }

    public SecretWord randomWord(){
        return wordsDictionary.get(new Random().nextInt(wordsDictionary.size()));
    }

    public Map<Integer, SecretWord> wordsReader() throws IOException{
        Map<Integer, SecretWord> wordsMap = new HashMap<>();
        int cont = 0;
        Stream<String> wordsAndTips = Files.lines(Paths.get(new File("").getAbsolutePath().concat("src/main/resources"), "wordsList.txt"));
        //INSTEAD OF 1, IT NEEDS TO USE THE CONT VARIABLE...
        wordsAndTips.map(string -> string.split(";", 2)).map(array  -> wordsMap.put(1, new SecretWord(array[0], array[1])));
        return wordsMap;
    }
}

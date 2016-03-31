package util;

import model.SecretWord;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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
        Integer cont = 0;
        Object[] wordsAndTips = Files.lines(Paths.get(new File("").getAbsolutePath().concat("/src/main/resources"), "wordsList.txt")).toArray();
        for (Object wordOrTip : wordsAndTips) {
            String[] parsedLine = ((String) wordOrTip).split(";", 2);
            wordsMap.put(cont++, new SecretWord(parsedLine[0].toUpperCase(), parsedLine[1].replace(";", "")));
        }
        return wordsMap;
    }
}

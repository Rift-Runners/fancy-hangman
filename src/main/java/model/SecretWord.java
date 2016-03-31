package model;

/**
 * Created by Guilherme on 30/03/2016.
 */
public class SecretWord {

    private String word, tip;

    public SecretWord(String word, String tip) {
        this.word = word;
        this.tip = tip;
    }

    public String getWord() {
        return word;
    }

    public String getTip() {
        return tip;
    }
}

package model;

/**
 * Created by Guilherme on 10/03/2016.
 */
public class Player {

    private String name;
    private int attempts;

    public Player(String name){
        this.name = name;
        this.attempts = 0;
    }

    public int getAttempts() {
        return attempts;
    }

    public String getName() {
        return name;
    }

    public void hasAttempted(){
        this.attempts++;
    }
}

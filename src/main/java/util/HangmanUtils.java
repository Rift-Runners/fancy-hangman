package util;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
        Random randomizer = new Random();
        return wordDictionary[randomizer.nextInt(wordDictionary.length)];
    }

    public String stringReader(Object o){
        System.out.println(o);
        Scanner s = new Scanner(System.in);
        return s.nextLine();
    }

    public void alertBox(String title, String message){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        Label label = new Label(message);
        Button closeBtn = new Button("Close");
        closeBtn.setOnAction(e -> window.close());


        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeBtn);
        layout.setAlignment(Pos.CENTER);

        window.setScene(new Scene(layout));
        window.showAndWait();
    }
}

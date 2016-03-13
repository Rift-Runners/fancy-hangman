package util;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by Guilherme on 13/03/2016.
 */
public class AlertBox {

    public void display(String title, String message){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);

        Label label = new Label(message);
        Button closeBtn = new Button("Close");
        closeBtn.setOnAction(e -> window.close());


        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));
        layout.getChildren().addAll(label, closeBtn);
        layout.setAlignment(Pos.CENTER);

        window.setScene(new Scene(layout));
        window.showAndWait();
    }
}

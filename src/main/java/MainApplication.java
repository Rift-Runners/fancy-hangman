import controller.GameController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Game;
import model.Player;
import util.HangmanUtils;
import view.GameView;

/**
 * Created by Guilherme on 12/03/2016.
 */
public class MainApplication extends Application{

    private final String LETTERS = "ABCDEFGHJIKLMNOPQRSTUVWXYZ";
    private Button[] letterBtns;
    private Stage window;
    private GameView gameView;

    public static void main(String[] args){
        launch(args);
    }

    public void controllerSetUp(){
        HangmanUtils hangmanUtils = new HangmanUtils();
        Player player = new Player(hangmanUtils.stringReader("Digite seu nome:"));
        Game game = new Game(hangmanUtils.randomWord(), player);
        GameController gameController = new GameController(game);
        this.gameView = new GameView(gameController);
    }

    public Scene initComponents(){
        //Player name line
        HBox playerNameLine = new HBox(5);
        Label playerLabel = new Label("Player:");
        Text player = new Text(gameView.getGameController().getGame().getPlayer().getName());
        playerNameLine.getChildren().addAll(playerLabel,player);

        //Letters Buttons lines
        HBox lettersLine = new HBox(10);
        letterBtns = new Button[26];
        for (int i = 0; i < LETTERS.length(); i++) {
            letterBtns[i] = new Button(LETTERS.substring(i,i+1));
            final String buttonText = letterBtns[i].getText();
            letterBtns[i].setOnAction(e -> System.out.println("My value is: "+buttonText));
        }
        lettersLine.getChildren().addAll(letterBtns);

        //Only tip button in the line, no need to put it in a hbox
        Button tip = new Button("Tip");

        //Column to order the lines (in order)
        VBox gameColumn = new VBox(20);
        gameColumn.getChildren().addAll(playerNameLine,lettersLine, tip);

        return new Scene(gameColumn, 600, 500);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        controllerSetUp();
        window = primaryStage;
        primaryStage.setTitle("Fancy Hangman");
        primaryStage.setScene(initComponents());
        primaryStage.show();
    }
}

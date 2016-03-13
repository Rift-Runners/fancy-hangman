import controller.GameController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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

    public Scene initMainLayout(){
        //Player name, used Letters and lives line
        HBox firstLine = new HBox(10);
        Label playerNameLabel = new Label("Player:");
        Label playerName = new Label(gameView.getGameController().getGame().getPlayer().getName());
        Label usedLettersLabel = new Label("Used Letters:");
        Label usedLetters = new Label(gameView.getGameController().getUsedLetters());
        Label playerLivesLabel = new Label("Lives:");
        Label playerLives = new Label(String.valueOf(gameView.getGameController().getGame().getPlayer().getAttempts()));
        firstLine.getChildren().addAll(playerNameLabel,playerName,usedLettersLabel,usedLetters,playerLivesLabel,playerLives);

        //Secret word line
        Label secretWord = new Label(gameView.getGameController().getExploreWord());

        //Letters Buttons lines
        HBox lettersLine = new HBox(10);
        letterBtns = new Button[26];
        for (int i = 0; i < LETTERS.length(); i++) {
            letterBtns[i] = new Button(LETTERS.substring(i,i+1));
            final String buttonText = letterBtns[i].getText();
            letterBtns[i].setOnAction(e -> gameView.getGameController().guessLetter(buttonText.charAt(0)));
        }
        lettersLine.getChildren().addAll(letterBtns);

        //Only tip button in the line, no need to put it in a hbox
        Button tip = new Button("Tip");

        //Column to order the lines (in order)
        VBox gameColumn = new VBox(20);
        gameColumn.getChildren().addAll(firstLine,secretWord,lettersLine, tip);
        gameColumn.setAlignment(Pos.CENTER);

        return new Scene(gameColumn, 600, 500);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        controllerSetUp();
        window = primaryStage;
        window.setScene(initMainLayout());
        window.setTitle("Fancy Hangman");
        window.show();
    }
}

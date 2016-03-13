import controller.GameController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Game;
import model.Player;
import util.HangmanUtils;
import view.GameView;

/**
 * Created by Guilherme on 12/03/2016.
 */
public class MainApplication extends Application implements EventHandler<ActionEvent> {

    private final String LETTERS = "ABCDEFGHJIKLMNOPQRSTUVWXYZ";
    private Button[] letterBtns;
    private Stage window;
    private GameView gameView;
    private Label playerName, usedLetters, playerLives, secretWord;
    private ImageView playerImage;

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
        playerName = new Label(gameView.getGameController().getGame().getPlayer().getName());
        Label usedLettersLabel = new Label("Used Letters:");
        usedLetters = new Label(gameView.getGameController().getUsedLetters());
        Label playerLivesLabel = new Label("Lives:");
        playerLives = new Label(String.valueOf(gameView.getGameController().getGame().getPlayer().getAttempts()));
        firstLine.getChildren().addAll(playerNameLabel,playerName,usedLettersLabel,usedLetters,playerLivesLabel,playerLives);

        //Secret word line
        secretWord = new Label(gameView.getGameController().getExploreWord());

        //Letters Buttons lines
        HBox lettersLine = new HBox(10);
        letterBtns = new Button[26];
        for (int i = 0; i < LETTERS.length(); i++) {
            letterBtns[i] = new Button(LETTERS.substring(i,i+1));
            letterBtns[i].setOnAction(this);
        }
        lettersLine.getChildren().addAll(letterBtns);

        //Only tip button in the line, no need to put it in a hbox
        Button tip = new Button("Tip");
        //Only image in the line, no need to put it in a hbox

        playerImage = new ImageView(new Image("images/0-6.png"));

        //Column to order the lines (in order)
        VBox gameColumn = new VBox(20);
        gameColumn.getChildren().addAll(firstLine, secretWord, lettersLine, tip, playerImage);
        gameColumn.setAlignment(Pos.CENTER);

        return new Scene(gameColumn, 900, 600);
    }
    public void imageUpdate(){
        switch(gameView.getGameController().getGame().getPlayer().getAttempts()){
            case 1:
                playerImage.setImage(new Image("images/1-6.png"));
                break;
            case 2:
                playerImage.setImage(new Image("images/2-6.png"));
                break;
            case 3:
                playerImage.setImage(new Image("images/3-6.png"));
                break;
            case 4:
                playerImage.setImage(new Image("images/4-6.png"));
                break;
            case 5:
                playerImage.setImage(new Image("images/5-6.png"));
                break;
            case 6:
                playerImage.setImage(new Image("images/6-6.png"));
                break;
        }
    }

    public void turnComponentsUpdate(){
        secretWord.setText(gameView.getGameController().getExploreWord());
        playerName.setText(gameView.getGameController().getGame().getPlayer().getName());
        usedLetters.setText(gameView.getGameController().getUsedLetters());
        playerLives.setText(String.valueOf(gameView.getGameController().getGame().getPlayer().getAttempts()));
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        controllerSetUp();
        window = primaryStage;
        window.setScene(initMainLayout());
        window.setTitle("Fancy Hangman");
        window.show();
    }

    @Override
    public void handle(ActionEvent event) {
        Button clickedLetter = (Button)event.getSource();
        if(gameView.getGameController().isRunning()) {
            gameView.getGameController().guessLetter(clickedLetter.getText().charAt(0));
            turnComponentsUpdate();
            imageUpdate();
            gameView.guessTurn();
        } else {
            HangmanUtils hangmanUtils = new HangmanUtils();
            hangmanUtils.alertBox("Game over", "Please, restart the application.");
        }
    }
}

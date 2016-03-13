import controller.GameController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Game;
import model.Player;
import util.ConfirmBox;
import util.HangmanUtils;
import util.InputBox;
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
        Game game = new Game(new HangmanUtils().randomWord(), playerSetUp());
        GameController gameController = new GameController(game);
        this.gameView = new GameView(gameController);
    }

    public Player playerSetUp() {
        String name = new InputBox().display("Nome", "Digite seu nome:");
        System.out.println(name+":name");
        while (name.equals("")){
            name = new InputBox().display("Nome", "Digite seu nome:");
        }
        return new Player(name);
    }

    public Scene initMainLayout(){
        //Player name, used Letters and lives top layout
        HBox topLayout = new HBox(10);
        Label playerNameLabel = new Label("Player:");
        playerName = new Label(gameView.getGameController().getGame().getPlayer().getName());
        Label usedLettersLabel = new Label("|   Used Letters:");
        usedLetters = new Label(gameView.getGameController().getUsedLetters());
        Label playerLivesLabel = new Label("|   Lives:");
        playerLives = new Label(String.valueOf(gameView.getGameController().getGame().getPlayer().getAttempts()));
        topLayout.getChildren().addAll(playerNameLabel,playerName,usedLettersLabel,usedLetters,playerLivesLabel,playerLives);

        //Secret word, lettersButtons, tip center layout
        VBox centerLayout = new VBox(20);
        secretWord = new Label(gameView.getGameController().getExploreWord());

        //Letters Buttons
        HBox lettersLine1 = new HBox(10);
        HBox lettersLine2 = new HBox(10);
        HBox lettersLine3 = new HBox(10);
        letterBtns = new Button[26];
        for (int i = 0; i < LETTERS.length(); i++) {
            letterBtns[i] = new Button(LETTERS.substring(i,i+1));
            letterBtns[i].setOnAction(this);
            if(i<9){
                lettersLine1.getChildren().add(letterBtns[i]);
            } else if(i<18){
                lettersLine2.getChildren().add(letterBtns[i]);
            } else{
                lettersLine3.getChildren().add(letterBtns[i]);
            }
        }
        Button tip = new Button("Tip");
        centerLayout.getChildren().addAll(secretWord, lettersLine1,lettersLine2,lettersLine3, tip);
        centerLayout.setAlignment(Pos.CENTER);

        //Only image in the left layout, no need to put it in a hbox
        playerImage = new ImageView(new Image("images/0-6.png"));

        //Main layout
        BorderPane mainLayout = new BorderPane();
        mainLayout.setPadding(new Insets(20));
        mainLayout.setTop(topLayout);
        mainLayout.setCenter(centerLayout);
        mainLayout.setRight(playerImage);

        return new Scene(mainLayout, 750, 500);
    }

    public void imageUpdate(){
        switch(gameView.getGameController().getGame().getPlayer().getAttempts()){
            case 0:
                playerImage.setImage(new Image("images/0-6.png"));
                break;
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

    public void restartGame(){
        controllerSetUp();
        turnComponentsUpdate();
        imageUpdate();
    }

    public void closeProgram(){
        if(new ConfirmBox().display("Close Game", "Do you really want to close the game?")){
            window.close();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        controllerSetUp();
        window = primaryStage;
        window.setScene(initMainLayout());
        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });
        window.setResizable(false);
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
            if(new ConfirmBox().display("Game is over", "Want to start a new game?")){
                restartGame();
            }
        }
    }
}

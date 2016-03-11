import controller.GameController;
import model.Game;
import model.Player;
import util.HangmanUtils;
import view.GameView;

/**
 * Created by Guilherme on 11/03/2016.
 */
public class MainApplication {
    
    public static void main(String[] args){
        HangmanUtils hangmanUtils = new HangmanUtils();
        Player player = new Player(hangmanUtils.stringReader("Digite seu nome:"));
        Game game = new Game(hangmanUtils.randomWord(), player);
        GameController gameController = new GameController(game);
        GameView gameView = new GameView(gameController);
        gameView.playGame();
    }
}

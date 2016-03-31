package unittest.view;

import controller.GameController;
import model.Game;
import model.Player;
import model.SecretWord;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import view.GameView;

import static org.junit.Assert.*;

public class GameViewUnitTest {

    public GameView gameView;

    @Before
    public void setUp(){
        GameController gameController = new GameController(new Game(new SecretWord("APPLE", "red colored and round-shaped fruit"),new Player("William")));
        this.gameView = new GameView(gameController);
    }

    @Test
    public void testGameViewExists(){
        assertNotNull(gameView);
    }

    @Test
    public void testGameViewHasAGameController(){
        assertNotNull(gameView.getGameController());
    }

    @After
    public void tearDown(){
        this.gameView = null;
        assertNull(gameView);
    }
}

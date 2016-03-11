package unittest.view;

import controller.GameController;
import model.Game;
import model.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import view.GameView;

import static org.junit.Assert.*;

public class GameViewUnitTest {

    public GameView gameView;

    @Before
    public void setUp(){
        GameController gameController = new GameController(new Game("APPLE",new Player("William")));
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

    @Test
    public void test(){

    }

    @After
    public void tearDown(){
        this.gameView = null;
        assertNull(gameView);
    }
}

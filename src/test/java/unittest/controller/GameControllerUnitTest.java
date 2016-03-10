package unittest.controller;

import controller.GameController;
import model.Game;
import model.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameControllerUnitTest {

    private GameController gameController;

    @Before
    public void setUp(){
        Player player = new Player("William");
        Game game = new Game("Apple", player);
        this.gameController = new GameController(game);
    }

    @Test
    public void testGameControllerExists(){
        assertNotNull(gameController);
    }

    @Test
    public void testGameControllerHasAGame(){
        assertNotNull(gameController.getGame());
    }

    @After
    public void tearDown(){
        this.gameController = null;
        assertNull(gameController);
    }


}

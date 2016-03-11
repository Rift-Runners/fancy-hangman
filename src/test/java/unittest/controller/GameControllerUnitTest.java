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
        Game game = new Game("APPLE", player);
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

    @Test
    public void testGameControllerHasAExploreWord(){
        assertNotNull(gameController.getExploreWord());
    }

    @Test
    public void testGameHasUsedLetters(){
        gameController.guessLetter('Z');
        assertEquals("Z ", gameController.getUsedLetters());
    }

    @Test
    public void testGameHasNotUsedLetters(){
        gameController.guessLetter('A');
        assertEquals("", gameController.getUsedLetters());
    }

    @Test
    public void testGameBuiltExploreWord(){
        assertEquals("_____", gameController.getExploreWord());
    }

    @Test
    public void testGameRevealedLetter(){
        gameController.guessLetter('E');
        assertEquals("____E",gameController.getExploreWord());
    }

    @After
    public void tearDown(){
        this.gameController = null;
        assertNull(gameController);
    }
}

package unittest.controller;

import controller.GameController;
import model.Game;
import model.Player;
import model.SecretWord;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameControllerUnitTest {

    private GameController gameController;

    @Before
    public void setUp(){
        Game game = new Game(new SecretWord("apple", "apple tip"), new Player("William"));
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
    public void testRepeatUsedLetter(){
        gameController.guessLetter('Z');
        gameController.guessLetter('Z');
        assertEquals("Z ", gameController.getUsedLetters());
    }

    @Test
    public void testPlayerIsAlive(){
        gameController.getGame().getPlayer().hasAttempted();
        assertFalse(gameController.playerIsDead());
    }

    @Test
    public void testPlayerIsDead(){
        for (int i = 0; i < 6; i++) {
            gameController.getGame().getPlayer().hasAttempted();
        }
        assertTrue(gameController.playerIsDead());
    }

    @Test
    public void testPlayerNotAWinner(){
        assertFalse(gameController.playerIsWinner());
    }

    @Test
    public void testPlayerHasWon(){
        gameController.guessLetter('A');
        gameController.guessLetter('P');
        gameController.guessLetter('L');
        gameController.guessLetter('E');
        assertTrue(gameController.playerIsWinner());
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

    @Test
    public void testGameIsRunning(){
        assertTrue(gameController.isRunning());
    }

    @Test
    public void testGameStoppedRunning(){
        gameController.stopRunning();
        assertFalse(gameController.isRunning());
    }

    @After
    public void tearDown(){
        this.gameController = null;
        assertNull(gameController);
    }
}

package unittest.model;

import model.Game;
import model.Player;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Guilherme on 10/03/2016.
 */
public class GameUnitTest {

    private Game game;

    @Before
    public void setUp(){
        this.game = new Game("Apple",new Player("William"));
    }

    @Test
    public void testGameHasAPlayer(){
        assertNotNull(game.getPlayer());
    }

    @Test
    public void testGameHasASecretWord(){
        assertEquals("Apple", game.getSecretWord());
    }

    @Test
    public void testGameIsRunning(){
        assertEquals(true, game.isRunning());
    }

    @After
    public void tearDown(){
        game = null;
        assertNull(game);
    }
}

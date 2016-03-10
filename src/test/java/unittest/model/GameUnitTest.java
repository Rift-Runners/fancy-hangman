package unittest.model;

import model.Game;
import model.Player;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameUnitTest {

    private Game game;

    @Before
    public void setUp(){
        this.game = new Game("APPLE", new Player("William"));
    }

    @Test
    public void testGameExists(){
        assertNotNull(game);
    }

    @Test
    public void testGameHasAPlayer(){
        assertNotNull(game.getPlayer());
    }

    @Test
    public void testGameHasASecretWord(){
        assertEquals("APPLE", game.getSecretWord());
    }

    @After
    public void tearDown(){
        this.game = null;
        assertNull(game);
    }
}

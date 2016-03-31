package unittest.model;

import model.Game;
import model.Player;
import model.SecretWord;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameUnitTest {

    private Game game;

    @Before
    public void setUp() {
        this.game = new Game(new SecretWord("APPLE", "red colored and round-shaped fruit"), new Player("William"));
    }

    @Test
    public void testGameExists() {
        assertNotNull(game);
    }

    @Test
    public void testGameHasAPlayer() {
        assertNotNull(game.getPlayer());
    }

    @Test
    public void testGameSecretWordHasAWord() {
        assertNotNull(game.getSecretWord().getWord());
    }

    @Test
    public void testGameSecretWordHasAWordTip() {
        assertNotNull(game.getSecretWord().getTip());
    }

    @Test
    public void testGameSecretWordHasTheRightWord() {
        assertEquals("APPLE", game.getSecretWord().getWord());
    }

    @Test
    public void testGameSecretWordHasTheRightWordTip() {
        assertEquals("red colored and round-shaped fruit", game.getSecretWord().getTip());
    }

    @After
    public void tearDown() {
        this.game = null;
        assertNull(game);
    }
}

package unittest.model;

import model.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerUnitTest {

    private Player player;

    @Before
    public void setUp(){
        player = new Player("William");
    }

    @Test
    public void testPlayerExists(){
        assertNotNull(player);
    }

    @Test
    public void testPlayerHasAName(){
        assertEquals("William", player.getName());
    }

    @Test
    public void testPlayerHasAttempts(){
        player.hasAttempted();
        assertEquals(1, player.getAttempts());
    }


}

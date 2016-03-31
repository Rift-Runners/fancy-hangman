package unittest.model;

import model.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerUnitTest {

    private Player player;

    @Before
    public void setUp(){
        this.player = new Player("William");
    }

    @Test
    public void testPlayerExists(){
        assertNotNull(player);
    }

    @Test
    public void testPlayerHasAName(){
        assertNotNull(player.getName());
    }
    
    @Test
    public void testPlayerHasTheRightName(){
        assertEquals("William", player.getName());
    }

    @Test
    public void testPlayerHasAttempts(){
        player.hasAttempted();
        assertEquals(1, player.getAttempts());
    }

    @After
    public void tearDown(){
        this.player = null;
        assertNull(player);
    }
}

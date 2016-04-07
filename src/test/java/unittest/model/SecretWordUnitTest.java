package unittest.model;

import model.SecretWord;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SecretWordUnitTest {

    private SecretWord secretWord;

    @Before
    public void setUp() {
        this.secretWord = new SecretWord("APPLE", "red colored and round-shaped fruit");
    }

    @Test
    public void testSecretWordExists() {
        assertNotNull(secretWord);
    }

    @Test
    public void testSecretWordHasAWord() {
        assertNotNull(secretWord.getWord());
    }

    @Test
    public void testSecretWordHasATip() {
        assertNotNull(secretWord.getTip());
    }

    @Test
    public void testPlayerHasTheRightWord() {
        assertEquals("APPLE", secretWord.getWord());
    }

    @Test
    public void testPlayerHasTheRightTip() {
        assertEquals("red colored and round-shaped fruit", secretWord.getTip());
    }

    @After
    public void tearDown() {
        this.secretWord = null;
        assertNull(secretWord);
    }
}

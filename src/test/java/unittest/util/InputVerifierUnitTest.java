package unittest.util;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import util.InputVerifier;

public class InputVerifierUnitTest {

    private InputVerifier inputVerifier;

    @Before
    public void setUp(){
        this.inputVerifier = new InputVerifier();
    }

    @Test
    public void testInputVerifierExists(){
        assertNotNull(this.inputVerifier);
    }

    @Test
    public void testInputIsValid(){
        assertEquals(true, inputVerifier.isAValidLetter('A'));
    }

    @After
    public void tearDown(){
        this.inputVerifier = null;
        assertNull(inputVerifier);
    }
}

package sheridan.runze.assignment1.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordBlockLogicTest {

    @Test
    void validWordShouldPass() {
        assertTrue(WordBlockLogic.isValid("Hello"));
    }

    @Test
    void tooLongWordShouldFail() {
        assertFalse(WordBlockLogic.isValid("ABCDEFGHIJK"));
    }
}

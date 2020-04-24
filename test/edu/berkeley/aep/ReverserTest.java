package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverserTest {
    @Test
    public void abcdeShouldReverseToedcba() {
        Reverser term = new Reverser("abcde");
        assertEquals(term.reverse(), "edcba");
    }

    @Test
    public void nullStringShouldReturnNullString(){
        Reverser term = new Reverser("");
        assertEquals(term.reverse(), "");
    }
}

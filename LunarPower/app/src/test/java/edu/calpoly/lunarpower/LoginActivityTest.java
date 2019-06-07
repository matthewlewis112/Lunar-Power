package edu.calpoly.lunarpower;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoginActivityTest {
    @Test
    public void testParentClass() {
        assertEquals(new LoginActivity().getClass(), LoginActivity.class);
    }

    @Test
    public void testToString(){
        assertEquals("LoginActivity", new LoginActivity().toString());
    }
}

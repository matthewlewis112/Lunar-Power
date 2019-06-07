package edu.calpoly.lunarpower;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SplashActivityTest {
    @Test
    public void testParentClass() {
        assertEquals(new SplashActivity().getClass(), SplashActivity.class);
    }

    @Test
    public void testToString(){
        assertEquals("SplashActivity", new SplashActivity().toString());
    }
}

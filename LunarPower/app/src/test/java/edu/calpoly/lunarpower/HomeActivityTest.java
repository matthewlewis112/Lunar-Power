package edu.calpoly.lunarpower;

import android.content.Context;

import org.junit.Test;

import java.util.LinkedList;

import edu.calpoly.lunarpower.model.DevicesDO;

import static org.junit.Assert.assertEquals;

public class HomeActivityTest {
    @Test
    public void testParentClass() {
        assertEquals(new HomeActivity().getClass(), HomeActivity.class);
    }

    @Test
    public void testToString(){
        assertEquals("HomeActivity", new HomeActivity().toString());
    }
}

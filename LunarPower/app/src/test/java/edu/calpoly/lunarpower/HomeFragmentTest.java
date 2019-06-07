package edu.calpoly.lunarpower;

import android.support.v4.app.Fragment;
import android.widget.LinearLayout;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HomeFragmentTest {
    @Test
    public void testParentClass() {
        assertEquals(new HomeFragment().getClass(), HomeFragment.class);
    }

    @Test
    public void testToString(){
        assertEquals("HomeFragment", new HomeFragment().toString());
    }
}

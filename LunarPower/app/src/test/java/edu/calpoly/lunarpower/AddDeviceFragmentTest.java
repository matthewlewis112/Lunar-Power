package edu.calpoly.lunarpower;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddDeviceFragmentTest {
    @Test
    public void testParentClass() {
        assertEquals(new AddDeviceFragment().getClass(), AddDeviceFragment.class);
    }

    @Test
    public void testToString(){
        assertEquals("AddDeviceFragment", new AddDeviceFragment().toString());
    }
}

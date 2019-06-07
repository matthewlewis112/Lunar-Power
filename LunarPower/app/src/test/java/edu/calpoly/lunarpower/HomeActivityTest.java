package edu.calpoly.lunarpower;

import android.content.Context;

import org.junit.Test;

import java.util.LinkedList;

import edu.calpoly.lunarpower.model.DevicesDO;

import static org.junit.Assert.assertEquals;

public class HomeActivityTest {
    private static final String packageName = "edu.calpoly.lunarpower";
    @Test
    public void testPackage() {
        Context appContext = new HomeActivity();
        assertEquals(packageName, appContext.getPackageName());

    }
    @Test
    public void testGetDevices() {
        assertEquals(new LinkedList<DevicesDO>(), new HomeActivity().getDevices());
    }
    @Test
    public void testParentClass() {
        assertEquals(new HomeActivity().getClass(), HomeActivity.class);
    }
    @Test
    public void testFragment() {
        assertEquals(new HomeActivity().getDevices().size(), 0);
    }



}

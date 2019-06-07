package edu.calpoly.lunarpower;

import android.content.Context;
import android.support.test.runner.AndroidJUnit4;
import android.support.v4.app.Fragment;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class HomeActivityTester {
    private static final String packageName = "edu.calpoly.lunarpower";
    @Test
    public void testHomeActivity(){
        Context appContext = new HomeActivity();
        Assert.assertEquals(packageName, appContext.getPackageName());
    }
    @Test
    public void testHomeFragment(){
        Fragment fragment= new HomeFragment();
        Assert.assertEquals(packageName, fragment.getActivity().getPackageName());
    }
    @Test
    public void testDeviceFragment(){
        Fragment fragment= new DeviceFragment();
        Assert.assertEquals(packageName, fragment.getActivity().getPackageName());
    }
    @Test
    public void testSettingsFragment(){
        Fragment fragment = new SettingsFragment();
        Assert.assertEquals(packageName, fragment.getActivity().getPackageName());
    }
}

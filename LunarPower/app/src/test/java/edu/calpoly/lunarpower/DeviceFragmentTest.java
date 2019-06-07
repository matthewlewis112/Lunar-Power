package edu.calpoly.lunarpower;

import android.support.v4.app.Fragment;
import android.widget.LinearLayout;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeviceFragmentTest {
    private static final String packageName = "edu.calpoly.lunarpower";
    @Test
    public void testPackage() {
        Fragment appFragment = new DeviceFragment();
        assertEquals(packageName, appFragment.getActivity().getPackageName());

    }
    @Test
    public void testLayout() {
        assertEquals(new DeviceFragment().getLayoutInflater().getClass(), LinearLayout.class);
    }
    @Test
    public void testParentClass() {
        assertEquals(new DeviceFragment().getClass(), DeviceFragment.class);
    }
    @Test
    public void testFragment() {
        assertEquals(new HomeActivity().getDevices().size(), 0);
    }



}

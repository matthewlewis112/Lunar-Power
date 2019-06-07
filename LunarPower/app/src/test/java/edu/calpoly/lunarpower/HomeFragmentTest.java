package edu.calpoly.lunarpower;

import android.support.v4.app.Fragment;
import android.widget.LinearLayout;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HomeFragmentTest {
    private static final String packageName = "edu.calpoly.lunarpower";
    @Test
    public void testPackage() {
        Fragment appFragment = new HomeFragment();
        assertEquals(packageName, appFragment.getActivity().getPackageName());

    }
    @Test
    public void testLayout() {
        assertEquals(new HomeFragment().getLayoutInflater().getClass(), LinearLayout.class);
    }
    @Test
    public void testParentClass() {
        assertEquals(new HomeFragment().getClass(), HomeFragment.class);
    }
}

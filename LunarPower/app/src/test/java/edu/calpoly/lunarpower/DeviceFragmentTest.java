package edu.calpoly.lunarpower;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.LinearLayout;

import org.junit.Test;

import java.util.LinkedList;

import edu.calpoly.lunarpower.model.DevicesDO;

import static org.junit.Assert.assertEquals;

public class DeviceFragmentTest {
   @Test
    public void testParentClass() {
        assertEquals(new DeviceFragment().getClass(), DeviceFragment.class);
    }



}

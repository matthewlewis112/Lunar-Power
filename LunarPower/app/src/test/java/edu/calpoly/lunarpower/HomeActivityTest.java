package edu.calpoly.lunarpower;

import android.app.Activity;
import android.content.Context;
import android.view.View;

import org.junit.Test;

import java.util.LinkedList;

import edu.calpoly.lunarpower.model.DevicesDO;
import edu.calpoly.lunarpower.model.TasksDO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class HomeActivityTest {
    @Test
    public void testParentClass() {
        assertEquals(new HomeActivity().getClass(), HomeActivity.class);
    }
}

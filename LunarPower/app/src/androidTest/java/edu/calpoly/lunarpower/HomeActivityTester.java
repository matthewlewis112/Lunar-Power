package edu.calpoly.lunarpower;

import android.content.Context;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class HomeActivityTester {
    @Test
    public void testHomeFragment(){
        Context appContext = new HomeActivity();
        Assert.assertEquals("edu.calpoly.lunarpower", appContext.getPackageName());
    }
}

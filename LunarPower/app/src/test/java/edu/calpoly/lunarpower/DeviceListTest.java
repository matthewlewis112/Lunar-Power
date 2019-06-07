package edu.calpoly.lunarpower;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import edu.calpoly.lunarpower.model.DeviceListDO;

import static org.junit.Assert.assertEquals;

public class DeviceListTest {
    @Test
    public void testLoopRunningNever() {
        DeviceListDO list = new DeviceListDO();
        list.setDevices(new ArrayList<String>());
        assertEquals("", list.toString());
    }
    
    @Test
    public void testLoopRunningOnce() {
        DeviceListDO list = new DeviceListDO();
        list.setDevices(Arrays.asList("test"));
        assertEquals("test\n", list.toString());
    }
    
    @Test
    public void testLoopRunningTwice() {
        DeviceListDO list = new DeviceListDO();
        list.setDevices(Arrays.asList("test1", "test2"));
        assertEquals("test1\ntest2\n", list.toString());
    }
    
    @Test
    public void testLoopRunningUsual() {
        DeviceListDO list = new DeviceListDO();
        list.setDevices(Arrays.asList("test1", "test2","test3", "test4","test5", "test6","test7", "test8","test9", "test10","test11", "test12"));
        assertEquals("test1\ntest2\ntest3\ntest4\ntest5\ntest6\ntest7\ntest8\ntest9\ntest10\ntest11\ntest12\n", list.toString());
    }



}

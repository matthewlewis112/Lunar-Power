package edu.calpoly.lunarpower;

import org.junit.Test;

import static org.junit.Assert.*;
import edu.calpoly.lunarpower.model.DevicesDO;

public class DeviceTest {
    @Test
    public void testSetUserId() {
        DevicesDO devicesDO = new DevicesDO();
        devicesDO.setUserId("test");
        assertEquals("test", devicesDO.getUserId());
    }
    @Test
    public void testSetName() {
        DevicesDO devicesDO = new DevicesDO();
        devicesDO.setName("test");
        assertEquals("test", devicesDO.getName());
    }
    @Test
    public void testGetUserIdNull() {
        DevicesDO devicesDO = new DevicesDO();
        assertNull(devicesDO.getUserId());
    }
    @Test
    public void testGetNameNull() {
        DevicesDO devicesDO = new DevicesDO();
        assertNull(devicesDO.getName());
    }



}

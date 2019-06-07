package edu.calpoly.lunarpower;

import org.junit.Test;

import edu.calpoly.lunarpower.model.DevicesDO;
import edu.calpoly.lunarpower.model.TasksDO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TaskTest {
    @Test
    public void testSetUserId() {
        TasksDO tasksDO = new TasksDO();
        tasksDO.setUserId("test");
        assertEquals("test", tasksDO.getUserId());
    }
    @Test
    public void testSetName() {
        TasksDO tasksDO = new TasksDO();
        tasksDO.setName("test");
        assertEquals("test", tasksDO.getName());
    }
    @Test
    public void testGetUserIdNull() {
        TasksDO tasksDO = new TasksDO();
        assertNull(tasksDO.getUserId());
    }
    @Test
    public void testGetNameNull() {
        TasksDO tasksDO = new TasksDO();
        assertNull(tasksDO.getName());
    }



}

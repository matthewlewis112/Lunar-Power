package edu.calpoly.lunarpower.model;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

import java.util.Set;

@DynamoDBTable(tableName = "lunarpower-mobilehub-627565767-Tasks")

public class TasksDO {
    private String userId;
    private Set<Double> deviceID;
    private String name;
    private Double taskID;

    @DynamoDBHashKey(attributeName = "userId")
    @DynamoDBAttribute(attributeName = "userId")
    public String getUserId() {
        return userId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }
    @DynamoDBAttribute(attributeName = "DeviceID")
    public Set<Double> getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(final Set<Double> deviceID) {
        this.deviceID = deviceID;
    }
    @DynamoDBAttribute(attributeName = "Name")
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
    @DynamoDBAttribute(attributeName = "TaskID")
    public Double getTaskID() {
        return taskID;
    }

    public void setTaskID(final Double taskID) {
        this.taskID = taskID;
    }

}

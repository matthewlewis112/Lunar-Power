package edu.calpoly.lunarpower.model;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

import java.util.Set;

@DynamoDBTable(tableName = "lunarpower-mobilehub-627565767-Tasks")

public class TasksDO {
    private String _userId;
    private Set<Double> _deviceID;
    private String _name;
    private Double _taskID;

    @DynamoDBHashKey(attributeName = "userId")
    @DynamoDBAttribute(attributeName = "userId")
    public String getUserId() {
        return _userId;
    }

    public void setUserId(final String _userId) {
        this._userId = _userId;
    }
    @DynamoDBAttribute(attributeName = "DeviceID")
    public Set<Double> getDeviceID() {
        return _deviceID;
    }

    public void setDeviceID(final Set<Double> _deviceID) {
        this._deviceID = _deviceID;
    }
    @DynamoDBAttribute(attributeName = "Name")
    public String getName() {
        return _name;
    }

    public void setName(final String _name) {
        this._name = _name;
    }
    @DynamoDBAttribute(attributeName = "TaskID")
    public Double getTaskID() {
        return _taskID;
    }

    public void setTaskID(final Double _taskID) {
        this._taskID = _taskID;
    }

}

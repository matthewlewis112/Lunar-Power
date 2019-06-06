package edu.calpoly.lunarpower.model;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

import java.util.List;

@DynamoDBTable(tableName = "lunarpower-mobilehub-627565767-DeviceList")

public class DeviceListDO {
    private String _userId;
    private List<String> _devices;

    @DynamoDBHashKey(attributeName = "userId")
    @DynamoDBAttribute(attributeName = "userId")
    public String getUserId() {
        return _userId;
    }

    public void setUserId(final String _userId) {
        this._userId = _userId;
    }
    @DynamoDBAttribute(attributeName = "Devices")
    public List<String> getDevices() {
        return _devices;
    }

    public void setDevices(final List<String> _devices) {
        this._devices = _devices;
    }

}

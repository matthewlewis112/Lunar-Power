package edu.calpoly.lunarpower.model;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

import java.util.List;

@DynamoDBTable(tableName = "lunarpower-mobilehub-627565767-DeviceList")

public class DeviceListDO {
    private String userId;
    private List<String> devices;

    @DynamoDBHashKey(attributeName = "userId")
    @DynamoDBAttribute(attributeName = "userId")
    public String getUserId() {
        return userId;
    }

    public void setUserId(final String _userId) {
        this.userId = _userId;
    }
    @DynamoDBAttribute(attributeName = "Devices")
    public List<String> getDevices() {
        return devices;
    }

    public void setDevices(final List<String> devices) {
        this.devices = devices;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(devices != null) {
            int index = 0;
            while (index < devices.size()) {
                sb.append(devices.get(index)).append("\n");
                index++;
            }
        }
        return sb.toString();
    }

}

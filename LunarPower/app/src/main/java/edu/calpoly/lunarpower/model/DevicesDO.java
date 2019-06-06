package edu.calpoly.lunarpower.model;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBHashKey;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;

@DynamoDBTable(tableName = "lunarpower-mobilehub-627565767-Devices")

public class DevicesDO {
    private String userId;
    private Double iD;
    private String name;

    @DynamoDBHashKey(attributeName = "userId")
    @DynamoDBAttribute(attributeName = "userId")
    public String getUserId() {
        return userId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }
    @DynamoDBAttribute(attributeName = "ID")
    public Double getID() {
        return iD;
    }

    public void setID(final Double iD) {
        this.iD = iD;
    }
    @DynamoDBAttribute(attributeName = "Name")
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

}
